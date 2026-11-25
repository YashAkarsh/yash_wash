package kotlinx.coroutines.sync;

import kotlin.e1;
import kotlin.jvm.internal.i0;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final r0 f37269a = new r0("LOCK_FAIL");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final r0 f37270b = new r0("UNLOCK_FAIL");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final r0 f37271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final r0 f37272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final b f37273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final b f37274f;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {112}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f37275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f37276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f37277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f37278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f37279h;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f37278g = obj;
            this.f37279h |= Integer.MIN_VALUE;
            return e.o(null, null, null, this);
        }
    }

    static {
        r0 r0Var = new r0("LOCKED");
        f37271c = r0Var;
        r0 r0Var2 = new r0("UNLOCKED");
        f37272d = r0Var2;
        f37273e = new b(r0Var);
        f37274f = new b(r0Var2);
    }

    @a7.d
    public static final c a(boolean z7) {
        return new d(z7);
    }

    public static /* synthetic */ c b(boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object o(@a7.d c cVar, @a7.e Object obj, @a7.d i5.a<? extends T> aVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i7 = aVar2.f37279h;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar2.f37279h = i7 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj2 = aVar2.f37278g;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar2.f37279h;
        if (i8 == 0) {
            e1.n(obj2);
            aVar2.f37275d = cVar;
            aVar2.f37276e = obj;
            aVar2.f37277f = aVar;
            aVar2.f37279h = 1;
            if (cVar.c(obj, aVar2) == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (i5.a) aVar2.f37277f;
            obj = aVar2.f37276e;
            cVar = (c) aVar2.f37275d;
            e1.n(obj2);
        }
        try {
            return aVar.invoke();
        } finally {
            i0.d(1);
            cVar.d(obj);
            i0.c(1);
        }
    }

    private static final <T> Object p(c cVar, Object obj, i5.a<? extends T> aVar, kotlin.coroutines.d<? super T> dVar) {
        i0.e(0);
        cVar.c(obj, dVar);
        i0.e(1);
        try {
            return aVar.invoke();
        } finally {
            i0.d(1);
            cVar.d(obj);
            i0.c(1);
        }
    }

    public static /* synthetic */ Object q(c cVar, Object obj, i5.a aVar, kotlin.coroutines.d dVar, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            obj = null;
        }
        i0.e(0);
        cVar.c(obj, dVar);
        i0.e(1);
        try {
            return aVar.invoke();
        } finally {
            i0.d(1);
            cVar.d(obj);
            i0.c(1);
        }
    }
}
