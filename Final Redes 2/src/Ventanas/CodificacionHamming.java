/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author John Jairo
 */
public class CodificacionHamming extends javax.swing.JFrame {

     public CodificacionHamming() {
        initComponents();
        ImageIcon Tornique = new ImageIcon(getClass().getResource("/Imagenes/Hamming.png"));
        ImageIcon Icono = new ImageIcon(Tornique.getImage().getScaledInstance(FondoHamming.getWidth(), FondoHamming.getHeight(), Image.SCALE_DEFAULT));
        FondoHamming.setIcon(Icono);
    }
     
      public static String ingresado = "";
    public static String generado = "";
    public static String generadoError = "";
    public static String generadoCorrecto = "";
    public static String ingresadoDecodificado = "";

    public class ImageFondo extends JPanel{
    private Image fondo=null;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }
    public void setImage(String image){
        if (image!=null) {
            fondo=new ImageIcon(getClass().getResource(image)).getImage();
        }
    }
    
}
    
    public static void anadir(String original, String codificado) {
        File archivo = new File("codificados.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(archivo, true);
            writer.append("//////////////////////// CODIFICACION HAMMING ////////////////////////////////" + "\n");
            writer.append("El mensaje original es: " + original + "\n");
            writer.append("El mensaje codificado es: " + codificado + "\n\n\n");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public void codificar() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de bits para realizar codificacion Hamming"));
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[n - i - 1] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero " + (n - i) + ":"));
        }
        JOptionPane.showMessageDialog(null, "Usted ingreso:");
        for (int i = 0; i < n; i++) {
            ingresado = ingresado + a[n - i - 1] + "";
        }
        JOptionPane.showMessageDialog(null, ingresado);
        int b[] = generarHamming(a);
        JOptionPane.showMessageDialog(null, "El codigo hamming generado es:");
        for (int i = 0; i < b.length; i++) {
            generado = generado + b[b.length - i - 1];
        }
        JOptionPane.showMessageDialog(null, generado);
        anadir(ingresado, generado);
        int error = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion de un error para verificar la deteccion de errores\n Ingrese 0 para saltar"));
        if (error != 0) {
            b[error - 1] = (b[error - 1] + 1) % 2;
        }
        JOptionPane.showMessageDialog(null, "Codigo con error es:");
        for (int i = 0; i < b.length; i++) {
            generadoError = generadoError + b[b.length - i - 1];
        }
        JOptionPane.showMessageDialog(null, generadoError);
        datoRecibido(b, b.length - a.length);
    }

    static int[] generarHamming(int a[]) {
        int b[];
        int i = 0, contadorParidad = 0, j = 0, k = 0;
        while (i < a.length) {
            if (Math.pow(2, contadorParidad) == i + contadorParidad + 1) {
                contadorParidad++;
            } else {
                i++;
            }
        }
        b = new int[a.length + contadorParidad];
         for (i = 1; i <= b.length; i++) {
            if (Math.pow(2, j) == i) {
                b[i - 1] = 2;
                j++;
            } else {
                b[k + j] = a[k++];
            }
        }
        for (i = 0; i < contadorParidad; i++) {
            b[((int) Math.pow(2, i)) - 1] = getParidad(b, i);
        }
        return b;
    }

    static int getParidad(int b[], int bitsCorrectos) {
        int paridad = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 2) {
                int k = i + 1;
                String s = Integer.toBinaryString(k);
                int x = ((Integer.parseInt(s)) / ((int) Math.pow(10, bitsCorrectos))) % 10;
                if (x == 1) {
                    if (b[i] == 1) {
                        paridad = (paridad + 1) % 2;
                    }
                }
            }
        }
        return paridad;
    }

    static void datoRecibido(int a[], int contadorParidad) {
        int bitsCorrectos;
        int paridad[] = new int[contadorParidad];
        String ubicacionError = new String();
        for (bitsCorrectos = 0; bitsCorrectos < contadorParidad; bitsCorrectos++) {
            for (int i = 0; i < a.length; i++) {
                int k = i + 1;
                String s = Integer.toBinaryString(k);
                int bit = ((Integer.parseInt(s)) / ((int) Math.pow(10, bitsCorrectos))) % 10;
                if (bit == 1) {
                    if (a[i] == 1) {
                        paridad[bitsCorrectos] = (paridad[bitsCorrectos] + 1) % 2;
                    }
                }
            }
            ubicacionError = paridad[bitsCorrectos] + ubicacionError;
        }
        int posicionError = Integer.parseInt(ubicacionError, 2);
        if (posicionError != 0) {
            JOptionPane.showMessageDialog(null, "El error esta en la posicion " + posicionError + ".");
            a[posicionError - 1] = (a[posicionError - 1] + 1) % 2;
            JOptionPane.showMessageDialog(null, "El codigo correcto es:");
            for (int i = 0; i < a.length; i++) {
                generadoCorrecto = generadoCorrecto + a[a.length - i - 1];
            }
            JOptionPane.showMessageDialog(null, generadoCorrecto);
        } else {
            JOptionPane.showMessageDialog(null, "No hay error en el dato recibido.");
        }
        JOptionPane.showMessageDialog(null, "El dato decodificado es:");
        bitsCorrectos = contadorParidad - 1;
        for (int i = a.length; i > 0; i--) {
            if (Math.pow(2, bitsCorrectos) != i) {
                ingresadoDecodificado = ingresadoDecodificado + a[i - 1];
            } else {
                bitsCorrectos--;
            }
        }
        JOptionPane.showMessageDialog(null, ingresadoDecodificado);
    }
     
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        FondoHamming = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 770));
        setPreferredSize(new java.awt.Dimension(880, 770));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, -1, -1));

        jButton1.setText("Iniciar Codificación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 680, 170, -1));

        FondoHamming.setPreferredSize(new java.awt.Dimension(880, 770));
        getContentPane().add(FondoHamming, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       CodificacionHamming hamming = new CodificacionHamming();    
    hamming.codificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        Inicio I = new Inicio();
        I.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CodificacionHamming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodificacionHamming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodificacionHamming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodificacionHamming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodificacionHamming().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoHamming;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
