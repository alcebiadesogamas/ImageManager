package br.ufes.presenter;

import br.ufes.model.Usuario;
import br.ufes.service.ServiceUsuario;
import br.ufes.view.ViewCadastro;
import br.ufes.view.ViewHome;
import br.ufes.view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Alcebiades
 */
public class PresenterLogin {

    private Usuario user; //model
    private ServiceUsuario userservice;//service
    private ViewLogin vl;//view

    public PresenterLogin() throws Exception {
        this.vl = new ViewLogin();
        this.user = new Usuario();
        this. userservice = new ServiceUsuario();
        
        this.vl.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastro().setVisible(true);
                vl.dispose();

            }
        });

        this.vl.getBtnEntrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setNome(vl.getTfNome().getText());
                
                user.setSenha(new String(vl.getPfSenha().getPassword())); 
                if (isValidPassword(new String(vl.getPfSenha().getPassword()))) {
                    if (userservice.loginValidation(user, new String(vl.getPfSenha().getPassword()))) {
                        
                        
                        vl.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha incoreto(s)");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Senha deve Ter entre 4 e 12 caracteres");
                }
            }
        });

        this.vl.setVisible(true);
    }

    public boolean isValidPassword(String pass) {
        return (pass.length() >= 4 && pass.length() <= 12);
    }

    public ViewLogin getVl() {
        return vl;
    }
    
    
}
