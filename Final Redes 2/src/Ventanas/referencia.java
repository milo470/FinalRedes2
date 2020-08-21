/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author John Jairo
 */
public class referencia extends JPanel{
    String[] vector2;
  
  int[] vector3;
  
  int[] vectorfinal;
  
  String[][] matriz;
  
  int indice;
  
  int opcion;
  
  public referencia() {
    setBorder(BorderFactory.createLineBorder(Color.black));
    setBackground(Color.WHITE);
  }
  
  public void ponervector(int[] vector, int tamano, int b) {
    this.vectorfinal = vector;
    this.indice = tamano;
    this.opcion = b;
  }
  
  public void paintComponent(Graphics g) {
      
      
      try{
      
    super.paintComponent(g);
    setSize(450, 600);
    g.drawString("REFERENCIA - UNIPOLAR", 150, 20);
    int y = 58;
    while (y <= 400) {
      int x = 40;
      while (x <= 200) {
        g.setColor(Color.BLUE);
        g.drawString("|", y, x);
        x += 20;
      } 
      y += 30;
    } 
    g.setColor(Color.black);
    g.drawLine(30, 10, 30, 200);
    g.drawLine(30, 200, 400, 200);
    g.drawLine(25, 100, 35, 100);
    g.drawString("1", 18, 105);
    int vax = 30;
    int vay = 200;
    for (int i = 0; i < this.indice; i++) {
      if (this.vectorfinal[i] == 0) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay, vax + 30, vay);
        vax += 30;
        if (i != this.indice - 1 && 
          this.vectorfinal[i + 1] == 1)
          g.drawLine(vax, vay, vax, vay - 100); 
      } 
      if (this.vectorfinal[i] == 1) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay - 100, vax + 30, vay - 100);
        vax += 30;
        if (i != this.indice - 1 && 
          this.vectorfinal[i + 1] == 0)
          g.drawLine(vax, vay - 100, vax, vay); 
      } 
    } 
    
    if (this.opcion == 4) {
      g.setColor(Color.black);
      g.drawString("MANCHESTER", 170, 230);
      int y2 = 58;
      while (y2 <= 400) {
        int x2 = 250;
        while (x2 <= 550) {
          g.setColor(Color.BLUE);
          g.drawString("|", y2, x2);
          x2 += 20;
        } 
        y2 += 30;
      } 
      g.setColor(Color.black);
      g.drawLine(30, 250, 30, 550);
      g.drawLine(30, 400, 400, 400);
      g.drawLine(25, 300, 35, 300);
      g.drawString("1", 18, 305);
      g.drawLine(25, 500, 35, 500);
      g.drawString("-1", 13, 505);
      vax = 30;
      vay = 400;
      for (int x = 0; x < this.indice; x++) {
        if (x + 1 < this.indice) {
          if (this.vectorfinal[x] == 1 && this.vectorfinal[x + 1] == 1) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay + 100, vax + 15, vay + 100);
            vax += 15;
            g.drawLine(vax, vay + 100, vax, vay - 100);
            vay -= 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            g.drawLine(vax, vay, vax, vay + 200);
            vay = 400;
          } 
          if (this.vectorfinal[x] == 1 && this.vectorfinal[x + 1] == 0) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay + 100, vax + 15, vay + 100);
            vax += 15;
            g.drawLine(vax, vay + 100, vax, vay - 100);
            vay -= 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            vay = 400;
          } 
          if (this.vectorfinal[x] == 0 && this.vectorfinal[x + 1] == 1) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay - 100, vax + 15, vay - 100);
            vax += 15;
            g.drawLine(vax, vay - 100, vax, vay + 100);
            vay += 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            vay = 400;
          } 
          if (this.vectorfinal[x] == 0 && this.vectorfinal[x + 1] == 0) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay - 100, vax + 15, vay - 100);
            vax += 15;
            g.drawLine(vax, vay - 100, vax, vay + 100);
            vay += 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            g.drawLine(vax, vay, vax, vay - 200);
            vay = 400;
          } 
        } 
      } 
      if (this.vectorfinal[this.indice - 1] == 0) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay - 100, vax + 15, vay - 100);
        vax += 15;
        g.drawLine(vax, vay - 100, vax, vay + 100);
        vay += 100;
        g.drawLine(vax, vay, vax + 15, vay);
        vax += 15;
        vay = 400;
      } 
      if (this.vectorfinal[this.indice - 1] == 1) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay + 100, vax + 15, vay + 100);
        vax += 15;
        g.drawLine(vax, vay + 100, vax, vay - 100);
        vay -= 100;
        g.drawLine(vax, vay, vax + 15, vay);
        vax += 15;
        vay = 400;
      } 
      
    } 
    if (this.opcion == 5) {
      g.setColor(Color.black);
      g.drawString("MANCHESTER DIFERENCIAL", 150, 230);
      int y2 = 58;
      while (y2 <= 400) {
        int x2 = 250;
        while (x2 <= 550) {
          g.setColor(Color.BLUE);
          g.drawString("|", y2, x2);
          x2 += 20;
        } 
        y2 += 30;
      } 
      g.setColor(Color.black);
      g.drawLine(30, 250, 30, 550);
      g.drawLine(30, 400, 400, 400);
      g.drawLine(25, 300, 35, 300);
      g.drawString("1", 18, 305);
      g.drawLine(25, 500, 35, 500);
      g.drawString("-1", 13, 505);
      vax = 30;
      vay = 400;
      for (int x = 0; x < this.indice; x++) {
        if (x + 1 < this.indice) {
          if (this.vectorfinal[x] == 0 && this.vectorfinal[x + 1] == 0) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay + 100, vax + 15, vay + 100);
            vax += 15;
            g.drawLine(vax, vay + 100, vax, vay - 100);
            vay -= 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            g.drawLine(vax, vay, vax, vay + 200);
            vay = 400;
          } 
          if (this.vectorfinal[x] == 0 && this.vectorfinal[x + 1] == 1) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay + 100, vax + 15, vay + 100);
            vax += 15;
            g.drawLine(vax, vay + 100, vax, vay - 100);
            vay -= 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            vay = 400;
          } 
          if (this.vectorfinal[x] == 1 && this.vectorfinal[x + 1] == 0) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay - 100, vax + 15, vay - 100);
            vax += 15;
            g.drawLine(vax, vay - 100, vax, vay + 100);
            vay += 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            vay = 400;
          } 
          if (this.vectorfinal[x] == 1 && this.vectorfinal[x + 1] == 1) {
            g.setColor(Color.RED);
            g.drawLine(vax, vay - 100, vax + 15, vay - 100);
            vax += 15;
            g.drawLine(vax, vay - 100, vax, vay + 100);
            vay += 100;
            g.drawLine(vax, vay, vax + 15, vay);
            vax += 15;
            g.drawLine(vax, vay, vax, vay - 200);
            vay = 400;
          } 
        } 
      } 
      if (this.vectorfinal[this.indice - 1] == 1) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay - 100, vax + 15, vay - 100);
        vax += 15;
        g.drawLine(vax, vay - 100, vax, vay + 100);
        vay += 100;
        g.drawLine(vax, vay, vax + 15, vay);
        vax += 15;
        vay = 400;
      } 
      if (this.vectorfinal[this.indice - 1] == 0) {
        g.setColor(Color.RED);
        g.drawLine(vax, vay + 100, vax + 15, vay + 100);
        vax += 15;
        g.drawLine(vax, vay + 100, vax, vay - 100);
        vay -= 100;
        g.drawLine(vax, vay, vax + 15, vay);
        vax += 15;
        vay = 400;
      } 
    } 
    
      }catch(Exception e){
          System.out.println(e);
          JOptionPane.showMessageDialog(null, "Error, Ingrese Un Dato En Binario,");
      
      }
    
    
    
    
    
   
  }
}
