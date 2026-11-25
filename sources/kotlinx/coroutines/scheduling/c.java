package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.t0;
import kotlinx.coroutines.internal.v0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a2 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final c f37165c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final o0 f37166d = p.f37199b.a1(v0.d(o1.f37102a, kotlin.ranges.q.n(64, t0.a()), 0, 0, 12, null));

    private c() {
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        f37166d.T0(gVar, runnable);
    }

    @Override // kotlinx.coroutines.o0
    @j2
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        f37166d.V0(gVar, runnable);
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    @d2
    public o0 a1(int i7) {
        return p.f37199b.a1(i7);
    }

    @Override // kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // kotlinx.coroutines.a2
    @a7.d
    public Executor e1() {
        return this;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@a7.d Runnable runnable) {
        T0(kotlin.coroutines.i.f34682a, runnable);
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        return "Dispatchers.IO";
    }
}
