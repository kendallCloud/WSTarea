/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Dto;

import cr.ac.una.wstarea.Model.Marca;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kendall
 */
public class MarcaDto {
    private Date horaEntrada;
    private Date horaSalida;
    private Date jornada;
    private Long id;

    public MarcaDto(Marca marc) {
        this.id = marc.getPkMarca();
        this.horaEntrada = marc.getHoraEntrada();
        this.horaSalida = marc.getHoraEntrada();
        this.jornada = marc.getHoraSalida();
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getJornada() {
        return jornada;
    }

    public void setJornada(Date jornada) {
        this.jornada = jornada;
    }
    
    
    
}
