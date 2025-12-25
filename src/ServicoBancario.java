import java.util.ArrayList;
import java.util.Scanner;

public class ServicoBancario {

    private ArrayList<Cliente> listaClientes;

    public ServicoBancario(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void criarConta(Scanner leia) {

        Cliente cliente = verificaCliente(leia);
        if(cliente == null){
            return;
        }

        boolean jaTemCorrente = cliente.getContas().stream()
                .anyMatch(c -> c instanceof ContaCorrente);

        boolean jaTemPoupanca = cliente.getContas().stream()
                .anyMatch(c -> c instanceof ContaPoupanca);
        String contas = """
                1 - CONTA CORRENTE
                2 - CONTA POUPANÇA
                """;

        System.out.println(contas);

        int tipoConta = leia.nextInt();
        leia.nextLine(); // consumir quebra de linha

        if(tipoConta == 1 && jaTemCorrente){
            System.out.println("O cliente já possui uma conta corrente!");
            return;
        }
        if(tipoConta == 2 && jaTemPoupanca){
            System.out.println("O cliente já possui uma conta poupança!");
            return;
        }
        System.out.print("Número da conta: ");
        String numeroConta = leia.nextLine();

        Conta conta = (tipoConta == 1)
                ? new ContaCorrente(numeroConta, cliente)
                : new ContaPoupanca(numeroConta, cliente);

        cliente.adcionarConta(conta);

        System.out.println("Conta criada com sucesso!");

    }

    public void cadastrarCliente(Scanner leia) {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = leia.nextLine();

        System.out.print("CPF: ");
        String cpf = leia.nextLine();
        if(cpf == null){
            System.out.println("CPF cadastrado!");
        }
        Cliente cliente = new Cliente(nomeCliente, cpf);
        listaClientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes(){
        if(listaClientes == null){
            System.out.println("Não há cliente cadastrado!");
        }
        for(Cliente cliente : listaClientes){
            System.out.println("***************************");
            System.out.println("Cliente: " + cliente.getNome());
            for (Conta conta : cliente.getContas()){
                System.out.printf(" - " + conta.toString());
                System.out.println("***************************");
            }
        }
        System.out.println();
    }

    public void sacar(Scanner leia){
        Conta conta = verificaConta(leia);
        if(conta == null){
            return;
        }
        System.out.printf("Valor do saque: ");
        double valorSaque = leia.nextDouble();
        leia.nextLine();
        double valorSaldo = conta.saldo;
        String opcao = null;
        if(valorSaque > valorSaldo){
            String avisoSaldoInsuficiente = """
                    SALDO INSUFICIENTE
                    Digite (S) para sacar: 
                    """;
            System.out.printf(avisoSaldoInsuficiente);
            opcao = leia.next().toUpperCase();

        }
        if( opcao.equals("S")){
            conta.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }

    public void depositar(Scanner leia){
        Conta conta = verificaConta(leia);
        if(conta == null){
            return;
        }
        System.out.printf("Valor do depósito: ");
        double valorDeposito = leia.nextDouble();
        leia.nextLine();

        conta.depositar(valorDeposito);
        System.out.println("Depósito realizado com sucesso!");

    }

    public void transferir(Scanner leia){
        Conta conta = verificaConta(leia);
        if(conta == null){
            return;
        }
        System.out.print("CPF de quem recebe: ");
        String cpfDestino = leia.nextLine();

        Cliente clienteDestino = listaClientes.stream()
                .filter(c -> c.getCpf().equalsIgnoreCase(cpfDestino))
                .findFirst()
                .orElse(null);
        if(clienteDestino == null){
            System.out.println("Cliente destinatário não encontrado!");
            return;
        }

        System.out.printf("Número da conta de destino: ");
        String numeroDaContaDestino = leia.nextLine();

        Conta contaDestino = clienteDestino.getContas().stream()
                .filter(c -> c.getNumeroDaConta().equalsIgnoreCase(numeroDaContaDestino))
                .findFirst()
                .orElse(null);
        if(contaDestino == null){
            System.out.println("Conta de destino não encontrada!");
            return;
        }

        System.out.printf("Valor da transferência: ");
        double valorTransferencia = leia.nextDouble();
        leia.nextLine();

        if (conta.transferir(contaDestino, valorTransferencia)) {
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência não realizada!");
        }
    }

    public void saldo(Scanner leia){
        Conta conta = verificaConta(leia);
        if(conta == null){
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println();
        }
    }
    public Cliente verificaCliente(Scanner leia){
        System.out.printf("CPF do Cliente: ");
        String cpf = leia.nextLine();
        Cliente cliente = listaClientes.stream()
                .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
        if(cliente == null){
            System.out.println("Cliente não encontrado!");
            return null;
        }
        return cliente;
    }
    public Conta verificaConta(Scanner leia){
        Cliente cliente =  verificaCliente(leia);
        if(cliente == null){
            System.out.println("Digite um nome para Cliente!");
        }

        System.out.printf("Número da conta: ");
        String numeroDaConta = leia.nextLine();


        Conta conta = cliente.getContas().stream()
                .filter(c -> c.getNumeroDaConta().equalsIgnoreCase(numeroDaConta))
                .findFirst()
                .orElse(null);


        if(conta == null){
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println("Saldo atual: " + conta.getSaldo());
        }
        return conta;
    }
}
