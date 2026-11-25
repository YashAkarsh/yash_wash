package androidx.databinding;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class t<T> extends ArrayList<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient q f7305a = new q();

    private void a(int i7, int i8) {
        q qVar = this.f7305a;
        if (qVar != null) {
            qVar.y(this, i7, i8);
        }
    }

    private void b(int i7, int i8) {
        q qVar = this.f7305a;
        if (qVar != null) {
            qVar.A(this, i7, i8);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t7) {
        super.add(t7);
        a(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean zAddAll = super.addAll(collection);
        if (zAddAll) {
            a(size, size() - size);
        }
        return zAddAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            b(0, size);
        }
    }

    @Override // androidx.databinding.w
    public void q(w.a aVar) {
        q qVar = this.f7305a;
        if (qVar != null) {
            qVar.r(aVar);
        }
    }

    @Override // androidx.databinding.w
    public void r0(w.a aVar) {
        if (this.f7305a == null) {
            this.f7305a = new q();
        }
        this.f7305a.a(aVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int i7) {
        T t7 = (T) super.remove(i7);
        b(i7, 1);
        return t7;
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i7, int i8) {
        super.removeRange(i7, i8);
        b(i7, i8 - i7);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i7, T t7) {
        T t8 = (T) super.set(i7, t7);
        q qVar = this.f7305a;
        if (qVar != null) {
            qVar.x(this, i7, 1);
        }
        return t8;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i7, T t7) {
        super.add(i7, t7);
        a(i7, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i7, Collection<? extends T> collection) {
        boolean zAddAll = super.addAll(i7, collection);
        if (zAddAll) {
            a(i7, collection.size());
        }
        return zAddAll;
    }
}
