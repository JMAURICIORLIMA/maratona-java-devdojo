package javacore.Rdatas.aula08.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now(); // Retorna a data atual do dispositivo.
        System.out.println(now);
        now = now.plusDays(25); // É adicionado mais a quantidade de dias a partir da data atual.
        System.out.println(now);
        now = now.withDayOfMonth(25); // Retorna uma cópia deste LocalDate com o dia do mês alterado.
        System.out.println(now);
        now = now.withMonth(2); // Retorna uma cópia deste LocalDate com o mês do ano alterado.
        System.out.println(now);
        now = now.with(ChronoField.DAY_OF_MONTH, 25);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        // Representar o próximo dia da semana, ex. Próxima Quarta (que dia da semana cairá).
        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()); // Retorna o primeiro dia do mês
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()); // Retorna o último dia do mês
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()); // Retorna o primeiro dia do próximo ano.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

    }
}
