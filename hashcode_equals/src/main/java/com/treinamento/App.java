package com.treinamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        List<Conta> contas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        int contador = 0;

        for (int i = 1; i <= 5; i++) {
            Cliente cliente = new Cliente(i, "Chico"+i);
            clientes.add(cliente);
        }

        contas.add(new Conta(1, "corrente", clientes.get(contador)));
        contador++;
        contas.add(new Conta(2, "corrente", clientes.get(contador)));
        contador++;
        contas.add(new Conta(3, "corrente", clientes.get(contador)));
        contador++;
        contas.add(new Conta(4, "corrente", clientes.get(contador)));
        contador++;
        contas.add(new Conta(5, "corrente", clientes.get(contador)));

        contador = 0;

        for (int i = 1; i <= 5; i++) {
            Conta novaConta = new Conta(i, "corrente", clientes.get(contador));
            contas.add(novaConta);
            contador++;
        }

        //contas.forEach(System.out :: println);

        contas.stream()
            .filter(c -> c.getNumeroDeConta().equals(2))
            .forEach(Conta :: imprime);

        /*for (Conta conta : contas) {
            if (conta.getNumeroDeConta() == 2) {
                System.out.println(conta);

            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (contas.get(i).equals(contas.get(j))) {
                    System.out.println("Conta (" +i+") " + contas.get(i) + " é igual a Conta (" +j+") " + contas.get(j));
                }
            }
        }*/
    }
}
