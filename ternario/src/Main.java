import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Qual é seu nome?");
    String nome = sc.next();

    System.out.println("Mas você é o " + nome + " pai, ou o " + nome + " filho?");
    String pai_ou_filho = sc.next();
    
    if (!pai_ou_filho.equals("pai") && !pai_ou_filho.equals("filho")) {
      System.out.println("Responda corretamente: pai ou filho");    
      pai_ou_filho = sc.next();
    }
    
    String resposta = pai_ou_filho.equals("filho") ? "Então você é FEIÃO. Só seu pai é BONITÃO" : "Você é BONITÃO";
    
    System.out.println(resposta);

    sc.close();
  }
}