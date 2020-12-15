package br.ufes.service;

import br.ufes.model.Notificacao;
import br.ufes.repository.NotificacaoRepository;

/**
 *
 * @author Alcebiades
 */
public class ServiceNotificacao {
    private NotificacaoRepository nr;
    
    public ServiceNotificacao(){
        nr = new NotificacaoRepository();
    }
    
    public void notificar(Notificacao n) throws Exception{
        nr.notificar(n);
    }
}
