/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testbeweging;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Ellen
 */
public class TestBeweging extends Application {
     private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
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
    
    private static int x;
    private static int y;
    private static Circle circle;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        
         circle = new Circle();
         x=25;
         y=25;
         circle.setRadius(20);
         
         circle.setTranslateX(x);
         circle.setTranslateY(y);

         
         root.getChildren().add(circle);
         primaryStage.setWidth(200);
         primaryStage.setHeight(200);
         primaryStage.setScene(new Scene(root));       
         
         primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                if(dX.get(t.getCode()) != null){
                    x += dX.get(t.getCode());
                    y += dY.get(t.getCode());
                    circle.setTranslateX(x);
                    circle.setTranslateY(y);
                }

            }
            
        });
        
 
        primaryStage.show();
    }

    
//     private void drawShapes(GraphicsContext gc) {
//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLACK);
//        gc.setLineWidth(5);
//        gc.fillOval(10, 60, 30, 30);
//
//    }
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
