package br.ufes.presenter;

import br.ufes.model.Usuario;
import br.ufes.service.ServiceUsuario;

import br.ufes.view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alcebiades
 */
public class PresenterLogin {

    private Usuario user; //model
    private ServiceUsuario userservice;//service
    private ViewLogin vl;//view

    public PresenterLogin(PresenterHome ph) throws Exception {
        this.vl = new ViewLogin();
        this.user = new Usuario();
        this.userservice = new ServiceUsuario();
        if(userservice.findAnyUser()){
            vl.getBtnCadastrar().setVisible(false);
        }
        this.vl.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ph.AddTela(new PresenterCadastroUsuario(ph).getVc());

                } catch (Exception ex) {
                    Logger.getLogger(PresenterLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                        ph.getVh().getMiConsultarImagem().setVisible(true);
                        ph.getVh().getMiConsultarUsuario().setVisible(true);
                        ph.getVh().getJlNomeUsuarioLogado().setText(user.getNome());
                        String adm = "Não";
                       
                        try {
                            if(userservice.isUserAdmin(user))
                                adm = "Sim";
                        } catch (Exception ex) {
                            Logger.getLogger(PresenterLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        ph.getVh().getJlTrueFalseAdm().setText(adm);
                        ph.setUsuarioAtual(user);
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
