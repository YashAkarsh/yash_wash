package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.d1;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class a implements kotlin.coroutines.d<Object>, e, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final kotlin.coroutines.d<Object> f34702a;

    public a(@a7.e kotlin.coroutines.d<Object> dVar) {
        this.f34702a = dVar;
    }

    @a7.d
    public kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> completion) {
        l0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @a7.d
    public kotlin.coroutines.d<l2> E(@a7.d kotlin.coroutines.d<?> completion) {
        l0.p(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @a7.e
    public final kotlin.coroutines.d<Object> F() {
        return this.f34702a;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return g.e(this);
    }

    @a7.e
    protected abstract Object R(@a7.d Object obj);

    protected void V() {
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public e i() {
        kotlin.coroutines.d<Object> dVar = this.f34702a;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object objI = I();
        if (objI == null) {
            objI = getClass().getName();
        }
        sb.append(objI);
        return sb.toString();
    }

    @Override // kotlin.coroutines.d
    public final void w(@a7.d Object obj) {
        kotlin.coroutines.d<Object> dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            kotlin.coroutines.d<Object> dVar2 = aVar.f34702a;
            l0.m(dVar2);
            try {
                Object objR = aVar.R(obj);
                if (objR == kotlin.coroutines.intrinsics.d.h()) {
                    return;
                }
                d1.a aVar2 = d1.f34719b;
                obj = d1.b(objR);
            } catch (Throwable th) {
                d1.a aVar3 = d1.f34719b;
                obj = d1.b(e1.a(th));
            }
            aVar.V();
            if (!(dVar2 instanceof a)) {
                dVar2.w(obj);
                return;
            }
            dVar = dVar2;
        }
    }
}
