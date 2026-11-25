package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class u0<T> extends kotlinx.coroutines.flow.internal.b<w0> implements e0<T>, c<T>, kotlinx.coroutines.flow.internal.r<T> {

    @a7.d
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36703e;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {386, 398, 403}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f36707g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f36708h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f36709i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ u0<T> f36710j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f36711k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u0<T> u0Var, kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
            this.f36710j = u0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36709i = obj;
            this.f36711k |= Integer.MIN_VALUE;
            return this.f36710j.a(null, this);
        }
    }

    public u0(@a7.d Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void u() {
    }

    private final boolean v(Object obj, Object obj2) {
        int i7;
        w0[] w0VarArrP;
        p();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !kotlin.jvm.internal.l0.g(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.l0.g(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i8 = this.f36703e;
            if ((i8 & 1) != 0) {
                this.f36703e = i8 + 2;
                return true;
            }
            int i9 = i8 + 1;
            this.f36703e = i9;
            w0[] w0VarArrP2 = p();
            l2 l2Var = l2.f34958a;
            while (true) {
                w0[] w0VarArr = w0VarArrP2;
                if (w0VarArr != null) {
                    int length = w0VarArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        w0 w0Var = w0VarArr[i10];
                        i10++;
                        if (w0Var != null) {
                            w0Var.f();
                        }
                    }
                }
                synchronized (this) {
                    i7 = this.f36703e;
                    if (i7 == i9) {
                        this.f36703e = i9 + 1;
                        return true;
                    }
                    w0VarArrP = p();
                    l2 l2Var2 = l2.f34958a;
                }
                w0VarArrP2 = w0VarArrP;
                i9 = i7;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b0 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d7 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.d] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, kotlinx.coroutines.flow.w0] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d5 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e7 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:51:0x00d7
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlinx.coroutines.flow.i0, kotlinx.coroutines.flow.i
    @a7.e
    public java.lang.Object a(@a7.d kotlinx.coroutines.flow.j<? super T> r11, @a7.d kotlin.coroutines.d<?> r12) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.u0.a(kotlinx.coroutines.flow.j, kotlin.coroutines.d):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.i0
    @a7.d
    public List<T> b() {
        return kotlin.collections.x.l(getValue());
    }

    @Override // kotlinx.coroutines.flow.internal.r
    @a7.d
    public i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return v0.d(this, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.d0, kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        setValue(t7);
        return l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.e0
    public boolean g(T t7, T t8) {
        if (t7 == null) {
            t7 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
        }
        if (t8 == null) {
            t8 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
        }
        return v(t7, t8);
    }

    @Override // kotlinx.coroutines.flow.e0, kotlinx.coroutines.flow.t0
    public T getValue() {
        kotlinx.coroutines.internal.r0 r0Var = kotlinx.coroutines.flow.internal.u.f36394a;
        T t7 = (T) this._state;
        if (t7 == r0Var) {
            return null;
        }
        return t7;
    }

    @Override // kotlinx.coroutines.flow.d0
    public void j() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.d0
    public boolean m(T t7) {
        setValue(t7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    @a7.d
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public w0 i() {
        return new w0();
    }

    @Override // kotlinx.coroutines.flow.e0
    public void setValue(T t7) {
        if (t7 == null) {
            t7 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
        }
        v(null, t7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    @a7.d
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public w0[] k(int i7) {
        return new w0[i7];
    }
}
