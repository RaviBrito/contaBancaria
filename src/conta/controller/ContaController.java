package conta.controller;
import conta.model.Conta;
import conta.repository.ContaRepository;
import java.util.ArrayList;
import java.util.Scanner;


public class ContaController implements ContaRepository {
    Scanner read = new Scanner(System.in);

    private ArrayList <Conta>  listaContas = new ArrayList<>();
    int numero=0;
    int numeroInput;
    int numConta;



    public void procurarPorNumero(int numero){
        var conta = buscarNaCollection(numero);
        if (conta!= null){
            conta.visualizar();
        }else {
            System.out.println("A conta" + numero + "não foi encontrado");
        }

    }
    public void listarTodas() {
        for(var conta : listaContas){
            conta.visualizar();
        }

    }
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("Conta numero: " + conta.getNumConta() + " ,foi criada com sucesso");

    }
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumConta());

        if (buscaConta != null){
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("Produto codigo:" + conta.getNumConta()+ " foi atualizado com sucesso");
        } else {
            System.out.println("Produto codigo:" + conta.getNumConta()+ " não foi encontrado");
        }


    }
    public void deletar(int numero) {
        var conta =buscarNaCollection(numero);
        if (conta != null){
            if (listaContas.remove(conta) == true){
                System.out.println("Conta numero" + numero + "foi deletada com sucesso");
            }else {
                System.out.println("Conta numero" + numero + " não foi encontrada");
            }
        }

    }
    public void sacar(int numero, float valor){
        var conta = buscarNaCollection(numero);

        if (conta != null){
            if (conta.sacar(valor) == true)
                System.out.println("\nSaque na conta" +numero +  "efetuada com sucesso");

        }else {
            System.out.println("\n  Conta numero" + numero + "não foi encontrado");
        }

    }
    public void depositar(int numero, float valor){
        var conta=buscarNaCollection(numero);
        if (conta != null){
            conta.depositar(valor);
            System.out.println("\n Deposito na Conta numero: " + numero + " realizado com sucesso");
        }else {
            System.out.println("\n Conta numero " + numero + "não foi encontrada");
        }

    }
    public void transferir(int numeroOrigem, int numeroDestino, float valor){
        var contaOrigem =buscarNaCollection(numeroOrigem);
        var contaDestino = buscarNaCollection(numeroDestino);
        if (contaOrigem != null && contaDestino != null){
            if (contaOrigem.sacar(valor) == true){
                contaDestino.depositar(valor);
                System.out.println("A transferencia foi realizada com sucesso");
            }else {
                System.out.println("Conta de origem e/ou Destino não foram localizadas");
            }
        }

    }
    public int gerarNumero(){
        return ++ numero;
    }
    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas ){
            if (conta.getNumConta() == numero) {
                return conta;
            }
        } return null;


    }

}



