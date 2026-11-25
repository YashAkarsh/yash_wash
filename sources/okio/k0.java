package okio;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f38489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReference<j0>[] f38490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0 f38491e = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f38487a = 65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j0 f38488b = new j0(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f38489c = iHighestOneBit;
        AtomicReference<j0>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i7 = 0; i7 < iHighestOneBit; i7++) {
            atomicReferenceArr[i7] = new AtomicReference<>();
        }
        f38490d = atomicReferenceArr;
    }

    private k0() {
    }

    private final AtomicReference<j0> a() {
        Thread threadCurrentThread = Thread.currentThread();
        kotlin.jvm.internal.l0.o(threadCurrentThread, "Thread.currentThread()");
        return f38490d[(int) (threadCurrentThread.getId() & (((long) f38489c) - 1))];
    }

    @h5.l
    public static final void d(@a7.d j0 segment) {
        AtomicReference<j0> atomicReferenceA;
        j0 j0Var;
        kotlin.jvm.internal.l0.p(segment, "segment");
        if (!(segment.f38473f == null && segment.f38474g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f38471d || (j0Var = (atomicReferenceA = f38491e.a()).get()) == f38488b) {
            return;
        }
        int i7 = j0Var != null ? j0Var.f38470c : 0;
        if (i7 >= f38487a) {
            return;
        }
        segment.f38473f = j0Var;
        segment.f38469b = 0;
        segment.f38470c = i7 + 8192;
        if (com.facebook.internal.a.a(atomicReferenceA, j0Var, segment)) {
            return;
        }
        segment.f38473f = null;
    }

    @a7.d
    @h5.l
    public static final j0 e() {
        AtomicReference<j0> atomicReferenceA = f38491e.a();
        j0 j0Var = f38488b;
        j0 andSet = atomicReferenceA.getAndSet(j0Var);
        if (andSet == j0Var) {
            return new j0();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new j0();
        }
        atomicReferenceA.set(andSet.f38473f);
        andSet.f38473f = null;
        andSet.f38470c = 0;
        return andSet;
    }

    public final int b() {
        j0 j0Var = a().get();
        if (j0Var != null) {
            return j0Var.f38470c;
        }
        return 0;
    }

    public final int c() {
        return f38487a;
    }
}
