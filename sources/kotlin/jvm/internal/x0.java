package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class x0 extends w0 {
    public x0(kotlin.reflect.h hVar, String str, String str2) {
        super(q.f34893g, ((t) hVar).s(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.l
    public void U(Object obj, Object obj2) {
        c().o0(obj, obj2);
    }

    @Override // kotlin.reflect.q
    public Object get(Object obj) {
        return a().o0(obj);
    }

    @kotlin.g1(version = "1.4")
    public x0(Class cls, String str, String str2, int i7) {
        super(q.f34893g, cls, str, str2, i7);
    }

    @kotlin.g1(version = "1.4")
    public x0(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, i7);
    }
}
