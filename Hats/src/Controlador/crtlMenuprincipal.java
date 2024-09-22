/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FrmPrincipal;
import Vista.PanelPantallaprincipal;
import Vista.panelEmpleados;
import Vista.panelServicios;
import Vista.panelUsuarios;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class crtlMenuprincipal {
    
 //1-Mandar a llamar a las demas capas
    FrmPrincipal vista;
    PanelPantallaprincipal Panel;
    
    //2-Constructor
    public crtlMenuprincipal(FrmPrincipal Vista, PanelPantallaprincipal panel){
        this.vista = Vista;
        this.Panel = panel;
        
        vista.btnUsuarios.addMouseListener(this);
        vista.btnEmpleados.addMouseListener(this);
        vista.btnServicios.addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {
        
       
      
        if(e.getSource() == vista.btnUsuarios){
            //1-Creo un objeto del panel que quiero mostrar
            panelUsuarios objUsuarios = new panelUsuarios();
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpContenedor.removeAll();
            //3- muestro el panel que quiero
            vista.jpContenedor.add(objUsuarios);
            
            //4- Refrescar todo
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
        if(e.getSource() == vista.btnEmpleados){
            panelEmpleados objEmpleados = new panelEmpleados();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objEmpleados);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
        }
        
        if(e.getSource() == vista.btnServicios){
            panelServicios objServicios = new panelServicios();
            
            vista.jpContenedor.removeAll();
            vista.jpContenedor.add(objServicios);
            
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();

        }
        

        
    }


    public crtlMenuprincipal() {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
   
    
}
