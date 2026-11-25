package kotlin.coroutines.jvm.internal;

import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final kotlin.coroutines.g f34704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private transient kotlin.coroutines.d<Object> f34705c;

    public d(@a7.e kotlin.coroutines.d<Object> dVar, @a7.e kotlin.coroutines.g gVar) {
        super(dVar);
        this.f34704b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void V() {
        kotlin.coroutines.d<?> dVar = this.f34705c;
        if (dVar != null && dVar != this) {
            kotlin.coroutines.g.b bVar = d().get(kotlin.coroutines.e.f34677q0);
            l0.m(bVar);
            ((kotlin.coroutines.e) bVar).g(dVar);
        }
        this.f34705c = c.f34703a;
    }

    @a7.d
    public final kotlin.coroutines.d<Object> Z() {
        kotlin.coroutines.d<Object> dVarM = this.f34705c;
        if (dVarM == null) {
            kotlin.coroutines.e eVar = (kotlin.coroutines.e) d().get(kotlin.coroutines.e.f34677q0);
            if (eVar == null || (dVarM = eVar.m(this)) == null) {
                dVarM = this;
            }
            this.f34705c = dVarM;
        }
        return dVarM;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        kotlin.coroutines.g gVar = this.f34704b;
        l0.m(gVar);
        return gVar;
    }

    public d(@a7.e kotlin.coroutines.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.d() : null);
    }
}
