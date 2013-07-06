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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private static int grootte = 200;
    private static int straal = 20;    
    private static Circle circle;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cirkeltje");
        Group root = new Group();
        
         circle = new Circle();
         x=25;
         y=25;
         circle.setRadius(straal);
         
         circle.setTranslateX(x);
         circle.setTranslateY(y);

         
         root.getChildren().add(circle);
         primaryStage.setWidth(grootte);
         primaryStage.setHeight(grootte);
         primaryStage.setScene(new Scene(root));       
         
         primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                Double xplus = dX.get(t.getCode());
                Double yplus = dY.get(t.getCode());
                if(dX.get(t.getCode()) != null){
                    if((x<grootte && x>0)|| (x>=grootte && xplus <= 0) || (x<=0 && xplus>=0)){
                    x += xplus;
                    }
                    if((y<grootte && y>0)|| (y>=grootte && yplus <= 0) || (y<=0 && yplus>=0)){
                    y += yplus;
                    }
                    circle.setTranslateX(x);
                    circle.setTranslateY(y);
                }

            }
            
        });
        
 
        primaryStage.show();
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
