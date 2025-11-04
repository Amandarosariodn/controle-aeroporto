package com.aeroporto.Models;
import java.time.LocalDateTime;
import java.util.Random;

public class Voo {  
  private int Id;
  private String CodigoVoo; // agora String com 4 dígitos
  private String Origem;
  private String Destino;
  private LocalDateTime HorarioPartida;
  private LocalDateTime HorarioChegada;
  private int quantidadeAssentos;
  
  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getCodigoVoo() {
    return CodigoVoo;
  }

  public void setCodigoVoo(String codigoVoo) {
    if (codigoVoo == null || !codigoVoo.matches("\\d{4}")) {
      throw new IllegalArgumentException("Código do voo deve conter exatamente 4 dígitos (ex: 0123).");
    }
    CodigoVoo = codigoVoo;
  }

  public String getOrigem() {
    return Origem;
  }

  public void setOrigem(String origem) {
    Origem = origem;
  }

  public String getDestino() {
    return Destino;
  }

  public void setDestino(String destino) {
    Destino = destino;
  }

  public LocalDateTime getHorarioPartida() {
    return HorarioPartida;
  }

  public void setHorarioPartida(LocalDateTime horarioPartida) {
    HorarioPartida = horarioPartida;
  }

  public LocalDateTime getHorarioChegada() {
    return HorarioChegada;
  }

  public void setHorarioChegada(LocalDateTime horarioChegada) {
    HorarioChegada = horarioChegada;
  }

  public int getQuantidadeAssentos() {
    return quantidadeAssentos;
  }

  public void setQuantidadeAssentos(int quantidadeAssentos) {
    this.quantidadeAssentos = quantidadeAssentos;
  }

  // Construtor principal exige código com 4 dígitos
  public Voo(int id, String codigoVoo, String origem, String destino, LocalDateTime horarioPartida, LocalDateTime horarioChegada,
      int quantidadeAssentos) {
    Id = id;
    setCodigoVoo(codigoVoo);
    Origem = origem;
    Destino = destino;
    HorarioPartida = horarioPartida;
    HorarioChegada = horarioChegada;
    this.quantidadeAssentos = quantidadeAssentos;
  }

  // Construtor auxiliar que gera um código aleatório de 4 dígitos
  public Voo(int id, String origem, String destino, LocalDateTime horarioPartida, LocalDateTime horarioChegada,
      int quantidadeAssentos) {
    this(id, gerarCodigoVooAleatorio(), origem, destino, horarioPartida, horarioChegada, quantidadeAssentos);
  }

  // Gera um código entre "0000" e "9999"
  public static String gerarCodigoVooAleatorio() {
    Random rnd = new Random();
    return String.format("%04d", rnd.nextInt(10000));
  }

}
