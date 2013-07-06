/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Item {
    private final String name;
    private final Shape shape;
    private final String tekst;

    public Item(String name, Shape shape, String tekst) {
        this.name = name;
        this.shape = shape;
        this.tekst = tekst;
    }

    public String getName() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }

    public String getTekst() {
        return tekst;
    }
        
}
