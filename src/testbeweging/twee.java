package testbeweging;




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
import javafx.stage.Stage;

/**
 *
 * @author Sebastiaan
 */
public class twee extends Application {
    
    private double x;
    private double y;
    private static Rectangle rectangle;

    private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();
    
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
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Engine Test");
        Group root = new Group();
        

        primaryStage.setScene(new Scene(root));
        
        /*
         * Test code
         */
        rectangles.add(new Rectangle(40, 100, 50, 200));
        rectangles.add(new Rectangle(300,200,420,230));
        
        for (Rectangle rect : rectangles){
            rect.setFill(Color.GRAY);
            root.getChildren().add(rect);
        }
        
        circles.add(new Circle(50,50,10, Color.BLUE));
        circles.add(new Circle(150,200,10, Color.BLUE));

        
        for (Circle c : circles){
            root.getChildren().add(c);
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
                    if(onCircle(x, y)){
                        System.out.println("spatie");
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

    private boolean onCircle(double nx, double ny){
        for (Circle c : circles){
            if(c.getCenterX()+2*c.getRadius()>nx && c.getCenterX()-2*c.getRadius()<nx
                    &&
               c.getCenterY()+2*c.getRadius()>ny && c.getCenterY()-2*c.getRadius()<ny 
                    ){
                return true;
            }
        }
        return false;
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
