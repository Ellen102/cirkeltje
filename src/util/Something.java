/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.paint.Paint;

/**
 *
 * @author Ellen
 */
public interface Something {
        
    public double getX() ;

    public void setX(double x) ;

    public double getY() ;

    public void setY(double y) ;

    public Paint getFill() ;

    public void setFill(Paint color);

    public double getWidth();

    public void setWidth(double width);

    public double getHeight();

    public void setHeight(double height);
    
    public String getName();
}
