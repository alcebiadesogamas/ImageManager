package br.ufes.model;

import br.ufes.service.ServiceImagem;
import br.ufes.view.proxy.IProxyImagem;

/**
 *
 * @author Alcebiades
 */
public class Imagem implements IProxyImagem {

    private int id;
    private String caminho;

    public Imagem(int id,String caminho, String descricao) {
        this.caminho = caminho;
        this.id = id;
        try {
            new ServiceImagem().getFromDisk(caminho);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Imagem() {
    }


    @Override
    public void request() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
