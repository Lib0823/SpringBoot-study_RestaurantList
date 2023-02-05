package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        // 와일드카드 MemotyDbEntity에서 getIndex()를 호출하여 DB에서 해당 index에 해당되는 값을 찾아옴.
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List<T> listAll() {
        return null;
    }
}
