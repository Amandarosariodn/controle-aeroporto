package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Voo {
  
  private int Id;
  public UUID CodigoVoo;
  private String Origem;
  private String Destino;

  public Voo(int id, String origem, String destino) {
    Id = id;
    CodigoVoo = codigoVoo;
    Origem = origem;
    Destino = destino;
  }
  List<String> voos = new ArrayList<>();
  voos.add(new Voo(1, "sp", "es"));

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
 
}