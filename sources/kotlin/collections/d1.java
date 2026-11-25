package kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class d1 extends c1 {
    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> L0(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rZ = selector.z(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rZ2 = selector.z(entry3);
                    if (rZ.compareTo(rZ2) < 0) {
                        entry2 = entry3;
                        rZ = rZ2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ <K, V> Map.Entry<K, V> M0(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.Q3(map.entrySet(), comparator);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> N0(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rZ = selector.z(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rZ2 = selector.z(entry3);
                    if (rZ.compareTo(rZ2) > 0) {
                        entry2 = entry3;
                        rZ = rZ2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Map.Entry O0(Map map, Comparator comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.i4(map.entrySet(), comparator);
    }
}
