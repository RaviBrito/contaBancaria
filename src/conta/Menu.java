package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	static Scanner read = new Scanner(System.in);




	public static void main(String[] args) {

		ContaController conta = new ContaController();
		int opcao, numeroConta, agencia, tipo = 0, aniversario,deposita,numeroInput, numeroDestino ;
		String titular;
		float saldo =0, limite,valorDeposito,salario, valor;


		try {
			opcao = read.nextInt();
		}catch (InputMismatchException e){
			System.out.println("\n Digite valos inteiros ");
			read.nextLine();
			opcao=0;
		}


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


			opcao = read.nextInt();

			switch (opcao) { //Escolha do Menu
				case 1: //CRIAR CONTA
					System.out.println("\n\n Criar conta");
					System.out.println("Digite o numero da agencia:");
					agencia= read.nextInt();
					System.out.println("Escreva o nome do Titular da conta: ");
					read.skip("\\R?");   //skip para ignorar "\r" quebra de linha e ler palavras compostas
					titular = read.nextLine();

					do {
						System.out.println("** Digite o tipo de conta **");
						System.out.println("*  1. Criar Conta Corrente *");
						System.out.println("*  2. Criar Conta Poupança *");
						tipo=read.nextInt();
					}while (tipo <1 && tipo > 2);

					System.out.println("Digite o saldo da conta");
					saldo= read.nextFloat();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite o limite de crédito (R$): ");
							limite = read.nextFloat();
							System.out.println("Digite seu salario (R$): ");
							salario = read.nextFloat();
							conta.cadastrar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo, limite, salario));
						}
						case 2-> {
							System.out.println("Digite o aniversario da Conta: ");
							aniversario = read.nextInt();
							conta.cadastrar(new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

							}
						}
				/*	//LIBERANDO LIMITE BASEADO NO SALARIO
							switch (tipo) {
								case 1: {
									System.out.println("Digite seu salario:");
									salario = read.nextInt();
									if  (salario == 1500){
										limite=500;
										System.out.println("O limite liberado pra voce é: " + limite);
									} else if (salario <= 2500) {
										limite=800;
									} else if (salario <= 3800 ) {
										limite=1200;
									} else if (salario <= 6000) {
										limite = 2000;

									} else if (salario > 6100) {
										limite= 2500;

									} else {
										limite=0;
										System.out.println("Para liberar seu credito converse com seu gerente");
									}

									//DEPOSITANDO VALOR NO CADASTRO DA CONTA
									System.out.println("Deseja depositar um valor na conta? S/N ");
									System.out.println("1. SIM");
									System.out.println("2. NÃO");
									deposita= read.nextInt ();

									numeroConta= conta.gerarNumero(); //salvar numero da conta pra usar deposito
									do {
										if (deposita == 1) {
											System.out.println("Digite o Valor de Deposito:");
											valorDeposito = read.nextFloat();
											conta.depositar(numeroConta, valorDeposito);
											saldo = valorDeposito;

											System.out.println("Seu saldo é: "+ saldo);

										} else {
											saldo = 0;
										}

									}while (deposita <1 || deposita >2);
									conta.cadastrar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo,
											limite, salario));


									break;

									}



								//DEPOSITAR VALOR NO CADASTRO
									System.out.println("Deseja depositar um valor na conta? S/N ");
									System.out.println("1. SIM");
									System.out.println("2. NÃO");
									deposita= read.nextInt ();
									numeroConta= conta.gerarNumero(); //salvar numero da conta pra usar deposito

									do {
										if (deposita == 1) {
											System.out.println("Digite o Valor de Deposito:");
											valorDeposito = read.nextFloat();
											conta.depositar(numeroConta, valorDeposito);
											saldo = valorDeposito;

											System.out.println("Seu saldo é: "+ saldo);

										} else {
											saldo = 0;
										}

									}while (deposita <1 || deposita >2);

							conta.cadastrar(new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo,
									aniversario));
						}*/

					keyPress();
					break;
				case 2: //listar contas
					System.out.println("Lista de Todas as Contas \n\n");
					conta.listarTodas();
					keyPress();
					break;
				case 3: // Buscar Conta por Numero
					System.out.println("Buscar Conta por Numero \n\n");
					System.out.println("Digite o numero da conta: ");

					numeroInput = read.nextInt();
					conta.buscarNaCollection(numeroInput);
					keyPress();

					break;
				case 4:// Atualizar Dados da Conta
					System.out.println("Atualizar Dados da Conta");
					System.out.println("Digite o numero da conta a ser atualizada:");
					numeroConta= read.nextInt();

					var buscarConta = conta.buscarNaCollection(numeroConta);

					if (buscarConta != null) {
						System.out.println("Digite o numero da agencia:");
						agencia = read.nextInt();
						System.out.println("Digite o nome do Titular");
						read.skip("\\R?");
						titular = read.nextLine();
						System.out.println("Digite saldo da conta:");
						saldo = read.nextFloat();
						switch (tipo) {
							case 1 -> {
								System.out.println("Digite o limite de crédito (R$): ");
								limite = read.nextFloat();
								System.out.println("Digite seu salario (R$): ");
								salario = read.nextFloat();
								conta.cadastrar(new ContaCorrente(conta.gerarNumero(), agencia, tipo, titular, saldo, limite, salario));
							}
							case 2 -> {
								System.out.println("Digite o aniversario da Conta: ");
								aniversario = read.nextInt();
								conta.cadastrar(new ContaPoupanca(conta.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

							}
							default -> {
								System.out.println("Tipo de conta invalido");
							}
						}
					}else {
						System.out.println("Conta não encontrada");


						keyPress();
						break;
					}

					/* FEATURES
					System.out.println("Escolha qual dado que atualizar");
					System.out.println("1.Agencia ");
					System.out.println("2.Tipo");
					System.out.println("3.Titular");
					System.out.println("4.Limite");//FEATURE SO APARECE ESSA OPÇÃO SE FOR CC
					System.out.println("5.Aniversário");//FEATURE SO APARECE ESSA OPÇÃO SE FOR CP

					opcao= read.nextInt();

					switch (opcao){
						case 1://Agencia
							System.out.println("Digite o numero da nova Agencia: ");
							numero= read.nextInt();
							conta.buscarNaCollection(numeroInput).setAgencia(numero);

							break;

						case 2:// tipo
							System.out.println("Sua conta é  " + conta.buscarNaCollection(numeroInput).getTipo() +
									". Deseja trocar? \n\n1.Sim\n\n2.Não");

							numero= read.nextInt();
							conta.buscarNaCollection(numero).setAgencia(numeroInput);

						case 3:
						case 4:
						case 5:
					}
					break;*/
				case 5:
					// Apagar Conta
					System.out.println("Apagar Conta");
					System.out.println("Digite o numero da conta: ");
					numeroConta= read.nextInt();

					conta.deletar(numeroConta);

					keyPress();
					break;
				case 6:
					// Sacar
					System.out.println("Saque");
					System.out.println("Digite o numero da conta");
					numeroConta=read.nextInt();
					do {
						System.out.println("Digite o valor: ");
						valor= read.nextFloat();
					}while(valor <=0);
					conta.sacar(numeroConta,valor);

					keyPress();
					break;
				case 7:
					// Depositar
					System.out.println("Depósito");
					numeroConta= read.nextInt();
					do {
						System.out.println("Digite o valor: ");
						valor= read.nextFloat();
					}while(valor <=0);
					conta.depositar(numeroConta,valor);


					keyPress();
					break;
				case 8:
					// Transferir valores entre contas
					System.out.println("Transferencia");
					System.out.println("Digite o numero da conta de Origem: ");
					numeroConta= read.nextInt();
					System.out.println("Digite a conta de Destino: ");
					int contaDestino;
					contaDestino= read.nextInt();
					do {
						System.out.println("Digite o valor: ");
						valor= read.nextFloat();
					}while(valor <=0);
					conta.transferir(numeroConta,contaDestino,valor);
					keyPress();
					break;
				case 9:
					continuar = false; // Definindo continuar como false para sair do loop
					keyPress();
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
		//teste lista
		ContaCorrente cc1 = new ContaCorrente(1,12,1,"Samuel Cardoso", 5000, 1000,7500.0f);
		ContaCorrente cc2 = new ContaCorrente(2,12,1,"Afonso Rodrigues", 1000, 5000,2500.0f);
		ContaPoupanca cp1 = new ContaPoupanca(1,12,1,"Rafael Cardoso", 5000, 15);
		ContaPoupanca cp2 = new ContaPoupanca(1,12,1,"Suzana Guedes", 10000, 10);
	}
	public static void keyPress(){
		try {
			System.out.println("\n\n Pressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Voce precionou uma tecla diferente");

		}
	}

}