/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXBtest;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Ellen
 * 
 * http://www.vogella.com/articles/JAXB/article.html
 * 
 */
public class TEST extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            //lezen
            JAXBContext jc = JAXBContext.newInstance(Lijst.class);
            Lijst ls = (Lijst) jc.createUnmarshaller().unmarshal(TEST.class.getResource("xmldoc.xml"));
            
           for(Person p : ls.getList()){
               System.out.println(p.getName());
               System.out.println(p.getTekst());
               System.out.println("-----");
           }
         
        //schrijven
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Lijst.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(ls, System.out);
        // Write to File
        m.marshal(ls, new File("./schrijf.xml"));
        
        
        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
