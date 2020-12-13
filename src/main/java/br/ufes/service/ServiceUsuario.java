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
                    
        return userRepo.findByLoginandPassword(user, password);
    }
    public boolean createUser(Usuario user, String password){
        return userRepo.createUser(user, password);
    }
    
}
