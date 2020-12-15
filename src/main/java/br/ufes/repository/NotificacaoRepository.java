package br.ufes.repository;

import br.ufes.dao.NotificacaoDAO;
import br.ufes.model.Notificacao;

/**
 *
 * @author Alcebiades
 */
public class NotificacaoRepository {
    private NotificacaoDAO ndao;
    
    public NotificacaoRepository(){
        ndao = new NotificacaoDAO();
    }
    
    public void notificar(Notificacao notify) throws Exception{
        ndao.saveById(notify);
    }
}
