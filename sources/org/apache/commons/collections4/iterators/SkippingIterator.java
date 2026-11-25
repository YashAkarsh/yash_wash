package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SkippingIterator<E> extends AbstractIteratorDecorator<E> {
    private final long offset;
    private long pos;

    public SkippingIterator(Iterator<E> it, long j7) {
        super(it);
        if (j7 < 0) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        this.offset = j7;
        this.pos = 0L;
        init();
    }

    private void init() {
        while (this.pos < this.offset && hasNext()) {
            next();
        }
    }

    @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
    public E next() {
        E e8 = (E) super.next();
        this.pos++;
        return e8;
    }

    @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
    public void remove() {
        if (this.pos <= this.offset) {
            throw new IllegalStateException("remove() can not be called before calling next()");
        }
        super.remove();
    }
}
