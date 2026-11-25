package kotlinx.coroutines.debug.internal;

import i5.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.y;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlin.sequences.o;
import kotlin.sequences.q;
import kotlin.sequences.u;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final m f35931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public final long f35932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final WeakReference<kotlin.coroutines.g> f35933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private String f35934d = f.f35947a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    @a7.e
    public Thread f35935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private WeakReference<kotlin.coroutines.jvm.internal.e> f35936f;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.k implements p<o<? super StackTraceElement>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f35937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f35938d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f35940f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m mVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f35940f = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = e.this.new a(this.f35940f, dVar);
            aVar.f35938d = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35937c;
            if (i7 == 0) {
                e1.n(obj);
                o oVar = (o) this.f35938d;
                e eVar = e.this;
                kotlin.coroutines.jvm.internal.e eVarI = this.f35940f.i();
                this.f35937c = 1;
                if (eVar.k(oVar, eVarI, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d o<? super StackTraceElement> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {80}, m = "yieldFrames", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35944g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35946i;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35944g = obj;
            this.f35946i |= Integer.MIN_VALUE;
            return e.this.k(null, null, this);
        }
    }

    public e(@a7.e kotlin.coroutines.g gVar, @a7.e m mVar, long j7) {
        this.f35931a = mVar;
        this.f35932b = j7;
        this.f35933c = new WeakReference<>(gVar);
    }

    private final List<StackTraceElement> b() {
        m mVar = this.f35931a;
        return mVar == null ? y.F() : u.c3(q.b(new a(mVar, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    /* JADX WARN: Code duplicated, block: B:23:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004a -> B:26:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005c -> B:25:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:21:0x004d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object k(kotlin.sequences.o<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.e r7, kotlin.coroutines.d<? super kotlin.l2> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.e.b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.e$b r0 = (kotlinx.coroutines.debug.internal.e.b) r0
            int r1 = r0.f35946i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35946i = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.e$b r0 = new kotlinx.coroutines.debug.internal.e$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35944g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35946i
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.f35943f
            kotlin.coroutines.jvm.internal.e r6 = (kotlin.coroutines.jvm.internal.e) r6
            java.lang.Object r7 = r0.f35942e
            kotlin.sequences.o r7 = (kotlin.sequences.o) r7
            java.lang.Object r2 = r0.f35941d
            kotlinx.coroutines.debug.internal.e r2 = (kotlinx.coroutines.debug.internal.e) r2
            kotlin.e1.n(r8)
            goto L5f
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.e1.n(r8)
            r2 = r5
        L41:
            if (r7 != 0) goto L46
            kotlin.l2 r6 = kotlin.l2.f34958a
            return r6
        L46:
            java.lang.StackTraceElement r8 = r7.I()
            if (r8 != 0) goto L4d
            goto L62
        L4d:
            r0.f35941d = r2
            r0.f35942e = r6
            r0.f35943f = r7
            r0.f35946i = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r4 = r7
            r7 = r6
            r6 = r4
        L5f:
            r4 = r7
            r7 = r6
            r6 = r4
        L62:
            kotlin.coroutines.jvm.internal.e r7 = r7.i()
            if (r7 == 0) goto L69
            goto L41
        L69:
            kotlin.l2 r6 = kotlin.l2.f34958a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.e.k(kotlin.sequences.o, kotlin.coroutines.jvm.internal.e, kotlin.coroutines.d):java.lang.Object");
    }

    @a7.e
    public final kotlin.coroutines.g c() {
        return this.f35933c.get();
    }

    @a7.e
    public final m d() {
        return this.f35931a;
    }

    @a7.d
    public final List<StackTraceElement> e() {
        return b();
    }

    @a7.e
    public final kotlin.coroutines.jvm.internal.e f() {
        WeakReference<kotlin.coroutines.jvm.internal.e> weakReference = this.f35936f;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @a7.d
    public final String g() {
        return this.f35934d;
    }

    @a7.d
    public final List<StackTraceElement> h() {
        kotlin.coroutines.jvm.internal.e eVarF = f();
        if (eVarF == null) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList();
        while (eVarF != null) {
            StackTraceElement stackTraceElementI = eVarF.I();
            if (stackTraceElementI != null) {
                arrayList.add(stackTraceElementI);
            }
            eVarF = eVarF.i();
        }
        return arrayList;
    }

    public final void i(@a7.e kotlin.coroutines.jvm.internal.e eVar) {
        this.f35936f = eVar == null ? null : new WeakReference<>(eVar);
    }

    public final void j(@a7.d String str, @a7.d kotlin.coroutines.d<?> dVar) {
        if (l0.g(this.f35934d, str) && l0.g(str, f.f35949c) && f() != null) {
            return;
        }
        this.f35934d = str;
        i(dVar instanceof kotlin.coroutines.jvm.internal.e ? (kotlin.coroutines.jvm.internal.e) dVar : null);
        this.f35935e = l0.g(str, f.f35948b) ? Thread.currentThread() : null;
    }

    @a7.d
    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ')';
    }
}
