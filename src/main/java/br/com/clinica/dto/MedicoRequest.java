package br.com.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MedicoRequest {
    
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, message = "O nome deve conter no mínimo 3 caracteres.")
    private String nome;

    @NotBlank(message = "O crm é obrigatório.")
    @Pattern(regexp = "\\d{4,10}", message = "O crm deve conter entre 4 e 10 dígitos numéricos.")
    private String crm;

    @NotBlank(message = "A especialidade é obrigatória.")
    private String especialidade;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos numéricos.")
    private String telefone;

    public String getNome(){
        return nome;
    }

    public String getCrm(){
        return crm;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public String getTelefone(){
        return telefone;
    }

}
