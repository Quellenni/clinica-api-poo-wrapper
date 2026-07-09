package br.com.clinica.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ConsultaRequest {

    @NotNull(message = "O id do paciente é obrigatório.")
    private Long pacienteId;

    @NotNull(message = "O id do médico é obrigatório.")
    private Long medicoId;

    @NotNull(message = "A data e hora da consulta são obrigatórias.")
    @Future(message = "A consulta deve ser agendada para uma data futura.")
    private LocalDateTime dataHora;

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
