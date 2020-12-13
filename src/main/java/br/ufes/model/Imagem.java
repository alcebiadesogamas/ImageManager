package br.ufes.model;

import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class Imagem {
    private int id;
    private String caminho;
    private String descricao;
   // private ArrayList<Permissao> permissoes = new ArrayList<>();
    
    public Imagem(String caminho, String descricao) {
        this.caminho = caminho;
        this.descricao = descricao;
    }

    public Imagem() {
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   /* public ArrayList<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(ArrayList<Permissao> permissoes) {
        this.permissoes = permissoes;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
