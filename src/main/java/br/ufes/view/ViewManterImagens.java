package br.ufes.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Alcebiades
 */
public class ViewManterImagens extends javax.swing.JInternalFrame {
    
    
    /**
     * Creates new form ManterImagens
     */
    public ViewManterImagens() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVizualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListImagens = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jlImagemNormal = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setTitle("Vizualização");
        setMaximumSize(new java.awt.Dimension(497, 326));
        setMinimumSize(new java.awt.Dimension(497, 326));

        btnVizualizar.setText("Vizualizar");

        btnExcluir.setText("Excluir");

        jScrollPane1.setViewportView(JListImagens);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlImagemNormal.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlImagemNormal)
                .addContainerGap(835, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlImagemNormal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVizualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnVizualizar)
                .addGap(33, 33, 33)
                .addComponent(btnExcluir)
                .addGap(30, 30, 30)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListImagens;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVizualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlImagemNormal;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnVizualizar() {
        return btnVizualizar;
    }

    public JList<String> getJListImagens() {
        return JListImagens;
    }

    public JLabel getJlImagemNormal() {
        return jlImagemNormal;
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    
}
