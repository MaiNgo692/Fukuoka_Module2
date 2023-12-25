package com.ra;

public class GenericService <E> implements Service<E>{
    @Override
    public boolean add(E item) {
        return false;
    }

    @Override
    public boolean edit(E item) {
        return false;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }
}
