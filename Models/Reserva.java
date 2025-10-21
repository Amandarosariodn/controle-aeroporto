package Models;

import java.util.Timer;
import java.util.UUID;

public class Reserva {
    public Timer HoraEntrada;
    public Timer HoraSaida;
    public UUID CodigoVoo;
    public int Assento;

    public Reserva(Timer horaEntrada, Timer horaSaida, UUID codigoVoo, int assento)
    {
        HoraEntrada = horaEntrada;
        HoraSaida = horaSaida;
        CodigoVoo = codigoVoo;
        Assento = assento;
    }

    public Timer getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(Timer HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public Timer getHoraSaida() {
        return HoraSaida;
    }

    public void setHoraSaida(Timer HoraSaida) {
        this.HoraSaida = HoraSaida;
    }

    public UUID getCodigoVoo() {
        return CodigoVoo;
    }

    public void setCodigoVoo(UUID codigoVoo) {
        this.CodigoVoo = codigoVoo;
    }

    public int getAssento() {
        return Assento;
    }

    public void setAssento(int assento) {
        this.Assento = assento;
    }

}
