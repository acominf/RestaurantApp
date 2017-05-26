/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import apprestaurant.Mesa;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author lucerogarcia
 */
public class DiagramasMesas extends javax.swing.JFrame {
    private ArrayList<JButton> botonesMesas;
    private ArrayList <Mesa> mesas;
    private boolean edicion;
    private String nomRes;
    /**
     * Creates new form diagramasMesas
     */
    public DiagramasMesas(ArrayList <Mesa> mesas, String nom) {
        initComponents();
        nomRes=nom;
        this.setName("DiagramaMesas");
        botonesMesas = new ArrayList<JButton>();
        this.mesas = mesas;
        for(Mesa m : mesas)
        {
            JButton nuevo = new JButton();
            nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); 
            nuevo.setText(""+m.accederId());
            nuevo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mesaActionPerformed(evt);
                }
            });
            botonesMesas.add(nuevo);
            getContentPane().add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(m.accederX(), m.accederY(), 50, 50));
        }
        agregar.setVisible(false);
        listo.setVisible(false);
        edicion = false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMesas = new javax.swing.JLabel();
        listo = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMesas.setFont(new java.awt.Font("PingFang TC", 3, 24)); // NOI18N
        labelMesas.setText("Mesas");
        getContentPane().add(labelMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 50));

        listo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        listo.setText("Listo");
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });
        getContentPane().add(listo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 97, 29));

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        atras.setText("Atrás");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        agregar.setVisible(false);
        listo.setVisible(false);
        editar.setVisible(true);
    }//GEN-LAST:event_listoActionPerformed
    
    private void mesaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        JButton clickeado= (JButton) evt.getSource();
        String s= clickeado.getText();
        System.out.print(s);
        for(int i = 0; i< mesas.size();i++)
        {
            if((s+1).equals(""+mesas.get(i).accederId() ))
            {
                EditarPedido editarPedido = new EditarPedido(mesas.get(i).accederPedido(),nomRes);
                this.setVisible(false);
                editarPedido.setVisible(true);
            }
        }
        if(edicion)
        {
            /*setDragEnabled(true);
            if(this.)*/
        }
        
        
    }
    
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        agregar.setVisible(true);
        listo.setVisible(true);
        editar.setVisible(false);
        edicion = true;
    }//GEN-LAST:event_editarActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        Frame[] frames = Frame.getFrames();
        for(int i=0;i<frames.length;i++)
        {
            if(frames[i].getName().equals("menuRes"))
            {
                this.setVisible(false);
                frames[i].setVisible(true);
            }
        }
        this.dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        Mesa nuevo= new Mesa(5,mesas.size()+1);
        mesas.add(nuevo);
        System.out.println(nuevo.accederId());
        JButton nuevoBoton = new JButton();
        nuevoBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mesa.png"))); 
        nuevoBoton.setText(""+nuevo.accederId());
        nuevoBoton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mesaActionPerformed(evt);
                }
            });
        botonesMesas.add(nuevoBoton);
        getContentPane().add(nuevoBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(nuevo.accederX(), nuevo.accederY(), 50, 50));
    }//GEN-LAST:event_agregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiagramasMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagramasMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagramasMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagramasMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DiagramasMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton atras;
    private javax.swing.JButton editar;
    private javax.swing.JLabel labelMesas;
    private javax.swing.JButton listo;
    // End of variables declaration//GEN-END:variables
}
