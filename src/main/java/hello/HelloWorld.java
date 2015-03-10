package hello;


import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.DatatypeConverterInterface;
import java.util.Arrays;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Ivan.Ivanyuk on 2/27/2015.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(new Date().getTime()/1000);
        System.out.println(System.currentTimeMillis()/1000);
        char[] test = new char[100];
        Arrays.asList(test).contains(1);
        byte[] apdu = DatatypeConverter.parseHexBinary("A0A40000023F00");
        System.out.println(DatatypeConverter.printBase64Binary(apdu));
    }

}
