package br.com.clinica.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PacienteAtualizacaoRequest {
    
    @Size(min = 3, message = "O nome deve conter no mínimo 3 caracteres.")
    private String nome;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos numéricos.")
    private String telefone;

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
}
