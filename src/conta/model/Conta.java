package conta.model;
public abstract class  Conta {

    private int numConta;
    private int agencia;
    private int tipo;
    private String titular;
    private float saldo;

    //Construtor
    public Conta(int numConta, int agencia, int tipo, String titular, float saldo) { //pede atributos
        this.numConta = numConta;
        this.agencia = agencia;
        this.tipo = tipo;
        this.titular = titular;
        this.saldo = saldo;
    }


    //getters and setters
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String nome) {
        this.titular = nome;
    }


    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void visualizar(){
        String tipoConta="";
        switch (this.tipo){
            case 1:
                tipoConta = "Conta Corrente";
                break;
            case 2:
                tipoConta= "Conta Poupança";
                break;
        }
        System.out.println("*****************");
        System.out.println("Dados da Conta: ");
        System.out.println("*****************");
        System.out.println("Numero da conta: " + this.numConta);
        System.out.println("Agencia da conta: " + this.agencia);
        System.out.println("Tipo da conta: " + tipoConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);

    }
    //Métodos || ações
    public void depositar (float valor){
        this.setSaldo(this.saldo + valor);
    }
    public boolean sacar(float valor){
        if (this.saldo < valor)
            return false;

        this.setSaldo(this.saldo - valor);
        return true;


    }

}

