/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.FrmLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ctrlLogin implements MouseListener {

    // 1-Llamar a las otras capas
    Usuario modelo;
    FrmLogin vista;

    // 2-Constructor 
    public ctrlLogin(Usuario Modelo, FrmLogin Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btningresar.addMouseListener(this);
        vista.btnirregis.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btningresar) {
            modelo.setCorreo(vista.txtcorreo.getText());
            modelo.setContraseña(modelo.convertirSHA256(vista.txtcontraseña.getText()));

            // Creo una variable llamada "comprobar" 
            // que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = modelo.iniciarSesion();

            // Si la variable es "true" significa que sí existe el usuario ingresado    
            if (comprobar) {
                JOptionPane.showMessageDialog(vista,"Usuario existe, ¡Bienvenido!");
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }
        
        // Clic al botón de Ir Al Registro
        if(e.getSource() == vista.btnirregis){
            Vista.FrmRegistro.initFrmRegistro();
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