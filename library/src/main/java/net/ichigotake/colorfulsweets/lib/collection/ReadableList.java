package net.ichigotake.colorfulsweets.lib.collection;

import java.util.Collection;
import java.util.List;

public interface ReadableList<E> {

    E get(int location);

    int size();

    boolean isEmpty();

    boolean contains(E item);

    boolean containsAll(Collection<E> collection);

    List<E> toList();

    E[] toArray();
}
