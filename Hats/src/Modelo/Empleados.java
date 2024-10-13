/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.panelEmpleados;
import Vista.panelUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Empleados {
    
    private String uuidTrabajador;
    private String nombreTrabajador;
    private String correTrabjador;
    private String contraseñaTrabajador;
    private String Direccion;
    private String Telefono;
    private String nombreperfil;
    private String FechaNacimiento;
    private String DuiTrabajador;

    public String getUuidTrabajador() {
        return uuidTrabajador;
    }

    public void setUuidTrabajador(String uuidTrabajador) {
        this.uuidTrabajador = uuidTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getCorreTrabjador() {
        return correTrabjador;
    }

    public void setCorreTrabjador(String correTrabjador) {
        this.correTrabjador = correTrabjador;
    }

    public String getContraseñaTrabajador() {
        return contraseñaTrabajador;
    }

    public void setContraseñaTrabajador(String contraseñaTrabajador) {
        this.contraseñaTrabajador = contraseñaTrabajador;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombreperfil() {
        return nombreperfil;
    }

    public void setNombreperfil(String nombreperfil) {
        this.nombreperfil = nombreperfil;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDuiTrabajador() {
        return DuiTrabajador;
    }

    public void setDuiTrabajador(String DuiTrabajador) {
        this.DuiTrabajador = DuiTrabajador;
    }
    
     
     public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        
        modeloDeDatos.setColumnIdentifiers(new Object[]{"uuidTrabajador", "nombre", "correo", "Contrasena", "direccion", "telefono", "nombrePerfil", "fechadeNacimiento", "duiTrabajadorUrl"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Trabajador");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("uuidTrabajador"), 
                    rs.getString("nombre"), 
                    rs.getString("correo"), 
                    rs.getString("Contrasena"), 
                    rs.getString("direccion"), 
                    rs.getString("telefono"), 
                    rs.getString("nombrePerfil"), 
                    rs.getString("fechadeNacimiento"), 
                    rs.getString("duiTrabajadorUrl")});
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
            PreparedStatement deleteEmpleador = conexion.prepareStatement("delete from Trabajador where uuidTrabajador = ?");
            deleteEmpleador.setString(1, miId);
            deleteEmpleador.executeUpdate();
        } catch (Exception e) {
            System.out.println("Este es el error metodo de eliminar" + e);
        }
        
     } 
     
     
     public void cargarDatosTabla(panelEmpleados vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbEmpleados.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbEmpleados.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 1).toString();
            String CorreoDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 2).toString();
            String ContraseñaDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 3).toString();
            String DireccionDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 4).toString();
            String TelefonoDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 5).toString();
            String NombrePerfilDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 6).toString();
            String NacimientoDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 7).toString();
            String DuiDeTB = vista.jtbEmpleados.getValueAt(filaSeleccionada, 8).toString();

            
            // Establece los valores en los campos de texto
            vista.txtNombreEmp.setText(NombreDeTB);
            vista.txtCorreoEmp.setText(CorreoDeTB);
            vista.txtContraseñaEmp.setText(ContraseñaDeTB);
            vista.txtDireccionEmp.setText(DireccionDeTB);
            vista.txtTelefonoEmp.setText(TelefonoDeTB);
            vista.txtNombrePerfilEmp.setText(NombrePerfilDeTB);
            vista.txtfechanaEmp.setText(NacimientoDeTB);
            vista.txtDuiEmp.setText(DuiDeTB);    
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
                PreparedStatement updateUser = conexion.prepareStatement("update Trabajador set nombre= ?, correo = ?, Contrasena = ?, direccion = ?, telefono = ?, nombrePerfil = ?, fechadeNacimiento = ?, duiTrabajadorUrl = ? where uuidTrabajador = ?");
                
                updateUser.setString(1, getNombreTrabajador());
                updateUser.setString(2, getCorreTrabjador());
                updateUser.setString(3, getContraseñaTrabajador());
                updateUser.setString(4, getDireccion());
                updateUser.setString(5, getTelefono());
                updateUser.setString(6, getNombreperfil());
                updateUser.setString(7, getFechaNacimiento());
                updateUser.setString(8, getDuiTrabajador());
                updateUser.setString(9, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("Este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("No");
        }
          
     }
     
      public void limpiar(panelEmpleados vista) {
        vista.txtNombreEmp.setText("");
            vista.txtCorreoEmp.setText("");
            vista.txtContraseñaEmp.setText("");
            vista.txtDireccionEmp.setText("");
            vista.txtTelefonoEmp.setText("");
            vista.txtNombrePerfilEmp.setText("");
            vista.txtfechanaEmp.setText("");
            vista.txtDuiEmp.setText("");   
    }

    
    

}


