package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBagDecorator<E> extends AbstractCollectionDecorator<E> implements Bag<E> {
    private static final long serialVersionUID = -3768146017343785417L;

    protected AbstractBagDecorator() {
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e8, int i7) {
        return decorated().add(e8, i7);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i7) {
        return decorated().remove(obj, i7);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    protected AbstractBagDecorator(Bag<E> bag) {
        super(bag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Bag<E> decorated() {
        return (Bag) super.decorated();
    }
}
