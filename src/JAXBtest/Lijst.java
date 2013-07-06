/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXBtest;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellen
 */
@XmlRootElement(name="root")
public class Lijst {
    private List<Person> list;

    @XmlElement (name = "lijst")
    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        System.out.println("setlist");
        this.list = list;
    }
    
}
