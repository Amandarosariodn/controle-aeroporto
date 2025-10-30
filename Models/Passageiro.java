package Models;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Passageiro {
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    private Voo vooReservado;          
    private boolean reservaConfirmada;
    private boolean checkInRealizado;
    private LocalDateTime horarioReserva;

    private static final Pattern EMAIL_REGEX = Pattern.compile(
        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public Passageiro(String nome, int idade, String cpf, String email) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
        setEmail(email);
        this.vooReservado = null;
        this.reservaConfirmada = false;
        this.checkInRealizado = false;
        this.horarioReserva = null;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome.trim();
    }

    public int getIdade() { return idade; }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }
        this.idade = idade;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) {
        if (cpf == null) throw new IllegalArgumentException("CPF não pode ser nulo.");
        String apenasDigitos = cpf.replaceAll("\\D", "");
        if (apenasDigitos.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }
        this.cpf = apenasDigitos;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email == null || !EMAIL_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public Voo getVooReservado() { return vooReservado; }

    public void reservarVoo(Voo voo) {
        if (voo == null) {
            throw new IllegalArgumentException("Voo não pode ser nulo.");
        }
        this.vooReservado = voo;
        this.reservaConfirmada = false;
        this.checkInRealizado = false;
        this.horarioReserva = LocalDateTime.now();
    }

    public void confirmarReserva() {
        if (vooReservado == null) {
            throw new IllegalStateException("Não existe reserva para confirmar.");
        }
        this.reservaConfirmada = true;
    }

    public boolean isReservaConfirmada() { return reservaConfirmada; }

    public void realizarCheckIn() {
        if (vooReservado == null) {
            throw new IllegalStateException("Reserva não existente.");
        }
        if (!reservaConfirmada) {
            throw new IllegalStateException("Reserva ainda não confirmada.");
        }
        if (checkInRealizado) {
            throw new IllegalStateException("Check-in já realizado.");
        }
        this.checkInRealizado = true;
    }

    public boolean isCheckInRealizado() { return checkInRealizado; }

    public LocalDateTime getHorarioReserva() { return horarioReserva; }

    @Override
    
    public String toString() {
        return "Passageiro{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", cpf='" + cpf + '\'' +
               ", email='" + email + '\'' +
               ", vooReservado=" + (vooReservado != null ? vooReservado.getNumeroVoo() : "nenhum") +
               ", reservaConfirmada=" + reservaConfirmada +
               ", checkInRealizado=" + checkInRealizado +
               ", horarioReserva=" + horarioReserva +
               '}';
    }
}
