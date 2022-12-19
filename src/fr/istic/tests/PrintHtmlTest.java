package fr.istic.tests;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import fr.istic.Utils;
import fr.istic.issaouad.impl.CategoryImpl;
import fr.istic.issaouad.impl.ConfiguratorImpl;
import fr.istic.issaouad.impl.PrintHtml;
import fr.istic.nplouzeau.cartaylor.api.Configuration;
import fr.istic.nplouzeau.cartaylor.api.PartType;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.*;
import java.util.Set;

import static org.junit.Assert.*;

public class PrintHtmlTest {
    @Test
    public void init() throws IOException {
    ConfiguratorImpl configurator = new ConfiguratorImpl();
    Configuration configuration = configurator.getConfiguration();
    configurator = new ConfiguratorImpl();
    configuration = configurator.getConfiguration();
    Set<PartType> engines =  (configurator.getVariants(new CategoryImpl(Utils.ENGINE)));
    Set<PartType>  interiors =  (configurator.getVariants( new CategoryImpl(Utils.INTERIOR)));
    Set<PartType> exteriors =  (configurator.getVariants( new CategoryImpl(Utils.EXTERIOR)));
    Set<PartType> transmissions =  (configurator.getVariants( new CategoryImpl(Utils.TRANSMISSION)));
        for(PartType p : engines){
        if(p.getName().equals("ED180")) configuration.selectPart(p);
    }
        for(PartType p : interiors){
        if(p.getName().equals("IN")) configuration.selectPart(p);
    }
        for(PartType p : exteriors){
        if(p.getName().equals("XS")) configuration.selectPart(p);
    }
        for(PartType p : exteriors){
        if(p.getName().equals("TM5")) configuration.selectPart(p);
    }
        System.out.println(configuration.getSelectedParts().size());

        // Creates a FileOutputStream
        FileOutputStream file = new FileOutputStream("fichier");

        // Creates a PrintStream
        PrintStream output = new PrintStream(file);


        PrintHtml html = new PrintHtml(output, configuration);
        html.printConfiguration();

        String expectedOutPut =  "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>Projet ACO : CARS TAYLOR</title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Configuration :  </h1>\n" +
                "<h2>ED180</h2>\n" +
                "<h3>\n" +
                "Categorie : Engine\n" +
                "</h3>\n" +
                "<ul>\n" +
                "<li>\n" +
                "power : 180kw</li>\n" +
                "<li>\n" +
                "type : DIESEL</li>\n" +
                "</ul>\n" +
                "<h2>IN</h2>\n" +
                "<h3>\n" +
                "Categorie : Interior\n" +
                "</h3>\n" +
                "<ul>\n" +
                "<li>\n" +
                "quality : STANDARD</li>\n" +
                "</ul>\n" +
                "<h2>XS</h2>\n" +
                "<h3>\n" +
                "Categorie : Exterior\n" +
                "</h3>\n" +
                "<ul>\n" +
                "<li>\n" +
                "paint : RED</li>\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";

        PrintStream expected = new PrintStream("expected");
        expected.write(expectedOutPut.getBytes());
        assertEquals(expected.toString(), expected.toString());
}
}
