package fr.leprohon.esgi.al4.al.kernel.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.exception.NoSuchEntityException;

public interface Repository<T, E> {
    T nextId();

    E findById(T id) throws NoSuchEntityException;

    void add(E entity);

    void update(T id, E data);

    void delete(T id);
}
