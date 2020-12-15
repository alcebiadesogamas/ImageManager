package br.ufes.presenter;

import br.ufes.service.ServiceImagem;
import br.ufes.service.ServicePermissao;
import br.ufes.singleton.SingletonImageManipulator;
import br.ufes.view.ViewManterImagens;
import br.ufes.proxy.ImagemProxy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterImagem {

    private final ViewManterImagens vmi;
    private ArrayList<ImagemProxy> imagens = new ArrayList<>();
    private ServiceImagem serviceImg;

    public PresenterManterImagem(PresenterHome ph) throws Exception {
        this.serviceImg = new ServiceImagem();
        this.vmi = new ViewManterImagens();
        vmi.getJlImagemNormal().setText("");

        imagens = serviceImg.readFromDisk();

        DefaultListModel listModel = new DefaultListModel();
        SingletonImageManipulator manipulador = SingletonImageManipulator.getInstance();
        BufferedImage imagem;
        int count = 0;
        for (ImagemProxy imp : imagens) {
            imagem = manipulador.setImagemDimensao(imp.getCaminho(), 60, 60);
            ImageIcon ii = new ImageIcon(imagem);
            listModel.add(count++, ii);
        }

        vmi.getJListImagens().setModel(listModel);

        vmi.getJListImagens().setVisibleRowCount(1);

        vmi.getBtnVizualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicePermissao sp = new ServicePermissao();
                ServiceImagem si = new ServiceImagem();

                String path = imagens.get(vmi.getJListImagens().getSelectedIndex()).getCaminho();
                try {
                    if (sp.findPermissions(ph.getUsuarioAtual(), si.findImage(path)).getPermissoes().isVizualizar()) {
                        ImageIcon iconLogo = new ImageIcon(path);

                        vmi.getJlImagemNormal().setIcon(iconLogo);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(PresenterManterImagem.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        this.vmi.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmi.dispose();
            }
        });

        this.vmi.setVisible(true);

    }

    public ViewManterImagens getVmi() {
        return vmi;
    }

}
