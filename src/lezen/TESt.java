/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lezen;

import JAXBtest.TEST;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ellen
 */
public class TESt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //lezen
            JAXBContext jc = JAXBContext.newInstance(World.class);
            World ls = (World) jc.createUnmarshaller().unmarshal(World.class.getResource("Wereld.xml"));
            
            for(Person p : ls.getPersons()){
                System.out.println(p.getName());
                System.out.println(p.getHeight());
                System.out.println(p.getZin());
            }
            System.out.println("----");
            for(Item i : ls.getItems()){
                System.out.println(i.getName());
                System.out.println(i.getHeight());
            }
            for(Building b : ls.getBuildings()){
                System.out.println(b.getName());
            }


        
        
        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    
    }
}
