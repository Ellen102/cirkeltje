/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.shape.Circle;

/**
 *new Circle(50,50,10, Color.BLUE)
 * @author Ellen
 */
public class Person {
    
    private final String name;
    private final Circle circle;
    private final String tekst;



    public Person(String name, Circle circle, String tekst) {
        this.name = name;
        this.circle=circle;
        this.tekst=tekst;
    }
    
    public String getName(){
        return name;
    }

    public Circle getCircle() {
        return circle;
    }

    public String getTekst() {
        return tekst;
    }

}
