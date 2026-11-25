package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class m1<T> implements d0<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private i5.a<? extends T> f34963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private volatile Object f34964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Object f34965c;

    public m1(@a7.d i5.a<? extends T> initializer, @a7.e Object obj) {
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        this.f34963a = initializer;
        this.f34964b = e2.f34722a;
        this.f34965c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // kotlin.d0
    public boolean a() {
        return this.f34964b != e2.f34722a;
    }

    @Override // kotlin.d0
    public T getValue() {
        T tInvoke;
        T t7 = (T) this.f34964b;
        e2 e2Var = e2.f34722a;
        if (t7 != e2Var) {
            return t7;
        }
        synchronized (this.f34965c) {
            tInvoke = (T) this.f34964b;
            if (tInvoke == e2Var) {
                i5.a<? extends T> aVar = this.f34963a;
                kotlin.jvm.internal.l0.m(aVar);
                tInvoke = aVar.invoke();
                this.f34964b = tInvoke;
                this.f34963a = null;
            }
        }
        return tInvoke;
    }

    @a7.d
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ m1(i5.a aVar, Object obj, int i7, kotlin.jvm.internal.w wVar) {
        this(aVar, (i7 & 2) != 0 ? null : obj);
    }
}
