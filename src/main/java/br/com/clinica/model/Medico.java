package br.com.clinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crm;
    private String especialidade;
    private String telefone;

    public Medico() {
    }

    public Medico(String nome, String crm, String especialidade, String telefone) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public void atualizarDados(String nome, String especialidade, String telefone){
        if(nome != null && !nome.isBlank()){
            this.nome = nome;
        }

        if(especialidade != null && !especialidade.isBlank()){
            this.especialidade = especialidade;
        }

        if(telefone != null && !telefone.isBlank()){
            this.telefone = telefone;
        }
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCrm() { return crm; }
    public String getEspecialidade() { return especialidade; }
    public String getTelefone() {return telefone;}

}
