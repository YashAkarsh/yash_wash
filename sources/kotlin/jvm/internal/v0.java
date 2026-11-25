package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class v0 extends u0 {
    public v0(kotlin.reflect.h hVar, String str, String str2) {
        super(q.f34893g, ((t) hVar).s(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.p
    public Object get() {
        return a().o0(new Object[0]);
    }

    @Override // kotlin.reflect.k
    public void set(Object obj) {
        c().o0(obj);
    }

    @kotlin.g1(version = "1.4")
    public v0(Class cls, String str, String str2, int i7) {
        super(q.f34893g, cls, str, str2, i7);
    }

    @kotlin.g1(version = "1.4")
    public v0(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, i7);
    }
}
