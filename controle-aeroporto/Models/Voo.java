package Models;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class Voo {  
  private int Id;
  public UUID CodigoVoo;
  private String Origem;
  private String Destino;
  private Timer HorarioPartida;
  private Timer HorarioChegada;
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

  public Timer getHorarioPartida() {
    return HorarioPartida;
  }

  public void setHorarioPartida(Timer horarioPartida) {
    HorarioPartida = horarioPartida;
  }

  public Timer getHorarioChegada() {
    return HorarioChegada;
  }

  public void setHorarioChegada(Timer horarioChegada) {
    HorarioChegada = horarioChegada;
  }

  public int getQuantidadeAssentos() {
    return quantidadeAssentos;
  }

  public void setQuantidadeAssentos(int quantidadeAssentos) {
    this.quantidadeAssentos = quantidadeAssentos;
  }

  public Voo(int id, UUID codigoVoo, String origem, String destino, Timer horarioPartida, Timer horarioChegada,
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