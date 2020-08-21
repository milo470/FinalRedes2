/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/**
 *
 * @author John Jairo
 */
public class codigomanchester extends JFrame {
    
  String codigo_captura;
  int opcion = 0;
  referencia referenciad;
  private JPanel botones;
  private JTextField codigo;
  private JButton guardar;
  private JLabel jLabel2;
  private JButton manchester;
   private JButton volver;
  

  
  private JButton salir;
  
  public codigomanchester() {
    initComponents();
    this.referenciad = new referencia();
    this.referenciad.setMinimumSize(new Dimension(450, 600));
    this.referenciad.setPreferredSize(new Dimension(450, 600));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    getContentPane().add(this.referenciad, gridBagConstraints);
  }
  
  private void initComponents() {
    this.botones = new JPanel();
    this.guardar = new JButton();
    this.salir = new JButton();
    this.manchester = new JButton();
    this.volver = new JButton();
    this.jLabel2 = new JLabel();
    this.codigo = new JTextField();
    setDefaultCloseOperation(3);
    setTitle("GRAFICADOR CÓDIGO MANCHESTER");
    setMinimumSize(new Dimension(600, 600));
    getContentPane().setLayout(new GridBagLayout());
    this.botones.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    this.botones.setAlignmentX(0.0F);
    this.botones.setAlignmentY(0.0F);
    this.botones.setMinimumSize(new Dimension(200, 600));
    this.botones.setPreferredSize(new Dimension(200, 600));
    this.botones.setBackground(Color.red);
  
  
    this.guardar.setText("GUARDAR SIMULACION");
    this.guardar.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            codigomanchester.this.guardarMouseClicked(evt);
          }
        });
    this.salir.setText("SALIR");
    this.salir.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            codigomanchester.this.salirMouseClicked(evt);
          }
        });

    this.manchester.setText("Graficar Manchester");
    this.manchester.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
              
              
              
              try{
            codigomanchester.this.manchesterMouseClicked(evt);
              }catch(Exception e){System.out.println("Error Al Graficar.");}
            
            
            
          }
        });
    
   
    this.volver.setText("Volver");
    this.volver.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            codigomanchester.this.VolverMouseClicked(evt);
          }
        });
    
    
    GroupLayout botonesLayout = new GroupLayout(this.botones);
    this.botones.setLayout(botonesLayout);
    botonesLayout.setHorizontalGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(botonesLayout.createSequentialGroup().addContainerGap().addGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.guardar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.volver, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.salir, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.manchester, GroupLayout.Alignment.LEADING, -1, 109, 32767)).addContainerGap(17, 32767)));
    botonesLayout.setVerticalGroup(botonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, botonesLayout.createSequentialGroup().addContainerGap().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.manchester).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.guardar).addGap(8, 8, 8).addComponent(this.volver).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.salir).addContainerGap()));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = 2;
    gridBagConstraints.anchor = 18;
    gridBagConstraints.weighty = 1.0D;
    gridBagConstraints.insets = new Insets(10, 0, 0, 0);
    getContentPane().add(this.botones, gridBagConstraints);
    this.jLabel2.setText("INGRESE EL CODIGO BINARIO :");
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.insets = new Insets(20, 0, 0, 0);
    getContentPane().add(this.jLabel2, gridBagConstraints);
    this.codigo.setColumns(12);
    this.codigo.setMinimumSize(new Dimension(80, 17));
    this.codigo.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            codigomanchester.this.codigoActionPerformed(evt);
          }
        });
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = 16;
    gridBagConstraints.insets = new Insets(20, 1, 0, 0);
    getContentPane().add(this.codigo, gridBagConstraints);
    pack();
  }
  
  private void codigoActionPerformed(ActionEvent evt) {}
  

  
  private void salirMouseClicked(MouseEvent evt) {
    System.exit(0);
  }

  private void VolverMouseClicked(MouseEvent evt) {
    this.setVisible(false);
    CodigoManchesterXD CM = new CodigoManchesterXD();
    CM.setVisible(true);
  }
  

  private void manchesterMouseClicked(MouseEvent evt) {
   
      
     try{ 
      
      
      this.codigo_captura = this.codigo.getText();
    int[] vector = new int[this.codigo_captura.length()];
    for (int x = 0; x < this.codigo_captura.length(); x++) {
      String aux = this.codigo_captura.substring(x, x + 1);
      vector[x] = Integer.parseInt(aux);
    } 
    this.opcion = 4;
    this.referenciad.ponervector(vector, this.codigo_captura.length(), this.opcion);
    this.referenciad.repaint();
    
     }catch(Exception e){
         System.out.println("Error Código Manchester.");
     
     }
    
    
  }
  


  
  private void guardarMouseClicked(MouseEvent evt) {
    BufferedImage imagen = new BufferedImage(this.referenciad.getWidth(), this.referenciad.getHeight(), 1);
    Graphics g = imagen.getGraphics();
    this.referenciad.paint(g);
    File fichero = new File("foto.jpg");
    String formato = "jpg";
    try {
      ImageIO.write(imagen, formato, fichero);
      JOptionPane.showMessageDialog(null, "Se Ha Guardado La Imagen En La Raíz Del Proyecto");
    } catch (IOException e) {
      System.out.println("Error Al Exportar La Imagen");
    } 
  }


  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new codigomanchester()).setVisible(true);
          }
        });
  }
}
