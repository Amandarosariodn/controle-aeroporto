package com.aeroporto.Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Checkin {
  private UUID CodigoCheckin;
  private Reserva Reserva;
  private LocalDateTime DataCheckin;

  public UUID getCodigoCheckin() {
    return CodigoCheckin;
  }

  public void setCodigoCheckin(UUID codigoCheckin) {
    CodigoCheckin = codigoCheckin;
  }

  public Reserva getReserva() {
    return Reserva;
  }

  public void setReserva(Reserva reserva) {
    Reserva = reserva;
  }

  public LocalDateTime getDataCheckin() {
    return DataCheckin;
  }

  public void setDataCheckin(LocalDateTime dataCheckin) {
    DataCheckin = dataCheckin;
  }

  public Checkin(UUID codigoCheckin, Reserva reserva, LocalDateTime dataCheckin) {
    CodigoCheckin = codigoCheckin;
    Reserva = reserva;
    DataCheckin = dataCheckin;
  }
}
