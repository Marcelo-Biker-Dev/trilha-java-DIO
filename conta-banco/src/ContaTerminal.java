import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        int numero;
        String agencia;
        String nomeCliente;
        Double saldo = 177.77;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da conta!");
        numero = scanner.nextInt();

        System.out.println("Por favor, digite o número da agência!");
        agencia = scanner.next();

        System.out.println("Por favor, digite o nome do cliente!");
        nomeCliente = scanner.next();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +
        ", conta " + numero + " e seu saldo R$ " + saldo + " já está disponível para saque.");

        scanner.close();
    }
}
