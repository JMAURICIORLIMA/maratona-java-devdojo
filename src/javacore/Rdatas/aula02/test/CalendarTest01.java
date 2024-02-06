package javacore.Rdatas.aula02.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance(); // Obtendo uma instância de Calendar

        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingão é o primeiro dia da semana");
        }

        System.out.println(c.get(Calendar.DAY_OF_WEEK)); // Dia da semana (seg, ter, qua....)
        System.out.println(c.get(Calendar.DAY_OF_MONTH)); // Dia do mês (1, 2, 3, 4....)
        System.out.println(c.get(Calendar.DAY_OF_YEAR)); // Dia do ano (Conta os dias até a data presente (1, 2, 10, 200, 360...))
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH)); // Dia da semana no mês.

        c.add(Calendar.DAY_OF_MONTH, 2); // Adicionando 2 dias a mais no calendário atual.
        c.add(Calendar.HOUR, 2); // Adiciona x horas na hora atual. Podendo virar o dia ou até mesmo o ano.
//        c.roll(Calendar.HOUR, 12);

        Date date = c.getTime(); // Obtendo a data e hora atual

        System.out.println(date);
    }
}
