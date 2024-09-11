package com.orderflow.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODUSR")
    private Long codigoUsuario;

    @Column(name = "NOMUSR")
    private String nomeUsuario;

    @Column(name = "EMLUSR")
    private String emailUsuario;

    @Column(name = "PSWUSR")
    private String senhaUsuario;

    public Usuario() {

    }

    public Usuario(Long codigoUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
