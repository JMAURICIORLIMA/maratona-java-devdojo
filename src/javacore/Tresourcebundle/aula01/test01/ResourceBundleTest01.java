package javacore.Tresourcebundle.aula01.test01;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {

        System.out.println(Locale.getDefault());

        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

        // Verifica se existe
        /*
         * boolean sasa = bundle.containsKey("sasa");
         * System.out.println(sasa);
         */

        String hello = bundle.getString("hello");
        String goodMorning = bundle.getString("good.morning");
        System.out.println(hello);
        System.out.println(goodMorning);

        System.out.println(Locale.ENGLISH);
        bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        hello = bundle.getString("hello");
        goodMorning = bundle.getString("good.morning");
        System.out.println(hello);
        System.out.println(goodMorning);

    }
}
