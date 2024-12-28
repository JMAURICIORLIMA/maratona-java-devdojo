### O que é a Classe `Duration`?

A classe **`Duration`**, parte da API de datas e horas do pacote `java.time` (Java 8+), representa uma quantidade de
tempo em **segundos e nanossegundos**. Ela é usada para medir intervalos de tempo precisos e para cálculos baseados em
tempo absoluto. Diferente de outras classes como `Period`, que trabalha com dias, meses e anos, a `Duration` é ideal
para intervalos de menor granularidade.

---

### Para que Serve a Classe `Duration`?

1. **Medir a diferença entre dois pontos no tempo:**  
   Usada para calcular o intervalo entre dois instantes (`Instant`) ou outra fonte de tempo precisa.

2. **Definir intervalos específicos de tempo:**  
   Pode ser usada para criar durações como "10 segundos", "5 minutos", etc., e aplicá-las em operações com datas ou
   horários.

3. **Cálculos e manipulações com tempo:**  
   Adicionar ou subtrair durações de objetos como `Instant` ou `LocalDateTime`.

---

### Como Utilizar a Classe `Duration`

#### Criando uma `Duration`

1. **Criar uma `Duration` a partir de unidades de tempo:**
   ```java
   import java.time.Duration;

   public class ExemploDuration {
       public static void main(String[] args) {
           Duration dezSegundos = Duration.ofSeconds(10);
           Duration cincoMinutos = Duration.ofMinutes(5);

           System.out.println("10 segundos: " + dezSegundos);
           System.out.println("5 minutos: " + cincoMinutos);
       }
   }
   ```

2. **Criar a partir de dois instantes (`Instant`):**
   ```java
   import java.time.Duration;
   import java.time.Instant;

   public class ExemploDurationEntreInstantes {
       public static void main(String[] args) {
           Instant inicio = Instant.now();
           Instant fim = inicio.plusSeconds(120);

           Duration duracao = Duration.between(inicio, fim);
           System.out.println("Duração entre os instantes: " + duracao.getSeconds() + " segundos");
       }
   }
   ```

#### Operações com `Duration`

1. **Adicionar ou subtrair uma duração:**
   ```java
   import java.time.Duration;
   import java.time.Instant;

   public class ExemploOperacoesDuration {
       public static void main(String[] args) {
           Instant agora = Instant.now();
           Duration duracao = Duration.ofHours(2);

           Instant depois = agora.plus(duracao);
           Instant antes = agora.minus(duracao);

           System.out.println("Agora: " + agora);
           System.out.println("Depois de 2 horas: " + depois);
           System.out.println("Antes de 2 horas: " + antes);
       }
   }
   ```

2. **Dividir ou multiplicar durações:**
   ```java
   import java.time.Duration;

   public class ExemploDivisaoMultiplicacao {
       public static void main(String[] args) {
           Duration duracao = Duration.ofMinutes(10);

           Duration metade = duracao.dividedBy(2);
           Duration dobrado = duracao.multipliedBy(2);

           System.out.println("Duração original: " + duracao);
           System.out.println("Metade da duração: " + metade);
           System.out.println("Duração dobrada: " + dobrado);
       }
   }
   ```

#### Convertendo para Outras Unidades

A classe `Duration` pode ser convertida para unidades como nanossegundos, milissegundos, segundos, minutos, horas e até
dias.

```java
import java.time.Duration;

public class ExemploConversao {
    public static void main(String[] args) {
        Duration duracao = Duration.ofHours(1);

        System.out.println("Horas: " + duracao.toHours());
        System.out.println("Minutos: " + duracao.toMinutes());
        System.out.println("Segundos: " + duracao.getSeconds());
        System.out.println("Milissegundos: " + duracao.toMillis());
    }
}
```

---

### Diferença entre `Duration` e `Period`

| **Aspecto**        | **`Duration`**                         | **`Period`**                            |
|--------------------|----------------------------------------|-----------------------------------------|
| **Definição**      | Representa tempo em segundos/nanos.    | Representa tempo em dias, meses e anos. |
| **Uso Comum**      | Intervalos precisos (segundos, nanos). | Intervalos maiores (dias, meses, anos). |
| **Unidades**       | Segundos, nanos, minutos, horas.       | Dias, meses, anos.                      |
| **Exemplo de Uso** | Medir intervalo entre dois instantes.  | Calcular diferenças entre datas.        |

---

### Resumo com Parábola

Imagine que você é um organizador de corridas. Você tem dois relógios diferentes para medir o tempo dos corredores:

1. **`Duration`** é como um **cronômetro digital preciso**, que mede cada segundo e nanossegundo da corrida. Ele não se
   preocupa com o calendário, apenas com o intervalo de tempo entre o início e o fim da corrida.

2. **`Period`** é como um **calendário**, que mede intervalos maiores, como "3 meses e 2 dias até a próxima competição".
   Ele é útil para organizar eventos no longo prazo.

#### Moral da história:

Se sua preocupação é medir o **tempo exato** de uma corrida ou tarefa, use o **`Duration`**.  
Se você precisa planejar **datas no calendário**, use o **`Period`**.  
Assim como o cronômetro e o calendário têm seus usos distintos, `Duration` e `Period` servem para diferentes tipos de
medições temporais!