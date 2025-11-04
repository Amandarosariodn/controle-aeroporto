package com.aeroporto.Menus;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;
import com.aeroporto.Models.SistemaAeroporto;
import com.aeroporto.Models.Voo;
import com.aeroporto.Models.Passageiro;
import com.aeroporto.Models.Reserva;
import com.aeroporto.Models.Checkin;
import java.time.LocalDateTime;

public class MenuInicial {

    private static SistemaAeroporto sistema = new SistemaAeroporto();
    private static Scanner scanner = new Scanner(System.in);


  public static void mostrarMenu(){
  System.out.println("\n--- BEM VINDO AO AEROPORTO ---");
  System.out.println("O que deseja fazer?");
  System.out.println("1 - Realizar reserva de voo");
  System.out.println("2- Realizar check-in");
  System.out.println("3- Visualizar ");
  System.out.println("0 -Sair");
  int opcaoEscolhidaNumerica = -1;
  try {
    opcaoEscolhidaNumerica = scanner.nextInt();
  } catch (java.util.InputMismatchException e) {
    scanner.next(); 
    opcaoEscolhidaNumerica = -1;
  }

  switch (opcaoEscolhidaNumerica) {
    case 1:
     realizarReserva();
     mostrarMenu();
     break;

    case 2:
     realizarCheckIn();
     mostrarMenu();
     break;

    case 3:
     visualizarDetalhes();
     mostrarMenu();
     break;

    case 0: 
    System.out.println("Tchau! <3");
    System.exit(0);
    break;

    default:
    System.out.println("Resposta Inválida. Tente novamente.");
    mostrarMenu();
    break;
  
  }
}

  public static void realizarReserva(){
    System.out.println("\n--- REALIZAR RESERVA ---");
    List<Voo> voosDisponiveis = sistema.getVoos();

    if (voosDisponiveis.isEmpty()) {
        System.out.println("Nenhum voo disponível no momento.");
        return;
    }

    System.out.println("Voos disponíveis:");
    for (int i = 0; i < voosDisponiveis.size(); i++) {
        Voo v = voosDisponiveis.get(i);
        System.out.printf("%d - Código: %s | Origem: %s | Destino: %s | Assentos: %d\n",
            i + 1, v.getCodigoVoo(), v.getOrigem(), v.getDestino(), v.getQuantidadeAssentos());
    }

    System.out.print("Digite o número do voo desejado: ");
    int indiceVoo = -1;
    try {
        indiceVoo = scanner.nextInt() - 1;
    } catch (java.util.InputMismatchException e) {
        scanner.next(); 
        System.out.println("Entrada inválida. Por favor, digite um número.");
        return;
    }

    if (indiceVoo < 0 || indiceVoo >= voosDisponiveis.size()) {
        System.out.println("Opção de voo inválida.");
        return;
    }

    Voo vooSelecionado = voosDisponiveis.get(indiceVoo);

    if (vooSelecionado.getQuantidadeAssentos() <= 0) {
        System.out.println("Desculpe, não há mais assentos disponíveis neste voo.");
        return;
    }

    System.out.print("Digite seu nome: ");
    scanner.nextLine(); 
    String nome = scanner.nextLine();
    System.out.print("Digite seu CPF: ");
    String cpf = scanner.nextLine();

    Passageiro novoPassageiro = new Passageiro(UUID.randomUUID(), nome, cpf);
    Reserva novaReserva = sistema.realizarReserva(novoPassageiro, vooSelecionado);

    if (novaReserva != null) {
        System.out.println("\n--- RESERVA REALIZADA COM SUCESSO! ---");
        System.out.println("Código da Reserva: " + novaReserva.getCodigoReserva());
        System.out.println("Passageiro: " + novaReserva.getPassageiro().getNome());
        System.out.println("Voo: " + novaReserva.getVoo().getOrigem() + " -> " + novaReserva.getVoo().getDestino());
        System.out.println("Assentos restantes no voo: " + vooSelecionado.getQuantidadeAssentos());
    } else {
        System.out.println("Falha ao realizar a reserva.");
    }
  }

  public static void realizarCheckIn(){
    System.out.println("\n--- REALIZAR CHECK-IN ---");
    System.out.print("Digite o Código da Reserva: ");
    scanner.nextLine();
    String codigoReserva = scanner.nextLine();

    Reserva reserva = sistema.buscarReservaPorCodigo(codigoReserva);

    if (reserva == null) {
        System.out.println("Reserva não encontrada ou código inválido.");
        return;
    }

    Checkin checkin = sistema.realizarCheckIn(reserva);

    if (checkin != null) {
        System.out.println("\n--- CHECK-IN REALIZADO COM SUCESSO! ---");
        System.out.println("Código do Check-in: " + checkin.getCodigoCheckin());
        System.out.println("Passageiro: " + checkin.getReserva().getPassageiro().getNome());
        System.out.println("Voo: " + checkin.getReserva().getVoo().getOrigem() + " -> " + checkin.getReserva().getVoo().getDestino());
    } else {
        System.out.println("Falha ao realizar o check-in.");
    }
  }

  public static void visualizarDetalhes(){
    System.out.println("\n--- VISUALIZAR DETALHES ---");
    System.out.println("1 - Voos Disponíveis");
    System.out.println("2 - Reservas Realizadas");
    System.out.println("3 - Check-ins Realizados");
    System.out.print("Escolha uma opção: ");

    int opcao = -1;
    try {
        opcao = scanner.nextInt();
    } catch (java.util.InputMismatchException e) {
        scanner.next(); 
        System.out.println("Entrada inválida. Por favor, digite um número.");
        return;
    }

    switch (opcao) {
        case 1:
            System.out.println("\n--- VOOS DISPONÍVEIS ---");
            for (Voo v : sistema.getVoos()) {
                System.out.printf("Código: %s | Origem: %s | Destino: %s | Partida: %s | Assentos: %d\n",
                    v.getCodigoVoo(), v.getOrigem(), v.getDestino(), v.getHorarioPartida(), v.getQuantidadeAssentos());
            }
            break;
        case 2:
            System.out.println("\n--- RESERVAS REALIZADAS ---");
            if (sistema.getReservas().isEmpty()) {
                System.out.println("Nenhuma reserva realizada.");
            } else {
                for (Reserva r : sistema.getReservas()) {
                    System.out.printf("Código: %s | Passageiro: %s | Voo: %s -> %s | Data: %s\n",
                        r.getCodigoReserva(), r.getPassageiro().getNome(), r.getVoo().getOrigem(), r.getVoo().getDestino(), r.getDataReserva());
                }
            }
            break;
        case 3:
            System.out.println("\n--- CHECK-INS REALIZADOS ---");
            if (sistema.getCheckins().isEmpty()) {
                System.out.println("Nenhum check-in realizado.");
            } else {
                for (Checkin c : sistema.getCheckins()) {
                    System.out.printf("Código: %s | Passageiro: %s | Voo: %s -> %s | Data: %s\n",
                        c.getCodigoCheckin(), c.getReserva().getPassageiro().getNome(), c.getReserva().getVoo().getOrigem(), c.getReserva().getVoo().getDestino(), c.getDataCheckin());
                }
            }
            break;
        default:
            System.out.println("Opção inválida.");
            break;
    }
  }
}
