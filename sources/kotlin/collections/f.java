package kotlin.collections;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class f<E> extends AbstractList<E> implements List<E>, j5.e {
    protected f() {
    }

    public abstract int a();

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i7, E e8);

    public abstract E b(int i7);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i7) {
        return b(i7);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i7, E e8);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
