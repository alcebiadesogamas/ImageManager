package br.ufes.service;

import br.ufes.model.Usuario;
import br.ufes.repository.UsuarioRepository;

/**
 *
 * @author Alcebiades
 */
public class ServiceUsuario {

    private UsuarioRepository userRepo;
    
    public ServiceUsuario() throws Exception{
        userRepo = new UsuarioRepository();
    }

    public boolean loginValidation(Usuario user, String password) {
        if(userRepo.userNameAlreadyExists(user)){
            return false;
        }
        return userRepo.findByLoginandPassword(user, password);
    }
    public boolean createUser(Usuario user, String password){
        return userRepo.createUser(user, password);
    }
    
    public boolean findAnyUser() throws Exception{
        return userRepo.findAnyUser();
    }
    
    public boolean isUserAdmin(Usuario user) throws Exception{
        return userRepo.isAdmin(user);
    }
    
    public Usuario findUser(Usuario user) throws Exception{
        return userRepo.findUser(user);
    }
}
