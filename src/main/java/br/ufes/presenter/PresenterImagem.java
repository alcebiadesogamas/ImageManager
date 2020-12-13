package br.ufes.presenter;

import br.ufes.singleton.SingletonImageManipulator;
import br.ufes.view.ViewManterImagens;
import br.ufes.view.proxy.IProxyImagem;
import br.ufes.view.proxy.ImagemProxy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Alcebiades
 */
public class PresenterImagem {

    private ViewManterImagens vmi;
    private ArrayList<IProxyImagem> imagens = new ArrayList<>();
    
    private BufferedImage image;
    private SingletonImageManipulator sim;

    public PresenterImagem() {
        this.vmi = new ViewManterImagens();
        
        sim.setImagemDimensao(caminhoImg,104, 104)
        this.vmi.getjLabel1().setIcon(new ImageIcon());
    }

}
