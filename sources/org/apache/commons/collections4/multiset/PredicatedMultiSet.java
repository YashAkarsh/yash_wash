package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: loaded from: classes3.dex */
public class PredicatedMultiSet<E> extends PredicatedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    protected PredicatedMultiSet(MultiSet<E> multiSet, Predicate<? super E> predicate) {
        super(multiSet, predicate);
    }

    public static <E> PredicatedMultiSet<E> predicatedMultiSet(MultiSet<E> multiSet, Predicate<? super E> predicate) {
        return new PredicatedMultiSet<>(multiSet, predicate);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E e8, int i7) {
        validate(e8);
        return decorated().add(e8, i7);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i7) {
        return decorated().remove(obj, i7);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e8, int i7) {
        validate(e8);
        return decorated().setCount(e8, i7);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }
}
