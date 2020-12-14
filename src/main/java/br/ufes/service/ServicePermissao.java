package br.ufes.service;

import br.ufes.model.Usuario;
import br.ufes.repository.PermissaoRepository;

/**
 *
 * @author Alcebiades
 */
public class ServicePermissao {
    private PermissaoRepository pr;

    public ServicePermissao() {
        this.pr = new PermissaoRepository();
    }
    
    public Usuario findPermissions(Usuario user) throws Exception
    {
       return pr.findAllPermissions(user);
    }
}
