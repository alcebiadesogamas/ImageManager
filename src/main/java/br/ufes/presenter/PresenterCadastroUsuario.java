package br.ufes.presenter;

import br.ufes.model.Permissao;
import br.ufes.model.Usuario;
import br.ufes.service.ServicePermissao;
import br.ufes.service.ServiceUsuario;
import br.ufes.view.ViewCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alcebiades
 */
public class PresenterCadastroUsuario {
    private ViewCadastro vc;
    private ServiceUsuario serviceUser;
    private ServicePermissao sp;
    private Usuario user;
    
    public PresenterCadastroUsuario(PresenterHome ph) throws Exception {
        vc = new ViewCadastro();
        sp = new ServicePermissao();
        serviceUser = new ServiceUsuario();
        Usuario user = new Usuario();
        
        Permissao p;
        if(!serviceUser.findAnyUser()){
           vc.getRbAdmin().setVisible(false);
           vc.getJlAsk().setVisible(false);
           p = new Permissao(true,true,true,user);
           user.setPermissoes(p);
           user.setAdmin(true);
        }
        vc.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vc.dispose();
            }
        });
        
        vc.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isValidPassword(new String(vc.getPfSenha().getPassword()), new String(vc.getPfConfirmarSenha().getPassword()))){
                    
                    if(vc.getRbAdmin().isSelected())
                        user.setAdmin(true);
                    user.setNome(vc.getTfNome().getText()); 
                     
                    
                    if(serviceUser.createUser(user, new String(vc.getPfSenha().getPassword()))){
                        try {
                           
                            sp.createPermissao(user);
                        } catch (Exception ex) {
                            Logger.getLogger(PresenterCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null,"Usuario Criado Com Sucesso!");
                        vc.dispose();
                        try {
                            ph.AddTela(new PresenterLogin(ph).getVl());
                            //ph.getVh().getMiConsultarImagem().setVisible(true);
                            //ph.getVh().getMiConsultarUsuario().setVisible(true);
                        } catch (Exception ex) {
                            Logger.getLogger(PresenterCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario Existente");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Senha deve conter entre 4 e 12 caracters!");
                }
            }
        });
        vc.setVisible(true);
    }
    
    public boolean isValidPassword(String a, String b){
        return a.equals(b)&&isValidPassword(a);
    }
     public boolean isValidPassword(String pass) {
        return (pass.length() >= 4 && pass.length() <= 12);
    }

    public ViewCadastro getVc() {
        return vc;
    }
     
    
}
