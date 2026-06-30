package br.com.clinica.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MedicoAtualizacaoRequest {

    @Size(min = 3, message = "O nome deve conter no mínimo 3 caracteres.")
    private String nome;

    private String especialidade;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos numéricos.")
    private String telefone;

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
