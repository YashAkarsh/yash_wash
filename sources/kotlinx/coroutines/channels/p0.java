package kotlinx.coroutines.channels;

import easypay.appinvoke.manager.Constants;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {Constants.ACTION_SUBMIT_CLICKED, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f35638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35640f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35641g;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35640f = obj;
            this.f35641g |= Integer.MIN_VALUE;
            return p0.c(0L, 0L, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {84, 88, 94, com.alibaba.fastjson.asm.j.f12632z}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f35642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f35643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35646h;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35645g = obj;
            this.f35646h |= Integer.MIN_VALUE;
            return p0.d(0L, 0L, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {f4.d.f33918h, f4.d.f33917g}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends kotlin.coroutines.jvm.internal.o implements i5.p<g0<? super l2>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35647e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35648f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ q0 f35649g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f35650h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f35651i;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f35652a;

            static {
                int[] iArr = new int[q0.values().length];
                iArr[q0.FIXED_PERIOD.ordinal()] = 1;
                iArr[q0.FIXED_DELAY.ordinal()] = 2;
                f35652a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(q0 q0Var, long j7, long j8, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f35649g = q0Var;
            this.f35650h = j7;
            this.f35651i = j8;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            c cVar = new c(this.f35649g, this.f35650h, this.f35651i, dVar);
            cVar.f35648f = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35647e;
            if (i7 == 0) {
                e1.n(obj);
                g0 g0Var = (g0) this.f35648f;
                int i8 = a.f35652a[this.f35649g.ordinal()];
                if (i8 == 1) {
                    long j7 = this.f35650h;
                    long j8 = this.f35651i;
                    m0 m0VarA = g0Var.a();
                    this.f35647e = 1;
                    if (p0.d(j7, j8, m0VarA, this) == objH) {
                        return objH;
                    }
                } else if (i8 == 2) {
                    long j9 = this.f35650h;
                    long j10 = this.f35651i;
                    m0 m0VarA2 = g0Var.a();
                    this.f35647e = 2;
                    if (p0.c(j9, j10, m0VarA2, this) == objH) {
                        return objH;
                    }
                }
            } else {
                if (i7 != 1 && i7 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d g0<? super l2> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((c) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(long r6, long r8, kotlinx.coroutines.channels.m0<? super kotlin.l2> r10, kotlin.coroutines.d<? super kotlin.l2> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.p0.a
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.channels.p0$a r0 = (kotlinx.coroutines.channels.p0.a) r0
            int r1 = r0.f35641g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35641g = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.p0$a r0 = new kotlinx.coroutines.channels.p0$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f35640f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35641g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L48
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            long r6 = r0.f35638d
            java.lang.Object r8 = r0.f35639e
            kotlinx.coroutines.channels.m0 r8 = (kotlinx.coroutines.channels.m0) r8
            kotlin.e1.n(r11)
        L34:
            r10 = r8
            goto L63
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            long r6 = r0.f35638d
            java.lang.Object r8 = r0.f35639e
            kotlinx.coroutines.channels.m0 r8 = (kotlinx.coroutines.channels.m0) r8
            kotlin.e1.n(r11)
            goto L73
        L48:
            long r6 = r0.f35638d
            java.lang.Object r8 = r0.f35639e
            r10 = r8
            kotlinx.coroutines.channels.m0 r10 = (kotlinx.coroutines.channels.m0) r10
            kotlin.e1.n(r11)
            goto L63
        L53:
            kotlin.e1.n(r11)
            r0.f35639e = r10
            r0.f35638d = r6
            r0.f35641g = r5
            java.lang.Object r8 = kotlinx.coroutines.g1.b(r8, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            kotlin.l2 r8 = kotlin.l2.f34958a
            r0.f35639e = r10
            r0.f35638d = r6
            r0.f35641g = r4
            java.lang.Object r8 = r10.R(r8, r0)
            if (r8 != r1) goto L72
            return r1
        L72:
            r8 = r10
        L73:
            r0.f35639e = r8
            r0.f35638d = r6
            r0.f35641g = r3
            java.lang.Object r9 = kotlinx.coroutines.g1.b(r6, r0)
            if (r9 != r1) goto L34
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.p0.c(long, long, kotlinx.coroutines.channels.m0, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:55:0x0127 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0111 -> B:34:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0125 -> B:15:0x003c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(long r19, long r21, kotlinx.coroutines.channels.m0<? super kotlin.l2> r23, kotlin.coroutines.d<? super kotlin.l2> r24) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.p0.d(long, long, kotlinx.coroutines.channels.m0, kotlin.coroutines.d):java.lang.Object");
    }

    @a7.d
    @f3
    public static final i0<l2> e(long j7, long j8, @a7.d kotlin.coroutines.g gVar, @a7.d q0 q0Var) {
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j7 + " ms").toString());
        }
        if (j8 >= 0) {
            return e0.c(f2.f36000a, n1.g().plus(gVar), 0, new c(q0Var, j7, j8, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j8 + " ms").toString());
    }

    public static /* synthetic */ i0 f(long j7, long j8, kotlin.coroutines.g gVar, q0 q0Var, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j8 = j7;
        }
        if ((i7 & 4) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        if ((i7 & 8) != 0) {
            q0Var = q0.FIXED_PERIOD;
        }
        return e(j7, j8, gVar, q0Var);
    }
}
