package fr.leprohon.esgi.al4.al.kernel.infrastructure;

import fr.leprohon.esgi.al4.al.kernel.exception.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class InMemoryRepositoryAbstract<T> implements Repository<Integer, T> {

    private final AtomicInteger size = new AtomicInteger(0);
    protected final Map<Integer, T> list = new ConcurrentHashMap<Integer, T>();

    @Override
    public Integer nextId() {
        return size.incrementAndGet();
    }

    @Override
    public T findById(Integer id) throws NoSuchEntityException {
        return list.get(id);
    }

    @Override
    public void add(T entity) {
        list.put(nextId(), entity);
    }

    @Override
    public void delete(Integer id) {
        list.remove(id);
    }

    @Override
    public void update(Integer id, T data) {
        list.put(id, data);
    }

    public Map<Integer, T> findAll() {
        return list;
    }

    @Override
    public String toString() {
        return "InMemoryRepositoryAbstract{" +
                "size=" + size +
                ", list=" + list +
                '}';
    }
}
