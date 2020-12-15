package br.ufes.repository;

import br.ufes.dao.PermissaoDAO;
import br.ufes.model.Imagem;
import br.ufes.model.Permissao;
import br.ufes.model.Usuario;
import br.ufes.proxy.ImagemProxy;

/**
 *
 * @author Alcebiades
 */
public class PermissaoRepository {
    private PermissaoDAO pdao;

    public PermissaoRepository() {
        pdao = new PermissaoDAO();
    }
    
    public void createPermissão(Usuario user, ImagemProxy img) throws Exception
    {
        pdao.AddPermission(user, img);
    }
    
    public Usuario findAllPermissions(Usuario user, ImagemProxy img) throws Exception
    {
        return pdao.getAllPermissionOf(user,img);
    }
    
}
