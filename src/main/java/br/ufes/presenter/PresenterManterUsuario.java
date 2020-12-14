package br.ufes.presenter;

import br.ufes.model.Usuario;
import br.ufes.service.ServicePermissao;
import br.ufes.service.ServiceUsuario;
import br.ufes.view.ViewManterUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alcebiades
 */
public class PresenterManterUsuario {

    private ViewManterUsuario vmu;
    private ServiceUsuario su;
    private DefaultTableModel tableModel;

    public PresenterManterUsuario(PresenterHome ph) {
        vmu = new ViewManterUsuario();
        try {
            su = new ServiceUsuario();
        } catch (Exception ex) {
            Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableModel = (DefaultTableModel) vmu.getJtUsuarios().getModel();

        vmu.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmu.dispose();
            }
        });

        vmu.getBtnBuscarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario user = new Usuario();
                user.setNome(vmu.getTfBuscarNome().getText());
                try {
                    user = su.findUser(user);
                } catch (Exception ex) {
                    Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                ServicePermissao sp = new ServicePermissao();
                try {
                    user = sp.findPermissions(user);
                } catch (Exception ex) {
                    Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                String adm = "Não";
                String excluir = "Não";
                String vizualizar = "Não";
                String compartilhar = "Não";
                if (user.getPermissoes().isExcluir()) {
                    excluir = "Sim";
                }
                if (user.getPermissoes().isVizualizar()) {
                    vizualizar = "Sim";
                }
                if (user.getPermissoes().isCompartilhar()) {
                    vizualizar = "Sim";
                }
                if (user.isAdmin()) {
                    adm = "Sim";
                }
                tableModel.addRow(new Object[]{
                    user.getNome(),
                    adm,
                    excluir,
                    vizualizar,
                    compartilhar
                });

            }
        });

        vmu.getBrnNovoUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ph.AddTela(new PresenterCadastroUsuario(ph).getVc());
                    vmu.dispose();
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
