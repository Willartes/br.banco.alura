import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ServicoBancario cadastroCliente = new ServicoBancario(listaClientes);

        int opcao;
        boolean continua = true;
        while (continua){
            String cabecalho = """
                    ---------------------------------
                        SISTEMA SIMPLES DE BANCO
                    
                        1- Cadastrar Cliente
                        2- Criar Conta
                        3- Listar Clientes e Contas
                        4- Sacar
                        5- Depositar
                        6- Transferir
                        7- Saldo
                        0- Sair
                    ---------------------------------
                    """;

            System.out.printf(cabecalho);
            System.out.printf("-> ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao){
                case 1:
                    cadastroCliente.cadastrarCliente(leia);
                    break;
                case 2:
                    cadastroCliente.criarConta(leia);
                    break;
                case 3:
                    cadastroCliente.listarClientes();
                    break;
                case 4:
                    cadastroCliente.sacar(leia);
                    break;
                case 5:
                    cadastroCliente.depositar(leia);
                    break;
                case 6:
                    cadastroCliente.transferir(leia);
                    break;
                case 7:
                    cadastroCliente.saldo(leia);
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
            if(opcao == 0){
                continua = false;
            }
        }


    }
}