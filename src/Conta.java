

public class Conta {

    private String numeroDaConta;
    protected double saldo;
    protected Cliente titular;

    public Conta(String numeroDaConta, Cliente titular) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if(valor >= this.saldo){
            this.saldo -= valor;
            return true;
        } else {
            System.out.print("Saldo insuficiente");
            return false;
        }
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public boolean transferir(Conta destino, double valor){
        if(sacar(valor)){
            destino.depositar(valor);
            return true;
        } else {
            System.out.print(sacar(valor));
            return false;
        }


    }


}
