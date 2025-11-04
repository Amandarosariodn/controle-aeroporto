package com.aeroporto.Models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.aeroporto.Models.Voo;
import com.aeroporto.Models.Passageiro;
import com.aeroporto.Models.Reserva;
import com.aeroporto.Models.Checkin;
import java.util.List;
import java.util.UUID;

public class SistemaAeroporto {
    private List<Voo> voos;
    private List<Passageiro> passageiros;
    private List<Reserva> reservas;
    private List<Checkin> checkins;

    public SistemaAeroporto() {
        this.voos = new ArrayList<>();
        this.passageiros = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.checkins = new ArrayList<>();
      
        inicializarDados();
    }

    private void inicializarDados() {

        Voo voo1 = new Voo(
            1,
            UUID.randomUUID(),
            "São Paulo (SP)",
            "Rio de Janeiro (RJ)",
            LocalDateTime.of(2025, 12, 25, 10, 0),
            LocalDateTime.of(2025, 12, 25, 11, 0),
            20
        );
        this.voos.add(voo1);

        Voo voo2 = new Voo(
            2,
            UUID.randomUUID(),
            "Belo Horizonte (MG)",
            "Salvador (BA)",
            LocalDateTime.of(2025, 12, 26, 14, 30),
            LocalDateTime.of(2025, 12, 26, 16, 30),
            100
        );
        this.voos.add(voo2);

        Voo voo3 = new Voo(
            3,
            UUID.randomUUID(),
            "xique-xique (BA)",
            "Florianópolis (SC)",
            LocalDateTime.of(2025, 12, 27, 9, 15),
            LocalDateTime.of(2025, 12, 27, 10, 0),
            50
        );
        this.voos.add(voo3);


    }

    public List<Voo> getVoos() {
        return voos;
    }

    public Voo buscarVooPorCodigo(String codigoVooString) {
        try {
            UUID codigoVoo = UUID.fromString(codigoVooString);
            for (Voo voo : voos) {
                if (voo.getCodigoVoo().equals(codigoVoo)) {
                    return voo;
                }
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        return null;
    }

    public Reserva buscarReservaPorCodigo(String codigoReservaString) {
        try {
            UUID codigoReserva = UUID.fromString(codigoReservaString);
            for (Reserva reserva : reservas) {
                if (reserva.getCodigoReserva().equals(codigoReserva)) {
                    return reserva;
                }
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        return null;
    }

    public Reserva realizarReserva(Passageiro passageiro, Voo voo) {
     
        if (voo.getQuantidadeAssentos() > 0) {
            Reserva novaReserva = new Reserva(UUID.randomUUID(), passageiro, voo, LocalDateTime.now());
            this.reservas.add(novaReserva);
            voo.setQuantidadeAssentos(voo.getQuantidadeAssentos() - 1);
     
            if (!this.passageiros.contains(passageiro)) {
                this.passageiros.add(passageiro);
            }
            return novaReserva;
        }
        return null; 
    }

    public Checkin realizarCheckIn(Reserva reserva) {
    
        Checkin novoCheckin = new Checkin(UUID.randomUUID(), reserva, LocalDateTime.now());
        this.checkins.add(novoCheckin);
        return novoCheckin;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Checkin> getCheckins() {
        return checkins;
    }
}
