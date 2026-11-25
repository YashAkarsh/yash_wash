package kotlin.reflect;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "KClasses")
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.4")
    @kotlin.internal.h
    @a7.d
    @q2(markerClass = {kotlin.s.class})
    public static final <T> T a(@a7.d d<T> dVar, @a7.e Object obj) {
        l0.p(dVar, "<this>");
        if (dVar.e0(obj)) {
            l0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + dVar.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.4")
    @kotlin.internal.h
    @a7.e
    @q2(markerClass = {kotlin.s.class})
    public static final <T> T b(@a7.d d<T> dVar, @a7.e Object obj) {
        l0.p(dVar, "<this>");
        if (!dVar.e0(obj)) {
            return null;
        }
        l0.n(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return obj;
    }
}
