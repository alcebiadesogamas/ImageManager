package br.ufes.model;

import br.ufes.service.ServiceImagem;
import br.ufes.proxy.IProxyImagem;

/**
 *
 * @author Alcebiades
 */
public class Imagem implements IProxyImagem {

    private int id;
    private String caminho;

    public Imagem(int id,String caminho) {
        this.caminho = caminho;
        this.id = id;

    }

    public Imagem(String caminho) {
        this.caminho = caminho;
    }
    
    public Imagem() {
    }


    @Override
    public void request() {
        
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
