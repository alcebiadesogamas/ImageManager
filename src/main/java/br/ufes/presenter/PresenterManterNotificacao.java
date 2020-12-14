package br.ufes.presenter;

import br.ufes.model.Usuario;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterNotificacao {
    private int idNotificacao;
    private Usuario usuario;
    private String descricao;

    public PresenterManterNotificacao(int idNotificacao, Usuario usuario, String descricao) {
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
