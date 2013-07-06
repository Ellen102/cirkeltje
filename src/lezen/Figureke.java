/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lezen;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ellen
 */
public abstract class Figureke {
    private double x;
   private double y;
   private double height;
   private double width;
   private String name;
   private Color fill = Color.GREEN;
   private String vorm;
   private Shape shape;

    public Shape getShape() {
        if(shape == null){
            shape = new Rectangle(x, y, width, height);
            shape.setFill(fill);
        }
        return shape;
    }

    public String getVorm() {
        return vorm;
    }

    public void setVorm(String vorm) {
        this.vorm = vorm;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
