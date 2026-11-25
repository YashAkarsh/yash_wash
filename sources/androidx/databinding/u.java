package androidx.databinding;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class u<K, V> extends androidx.collection.a<K, V> implements x<K, V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient r f7306n;

    private void u(Object obj) {
        r rVar = this.f7306n;
        if (rVar != null) {
            rVar.m(this, 0, obj);
        }
    }

    @Override // androidx.databinding.x
    public void U(x.a<? extends x<K, V>, K, V> aVar) {
        if (this.f7306n == null) {
            this.f7306n = new r();
        }
        this.f7306n.a(aVar);
    }

    @Override // androidx.databinding.x
    public void V(x.a<? extends x<K, V>, K, V> aVar) {
        r rVar = this.f7306n;
        if (rVar != null) {
            rVar.r(aVar);
        }
    }

    @Override // androidx.collection.i, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        u(null);
    }

    @Override // androidx.collection.i
    public V m(int i7) {
        K k7 = k(i7);
        V v7 = (V) super.m(i7);
        if (v7 != null) {
            u(k7);
        }
        return v7;
    }

    @Override // androidx.collection.i
    public V n(int i7, V v7) {
        K k7 = k(i7);
        V v8 = (V) super.n(i7, v7);
        u(k7);
        return v8;
    }

    @Override // androidx.collection.i, java.util.Map
    public V put(K k7, V v7) {
        super.put(k7, v7);
        u(k7);
        return v7;
    }

    @Override // androidx.collection.a
    public boolean s(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            int iF = f(it.next());
            if (iF >= 0) {
                m(iF);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // androidx.collection.a
    public boolean t(Collection<?> collection) {
        boolean z7 = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(k(size))) {
                m(size);
                z7 = true;
            }
        }
        return z7;
    }
}
