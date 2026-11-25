package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class a0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36937a = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_cur");

    @a7.d
    private volatile /* synthetic */ Object _cur;

    public a0(boolean z7) {
        this._cur = new b0(8, z7);
    }

    public final boolean a(@a7.d E e8) {
        while (true) {
            b0 b0Var = (b0) this._cur;
            int iA = b0Var.a(e8);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                androidx.concurrent.futures.b.a(f36937a, this, b0Var, b0Var.k());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            b0 b0Var = (b0) this._cur;
            if (b0Var.d()) {
                return;
            } else {
                androidx.concurrent.futures.b.a(f36937a, this, b0Var, b0Var.k());
            }
        }
    }

    public final int c() {
        return ((b0) this._cur).f();
    }

    public final boolean d() {
        return ((b0) this._cur).g();
    }

    public final boolean e() {
        return ((b0) this._cur).h();
    }

    @a7.d
    public final <R> List<R> f(@a7.d i5.l<? super E, ? extends R> lVar) {
        return ((b0) this._cur).i(lVar);
    }

    @a7.e
    public final E g() {
        while (true) {
            b0 b0Var = (b0) this._cur;
            E e8 = (E) b0Var.l();
            if (e8 != b0.f36955t) {
                return e8;
            }
            androidx.concurrent.futures.b.a(f36937a, this, b0Var, b0Var.k());
        }
    }
}
