package javacore.Bintroducaometodos.aula09exercicio.test;

import javacore.Bintroducaometodos.aula09exercicio.dominio.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee01 = new Employee();
        Employee employee02 = new Employee();
        Employee employee03 = new Employee();

        employee01.name = "João";
        employee01.age = 39;
        employee01.salary = new double[]{1590.00, 1800.50, 1730.40};

        employee02.name = "Marcos Augusto";
        employee02.age = 31;
        employee02.salary = new double[]{2540.00, 3010.55, 2930.43};

        employee03.name = "Sanji";
        employee03.age = 23;
        employee03.salary = new double[]{1200, 987.32, 2000};


        employee01.print();
        System.out.println("---------------------------");
        employee02.print();
        System.out.println("---------------------------");
        employee03.print();
    }
}
