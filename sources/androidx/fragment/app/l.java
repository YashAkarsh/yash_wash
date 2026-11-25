package androidx.fragment.app;

import androidx.lifecycle.p0;
import c.o0;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final Collection<Fragment> f8014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final Map<String, l> f8015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final Map<String, p0> f8016c;

    l(@o0 Collection<Fragment> collection, @o0 Map<String, l> map, @o0 Map<String, p0> map2) {
        this.f8014a = collection;
        this.f8015b = map;
        this.f8016c = map2;
    }

    @o0
    Map<String, l> a() {
        return this.f8015b;
    }

    @o0
    Collection<Fragment> b() {
        return this.f8014a;
    }

    @o0
    Map<String, p0> c() {
        return this.f8016c;
    }

    boolean d(Fragment fragment) {
        Collection<Fragment> collection = this.f8014a;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
