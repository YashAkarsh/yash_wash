package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class w0 extends kotlinx.coroutines.flow.internal.d<u0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f36808a = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_state");

    @a7.d
    volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@a7.d u0<?> u0Var) {
        if (this._state != null) {
            return false;
        }
        this._state = v0.f36776a;
        return true;
    }

    @a7.e
    public final Object d(@a7.d kotlin.coroutines.d<? super l2> dVar) {
        kotlinx.coroutines.r rVar = new kotlinx.coroutines.r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        if (!androidx.concurrent.futures.b.a(f36808a, this, v0.f36776a, rVar)) {
            d1.a aVar = d1.f34719b;
            rVar.w(d1.b(l2.f34958a));
        }
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @a7.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.d<l2>[] b(@a7.d u0<?> u0Var) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.c.f36272a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == v0.f36777b) {
                return;
            }
            if (obj == v0.f36776a) {
                if (androidx.concurrent.futures.b.a(f36808a, this, obj, v0.f36777b)) {
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f36808a, this, obj, v0.f36776a)) {
                d1.a aVar = d1.f34719b;
                ((kotlinx.coroutines.r) obj).w(d1.b(l2.f34958a));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = f36808a.getAndSet(this, v0.f36776a);
        kotlin.jvm.internal.l0.m(andSet);
        return andSet == v0.f36777b;
    }
}
