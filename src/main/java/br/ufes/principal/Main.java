package br.ufes.principal;

import br.ufes.dao.ImagemDAO;
import br.ufes.model.Imagem;
import br.ufes.presenter.PresenterHome;
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

    static final File dir = new File("Imagens");

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "jpg", "png" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ImagemDAO imgDao = new ImagemDAO();
        Imagem image = new Imagem();
        if (!imgDao.FindAnyImage()) {
            if (dir.isDirectory()) { // make sure it's a directory
                for (final File f : dir.listFiles(IMAGE_FILTER)) {
                    BufferedImage img = null;

                    try {
                        img = ImageIO.read(f);
                        image.setCaminho((dir + "/" + f.getName()).trim());
                        image.setDescricao(f.getName());
                        imgDao.AddImage(image);
                        /*
                    System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());
                         */

                    } catch (final IOException e) {
                        // handle errors here
                    }
                }
            }
        }

        new PresenterHome().getVh().setVisible(true);
    }

}
