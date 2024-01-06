package javacore.Npolimorfismo.aula05.test;

import javacore.Npolimorfismo.aula05.repositorio.Repositorio;
import javacore.Npolimorfismo.aula05.service.RepositorioArquivo;
import javacore.Npolimorfismo.aula05.service.RepositorioBancoDados;
import javacore.Npolimorfismo.aula05.service.RepositorioMemoria;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTest05 {
    public static void main(String[] args) {

//        Repositorio repositorio = new RepositorioArquivo();
//        Repositorio repositorio = new RepositorioMemoria();
        Repositorio repositorio = new RepositorioBancoDados();
        repositorio.salvar();

        List<String> list = new ArrayList<>();
        list.add("Goku");
        list.add("Vegeta");
        list.add("Kuririn");
        System.out.println(list);
    }
}
