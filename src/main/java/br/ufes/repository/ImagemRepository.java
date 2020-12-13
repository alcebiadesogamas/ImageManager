package br.ufes.repository;

import br.ufes.dao.ImagemDAO;
import br.ufes.model.Imagem;
import br.ufes.view.proxy.IProxyImagem;
import br.ufes.view.proxy.ImagemProxy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Alcebiades
 */
public class ImagemRepository {
    private ImagemDAO imgDao;
    public ImagemRepository(){
        imgDao = new ImagemDAO();
    }
    
    public ArrayList<IProxyImagem> readFromDisk(String path) throws Exception{
         File dir = new File(path);

        final String[] EXTENSIONS = new String[]{"jpg", "png"};
        // filter to identify images based on their extensions
        final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

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
        
        ArrayList<String> caminhos = new ArrayList<>();
        Imagem imge = new Imagem();
        if (!imgDao.FindAnyImage()) {
            if (dir.isDirectory()) { // make sure it's a directory
                for (final File f : dir.listFiles(IMAGE_FILTER)) {
                    BufferedImage img = null;

                    try {
                        img = ImageIO.read(f);
                        imge.setCaminho((dir + "/" + f.getName()).trim());
                        caminhos.add((dir + "/" + f.getName()).trim());
                        imgDao.AddImage(imge);
                    } catch (final IOException e) {
                        // handle errors here
                    }
                }
            }
        }
        
       if (dir.isDirectory()) { // make sure it's a directory
                for (final File f : dir.listFiles(IMAGE_FILTER)) {
                    BufferedImage img = null;

                    try {
                        img = ImageIO.read(f);
                        imge.setCaminho((dir + "/" + f.getName()).trim());
                        caminhos.add((dir + "/" + f.getName()).trim());
                    } catch (final IOException e) {
                        // handle errors here
                    }
                }
            }
    }
}
