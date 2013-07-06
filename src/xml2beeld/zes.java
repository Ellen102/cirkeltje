package xml2beeld;

import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;
import lezen.Building;
import lezen.Item;
import lezen.Person;
import mvc1.Model;


/**
 *
 * @author Sebastiaan
 */
public class zes extends Application {
    
    private double x;
    private double y;

    private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private Model model;

    
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
         * lijst vn componenten
         * 
         * falsspelen met root ...
         */
        model = new Model(root);
        
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
                            model.verwijder(i);
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


    
    private void updateGraphics(){
        model.verplaats(x, y);
    }
    
    private boolean pointCollides(double x, double y){
        
        for (Building b : model.getBuildings()){
            Rectangle rect = (Rectangle) b.getShape();
            if (x <= rect.getX()+rect.getWidth() && x >= rect.getX() 
                    && y <= rect.getY()+rect.getHeight() && y >= rect.getY()){
                return true;
            }
        }
        
        return false;
        
    }

    private Person onCircle(double nx, double ny){
        for (Person p : model.getPersons()){
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
        for (Item i : model.getItems()){
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
