package androidx.core.util;

import c.t0;
import java.util.function.Consumer;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@t0(24)
public final class g {
    @a7.d
    @t0(24)
    public static final <T> Consumer<T> a(@a7.d kotlin.coroutines.d<? super T> dVar) {
        l0.p(dVar, "<this>");
        return f.a(new h(dVar));
    }
}
