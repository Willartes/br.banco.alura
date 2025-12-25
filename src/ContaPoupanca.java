public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca(String numeroDaConta, Cliente titular) {
        super(numeroDaConta, titular);
        this.rendimento = 0.01;
    }

    public void aplicarRendimento(){
        this.saldo *= rendimento;
    }

    @Override
    public String toString(){
        return String.format("""
                *Conta Poupança*
                Número da conta: %s
                Saldo:           %.2f
                """, getNumeroDaConta(), getSaldo());
    }
}
