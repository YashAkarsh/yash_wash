package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, k0> f8343a = new HashMap<>();

    public final void a() {
        Iterator<k0> it = this.f8343a.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f8343a.clear();
    }

    final k0 b(String str) {
        return this.f8343a.get(str);
    }

    Set<String> c() {
        return new HashSet(this.f8343a.keySet());
    }

    final void d(String str, k0 k0Var) {
        k0 k0VarPut = this.f8343a.put(str, k0Var);
        if (k0VarPut != null) {
            k0VarPut.e();
        }
    }
}
