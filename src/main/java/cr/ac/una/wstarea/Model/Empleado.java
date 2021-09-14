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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Kendall
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByPkFolio", query = "SELECT e FROM Empleado e WHERE e.pkFolio = :pkFolio"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleado.findByCedula", query = "SELECT e FROM Empleado e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empleado.findByAdmin", query = "SELECT e FROM Empleado e WHERE e.admin = :admin"),
    @NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleado.findByPasswrd", query = "SELECT e FROM Empleado e WHERE e.passwrd = :passwrd")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pk_folio")
    private String pkFolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String cedula;
    @Basic(optional = false)
    @NotNull
    private BigInteger admin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Size(max = 30)
    private String passwrd;
    @Basic(optional = false)
    @NotNull
    @Lob
    private Serializable foto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Marca marca;

    public Empleado() {
    }

    public Empleado(String pkFolio) {
        this.pkFolio = pkFolio;
    }

    public Empleado(String pkFolio, String nombre, String apellido, String cedula, BigInteger admin, Date fechaNac, Serializable foto) {
        this.pkFolio = pkFolio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.admin = admin;
        this.fechaNac = fechaNac;
        this.foto = foto;
    }

    public String getPkFolio() {
        return pkFolio;
    }

    public void setPkFolio(String pkFolio) {
        this.pkFolio = pkFolio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public BigInteger getAdmin() {
        return admin;
    }

    public void setAdmin(BigInteger admin) {
        this.admin = admin;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.pkFolio == null && other.pkFolio != null) || (this.pkFolio != null && !this.pkFolio.equals(other.pkFolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wstarea.Model.Empleado[ pkFolio=" + pkFolio + " ]";
    }
    
}
