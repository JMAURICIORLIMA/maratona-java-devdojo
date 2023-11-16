# Orientação Objetos - Blocos de inicialização

60 - Orientação Objetos - Bloco de inicialização [^01]

[^01]: Acesso o vídeo YouTube ->  [60 - Orientação Objetos - Blocos de inicialização](https://abre.ai/hdvb)

Em Java, blocos de inicialização são usados para executar código antes da execução dos construtores. Existem dois tipos
principais de blocos de inicialização: o bloco de inicialização estática e o bloco de inicialização de instância.

### Bloco de Inicialização Estática:

Um bloco de inicialização estática é executado quando a classe é carregada na memória. Ele é denotado pelo uso da
palavra-chave `static`. Um bloco de inicialização estática é executado apenas uma vez quando a classe é carregada,
independentemente do número de instâncias criadas.

Exemplo:

```java
public class ExemploBlocoInicializacao {
    static {
        System.out.println("Bloco de Inicialização Estática");
    }

    public static void main(String[] args) {
        // A saída será "Bloco de Inicialização Estática" quando a classe for carregada.
    }
}
```

### Bloco de Inicialização de Instância:

Um bloco de inicialização de instância é executado quando uma instância da classe é criada. Ele não contém a
palavra-chave `static`. Esse bloco é executado antes de qualquer construtor ser chamado.

Exemplo:

```java
public class ExemploBlocoInicializacao {
    {
        System.out.println("Bloco de Inicialização de Instância");
    }

    public ExemploBlocoInicializacao() {
        System.out.println("Construtor");
    }

    public static void main(String[] args) {
        // A saída será "Bloco de Inicialização de Instância" seguido por "Construtor" quando uma instância for criada.
        ExemploBlocoInicializacao obj = new ExemploBlocoInicializacao();
    }
}
```

Em ambos os casos, os blocos de inicialização são usados para executar código que precisa ser executado durante a
inicialização da classe ou da instância. Eles são úteis quando há lógica de inicialização que deve ser compartilhada por
todos os construtores.