package javacore.Sformatacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        //Tranformando o objeto LocalDate em String
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Formatado de Objeto para String: " + s1);
        System.out.println("Formatado de Objeto para String: " + s2);
        System.out.println("Formatado de Objeto para String: " + s3);

        //Tranformando a String em um Objeto.
        LocalDate parseS1 = LocalDate.parse("20250306", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parseS2 = LocalDate.parse("2025-03-06", DateTimeFormatter.ISO_DATE);
        LocalDate parseS3 = LocalDate.parse("2025-03-06", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Transformando de String para Objeto: " + parseS1);
        System.out.println("Transformando de String para Objeto: " + parseS2);
        System.out.println("Transformando de String para Objeto: " + parseS3);

        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);
        LocalDateTime parse4 = LocalDateTime.parse("2025-03-06T02:04:33.235832747"); // Pode-se usar assim ou
        LocalDateTime parse5 = LocalDateTime.parse("2025-03-06T02:04:33.235832747", DateTimeFormatter.ISO_DATE_TIME); // Usar passando o objeto.
        System.out.println(parse4);
        System.out.println(parse5);

        //Padrões internacionais
        /*
         * No Brasil - dd/MM/yyyy
         * No EUA - MM/dd/yyyy
         * No Japão - yyyy/MM/dd
         */
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterEUA = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatterJapao = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatBR = LocalDate.now().format(formatterBR);
        String formatEUA = LocalDate.now().format(formatterEUA);
        String formatJapao = LocalDate.now().format(formatterJapao);

        System.out.println("Formato BR: " + formatBR);
        System.out.println("Formato EUA: " + formatEUA);
        System.out.println("Formato Japão: " + formatJapao);

        LocalDate parseBR = LocalDate.parse("06/03/2025", formatterBR);
        System.out.println("Formatado para LocalDate: " + parseBR);

        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println("Data formatada em Alemão: " + formatGR);

        LocalDate parseGR = LocalDate.parse("06.März.2025", formatterGR);
        System.out.println("Data parsing para objeto LocalDate: " + parseGR);

    }
}
