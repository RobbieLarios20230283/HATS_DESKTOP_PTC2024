package controlador;

import Vista.FrmPrincipal;
import Vista.panelEmpleados;
import Vista.panelUsuarios;
import Vista.panelprincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


//3- Heredar de la clase MouseListener
public class ctrlMenuPrincipal implements MouseListener{
   
    //1-Mandar a llamar a las demas capas
    FrmPrincipal vista;
    panelprincipal Panel;
    
    //2-Constructor
    public ctrlMenuPrincipal(FrmPrincipal Vista, panelprincipal panel){
        this.vista = Vista;
        this.Panel = panel;
        
        vista.btnUsuarios.addMouseListener(this);
        vista.btnEmpleados.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       
      
        if(e.getSource() == vista.btnUsuarios){
            System.err.println("se dio clic al btnUsuarios");
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
