package br.ufes.principal;

import br.ufes.singleton.SingletonImageManipulator;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Alcebiades
 */

public class GerarJListImagens {

    private GerarJListImagens gerarJListImgagens;

    public GerarJListImagens(String path) {
        //path = "Imagens"; //código do banco para pegar todas imagens do diretório
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        DefaultListModel listModel = new DefaultListModel();
        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++) {

            String name = listOfFiles[i].toString();
            System.out.println(name);

            if (name.endsWith("jpg") || name.endsWith("png") || name.endsWith("jpeg")) {
                SingletonImageManipulator manipulador = SingletonImageManipulator.getInstance();
                BufferedImage imagem;
                imagem = manipulador.setImagemDimensao(listOfFiles[i].getAbsolutePath(), 60, 60);
                ImageIcon ii = new ImageIcon(imagem);
                listModel.add(count++, ii);
            }
        }
        JList lsm = new JList(listModel);
        lsm.setVisibleRowCount(1);

        frame.add(new JScrollPane(lsm));

        frame.pack();
        frame.setVisible(true);
    }
}

