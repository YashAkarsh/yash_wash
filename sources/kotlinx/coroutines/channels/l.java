package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.l2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.w2;
import kotlinx.coroutines.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    public static final class a extends kotlin.coroutines.a implements kotlinx.coroutines.p0 {
        public a(kotlinx.coroutines.p0.b bVar) {
            super(bVar);
        }

        @Override // kotlinx.coroutines.p0
        public void handleException(@a7.d kotlin.coroutines.g gVar, @a7.d Throwable th) {
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0<E> f35607a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i0<? extends E> i0Var) {
            super(1);
            this.f35607a = i0Var;
        }

        public final void b(@a7.e Throwable th) {
            s.b(this.f35607a, th);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {ConstraintLayout.LayoutParams.a.f4571b0, 54}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
    static final class c<E> extends kotlin.coroutines.jvm.internal.o implements i5.p<g0<? super E>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f35610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i0<E> f35611h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(i0<? extends E> i0Var, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f35611h = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            c cVar = new c(this.f35611h, dVar);
            cVar.f35610g = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x004a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:18:0x0057  */
        /* JADX WARN: Code duplicated, block: B:20:0x0067 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0068  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r7.f35609f
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.f35608e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r4 = r7.f35610g
                kotlinx.coroutines.channels.g0 r4 = (kotlinx.coroutines.channels.g0) r4
                kotlin.e1.n(r8)
                r8 = r4
                goto L3d
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.f35608e
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r4 = r7.f35610g
                kotlinx.coroutines.channels.g0 r4 = (kotlinx.coroutines.channels.g0) r4
                kotlin.e1.n(r8)
                r5 = r7
                goto L4f
            L30:
                kotlin.e1.n(r8)
                java.lang.Object r8 = r7.f35610g
                kotlinx.coroutines.channels.g0 r8 = (kotlinx.coroutines.channels.g0) r8
                kotlinx.coroutines.channels.i0<E> r1 = r7.f35611h
                kotlinx.coroutines.channels.p r1 = r1.iterator()
            L3d:
                r4 = r7
            L3e:
                r4.f35610g = r8
                r4.f35608e = r1
                r4.f35609f = r3
                java.lang.Object r5 = r1.a(r4)
                if (r5 != r0) goto L4b
                return r0
            L4b:
                r6 = r4
                r4 = r8
                r8 = r5
                r5 = r6
            L4f:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L6b
                java.lang.Object r8 = r1.next()
                r5.f35610g = r4
                r5.f35608e = r1
                r5.f35609f = r2
                java.lang.Object r8 = r4.R(r8, r5)
                if (r8 != r0) goto L68
                return r0
            L68:
                r8 = r4
                r4 = r5
                goto L3e
            L6b:
                kotlin.l2 r8 = kotlin.l2.f34958a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.l.c.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d g0<? super E> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((c) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    @a7.d
    @f3
    public static final <E> i<E> a(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d x0 x0Var, @a7.e i5.l<? super Throwable, l2> lVar, @a7.d @kotlin.b i5.p<? super g0<? super E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        kotlin.coroutines.g gVarE = kotlinx.coroutines.n0.e(v0Var, gVar);
        i iVarA = j.a(i7);
        k c0Var = x0Var.d() ? new c0(gVarE, iVarA, pVar) : new k(gVarE, iVarA, true);
        if (lVar != null) {
            ((w2) c0Var).g0(lVar);
        }
        ((kotlinx.coroutines.a) c0Var).E1(x0Var, c0Var, pVar);
        return (i<E>) c0Var;
    }

    @a7.d
    @f3
    public static final <E> i<E> b(@a7.d i0<? extends E> i0Var, int i7, @a7.d x0 x0Var) {
        return c(w0.m(w0.m(f2.f36000a, n1.g()), new a(kotlinx.coroutines.p0.f37107r0)), null, i7, x0Var, new b(i0Var), new c(i0Var, null), 1, null);
    }

    public static /* synthetic */ i c(v0 v0Var, kotlin.coroutines.g gVar, int i7, x0 x0Var, i5.l lVar, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        kotlin.coroutines.g gVar2 = gVar;
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        int i9 = i7;
        if ((i8 & 4) != 0) {
            x0Var = x0.LAZY;
        }
        x0 x0Var2 = x0Var;
        if ((i8 & 8) != 0) {
            lVar = null;
        }
        return a(v0Var, gVar2, i9, x0Var2, lVar, pVar);
    }

    public static /* synthetic */ i d(i0 i0Var, int i7, x0 x0Var, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 1;
        }
        if ((i8 & 2) != 0) {
            x0Var = x0.LAZY;
        }
        return b(i0Var, i7, x0Var);
    }
}
