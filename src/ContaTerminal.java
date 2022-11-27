import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaTerminal {
    private static Scanner leitor = new Scanner(System.in);
    private static List<Conta> contas = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        int opcao = 0;

        while (true) {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Abrir uma conta");
            System.out.println("2 - Movimentar uma conta");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = leitor.nextInt();

            switch(opcao){
                case 0:
                    break;
                case 1:
                    abrirConta();
                    break;
                case 2:
                    movimentarConta();
                    break;
                default:
                    System.out.println("Opção incorreta!");
            }
            if (opcao == 0)
                break;
        }
    }

    private static void abrirConta(){
        System.out.println("Abertura de uma conta:");
        
        System.out.print("Número da Agência (xxxx): ");
        int agencia = leitor.nextInt();
        System.out.println(agencia);
        System.out.print("Número da Conta (...xxxx-x): ");
        String numeroConta = leitor.next();
        System.out.println(numeroConta);
        System.out.print("Nome do Cliente: ");
        String cliente = leitor.next();
        System.out.println(cliente);

        Conta conta = new Conta(agencia, numeroConta, cliente);
        if(contas.contains(conta))
            System.out.println("Já existe uma conta com essa agência e número.");
        else{
            contas.add(conta);
            System.out.println(conta.toString());
        }
    }

    private static void movimentarConta(){
        int opcao = 0;

        System.out.println("Informe os dados da tua Conta:");
        Conta conta = pesquisarConta();
        if(conta == null)
            return;

        double valor = 0.0;

        do{
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Consultar Saldo");
            System.out.println("0 - Retornar ao menu anterior");
            System.out.print("Opção: ");
            opcao = leitor.nextInt();

            switch(opcao){
                case 0:
                    break;
                case 1:
                    System.out.print("Informe o valor do depósito: ");
                    valor = leitor.nextDouble();
                    if(conta.depositar(valor))
                        System.out.println("Depósito realizado com sucesso.");
                    else
                        System.out.println("O depósito não foi realizado.");
                    break;
                case 2:
                    System.out.print("Informe o valor do saque: ");
                    valor = leitor.nextDouble();
                    if(conta.depositar(valor))
                        System.out.println("Saque realizado com sucesso.");
                    else
                        System.out.println("O saque não foi realizado.");
                    break;
                case 3:
                    System.out.println("Informe a conta de destino:");
                    Conta contaDestino = pesquisarConta();
                    if(contaDestino != null){
                        System.out.print("Informe o valor da transferência: ");
                        valor = leitor.nextDouble();
                        if(conta.transferir(valor, contaDestino))
                            System.out.print("Transferência realizada com sucesso.");
                        else
                            System.out.print("A transferência não foi realizada.");
                    }
                    break;
                case 4:
                    System.out.println("Saldo da conta: " + conta.getSaldo());
                    break;
                default:
                    System.out.println("Opção incorreta!");
            }
            if(opcao == 0)
                break;
        }while(true);
    }

    private static Conta pesquisarConta(){
        System.out.print("Informe o número da agência: ");
        int agencia = leitor.nextInt();
        System.out.print("Informe o número da conta: ");
        String numeroConta = leitor.next();

        Conta conta = new Conta(agencia, numeroConta);
        int i = contas.indexOf(conta);
        Conta retorno = contas.get(i);
        return retorno;
    }
}
