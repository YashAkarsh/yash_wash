package androidx.navigation;

import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.p0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class h extends k0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final m0.b f8846e = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<UUID, p0> f8847d = new HashMap<>();

    class a implements m0.b {
        a() {
        }

        @Override // androidx.lifecycle.m0.b
        @c.m0
        public <T extends k0> T a(@c.m0 Class<T> cls) {
            return new h();
        }

        @Override // androidx.lifecycle.m0.b
        public /* synthetic */ k0 b(Class cls, v.a aVar) {
            return n0.b(this, cls, aVar);
        }
    }

    h() {
    }

    @c.m0
    static h h(p0 p0Var) {
        return (h) new m0(p0Var, f8846e).a(h.class);
    }

    @Override // androidx.lifecycle.k0
    protected void e() {
        Iterator<p0> it = this.f8847d.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f8847d.clear();
    }

    void g(@c.m0 UUID uuid) {
        p0 p0VarRemove = this.f8847d.remove(uuid);
        if (p0VarRemove != null) {
            p0VarRemove.a();
        }
    }

    @c.m0
    p0 i(@c.m0 UUID uuid) {
        p0 p0Var = this.f8847d.get(uuid);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0();
        this.f8847d.put(uuid, p0Var2);
        return p0Var2;
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.f8847d.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
