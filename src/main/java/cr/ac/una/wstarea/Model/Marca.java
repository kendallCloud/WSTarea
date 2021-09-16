/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenda
 */
@Entity
@Table(name = "Marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByHoraEntrada", query = "SELECT m FROM Marca m WHERE m.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "Marca.findByHoraSalida", query = "SELECT m FROM Marca m WHERE m.horaSalida = :horaSalida"),
    @NamedQuery(name = "Marca.findByJornada", query = "SELECT m FROM Marca m WHERE m.jornada = :jornada"),
    @NamedQuery(name = "Marca.findByPkMarca", query = "SELECT m FROM Marca m WHERE m.pkMarca = :pkMarca"),
    @NamedQuery(name = "Marca.findById", query = "SELECT m FROM Marca m WHERE m.id = :id")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "hora_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEntrada;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jornada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jornada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_Marca")
    private Long pkMarca;
    @Column(name = "id")
    private BigInteger id;

    public Marca() {
    }

    public Marca(Long pkMarca) {
        this.pkMarca = pkMarca;
    }

    public Marca(Long pkMarca, Date jornada) {
        this.pkMarca = pkMarca;
        this.jornada = jornada;
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

    public Long getPkMarca() {
        return pkMarca;
    }

    public void setPkMarca(Long pkMarca) {
        this.pkMarca = pkMarca;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMarca != null ? pkMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.pkMarca == null && other.pkMarca != null) || (this.pkMarca != null && !this.pkMarca.equals(other.pkMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wstarea.Model.Marca[ pkMarca=" + pkMarca + " ]";
    }
    
}
