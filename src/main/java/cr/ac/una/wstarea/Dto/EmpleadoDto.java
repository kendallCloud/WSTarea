/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Dto;

import cr.ac.una.wstarea.Model.Empleado;
import cr.ac.una.wstarea.Model.Marca;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kendall
 */
public class EmpleadoDto {
    private String folio;
    private String name;
    private String lastname;
    private String cedula;
    private boolean admin;
    private final Date nacimiento;
    private Long id;
    private String psswr;
    
    
    public EmpleadoDto(Empleado empleado){
        this.id = empleado.getId();
        this.folio = empleado.getFolio();
        this.name = empleado.getNombre();
        this.lastname = empleado.getApellido();
        this.admin = (empleado.getAdmin().intValue()==1);
        this.nacimiento = empleado.getFechaNac();
        this.psswr = empleado.getPasswrd();
      //  this.marc = (List<MarcaDto>) new MarcaDto ((Marca) empleado.getMarca());
    }     

    public String getPsswr() {
        return psswr;
    }

    public void setPsswr(String psswr) {
        this.psswr = psswr;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
/*
    public List<MarcaDto> getMarc() {
        return marc;
    }

    public void setMarc(List<MarcaDto> marc) {
        this.marc = marc;
    }
     */
    
    
}
