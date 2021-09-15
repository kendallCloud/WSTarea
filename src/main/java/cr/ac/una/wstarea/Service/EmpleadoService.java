/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Service;

import cr.ac.una.wstarea.Dto.EmpleadoDto;
import cr.ac.una.wstarea.Model.Empleado;
import cr.ac.una.wstarea.Service.Util.CodigoRespuesta;
import cr.ac.una.wstarea.Service.Util.Respuesta;
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
      private EntityManager em;
      
       public Respuesta validarFolio(String folio) {
           
             try {
            Query qry = em.createNamedQuery("Empleado.findByPkFolio", Empleado.class);
            qry.setParameter("pkFolio",folio);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Empleado", new EmpleadoDto((Empleado) qryActividad.getSingleResult()));
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
      
}
