package Menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Voo;

public class MenuInicial {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void MostrarMenu() {
        System.out.println("BEM VINDO AO AEROPORTO ----");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Realizar reserva de voo");
        System.out.println("2 - Realizar check-in");
        System.out.println("3 - Visualizar voos");
        System.out.println("0 - Sair");
        String opcaoEscolhida = SCANNER.next();
        int opcaoEscolhidaNumerica = Integer.parseInt(opcaoEscolhida);

        switch (opcaoEscolhidaNumerica) {
            case 1:
                RealizarReserva();
                break;
            case 2:
                RealizarCheckIn();
                break;
            case 3:
                VisualizarDetalhes();
                break;
            case 0:
                System.out.println("Tchau! <3");
                System.exit(0);
                break;
            default:
                System.out.println("Resposta Inválida");
                System.exit(1);
                break;
        }
    }

    private static List<Voo> carregarVoosExemplo() {
        List<Voo> voos = new ArrayList<>();
        voos.add(new Voo("AA101", "São Paulo", "Rio de Janeiro", "2023-10-01 08:00", "2023-10-01 09:30", 100));
        voos.add(new Voo("BB202", "Rio de Janeiro", "Brasília", "2023-10-01 10:00", "2023-10-01 11:30", 80));
        voos.add(new Voo("CC303", "Brasília", "Salvador", "2023-10-01 12:00", "2023-10-01 14:00", 120));
        return voos;
    }

    public static void RealizarReserva() {
        List<Voo> voos = carregarVoosExemplo();

        System.out.println("\nVoos disponíveis:");
        for (Voo v : voos) {
            System.out.println(v);
        }

    System.out.print("Digite o número do voo para reserva: ");
    String numero = SCANNER.next();

        for (Voo v : voos) {
            if (v.getNumero().equalsIgnoreCase(numero)) {
                if (v.reservar()) {
                    System.out.println("Reserva confirmada para o voo " + numero + ".");
                } else {
                    System.out.println("Voo lotado.");
                }
                return;
            }
        }
        System.out.println("Voo não encontrado.");
    }

    public static void RealizarCheckIn() {
        List<Voo> voos = carregarVoosExemplo();

        System.out.print("Digite o número do voo para check-in: ");
        String numero = SCANNER.next();

        for (Voo v : voos) {
            if (v.getNumero().equalsIgnoreCase(numero)) {
                if (v.getPassageirosReservados() > 0) {
                    System.out.println("Check-in realizado para o voo " + numero + ".");
                } else {
                    System.out.println("Nenhuma reserva encontrada para este voo.");
                }
                return;
            }
        }
        System.out.println("Voo não encontrado.");
    }

    public static void VisualizarDetalhes() {
        List<Voo> voos = carregarVoosExemplo();
        System.out.println("\nVoos Disponíveis:");
        for (Voo v : voos) {
            System.out.println(v);
        }
    }

}


