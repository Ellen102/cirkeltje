package lezen;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ellen
 */

/*
 * !! waarde mogen niet meer aangepast worden na aanmaak !!
 */
public abstract class Figureke {
   private double x;
   private double y;
   private String name;
   private String vorm;
   private Color fill = Color.BLACK;


    public Color getFill() {
        return fill;
    }

    protected void setFill(Color fill) {
        this.fill = fill;
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
