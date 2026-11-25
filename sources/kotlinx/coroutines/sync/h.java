package kotlinx.coroutines.sync;

import kotlin.e1;
import kotlin.jvm.internal.i0;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.internal.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37288a = v0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final r0 f37289b = new r0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final r0 f37290c = new r0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final r0 f37291d = new r0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final r0 f37292e = new r0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f37293f = v0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {85}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f37294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f37295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f37296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f37297g;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f37296f = obj;
            this.f37297g |= Integer.MIN_VALUE;
            return h.q(null, null, this);
        }
    }

    @a7.d
    public static final f a(int i7, int i8) {
        return new g(i7, i8);
    }

    public static /* synthetic */ f b(int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return a(i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i j(long j7, i iVar) {
        return new i(j7, iVar, 0);
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    private static /* synthetic */ void o() {
    }

    private static /* synthetic */ void p() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object q(@a7.d f fVar, @a7.d i5.a<? extends T> aVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i7 = aVar2.f37297g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar2.f37297g = i7 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj = aVar2.f37296f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar2.f37297g;
        if (i8 == 0) {
            e1.n(obj);
            aVar2.f37294d = fVar;
            aVar2.f37295e = aVar;
            aVar2.f37297g = 1;
            if (fVar.b(aVar2) == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (i5.a) aVar2.f37295e;
            fVar = (f) aVar2.f37294d;
            e1.n(obj);
        }
        try {
            return aVar.invoke();
        } finally {
            i0.d(1);
            fVar.i();
            i0.c(1);
        }
    }

    private static final <T> Object r(f fVar, i5.a<? extends T> aVar, kotlin.coroutines.d<? super T> dVar) {
        i0.e(0);
        fVar.b(dVar);
        i0.e(1);
        try {
            return aVar.invoke();
        } finally {
            i0.d(1);
            fVar.i();
            i0.c(1);
        }
    }
}
