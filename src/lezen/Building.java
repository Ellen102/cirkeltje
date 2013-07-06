/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lezen;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ellen
 */
public class Building extends Figureke{
   private double height;
   private double width;
   private Shape shape;

  
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Rectangle(getX(), getY(), width, height);
            shape.setFill(getFill());
        }
        return shape;
    }
    
       public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
