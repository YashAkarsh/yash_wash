package v;

import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import i5.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@f
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final List<g<?>> f40427a = new ArrayList();

    public final <T extends k0> void a(@a7.d kotlin.reflect.d<T> clazz, @a7.d l<? super a, ? extends T> initializer) {
        l0.p(clazz, "clazz");
        l0.p(initializer, "initializer");
        this.f40427a.add(new g<>(h5.a.e(clazz), initializer));
    }

    @a7.d
    public final m0.b b() {
        Object[] array = this.f40427a.toArray(new g[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        g[] gVarArr = (g[]) array;
        return new b((g[]) Arrays.copyOf(gVarArr, gVarArr.length));
    }
}
