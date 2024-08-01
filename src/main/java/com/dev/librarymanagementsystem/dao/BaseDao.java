package com.dev.librarymanagementsystem.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class BaseDao<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> entityClass;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T getById(ID id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            // Add appropriate logging or error handling here
            throw new RuntimeException("Error fetching entity by ID", e);
        }
    }

    public List<T> getAll() {
        try {
            Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
            return (List<T>) query.getResultList();
        } catch (Exception e) {
            // Add appropriate logging or error handling here
            throw new RuntimeException("Error fetching all entities", e);
        }
    }

    public T save(T entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            // Add appropriate logging or error handling here
            throw new RuntimeException("Error saving entity", e);
        }
    }

    public T update(T entity) {
        try {
            entityManager.detach(entity);
            return entityManager.merge(entity);
        } catch (Exception e) {
            // Add appropriate logging or error handling here
            throw new RuntimeException("Error updating entity", e);
        }
    }

    public void delete(ID id) {
        try {
            T entity = entityManager.find(entityClass, id);
            if (entity != null) {
                entityManager.remove(entity);
            } else {
                throw new RuntimeException("Entity not found for deletion");
            }
        } catch (Exception e) {
            // Add appropriate logging or error handling here
            throw new RuntimeException("Error deleting entity", e);
        }
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
