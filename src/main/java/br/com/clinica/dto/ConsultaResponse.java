package br.com.clinica.dto;

import br.com.clinica.model.Consulta;
import br.com.clinica.model.StatusConsulta;

import java.time.LocalDateTime;

public class ConsultaResponse {

    private Long id;
    private LocalDateTime dataHora;
    private StatusConsulta status;
    private PacienteResponse paciente;
    private MedicoResponse medico;

    public ConsultaResponse(Consulta consulta) {
        this.id = consulta.getId();
        this.dataHora = consulta.getDataHora();
        this.status = consulta.getStatus();
        this.paciente = new PacienteResponse(consulta.getPaciente());
        this.medico = new MedicoResponse(consulta.getMedico());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public PacienteResponse getPaciente() {
        return paciente;
    }

    public MedicoResponse getMedico() {
        return medico;
    }
}
