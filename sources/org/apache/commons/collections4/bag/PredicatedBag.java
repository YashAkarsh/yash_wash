package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: loaded from: classes3.dex */
public class PredicatedBag<E> extends PredicatedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = -2575833140344736876L;

    protected PredicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        super(bag, predicate);
    }

    public static <E> PredicatedBag<E> predicatedBag(Bag<E> bag, Predicate<? super E> predicate) {
        return new PredicatedBag<>(bag, predicate);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e8, int i7) {
        validate(e8);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Bag<E> decorated() {
        return (Bag) super.decorated();
    }
}
