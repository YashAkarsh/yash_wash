package kotlinx.coroutines.flow;

import easypay.appinvoke.manager.Constants;
import java.util.concurrent.CancellationException;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q f36672b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.u$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0}, l = {113, 114}, m = "collect", n = {"this", "$this$catch_u24lambda_u2d0"}, s = {"L$0", "L$1"})
        public static final class C0482a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36673d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36674e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36676g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36677h;

            public C0482a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36673d = obj;
                this.f36674e |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public a(i iVar, i5.q qVar) {
            this.f36671a = iVar;
            this.f36672b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
            C0482a c0482a;
            a<T> aVar;
            if (dVar instanceof C0482a) {
                c0482a = (C0482a) dVar;
                int i7 = c0482a.f36674e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    c0482a.f36674e = i7 - Integer.MIN_VALUE;
                } else {
                    c0482a = new C0482a(dVar);
                }
            } else {
                c0482a = new C0482a(dVar);
            }
            Object objV = c0482a.f36673d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = c0482a.f36674e;
            if (i8 != 0) {
                if (i8 == 1) {
                    jVar = (j) c0482a.f36677h;
                    aVar = (a) c0482a.f36676g;
                    e1.n(objV);
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(objV);
                }
                return l2.f34958a;
            }
            e1.n(objV);
            i iVar = this.f36671a;
            c0482a.f36676g = this;
            c0482a.f36677h = jVar;
            c0482a.f36674e = 1;
            objV = k.v(iVar, jVar, c0482a);
            if (objV == objH) {
                return objH;
            }
            aVar = this;
            Throwable th = (Throwable) objV;
            if (th != null) {
                i5.q qVar = aVar.f36672b;
                c0482a.f36676g = null;
                c0482a.f36677h = null;
                c0482a.f36674e = 2;
                kotlin.jvm.internal.i0.e(6);
                Object objV2 = qVar.v(jVar, th, c0482a);
                kotlin.jvm.internal.i0.e(7);
                if (objV2 == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {Constants.ACTION_DELAY_PASSWORD_FOUND}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36680f;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36679e = obj;
            this.f36680f |= Integer.MIN_VALUE;
            return k.v(null, null, this);
        }
    }

    static final class c<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f36681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.h<Throwable> f36682b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", i = {0}, l = {158}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36683d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36684e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c<T> f36685f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f36686g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36685f = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36684e = obj;
                this.f36686g |= Integer.MIN_VALUE;
                return this.f36685f.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(j<? super T> jVar, k1.h<Throwable> hVar) {
            this.f36681a = jVar;
            this.f36682b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
            a aVar;
            c<T> cVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36686g;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36686g = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36684e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36686g;
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cVar = (c) aVar.f36683d;
                try {
                    e1.n(obj);
                    return l2.f34958a;
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    this = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.u.c.a
                    if (r0 == 0) goto L13
                    r0 = r6
                    kotlinx.coroutines.flow.u$c$a r0 = (kotlinx.coroutines.flow.u.c.a) r0
                    int r1 = r0.f36686g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f36686g = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.u$c$a r0 = new kotlinx.coroutines.flow.u$c$a
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f36684e
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
                    int r2 = r0.f36686g
                    r3 = 1
                    if (r2 == 0) goto L37
                    if (r2 != r3) goto L2f
                    java.lang.Object r5 = r0.f36683d
                    kotlinx.coroutines.flow.u$c r5 = (kotlinx.coroutines.flow.u.c) r5
                    kotlin.e1.n(r6)     // Catch: java.lang.Throwable -> L2d
                    goto L47
                L2d:
                    r6 = move-exception
                    goto L4c
                L2f:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L37:
                    kotlin.e1.n(r6)
                    kotlinx.coroutines.flow.j<T> r6 = r4.f36681a     // Catch: java.lang.Throwable -> L4a
                    r0.f36683d = r4     // Catch: java.lang.Throwable -> L4a
                    r0.f36686g = r3     // Catch: java.lang.Throwable -> L4a
                    java.lang.Object r5 = r6.f(r5, r0)     // Catch: java.lang.Throwable -> L4a
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    kotlin.l2 r5 = kotlin.l2.f34958a
                    return r5
                L4a:
                    r6 = move-exception
                    r5 = r4
                L4c:
                    kotlin.jvm.internal.k1$h<java.lang.Throwable> r5 = r5.f36682b
                    r5.f34872a = r6
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.u.c.f(java.lang.Object, kotlin.coroutines.d):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class d extends kotlin.coroutines.jvm.internal.o implements i5.p<Throwable, kotlin.coroutines.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36687e;

            d(kotlin.coroutines.d<? super d> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                return new d(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                kotlin.coroutines.intrinsics.d.h();
                if (this.f36687e != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                return kotlin.coroutines.jvm.internal.b.a(true);
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d Throwable th, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
                return ((d) D(th, dVar)).R(l2.f34958a);
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
        static final class e<T> extends kotlin.coroutines.jvm.internal.o implements i5.r<j<? super T>, Throwable, Long, kotlin.coroutines.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36688e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36689f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ long f36690g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f36691h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ i5.p<Throwable, kotlin.coroutines.d<? super Boolean>, Object> f36692i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            e(long j7, i5.p<? super Throwable, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super e> dVar) {
                super(4, dVar);
                this.f36691h = j7;
                this.f36692i = pVar;
            }

            @Override // i5.r
            public /* bridge */ /* synthetic */ Object K(Object obj, Throwable th, Long l7, kotlin.coroutines.d<? super Boolean> dVar) {
                return e0((j) obj, th, l7.longValue(), dVar);
            }

            /* JADX WARN: Code duplicated, block: B:16:0x003a  */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36688e;
                if (i7 == 0) {
                    e1.n(obj);
                    Throwable th = (Throwable) this.f36689f;
                    if (this.f36690g < this.f36691h) {
                        i5.p<Throwable, kotlin.coroutines.d<? super Boolean>, Object> pVar = this.f36692i;
                        this.f36688e = 1;
                        obj = pVar.a0(th, this);
                        if (obj == objH) {
                            return objH;
                        }
                    }
                    return kotlin.coroutines.jvm.internal.b.a(z);
                }
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                boolean z7 = ((Boolean) obj).booleanValue();
                return kotlin.coroutines.jvm.internal.b.a(z7);
            }

            @a7.e
            public final Object e0(@a7.d j<? super T> jVar, @a7.d Throwable th, long j7, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
                e eVar = new e(this.f36691h, this.f36692i, dVar);
                eVar.f36689f = th;
                eVar.f36690g = j7;
                return eVar.R(l2.f34958a);
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        public static final class f<T> implements i<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f36693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.r f36694b;

            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {117, 119}, m = "collect", n = {"this", "$this$retryWhen_u24lambda_u2d2", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u2d2", "cause", "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
            public static final class a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36695d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36696e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36698g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                Object f36699h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                Object f36700i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                long f36701j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                int f36702k;

                public a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36695d = obj;
                    this.f36696e |= Integer.MIN_VALUE;
                    return f.this.a(null, this);
                }
            }

            public f(i iVar, i5.r rVar) {
                this.f36693a = iVar;
                this.f36694b = rVar;
            }

            /* JADX WARN: Code duplicated, block: B:19:0x006e A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:20:0x006f  */
            /* JADX WARN: Code duplicated, block: B:23:0x0078  */
            /* JADX WARN: Code duplicated, block: B:25:0x0096 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:26:0x0097  */
            /* JADX WARN: Code duplicated, block: B:33:0x00ab  */
            /* JADX WARN: Code duplicated, block: B:35:0x00ae  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:31:0x00a8). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:27:0x009a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlinx.coroutines.flow.i
            @a7.e
            public java.lang.Object a(@a7.d kotlinx.coroutines.flow.j<? super T> r12, @a7.d kotlin.coroutines.d<? super kotlin.l2> r13) {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof kotlinx.coroutines.flow.u.f.a
                    if (r0 == 0) goto L13
                    r0 = r13
                    kotlinx.coroutines.flow.u$f$a r0 = (kotlinx.coroutines.flow.u.f.a) r0
                    int r1 = r0.f36696e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f36696e = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.u$f$a r0 = new kotlinx.coroutines.flow.u$f$a
                    r0.<init>(r13)
                L18:
                    java.lang.Object r13 = r0.f36695d
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.h()
                    int r2 = r0.f36696e
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L52
                    if (r2 == r4) goto L42
                    if (r2 != r3) goto L3a
                    long r5 = r0.f36701j
                    java.lang.Object r12 = r0.f36700i
                    java.lang.Throwable r12 = (java.lang.Throwable) r12
                    java.lang.Object r2 = r0.f36699h
                    kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) r2
                    java.lang.Object r7 = r0.f36698g
                    kotlinx.coroutines.flow.u$f r7 = (kotlinx.coroutines.flow.u.f) r7
                    kotlin.e1.n(r13)
                    goto L9a
                L3a:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L42:
                    int r12 = r0.f36702k
                    long r5 = r0.f36701j
                    java.lang.Object r2 = r0.f36699h
                    kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) r2
                    java.lang.Object r7 = r0.f36698g
                    kotlinx.coroutines.flow.u$f r7 = (kotlinx.coroutines.flow.u.f) r7
                    kotlin.e1.n(r13)
                    goto L74
                L52:
                    kotlin.e1.n(r13)
                    r5 = 0
                    r13 = r11
                L58:
                    kotlinx.coroutines.flow.i r2 = r13.f36693a
                    r0.f36698g = r13
                    r0.f36699h = r12
                    r7 = 0
                    r0.f36700i = r7
                    r0.f36701j = r5
                    r7 = 0
                    r0.f36702k = r7
                    r0.f36696e = r4
                    java.lang.Object r2 = kotlinx.coroutines.flow.k.v(r2, r12, r0)
                    if (r2 != r1) goto L6f
                    return r1
                L6f:
                    r10 = r2
                    r2 = r12
                    r12 = r7
                    r7 = r13
                    r13 = r10
                L74:
                    java.lang.Throwable r13 = (java.lang.Throwable) r13
                    if (r13 == 0) goto La8
                    i5.r r12 = r7.f36694b
                    java.lang.Long r8 = kotlin.coroutines.jvm.internal.b.g(r5)
                    r0.f36698g = r7
                    r0.f36699h = r2
                    r0.f36700i = r13
                    r0.f36701j = r5
                    r0.f36696e = r3
                    r9 = 6
                    kotlin.jvm.internal.i0.e(r9)
                    java.lang.Object r12 = r12.K(r2, r13, r8, r0)
                    r8 = 7
                    kotlin.jvm.internal.i0.e(r8)
                    if (r12 != r1) goto L97
                    return r1
                L97:
                    r10 = r13
                    r13 = r12
                    r12 = r10
                L9a:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    if (r13 == 0) goto La7
                    r12 = 1
                    long r5 = r5 + r12
                    r12 = r4
                    goto La8
                La7:
                    throw r12
                La8:
                    r13 = r7
                    if (r12 != 0) goto Lae
                    kotlin.l2 r12 = kotlin.l2.f34958a
                    return r12
                Lae:
                    r12 = r2
                    goto L58
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.u.f.a(kotlinx.coroutines.flow.j, kotlin.coroutines.d):java.lang.Object");
            }
        }

        @a7.d
        public static final <T> i<T> a(@a7.d i<? extends T> iVar, @a7.d i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
            return new a(iVar, qVar);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @a7.e
        public static final <T> Object b(@a7.d i<? extends T> iVar, @a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super Throwable> dVar) throws Throwable {
            b bVar;
            k1.h hVar;
            if (dVar instanceof b) {
                bVar = (b) dVar;
                int i7 = bVar.f36680f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    bVar.f36680f = i7 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(dVar);
                }
            } else {
                bVar = new b(dVar);
            }
            Object obj = bVar.f36679e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = bVar.f36680f;
            if (i8 == 0) {
                e1.n(obj);
                k1.h hVar2 = new k1.h();
                try {
                    j<? super Object> cVar = new c<>(jVar, hVar2);
                    bVar.f36678d = hVar2;
                    bVar.f36680f = 1;
                    if (iVar.a(cVar, bVar) == objH) {
                        return objH;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    hVar = hVar2;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hVar = (k1.h) bVar.f36678d;
                try {
                    e1.n(obj);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            Throwable th3 = (Throwable) hVar.f34872a;
            if (d(th, th3) || c(th, bVar.d())) {
                throw th;
            }
            if (th3 == null) {
                return th;
            }
            if (th instanceof CancellationException) {
                kotlin.p.a(th3, th);
                throw th3;
            }
            kotlin.p.a(th, th3);
            throw th;
        }

        private static final boolean c(Throwable th, kotlin.coroutines.g gVar) {
            o2 o2Var = (o2) gVar.get(o2.f37103s0);
            if (o2Var == null || !o2Var.isCancelled()) {
                return false;
            }
            return d(th, o2Var.K());
        }

        private static final boolean d(Throwable th, Throwable th2) {
            return th2 != null && kotlin.jvm.internal.l0.g(th2, th);
        }

        @a7.d
        public static final <T> i<T> e(@a7.d i<? extends T> iVar, long j7, @a7.d i5.p<? super Throwable, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
            if (j7 > 0) {
                return k.x1(iVar, new e(j7, pVar, null));
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Expected positive amount of retries, but had ", Long.valueOf(j7)).toString());
        }

        public static /* synthetic */ i f(i iVar, long j7, i5.p pVar, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                j7 = Long.MAX_VALUE;
            }
            if ((i7 & 2) != 0) {
                pVar = new d(null);
            }
            return k.v1(iVar, j7, pVar);
        }

        @a7.d
        public static final <T> i<T> g(@a7.d i<? extends T> iVar, @a7.d i5.r<? super j<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> rVar) {
            return new f(iVar, rVar);
        }
    }
