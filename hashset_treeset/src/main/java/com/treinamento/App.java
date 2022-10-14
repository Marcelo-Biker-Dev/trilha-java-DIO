package com.treinamento;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {

    // METODO "COMPARE_TO" OBRIGADO POR IMPLEMENTAR A INTERFACE COMPARABLE,
    // QUE FOI NECESSARIO A IMPLEMENTAR-LA PARA PODER USAR A ARVORE TREE_SET

    public static void main(String[] args) {

        /*Set<CoffeeBeans> graos = new HashSet<>();

        graos.add(new CoffeeBeans("Brazil"));
        graos.add(new CoffeeBeans("Colombia"));
        graos.add(new CoffeeBeans("Vietnam"));
        graos.add(new CoffeeBeans("Indonesia"));
        graos.add(new CoffeeBeans("Ethiopia"));

        System.out.println(graos);

        TreeSet<CoffeeBeans> granos = new TreeSet<>();

        granos.add(new CoffeeBeans("Brazil"));
        granos.add(new CoffeeBeans("Colombia"));
        granos.add(new CoffeeBeans("Vietnam"));
        granos.add(new CoffeeBeans("Indonesia"));
        granos.add(new CoffeeBeans("Ethiopia"));

        System.out.println(granos);*/

        Set<String> coresDaBandeiraDoBrasil = new TreeSet<>(Arrays.asList("verde", "amarelo", "azul", "branco"));
        System.out.println(coresDaBandeiraDoBrasil);
    }
}
