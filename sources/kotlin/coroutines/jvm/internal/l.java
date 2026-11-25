package kotlin.coroutines.jvm.internal;

import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
final class l implements kotlin.coroutines.d<l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private d1<l2> f34714a;

    public final void a() {
        synchronized (this) {
            while (true) {
                d1<l2> d1Var = this.f34714a;
                if (d1Var == null) {
                    l0.n(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } else {
                    e1.n(d1Var.l());
                }
            }
        }
    }

    @a7.e
    public final d1<l2> c() {
        return this.f34714a;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return kotlin.coroutines.i.f34682a;
    }

    public final void f(@a7.e d1<l2> d1Var) {
        this.f34714a = d1Var;
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        synchronized (this) {
            this.f34714a = d1.a(obj);
            l0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            l2 l2Var = l2.f34958a;
        }
    }
}
