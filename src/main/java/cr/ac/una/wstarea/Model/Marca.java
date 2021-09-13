/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenda
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByPkFolio", query = "SELECT m FROM Marca m WHERE m.pkFolio = :pkFolio"),
    @NamedQuery(name = "Marca.findByHoraEntrada", query = "SELECT m FROM Marca m WHERE m.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "Marca.findByHoraSalida", query = "SELECT m FROM Marca m WHERE m.horaSalida = :horaSalida"),
    @NamedQuery(name = "Marca.findByJornada", query = "SELECT m FROM Marca m WHERE m.jornada = :jornada")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pk_folio")
    private String pkFolio;
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEntrada;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSalida;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date jornada;
    @JoinColumn(name = "pk_folio", referencedColumnName = "pk_folio", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;

    public Marca() {
    }

    public Marca(String pkFolio) {
        this.pkFolio = pkFolio;
    }

    public Marca(String pkFolio, Date jornada) {
        this.pkFolio = pkFolio;
        this.jornada = jornada;
    }

    public String getPkFolio() {
        return pkFolio;
    }

    public void setPkFolio(String pkFolio) {
        this.pkFolio = pkFolio;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFolio != null ? pkFolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.pkFolio == null && other.pkFolio != null) || (this.pkFolio != null && !this.pkFolio.equals(other.pkFolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wstarea.Model.Marca[ pkFolio=" + pkFolio + " ]";
    }
    
}
