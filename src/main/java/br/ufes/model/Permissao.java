package br.ufes.model;

/**
 *
 * @author Alcebiades
 */
public class Permissao {
    
    private boolean excluir;
    private boolean compartilhar;
    private boolean vizualizar;
    private Imagem imagem;
    private Usuario usuario;

    public Permissao(boolean excluir, boolean compartilhar, boolean vizualizar, Imagem imagem, Usuario usuario) {
        this.excluir = excluir;
        this.compartilhar = compartilhar;
        this.vizualizar = vizualizar;
        this.imagem = imagem;
        this.usuario = usuario;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public boolean isCompartilhar() {
        return compartilhar;
    }

    public void setCompartilhar(boolean compartilhar) {
        this.compartilhar = compartilhar;
    }

    public boolean isVizualizar() {
        return vizualizar;
    }

    public void setVizualizar(boolean vizualizar) {
        this.vizualizar = vizualizar;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
}
