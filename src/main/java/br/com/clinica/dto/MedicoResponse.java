package br.com.clinica.dto;


import br.com.clinica.model.Medico;


public class MedicoResponse {

    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String telefone;

    public MedicoResponse(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.especialidade = medico.getEspecialidade();
        this.telefone = medico.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }
}