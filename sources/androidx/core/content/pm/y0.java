package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public abstract class y0<T> {

    @c.x0({c.x0.a.LIBRARY})
    public static class a extends y0<Void> {
        @Override // androidx.core.content.pm.y0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void a(List<x0> list) {
            return null;
        }

        @Override // androidx.core.content.pm.y0
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void c() {
            return null;
        }

        @Override // androidx.core.content.pm.y0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Void d(List<String> list) {
            return null;
        }
    }

    @c.d
    public abstract T a(List<x0> list);

    @c.h1
    public List<x0> b() throws Exception {
        return new ArrayList();
    }

    @c.d
    public abstract T c();

    @c.d
    public abstract T d(List<String> list);
}
