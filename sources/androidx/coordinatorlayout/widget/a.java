package androidx.coordinatorlayout.widget;

import androidx.collection.i;
import androidx.core.util.v;
import c.m0;
import c.o0;
import c.x0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v.a<ArrayList<T>> f5026a = new v.b(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<T, ArrayList<T>> f5027b = new i<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f5028c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<T> f5029d = new HashSet<>();

    private void e(T t7, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t7)) {
            return;
        }
        if (hashSet.contains(t7)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t7);
        ArrayList<T> arrayList2 = this.f5027b.get(t7);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                e(arrayList2.get(i7), arrayList, hashSet);
            }
        }
        hashSet.remove(t7);
        arrayList.add(t7);
    }

    @m0
    private ArrayList<T> f() {
        ArrayList<T> arrayListB = this.f5026a.b();
        return arrayListB == null ? new ArrayList<>() : arrayListB;
    }

    private void k(@m0 ArrayList<T> arrayList) {
        arrayList.clear();
        this.f5026a.a(arrayList);
    }

    public void a(@m0 T t7, @m0 T t8) {
        if (!this.f5027b.containsKey(t7) || !this.f5027b.containsKey(t8)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f5027b.get(t7);
        if (arrayListF == null) {
            arrayListF = f();
            this.f5027b.put(t7, arrayListF);
        }
        arrayListF.add(t8);
    }

    public void b(@m0 T t7) {
        if (this.f5027b.containsKey(t7)) {
            return;
        }
        this.f5027b.put(t7, null);
    }

    public void c() {
        int size = this.f5027b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList<T> arrayListO = this.f5027b.o(i7);
            if (arrayListO != null) {
                k(arrayListO);
            }
        }
        this.f5027b.clear();
    }

    public boolean d(@m0 T t7) {
        return this.f5027b.containsKey(t7);
    }

    @o0
    public List g(@m0 T t7) {
        return this.f5027b.get(t7);
    }

    @o0
    public List<T> h(@m0 T t7) {
        int size = this.f5027b.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList<T> arrayListO = this.f5027b.o(i7);
            if (arrayListO != null && arrayListO.contains(t7)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f5027b.k(i7));
            }
        }
        return arrayList;
    }

    @m0
    public ArrayList<T> i() {
        this.f5028c.clear();
        this.f5029d.clear();
        int size = this.f5027b.size();
        for (int i7 = 0; i7 < size; i7++) {
            e(this.f5027b.k(i7), this.f5028c, this.f5029d);
        }
        return this.f5028c;
    }

    public boolean j(@m0 T t7) {
        int size = this.f5027b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList<T> arrayListO = this.f5027b.o(i7);
            if (arrayListO != null && arrayListO.contains(t7)) {
                return true;
            }
        }
        return false;
    }

    int l() {
        return this.f5027b.size();
    }
}
