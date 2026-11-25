package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class h<E> extends AbstractSet<E> implements Set<E>, j5.h {
    protected h() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e8);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
