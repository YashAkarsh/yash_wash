package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends kotlin.collections.h<E> {
    public final boolean b(@a7.d E element) {
        l0.p(element, "element");
        return d(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return b((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean d(@a7.d Map.Entry<? extends K, ? extends V> entry);

    public /* bridge */ boolean f(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return f((Map.Entry) obj);
        }
        return false;
    }
}
