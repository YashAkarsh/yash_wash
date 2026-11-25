package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
final class f1<T> implements d0<T>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f34724d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<f1<?>, Object> f34725e = AtomicReferenceFieldUpdater.newUpdater(f1.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private volatile i5.a<? extends T> f34726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private volatile Object f34727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Object f34728c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
        }
    }

    public f1(@a7.d i5.a<? extends T> initializer) {
        kotlin.jvm.internal.l0.p(initializer, "initializer");
        this.f34726a = initializer;
        e2 e2Var = e2.f34722a;
        this.f34727b = e2Var;
        this.f34728c = e2Var;
    }

    private final Object writeReplace() {
        return new x(getValue());
    }

    @Override // kotlin.d0
    public boolean a() {
        return this.f34727b != e2.f34722a;
    }

    @Override // kotlin.d0
    public T getValue() {
        T t7 = (T) this.f34727b;
        e2 e2Var = e2.f34722a;
        if (t7 != e2Var) {
            return t7;
        }
        i5.a<? extends T> aVar = this.f34726a;
        if (aVar != null) {
            T tInvoke = aVar.invoke();
            if (androidx.concurrent.futures.b.a(f34725e, this, e2Var, tInvoke)) {
                this.f34726a = null;
                return tInvoke;
            }
        }
        return (T) this.f34727b;
    }

    @a7.d
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
