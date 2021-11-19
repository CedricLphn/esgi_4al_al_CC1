package common.infrastructure;

import common.NoSuchEntityException;
import common.Repository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class InMemoryRepositoryAbstract<T> implements Repository<Integer, T> {

    private final AtomicInteger size = new AtomicInteger(0);
    private final Map<Integer, T> list = new ConcurrentHashMap<Integer, T>();

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
}
