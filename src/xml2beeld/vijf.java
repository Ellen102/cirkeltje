package xml2beeld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import lezen.Building;
import lezen.Item;
import lezen.Person;
import lezen.World;


/**
 *
 * @author Sebastiaan
 */
public class vijf extends Application {
    
    private double x;
    private double y;
    private static Rectangle rectangle;

    private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Person> circles = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    
    static {
        dX = new HashMap<>();
        dY = new HashMap<>();
        
        dX.put(KeyCode.RIGHT, OFFSET);
        dY.put(KeyCode.RIGHT, 0.0);
        
        dX.put(KeyCode.LEFT, -OFFSET);
        dY.put(KeyCode.LEFT, 0.0);
        
        dX.put(KeyCode.UP, 0.0);
        dY.put(KeyCode.UP, -OFFSET);
        
        dX.put(KeyCode.DOWN, 0.0);
        dY.put(KeyCode.DOWN, OFFSET);
    }
    
    private final Group root = new Group();
    @Override
    public void start(Stage primaryStage) throws JAXBException {
        primaryStage.setTitle("Game Engine Test");
        

        primaryStage.setScene(new Scene(root));
        
/*
 * lees
 * 
 */
        JAXBContext jc = JAXBContext.newInstance(World.class);
        World ls = (World) jc.createUnmarshaller().unmarshal(vijf.class.getResource("Wereld.xml"));
        
        for(Building b : ls.getBuildings()){
            Shape shape = b.getShape();
            rectangles.add((Rectangle) shape);
            root.getChildren().add(shape);
        }
        
        for(Item b : ls.getItems()){
            Shape shape = b.getShape();
            items.add(b);
            root.getChildren().add(shape);
        }
        
        for(Person b : ls.getPersons()){
            Shape shape = b.getShape();
            circles.add(b);
            root.getChildren().add(shape);
        }
        
        initSquare(root); //naar voorgrond zetten (opzoeken altijd ofzo)
        
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
 
                
                if(dX.get(t.getCode()) != null){
                    double nx = x;
                    double ny = y;
                    nx += dX.get(t.getCode());
                    ny += dY.get(t.getCode());
                    
                    
                    if (!pointCollides(nx, ny)){
                        x = nx;
                        y = ny;
                    }
                
                    updateGraphics();
                }else if(t.getCode() == KeyCode.SPACE){
                    Person p = onCircle(x, y);
                    if(p !=null){
                        System.out.println(p.getName()+" : "+ p.getZin());
                    }else{
                        Item i = onItem(x ,y);
                        if(i != null){
                            System.out.println("je vond " + i.getName());
                            verwijder(i);
                        }
                    
                    }
                }
                
                
            }
            
        });
        
        updateGraphics();
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
    private void initSquare(Group root) {
        double width = 5.0;
        double height = 10.0;
        rectangle = new Rectangle(width, height);
        x = 20;
        y = 20;
        rectangle.setFill(Color.YELLOW);
        root.getChildren().add(rectangle);
        rectangle.toFront();
    }

    
    private void updateGraphics(){
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
    }
    
    private boolean pointCollides(double x, double y){
        
        for (Rectangle rect : rectangles){
            if (x <= rect.getX()+rect.getWidth() && x >= rect.getX() 
                    && y <= rect.getY()+rect.getHeight() && y >= rect.getY()){
                return true;
            }
        }
        
        return false;
        
    }

    private Person onCircle(double nx, double ny){
        for (Person p : circles){
            Circle c = (Circle) p.getShape();
            if(c.getCenterX()+2*c.getRadius()>nx && c.getCenterX()-2*c.getRadius()<nx
                    &&
               c.getCenterY()+2*c.getRadius()>ny && c.getCenterY()-2*c.getRadius()<ny 
                    ){
                return p;
            }
        }
        return null;
    }
    
    private Item onItem(double nx, double ny){
        for (Item i : items){
            Rectangle s = (Rectangle) i.getShape();
            if(s.getX()== nx
                    &&
               s.getY() == ny
                    ){
                return i;
            }
        }
        return null;
    }
    
    
    private void verwijder(Item i){
        root.getChildren().remove(i.getShape());
        items.remove(i);
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}
