package conta;

import conta.model.ContaPoupanca;

import java.util.Scanner;

public class Menu {
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		boolean continuar = true;

		while (continuar) {
			System.out.println("********************************************");
			System.out.println("                   RV Bank                  ");
			System.out.println("********************************************");
			System.out.println("*                                          *");
			System.out.println("*     1. Criar Conta                        ");
			System.out.println("*     2. Listar Todas as Contas            *");
			System.out.println("*     3. Buscar Conta por Numero           *");
			System.out.println("*     4. Atualizar Dados da Conta          *");
			System.out.println("*     5. Apagar Conta                      *");
			System.out.println("*     6. Sacar                             *");
			System.out.println("*     7. Depositar                         *");
			System.out.println("*     8. Transferir valores entre contas   *");
			System.out.println("*     9. Sair                              *");
			System.out.println("********************************************");
			System.out.println("*                                          *");
			System.out.println("*     Escolha a Opção desejada             *");
			System.out.println("*                                          *");
			System.out.println("********************************************");

			int opcao;
			opcao = read.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Você escolheu criar conta");
					// método criar conta
					break;
				case 2:
					System.out.println("Lista de Todas as Contas");
					break;
				case 3:
					// Buscar Conta por Numero
					break;
				case 4:
					// Atualizar Dados da Conta
					break;
				case 5:
					// Apagar Conta
					break;
				case 6:
					// Sacar
					break;
				case 7:
					// Depositar
					break;
				case 8:
					// Transferir valores entre contas
					break;
				case 9:
					continuar = false; // Definindo continuar como false para sair do loop
					break;
				default:
					System.out.println("Opção inválida");
			}
		}

		// Teste Conta Corrente
		ContaPoupanca cp1 = new ContaPoupanca(1, 123, 2, "Samael", 4000.0f, 21);
		cp1.visualizar();
		cp1.getAniversario();
	}
}