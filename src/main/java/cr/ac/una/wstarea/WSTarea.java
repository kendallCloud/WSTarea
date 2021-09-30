/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea;

import cr.ac.una.wstarea.Dto.EmpleadoDto;
import cr.ac.una.wstarea.Service.EmpleadoService;
import cr.ac.una.wstarea.Util.Reportes;
import cr.ac.una.wstarea.Util.Respuesta;
import java.io.FileNotFoundException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Kendall
 */
@WebService(serviceName = "WSTarea")
public class WSTarea {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    /**
     *
     * @param folio
     * @return
     */
    @WebMethod(operationName = "validar")
     public String Validar(@WebParam(name = "folio") String folio){
         String folios[]={"098w","6s4","ab12","af32"};
         
         String result="No se encontró el folio.\n";
         
         for(String val:folios){
                if(val == null ? folio == null : val.equals(folio)) result="si existe el folio.\n";
            }
         
        return result;
         
     }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarAdmin")
    public Boolean ValidarAdmin(@WebParam(name = "psswrd") String psswrd, @WebParam(name = "folio") String folio) {
     
        
        EmpleadoService user = new EmpleadoService();
        Respuesta result = user.BuscarFolio(folio);
        EmpleadoDto admin = (EmpleadoDto) result.getResultado();
        
        return (result.getEstado()  &&  (admin.getPsswr() == null ? psswrd == null : admin.getPsswr().equals(psswrd)));
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetUltimaMarca")
    public Date GetUltimaMarca(@WebParam(name = "ahora") Date ahora, @WebParam(name = "folio") String folio) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
//     * @return 
//     * @throws java.io.FileNotFoundException
//     * @throws net.sf.jasperreports.engine.JRException
//     * @throws java.sql.SQLException
    */
    @WebMethod(operationName = "pdf")
    public String pdf() {
        try {
            //        //TODO write your implementation code here:
//
Reportes r = new Reportes();
//
return r.generarReporteEmpleados2();
//        
//
//    }

//    /**
//     * Web service operation
//     */
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WSTarea.class.getName()).log(Level.SEVERE, null, ex);
            return "Archivo no encontrado";
        } catch (SQLException ex) {
            Logger.getLogger(WSTarea.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL exception";
        } catch (JRException ex) {
            Logger.getLogger(WSTarea.class.getName()).log(Level.SEVERE, null, ex);
            return "JRE Exception";
        } catch (NamingException ex) {
            Logger.getLogger(WSTarea.class.getName()).log(Level.SEVERE, null, ex);
            return "Naming Exception";
        }
//        return null;
  
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "prueba")
    public String prueba() {
        //TODO write your implementation code here:
        return "SIUUUUUUUUUUUU";
    }
}
    



