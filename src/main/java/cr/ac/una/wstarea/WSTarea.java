/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.lang.String;

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
         String folios[]={"098w","6s4","ab12","af32"};
         
         String result="No se encontró el folio.\n";
         
         for(String val:folios){
                if(val == null ? folio == null : val.equals(folio)) result="si existe el folio.\n";
            }
         
        return result;
         
     }
    
}



