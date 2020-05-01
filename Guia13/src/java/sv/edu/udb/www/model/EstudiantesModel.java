/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import sv.edu.udb.www.utils.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import sv.edu.udb.www.entities.EstudianteEntity;

/**
 *
 * @author Rick
 */
public class EstudiantesModel {

    public List<EstudianteEntity> listarEstudiante() {
        //Obtengo una instancia de EntityManager
        EntityManager em = JPAUtil.getEM();
        try {
            Query consulta = em.createNamedQuery("EstudianteEntity.findAll");
            //El método getResultList() de la clase Query permite obtener
            // la lista de resultados de una consulta de selección
            List<EstudianteEntity> lista = consulta.getResultList();
            em.close();// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public EstudianteEntity obtenerEstudiante(String carnet) {
        EntityManager em = JPAUtil.getEM();
        try {
            //Recupero el objeto desde la BD a través del método find
            EstudianteEntity estudiante = em.find(EstudianteEntity.class, carnet);
            em.close();
            return estudiante;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }

    public int insertarEstudiante(EstudianteEntity estudiante) {
        EntityManager em = JPAUtil.getEM();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.persist(estudiante); //Guardando el objeto en la BD
            tran.commit();//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int modificarEstudiante(EstudianteEntity estudiante) {
        EntityManager em = JPAUtil.getEM();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();//Iniciando transacción
            em.merge(estudiante); //Actualizando el objeto en la BD
            tran.commit();
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

    public int eliminarEstudiante(String carnet) {
        EntityManager em = JPAUtil.getEM();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            EstudianteEntity est = em.find(EstudianteEntity.class, carnet);
            if (est != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();//Iniciando transacción
                em.remove(est);//Borrando la instancia
                tran.commit();//Confirmando la transacción
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
}
