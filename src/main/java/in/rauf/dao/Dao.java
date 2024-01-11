package in.rauf.dao;


import java.util.Collection;
import java.util.Optional;

interface Dao<E, K> {
    void persist(E entity);

    void remove(E entity);

    Optional<E> findById(K id);

    Collection<E> findAll();

    Class getEntityClass();
}
