package br.ufes.presenter;

import br.ufes.service.ServiceImagem;
import br.ufes.singleton.SingletonImageManipulator;
import br.ufes.view.ViewManterImagens;
import br.ufes.view.proxy.IProxyImagem;
import br.ufes.view.proxy.ImagemProxy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterImagem {

    private ViewManterImagens vmi;
    private ArrayList<ImagemProxy> imagens = new ArrayList<>();
    private ServiceImagem serviceImg; 
    
    private BufferedImage image;
    private SingletonImageManipulator sim;

    public PresenterManterImagem() throws Exception {
        imagens = serviceImg.readFromDataBase();
        
        this.vmi = new ViewManterImagens();
        
        
        SingletonImageManipulator manipulador = SingletonImageManipulator.getInstance();
        BufferedImage imagem;
        int count = 0;
        for(ImagemProxy imp: imagens){
            imagem = manipulador.setImagemDimensao(imp.getCaminho(), 60, 60);
            ImageIcon ii = new ImageIcon(imagem);
            vmi.getListModel().add(count++, ii);
        }
        
        vmi.getJListImagens().setModel(vmi.getListModel());
        
        vmi.getJListImagens().setVisibleRowCount(1);
        vmi.add(new JScrollPane(vmi.getJListImagens()));
        
        
        
    }

    public ViewManterImagens getVmi() {
        return vmi;
    }

}
