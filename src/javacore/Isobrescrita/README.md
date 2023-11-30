# Sobrecarga do método toString

76 - Orientação Objetos - Sobrecarga do método toString[^01]

[^01]: Acesse o vídeo Youtube -> [76 - Orientação Objetos - Sobrecarga do método toString](https://abre.ai/huEb)

A sobrescrita do método `toString()` em Java é uma prática comum para fornecer uma representação de string significativa
para objetos. O método `toString()` está definido na classe `Object`, da qual todas as classes em Java herdam
implicitamente. A assinatura do método na classe `Object` é:

```java
public String toString(){
        // implementação padrão
        }
```

Ao sobrescrever esse método em suas próprias classes, você pode fornecer uma representação de string personalizada para
seus objetos. Aqui está um exemplo:

```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Sobrescrita do método toString
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        System.out.println(person); // Automaticamente chama o método toString
    }
}
```

Neste exemplo, ao imprimir a instância de `Person`, o método `toString()` é automaticamente chamado. A saída será a
representação de string definida no método sobrescrito.

É uma prática útil sobrescrever `toString()` para que, ao imprimir ou logar objetos, você obtenha informações mais úteis
sobre o estado do objeto. Isso é especialmente útil ao depurar ou ao usar registros em sua aplicação.

Lembre-se de adicionar a anotação `@Override` acima do método para garantir que você esteja realmente sobrescrevendo um
método da superclasse e não criando um novo método por engano.