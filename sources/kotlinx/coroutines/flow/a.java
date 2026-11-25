package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.e2;

/* JADX INFO: loaded from: classes3.dex */
@e2
public abstract class a<T> implements i<T>, c<T> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.a$a, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {230}, m = "collect", n = {"safeCollector"}, s = {"L$0"})
    static final class C0454a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36004e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<T> f36005f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36006g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0454a(a<T> aVar, kotlin.coroutines.d<? super C0454a> dVar) {
            super(dVar);
            this.f36005f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36004e = obj;
            this.f36006g |= Integer.MIN_VALUE;
            return this.f36005f.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.i
    @a7.e
    public final Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
        C0454a c0454a;
        Throwable th;
        kotlinx.coroutines.flow.internal.v vVar;
        if (dVar instanceof C0454a) {
            c0454a = (C0454a) dVar;
            int i7 = c0454a.f36006g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                c0454a.f36006g = i7 - Integer.MIN_VALUE;
            } else {
                c0454a = new C0454a(this, dVar);
            }
        } else {
            c0454a = new C0454a(this, dVar);
        }
        Object obj = c0454a.f36004e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = c0454a.f36006g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            vVar = (kotlinx.coroutines.flow.internal.v) c0454a.f36003d;
            try {
                e1.n(obj);
                vVar.V();
                return l2.f34958a;
            } catch (Throwable th2) {
                th = th2;
                vVar.V();
                throw th;
            }
        }
        e1.n(obj);
        kotlinx.coroutines.flow.internal.v vVar2 = new kotlinx.coroutines.flow.internal.v(jVar, c0454a.d());
        try {
            c0454a.f36003d = vVar2;
            c0454a.f36006g = 1;
            if (d(vVar2, c0454a) == objH) {
                return objH;
            }
            vVar = vVar2;
            vVar.V();
            return l2.f34958a;
        } catch (Throwable th3) {
            th = th3;
            vVar = vVar2;
            vVar.V();
            throw th;
        }
    }

    @a7.e
    public abstract Object d(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar);
}
