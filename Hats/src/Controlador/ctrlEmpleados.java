package Controlador;

import Modelo.Empleados;
import Vista.panelEmpleados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Admin
 */
public class ctrlEmpleados implements MouseListener {

    private Empleados modelo;
    private panelEmpleados Vista;

    public ctrlEmpleados (Empleados modelo, panelEmpleados vista) {
        this.modelo = modelo;
        this.Vista = vista;

        // Registrar el controlador como listener de los eventos de ratón  
        vista.btnEliminarEmp.addMouseListener(this);
        vista.btnActualizarEmp.addMouseListener(this);
        vista.btnLimiparEmp.addMouseListener(this);
        vista.jtbEmpleados.addMouseListener(this);
        modelo.Mostrar(vista.jtbEmpleados);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == Vista.btnEliminarEmp) {
            modelo.Eliminar(Vista.jtbEmpleados);
            modelo.Mostrar(Vista.jtbEmpleados);
        }

        if (e.getSource() == Vista.jtbEmpleados) {
            modelo.cargarDatosTabla(Vista);
        }

        if (e.getSource() == Vista.btnActualizarEmp) {
            modelo.setNombreTrabajador(Vista.txtNombreEmp.getText());
            modelo.setCorreTrabjador(Vista.txtCorreoEmp.getText());
            modelo.setContraseñaTrabajador(Vista.txtContraseñaEmp.getText());
            modelo.setDireccion(Vista.txtDireccionEmp.getText());
            modelo.setTelefono(Vista.txtTelefonoEmp.getText());
            modelo.setNombreperfil(Vista.txtNombrePerfilEmp.getText());
            modelo.setFechaNacimiento(Vista.txtfechanaEmp.getText());
            modelo.setDuiTrabajador(Vista.txtDuiEmp.getText());

            modelo.Actualizar(Vista.jtbEmpleados);
            modelo.Mostrar(Vista.jtbEmpleados);
        }

        if (e.getSource() == Vista.btnLimiparEmp) {
            modelo.limpiar(Vista);
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

