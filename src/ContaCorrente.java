
public class ContaCorrente extends Conta {

    private double taxaManutencao;

    public ContaCorrente(String numeroDaConta, Cliente titular) {
        super(numeroDaConta, titular);
        this.taxaManutencao = 10.0;
    }

    @Override
    public String toString(){
        return String.format("""
                *Conta corrente*
                Numero da conta: %s
                Saldo:           %.2f
                """, getNumeroDaConta(), getSaldo());
    }
}
