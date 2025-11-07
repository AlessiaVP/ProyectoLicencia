/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class Licencia {
    private String nombreDocente;
    private String ciDocente;
    private String fechaInicio;

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    private String fechaFin;
    private String turno;
    private String gruposAfectados;
    private String motivo;

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getCiDocente() {
        return ciDocente;
    }

    public void setCiDocente(String ciDocente) {
        this.ciDocente = ciDocente;
    }

   

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGruposAfectados() {
        return gruposAfectados;
    }

    public void setGruposAfectados(String gruposAfectados) {
        this.gruposAfectados = gruposAfectados;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    

   

  //public boolean estaActivaHoy() {
   //     LocalDate hoy = LocalDate.now();
    //    return (hoy.isEqual(fechaInicio) || hoy.isAfter(fechaInicio)) && hoy.isBefore(fechaFin.plusDays(1));


  }