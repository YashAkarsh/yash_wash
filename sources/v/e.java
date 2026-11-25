package v;

import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // v.a
    @a7.e
    public <T> T a(@a7.d a.b<T> key) {
        l0.p(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(@a7.d a.b<T> key, T t7) {
        l0.p(key, "key");
        b().put(key, t7);
    }

    public e(@a7.d a initialExtras) {
        l0.p(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ e(a aVar, int i7, w wVar) {
        this((i7 & 1) != 0 ? a.C0550a.f40425b : aVar);
    }
}
