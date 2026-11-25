package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8060d = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Fragment> f8061a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, r> f8062b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m f8063c;

    u() {
    }

    void a(@m0 Fragment fragment) {
        if (this.f8061a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f8061a) {
            this.f8061a.add(fragment);
        }
        fragment.mAdded = true;
    }

    void b() {
        this.f8062b.values().removeAll(Collections.singleton(null));
    }

    boolean c(@m0 String str) {
        return this.f8062b.get(str) != null;
    }

    void d(int i7) {
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                rVar.u(i7);
            }
        }
    }

    void e(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
        String str2 = str + "    ";
        if (!this.f8062b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (r rVar : this.f8062b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment fragmentK = rVar.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f8061a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i7 = 0; i7 < size; i7++) {
                Fragment fragment = this.f8061a.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    @o0
    Fragment f(@m0 String str) {
        r rVar = this.f8062b.get(str);
        if (rVar != null) {
            return rVar.k();
        }
        return null;
    }

    @o0
    Fragment g(@c.b0 int i7) {
        for (int size = this.f8061a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f8061a.get(size);
            if (fragment != null && fragment.mFragmentId == i7) {
                return fragment;
            }
        }
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (fragmentK.mFragmentId == i7) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @o0
    Fragment h(@o0 String str) {
        if (str != null) {
            for (int size = this.f8061a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f8061a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @o0
    Fragment i(@m0 String str) {
        Fragment fragmentFindFragmentByWho;
        for (r rVar : this.f8062b.values()) {
            if (rVar != null && (fragmentFindFragmentByWho = rVar.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    int j(@m0 Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f8061a.indexOf(fragment);
        for (int i7 = iIndexOf - 1; i7 >= 0; i7--) {
            Fragment fragment2 = this.f8061a.get(i7);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f8061a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f8061a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    int k() {
        return this.f8062b.size();
    }

    @m0
    List<r> l() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                arrayList.add(rVar);
            }
        }
        return arrayList;
    }

    @m0
    List<Fragment> m() {
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                arrayList.add(rVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @o0
    r n(@m0 String str) {
        return this.f8062b.get(str);
    }

    @m0
    List<Fragment> o() {
        ArrayList arrayList;
        if (this.f8061a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f8061a) {
            arrayList = new ArrayList(this.f8061a);
        }
        return arrayList;
    }

    m p() {
        return this.f8063c;
    }

    void q(@m0 r rVar) {
        Fragment fragmentK = rVar.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f8062b.put(fragmentK.mWho, rVar);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f8063c.g(fragmentK);
            } else {
                this.f8063c.p(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.T0(2)) {
            Log.v(f8060d, "Added fragment to active set " + fragmentK);
        }
    }

    void r(@m0 r rVar) {
        Fragment fragmentK = rVar.k();
        if (fragmentK.mRetainInstance) {
            this.f8063c.p(fragmentK);
        }
        if (this.f8062b.put(fragmentK.mWho, null) != null && FragmentManager.T0(2)) {
            Log.v(f8060d, "Removed fragment from active set " + fragmentK);
        }
    }

    void s() {
        Iterator<Fragment> it = this.f8061a.iterator();
        while (it.hasNext()) {
            r rVar = this.f8062b.get(it.next().mWho);
            if (rVar != null) {
                rVar.m();
            }
        }
        for (r rVar2 : this.f8062b.values()) {
            if (rVar2 != null) {
                rVar2.m();
                Fragment fragmentK = rVar2.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    r(rVar2);
                }
            }
        }
    }

    void t(@m0 Fragment fragment) {
        synchronized (this.f8061a) {
            this.f8061a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    void u() {
        this.f8062b.clear();
    }

    void v(@o0 List<String> list) {
        this.f8061a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.T0(2)) {
                    Log.v(f8060d, "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    @m0
    ArrayList<FragmentState> w() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f8062b.size());
        for (r rVar : this.f8062b.values()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                FragmentState fragmentStateS = rVar.s();
                arrayList.add(fragmentStateS);
                if (FragmentManager.T0(2)) {
                    Log.v(f8060d, "Saved state of " + fragmentK + ": " + fragmentStateS.f7871m);
                }
            }
        }
        return arrayList;
    }

    @o0
    ArrayList<String> x() {
        synchronized (this.f8061a) {
            if (this.f8061a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f8061a.size());
            for (Fragment fragment : this.f8061a) {
                arrayList.add(fragment.mWho);
                if (FragmentManager.T0(2)) {
                    Log.v(f8060d, "saveAllState: adding fragment (" + fragment.mWho + "): " + fragment);
                }
            }
            return arrayList;
        }
    }

    void y(@m0 m mVar) {
        this.f8063c = mVar;
    }
}
