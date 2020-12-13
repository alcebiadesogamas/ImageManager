package br.ufes.service;

import br.ufes.repository.ImagemRepository;

import br.ufes.view.proxy.ImagemProxy;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class ServiceImagem {

    ImagemRepository imgRepo;

    public ServiceImagem() {
        imgRepo = new ImagemRepository();
    }

    public ArrayList<ImagemProxy> getFromDisk(String path) throws Exception {

        ArrayList<ImagemProxy> imgs = imgRepo.readFromDisk(path);
        return imgs;
    }

    public ArrayList<ImagemProxy> readFromDataBase() throws Exception {
        ArrayList<ImagemProxy> imgs = imgRepo.readFromDataBase();
        return imgs;
    }
}
