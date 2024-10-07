/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.panelUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Usuarios {
    
    private String uuid_Empleador;
    private String nombreEmpleador;
    private String apellidoEmpleador;
    private String correoEmpleador;
    private String contraseñaEmpleador;
    private String telefonoEmpleador;
    private String duiEmpleador;
    private String direccionEmpleador;
    private String nacimientoEmpleador;
    
    public String getUuid_Empleador() {
        return uuid_Empleador;
    }

    public void setUuid_Empleador(String uuid_Empleador) {
        this.uuid_Empleador = uuid_Empleador;
    }

    public String getNombreEmpleador() {
        return nombreEmpleador;
    }

    public void setNombreEmpleador(String nombreEmpleador) {
        this.nombreEmpleador = nombreEmpleador;
    }

    public String getApellidoEmpleador() {
        return apellidoEmpleador;
    }

    public void setApellidoEmpleador(String apellidoEmpleador) {
        this.apellidoEmpleador = apellidoEmpleador;
    }

    public String getCorreoEmpleador() {
        return correoEmpleador;
    }

    public void setCorreoEmpleador(String correoEmpleador) {
        this.correoEmpleador = correoEmpleador;
    }

    public String getContraseñaEmpleador() {
        return contraseñaEmpleador;
    }

    public void setContraseñaEmpleador(String contraseñaEmpleador) {
        this.contraseñaEmpleador = contraseñaEmpleador;
    }

    public String getTelefonoEmpleador() {
        return telefonoEmpleador;
    }

    public void setTelefonoEmpleador(String telefonoEmpleador) {
        this.telefonoEmpleador = telefonoEmpleador;
    }

    public String getDuiEmpleador() {
        return duiEmpleador;
    }

    public void setDuiEmpleador(String duiEmpleador) {
        this.duiEmpleador = duiEmpleador;
    }

    public String getDireccionEmpleador() {
        return direccionEmpleador;
    }

    public void setDireccionEmpleador(String direccionEmpleador) {
        this.direccionEmpleador = direccionEmpleador;
    }

    public String getNacimientoEmpleador() {
        return nacimientoEmpleador;
    }

    public void setNacimientoEmpleador(String nacimientoEmpleador) {
        this.nacimientoEmpleador = nacimientoEmpleador;
    }

  
     
     public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        
        modeloDeDatos.setColumnIdentifiers(new Object[]{"uuidEmpleador", "nombre Empleador", "CorreoUS", "ContrasenaUS", "apellido Empleador", "Telefono", "DuiEmpleador", "Direccion", "fechanac" });
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Empleador");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("uuidEmpleador"), 
                    rs.getString("nombreEmpleador"), 
                    rs.getString("CorreoUS"), 
                    rs.getString("ContrasenaUS"), 
                    rs.getString("apellidoEmpleador"), 
                    rs.getString("Telefono"), 
                    rs.getString("DuiEmpleador"), 
                    rs.getString("Direccion"), 
                    rs.getString("fechanac")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
     
     
     public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //borramos 
        try {
            PreparedStatement deleteEmpleador = conexion.prepareStatement("delete from Empleador where uuidEmpleador = ?");
            deleteEmpleador.setString(1, miId);
            deleteEmpleador.executeUpdate();
        } catch (Exception e) {
            System.out.println("Este es el error metodo de eliminar" + e);
        }
        
     } 
     
     
     public void cargarDatosTabla(panelUsuarios vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbUsuarios.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbUsuarios.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 1).toString();
            String CorreoDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 2).toString();
            String ContraseñaDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 3).toString();
            String ApellidoDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 4).toString();
            String TelefonoDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 5).toString();
            String DuiDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 6).toString();
            String DireccionDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 7).toString();
            String NacimientoDeTB = vista.jtbUsuarios.getValueAt(filaSeleccionada, 8).toString();

            
            // Establece los valores en los campos de texto
            vista.txtNombres.setText(NombreDeTB);
            vista.txtApellidos.setText(ApellidoDeTB);
            vista.txtCorreo.setText(CorreoDeTB);
            vista.txtContraseña.setText(ContraseñaDeTB);
            vista.txtTelefono.setText(TelefonoDeTB);
            vista.txtDui.setText(DuiDeTB);
            vista.txtDireccion.setText(DireccionDeTB);
            vista.txtNacimiento.setText(NacimientoDeTB);    
        }
     }
     
     public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update Empleador set nombreEmpleador= ?, CorreoUS = ?, ContrasenaUS = ?, apellidoEmpleador = ?, Telefono = ?, DuiEmpleador = ?, Direccion = ?, fechanac = ? where uuidEmpleador = ?");
                
                updateUser.setString(1, getNombreEmpleador());
                updateUser.setString(2, getCorreoEmpleador());
                updateUser.setString(3, getContraseñaEmpleador());
                updateUser.setString(4, getApellidoEmpleador());
                updateUser.setString(5, getTelefonoEmpleador());
                updateUser.setString(6, getDuiEmpleador());
                updateUser.setString(7, getDireccionEmpleador());
                updateUser.setString(8, getNacimientoEmpleador());
                updateUser.setString(9, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("Este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("No");
        }
          
     }
     
      public void limpiar(panelUsuarios vista) {
        vista.txtNombres.setText("");
            vista.txtApellidos.setText("");
            vista.txtCorreo.setText("");
            vista.txtContraseña.setText("");
            vista.txtTelefono.setText("");
            vista.txtDui.setText("");
            vista.txtDireccion.setText("");
            vista.txtNacimiento.setText("");   
    }

    
    


}


