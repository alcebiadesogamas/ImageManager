package br.ufes.repository;

import br.ufes.dao.PermissaoDAO;
import br.ufes.model.Usuario;

/**
 *
 * @author Alcebiades
 */
public class PermissaoRepository {
    private PermissaoDAO pdao;

    public PermissaoRepository() {
        pdao = new PermissaoDAO();
    }
    
    public Usuario findAllPermissions(Usuario user) throws Exception
    {
        return pdao.getAllPermissionOf(user);
    }
    
}
