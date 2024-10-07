package Controlador;

import Modelo.Usuarios;
import Vista.panelUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Admin
 */
public class ctrlUsuarios implements MouseListener {

    private Usuarios modelo;
    private panelUsuarios Vista;

    public ctrlUsuarios(Usuarios modelo, panelUsuarios vista) {
        this.modelo = modelo;
        this.Vista = vista;

        // Registrar el controlador como listener de los eventos de ratón  
        vista.btnEliminar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.jtbUsuarios.addMouseListener(this);
        modelo.Mostrar(vista.jtbUsuarios);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == Vista.btnEliminar) {
            modelo.Eliminar(Vista.jtbUsuarios);
            modelo.Mostrar(Vista.jtbUsuarios);
        }

        if (e.getSource() == Vista.jtbUsuarios) {
            modelo.cargarDatosTabla(Vista);
        }

        if (e.getSource() == Vista.btnActualizar) {
            modelo.setNombreEmpleador(Vista.txtNombres.getText());
            modelo.setApellidoEmpleador(Vista.txtApellidos.getText());
            modelo.setCorreoEmpleador(Vista.txtCorreo.getText());
            modelo.setContraseñaEmpleador(Vista.txtContraseña.getText());
            modelo.setTelefonoEmpleador(Vista.txtTelefono.getText());
            modelo.setDuiEmpleador(Vista.txtDui.getText());
            modelo.setDireccionEmpleador(Vista.txtDireccion.getText());
            modelo.setNacimientoEmpleador(Vista.txtNacimiento.getText());

            modelo.Actualizar(Vista.jtbUsuarios);
            modelo.Mostrar(Vista.jtbUsuarios);
        }

        if (e.getSource() == Vista.btnLimpiar) {
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
