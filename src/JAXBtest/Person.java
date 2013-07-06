/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXBtest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellen
 */

public class Person {
    private String name;
    private String tekst;

    public String getName() {
        return name;
    }
    
    @XmlElement(name = "name")
    public void setName(String name) {
        System.out.println("---"+name);
        this.name = name;
    }

    public String getTekst() {
        return tekst;
    }
    
    @XmlElement(name = "tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
  
    
}
