package br.ufes.presenter;

import br.ufes.model.Usuario;
import br.ufes.service.ServiceImagem;
import br.ufes.service.ServicePermissao;
import br.ufes.service.ServiceUsuario;
import br.ufes.view.ViewManterUsuario;
import br.ufes.view.proxy.ImagemProxy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private ServicePermissao sp;
    private ArrayList<ImagemProxy> ip;

    public PresenterManterUsuario(PresenterHome ph) {
        vmu = new ViewManterUsuario();
        ip = new ArrayList<>();
        try {
            sp = new ServicePermissao();
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
                String adm = "Não";
                String excluir = "Não";
                String vizualizar = "Não";
                String compartilhar = "Não";
                if (user.isAdmin()) {
                    adm = "Sim";
                    excluir = "Sim";
                    vizualizar = "Sim";
                    compartilhar = "Sim";
                    
                    ServiceImagem temp = new ServiceImagem();
                    try {
                        ip = temp.readFromDataBase();
                    } catch (Exception ex) {
                        Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (ImagemProxy a : ip) {
                        tableModel.addRow(new Object[]{
                            user.getNome(),
                            adm,
                            excluir,
                            vizualizar,
                            compartilhar,
                            a.getCaminho()
                        });
                    }

                } else {

                    ServiceImagem temp = new ServiceImagem();
                    try {
                        ip = temp.readFromDataBase();
                    } catch (Exception ex) {
                        Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (ImagemProxy a : ip) {
                        try {

                            tableModel.addRow(new Object[]{
                                sp.findPermissions(user, a).getNome(),
                                "Não",
                                sp.findPermissions(user, a).getPermissoes().isExcluir(),
                                sp.findPermissions(user, a).getPermissoes().isVizualizar(),
                                sp.findPermissions(user, a).getPermissoes().isCompartilhar(),
                                a.getCaminho()

                            });

                        } catch (Exception ex) {
                            Logger.getLogger(PresenterManterUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

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
