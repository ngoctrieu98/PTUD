/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.connect;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author os-phungbm
 */
 
public class MyEntityManagerFactory {

    private static MyEntityManagerFactory instance = null;

    private EntityManager entityManager;

    private MyEntityManagerFactory() {

        entityManager = Persistence.createEntityManagerFactory("QuanLyPhongTro_application").createEntityManager();

    }

    public synchronized static MyEntityManagerFactory getInstance() {
        if (instance == null) {
            instance = new MyEntityManagerFactory();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
