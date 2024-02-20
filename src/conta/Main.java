package conta;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Conta c1 = new Conta(1, 123, 1, "Sabrina", 250000.f);

        c1.visualizar();
        c1.setAgencia(456);
        System.out.println(c1.getAgencia());

        System.out.println("_________________");
        System.out.println("      Menu       ");
        System.out.println("  1. Saldo      ");
        System.out.println("  2. Saque      ");
        System.out.println("  3. Deposito   ");
        System.out.println("  0. Sair       ");
        System.out.println("_________________");

        int opcao = read.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Seu saldo é: " + c1.getSaldo());
                break;

            case 2:
                System.out.println("Qual o valor? ");
                float valorSaque = read.nextInt();
                c1.sacar(valorSaque);
                System.out.println("Seu saldo é: " + c1.getSaldo());
                break;

            case 3:
                System.out.println("Qual o valor? ");
                float valorDeposito = read.nextFloat();
                c1.depositar(valorDeposito);
                System.out.println("Seu saldo é: " + c1.getSaldo());
                break;

            case 0:
                System.out.println("Programa Finalizado");
                break;
        }

        ContaPoupanca cp1 = new ContaPoupanca(012, 456, 2,"Kauan Rodrigues",5000f);

        System.out.println(cp1.visualizar());
        System.out.println("Sua renda mensal é: " + cp1.rendaJuros()+"\n");

        ContaCorrente cc1 = new ContaCorrente (013, 456, 1,"Afonso Manoel ",10000f);
        System.out.println("\n\n" + cp1.visualizar());
        System.out.println("Seu limite é : " + cc1.getLimite());

    }

}
