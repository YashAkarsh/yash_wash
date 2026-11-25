package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.p0;
import c.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class m extends k0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f8017k = "FragmentManager";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final m0.b f8018l = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f8022g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Fragment> f8019d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, m> f8020e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, p0> f8021f = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8023h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8024i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f8025j = false;

    class a implements m0.b {
        a() {
        }

        @Override // androidx.lifecycle.m0.b
        @c.m0
        public <T extends k0> T a(@c.m0 Class<T> cls) {
            return new m(true);
        }

        @Override // androidx.lifecycle.m0.b
        public /* synthetic */ k0 b(Class cls, v.a aVar) {
            return n0.b(this, cls, aVar);
        }
    }

    m(boolean z7) {
        this.f8022g = z7;
    }

    @c.m0
    static m k(p0 p0Var) {
        return (m) new m0(p0Var, f8018l).a(m.class);
    }

    @Override // androidx.lifecycle.k0
    protected void e() {
        if (FragmentManager.T0(3)) {
            Log.d(f8017k, "onCleared called for " + this);
        }
        this.f8023h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f8019d.equals(mVar.f8019d) && this.f8020e.equals(mVar.f8020e) && this.f8021f.equals(mVar.f8021f);
    }

    void g(@c.m0 Fragment fragment) {
        if (this.f8025j) {
            if (FragmentManager.T0(2)) {
                Log.v(f8017k, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f8019d.containsKey(fragment.mWho)) {
                return;
            }
            this.f8019d.put(fragment.mWho, fragment);
            if (FragmentManager.T0(2)) {
                Log.v(f8017k, "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void h(@c.m0 Fragment fragment) {
        if (FragmentManager.T0(3)) {
            Log.d(f8017k, "Clearing non-config state for " + fragment);
        }
        m mVar = this.f8020e.get(fragment.mWho);
        if (mVar != null) {
            mVar.e();
            this.f8020e.remove(fragment.mWho);
        }
        p0 p0Var = this.f8021f.get(fragment.mWho);
        if (p0Var != null) {
            p0Var.a();
            this.f8021f.remove(fragment.mWho);
        }
    }

    public int hashCode() {
        return (((this.f8019d.hashCode() * 31) + this.f8020e.hashCode()) * 31) + this.f8021f.hashCode();
    }

    @o0
    Fragment i(String str) {
        return this.f8019d.get(str);
    }

    @c.m0
    m j(@c.m0 Fragment fragment) {
        m mVar = this.f8020e.get(fragment.mWho);
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this.f8022g);
        this.f8020e.put(fragment.mWho, mVar2);
        return mVar2;
    }

    @c.m0
    Collection<Fragment> l() {
        return new ArrayList(this.f8019d.values());
    }

    @o0
    @Deprecated
    l m() {
        if (this.f8019d.isEmpty() && this.f8020e.isEmpty() && this.f8021f.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, m> entry : this.f8020e.entrySet()) {
            l lVarM = entry.getValue().m();
            if (lVarM != null) {
                map.put(entry.getKey(), lVarM);
            }
        }
        this.f8024i = true;
        if (this.f8019d.isEmpty() && map.isEmpty() && this.f8021f.isEmpty()) {
            return null;
        }
        return new l(new ArrayList(this.f8019d.values()), map, new HashMap(this.f8021f));
    }

    @c.m0
    p0 n(@c.m0 Fragment fragment) {
        p0 p0Var = this.f8021f.get(fragment.mWho);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0();
        this.f8021f.put(fragment.mWho, p0Var2);
        return p0Var2;
    }

    boolean o() {
        return this.f8023h;
    }

    void p(@c.m0 Fragment fragment) {
        if (this.f8025j) {
            if (FragmentManager.T0(2)) {
                Log.v(f8017k, "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f8019d.remove(fragment.mWho) != null) && FragmentManager.T0(2)) {
            Log.v(f8017k, "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Deprecated
    void q(@o0 l lVar) {
        this.f8019d.clear();
        this.f8020e.clear();
        this.f8021f.clear();
        if (lVar != null) {
            Collection<Fragment> collectionB = lVar.b();
            if (collectionB != null) {
                for (Fragment fragment : collectionB) {
                    if (fragment != null) {
                        this.f8019d.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, l> mapA = lVar.a();
            if (mapA != null) {
                for (Map.Entry<String, l> entry : mapA.entrySet()) {
                    m mVar = new m(this.f8022g);
                    mVar.q(entry.getValue());
                    this.f8020e.put(entry.getKey(), mVar);
                }
            }
            Map<String, p0> mapC = lVar.c();
            if (mapC != null) {
                this.f8021f.putAll(mapC);
            }
        }
        this.f8024i = false;
    }

    void r(boolean z7) {
        this.f8025j = z7;
    }

    boolean s(@c.m0 Fragment fragment) {
        if (this.f8019d.containsKey(fragment.mWho)) {
            return this.f8022g ? this.f8023h : !this.f8024i;
        }
        return true;
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f8019d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f8020e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f8021f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
