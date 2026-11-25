package androidx.databinding;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface x<K, V> extends Map<K, V> {

    public static abstract class a<T extends x<K, V>, K, V> {
        public abstract void a(T t7, K k7);
    }

    void U(a<? extends x<K, V>, K, V> aVar);

    void V(a<? extends x<K, V>, K, V> aVar);
}
