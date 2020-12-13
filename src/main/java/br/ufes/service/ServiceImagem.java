package br.ufes.service;

import br.ufes.repository.ImagemRepository;

/**
 *
 * @author Alcebiades
 */
public class ServiceImagem {
    ImagemRepository imgRepo;
    public ServiceImagem(){
        imgRepo = new ImagemRepository();
    }
    public void getFromDisk(String path) throws Exception{
        imgRepo.readFromDisk(path);
    }
}
