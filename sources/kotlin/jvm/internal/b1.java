package kotlin.jvm.internal;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public final class b1 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Class<?> f34837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final String f34838b;

    public b1(@a7.d Class<?> jClass, @a7.d String moduleName) {
        l0.p(jClass, "jClass");
        l0.p(moduleName, "moduleName");
        this.f34837a = jClass;
        this.f34838b = moduleName;
    }

    public boolean equals(@a7.e Object obj) {
        return (obj instanceof b1) && l0.g(s(), ((b1) obj).s());
    }

    public int hashCode() {
        return s().hashCode();
    }

    @Override // kotlin.reflect.h
    @a7.d
    public Collection<kotlin.reflect.c<?>> i() {
        throw new h5.p();
    }

    @Override // kotlin.jvm.internal.t
    @a7.d
    public Class<?> s() {
        return this.f34837a;
    }

    @a7.d
    public String toString() {
        return s().toString() + " (Kotlin reflection is not available)";
    }
}
