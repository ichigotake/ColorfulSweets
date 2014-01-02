package net.ichigotake.colorfulsweets.lib.model;

import java.util.Collection;

public interface MutableList<E> extends ReadableList<E> {

    void clear();

    void remove(int location);

    void add(E item);

    void addAll(Collection<E> collection);
}
