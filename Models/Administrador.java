
package Models;

import java.util.*;

//Responsável pelas reservas pendentes.

public class Administrador {
    private String Nome;
    private String Senha;
    private Queue<Reserva> FilaReservasPendentes; // fila de reservas pendentes
    private List<Voo> ListaVoos; // lista de voos disponíveis

    public Administrador(String nome, String senha, Queue<Reserva> filaReservasPendentes, List<Voo> listaVoos) {
        this.nome = nome;
        this.senha = senha;
        this.filaReservasPendentes = filaReservasPendentes;
        this.listaVoos = listaVoos;
    }

    // login
    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    // O administrador pode ter acesso manual as reservas
    public void processarReservasManualmente() {
        Scanner sc = new Scanner(System.in);

        if (filaReservasPendentes.isEmpty()) {
            System.out.println("✅ Não há reservas pendentes no momento.");
            return;
        }

        System.out.println("\n=== PROCESSAMENTO MANUAL DE RESERVAS ===");

        while (!filaReservasPendentes.isEmpty()) {
            Reserva reserva = filaReservasPendentes.peek(); // visualiza a próxima reserva (sem remover ainda)
            Voo voo = buscarVoo(reserva.getNumeroVoo());

            if (voo == null) {
                System.out.println("❌ Voo " + reserva.getNumeroVoo() + " não encontrado. Reserva removida da fila.");
                filaReservasPendentes.poll();
                continue;
            }

            System.out.println("\nPróxima reserva pendente:");
            System.out.println("Passageiro: " + reserva.getPassageiro().getNome());
            System.out.println("Voo: " + reserva.getNumeroVoo());
            System.out.println("Origem: " + voo.getOrigem() + "  →  Destino: " + voo.getDestino());
            System.out.println("Capacidade atual: " + voo.getPassageirosReservados() + "/" + voo.getMaxPassageiros());

            if (voo.getPassageirosReservados() >= voo.getMaxPassageiros()) {
                System.out.println("O voo está cheio! Reserva não pode ser confirmada.");
                filaReservasPendentes.poll(); // remove da fila
                continue;
            }

            System.out.print("Deseja confirmar esta reserva? (S/N): ");
            String resposta = sc.nextLine().trim().toUpperCase();

            if (resposta.equals("S")) {
                boolean confirmado = voo.reservar();
                if (confirmado) {
                    System.out.println("Reserva confirmada para " + reserva.getPassageiro().getNome() + " no voo "
                            + voo.getNumero());
                } else {
                    System.out.println("Não foi possível confirmar a reserva!! (voo cheio).");
                }
            } else {
                System.out.println("Reserva rejeitada.");
            }

            filaReservasPendentes.poll(); // remove da fila, pois foi processada
        }

        System.out.println("\n Todas as reservas pendentes foram processadas.");
    }

    // Informa os voos disponíveis
    public void exibirVoosDisponiveis() {
        System.out.println("\n--- Voos Disponíveis ---");
        for (Voo voo : listaVoos) {
            if (voo.getPassageirosReservados() < voo.getMaxPassageiros()) {
                System.out.println(voo);
            }
        }
    }

    /**
     * Informa voos que estão cheios.
     */
    public void exibirVoosCheios() {
        System.out.println("\n--- Voos Cheios ---");
        for (Voo voo : listaVoos) {
            if (voo.getPassageirosReservados() >= voo.getMaxPassageiros()) {
                System.out.println(voo);
            }
        }
    }

    /**
     * Busca um voo pelo número.
     */
    private Voo buscarVoo(String numeroVoo) {
        for (Voo v : listaVoos) {
            if (v.getNumero() != null && v.getNumero().equals(numeroVoo)) {
                return v;
            }
        }
        return null;
    }
}
