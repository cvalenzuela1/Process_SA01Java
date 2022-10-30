/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_sa.controller;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import process_sa.models.Persona;
import process_sa.models.Usuario;

/**
 *
 * @author cvale
 */
public class Controlador {
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER = "dbprocess_sa";
    private final String PASWORD = "123";

    Connection conn = null;
    
    public Controlador() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASWORD);
            System.out.println("Conexión establecida!");

        } catch (Exception e) {
            System.out.println("Error en la conexión..."+e);
        }
    }

    public void desconectar() {
        try {
            conn.close();
            System.out.println("Desconectado exitosamente de la BDD");
        } catch (Exception e) {
            System.out.println("Error al desconectar de BDD: "+e);
        }
    }
    
    public ResultSet ejecutarProcedimientoAlmacenado(String strProcedimientoSQL){
        try {
            CallableStatement cs = conn.prepareCall(strProcedimientoSQL);
            return cs.executeQuery();
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
    }
    
    public boolean responsableExiste(int persona_id) throws SQLException{
        PreparedStatement ps;
        String sentencia = String.format("SELECT persona_id_persona FROM RESPONSABLE WHERE persona_id_persona = %s", persona_id);
        ps = conn.prepareStatement(sentencia);
        ResultSet rs = ps.executeQuery();
        int id_persona = 0;
        while (rs.next()){
            id_persona = rs.getInt("persona_id_persona");
        }
        if (id_persona > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean usuarioExiste(String usuario) throws SQLException{
        PreparedStatement ps;
        String sentencia = String.format("SELECT id_usuario FROM USUARIO WHERE nombre_usuario = '%s'", usuario);
        ps = conn.prepareStatement(sentencia);
        ResultSet rs = ps.executeQuery();
        int id_usuario = 0;
        while (rs.next()){
            id_usuario = rs.getInt("id_usuario");
        }
        if (id_usuario > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean iniciarSesionUsuario(Usuario objectUsuario){
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_USUARIO_INICIAR_SESION(?,?,?,?)}");
            cs.registerOutParameter(3, OracleTypes.NUMBER);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.setString(1, objectUsuario.getNombre_usuario());
            cs.setString(2, objectUsuario.getContraseña());
            
            cs.executeUpdate();
            
            if (cs.getInt(3) > 0 && cs.getString(4).equalsIgnoreCase("administrador")){
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return false;
        }
    }
    
    public List<Usuario> getUsuarios(){
        //cs = conn.prepareCall("{call PD_DELETE_USUARIO()}");
        final List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{call PD_SELECT_USUARIOS(?,?,?,?)}");
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            
            cs.execute();
            
            String id = cs.getString(1);
            String nombre = cs.getString(2);
            String contraseña = cs.getString(3);
            String rol_id = cs.getString(4);
            
            if (id != null && nombre != null && contraseña != null && rol_id != null){
                final String[] arrayID = id.split(",");
                final String[] arrayNombres = nombre.split(",");
                final String[] arrayPassword = contraseña.split(",");
                final String[] arrayRolID = rol_id.split(",");
                if (null != arrayID && arrayID.length > 0) {
                    Usuario user;
                    for (int i = 0; i < arrayID.length; i++) {
                        user = new Usuario();
                        user.setId(Integer.parseInt(arrayID[i]));
                        user.setNombre_usuario(arrayNombres[i]);
                        user.setContraseña(arrayPassword[i]);
                        user.setId_rol(Integer.parseInt(arrayRolID[i]));

                        listaUsuarios.add(user);
                    }
                }
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
        }
        return listaUsuarios;
    }
    
    public int getUsuariosAdmin(){
        //cs = conn.prepareCall("{call PD_DELETE_USUARIO()}");
        final List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{call PD_COUNT_USUARIOS_ADMIN(?,?)}");
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.setString(1, "Administrador");
            
            cs.executeUpdate();
            
            int count = cs.getInt(2);
            
            if (count > 0){
                return count;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return 0;
        }
    }
    
    public List<Persona> getPersonas(){
        //cs = conn.prepareCall("{call PD_DELETE_USUARIO()}");
        final List<Persona> listaPersonas = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{call PD_SELECT_PERSONAS(?,?,?,?,?)}");
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            
            cs.executeUpdate();
            
            String id = cs.getString(1);
            String rut = cs.getString(2);
            String nombre = cs.getString(3);
            String appaterno = cs.getString(4);
            String apmaterno = cs.getString(5);
            
            if (id != null && rut != null && nombre != null && appaterno != null && apmaterno != null){
                final String[] arrayID = id.split(",");
                final String[] arrayRut = rut.split(",");
                final String[] arrayNombres = nombre.split(",");
                final String[] arrayAppaterno = appaterno.split(",");
                final String[] arrayApmaterno = apmaterno.split(",");
                if (null != arrayID && arrayID.length > 0) {
                    Persona persona;
                    for (int i = 0; i < arrayID.length; i++) {
                        persona = new Persona();
                        persona.setId(Integer.parseInt(arrayID[i]));
                        persona.setRut(arrayRut[i]);
                        persona.setNombre(arrayNombres[i]);
                        persona.setApellido_paterno(arrayAppaterno[i]);
                        persona.setApellido_materno(arrayApmaterno[i]);

                        listaPersonas.add(persona);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
        }
        return listaPersonas;
    }
    
    public String getRolUsuario(int rol_id){
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_GET_ROL_NOMBRE(?,?)}");
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.setInt(1, rol_id);
            
            cs.executeUpdate();
            
            if (!cs.getString(2).equalsIgnoreCase(null)){
                return cs.getString(2);
            } 
            else {
                return null;
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
    }
    
    public int getIdDireccion(){
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_GET_LAST_DIRECCION_ID(?)}");
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            
            cs.executeUpdate();
            int id = cs.getInt(1);
            
            if (id > 0){
                return id;
            } 
            else {
                return 0;
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return 0;
        }
    }
    
    public List<String> getRoles(){
        final List<String> listaRol = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_SELECT_ROLES(?,?)}");
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            
            cs.executeUpdate();
            
            String id = cs.getString(1);
            String nombre = cs.getString(2);
            
            System.out.println("ID: "+id);
            System.out.println("NOMBRE: "+nombre);
            
            if (id != null && nombre != null){
                final List<String> arrayID = new ArrayList<>();
                for (int i = 0; i < id.length(); i++) {
                    arrayID.add(String.valueOf(id.charAt(i)));
                }
                final String[] arrayNombre = nombre.split(",");

                if (null != arrayNombre && arrayID.size() > 0) {
                    for (int i = 0; i < arrayID.size(); i++) {
                        String item = arrayID.get(i)+" - "+arrayNombre[i];
                        listaRol.add(item);
                    }
                }
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
        return listaRol;
    }
    
    public List<String> getRolesDistinct(){
        final List<String> listaRol = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_SELECT_ROLES_DISTINCT(?)}");
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            
            cs.executeUpdate();
            
            String nombre = cs.getString(1);
            
            if (nombre != null){
                final String[] arrayNombre = nombre.split(",");
                if (null != arrayNombre && arrayNombre.length > 0) {
                    for (int i = 0; i < arrayNombre.length; i++) {
                        listaRol.add(arrayNombre[i]);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
        return listaRol;
    }
    
    public List<String> getRegiones(){
        final List<String> listaRegion = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_SELECT_REGIONES(?,?)}");
            cs.registerOutParameter(1, OracleTypes.LONGNVARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.executeUpdate();
            
            String id = cs.getString(1);
            String nombre = cs.getString(2);
            
            if (nombre != null && id != null){
                final List<String> arrayID = new ArrayList<>();
                int contador = 0;
                int actual_numero = 10;
                for (int i = 0; i < id.length(); i++) {
                    if (i < 9){
                        arrayID.add(String.valueOf(id.charAt(i)));
                    }
                    else{
                        if (i == 9){
                            contador = (id.length()-i)/2;
                        }
                        if (contador > 0){
                            arrayID.add(String.valueOf(actual_numero));
                            actual_numero += 1;
                            contador-=1;
                        }
                    }
                }
                
                final String[] arrayNombre = nombre.split(",");
                if (null != arrayNombre && arrayID.size() > 0) {
                    for (int i = 0; i < arrayID.size(); i++) {
                        String item = arrayID.get(i)+" - "+arrayNombre[i];
                        listaRegion.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
        
        return listaRegion;
    }
    
    public List<String> getCiudad(){
        final List<String> listaCiudad = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_SELECT_CIUDADES(?,?)}");
            cs.registerOutParameter(1, OracleTypes.LONGNVARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            
            cs.executeUpdate();
            
            String id = cs.getString(1);
            String nombre = cs.getString(2);
            
            if (nombre != null && id != null){
                final List<String> arrayID = new ArrayList<>();
                int contador = 0;
                int actual_numero = 10;
                for (int i = 0; i < id.length(); i++) {
                    if (i < 9){
                        arrayID.add(String.valueOf(id.charAt(i)));
                    }
                    else{
                        if (i == 9){
                            contador = (id.length()-i)/2;
                        }
                        if (contador > 0){
                            arrayID.add(String.valueOf(actual_numero));
                            actual_numero += 1;
                            contador-=1;
                        } 
                    }
                }
                
                final String[] arrayNombre = nombre.split(",");
                if (null != arrayNombre && arrayID.size() > 0) {
                    for (int i = 0; i < arrayID.size(); i++) {
                        String item = arrayID.get(i)+" - "+arrayNombre[i];
                        listaCiudad.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
        return listaCiudad;
    }
    
    public List<String> getComuna(){
        final List<String> listaComuna = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{CALL PD_SELECT_COMUNAS(?,?)}");
            cs.registerOutParameter(1, OracleTypes.LONGNVARCHAR);
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            
            cs.executeUpdate();
            
            String id = cs.getString(1);
            String nombre = cs.getString(2);
            
            if (nombre != null && id != null){
                final List<String> arrayID = new ArrayList<>();
                int contador = 0;
                int actual_numero = 10;
                for (int i = 0; i < id.length(); i++) {
                    if (i < 9){
                        arrayID.add(String.valueOf(id.charAt(i)));
                    }
                    else{
                        if (i == 9){
                            contador = (id.length()-i)/2;
                        }
                        if (contador > 0){
                            arrayID.add(String.valueOf(actual_numero));
                            actual_numero += 1;
                            contador-=1;
                        } 
                    }
                }
                
                final String[] arrayNombre = nombre.split(",");
                if (null != arrayNombre && arrayID.size() > 0) {
                    for (int i = 0; i < arrayID.size(); i++) {
                        String item = arrayID.get(i)+" - "+arrayNombre[i];
                        listaComuna.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR conexión: "+e);
            return null;
        }
        return listaComuna;
    }
}