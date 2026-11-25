package kotlinx.coroutines.test;

import a7.d;
import h5.e;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlinx.coroutines.internal.a1;
import kotlinx.coroutines.internal.b1;

/* JADX INFO: loaded from: classes3.dex */
final class c implements Comparable<c>, Runnable, b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d
    private final Runnable f37315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f37316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @e
    public final long f37317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private a1<?> f37318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37319e;

    public c(@d Runnable runnable, long j7, long j8) {
        this.f37315a = runnable;
        this.f37316b = j7;
        this.f37317c = j8;
    }

    @Override // kotlinx.coroutines.internal.b1
    public void a(@a7.e a1<?> a1Var) {
        this.f37318d = a1Var;
    }

    @Override // kotlinx.coroutines.internal.b1
    @a7.e
    public a1<?> b() {
        return this.f37318d;
    }

    @Override // kotlinx.coroutines.internal.b1
    public void c(int i7) {
        this.f37319e = i7;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(@d c cVar) {
        long j7 = this.f37317c;
        long j8 = cVar.f37317c;
        return j7 == j8 ? l0.u(this.f37316b, cVar.f37316b) : l0.u(j7, j8);
    }

    @Override // kotlinx.coroutines.internal.b1
    public int g() {
        return this.f37319e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f37315a.run();
    }

    @d
    public String toString() {
        return "TimedRunnable(time=" + this.f37317c + ", run=" + this.f37315a + ')';
    }

    public /* synthetic */ c(Runnable runnable, long j7, long j8, int i7, w wVar) {
        this(runnable, (i7 & 2) != 0 ? 0L : j7, (i7 & 4) != 0 ? 0L : j8);
    }
}
