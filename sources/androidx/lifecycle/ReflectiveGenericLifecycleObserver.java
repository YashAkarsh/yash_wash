package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.a f8240b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f8239a = obj;
        this.f8240b = c.f8253c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.o
    public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
        this.f8240b.a(qVar, bVar, this.f8239a);
    }
}
