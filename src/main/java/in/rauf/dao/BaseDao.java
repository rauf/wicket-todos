package in.rauf.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Optional;

public abstract class BaseDao<E, K> implements Dao<E, K>, Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "DefaultPersistenceUnit";
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    protected Class entityClass;

    public BaseDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public void persist(E entity) {
        var entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(E entity) {
        var entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<E> findById(K id) {
        var entityManager = getEntityManager();
        return Optional.ofNullable((E) entityManager.find(entityClass, id));
    }

    @Override
    public Class getEntityClass() {
        return entityClass;
    }

    @Override
    public Collection<E> findAll() {
        var entityManager = getEntityManager();
        var query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
        return query.getResultList();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}