/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea;

import com.sun.xml.wss.saml.internal.saml11.jaxb10.Object;
import cr.ac.una.wstarea.Dto.EmpleadoDto;
import cr.ac.una.wstarea.Dto.MarcaDto;
import cr.ac.una.wstarea.Service.EmpleadoService;
import cr.ac.una.wstarea.Service.MarcaService;
import cr.ac.una.wstarea.Util.Respuesta;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.Date;

/**
 *
 * @author Kendall
 */
@WebService(serviceName = "WSTarea")
public class WSTarea {

    /**
     * This is a sample web service operation
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
        EmpleadoService user = new EmpleadoService();
        Respuesta result = user.BuscarFolio(folio);
        EmpleadoDto admin = (EmpleadoDto) result.getResultado();
         
         String resultado="No se encontró el folio.\n";
         
         if(result.getEstado()) resultado=" se encontró el folio.\n";
         
        return resultado;
         
     }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarAdmin")
    public Boolean ValidarAdmin(@WebParam(name = "psswrd") String psswrd, @WebParam(name = "folio") String folio) { 
        
        EmpleadoService user = new EmpleadoService();
        Respuesta result = user.BuscarFolio(folio);
        EmpleadoDto admin = (EmpleadoDto) result.getResultado();
        
        return result.getEstado();
        
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
     */
    @WebMethod(operationName = "GuaradarEmpleado")
    public Boolean GuaradarEmpleado(@WebParam(name = "emp") java.lang.Object emp) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CorregirFecha")
    public Boolean CorregirFecha(@WebParam(name = "fecha") Date fecha, @WebParam(name = "folio_emp") String folio_emp, @WebParam(name = "salida") Boolean salida) {
        
        EmpleadoService user = new EmpleadoService();
        Respuesta result = user.BuscarFolio(folio_emp);
        EmpleadoDto admin = (EmpleadoDto) result.getResultado();
        MarcaDto up = null;
        if(admin!=null)  up = new MarcaDto(fecha,admin.getId(),salida);
      
        MarcaService marca = new MarcaService();
        Respuesta subir = marca.guardarMarca(up,true);
        return null;
    }


    /**
     * Web service operation
     */
  
    
}



