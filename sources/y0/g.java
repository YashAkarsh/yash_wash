package y0;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.util.h f40581b = new com.bumptech.glide.util.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.util.h, f<?, ?>> f40582a = new HashMap();

    public <Z, R> f<Z, R> a(Class<Z> cls, Class<R> cls2) {
        f<Z, R> fVar;
        if (cls.equals(cls2)) {
            return h.c();
        }
        com.bumptech.glide.util.h hVar = f40581b;
        synchronized (hVar) {
            hVar.a(cls, cls2);
            fVar = (f) this.f40582a.get(hVar);
        }
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void b(Class<Z> cls, Class<R> cls2, f<Z, R> fVar) {
        this.f40582a.put(new com.bumptech.glide.util.h(cls, cls2), fVar);
    }
}
