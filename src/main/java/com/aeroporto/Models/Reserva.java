package com.aeroporto.Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reserva {
  private UUID CodigoReserva;
  private Passageiro Passageiro;
  private Voo Voo;
  private LocalDateTime DataReserva;

  public UUID getCodigoReserva() {
    return CodigoReserva;
  }

  public void setCodigoReserva(UUID codigoReserva) {
    CodigoReserva = codigoReserva;
  }

  public Passageiro getPassageiro() {
    return Passageiro;
  }

  public void setPassageiro(Passageiro passageiro) {
    Passageiro = passageiro;
  }

  public Voo getVoo() {
    return Voo;
  }

  public void setVoo(Voo voo) {
    Voo = voo;
  }

  public LocalDateTime getDataReserva() {
    return DataReserva;
  }

  public void setDataReserva(LocalDateTime dataReserva) {
    DataReserva = dataReserva;
  }

  public Reserva(UUID codigoReserva, Passageiro passageiro, Voo voo, LocalDateTime dataReserva) {
    CodigoReserva = codigoReserva;
    Passageiro = passageiro;
    Voo = voo;
    DataReserva = dataReserva;
  }
}
