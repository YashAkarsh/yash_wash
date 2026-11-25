package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public E pop() throws EmptyStackException {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public E push(E e8) {
        add(e8);
        return e8;
    }

    public int search(Object obj) {
        int i7 = 1;
        int size = size() - 1;
        while (size >= 0) {
            E e8 = get(size);
            if ((obj == null && e8 == null) || (obj != null && obj.equals(e8))) {
                return i7;
            }
            size--;
            i7++;
        }
        return -1;
    }

    public ArrayStack(int i7) {
        super(i7);
    }

    public E peek(int i7) throws EmptyStackException {
        int size = (size() - i7) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }
}
