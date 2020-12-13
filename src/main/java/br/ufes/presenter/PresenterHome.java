package br.ufes.presenter;

import br.ufes.service.ServiceUsuario;
import br.ufes.view.ViewHome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alcebiades
 */
public class PresenterHome {

    private ViewHome vh;
 

    public PresenterHome() {
        this.vh = new ViewHome();
        
        try {
            this.AddTela(new PresenterLogin(this).getVl());
            vh.getMiConsultarImagem().setVisible(false);
            vh.getMiConsultarUsuario().setVisible(false);
            
        } catch (Exception ex) {
            Logger.getLogger(PresenterHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.vh.getMiSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vh.dispose();
            }
        });

        this.vh.getMiSobre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date a = new Date();
                JOptionPane.showMessageDialog(null, "Alcebiades Lopes Gamas\n"
                        + f.format(a.getTime()), "Autor", 1);
            }
        });
        
        this.vh.getMiConsultarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        

        vh.setVisible(true);
    
    }

    public ViewHome getVh() {
        return vh;
    }
    
    public void AddTela(javax.swing.JInternalFrame jf){
        this.vh.getJdpPrincipal().add(jf);
    }

}
