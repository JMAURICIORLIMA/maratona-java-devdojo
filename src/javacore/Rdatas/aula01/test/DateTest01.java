package javacore.Rdatas.aula01.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {

        Date date = new Date(); // Classe date trabalha com Milli Segundos
        date.setTime(date.getTime());
        System.out.println(date);
    }
}
