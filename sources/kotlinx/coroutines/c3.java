package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class c3 extends kotlin.coroutines.a implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final c3 f35535a = new c3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final String f35536b = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private c3() {
        super(o2.f37103s0);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public static /* synthetic */ void T0() {
    }

    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public static /* synthetic */ void V0() {
    }

    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public static /* synthetic */ void Y0() {
    }

    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public static /* synthetic */ void a1() {
    }

    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public static /* synthetic */ void d1() {
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public kotlin.sequences.m<o2> E() {
        return kotlin.sequences.s.g();
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    @a7.e
    public Object H(@a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public q1 J0(boolean z7, boolean z8, @a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        return d3.f35894a;
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public CancellationException K() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public w Q0(@a7.d y yVar) {
        return d3.f35894a;
    }

    @Override // kotlinx.coroutines.o2
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public void c(@a7.e CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        c(null);
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean e(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public q1 g0(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        return d3.f35894a;
    }

    @Override // kotlinx.coroutines.o2
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public o2 o0(@a7.d o2 o2Var) {
        return o2.a.i(this, o2Var);
    }

    @Override // kotlinx.coroutines.o2
    public boolean r() {
        return false;
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.WARNING, message = f35536b)
    public boolean start() {
        return false;
    }

    @a7.d
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public kotlinx.coroutines.selects.c x0() {
        throw new UnsupportedOperationException("This job is always active");
    }
}
