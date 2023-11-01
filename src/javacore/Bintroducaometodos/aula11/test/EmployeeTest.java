package javacore.Bintroducaometodos.aula11.test;

import javacore.Bintroducaometodos.aula11.dominio.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee01 = new Employee();
        Employee employee02 = new Employee();
        Employee employee03 = new Employee();

        employee01.setName("João");
        employee01.setAge(39);
        employee01.setSalary(new double[]{1590.00, 1800.50, 1730.40});

        employee02.setName("Marcos Augusto");
        employee02.setAge(31);
        employee02.setSalary(new double[]{2540.00, 3010.55, 2930.43});

        employee03.setName("Sanji");
        employee03.setAge(23);
        employee03.setSalary(new double[]{1200, 987.32, 2000});


        employee01.print();
        System.out.println("---------------------------");
        employee02.print();
        System.out.println("---------------------------");
        employee03.print();
    }
}
