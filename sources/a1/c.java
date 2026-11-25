package a1;

import com.bumptech.glide.util.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f16b = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<h, b<?, ?>> f17a = new HashMap();

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        h hVar = f16b;
        synchronized (hVar) {
            hVar.a(cls, cls2);
            bVar = (b) this.f17a.get(hVar);
        }
        return bVar == null ? d.a() : bVar;
    }

    public <T, Z> void b(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.f17a.put(new h(cls, cls2), bVar);
    }
}
