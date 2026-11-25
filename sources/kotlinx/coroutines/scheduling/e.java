package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.a1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
@a1
public class e extends a2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f37170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final String f37171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private a f37172g;

    public /* synthetic */ e(int i7, int i8, long j7, String str, int i9, w wVar) {
        this(i7, i8, j7, (i9 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ o0 q1(e eVar, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((i8 & 1) != 0) {
            i7 = 16;
        }
        return eVar.i1(i7);
    }

    private final a s1() {
        return new a(this.f37168c, this.f37169d, this.f37170e, this.f37171f);
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        try {
            a.G(this.f37172g, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            b1.f35517g.T0(gVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.o0
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        try {
            a.G(this.f37172g, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            b1.f35517g.V0(gVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f37172g.close();
    }

    @Override // kotlinx.coroutines.a2
    @a7.d
    public Executor e1() {
        return this.f37172g;
    }

    @a7.d
    public final o0 i1(int i7) {
        if (i7 > 0) {
            return new g(this, i7, null, 1);
        }
        throw new IllegalArgumentException(l0.C("Expected positive parallelism level, but have ", Integer.valueOf(i7)).toString());
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        return super.toString() + "[scheduler = " + this.f37172g + ']';
    }

    public final void w1(@a7.d Runnable runnable, @a7.d l lVar, boolean z7) {
        try {
            this.f37172g.F(runnable, lVar, z7);
        } catch (RejectedExecutionException unused) {
            b1.f35517g.f2(this.f37172g.r(runnable, lVar));
        }
    }

    @a7.d
    public final o0 z1(int i7) {
        if (!(i7 > 0)) {
            throw new IllegalArgumentException(l0.C("Expected positive parallelism level, but have ", Integer.valueOf(i7)).toString());
        }
        if (i7 <= this.f37168c) {
            return new g(this, i7, null, 0);
        }
        throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f37168c + "), but have " + i7).toString());
    }

    public e(int i7, int i8, long j7, @a7.d String str) {
        this.f37168c = i7;
        this.f37169d = i8;
        this.f37170e = j7;
        this.f37171f = str;
        this.f37172g = s1();
    }

    public /* synthetic */ e(int i7, int i8, String str, int i9, w wVar) {
        this((i9 & 1) != 0 ? o.f37191c : i7, (i9 & 2) != 0 ? o.f37192d : i8, (i9 & 4) != 0 ? o.f37189a : str);
    }

    public e(int i7, int i8, @a7.d String str) {
        this(i7, i8, o.f37193e, str);
    }

    public /* synthetic */ e(int i7, int i8, int i9, w wVar) {
        this((i9 & 1) != 0 ? o.f37191c : i7, (i9 & 2) != 0 ? o.f37192d : i8);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ e(int i7, int i8) {
        this(i7, i8, o.f37193e, null, 8, null);
    }
}
