
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.FrmRegistro;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ctrlRegistro implements MouseListener {

    // 1-Llamar a las otras capas
    Usuario modelo;
    FrmRegistro vista;
    
    // 2-Constructor 
    public ctrlRegistro(Usuario Modelo, FrmRegistro Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnregis.addMouseListener(this);
        vista.btnvollog.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnregis){
            modelo.setNombre(vista.txtregisname.getText());
            modelo.setCorreo(vista.txtregiscorreo.getText());
            modelo.setContraseña(modelo.convertirSHA256(vista.txtregiscont.getText()));
            
            modelo.GuardarUsuario();
            
            // Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
        }
        
         // Clic al botón de Ir Al Login
        if(e.getSource() == vista.btnvollog){
            Vista.FrmLogin.initFrmLogin();
            vista.dispose();
        }
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
