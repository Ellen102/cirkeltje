/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ellen
 */
public class Building extends Rectangle {
    private String name;
    
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
