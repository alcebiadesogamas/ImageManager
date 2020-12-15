package br.ufes.service;

import br.ufes.dao.ImagemDAO;
import br.ufes.dao.UsuarioDAO;
import br.ufes.model.Permissao;
import br.ufes.model.Usuario;
import br.ufes.repository.PermissaoRepository;
import br.ufes.proxy.ImagemProxy;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class ServicePermissao {
    private PermissaoRepository pr;
    private ImagemDAO imgDao;
    private UsuarioDAO udao;

    public ServicePermissao() {
        this.pr = new PermissaoRepository();
        imgDao = new ImagemDAO();
        udao = new UsuarioDAO();
    }
    
    public void createPermissao(Usuario user) throws Exception
    {   
        Usuario temp = udao.findIdUserByName(user);
        ArrayList<ImagemProxy> aux = imgDao.findAll();
        for(ImagemProxy im : aux)
            pr.createPermissão(temp, im);
    }
    
    public Usuario findPermissions(Usuario user, ImagemProxy img) throws Exception
    {
       return pr.findAllPermissions(user,img);
    }
}
