package z4;

import h5.h;
import java.util.Map;
import kotlin.g1;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "CollectionsJDK8Kt")
public final class a {
    @g1(version = "1.2")
    @f
    private static final <K, V> V a(Map<? extends K, ? extends V> map, K k7, V v7) {
        l0.p(map, "<this>");
        return (V) map.getOrDefault(k7, v7);
    }

    @g1(version = "1.2")
    @f
    private static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k7, V v7) {
        l0.p(map, "<this>");
        return map.remove(k7, v7);
    }
}
