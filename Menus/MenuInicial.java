package Menus;
import java.util.Scanner;
import java.util.UUID;

import javax.swing.undo.StateEdit;

import java.util.ArrayList;
import java.util.List;

import Models.Voo;

public class MenuInicial {


  public static void MostrarMenu(){
  System.out.println("BEM VINDO AO AEROPORTO ----");
  System.out.println("O que deseja fazer?");
  System.out.println("1 - Realizar reserva de voo");
  System.out.println("2- Realizar check-in");
  System.out.println("3- Visualizar ");
  System.out.println("0 -Sair");
  Scanner scanner = new Scanner(System.in);
  String opcaoEscolhida = scanner.next();
  int opcaoEscolhidaNumerica = Integer.parseInt(opcaoEscolhida);

  switch (opcaoEscolhidaNumerica) {
    case 1:
     RealizarReserva();break;

    case 2:
     RealizarCheckIn();break;

    case 3:
     VisualizarDetalhes();break;

    case 0: 
    System.out.println("Tchau! <3");
    System.exit(opcaoEscolhidaNumerica);break;

    default:
    System.out.println("Resposta Inválida");
    System.exit(opcaoEscolhidaNumerica);break;
  
  }
}

  public static void ValidarTamanhoCodigoVoo(UUID codigoVoo){
    List<Voo> voos = new ArrayList<>();
    voos.Add(1, "Es", "SP", 12, 23,1324 );

  }

  public String RealizarReserva(){


  }

}

