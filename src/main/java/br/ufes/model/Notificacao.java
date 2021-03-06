package br.ufes.model;

/**
 *
 * @author Alcebiades
 */
public class Notificacao {
       private int idNotificacao;
    private Usuario usuario;
    private String descricao;

    public Notificacao(int idNotificacao, Usuario usuario, String descricao) {
        this.idNotificacao = idNotificacao;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
