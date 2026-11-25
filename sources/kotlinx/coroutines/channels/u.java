package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.a1;
import kotlin.b1;
import kotlin.l2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.z1;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class u {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {104}, m = "consumeEach", n = {"action", "$this$consume$iv"}, s = {"L$0", "L$1"})
    static final class a<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35668d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35669e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35672h;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35671g = obj;
            this.f35672h |= Integer.MIN_VALUE;
            return u.e(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {129}, m = "consumeEach", n = {"action", "channel$iv"}, s = {"L$0", "L$1"})
    static final class b<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35675f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35676g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35677h;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35676g = obj;
            this.f35677h |= Integer.MIN_VALUE;
            return u.d(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0}, l = {com.alibaba.fastjson.asm.j.C}, m = "toList", n = {"$this$toList_u24lambda_u2d3", "$this$consume$iv$iv"}, s = {"L$1", "L$2"})
    static final class c<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35680f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f35681g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f35682h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f35683i;

        c(kotlin.coroutines.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35682h = obj;
            this.f35683i |= Integer.MIN_VALUE;
            return s.g0(null, this);
        }
    }

    @a1
    public static final void a(@a7.d i0<?> i0Var, @a7.e Throwable th) {
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = z1.a("Channel was consumed, consumer had failed", th);
            }
        }
        i0Var.c(cancellationExceptionA);
    }

    @f3
    public static final <E, R> R b(@a7.d i<E> iVar, @a7.d i5.l<? super i0<? extends E>, ? extends R> lVar) {
        i0<E> i0VarG = iVar.G();
        try {
            return lVar.z(i0VarG);
        } finally {
            kotlin.jvm.internal.i0.d(1);
            i0.a.b(i0VarG, null, 1, null);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    public static final <E, R> R c(@a7.d i0<? extends E> i0Var, @a7.d i5.l<? super i0<? extends E>, ? extends R> lVar) {
        try {
            R rZ = lVar.z(i0Var);
            kotlin.jvm.internal.i0.d(1);
            s.b(i0Var, null);
            kotlin.jvm.internal.i0.c(1);
            return rZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                s.b(i0Var, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:28:0x006e A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:26:0x0066, B:28:0x006e, B:29:0x0079), top: B:40:0x0066 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    @kotlinx.coroutines.f3
    public static final <E> java.lang.Object d(@a7.d kotlinx.coroutines.channels.i<E> r6, @a7.d i5.l<? super E, kotlin.l2> r7, @a7.d kotlin.coroutines.d<? super kotlin.l2> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.u.b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.u$b r0 = (kotlinx.coroutines.channels.u.b) r0
            int r1 = r0.f35677h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35677h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.u$b r0 = new kotlinx.coroutines.channels.u$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35676g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35677h
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.f35675f
            kotlinx.coroutines.channels.p r6 = (kotlinx.coroutines.channels.p) r6
            java.lang.Object r7 = r0.f35674e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r2 = r0.f35673d
            i5.l r2 = (i5.l) r2
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L3b
            r5 = r0
            r0 = r7
            r7 = r2
        L38:
            r2 = r1
            r1 = r5
            goto L66
        L3b:
            r6 = move-exception
            goto L8f
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.e1.n(r8)
            kotlinx.coroutines.channels.i0 r6 = r6.G()
            kotlinx.coroutines.channels.p r8 = r6.iterator()     // Catch: java.lang.Throwable -> L8b
            r5 = r8
            r8 = r6
            r6 = r5
        L53:
            r0.f35673d = r7     // Catch: java.lang.Throwable -> L88
            r0.f35674e = r8     // Catch: java.lang.Throwable -> L88
            r0.f35675f = r6     // Catch: java.lang.Throwable -> L88
            r0.f35677h = r4     // Catch: java.lang.Throwable -> L88
            java.lang.Object r2 = r6.a(r0)     // Catch: java.lang.Throwable -> L88
            if (r2 != r1) goto L62
            return r1
        L62:
            r5 = r0
            r0 = r8
            r8 = r2
            goto L38
        L66:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L85
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L85
            if (r8 == 0) goto L79
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Throwable -> L85
            r7.z(r8)     // Catch: java.lang.Throwable -> L85
            r8 = r0
            r0 = r1
            r1 = r2
            goto L53
        L79:
            kotlin.l2 r6 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L85
            kotlin.jvm.internal.i0.d(r4)
            kotlinx.coroutines.channels.i0.a.b(r0, r3, r4, r3)
            kotlin.jvm.internal.i0.c(r4)
            return r6
        L85:
            r6 = move-exception
            r7 = r0
            goto L8f
        L88:
            r6 = move-exception
            r7 = r8
            goto L8f
        L8b:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L8f:
            kotlin.jvm.internal.i0.d(r4)
            kotlinx.coroutines.channels.i0.a.b(r7, r3, r4, r3)
            kotlin.jvm.internal.i0.c(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.u.d(kotlinx.coroutines.channels.i, i5.l, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:12:0x0031, B:25:0x005c, B:27:0x0064, B:21:0x004a, B:28:0x006d), top: B:37:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    public static final <E> java.lang.Object e(@a7.d kotlinx.coroutines.channels.i0<? extends E> r5, @a7.d i5.l<? super E, kotlin.l2> r6, @a7.d kotlin.coroutines.d<? super kotlin.l2> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.u.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.channels.u$a r0 = (kotlinx.coroutines.channels.u.a) r0
            int r1 = r0.f35672h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35672h = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.u$a r0 = new kotlinx.coroutines.channels.u$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35671g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35672h
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f35670f
            kotlinx.coroutines.channels.p r5 = (kotlinx.coroutines.channels.p) r5
            java.lang.Object r6 = r0.f35669e
            kotlinx.coroutines.channels.i0 r6 = (kotlinx.coroutines.channels.i0) r6
            java.lang.Object r2 = r0.f35668d
            i5.l r2 = (i5.l) r2
            kotlin.e1.n(r7)     // Catch: java.lang.Throwable -> L35
            goto L5c
        L35:
            r5 = move-exception
            goto L7e
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.e1.n(r7)
            kotlinx.coroutines.channels.p r7 = r5.iterator()     // Catch: java.lang.Throwable -> L7a
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L4a:
            r0.f35668d = r7     // Catch: java.lang.Throwable -> L35
            r0.f35669e = r6     // Catch: java.lang.Throwable -> L35
            r0.f35670f = r5     // Catch: java.lang.Throwable -> L35
            r0.f35672h = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r5.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L59
            return r1
        L59:
            r4 = r2
            r2 = r7
            r7 = r4
        L5c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L35
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Throwable -> L35
            r2.z(r7)     // Catch: java.lang.Throwable -> L35
            r7 = r2
            goto L4a
        L6d:
            kotlin.l2 r5 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L35
            kotlin.jvm.internal.i0.d(r3)
            r7 = 0
            kotlinx.coroutines.channels.s.b(r6, r7)
            kotlin.jvm.internal.i0.c(r3)
            return r5
        L7a:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L7e:
            throw r5     // Catch: java.lang.Throwable -> L7f
        L7f:
            r7 = move-exception
            kotlin.jvm.internal.i0.d(r3)
            kotlinx.coroutines.channels.s.b(r6, r5)
            kotlin.jvm.internal.i0.c(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.u.e(kotlinx.coroutines.channels.i0, i5.l, kotlin.coroutines.d):java.lang.Object");
    }

    @f3
    private static final <E> Object f(i<E> iVar, i5.l<? super E, l2> lVar, kotlin.coroutines.d<? super l2> dVar) {
        i0<E> i0VarG = iVar.G();
        try {
            p<E> it = i0VarG.iterator();
            while (true) {
                kotlin.jvm.internal.i0.e(3);
                kotlin.jvm.internal.i0.e(0);
                Object objA = it.a(null);
                kotlin.jvm.internal.i0.e(1);
                if (!((Boolean) objA).booleanValue()) {
                    return l2.f34958a;
                }
                lVar.z(it.next());
            }
        } finally {
            kotlin.jvm.internal.i0.d(1);
            i0.a.b(i0VarG, null, 1, null);
            kotlin.jvm.internal.i0.c(1);
        }
    }

    private static final <E> Object g(i0<? extends E> i0Var, i5.l<? super E, l2> lVar, kotlin.coroutines.d<? super l2> dVar) {
        try {
            p<? extends E> it = i0Var.iterator();
            while (true) {
                kotlin.jvm.internal.i0.e(3);
                kotlin.jvm.internal.i0.e(0);
                Object objA = it.a(null);
                kotlin.jvm.internal.i0.e(1);
                if (!((Boolean) objA).booleanValue()) {
                    l2 l2Var = l2.f34958a;
                    kotlin.jvm.internal.i0.d(1);
                    s.b(i0Var, null);
                    kotlin.jvm.internal.i0.c(1);
                    return l2Var;
                }
                lVar.z(it.next());
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                s.b(i0Var, th);
                kotlin.jvm.internal.i0.c(1);
                throw th2;
            }
        }
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> kotlinx.coroutines.selects.d<E> h(@a7.d i0<? extends E> i0Var) {
        return i0Var.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
    @a7.e
    public static final <E> Object i(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super E> dVar) {
        return i0Var.p(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f A[Catch: all -> 0x0039, TryCatch #2 {all -> 0x0039, blocks: (B:12:0x0035, B:25:0x0067, B:27:0x006f, B:28:0x0078), top: B:43:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @a7.e
    public static final <E> java.lang.Object j(@a7.d kotlinx.coroutines.channels.i0<? extends E> r7, @a7.d kotlin.coroutines.d<? super java.util.List<? extends E>> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.u.c
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.u$c r0 = (kotlinx.coroutines.channels.u.c) r0
            int r1 = r0.f35683i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35683i = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.u$c r0 = new kotlinx.coroutines.channels.u$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f35682h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f35683i
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.f35681g
            kotlinx.coroutines.channels.p r7 = (kotlinx.coroutines.channels.p) r7
            java.lang.Object r2 = r0.f35680f
            kotlinx.coroutines.channels.i0 r2 = (kotlinx.coroutines.channels.i0) r2
            java.lang.Object r4 = r0.f35679e
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.f35678d
            java.util.List r5 = (java.util.List) r5
            kotlin.e1.n(r8)     // Catch: java.lang.Throwable -> L39
            goto L67
        L39:
            r7 = move-exception
            r8 = r2
            goto L89
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            kotlin.e1.n(r8)
            java.util.List r8 = kotlin.collections.w.j()
            kotlinx.coroutines.channels.p r2 = r7.iterator()     // Catch: java.lang.Throwable -> L85
            r4 = r8
            r5 = r4
            r8 = r7
            r7 = r2
        L53:
            r0.f35678d = r5     // Catch: java.lang.Throwable -> L83
            r0.f35679e = r4     // Catch: java.lang.Throwable -> L83
            r0.f35680f = r8     // Catch: java.lang.Throwable -> L83
            r0.f35681g = r7     // Catch: java.lang.Throwable -> L83
            r0.f35683i = r3     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r7.a(r0)     // Catch: java.lang.Throwable -> L83
            if (r2 != r1) goto L64
            return r1
        L64:
            r6 = r2
            r2 = r8
            r8 = r6
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L39
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r8 == 0) goto L78
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L39
            r4.add(r8)     // Catch: java.lang.Throwable -> L39
            r8 = r2
            goto L53
        L78:
            kotlin.l2 r7 = kotlin.l2.f34958a     // Catch: java.lang.Throwable -> L39
            r7 = 0
            kotlinx.coroutines.channels.s.b(r2, r7)
            java.util.List r7 = kotlin.collections.w.b(r5)
            return r7
        L83:
            r7 = move-exception
            goto L89
        L85:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L89:
            throw r7     // Catch: java.lang.Throwable -> L8a
        L8a:
            r0 = move-exception
            kotlinx.coroutines.channels.s.b(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.u.j(kotlinx.coroutines.channels.i0, kotlin.coroutines.d):java.lang.Object");
    }
}
