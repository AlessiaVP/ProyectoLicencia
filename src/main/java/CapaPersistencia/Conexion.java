/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaException.BDException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 62512396
 */
public class Conexion {
     public static Connection getConnection () throws BDException {
 Connection con=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/baselicencias?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        }catch(SQLException sqle){
        throw new BDException("Error de conexion");
    }
        return con;
            
    }
}

