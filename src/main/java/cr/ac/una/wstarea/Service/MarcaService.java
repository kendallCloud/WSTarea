/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Service;

import cr.ac.una.wstarea.Dto.EmpleadoDto;
import cr.ac.una.wstarea.Dto.MarcaDto;
import cr.ac.una.wstarea.Model.Empleado;
import cr.ac.una.wstarea.Model.Marca;
import cr.ac.una.wstarea.Util.CodigoRespuesta;
import cr.ac.una.wstarea.Util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Kendall
 */

@LocalBean
@Stateless

public class MarcaService {
      private static final Logger LOG = Logger.getLogger(MarcaService.class.getName());
      private EntityManager em;
        public EntityTransaction et;
      
      
           public Respuesta guardarMarca(MarcaDto dto,boolean nuevo){
            try {
                et = em.getTransaction();
                et.begin();
                Marca entity = new Marca();
                CodigoRespuesta cr;
               //nueva partida.
           if(nuevo){
                entity = new Marca(dto);
                em.persist(entity);//Guardo en BD
           }else{
                entity = em.find(Marca.class,dto.getId());
                if(entity == null){
                   et.rollback();
                   return new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO,"", "NoResultException");
                }
              //  entity.Actualizar(dto);
                entity = em.merge(entity);
           } 
            et.commit();
            return new Respuesta(true,CodigoRespuesta.CORRECTO ,"Se guardó la marca  exitosamente", "", "Marca", new MarcaDto(entity));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, "Ocurrio un error al registrar la partida", ex);
            return new Respuesta(Boolean.FALSE,CodigoRespuesta.ERROR_INTERNO ,"Ocurrio un error al registrar la partida", ex.getMessage());
            }
    }
         
         
         
      
      
}
