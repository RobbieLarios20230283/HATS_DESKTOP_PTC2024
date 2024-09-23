/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class Usuario {

   //1-Parametros
    private String UUID_admin;
    private String Nombre;
    private String Correo;
    private String Contraseña;
    
    //2-Getters y Setters

    public String getUUID_admin() {
        return UUID_admin;
    }

    public void setUUID_admin(String UUID_admin) {
        this.UUID_admin = UUID_admin;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    //3-Metodos
       public void GuardarUsuario() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addAdmin = conexion.prepareStatement("INSERT INTO credencialesAdmins(uuidAdmin, NombreCompleto, correoAdmin, ContraseñaUsuario) VALUES (?, ?, ?, ?)");
            String contraseñaEncriptada = convertirSHA256(getContraseña());
            //Establecer valores de la consulta SQL
            addAdmin.setString(1, UUID.randomUUID().toString());
            addAdmin.setString(2, getNombre());
            addAdmin.setString(3, getCorreo());
            addAdmin.setString(4, contraseñaEncriptada);
 
            //Ejecutar la consulta
            addAdmin.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
       
       //El método devuelve un valor booleano (verdadero o falso)
       //Verdadero si existe el usuario y Falso si no existe
       public boolean iniciarSesion() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM credencialesAdmins WHERE correoAdmin = ? AND ContraseñaUsuario = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            String contraseñaEncriptada = convertirSHA256(getContraseña());
            statement.setString(1, getCorreo());
            statement.setString(2, contraseñaEncriptada);

            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
       
       public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
}
       
    
    
}

