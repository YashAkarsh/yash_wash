package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class m2<T> implements d0<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private i5.a<? extends T> f34966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private Object f34967b;

    public m2(@a7.d i5.a<? extends T> initializer) {
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        this.f34966a = initializer;
        this.f34967b = e2.f34722a;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // kotlin.d0
    public boolean a() {
        return this.f34967b != e2.f34722a;
    }

    @Override // kotlin.d0
    public T getValue() {
        if (this.f34967b == e2.f34722a) {
            i5.a<? extends T> aVar = this.f34966a;
            kotlin.jvm.internal.l0.m(aVar);
            this.f34967b = aVar.invoke();
            this.f34966a = null;
        }
        return (T) this.f34967b;
    }

    @a7.d
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
