package kotlin.coroutines.intrinsics;

import i5.l;
import i5.p;
import i5.q;
import kotlin.coroutines.g;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t1;
import kotlin.l2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    public static final class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<kotlin.coroutines.d<? super T>, Object> f34689c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlin.coroutines.d<? super T> dVar, l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
            super(dVar);
            this.f34689c = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.c$a for r2v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected java.lang.Object R(@a7.d java.lang.Object r3) {
            /*
                r2 = this;
                int r0 = r2.f34688b
                r1 = 1
                if (r0 == 0) goto L1a
                if (r0 != r1) goto Le
                r0 = 2
                r2.f34688b = r0
                kotlin.e1.n(r3)
                goto L25
            Le:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "This coroutine had already completed"
                java.lang.String r0 = r0.toString()
                r3.<init>(r0)
                throw r3
            L1a:
                r2.f34688b = r1
                kotlin.e1.n(r3)
                i5.l<kotlin.coroutines.d<? super T>, java.lang.Object> r3 = r2.f34689c
                java.lang.Object r3 = r3.z(r2)
            L25:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.c.a.R(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l<kotlin.coroutines.d<? super T>, Object> f34691e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(kotlin.coroutines.d<? super T> dVar, g gVar, l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
            super(dVar, gVar);
            this.f34691e = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlin.coroutines.intrinsics.c$b for r2v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected java.lang.Object R(@a7.d java.lang.Object r3) {
            /*
                r2 = this;
                int r0 = r2.f34690d
                r1 = 1
                if (r0 == 0) goto L1a
                if (r0 != r1) goto Le
                r0 = 2
                r2.f34690d = r0
                kotlin.e1.n(r3)
                goto L25
            Le:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "This coroutine had already completed"
                java.lang.String r0 = r0.toString()
                r3.<init>(r0)
                throw r3
            L1a:
                r2.f34690d = r1
                kotlin.e1.n(r3)
                i5.l<kotlin.coroutines.d<? super T>, java.lang.Object> r3 = r2.f34691e
                java.lang.Object r3 = r3.z(r2)
            L25:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.c.b.R(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: kotlin.coroutines.intrinsics.c$c, reason: collision with other inner class name */
    public static final class C0432c extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f34693c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0432c(kotlin.coroutines.d dVar, l lVar) {
            super(dVar);
            this.f34693c = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected Object R(@a7.d Object obj) {
            int i7 = this.f34692b;
            if (i7 == 0) {
                this.f34692b = 1;
                e1.n(obj);
                l0.n(this.f34693c, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-0>, kotlin.Any?>");
                return ((l) t1.q(this.f34693c, 1)).z(this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f34692b = 2;
            e1.n(obj);
            return obj;
        }
    }

    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l f34695e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlin.coroutines.d dVar, g gVar, l lVar) {
            super(dVar, gVar);
            this.f34695e = lVar;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected Object R(@a7.d Object obj) {
            int i7 = this.f34694d;
            if (i7 == 0) {
                this.f34694d = 1;
                e1.n(obj);
                l0.n(this.f34695e, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-0>, kotlin.Any?>");
                return ((l) t1.q(this.f34695e, 1)).z(this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f34694d = 2;
            e1.n(obj);
            return obj;
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ p f34697c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f34698d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kotlin.coroutines.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f34697c = pVar;
            this.f34698d = obj;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected Object R(@a7.d Object obj) {
            int i7 = this.f34696b;
            if (i7 == 0) {
                this.f34696b = 1;
                e1.n(obj);
                l0.n(this.f34697c, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                return ((p) t1.q(this.f34697c, 2)).a0(this.f34698d, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f34696b = 2;
            e1.n(obj);
            return obj;
        }
    }

    public static final class f extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34699d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f34700e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f34701f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kotlin.coroutines.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f34700e = pVar;
            this.f34701f = obj;
            l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        protected Object R(@a7.d Object obj) {
            int i7 = this.f34699d;
            if (i7 == 0) {
                this.f34699d = 1;
                e1.n(obj);
                l0.n(this.f34700e, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda-1>, kotlin.Any?>");
                return ((p) t1.q(this.f34700e, 2)).a0(this.f34701f, this);
            }
            if (i7 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f34699d = 2;
            e1.n(obj);
            return obj;
        }
    }

    @g1(version = "1.3")
    private static final <T> kotlin.coroutines.d<l2> a(kotlin.coroutines.d<? super T> dVar, l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
        g gVarD = dVar.d();
        return gVarD == i.f34682a ? new a(dVar, lVar) : new b(dVar, gVarD, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @g1(version = "1.3")
    public static <T> kotlin.coroutines.d<l2> b(@a7.d l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar, @a7.d kotlin.coroutines.d<? super T> completion) {
        l0.p(lVar, "<this>");
        l0.p(completion, "completion");
        kotlin.coroutines.d<?> dVarA = h.a(completion);
        if (lVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) lVar).E(dVarA);
        }
        g gVarD = dVarA.d();
        return gVarD == i.f34682a ? new C0432c(dVarA, lVar) : new d(dVarA, gVarD, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @g1(version = "1.3")
    public static <R, T> kotlin.coroutines.d<l2> c(@a7.d p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, R r7, @a7.d kotlin.coroutines.d<? super T> completion) {
        l0.p(pVar, "<this>");
        l0.p(completion, "completion");
        kotlin.coroutines.d<?> dVarA = h.a(completion);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).D(r7, dVarA);
        }
        g gVarD = dVarA.d();
        return gVarD == i.f34682a ? new e(dVarA, pVar, r7) : new f(dVarA, gVarD, pVar, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @g1(version = "1.3")
    public static <T> kotlin.coroutines.d<T> d(@a7.d kotlin.coroutines.d<? super T> dVar) {
        kotlin.coroutines.d<T> dVar2;
        l0.p(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (kotlin.coroutines.d<T>) dVar3.Z()) == null) ? dVar : dVar2;
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> Object e(l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar, kotlin.coroutines.d<? super T> completion) {
        l0.p(lVar, "<this>");
        l0.p(completion, "completion");
        return ((l) t1.q(lVar, 1)).z(completion);
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T> Object f(p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, R r7, kotlin.coroutines.d<? super T> completion) {
        l0.p(pVar, "<this>");
        l0.p(completion, "completion");
        return ((p) t1.q(pVar, 2)).a0(r7, completion);
    }

    @kotlin.internal.f
    private static final <R, P, T> Object g(q<? super R, ? super P, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar, R r7, P p7, kotlin.coroutines.d<? super T> completion) {
        l0.p(qVar, "<this>");
        l0.p(completion, "completion");
        return ((q) t1.q(qVar, 3)).v(r7, p7, completion);
    }
}
