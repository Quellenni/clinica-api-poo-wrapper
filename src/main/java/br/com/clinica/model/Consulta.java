package br.com.clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    public Consulta() {
    }

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, StatusConsulta status) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = status;
    }

    public void cancelar() {
        this.status = StatusConsulta.CANCELADA;
    }

    public Long getId() { return id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public StatusConsulta getStatus() { return status; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
}
