package br.ufes.repository;

import br.ufes.dao.UsuarioDAO;
import br.ufes.model.Usuario;


/**
 *
 * @author Alcebiades
 */
public class UsuarioRepository {
    private final UsuarioDAO udao;

    public UsuarioRepository() throws Exception {
        udao = new UsuarioDAO();
    }
    
    public boolean findByLoginandPassword(Usuario user, String password)
    {
        try {            
            return udao.findUserByNameAndPassword(user.getNome(), password);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
   
    public boolean userNameAlreadyExists(Usuario user){
       try {            
            return udao.findUserByName(user.getNome());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean createUser(Usuario user, String pass)
    {
        try {
            udao.createUser(user, pass);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    public boolean findAnyUser() throws Exception{
       return udao.findAnyUser();
    }
}
