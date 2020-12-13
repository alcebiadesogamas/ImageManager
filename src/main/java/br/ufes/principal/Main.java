package br.ufes.principal;

import br.ufes.dao.ImagemDAO;
import br.ufes.model.Imagem;
import br.ufes.presenter.PresenterHome;
import br.ufes.view.proxy.IProxyImagem;
import br.ufes.view.proxy.ImagemProxy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Alcebiades
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {


        new PresenterHome().getVh().setVisible(true);
    }

}
