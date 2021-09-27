/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Model;

import cr.ac.una.wstarea.Dto.EmpleadoDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "Empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByFolio", query = "SELECT e FROM Empleado e WHERE e.folio = :folio"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleado.findByCedula", query = "SELECT e FROM Empleado e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empleado.findByAdmin", query = "SELECT e FROM Empleado e WHERE e.admin = :admin"),
    @NamedQuery(name = "Empleado.findByFechaNac", query = "SELECT e FROM Empleado e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleado.findByPasswrd", query = "SELECT e FROM Empleado e WHERE e.passwrd = :passwrd"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "folio")
    private String folio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin")
    private Long admin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Size(max = 30)
    @Column(name = "passwrd")
    private String passwrd;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "foto")
    private byte[]  foto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;

    public Empleado() {
    }

    public Empleado(Long id) {
        this.id = id;
    }

    public Empleado(Long id, String folio, String nombre, String apellido, String cedula, Long admin, Date fechaNac, byte[] foto) {
        this.id = id;
        this.folio = folio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.admin = admin;
        this.fechaNac = fechaNac;
        this.foto = foto;
    }

    public Empleado(EmpleadoDto empl) {
         this.id = empl.getId();
        this.folio =  empl.getFolio();
        this.nombre =  empl.getName() ;
        this.apellido =  empl.getLastname() ;
        this.cedula = empl.getCedula();
      if(empl.isAdmin())  this.admin = Long.valueOf(1);
      else this.admin = Long.valueOf(0);
      this.fechaNac = empl.getNacimiento();
       this.foto = empl.getFoto();
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
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

    public Long getAdmin() {
        return admin;
    }

    public void setAdmin(Long admin) {
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wstarea.Model.Empleado[ id=" + id + " ]";
    }

    public void NuevoEmpleado(EmpleadoDto empl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
