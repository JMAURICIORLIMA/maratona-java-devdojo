### O que é a Classe `Period`?

A classe **`Period`** faz parte do pacote `java.time` e é usada para representar um **intervalo de tempo baseado em
unidades como anos, meses e dias**. Diferente da classe `Duration`, que mede tempo em segundos e nanossegundos, `Period`
é voltada para cálculos em um contexto de calendário.

**Principais características:**

- Representa intervalos maiores, como "2 anos, 3 meses e 5 dias".
- É imutável e thread-safe.
- Ideal para operações baseadas em calendários, como calcular idades ou diferenças entre datas.

---

### Para que Serve a Classe `Period`?

1. **Calcular a diferença entre duas datas no calendário:**  
   Por exemplo, calcular a idade de uma pessoa ou o tempo restante para uma data importante.

2. **Adicionar ou subtrair períodos de tempo em uma data:**  
   Por exemplo, somar "2 anos e 3 meses" a uma data.

3. **Trabalhar com intervalos de tempo legíveis em termos de calendário:**  
   Permite operações que consideram dias, meses e anos, ao invés de segundos ou nanossegundos.

---

### Como Utilizar a Classe `Period`

#### Criando um `Period`

1. **Criar um `Period` com valores específicos:**
   ```java
   import java.time.Period;

   public class ExemploPeriod {
       public static void main(String[] args) {
           Period doisAnosTresMeses = Period.of(2, 3, 0); // 2 anos e 3 meses
           Period cincoDias = Period.ofDays(5);

           System.out.println("Período: " + doisAnosTresMeses);
           System.out.println("Período em dias: " + cincoDias);
       }
   }
   ```

2. **Calcular o `Period` entre duas datas:**
   ```java
   import java.time.LocalDate;
   import java.time.Period;

   public class ExemploPeriodEntreDatas {
       public static void main(String[] args) {
           LocalDate nascimento = LocalDate.of(1990, 5, 20);
           LocalDate hoje = LocalDate.now();

           Period idade = Period.between(nascimento, hoje);
           System.out.println("Idade: " + idade.getYears() + " anos, " +
                              idade.getMonths() + " meses e " +
                              idade.getDays() + " dias.");
       }
   }
   ```

#### Operações com `Period`

1. **Adicionar ou subtrair um período de tempo:**
   ```java
   import java.time.LocalDate;
   import java.time.Period;

   public class ExemploOperacoesComPeriod {
       public static void main(String[] args) {
           LocalDate hoje = LocalDate.now();
           Period periodo = Period.ofMonths(6); // 6 meses

           LocalDate futuro = hoje.plus(periodo);
           LocalDate passado = hoje.minus(periodo);

           System.out.println("Data atual: " + hoje);
           System.out.println("Daqui a 6 meses: " + futuro);
           System.out.println("6 meses atrás: " + passado);
       }
   }
   ```

2. **Dividir ou normalizar períodos:**  
   A classe `Period` não suporta divisão direta, mas permite combinar períodos manualmente, criando representações úteis
   de tempo.

#### Exibindo os Componentes do Período

É possível obter os anos, meses e dias de um `Period` separadamente:

```java
import java.time.Period;

public class ExemploComponentesPeriod {
    public static void main(String[] args) {
        Period periodo = Period.of(1, 2, 15); // 1 ano, 2 meses e 15 dias

        System.out.println("Anos: " + periodo.getYears());
        System.out.println("Meses: " + periodo.getMonths());
        System.out.println("Dias: " + periodo.getDays());
    }
}
```

---

### Diferença entre `Period` e `Duration`

| **Aspecto**        | **`Period`**                             | **`Duration`**                          |
|--------------------|------------------------------------------|-----------------------------------------|
| **Definição**      | Intervalo de tempo em anos, meses, dias. | Intervalo de tempo em segundos/nanos.   |
| **Uso Comum**      | Diferenças no calendário (datas).        | Medições precisas (intervalos exatos).  |
| **Unidades**       | Anos, meses, dias.                       | Segundos, nanos, minutos, horas.        |
| **Exemplo de Uso** | Calcular idade ou tempo entre datas.     | Medir o tempo de execução de um evento. |

---

### Resumo com Parábola

Imagine que você está planejando uma jornada épica para atravessar um continente. Você tem dois instrumentos para
ajudar:

1. **`Period`** é como um **calendário de parede**. Ele te ajuda a planejar os grandes marcos da viagem: "vou passar 2
   meses neste país", "daqui a 3 anos estarei do outro lado". Ele lida com dias, meses e anos, que fazem sentido no
   contexto de um calendário.

2. **`Duration`** é como um **cronômetro digital**. Ele mede exatamente quanto tempo você gastou em cada etapa,
   calculando segundos e nanossegundos. É ideal para momentos precisos, mas não se preocupa com o contexto de
   calendário.

#### Moral da história:

- **Use `Period` quando o tempo está relacionado a um calendário** — planejando prazos, idades ou intervalos em dias,
  meses e anos.
- **Use `Duration` quando o tempo está relacionado à precisão absoluta**, como medir a duração exata de uma tarefa ou
  evento.

Assim como o calendário ajuda a planejar sua jornada e o cronômetro registra o tempo gasto em cada etapa, `Period` e
`Duration` têm seus próprios papéis em medir o tempo!