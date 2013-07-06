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
   private String name;
   private Color fill = Color.GREEN;
   private String vorm;

    public Color getFill() {
        return fill;
    }

    protected void setFill(Color fill) {
        this.fill = fill;
        getShape().setFill(fill);
    }
    public abstract Shape getShape();

    /*
     * eventueel eigen vorm kiezen met facotrymap ofzo
     */
    
    public String getVorm() {
        return vorm;
    }

    public void setVorm(String vorm) {
        this.vorm = vorm;
    }

    
    /*
     * gegevens figuur
     */
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



    
    
    
    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
