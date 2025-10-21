package Models;

public class Checkin {

  private String CPF;
  private String Bagagem;
  private String vooReservado;
  
  public String getCPF() {
    return CPF;
  }
  public void setCPF(String cPF) {
    CPF = cPF;
  }
  public String getBagagem() {
    return Bagagem;
  }
  public void setBagagem(String bagagem) {
    Bagagem = bagagem;
  }
  public String getVooReservado() {
    return vooReservado;
  }
  public void setVooReservado(String vooReservado) {
    this.vooReservado = vooReservado;

  }
}
