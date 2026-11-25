package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.a1;
import kotlin.collections.r0;
import kotlin.e1;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.channels.e0;
import kotlinx.coroutines.channels.g0;
import kotlinx.coroutines.channels.i0;
import kotlinx.coroutines.channels.m0;
import kotlinx.coroutines.g4;
import kotlinx.coroutines.u2;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {com.alibaba.fastjson.asm.j.f12627u, com.alibaba.fastjson.asm.j.f12629w, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36325e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36326f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36327g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36328h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f36329i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private /* synthetic */ Object f36330j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36331k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ i5.a<T[]> f36332l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36333m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f36334n;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        static final class C0466a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36335e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36336f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f36337g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f36338h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.n<r0<Object>> f36339i;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$a$a$a, reason: collision with other inner class name */
            static final class C0467a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.n<r0<Object>> f36340a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f36341b;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$a$a$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {35, 36}, m = "emit", n = {}, s = {})
                static final class C0468a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    /* synthetic */ Object f36342d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ C0467a<T> f36343e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36344f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0468a(C0467a<? super T> c0467a, kotlin.coroutines.d<? super C0468a> dVar) {
                        super(dVar);
                        this.f36343e = c0467a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) {
                        this.f36342d = obj;
                        this.f36344f |= Integer.MIN_VALUE;
                        return this.f36343e.f(null, this);
                    }
                }

                C0467a(kotlinx.coroutines.channels.n<r0<Object>> nVar, int i7) {
                    this.f36340a = nVar;
                    this.f36341b = i7;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.j
                @a7.e
                public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                    C0468a c0468a;
                    if (dVar instanceof C0468a) {
                        c0468a = (C0468a) dVar;
                        int i7 = c0468a.f36344f;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            c0468a.f36344f = i7 - Integer.MIN_VALUE;
                        } else {
                            c0468a = new C0468a(this, dVar);
                        }
                    } else {
                        c0468a = new C0468a(this, dVar);
                    }
                    Object obj = c0468a.f36342d;
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i8 = c0468a.f36344f;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            e1.n(obj);
                        } else {
                            if (i8 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            e1.n(obj);
                        }
                        return l2.f34958a;
                    }
                    e1.n(obj);
                    kotlinx.coroutines.channels.n<r0<Object>> nVar = this.f36340a;
                    r0<Object> r0Var = new r0<>(this.f36341b, t7);
                    c0468a.f36344f = 1;
                    if (nVar.R(r0Var, c0468a) == objH) {
                        return objH;
                    }
                    c0468a.f36344f = 2;
                    if (g4.a(c0468a) == objH) {
                        return objH;
                    }
                    return l2.f34958a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0466a(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, int i7, AtomicInteger atomicInteger, kotlinx.coroutines.channels.n<r0<Object>> nVar, kotlin.coroutines.d<? super C0466a> dVar) {
                super(2, dVar);
                this.f36336f = iVarArr;
                this.f36337g = i7;
                this.f36338h = atomicInteger;
                this.f36339i = nVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                return new C0466a(this.f36336f, this.f36337g, this.f36338h, this.f36339i, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36335e;
                try {
                    if (i7 == 0) {
                        e1.n(obj);
                        kotlinx.coroutines.flow.i[] iVarArr = this.f36336f;
                        int i8 = this.f36337g;
                        kotlinx.coroutines.flow.i iVar = iVarArr[i8];
                        C0467a c0467a = new C0467a(this.f36339i, i8);
                        this.f36335e = 1;
                        if (iVar.a(c0467a, this) == objH) {
                            return objH;
                        }
                    } else {
                        if (i7 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    if (this.f36338h.decrementAndGet() == 0) {
                        m0.a.a(this.f36339i, null, 1, null);
                    }
                    return l2.f34958a;
                } catch (Throwable th) {
                    if (this.f36338h.decrementAndGet() == 0) {
                        m0.a.a(this.f36339i, null, 1, null);
                    }
                    throw th;
                }
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((C0466a) D(v0Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, i5.a<T[]> aVar, i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlinx.coroutines.flow.j<? super R> jVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36331k = iVarArr;
            this.f36332l = aVar;
            this.f36333m = qVar;
            this.f36334n = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36331k, this.f36332l, this.f36333m, this.f36334n, dVar);
            aVar.f36330j = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00d9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x00da  */
        /* JADX WARN: Code duplicated, block: B:26:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:28:0x00e7 A[LOOP:0: B:28:0x00e7->B:52:?, LOOP_START, PHI: r6 r10
          0x00e7: PHI (r6v9 int) = (r6v8 int), (r6v10 int) binds: [B:25:0x00e2, B:52:?] A[DONT_GENERATE, DONT_INLINE]
          0x00e7: PHI (r10v5 kotlin.collections.r0) = (r10v4 kotlin.collections.r0), (r10v18 kotlin.collections.r0) binds: [B:25:0x00e2, B:52:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:30:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:34:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:37:0x010f  */
        /* JADX WARN: Code duplicated, block: B:39:0x0119  */
        /* JADX WARN: Code duplicated, block: B:41:0x012f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x0130  */
        /* JADX WARN: Code duplicated, block: B:47:0x0162  */
        /* JADX WARN: Code duplicated, block: B:50:0x010d A[EDGE_INSN: B:50:0x010d->B:36:0x010d BREAK  A[LOOP:0: B:28:0x00e7->B:52:?], SYNTHETIC] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0130 -> B:20:0x00c4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 359
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.m.a.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class b<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.q f36347c;

        public b(kotlinx.coroutines.flow.i iVar, kotlinx.coroutines.flow.i iVar2, i5.q qVar) {
            this.f36345a = iVar;
            this.f36346b = iVar2;
            this.f36347c = qVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objG = w0.g(new c(jVar, this.f36345a, this.f36346b, this.f36347c, null), dVar);
            return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
    static final class c extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36349f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f36350g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T2> f36351h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T1> f36352i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> f36353j;

        static final class a extends n0 implements i5.l<Throwable, l2> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c0 f36354a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f36355b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c0 c0Var, kotlinx.coroutines.flow.j<? super R> jVar) {
                super(1);
                this.f36354a = c0Var;
                this.f36355b = jVar;
            }

            public final void b(@a7.e Throwable th) {
                if (this.f36354a.b()) {
                    this.f36354a.c(new kotlinx.coroutines.flow.internal.a(this.f36355b));
                }
            }

            @Override // i5.l
            public /* bridge */ /* synthetic */ l2 z(Throwable th) {
                b(th);
                return l2.f34958a;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<l2, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36356e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T1> f36357f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.coroutines.g f36358g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ Object f36359h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ i0<Object> f36360i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f36361j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> f36362k;

            static final class a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlin.coroutines.g f36363a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Object f36364b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ i0<Object> f36365c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j<R> f36366d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> f36367e;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$c$b$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
                static final class C0469a extends kotlin.coroutines.jvm.internal.o implements i5.p<l2, kotlin.coroutines.d<? super l2>, Object> {

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    Object f36368e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36369f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ i0<Object> f36370g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.flow.j<R> f36371h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    final /* synthetic */ i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> f36372i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    final /* synthetic */ T1 f36373j;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0469a(i0<? extends Object> i0Var, kotlinx.coroutines.flow.j<? super R> jVar, i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, T1 t7, kotlin.coroutines.d<? super C0469a> dVar) {
                        super(2, dVar);
                        this.f36370g = i0Var;
                        this.f36371h = jVar;
                        this.f36372i = qVar;
                        this.f36373j = t7;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.d
                    public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                        return new C0469a(this.f36370g, this.f36371h, this.f36372i, this.f36373j, dVar);
                    }

                    /* JADX WARN: Code duplicated, block: B:29:0x006e A[RETURN] */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) throws Throwable {
                        Object objS;
                        kotlinx.coroutines.flow.j jVar;
                        Object objH = kotlin.coroutines.intrinsics.d.h();
                        int i7 = this.f36369f;
                        if (i7 != 0) {
                            if (i7 == 1) {
                                e1.n(obj);
                                objS = ((kotlinx.coroutines.channels.r) obj).o();
                            } else if (i7 == 2) {
                                kotlinx.coroutines.flow.j jVar2 = (kotlinx.coroutines.flow.j) this.f36368e;
                                e1.n(obj);
                                jVar = jVar2;
                                this.f36368e = null;
                                this.f36369f = 3;
                                if (jVar.f(obj, this) == objH) {
                                    return objH;
                                }
                            } else {
                                if (i7 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                e1.n(obj);
                            }
                            return l2.f34958a;
                        }
                        e1.n(obj);
                        i0<Object> i0Var = this.f36370g;
                        this.f36369f = 1;
                        objS = i0Var.s(this);
                        if (objS == objH) {
                            return objH;
                        }
                        kotlinx.coroutines.flow.j jVar3 = this.f36371h;
                        if (objS instanceof kotlinx.coroutines.channels.r.c) {
                            Throwable thF = kotlinx.coroutines.channels.r.f(objS);
                            if (thF == null) {
                                throw new kotlinx.coroutines.flow.internal.a(jVar3);
                            }
                            throw thF;
                        }
                        i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> qVar = this.f36372i;
                        T1 t7 = this.f36373j;
                        if (objS == u.f36394a) {
                            objS = null;
                        }
                        this.f36368e = jVar3;
                        this.f36369f = 2;
                        obj = qVar.v(t7, objS, this);
                        jVar = jVar3;
                        if (obj == objH) {
                            return objH;
                        }
                        this.f36368e = null;
                        this.f36369f = 3;
                        if (jVar.f(obj, this) == objH) {
                            return objH;
                        }
                        return l2.f34958a;
                    }

                    @Override // i5.p
                    @a7.e
                    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
                    public final Object a0(@a7.d l2 l2Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                        return ((C0469a) D(l2Var, dVar)).R(l2.f34958a);
                    }
                }

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$c$b$a$b, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", f = "Combine.kt", i = {}, l = {131}, m = "emit", n = {}, s = {})
                static final class C0470b extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    /* synthetic */ Object f36374d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a<T> f36375e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36376f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0470b(a<? super T> aVar, kotlin.coroutines.d<? super C0470b> dVar) {
                        super(dVar);
                        this.f36375e = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) {
                        this.f36374d = obj;
                        this.f36376f |= Integer.MIN_VALUE;
                        return this.f36375e.f(null, this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                a(kotlin.coroutines.g gVar, Object obj, i0<? extends Object> i0Var, kotlinx.coroutines.flow.j<? super R> jVar, i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
                    this.f36363a = gVar;
                    this.f36364b = obj;
                    this.f36365c = i0Var;
                    this.f36366d = jVar;
                    this.f36367e = qVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.j
                @a7.e
                public final Object f(T1 t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                    C0470b c0470b;
                    if (dVar instanceof C0470b) {
                        c0470b = (C0470b) dVar;
                        int i7 = c0470b.f36376f;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            c0470b.f36376f = i7 - Integer.MIN_VALUE;
                        } else {
                            c0470b = new C0470b(this, dVar);
                        }
                    } else {
                        c0470b = new C0470b(this, dVar);
                    }
                    Object obj = c0470b.f36374d;
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i8 = c0470b.f36376f;
                    if (i8 == 0) {
                        e1.n(obj);
                        kotlin.coroutines.g gVar = this.f36363a;
                        l2 l2Var = l2.f34958a;
                        Object obj2 = this.f36364b;
                        C0469a c0469a = new C0469a(this.f36365c, this.f36366d, this.f36367e, t7, null);
                        c0470b.f36376f = 1;
                        if (f.c(gVar, l2Var, obj2, c0469a, c0470b) == objH) {
                            return objH;
                        }
                    } else {
                        if (i8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(kotlinx.coroutines.flow.i<? extends T1> iVar, kotlin.coroutines.g gVar, Object obj, i0<? extends Object> i0Var, kotlinx.coroutines.flow.j<? super R> jVar, i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlin.coroutines.d<? super b> dVar) {
                super(2, dVar);
                this.f36357f = iVar;
                this.f36358g = gVar;
                this.f36359h = obj;
                this.f36360i = i0Var;
                this.f36361j = jVar;
                this.f36362k = qVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                return new b(this.f36357f, this.f36358g, this.f36359h, this.f36360i, this.f36361j, this.f36362k, dVar);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.internal.m$c$b for r9v1 'this'  kotlin.coroutines.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final java.lang.Object R(@a7.d java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                    int r1 = r9.f36356e
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    kotlin.e1.n(r10)
                    goto L35
                Lf:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L17:
                    kotlin.e1.n(r10)
                    kotlinx.coroutines.flow.i<T1> r10 = r9.f36357f
                    kotlinx.coroutines.flow.internal.m$c$b$a r1 = new kotlinx.coroutines.flow.internal.m$c$b$a
                    kotlin.coroutines.g r4 = r9.f36358g
                    java.lang.Object r5 = r9.f36359h
                    kotlinx.coroutines.channels.i0<java.lang.Object> r6 = r9.f36360i
                    kotlinx.coroutines.flow.j<R> r7 = r9.f36361j
                    i5.q<T1, T2, kotlin.coroutines.d<? super R>, java.lang.Object> r8 = r9.f36362k
                    r3 = r1
                    r3.<init>(r4, r5, r6, r7, r8)
                    r9.f36356e = r2
                    java.lang.Object r10 = r10.a(r1, r9)
                    if (r10 != r0) goto L35
                    return r0
                L35:
                    kotlin.l2 r10 = kotlin.l2.f34958a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.m.c.b.R(java.lang.Object):java.lang.Object");
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d l2 l2Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((b) D(l2Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$c$c, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
        static final class C0471c extends kotlin.coroutines.jvm.internal.o implements i5.p<g0<? super Object>, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36377e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36378f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T2> f36379g;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$c$c$a */
            static final class a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ g0<Object> f36380a;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.m$c$c$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1", f = "Combine.kt", i = {}, l = {93}, m = "emit", n = {}, s = {})
                static final class C0472a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    /* synthetic */ Object f36381d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a<T> f36382e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36383f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0472a(a<? super T> aVar, kotlin.coroutines.d<? super C0472a> dVar) {
                        super(dVar);
                        this.f36382e = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) {
                        this.f36381d = obj;
                        this.f36383f |= Integer.MIN_VALUE;
                        return this.f36382e.f(null, this);
                    }
                }

                a(g0<Object> g0Var) {
                    this.f36380a = g0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.j
                @a7.e
                public final Object f(T2 t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                    C0472a c0472a;
                    Object obj;
                    if (dVar instanceof C0472a) {
                        c0472a = (C0472a) dVar;
                        int i7 = c0472a.f36383f;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            c0472a.f36383f = i7 - Integer.MIN_VALUE;
                        } else {
                            c0472a = new C0472a(this, dVar);
                        }
                    } else {
                        c0472a = new C0472a(this, dVar);
                    }
                    Object obj2 = c0472a.f36381d;
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i8 = c0472a.f36383f;
                    if (i8 == 0) {
                        e1.n(obj2);
                        m0<Object> m0VarA = this.f36380a.a();
                        if (t7 == 0) {
                            obj = t7;
                            obj = u.f36394a;
                        }
                        obj = t7;
                        c0472a.f36383f = 1;
                        if (m0VarA.R(obj, c0472a) == objH) {
                            return objH;
                        }
                    } else {
                        if (i8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj2);
                    }
                    return l2.f34958a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0471c(kotlinx.coroutines.flow.i<? extends T2> iVar, kotlin.coroutines.d<? super C0471c> dVar) {
                super(2, dVar);
                this.f36379g = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                C0471c c0471c = new C0471c(this.f36379g, dVar);
                c0471c.f36378f = obj;
                return c0471c;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.internal.m$c$c for r4v1 'this'  kotlin.coroutines.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final java.lang.Object R(@a7.d java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                    int r1 = r4.f36377e
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    kotlin.e1.n(r5)
                    goto L2e
                Lf:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L17:
                    kotlin.e1.n(r5)
                    java.lang.Object r5 = r4.f36378f
                    kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.g0) r5
                    kotlinx.coroutines.flow.i<T2> r1 = r4.f36379g
                    kotlinx.coroutines.flow.internal.m$c$c$a r3 = new kotlinx.coroutines.flow.internal.m$c$c$a
                    r3.<init>(r5)
                    r4.f36377e = r2
                    java.lang.Object r5 = r1.a(r3, r4)
                    if (r5 != r0) goto L2e
                    return r0
                L2e:
                    kotlin.l2 r5 = kotlin.l2.f34958a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.m.c.C0471c.R(java.lang.Object):java.lang.Object");
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((C0471c) D(g0Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(kotlinx.coroutines.flow.j<? super R> jVar, kotlinx.coroutines.flow.i<? extends T2> iVar, kotlinx.coroutines.flow.i<? extends T1> iVar2, i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f36350g = jVar;
            this.f36351h = iVar;
            this.f36352i = iVar2;
            this.f36353j = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            c cVar = new c(this.f36350g, this.f36351h, this.f36352i, this.f36353j, dVar);
            cVar.f36349f = obj;
            return cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.i0] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.i0] */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) throws Throwable {
            i0 i0Var;
            i0 i0Var2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            ?? r7 = this.f36348e;
            try {
                if (r7 != 0) {
                    if (r7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i0Var2 = (i0) this.f36349f;
                    try {
                        e1.n(obj);
                        r7 = i0Var2;
                    } catch (kotlinx.coroutines.flow.internal.a e8) {
                        e = e8;
                        q.b(e, this.f36350g);
                        r7 = i0Var2;
                    }
                    i0.a.b(r7, null, 1, null);
                    return l2.f34958a;
                }
                e1.n(obj);
                v0 v0Var = (v0) this.f36349f;
                i0 i0VarF = e0.f(v0Var, null, 0, new C0471c(this.f36351h, null), 3, null);
                c0 c0VarC = u2.c(null, 1, null);
                ((m0) i0VarF).M(new a(c0VarC, this.f36350g));
                try {
                    kotlin.coroutines.g gVarD = v0Var.D();
                    Object objB = kotlinx.coroutines.internal.w0.b(gVarD);
                    kotlin.coroutines.g gVarPlus = v0Var.D().plus(c0VarC);
                    l2 l2Var = l2.f34958a;
                    b bVar = new b(this.f36352i, gVarD, objB, i0VarF, this.f36350g, this.f36353j, null);
                    this.f36349f = i0VarF;
                    this.f36348e = 1;
                    i0Var = i0VarF;
                    try {
                        if (f.d(gVarPlus, l2Var, null, bVar, this, 4, null) == objH) {
                            return objH;
                        }
                        r7 = i0Var;
                        i0.a.b(r7, null, 1, null);
                        return l2.f34958a;
                    } catch (kotlinx.coroutines.flow.internal.a e9) {
                        e = e9;
                        i0Var2 = i0Var;
                        q.b(e, this.f36350g);
                        r7 = i0Var2;
                    } catch (Throwable th) {
                        th = th;
                        r7 = i0Var;
                        i0.a.b(r7, null, 1, null);
                        throw th;
                    }
                } catch (kotlinx.coroutines.flow.internal.a e10) {
                    e = e10;
                    i0Var = i0VarF;
                } catch (Throwable th2) {
                    th = th2;
                    i0Var = i0VarF;
                }
                q.b(e, this.f36350g);
                r7 = i0Var2;
                i0.a.b(r7, null, 1, null);
                return l2.f34958a;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((c) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @a7.e
    @a1
    public static final <R, T> Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlinx.coroutines.flow.i<? extends T>[] iVarArr, @a7.d i5.a<T[]> aVar, @a7.d i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = p.a(new a(iVarArr, aVar, qVar, jVar, null), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    @a7.d
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> b(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return new b(iVar2, iVar, qVar);
    }
}
