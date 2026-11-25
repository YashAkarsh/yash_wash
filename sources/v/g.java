package v;

import androidx.lifecycle.k0;
import i5.l;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class g<T extends k0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Class<T> f40428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final l<a, T> f40429b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@a7.d Class<T> clazz, @a7.d l<? super a, ? extends T> initializer) {
        l0.p(clazz, "clazz");
        l0.p(initializer, "initializer");
        this.f40428a = clazz;
        this.f40429b = initializer;
    }

    @a7.d
    public final Class<T> a() {
        return this.f40428a;
    }

    @a7.d
    public final l<a, T> b() {
        return this.f40429b;
    }
}
