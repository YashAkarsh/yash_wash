package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7147d = "MergedDataBinderMapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<Class<? extends j>> f7148a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<j> f7149b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f7150c = new CopyOnWriteArrayList();

    private boolean h() {
        boolean z7 = false;
        for (String str : this.f7150c) {
            try {
                Class<?> cls = Class.forName(str);
                if (j.class.isAssignableFrom(cls)) {
                    f((j) cls.newInstance());
                    this.f7150c.remove(str);
                    z7 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e8) {
                Log.e(f7147d, "unable to add feature mapper for " + str, e8);
            } catch (InstantiationException e9) {
                Log.e(f7147d, "unable to add feature mapper for " + str, e9);
            }
        }
        return z7;
    }

    @Override // androidx.databinding.j
    public String b(int i7) {
        Iterator<j> it = this.f7149b.iterator();
        while (it.hasNext()) {
            String strB = it.next().b(i7);
            if (strB != null) {
                return strB;
            }
        }
        if (h()) {
            return b(i7);
        }
        return null;
    }

    @Override // androidx.databinding.j
    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i7) {
        Iterator<j> it = this.f7149b.iterator();
        while (it.hasNext()) {
            ViewDataBinding viewDataBindingC = it.next().c(dataBindingComponent, view, i7);
            if (viewDataBindingC != null) {
                return viewDataBindingC;
            }
        }
        if (h()) {
            return c(dataBindingComponent, view, i7);
        }
        return null;
    }

    @Override // androidx.databinding.j
    public ViewDataBinding d(DataBindingComponent dataBindingComponent, View[] viewArr, int i7) {
        Iterator<j> it = this.f7149b.iterator();
        while (it.hasNext()) {
            ViewDataBinding viewDataBindingD = it.next().d(dataBindingComponent, viewArr, i7);
            if (viewDataBindingD != null) {
                return viewDataBindingD;
            }
        }
        if (h()) {
            return d(dataBindingComponent, viewArr, i7);
        }
        return null;
    }

    @Override // androidx.databinding.j
    public int e(String str) {
        Iterator<j> it = this.f7149b.iterator();
        while (it.hasNext()) {
            int iE = it.next().e(str);
            if (iE != 0) {
                return iE;
            }
        }
        if (h()) {
            return e(str);
        }
        return 0;
    }

    public void f(j jVar) {
        if (this.f7148a.add((Class<? extends j>) jVar.getClass())) {
            this.f7149b.add(jVar);
            Iterator<j> it = jVar.a().iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
    }

    protected void g(String str) {
        this.f7150c.add(str + ".DataBinderMapperImpl");
    }
}
