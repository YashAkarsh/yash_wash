package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4955c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseIntArray f4956a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Integer, HashSet<WeakReference<a>>> f4957b = new HashMap<>();

    public interface a {
        void a(int key, int newValue, int oldValue);
    }

    public void a(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.f4957b.get(Integer.valueOf(key));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f4957b.put(Integer.valueOf(key), hashSet);
        }
        hashSet.add(new WeakReference<>(listener));
    }

    public void b() {
        this.f4957b.clear();
    }

    public void c(int key, int value) {
        int i7 = this.f4956a.get(key, -1);
        if (i7 == value) {
            return;
        }
        this.f4956a.put(key, value);
        HashSet<WeakReference<a>> hashSet = this.f4957b.get(Integer.valueOf(key));
        if (hashSet == null) {
            return;
        }
        Iterator<WeakReference<a>> it = hashSet.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            a aVar = it.next().get();
            if (aVar != null) {
                aVar.a(key, value, i7);
            } else {
                z7 = true;
            }
        }
        if (z7) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<a> weakReference : hashSet) {
                if (weakReference.get() == null) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public int d(int key) {
        return this.f4956a.get(key, -1);
    }

    public void e(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.f4957b.get(Integer.valueOf(key));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference<a> weakReference : hashSet) {
            a aVar = weakReference.get();
            if (aVar == null || aVar == listener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void f(a listener) {
        Iterator<Integer> it = this.f4957b.keySet().iterator();
        while (it.hasNext()) {
            e(it.next().intValue(), listener);
        }
    }
}
