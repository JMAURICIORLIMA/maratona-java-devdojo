package javacore.Rdatas.aula07.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {

    public static void main(String[] args) {

        LocalDateTime aniversario = LocalDateTime.of(1990, Month.JANUARY, 10, 12, 0, 0);
        LocalDateTime now = LocalDateTime.now();

        long between1 = ChronoUnit.DAYS.between(aniversario, now);
        long between2 = ChronoUnit.WEEKS.between(aniversario, now);
        long between3 = ChronoUnit.MONTHS.between(aniversario, now);
        long between4 = ChronoUnit.YEARS.between(aniversario, now);

        System.out.println("Dias " + between1);
        System.out.println("Semanas " + between2);
        System.out.println("Meses " + between3);
        System.out.println("Anos " + between4);

    }

}
