package conta.model;


public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo){
        super(numero, agencia, tipo, titular, saldo);
        this.rendaJuros();
    }

     public float rendaJuros(){
        float saldo = this.getSaldo();
        float juros= 0.5f;
        float renda = (saldo * juros) / 100;
        return renda;
     }
}
