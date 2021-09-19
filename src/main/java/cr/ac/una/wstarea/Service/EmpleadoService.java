/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Service;

import cr.ac.una.wstarea.Dto.EmpleadoDto;
import cr.ac.una.wstarea.Model.Empleado;
import cr.ac.una.wstarea.Util.CodigoRespuesta;
import cr.ac.una.wstarea.Util.EntityManagerHelper;
import cr.ac.una.wstarea.Util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Kendall
 */
public class EmpleadoService {
      private static final Logger LOG = Logger.getLogger(MarcaService.class.getName());
      private final EntityManager em = EntityManagerHelper.getManager();
      
       public Respuesta BuscarFolio(String folio) {
           
             try {
            Query qry = em.createNamedQuery("Empleado.findByFolio",Empleado.class);
          if(null!=qry)  qry.setParameter("folio",folio);

               return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmpleadoDto((Empleado) qry.getSingleResult()));
            }
             catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
           
       }
              
       public Respuesta guardarEmpleado(EmpleadoDto empl) {
        try {
            Empleado empleado;
            if (empl.getFolio() != null && !"".equals(empl.getFolio())){
                empleado = em.find(Empleado.class, empl.getFolio());
                if (empleado == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe registro del folio ingresado.", "guardarEmpleado NoResultException");
                }
                empleado.NuevoEmpleado(empl);
                empleado = em.merge(empleado);
            } else {
                empleado = new Empleado(empl);
                em.persist(empleado);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmpleadoDto(empleado));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el empleado.", "guardarEmpleado " + ex.getMessage());
        }
    }
      
}
