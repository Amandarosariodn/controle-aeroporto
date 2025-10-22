package Models;

import java.util.Objects;

public class Voo {
  private String numero;
  private String origem;
  private String destino;
  private String horarioPartida; // formato simples; ajustar para java.time.LocalDateTime se desejar
  private String horarioChegada;
  private int maxPassageiros;
  private int passageirosReservados;

  public Voo() {
  }

  public Voo(String numero, String origem, String destino, String horarioPartida, String horarioChegada, int maxPassageiros) {
    this.numero = numero;
    this.origem = origem;
    this.destino = destino;
    this.horarioPartida = horarioPartida;
    this.horarioChegada = horarioChegada;
    this.maxPassageiros = maxPassageiros;
    this.passageirosReservados = 0;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getHorarioPartida() {
    return horarioPartida;
  }

  public void setHorarioPartida(String horarioPartida) {
    this.horarioPartida = horarioPartida;
  }

  public String getHorarioChegada() {
    return horarioChegada;
  }

  public void setHorarioChegada(String horarioChegada) {
    this.horarioChegada = horarioChegada;
  }

  public int getMaxPassageiros() {
    return maxPassageiros;
  }

  public void setMaxPassageiros(int maxPassageiros) {
    this.maxPassageiros = maxPassageiros;
  }

  public int getPassageirosReservados() {
    return passageirosReservados;
  }

  public void setPassageirosReservados(int passageirosReservados) {
    this.passageirosReservados = passageirosReservados;
  }

  public boolean reservar() {
    if (passageirosReservados < maxPassageiros) {
      passageirosReservados++;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Voo{" +
        "numero='" + numero + '\'' +
        ", origem='" + origem + '\'' +
        ", destino='" + destino + '\'' +
        ", partida='" + horarioPartida + '\'' +
        ", chegada='" + horarioChegada + '\'' +
        ", max=" + maxPassageiros +
        ", reservados=" + passageirosReservados +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Voo voo = (Voo) o;
    return Objects.equals(numero, voo.numero);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero);
  }
}