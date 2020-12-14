package br.ufes.presenter;

import br.ufes.view.ViewManterUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterUsuario {
    private ViewManterUsuario vmu;

    public PresenterManterUsuario(PresenterHome ph) {
        vmu = new ViewManterUsuario();
        vmu.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmu.dispose();  
            }
        });
        
        vmu.getBtnBuscarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        });
        
        vmu.getBrnNovoUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ph.AddTela(new PresenterCadastroUsuario(ph).getVc());
                } catch (Exception ex) {
                    Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        vmu.setVisible(true);
    }

    public ViewManterUsuario getVmu() {
        return vmu;
    }
    
    
    
}
