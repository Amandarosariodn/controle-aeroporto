package com.aeroporto.Models;
import java.time.LocalDateTime;

import java.util.UUID;

public class Voo {  
  private int Id;
  private UUID CodigoVoo;
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

  public UUID getCodigoVoo() {
    return CodigoVoo;
  }

  public void setCodigoVoo(UUID codigoVoo) {
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

  public Voo(int id, UUID codigoVoo, String origem, String destino, LocalDateTime horarioPartida, LocalDateTime horarioChegada,
      int quantidadeAssentos) {
    Id = id;
    CodigoVoo = codigoVoo;
    Origem = origem;
    Destino = destino;
    HorarioPartida = horarioPartida;
    HorarioChegada = horarioChegada;
    this.quantidadeAssentos = quantidadeAssentos;
  }

}
