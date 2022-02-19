/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.connect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author phungbm
 * @param <T>
 */
public abstract class GeneralCRUD<T> {

    protected EntityManager em;

    public GeneralCRUD() {
        em = MyEntityManagerFactory.getInstance().getEntityManager();
    }

    //crud
    public boolean save(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public boolean update(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public boolean delete(Class<T> t, String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.remove(em.find(t, id));
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public List<T> getAll(Class<T> t) {

        String[] name = t.getName().split("\\.");
       
        String sql="select t from "+ name[1]+" t";
        Query q=em.createQuery(sql);
        return q.getResultList();
    }
    public boolean updateCondition(Class<T>    t, String nameCondition, Object valueCondition, String key, String keyValue) {
        int rows = 0;
        EntityTransaction tr = em.getTransaction();
        String sql="UPDATE "
                + t.getName()+" e SET e." 
                + nameCondition +" = '"
                + valueCondition+"'" + " WHERE e." 
                + key + " = " + "'" 
                + keyValue + "'" ;
        System.out.println(sql);
        try{
            tr.begin();
            Query q = em.createQuery(sql);
            rows =  q.executeUpdate();
            System.out.println(rows);
        }catch(Exception e){
            tr.rollback();
            e.printStackTrace();
        }
        return rows < 0 ? false : true;
    }
    
    public List<T> getAllByCondition(Class<T> t, String nameCondition, Object condition) {
        String query = t.getName().split("\\.")[1] + ".findBy" + nameCondition;
        System.out.println(query);
        NamedQuery[] namedQueries = t.getAnnotation(NamedQueries.class).value();
        for (NamedQuery namedQuery : namedQueries) {
            if (query.equalsIgnoreCase(namedQuery.name())) {
                String parameter = "";
                for(Field field : t.getDeclaredFields()){
                    if (nameCondition.equalsIgnoreCase(field.getName())) {
                        parameter = field.getName();
                    }
                }
                try {
                    return em.createNamedQuery(namedQuery.name()).setParameter(parameter, condition).setHint(QueryHints.REFRESH, HintValues.TRUE).getResultList();
                } catch(NoResultException exception) {
                    return new ArrayList<>();
                }
            }
        }
        return new ArrayList<>();
    }
    
    /**
     *
     * @param t
     * @param nameCondition
     * @param condition
     * @return
     */
    public Object getOneByCondition(Class<T> t, String nameCondition, Object condition) {
        String query = t.getName().split("\\.")[1] + ".findBy" + nameCondition;
        System.out.println(query);
        NamedQuery[] namedQueries = t.getAnnotation(NamedQueries.class).value();
        for (NamedQuery namedQuery : namedQueries) {
            if (query.equalsIgnoreCase(namedQuery.name())) {
                String parameter = "";
                for(Field field : t.getDeclaredFields()){
                    if (nameCondition.equalsIgnoreCase(field.getName())) {
                        parameter = field.getName();
                    }
                }
                try {
                    return em.createNamedQuery(namedQuery.name()).setParameter(parameter, condition).setHint(QueryHints.REFRESH, HintValues.TRUE).getSingleResult();
                } catch (NoResultException exception) {
                    return null;
                }
            }
        }
        return null;
    }

    
}
