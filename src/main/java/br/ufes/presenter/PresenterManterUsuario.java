package br.ufes.presenter;

import br.ufes.view.ViewManterUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterUsuario {
    private ViewManterUsuario vmu;

    public PresenterManterUsuario() {
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
                
            }
        });
        
        
        
        vmu.setVisible(true);
    }
    
    
}
