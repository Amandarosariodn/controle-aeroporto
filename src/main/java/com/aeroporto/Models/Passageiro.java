package com.aeroporto.Models;

import java.util.UUID;
public class Passageiro {
  private UUID Id;
  private String Nome;
  private String CPF;
  private String Email;
  private String vooReservado;
  
  public UUID getId() {
    return Id;
  }

  public void setId(UUID id) {
    Id = id;
  }

  public String getNome() {
    return Nome;
  }
  public void setNome(String nome) {
    Nome = nome;
  }
  public String getCPF() {
    return CPF;
  }
  public void setCPF(String cPF) {
    CPF = cPF;
  }
  public String getEmail() {
    return Email;
  }
  public void setEmail(String email) {
    Email = email;
  }
  public String getVooReservado() {
    return vooReservado;
  }
  public void setVooReservado(String vooReservado) {
    this.vooReservado = vooReservado;
  }

  public Passageiro(UUID id, String nome, String cPF) {
    Id = id;
    Nome = nome;
    CPF = cPF;
  }
}
