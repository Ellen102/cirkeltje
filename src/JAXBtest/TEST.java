/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JAXBtest;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ellen
 */
public class TEST extends Application {
    
    @Override
    public void start(Stage primaryStage) throws JAXBException {
            JAXBContext jc = JAXBContext.newInstance(Lijst.class);
            Lijst ls = (Lijst) jc.createUnmarshaller().unmarshal(
                    TEST.class.getResource("xmldoc.xml"));
            
           for(Person p : ls.getList()){
               System.out.println(p.getName());
               System.out.println(p.getTekst());
               System.out.println("-----");
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
