/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;
import CapaException.usuarioException;
import CapaLogica.Usuario;
import CapaLogica.Licencia;
import CapaLogica.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 62512396
 */
public class PersistenciaUsuario {
     private static final String SQLGuardarL = ("INSERT INTO baselicencias.licencia (nombreDocente,CiDocente,fechaInicio,fechaFin,Turno,GruposAfectados,Motivo) VALUES (?,?,?,?,?,?,?)");
     private static final String SQLBuscarL = ("SELECT * FROM baselicencias.licencia where CiDocente=?");
     private static final String SQLBuscarU = ("SELECT * FROM baselicencias.usuario where ID=?");
     private static final String SQLActivas = ("SELECT nombreDocente AS Nombre,fechaInicio AS Inicio, fechaFin AS Fin,GruposAfectados AS Grupos FROM baselicencias.licencia");
     private static final String SQLEliminarL = ("DELETE FROM baselicencias.licencia WHERE CiDocente=?");
     private static final String SQLEliminarU = ("DELETE FROM baselicencias.usuario WHERE ID=?");
     private static final String SQL_REGISTRAR = ("INSERT INTO baselicencias.usuario(ID, Nombre,Contrasenia) VALUES (?, ?,?)");
     private static final String SQL_INICIAR_SESION = ("SELECT * FROM baselicencias.usuario WHERE Nombre = ? AND Contrasenia = ?");
    
     public Conexion conex = new Conexion();
    public PreparedStatement PS;
    public ResultSet rs;

    public void registrarUsuario(Usuario login) throws Exception {
        try {
            Connection con = conex.getConnection();
            PS = con.prepareStatement(SQL_REGISTRAR);
            PS.setString(1, login.getId());
            PS.setString(2, login.getNombre());
            PS.setString(3, login.getContrasenia());
            int resultado = PS.executeUpdate();

            if (resultado <= 0) {
                throw new Exception("No se pudo registrar el usuario.");
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para validar usuario y contraseña
    public boolean iniciarSesion(String id, String nombre , String contraseña) throws Exception {
        boolean valido = false;
        try {
            Connection con = conex.getConnection();
            PS = con.prepareStatement(SQL_INICIAR_SESION);
            PS.setString(1, id);
            PS.setString(2, nombre);
            PS.setString(3, contraseña);
            rs = PS.executeQuery();

            if (rs.next()) {
                valido = true; // usuario encontrado
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al validar inicio de sesión: " + e.getMessage());
        }
        return valido;
    }
    
 public void guardarlicencia(Licencia li) throws Exception {
        try {
            int resultado = 0;

            Connection con = conex.getConnection();

            PS = (PreparedStatement) con.prepareStatement(SQLGuardarL);
            PS.setString(1, li.getNombreDocente());
            PS.setString(2, li.getCiDocente());
            PS.setString(3, li.getFechaInicio());
            PS.setString(4, li.getFechaFin());
            PS.setString(5, li.getTurno());
            PS.setString(6, li.getGruposAfectados());
            PS.setString(7, li.getMotivo());

            resultado = PS.executeUpdate();

        } catch (SQLException e) {
        }
 }
 public boolean eliminarUsuario(String id) throws Exception{
     boolean valido= false;
    try {
        String Eliminacion=null;
        Connection conexion;
        conexion=conex.getConnection();
        PS=conexion.prepareStatement(SQLEliminarU);
        PS.setString(1,id);
        int resultado= PS.executeUpdate();
        
        if(resultado==1) {
           
            valido=true;
        }
        conexion.close();
    } catch (Exception e) {
        System.out.println(e);
    }return valido;
}
 public boolean eliminarLicencia(String CIDocente) throws Exception{
    boolean valido= false;
     try {
        String Eliminacion=null;
        Connection conexion;
        conexion=conex.getConnection();
        PS=conexion.prepareStatement(SQLEliminarL);
        PS.setString(1, CIDocente);
       
        int resultado= PS.executeUpdate();
         if(resultado==1) {
          
            valido=true;
    
         }  
        conexion.close();
    } catch (Exception e) {
        System.out.println(e);
    }return valido;
}
 public Usuario buscarId(String ID) throws Exception {
        Usuario usu = new Usuario();
        try {
            Connection con;
            con = conex.getConnection();
            PS = (PreparedStatement) con.prepareStatement(SQLBuscarU);
            PS.setString(1, ID);
            rs = PS.executeQuery();
            if (rs.next()) {
                String Id = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String contraseña = rs.getString("Contrasenia");
                
               usu.setId(Id);
               usu.setNombre(nombre);
               usu.setContrasenia(contraseña);
            }

        } catch (SQLException e) {
            throw new usuarioException("No se conecto");
        }
        return usu;
       
    }
public Licencia buscarCi(String CIDocente) throws Exception {
        Licencia lice = new Licencia();
        try {
            
            Connection con = conex.getConnection();
            PS = (PreparedStatement) con.prepareStatement(SQLBuscarL);
            PS.setString(1,CIDocente );
            rs = PS.executeQuery();
            if (rs.next()) {
                String ciDocente = rs.getString("CiDocente");
                String nombreD = rs.getString("nombreDocente");
                String fechaI = rs.getString("fechaInicio");
                String fechaF = rs.getString("fechaFin");
                String Turno = rs.getString("Turno");
                String GruposAfectados = rs.getString("GruposAfectados");
               String Motivo = rs.getString("Motivo");
                
             lice.setCiDocente(ciDocente);
             lice.setNombreDocente(nombreD);
             lice.setFechaInicio(fechaI);
             lice.setFechaFin(fechaF);
             lice.setTurno(Turno);
             lice.setGruposAfectados(GruposAfectados);
             lice.setMotivo(Motivo);
            }

        } catch (SQLException e) {
            throw new usuarioException("No se conecto");
        }
        return lice;
       
        
    }
public void llenarTabla (JTable tabla) throws Exception{
    try {
    Connection con = conex.getConnection();
    PS = (PreparedStatement) con.prepareStatement(SQLActivas);
          
            rs = PS.executeQuery();
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSetMetaData rsmd = rs.getMetaData();
         int numColumnas = rsmd.getColumnCount();
         for (int i = 1; i <= numColumnas; i++) {
            
            modelo.addColumn(rsmd.getColumnLabel(i));
        }

        // 4. Recorrer el ResultSet y agregar los datos como filas
        while (rs.next()) {
            // Crear un array de Object para almacenar los datos de la fila actual
            Object[] fila = new Object[numColumnas];
           
            for (int i = 1; i <= numColumnas; i++) {
                // Obtener el valor de cada columna (se usa i-1 en el array)
                fila[i - 1] = rs.getObject(i);
            }
           
            // Agregar la fila al modelo
            modelo.addRow(fila);
        }
       
        // 5. Asignar el modelo completo al JTable
        tabla.setModel(modelo);
        
        
        
        
        
        } catch (SQLException e) {
            throw new usuarioException("No se conecto");
        }
        
        
} 
}
