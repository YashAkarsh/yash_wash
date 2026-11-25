package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, j5.b {
    protected e() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e8);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
