package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.l2;
import kotlinx.coroutines.e2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.i f36506a;

        public a(kotlinx.coroutines.channels.i iVar) {
            this.f36506a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objL0 = k.l0(jVar, this.f36506a.G(), dVar);
            return objL0 == kotlin.coroutines.intrinsics.d.h() ? objL0 : l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 1, 1, 1}, l = {ConstraintLayout.LayoutParams.a.Z, 62}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "consume"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36508e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f36509f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36510g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36511h;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36510g = obj;
            this.f36511h |= Integer.MIN_VALUE;
            return m.e(null, null, false, this);
        }
    }

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> i<T> b(@a7.d kotlinx.coroutines.channels.i<T> iVar) {
        return new a(iVar);
    }

    @a7.d
    public static final <T> i<T> c(@a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var) {
        return new e(i0Var, true, null, 0, null, 28, null);
    }

    @a7.e
    public static final <T> Object d(@a7.d j<? super T> jVar, @a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objE = e(jVar, i0Var, true, dVar);
        return objE == kotlin.coroutines.intrinsics.d.h() ? objE : l2.f34958a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0075 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:18:0x004b), top: B:46:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[Catch: all -> 0x0055, TRY_ENTER, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:18:0x004b), top: B:46:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0085 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:18:0x004b), top: B:46:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.j, kotlinx.coroutines.flow.j<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, kotlinx.coroutines.flow.j] */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0095 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <T> java.lang.Object e(kotlinx.coroutines.flow.j<? super T> r6, kotlinx.coroutines.channels.i0<? extends T> r7, boolean r8, kotlin.coroutines.d<? super kotlin.l2> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.m.b
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.m$b r0 = (kotlinx.coroutines.flow.m.b) r0
            int r1 = r0.f36511h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36511h = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.m$b r0 = new kotlinx.coroutines.flow.m$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f36510g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
            int r2 = r0.f36511h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L57
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            boolean r6 = r0.f36509f
            java.lang.Object r7 = r0.f36508e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r8 = r0.f36507d
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) r8
            kotlin.e1.n(r9)     // Catch: java.lang.Throwable -> L55
        L35:
            r5 = r8
            r8 = r6
            r6 = r5
            goto L5d
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            boolean r6 = r0.f36509f
            java.lang.Object r7 = r0.f36508e
            kotlinx.coroutines.channels.i0 r7 = (kotlinx.coroutines.channels.i0) r7
            java.lang.Object r8 = r0.f36507d
            kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) r8
            kotlin.e1.n(r9)     // Catch: java.lang.Throwable -> L55
            kotlinx.coroutines.channels.r r9 = (kotlinx.coroutines.channels.r) r9     // Catch: java.lang.Throwable -> L55
            java.lang.Object r9 = r9.o()     // Catch: java.lang.Throwable -> L55
            goto L6f
        L55:
            r8 = move-exception
            goto L9c
        L57:
            kotlin.e1.n(r9)
            kotlinx.coroutines.flow.k.o0(r6)
        L5d:
            r0.f36507d = r6     // Catch: java.lang.Throwable -> L98
            r0.f36508e = r7     // Catch: java.lang.Throwable -> L98
            r0.f36509f = r8     // Catch: java.lang.Throwable -> L98
            r0.f36511h = r4     // Catch: java.lang.Throwable -> L98
            java.lang.Object r9 = r7.s(r0)     // Catch: java.lang.Throwable -> L98
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
            r8 = r6
            r6 = r5
        L6f:
            boolean r2 = kotlinx.coroutines.channels.r.k(r9)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L85
            java.lang.Throwable r8 = kotlinx.coroutines.channels.r.f(r9)     // Catch: java.lang.Throwable -> L55
            if (r8 != 0) goto L84
            if (r6 == 0) goto L81
            r6 = 0
            kotlinx.coroutines.channels.s.b(r7, r6)
        L81:
            kotlin.l2 r6 = kotlin.l2.f34958a
            return r6
        L84:
            throw r8     // Catch: java.lang.Throwable -> L55
        L85:
            java.lang.Object r9 = kotlinx.coroutines.channels.r.i(r9)     // Catch: java.lang.Throwable -> L55
            r0.f36507d = r8     // Catch: java.lang.Throwable -> L55
            r0.f36508e = r7     // Catch: java.lang.Throwable -> L55
            r0.f36509f = r6     // Catch: java.lang.Throwable -> L55
            r0.f36511h = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r9 = r8.f(r9, r0)     // Catch: java.lang.Throwable -> L55
            if (r9 != r1) goto L35
            return r1
        L98:
            r6 = move-exception
            r5 = r8
            r8 = r6
            r6 = r5
        L9c:
            throw r8     // Catch: java.lang.Throwable -> L9d
        L9d:
            r9 = move-exception
            if (r6 == 0) goto La3
            kotlinx.coroutines.channels.s.b(r7, r8)
        La3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.m.e(kotlinx.coroutines.flow.j, kotlinx.coroutines.channels.i0, boolean, kotlin.coroutines.d):java.lang.Object");
    }

    @a7.d
    @e2
    public static final <T> kotlinx.coroutines.channels.i0<T> f(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var) {
        return kotlinx.coroutines.flow.internal.f.b(iVar).o(v0Var);
    }

    @a7.d
    public static final <T> i<T> g(@a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var) {
        return new e(i0Var, false, null, 0, null, 28, null);
    }
}
