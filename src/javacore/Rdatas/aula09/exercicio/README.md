Aqui está a explicação detalhada e o passo a passo para criar um programa que, dado um dia, retorna o próximo **dia útil
**, considerando sexta, sábado e domingo como **dias da semana não úteis**. Usaremos a classe `TemporalAdjuster` para
isso.

---

### Passo a Passo do Exercício

1. **Importar as Classes Necessárias**  
   Precisamos das classes do pacote `java.time` e `java.time.temporal` para manipular as datas e criar o ajustador
   personalizado.

   ```java
   import java.time.DayOfWeek;
   import java.time.LocalDate;
   import java.time.temporal.Temporal;
   import java.time.temporal.TemporalAdjuster;
   ```

2. **Entender a Lógica do Próximo Dia Útil**
    - Segunda a Quarta-feira: o próximo dia útil será o próximo dia consecutivo.
    - Quinta-feira: o próximo dia útil será a **segunda-feira da próxima semana**.
    - Sexta-feira, Sábado ou Domingo: o próximo dia útil será **segunda-feira**.

3. **Criar um Ajustador Personalizado com `TemporalAdjuster`**  
   Usaremos a interface funcional `TemporalAdjuster` para implementar a lógica que ajustará uma data ao próximo dia
   útil.

4. **Implementar a Lógica no Ajustador Personalizado**  
   Dentro do método `adjustInto`, usaremos `DayOfWeek` para identificar o dia atual e calcular o próximo dia útil com
   base nas regras.

5. **Testar o Programa**  
   Finalmente, testaremos o programa com diferentes datas para garantir que ele funcione corretamente.

---

### Código do Programa com Explicação

Aqui está o código completo e explicado:

```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class ProximoDiaUtil {
    public static void main(String[] args) {
        // Data atual para testar
        LocalDate data = LocalDate.now();
        System.out.println("Data atual: " + data);

        // Aplicar o ajustador personalizado
        LocalDate proximoDiaUtil = data.with(new AjustadorProximoDiaUtil());
        System.out.println("Próximo dia útil: " + proximoDiaUtil);
    }
}

// Ajustador personalizado para calcular o próximo dia útil
class AjustadorProximoDiaUtil implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        // Converter o temporal em LocalDate
        LocalDate data = LocalDate.from(temporal);

        // Obter o dia da semana atual
        DayOfWeek diaDaSemana = data.getDayOfWeek();

        // Lógica para encontrar o próximo dia útil
        switch (diaDaSemana) {
            case THURSDAY: // Se for quinta-feira, pular para segunda-feira
            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                // Avançar os dias restantes para alcançar a segunda-feira
                return data.with(DayOfWeek.MONDAY);
            default: // Para Segunda, Terça ou Quarta-feira, basta avançar 1 dia
                return data.plusDays(1);
        }
    }
}
```

---

### Explicação do Programa

1. **Linha a Linha:**
    - `LocalDate data = LocalDate.now();`  
      Obtém a data atual para ser usada no exemplo.
    - `data.with(new AjustadorProximoDiaUtil());`  
      Aplica o **ajustador personalizado** à data atual. O ajustador contém a lógica para determinar o próximo dia útil.

2. **Criando o Ajustador Personalizado:**
    - `class AjustadorProximoDiaUtil implements TemporalAdjuster`  
      Declaramos uma classe que implementa a interface `TemporalAdjuster`. Essa interface tem um único método chamado
      `adjustInto`, que é onde definimos a lógica de ajuste.

    - `Temporal adjustInto(Temporal temporal)`  
      O método `adjustInto` recebe um objeto do tipo `Temporal`, que representa um ponto temporal genérico. Nós o
      convertemos para `LocalDate` para trabalhar com dias de calendário.

    - `DayOfWeek diaDaSemana = data.getDayOfWeek();`  
      Usamos o método `getDayOfWeek()` para identificar o dia da semana da data atual.

3. **Lógica de Ajuste:**
    - Usamos um **switch** para verificar o dia da semana atual e determinar o próximo dia útil:
        - **Quinta, Sexta, Sábado ou Domingo:**  
          Usamos `data.with(DayOfWeek.MONDAY)` para ajustar a data para a próxima segunda-feira.
        - **Segunda, Terça ou Quarta-feira:**  
          Usamos `data.plusDays(1)` para avançar apenas um dia.

4. **Testando o Programa:**
    - Teste com diferentes dias da semana (atualmente ou configurando datas específicas) para verificar o funcionamento:
      ```java
      LocalDate quinta = LocalDate.of(2025, 1, 23); // Quinta-feira
      System.out.println("Quinta-feira: " + quinta.with(new AjustadorProximoDiaUtil()));
 
      LocalDate sexta = LocalDate.of(2025, 1, 24); // Sexta-feira
      System.out.println("Sexta-feira: " + sexta.with(new AjustadorProximoDiaUtil()));
 
      LocalDate sabado = LocalDate.of(2025, 1, 25); // Sábado
      System.out.println("Sábado: " + sabado.with(new AjustadorProximoDiaUtil()));
 
      LocalDate segunda = LocalDate.of(2025, 1, 20); // Segunda-feira
      System.out.println("Segunda-feira: " + segunda.with(new AjustadorProximoDiaUtil()));
      ```

---

### Resumo com Parábola

Imagine que você é um carteiro entregando correspondências. No seu cronograma, você trabalha de segunda a quinta-feira,
mas descansa na sexta, no sábado e no domingo. Se você recebe um pedido de entrega na **quinta-feira**, o próximo dia em
que você trabalhará será na **segunda-feira**.

Agora, pense no **`TemporalAdjuster`** como seu ajudante pessoal. Ele olha o calendário, verifica o dia atual e calcula
automaticamente o próximo dia em que você estará disponível para trabalhar. Você só precisa perguntar, e ele faz o
trabalho pesado!

#### Moral da história:

O `TemporalAdjuster` é seu ajudante esperto para lidar com ajustes de datas complexas. Ele entende as regras (como dias
úteis) e faz os cálculos necessários, economizando seu esforço e garantindo que as datas sempre estejam corretas!