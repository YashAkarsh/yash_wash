package kotlinx.coroutines.flow.internal;

import kotlin.l2;
import kotlinx.coroutines.internal.w0;

/* JADX INFO: loaded from: classes3.dex */
final class b0<T> implements kotlinx.coroutines.flow.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f36266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Object f36267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i5.p<T, kotlin.coroutines.d<? super l2>, Object> f36268c;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<T, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36271g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36271g = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36271g, dVar);
            aVar.f36270f = obj;
            return aVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.internal.b0$a for r3v1 'this'  kotlin.coroutines.d
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
                int r1 = r3.f36269e
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.e1.n(r4)
                goto L27
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.e1.n(r4)
                java.lang.Object r4 = r3.f36270f
                kotlinx.coroutines.flow.j<T> r1 = r3.f36271g
                r3.f36269e = r2
                java.lang.Object r4 = r1.f(r4, r3)
                if (r4 != r0) goto L27
                return r0
            L27:
                kotlin.l2 r4 = kotlin.l2.f34958a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.b0.a.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(T t7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(t7, dVar)).R(l2.f34958a);
        }
    }

    public b0(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.g gVar) {
        this.f36266a = gVar;
        this.f36267b = w0.b(gVar);
        this.f36268c = new a(jVar, null);
    }

    @Override // kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objC = f.c(this.f36266a, t7, this.f36267b, this.f36268c, dVar);
        return objC == kotlin.coroutines.intrinsics.d.h() ? objC : l2.f34958a;
    }
}
