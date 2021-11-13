package shopping.kernel;

public interface Repository<T, E> {
    T nextId();

    E findById(T id) throws NoSuchEntityException;

    void add(E entity);

    void delete(T id);
}
