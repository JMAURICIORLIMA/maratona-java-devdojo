Orientação Objetos - Orientação Objetos - Sobrecarga de métodos [^01].

[^01]: Acesso o vídeo YouTube -> [Maratona Java 57 - Orientação Objetos - Sobrecarga de métodos](https://abre.ai/hcpW).

Sobrecarga e substituição de método em Java [^02]

[^02]: Baeldung "em inglês" -> [Sobrecarga e substituição de método em Java]K(https://www.baeldung.com/java-method-overload-override)

### 1. Visão Geral

A sobrecarga e a substituição de métodos são conceitos-chave da linguagem de programação Java e, como tal, merecem uma
análise aprofundada.

Neste artigo aprenderemos o básico desses conceitos e veremos em que situações eles podem ser úteis.

### 2. Sobrecarga de método

A sobrecarga de métodos é um mecanismo poderoso que nos permite definir APIs de classes coesas. Para entender melhor
por que a sobrecarga de métodos é um recurso tão valioso, vejamos um exemplo simples.

Suponha que escrevemos uma classe utilitária ingênua que implementa diferentes métodos para multiplicar dois números,
três números e assim por diante.

Se dermos aos métodos nomes enganosos ou ambíguos, como multiplicar2(), multiplicar3(), multiplicar4(), então isso
seria uma API de classe mal projetada. É aqui que entra a sobrecarga de métodos.

Simplificando, podemos implementar a sobrecarga de métodos de duas maneiras diferentes:

- implementar dois ou mais métodos que tenham o mesmo nome, mas que recebam números diferentes de argumentos
- implementar dois ou mais métodos que tenham o mesmo nome, mas que recebam argumentos de tipos diferentes

**2.1. Diferentes números de argumentos**

A classe Multiplier mostra, resumidamente, como sobrecarregar o método multiplicar() simplesmente definindo duas
implementações que recebem números diferentes de argumentos:

```java
public class Multiplier {
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
}
```

**2.2. Argumentos de diferentes tipos**

Da mesma forma, podemos sobrecarregar o método multiplicar() fazendo-o aceitar argumentos de diferentes tipos:

```java
public class Multiplier {
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
}
```

Além disso, é legítimo definir a classe Multiplicador com ambos os tipos de sobrecarga de métodos:

```java
public class Multiplier {
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
}
```

Vale a pena notar, entretanto, que não é possível ter duas implementações de métodos que diferem apenas em seus tipos
de retorno.

Para entender o porquê – vamos considerar o seguinte exemplo:

```java
public int multiply(int a, int b) { 
    return a * b; 
}
 
public double multiply(int a, int b) { 
    return a * b; 
}
```

Nesse caso, o código simplesmente não seria compilado por causa da ambiguidade na chamada do método – o compilador não
saberia qual implementação de multiplicar() chamar.

**2.3. Tipo Promoção**

Um recurso interessante fornecido pela sobrecarga de método é a chamada promoção de tipo, também conhecida como
conversão primitiva ampliada.

Em termos simples, um determinado tipo é promovido implicitamente para outro quando não há correspondência entre os
tipos dos argumentos passados para o método sobrecarregado e uma implementação específica do método.

Para entender mais claramente como funciona a promoção de tipo, considere as seguintes implementações do método
multiplicar():

```java
public double multiply(int a, long b) {
    return a * b;
}

public int multiply(int a, int b, int c) {
    return a * b * c;
}
```

Agora, chamar o método com dois argumentos int resultará na promoção do segundo argumento para long, pois neste caso
não há uma implementação correspondente do método com dois argumentos int.

Vejamos um teste de unidade rápido para demonstrar a promoção do tipo:

```java
@Test
public void whenCalledMultiplyAndNoMatching_thenTypePromotion() {
    assertThat(multiplier.multiply(10, 10)).isEqualTo(100.0);
}
```

Por outro lado, se chamarmos o método com uma implementação correspondente, a promoção de tipo simplesmente não
ocorrerá:

```java
@Test
public void whenCalledMultiplyAndMatching_thenNoTypePromotion() {
    assertThat(multiplier.multiply(10, 10, 10)).isEqualTo(1000);
}
```

Aqui está um resumo das regras de promoção de tipo que se aplicam à sobrecarga de métodos:

- byte pode ser promovido para short, int, long, float ou double
- short pode ser promovido para int, long, float ou double
- char pode ser promovido para int, long, float ou double
- int pode ser promovido para long, float ou double
- longo pode ser promovido para float ou double
- float pode ser promovido para double

**2.4. Vinculação estática**

A capacidade de associar uma chamada de método específica ao corpo do método é conhecida como vinculação.

No caso de sobrecarga de método, a ligação é executada estaticamente em tempo de compilação, por isso é chamada de
ligação estática.

O compilador pode definir efetivamente a ligação em tempo de compilação simplesmente verificando as assinaturas dos
métodos.

### 3. Substituição de método

A substituição de métodos nos permite fornecer implementações refinadas em subclasses para métodos definidos em uma
classe base.

Embora a substituição de método seja um recurso poderoso – considerando que é uma consequência lógica do uso de herança,
um dos maiores pilares da OOP – quando e onde utilizá-la deve ser analisado cuidadosamente, caso a caso.

Vamos ver agora como usar a substituição de métodos criando um relacionamento simples baseado em herança (“é um”).

Aqui está a classe base:

```java
public class Vehicle {
    
    public String accelerate(long mph) {
        return "The vehicle accelerates at : " + mph + " MPH.";
    }
    
    public String stop() {
        return "The vehicle has stopped.";
    }
    
    public String run() {
        return "The vehicle is running.";
    }
}
```

E aqui está uma subclasse inventada:

```java
public class Car extends Vehicle {

    @Override
    public String accelerate(long mph) {
        return "The car accelerates at : " + mph + " MPH.";
    }
}
```

Na hierarquia acima, simplesmente substituímos o método acelerar() para fornecer uma implementação mais refinada para o
subtipo Carro.

Aqui, fica claro que se um aplicativo usa instâncias da classe Vehicle pode funcionar com instâncias de Car, então ele
também, já que ambas as implementações do método acelerar() têm a mesma assinatura e o mesmo tipo de retorno.

Vamos escrever alguns testes unitários para verificar as Vehicle e Car : classes

```java
@Test
public void whenCalledAccelerate_thenOneAssertion() {
    assertThat(vehicle.accelerate(100))
      .isEqualTo("The vehicle accelerates at : 100 MPH.");
}
    
@Test
public void whenCalledRun_thenOneAssertion() {
    assertThat(vehicle.run())
      .isEqualTo("The vehicle is running.");
}
    
@Test
public void whenCalledStop_thenOneAssertion() {
    assertThat(vehicle.stop())
      .isEqualTo("The vehicle has stopped.");
}

@Test
public void whenCalledAccelerate_thenOneAssertion() {
    assertThat(car.accelerate(80))
      .isEqualTo("The car accelerates at : 80 MPH.");
}
    
@Test
public void whenCalledRun_thenOneAssertion() {
    assertThat(car.run())
      .isEqualTo("The vehicle is running.");
}
    
@Test
public void whenCalledStop_thenOneAssertion() {
    assertThat(car.stop())
      .isEqualTo("The vehicle has stopped.");
}
```

Agora, vamos ver alguns testes de unidade que mostram como os métodos run() e stop(), que não são substituídos,
retornam valores iguais para Car e Vehicle :

```java
@Test
public void givenVehicleCarInstances_whenCalledRun_thenEqual() {
    assertThat(vehicle.run()).isEqualTo(car.run());
}
 
@Test
public void givenVehicleCarInstances_whenCalledStop_thenEqual() {
   assertThat(vehicle.stop()).isEqualTo(car.stop());
}
```

No nosso caso, temos acesso ao código-fonte de ambas as classes, então podemos ver claramente que chamar o método
acelerar() em uma instância base de Veículo e chamar acelerar() em uma instância de Carro retornará valores diferentes
para o mesmo argumento.

Portanto, o teste a seguir demonstra que o método substituído é invocado para uma instância de Car :

```java
@Test
public void whenCalledAccelerateWithSameArgument_thenNotEqual() {
    assertThat(vehicle.accelerate(100))
      .isNotEqualTo(car.accelerate(100));
}
```

**3.1. Substituibilidade de tipo**

Um princípio fundamental da OOP é o da substituibilidade de tipo, que está intimamente associado ao [Princípio de
Substituição de Liskov (LSP)](https://en.wikipedia.org/wiki/Liskov_substitution_principle) .

Simplificando, o LSP afirma que se um aplicativo funcionar com um determinado tipo base, ele também deverá funcionar
com qualquer um de seus subtipos. Dessa forma, a substituibilidade de tipo é preservada adequadamente.

O maior problema com a substituição de métodos é que algumas implementações de métodos específicos nas classes
derivadas podem não aderir totalmente ao LSP e, portanto, não conseguem preservar a substituibilidade de tipos.

Claro, é válido fazer um método sobrescrito para aceitar argumentos de tipos diferentes e retornar um tipo diferente
também, mas com total aderência a estas regras:

- Se um método na classe base recebe argumento(s) de um determinado tipo, o método substituído deve usar o mesmo tipo
  ou um supertipo (também conhecido como argumentos de método contravariantes )
- Se um método na classe base retornar void, o método substituído deverá retornar void
- Se um método na classe base retornar um primitivo, o método substituído deverá retornar o mesmo primitivo
- Se um método na classe base retornar um determinado tipo, o método substituído deverá retornar o mesmo tipo ou um
  subtipo (também conhecido como tipo de retorno covariante )
- Se um método na classe base lançar uma exceção, o método substituído deverá lançar a mesma exceção ou um subtipo da
  exceção da classe base

**3.2. Vinculação Dinâmica**

Considerando que a substituição de métodos só pode ser implementada com herança, onde há uma hierarquia de um tipo base
e subtipo(s), o compilador não pode determinar em tempo de compilação qual método chamar, pois tanto a classe base
quanto as subclasses definem o mesmos métodos.

Como consequência, o compilador precisa verificar o tipo de objeto para saber qual método deve ser invocado.

Como essa verificação acontece em tempo de execução, a substituição de método é um exemplo típico de ligação dinâmica.

### 4. Conclusão

Neste tutorial, aprendemos como implementar a sobrecarga e a substituição de métodos e exploramos algumas situações
típicas em que elas são úteis.