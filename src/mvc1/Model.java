package mvc1;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import lezen.Building;
import lezen.Item;
import lezen.Person;
import lezen.World;
import xml2beeld.vijf;

/**
 *
 * @author Ellen
 */
public class Model {
    private double x;
    private double y;
    private static final Shape me = new Rectangle(5.0, 10.0);;
    
    /*
     * illegaal
     * beste manier om verandering weer te geven??
     */
    private List children;
    
    private final ObservableList<Building> buildings = FXCollections.observableArrayList();
    private final ObservableList<Person> persons = FXCollections.observableArrayList();
    private final ObservableList<Item> items = FXCollections.observableArrayList();

    public Model(Group root) {
            me.setFill(Color.YELLOW);
            x=20; y=20;

            this.children=root.getChildren();
            
        World w;
        try {
            JAXBContext jc = JAXBContext.newInstance(World.class);
            w = (World) jc.createUnmarshaller().unmarshal(vijf.class.getResource("Wereld.xml"));
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
        for(Building b : w.getBuildings()){
           buildings.add(b);
           children.add(b.getShape());
        }
        
        for(Person b : w.getPersons()){
            persons.add(b);
            children.add(b.getShape());
        }
        
        for(Item b : w.getItems()){
            items.add(b);
            children.add(b.getShape());
        }

        children.add(me);

    }

    public ObservableList<Building> getBuildings() {
        return buildings;
    }

    public ObservableList<Person> getPersons() {
        return persons;
    }

    public ObservableList<Item> getItems() {
        return items;
    }
    
    public void verwijder(Item item){
        children.remove(item.getShape());
        items.remove(item);
    }
    
    public void verplaats(double x, double y){
        me.setTranslateX(x);
        me.setTranslateY(y);
    }
    


    
}
