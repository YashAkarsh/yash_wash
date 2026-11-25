package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.a2;

/* JADX INFO: loaded from: classes3.dex */
public class i extends a2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f37182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final String f37183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private a f37184g;

    public i() {
        this(0, 0, 0L, null, 15, null);
    }

    private final a i1() {
        return new a(this.f37180c, this.f37181d, this.f37182e, this.f37183f);
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        a.G(this.f37184g, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.o0
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        a.G(this.f37184g, runnable, null, true, 2, null);
    }

    @Override // kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f37184g.close();
    }

    @Override // kotlinx.coroutines.a2
    @a7.d
    public Executor e1() {
        return this.f37184g;
    }

    public final void q1(@a7.d Runnable runnable, @a7.d l lVar, boolean z7) {
        this.f37184g.F(runnable, lVar, z7);
    }

    public final void s1() {
        z1();
    }

    public final synchronized void w1(long j7) {
        this.f37184g.v0(j7);
    }

    public final synchronized void z1() {
        this.f37184g.v0(1000L);
        this.f37184g = i1();
    }

    public /* synthetic */ i(int i7, int i8, long j7, String str, int i9, w wVar) {
        this((i9 & 1) != 0 ? o.f37191c : i7, (i9 & 2) != 0 ? o.f37192d : i8, (i9 & 4) != 0 ? o.f37193e : j7, (i9 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public i(int i7, int i8, long j7, @a7.d String str) {
        this.f37180c = i7;
        this.f37181d = i8;
        this.f37182e = j7;
        this.f37183f = str;
        this.f37184g = i1();
    }
}
