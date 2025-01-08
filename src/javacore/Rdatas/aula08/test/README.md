### O que é a Classe `TemporalAdjusters`?

A **`TemporalAdjusters`** é uma classe utilitária do pacote `java.time.temporal` que fornece métodos estáticos para
ajustar datas. Esses ajustes permitem calcular datas específicas, como o próximo dia útil, o último dia do mês ou a
próxima sexta-feira. É útil para operações complexas que exigem cálculos baseados em regras de calendário.

---

### Para que Serve a Classe `TemporalAdjusters`?

1. **Realizar ajustes baseados em regras de calendário:**  
   Por exemplo, obter o primeiro ou último dia do mês, ou o próximo domingo.

2. **Facilitar cálculos com datas específicas:**  
   Simplifica operações que seriam complicadas com cálculos manuais.

3. **Trabalhar com qualquer classe que implemente `Temporal`:**  
   Pode ser usada com classes como `LocalDate`, `LocalDateTime`, ou `ZonedDateTime`.

---

### Como Utilizar a Classe `TemporalAdjusters`

#### Métodos Comuns de Ajuste

1. **`firstDayOfMonth()`:** Retorna o primeiro dia do mês.
2. **`lastDayOfMonth()`:** Retorna o último dia do mês.
3. **`next(DayOfWeek)`:** Retorna a próxima ocorrência de um dia da semana.
4. **`previous(DayOfWeek)`:** Retorna a ocorrência anterior de um dia da semana.
5. **`firstInMonth(DayOfWeek)`:** Retorna a primeira ocorrência de um dia da semana no mês.
6. **`lastInMonth(DayOfWeek)`:** Retorna a última ocorrência de um dia da semana no mês.

#### Exemplo Prático

```java
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public class ExemploTemporalAdjusters {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        // Primeiro dia do mês
        LocalDate primeiroDiaMes = hoje.with(TemporalAdjusters.firstDayOfMonth());

        // Último dia do mês
        LocalDate ultimoDiaMes = hoje.with(TemporalAdjusters.lastDayOfMonth());

        // Próxima sexta-feira
        LocalDate proximaSexta = hoje.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        // Última segunda-feira do mês
        LocalDate ultimaSegundaMes = hoje.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));

        System.out.println("Hoje: " + hoje);
        System.out.println("Primeiro dia do mês: " + primeiroDiaMes);
        System.out.println("Último dia do mês: " + ultimoDiaMes);
        System.out.println("Próxima sexta-feira: " + proximaSexta);
        System.out.println("Última segunda-feira do mês: " + ultimaSegundaMes);
    }
}
```

#### Criando um Ajustador Personalizado

Você pode criar seu próprio ajustador com a interface `TemporalAdjuster`:

```java
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.Temporal;

public class ExemploAjustadorPersonalizado {
    public static void main(String[] args) {
        TemporalAdjuster ajustarParaDia15 = temporal -> {
            LocalDate data = LocalDate.from(temporal);
            return data.withDayOfMonth(15);
        };

        LocalDate hoje = LocalDate.now();
        LocalDate dia15 = hoje.with(ajustarParaDia15);

        System.out.println("Hoje: " + hoje);
        System.out.println("Ajustado para o dia 15: " + dia15);
    }
}
```

---

### Casos de Uso Comuns

1. **Fechamento de Contas:**  
   Calcular o último dia do mês para fechamento financeiro.

2. **Planejamento de Eventos:**  
   Encontrar a próxima sexta-feira para reuniões.

3. **Feriados ou Datas Fixas:**  
   Ajustar uma data para o próximo dia útil ou uma data comemorativa.

---

### Resumo com Parábola

Imagine que você é um agricultor cuidando de uma plantação. Todos os meses, você precisa decidir quando plantar, colher
e fertilizar. As tarefas têm datas específicas:

1. **`TemporalAdjusters` é como um ajudante experiente** que sabe exatamente quais são os melhores dias para cada
   atividade. Ele pode te dizer qual é o **primeiro dia do mês**, quando será a **próxima sexta-feira** ou quando
   ocorrerá a **última segunda-feira do mês**.

2. **Se precisar de algo mais personalizado**, como escolher o dia 15 para fertilizar, você pode ensinar o ajudante a
   criar um ajuste personalizado.

#### Moral da história:

O **`TemporalAdjusters`** é seu assistente de calendário, pronto para realizar cálculos e ajustes precisos de datas.
Seja planejando um evento ou calculando prazos, ele simplifica suas operações, assim como um ajudante confiável
simplifica a vida no campo!