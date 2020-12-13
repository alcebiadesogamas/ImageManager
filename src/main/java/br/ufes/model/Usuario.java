package br.ufes.model;

import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private boolean admin = false;
    private ArrayList<Permissao> permissoes = new ArrayList<>();

    public Usuario(int id, String nome, String senha, boolean admin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.admin = admin;
    }

    public Usuario() {
        
    }  
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(ArrayList<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
    
}
