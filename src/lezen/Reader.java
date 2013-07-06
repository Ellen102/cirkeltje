/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lezen;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Ellen
 */
@XmlRootElement(name="wereld")
public class Reader {
    
    private List<Building> buildings;
    private List<Person> persons;
    private List<Item> items;
//    @XmlElement (name = "item")
//    public List<Building> getBuildings() {
//        return buildings;
//    }
//
//    public void setBuildings(List<Building> buildings) {
//        this.buildings = buildings;
//    }

    @XmlElementWrapper (name = "persons")
    @XmlElement (name = "person")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

//    @XmlElementWrapper (name = "items")
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
    
    
}
