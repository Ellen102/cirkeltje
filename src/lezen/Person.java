package lezen;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Person extends Figureke{
    private String zin;
    private double radius;
    private Shape shape;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
   
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Circle(getX(), getY(), radius);
            shape.setFill(getFill());
        }
        return shape;
    }
    public String getZin() {
        return zin;
    }

    public void setZin(String zin) {
        this.zin = zin;
    }
    
}
