## 📌 **Classes Utilitárias: `ZonedDateTime`, `ZoneId`, `OffsetDateTime`**

As classes `ZonedDateTime`, `ZoneId` e `OffsetDateTime` fazem parte da API de datas do Java (`java.time`) e são usadas
para trabalhar com **fusos horários** e **deslocamentos de horário (offsets)**. Elas são fundamentais para aplicações
que precisam lidar com diferentes zonas horárias, como sistemas globais, agendamentos e logs de eventos.

---

# 🛠 **1. O que é e para que serve cada classe?**

### 🏙 **`ZonedDateTime` (Data e Hora com Fuso Horário)**

O `ZonedDateTime` representa uma data e hora específica **com um fuso horário associado** (`ZoneId`).

✔ **Exemplo:** "2025-02-09T10:00:00-03:00[America/Sao_Paulo]"  
✔ **Para que serve?**

- Trabalhar com datas e horários levando em conta um fuso horário específico.
- Ideal para aplicações que precisam converter horários para diferentes regiões do mundo.

---

### 🌎 **`ZoneId` (Identificador de Fuso Horário)**

O `ZoneId` representa um **fuso horário**, como **"America/Sao_Paulo"**, **"Europe/London"** ou **"Asia/Tokyo"**.

✔ **Para que serve?**

- Definir ou alterar o fuso horário de uma data/hora.
- Obter a lista de fusos horários disponíveis.

---

### ⏳ **`OffsetDateTime` (Data e Hora com Offset UTC)**

O `OffsetDateTime` representa uma data e hora **com um deslocamento fixo (offset) em relação ao UTC**.

✔ **Exemplo:** "2025-02-09T10:00:00-03:00"  
✔ **Para que serve?**

- Guardar e manipular horários em relação ao UTC, sem um fuso horário específico.
- Muito usado em **bancos de dados** e **protocolos de comunicação** (ex.: APIs REST).

---

# 📝 **2. Como Utilizar essas Classes?**

## **Exemplo 1️⃣: Criando um `ZonedDateTime` com `ZoneId`**

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ExemploZonedDateTime {
    public static void main(String[] args) {
        // Criando um ZonedDateTime para o horário atual com um fuso específico
        ZonedDateTime agoraSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Data e hora em São Paulo: " + agoraSaoPaulo);

        // Criando uma data específica com fuso horário de Nova York
        ZonedDateTime dataNovaYork = ZonedDateTime.of(2025, 2, 9, 10, 0, 0, 0, ZoneId.of("America/New_York"));
        System.out.println("Data e hora em Nova York: " + dataNovaYork);
    }
}
```

📌 **Explicação:**

- `ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))` → Obtém a data e hora atuais em São Paulo.
- `ZonedDateTime.of(2025, 2, 9, 10, 0, 0, 0, ZoneId.of("America/New_York"))` → Cria um `ZonedDateTime` específico para
  Nova York.

---

## **Exemplo 2️⃣: Convertendo entre Fusos Horários (`withZoneSameInstant`)**

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ConverterFusoHorario {
    public static void main(String[] args) {
        ZonedDateTime agoraSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime agoraLondres = agoraSaoPaulo.withZoneSameInstant(ZoneId.of("Europe/London"));

        System.out.println("Horário em São Paulo: " + agoraSaoPaulo);
        System.out.println("Horário em Londres: " + agoraLondres);
    }
}
```

📌 **Explicação:**

- `withZoneSameInstant()` → Converte a mesma hora para outro fuso horário.

---

## **Exemplo 3️⃣: Listando os Fusos Horários Disponíveis**

```java
import java.time.ZoneId;
import java.util.Set;

public class ListaFusos {
    public static void main(String[] args) {
        Set<String> fusos = ZoneId.getAvailableZoneIds();
        fusos.stream().limit(10).forEach(System.out::println); // Mostra os 10 primeiros
    }
}
```

📌 **Explicação:**

- `ZoneId.getAvailableZoneIds()` retorna a lista completa de fusos horários.

---

## **Exemplo 4️⃣: Trabalhando com `OffsetDateTime`**

```java
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExemploOffsetDateTime {
    public static void main(String[] args) {
        // Criando um OffsetDateTime com o fuso UTC-03:00
        OffsetDateTime dataComOffset = OffsetDateTime.now(ZoneOffset.of("-03:00"));
        System.out.println("Data e hora com offset -03:00: " + dataComOffset);
    }
}
```

📌 **Explicação:**

- `ZoneOffset.of("-03:00")` → Define um deslocamento fixo de **-3 horas em relação ao UTC**.

---

# 🎯 **3. Diferença Entre `ZonedDateTime`, `ZoneId` e `OffsetDateTime`**

| Classe           | O que representa?                      | Usa fusos horários? | Usa deslocamento UTC? | Ideal para...                                      |
|------------------|----------------------------------------|---------------------|-----------------------|----------------------------------------------------|
| `ZonedDateTime`  | Data e hora com fuso horário           | ✅ Sim               | ✅ Sim                 | Aplicações que lidam com múltiplos fusos horários. |
| `ZoneId`         | Apenas o identificador do fuso horário | ✅ Sim               | ❌ Não                 | Definir/converter fusos horários.                  |
| `OffsetDateTime` | Data e hora com um offset fixo do UTC  | ❌ Não               | ✅ Sim                 | Comunicação entre sistemas e bancos de dados.      |

---

# 📖 **4. Resumo com Parábola**

💡 **Imagine um grande aeroporto internacional!**

1. **`ZonedDateTime` é como o painel de voos no aeroporto.** Ele mostra a data e hora **exata** para cada cidade no seu
   respectivo fuso horário. Se você estiver voando de São Paulo para Londres, ele mostrará os horários em ambos os
   fusos.

2. **`ZoneId` é como o mapa de fusos horários do mundo.** Ele te mostra que "Nova York está no fuso Eastern Time (
   ET)", "São Paulo está no Brasil Time (BRT)", etc.

3. **`OffsetDateTime` é como um relógio mundial configurado em UTC.** Ele não liga para nomes de cidades, só para a
   diferença de tempo em relação ao **UTC**. Por isso, é usado para armazenar informações de forma padronizada em
   sistemas globais.

💭 **Moral da história:**  
Se precisar armazenar ou exibir horários corretamente, escolha bem sua ferramenta! Se quer fusos horários detalhados,
use `ZonedDateTime`; se precisa apenas de deslocamento UTC, vá de `OffsetDateTime`; e se só quer trabalhar com fusos,
`ZoneId` é sua melhor opção! 🚀