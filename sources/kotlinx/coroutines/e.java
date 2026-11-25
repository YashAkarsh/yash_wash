package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f35980b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d1<T>[] f35981a;

    @a7.d
    volatile /* synthetic */ int notCompletedCount;

    private final class a extends v2 {

        @a7.d
        private volatile /* synthetic */ Object _disposer = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        private final q<List<? extends T>> f35982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q1 f35983f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(q<? super List<? extends T>> qVar) {
            this.f35982e = qVar;
        }

        @Override // kotlinx.coroutines.g0
        public void V0(@a7.e Throwable th) {
            if (th != null) {
                Object objJ = this.f35982e.J(th);
                if (objJ != null) {
                    this.f35982e.t0(objJ);
                    e<T>.b bVarY0 = Y0();
                    if (bVarY0 == null) {
                        return;
                    }
                    bVarY0.d();
                    return;
                }
                return;
            }
            if (e.f35980b.decrementAndGet(e.this) == 0) {
                q<List<? extends T>> qVar = this.f35982e;
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                d1[] d1VarArr = ((e) e.this).f35981a;
                ArrayList arrayList = new ArrayList(d1VarArr.length);
                int length = d1VarArr.length;
                int i7 = 0;
                while (i7 < length) {
                    d1 d1Var = d1VarArr[i7];
                    i7++;
                    arrayList.add(d1Var.u());
                }
                qVar.w(kotlin.d1.b(arrayList));
            }
        }

        @a7.e
        public final e<T>.b Y0() {
            return (b) this._disposer;
        }

        @a7.d
        public final q1 Z0() {
            q1 q1Var = this.f35983f;
            if (q1Var != null) {
                return q1Var;
            }
            kotlin.jvm.internal.l0.S("handle");
            return null;
        }

        public final void a1(@a7.e e<T>.b bVar) {
            this._disposer = bVar;
        }

        public final void b1(@a7.d q1 q1Var) {
            this.f35983f = q1Var;
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
            V0(th);
            return kotlin.l2.f34958a;
        }
    }

    private final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final e<T>.a[] f35985a;

        public b(e<T>.a[] aVarArr) {
            this.f35985a = aVarArr;
        }

        @Override // kotlinx.coroutines.p
        public void b(@a7.e Throwable th) {
            d();
        }

        public final void d() {
            e<T>.a[] aVarArr = this.f35985a;
            int length = aVarArr.length;
            int i7 = 0;
            while (i7 < length) {
                e<T>.a aVar = aVarArr[i7];
                i7++;
                aVar.Z0().F();
            }
        }

        @a7.d
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f35985a + ']';
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
            b(th);
            return kotlin.l2.f34958a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@a7.d d1<? extends T>[] d1VarArr) {
        this.f35981a = d1VarArr;
        this.notCompletedCount = d1VarArr.length;
    }

    @a7.e
    public final Object b(@a7.d kotlin.coroutines.d<? super List<? extends T>> dVar) {
        r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        int length = this.f35981a.length;
        a[] aVarArr = new a[length];
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            d1 d1Var = this.f35981a[i8];
            d1Var.start();
            a aVar = new a(rVar);
            aVar.b1(d1Var.g0(aVar));
            kotlin.l2 l2Var = kotlin.l2.f34958a;
            aVarArr[i8] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        while (i7 < length) {
            a aVar2 = aVarArr[i7];
            i7++;
            aVar2.a1(bVar);
        }
        if (rVar.r()) {
            bVar.d();
        } else {
            rVar.i0(bVar);
        }
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }
}
