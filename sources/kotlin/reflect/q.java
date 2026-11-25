package kotlin.reflect;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
public interface q<T, V> extends o<V>, i5.l<T, V> {

    public interface a<T, V> extends o.c<V>, i5.l<T, V> {
    }

    @Override // kotlin.reflect.o
    @a7.d
    a<T, V> a();

    V get(T t7);

    @g1(version = "1.1")
    @a7.e
    Object n(T t7);
}
