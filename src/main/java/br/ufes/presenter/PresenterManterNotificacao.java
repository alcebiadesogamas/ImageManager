package br.ufes.presenter;

import br.ufes.model.Usuario;
import br.ufes.view.ViewManterNotificacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterNotificacao {
 
    private ViewManterNotificacao vmn;
    
    public PresenterManterNotificacao(){
        vmn = new ViewManterNotificacao();
        
        vmn.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmn.dispose();
            }
        });
        
        
        vmn.setVisible(true);
    }

    public ViewManterNotificacao getVmn() {
        return vmn;
    }
    
    
}
