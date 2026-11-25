package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.channels.e0;
import kotlinx.coroutines.channels.g0;
import kotlinx.coroutines.channels.i0;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class k<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final Iterable<kotlinx.coroutines.flow.i<T>> f36321d;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {com.alibaba.fastjson.asm.j.f12632z}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36322e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T> f36323f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ y<T> f36324g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.i<? extends T> iVar, y<T> yVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36323f = iVar;
            this.f36324g = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new a(this.f36323f, this.f36324g, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36322e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.i<T> iVar = this.f36323f;
                y<T> yVar = this.f36324g;
                this.f36322e = 1;
                if (iVar.a(yVar, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    public /* synthetic */ k(Iterable iterable, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(iterable, (i8 & 2) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 4) != 0 ? -2 : i7, (i8 & 8) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        y yVar = new y(g0Var);
        Iterator<kotlinx.coroutines.flow.i<T>> it = this.f36321d.iterator();
        while (it.hasNext()) {
            kotlinx.coroutines.l.f(g0Var, null, null, new a(it.next(), yVar, null), 3, null);
        }
        return l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new k(this.f36321d, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public i0<T> o(@a7.d v0 v0Var) {
        return e0.c(v0Var, this.f36273a, this.f36274b, l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@a7.d Iterable<? extends kotlinx.coroutines.flow.i<? extends T>> iterable, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(gVar, i7, mVar);
        this.f36321d = iterable;
    }
}
