package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes2.dex */
public interface i0<E> {

    public static final class a {

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.i0$a$a, reason: collision with other inner class name */
        public static final class C0447a implements kotlinx.coroutines.selects.d<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i0<E> f35600a;

            /* JADX INFO: Add missing generic type declarations: [R] */
            /* JADX INFO: renamed from: kotlinx.coroutines.channels.i0$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1", f = "Channel.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
            static final class C0448a<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<r<? extends E>, kotlin.coroutines.d<? super R>, Object> {

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f35601e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                /* synthetic */ Object f35602f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ i5.p<E, kotlin.coroutines.d<? super R>, Object> f35603g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0448a(i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super C0448a> dVar) {
                    super(2, dVar);
                    this.f35603g = pVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.d
                public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                    C0448a c0448a = new C0448a(this.f35603g, dVar);
                    c0448a.f35602f = obj;
                    return c0448a;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.i0$a$a$a<R> for r3v1 'this'  java.lang.Object
                    	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                    	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                    	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                    	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final java.lang.Object R(@a7.d java.lang.Object r4) {
                    /*
                        r3 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                        int r1 = r3.f35601e
                        r2 = 1
                        if (r1 == 0) goto L17
                        if (r1 != r2) goto Lf
                        kotlin.e1.n(r4)
                        goto L37
                    Lf:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r0)
                        throw r4
                    L17:
                        kotlin.e1.n(r4)
                        java.lang.Object r4 = r3.f35602f
                        kotlinx.coroutines.channels.r r4 = (kotlinx.coroutines.channels.r) r4
                        java.lang.Object r4 = r4.o()
                        java.lang.Throwable r1 = kotlinx.coroutines.channels.r.f(r4)
                        if (r1 != 0) goto L38
                        i5.p<E, kotlin.coroutines.d<? super R>, java.lang.Object> r1 = r3.f35603g
                        java.lang.Object r4 = kotlinx.coroutines.channels.r.h(r4)
                        r3.f35601e = r2
                        java.lang.Object r4 = r1.a0(r4, r3)
                        if (r4 != r0) goto L37
                        return r0
                    L37:
                        return r4
                    L38:
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.i0.a.C0447a.C0448a.R(java.lang.Object):java.lang.Object");
                }

                @Override // i5.p
                public /* bridge */ /* synthetic */ Object a0(Object obj, Object obj2) {
                    return e0(((r) obj).o(), (kotlin.coroutines.d) obj2);
                }

                @a7.e
                public final Object e0(@a7.d Object obj, @a7.e kotlin.coroutines.d<? super R> dVar) {
                    return ((C0448a) D(r.b(obj), dVar)).R(l2.f34958a);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0447a(i0<? extends E> i0Var) {
                this.f35600a = i0Var;
            }

            @Override // kotlinx.coroutines.selects.d
            @j2
            public <R> void h(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
                this.f35600a.l().h(fVar, new C0448a(pVar, null));
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {354}, m = "receiveOrNull", n = {}, s = {})
        static final class b<E> extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f35604d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f35605e;

            b(kotlin.coroutines.d<? super b> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f35604d = obj;
                this.f35605e |= Integer.MIN_VALUE;
                return a.i(null, this);
            }
        }

        public static /* synthetic */ void b(i0 i0Var, CancellationException cancellationException, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                cancellationException = null;
            }
            i0Var.c(cancellationException);
        }

        public static /* synthetic */ boolean c(i0 i0Var, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return i0Var.e(th);
        }

        @a7.d
        public static <E> kotlinx.coroutines.selects.d<E> d(@a7.d i0<? extends E> i0Var) {
            return new C0447a(i0Var);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @b1(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void e() {
        }

        @d2
        public static /* synthetic */ void f() {
        }

        @d2
        public static /* synthetic */ void g() {
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
        @a7.e
        public static <E> E h(@a7.d i0<? extends E> i0Var) throws Throwable {
            Object objO = i0Var.o();
            if (r.m(objO)) {
                return (E) r.i(objO);
            }
            Throwable thF = r.f(objO);
            if (thF == null) {
                return null;
            }
            throw kotlinx.coroutines.internal.q0.p(thF);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @kotlin.internal.h
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
        @a7.e
        public static <E> Object i(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super E> dVar) {
            b bVar;
            Object objS;
            if (dVar instanceof b) {
                bVar = (b) dVar;
                int i7 = bVar.f35605e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    bVar.f35605e = i7 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(dVar);
                }
            } else {
                bVar = new b(dVar);
            }
            Object obj = bVar.f35604d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = bVar.f35605e;
            if (i8 == 0) {
                e1.n(obj);
                bVar.f35605e = 1;
                objS = i0Var.s(bVar);
                if (objS == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                objS = ((r) obj).o();
            }
            return r.h(objS);
        }
    }

    @a7.e
    Object A(@a7.d kotlin.coroutines.d<? super E> dVar);

    void c(@a7.e CancellationException cancellationException);

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean e(Throwable th);

    boolean isEmpty();

    @a7.d
    p<E> iterator();

    boolean j();

    @a7.d
    kotlinx.coroutines.selects.d<E> k();

    @a7.d
    kotlinx.coroutines.selects.d<r<E>> l();

    @a7.d
    kotlinx.coroutines.selects.d<E> n();

    @a7.d
    Object o();

    @kotlin.internal.h
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
    @a7.e
    Object p(@a7.d kotlin.coroutines.d<? super E> dVar);

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
    @a7.e
    E poll();

    @a7.e
    Object s(@a7.d kotlin.coroutines.d<? super r<? extends E>> dVar);
}
