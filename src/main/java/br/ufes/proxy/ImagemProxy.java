package br.ufes.proxy;

import br.ufes.model.Imagem;

/**
 *
 * @author Alcebiades
 */
public class ImagemProxy implements IProxyImagem {

    private Imagem imgreal;

    private int id;
    private String caminho;

    public ImagemProxy(int id, String caminho) {
        this.id = id;
        this.caminho = caminho;
    }

    public ImagemProxy(String caminho) {
        this.caminho = caminho;
    }

    public ImagemProxy() {
    }
    
    
    
    @Override
    public void request() {
        if(this.imgreal == null)
            this.imgreal = new Imagem(this.caminho);
        imgreal.request();
    }

    public Imagem getImgreal() {
        return imgreal;
    }

    public void setImgreal(Imagem imgreal) {
        this.imgreal = imgreal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    
}
