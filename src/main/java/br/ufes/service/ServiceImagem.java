package br.ufes.service;

import br.ufes.repository.ImagemRepository;

import br.ufes.proxy.ImagemProxy;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class ServiceImagem {

    private ImagemRepository imgRepo;
    private ArrayList<ImagemProxy> imagens;
    
    public ServiceImagem() {
        imgRepo = new ImagemRepository();
        imagens = new ArrayList<>();
        
    }

    public ArrayList<ImagemProxy> getImagens() {
        return imagens;
    }

    public ArrayList<ImagemProxy> readFromDisk() throws Exception {

        ArrayList<ImagemProxy> imgs;
        imgs = imgRepo.readFromDisk();
        
        return imgs;

    }

    public ArrayList<ImagemProxy> readFromDataBase() throws Exception {
        ArrayList<ImagemProxy> imgs = imgRepo.readFromDataBase();
        return imgs;
    }
    
    public ImagemProxy findImage(String path) throws Exception{
        return imgRepo.findImagem(path);
    }
}
