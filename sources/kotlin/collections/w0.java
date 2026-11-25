package kotlin.collections;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "MapAccessorsKt")
public final class w0 {
    @kotlin.internal.f
    private static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.o<?> property) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        return (V1) a1.a(map, property.getName());
    }

    @h5.h(name = "getVar")
    @kotlin.internal.f
    private static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.o<?> property) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        return (V1) a1.a(map, property.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <V> void c(Map<? super String, ? super V> map, Object obj, kotlin.reflect.o<?> property, V v7) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        map.put(property.getName(), v7);
    }
}
