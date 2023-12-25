package com.ra;

public interface Service <E>{
    boolean add(E item);
    boolean edit(E item);
    boolean remove(E item);
}
