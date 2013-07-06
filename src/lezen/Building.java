/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lezen;

import javafx.scene.shape.Rectangle;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ellen
 */
public class Building extends Rectangle{
    private String name;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
