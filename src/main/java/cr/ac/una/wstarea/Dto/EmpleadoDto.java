/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Dto;

import cr.ac.una.wstarea.Model.Empleado;
import java.time.LocalDate;
import java.util.Date;

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
    private MarcaDto marc;
    
    public EmpleadoDto(Empleado empleado){
         this.folio = empleado.getPkFolio();
         this.name = empleado.getNombre();
         this.lastname = empleado.getApellido();
          this.admin = (empleado.getAdmin().intValue()==1);
           this.nacimiento = empleado.getFechaNac();
           this.marc = new MarcaDto (empleado.getMarca());
    }
    
    
     
}
