public class Conta {

  private int agencia;
  private String conta;
  private String cliente;
  private double saldo;

  public Conta(int agencia, String numero){
    this.agencia = agencia;
    this.conta = numero;
    saldo = 0.0;
  }

  public Conta(int agencia, String numero, String cliente){
    this(agencia, numero);
    this.cliente = cliente;
  }

  public boolean depositar(double valor){
    if(valor < 0)
      return false;

    saldo += valor;
    return true;    
  }

  public boolean sacar(double valor){
    if(valor < 0 && saldo < valor)
      return false;

    saldo -= valor;
    return true;
  }

  public boolean transferir(double valor, Conta destino){
    if(!sacar(valor))
      return false;

    if(destino.depositar(valor))
      return true;
    else {
      depositar(valor);
      return false;
    }
  }

  public double getSaldo(){
    return saldo;
  }

  @Override
  public boolean equals(Object obj){
    if(obj == null || !(obj instanceof Conta))
      return false;
    
    if(obj == this)
      return true;
    
    Conta conta = (Conta) obj;
    boolean retorno = agencia == conta.agencia && this.conta.equals(conta.conta);
    return retorno;
  }

  @Override
  public int hashCode(){
    int retorno = (agencia + conta).hashCode();
    return retorno;
  }

  @Override
  public String toString(){
    return "Olá " + cliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +", conta " + conta + " e seu saldo "+ saldo + " já está disponível para saque";
  }
}
