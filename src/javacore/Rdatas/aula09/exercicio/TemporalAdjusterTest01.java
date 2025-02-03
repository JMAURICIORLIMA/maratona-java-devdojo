package javacore.Rdatas.aula09.exercicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

public class TemporalAdjusterTest01 {

    public static void main(String[] args) {

        //Criando o ajustador personalizado
        TemporalAdjuster nextDayUtil = temporal -> {
            LocalDate date = LocalDate.from(temporal);
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            // Lógica para determinar o próximo dia útil.
            switch (dayOfWeek) {
                case THURSDAY:  //Quinta-feira
                    return date.plusDays(4); //Pula para segunda
                case FRIDAY:    //Sexta-feira
                    return date.plusDays(3); //Pula para segunda
                case SATURDAY:  //Sábado
                    return date.plusDays(2); //Pula para segunda
                case SUNDAY:    //Domingo
                    return date.plusDays(1); //Pula para segunda
                default:        //Segunda, Terça, Quarta
                    return date.plusDays(1); // Vai para o próximo dia.
            }
        };

        LocalDate[] testDates = {
                LocalDate.of(2024, 2,5),
                LocalDate.of(2024, 2,8),
                LocalDate.of(2024, 2,9),
                LocalDate.of(2024, 2,10),
                LocalDate.of(2024, 2,11)
        };

        for (LocalDate date : testDates) {
            LocalDate nextDay = date.with(nextDayUtil);
            System.out.printf("Data atual: %s (%s) -> Próximo dia útil: %s (%s)%n",
                    date, date.getDayOfWeek(),
                    nextDay, nextDay.getDayOfWeek());
        }
    }
}