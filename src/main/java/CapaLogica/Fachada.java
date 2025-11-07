/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaPersistencia.PersistenciaUsuario;
import javax.swing.JTable;

/**
 *
 * @author 62512396
 */
public class Fachada {
        public void guardarlicencia (Licencia lice) throws Exception {
    PersistenciaUsuario li = new PersistenciaUsuario();
    li.guardarlicencia(lice);
    
}
        
public boolean eliminarUsuario(String ID)throws Exception{
PersistenciaUsuario usu = new PersistenciaUsuario();
return usu.eliminarUsuario(ID);

}
public boolean eliminarLicencia(String ciDocente)throws Exception{
PersistenciaUsuario usu = new PersistenciaUsuario();
return usu.eliminarLicencia(ciDocente);

}



public Usuario buscarId (String id)throws Exception{
Usuario usu = new Usuario();
PersistenciaUsuario usua = new PersistenciaUsuario();
usu=usua.buscarId(id);
return usu;
}


public Licencia buscarCi (String ciDocente)throws Exception{
Licencia lice = new Licencia();
PersistenciaUsuario lic = new PersistenciaUsuario();
lice=lic.buscarCi(ciDocente);
return lice;
}
public void llenarTabla (JTable tabla) throws Exception{
  PersistenciaUsuario usu= new PersistenciaUsuario();
  usu.llenarTabla(tabla);
}


    public void registrarUsuario(Usuario login) throws Exception {
        PersistenciaUsuario usu = new PersistenciaUsuario();
        usu.registrarUsuario(login);
    }

    // Llama al método de persistencia para iniciar sesión
    public boolean iniciarSesion(String id, String nombre, String contraseña) throws Exception {
        PersistenciaUsuario usu = new PersistenciaUsuario();
        return usu.iniciarSesion(id, nombre, contraseña);
    }
}
