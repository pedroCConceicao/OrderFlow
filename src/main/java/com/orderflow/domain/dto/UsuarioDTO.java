package com.orderflow.domain.dto;

public class UsuarioDTO {

    private Long codigoUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;

    public UsuarioDTO(Long codigoUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public UsuarioDTO() {
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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "codigoUsuario=" + codigoUsuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", senhaUsuario='" + senhaUsuario + '\'' +
                '}';
    }
}
