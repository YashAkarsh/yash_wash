package androidx.fragment.app;

import android.util.Log;
import c.m0;
import c.o0;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class a extends v implements FragmentManager.k, FragmentManager.p {
    private static final String O = "FragmentManager";
    final FragmentManager L;
    boolean M;
    int N;

    a(@m0 FragmentManager fragmentManager) {
        super(fragmentManager.E0(), fragmentManager.H0() != null ? fragmentManager.H0().f().getClassLoader() : null);
        this.N = -1;
        this.L = fragmentManager;
    }

    private static boolean e0(v.a aVar) {
        Fragment fragment = aVar.f8092b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.v
    public boolean B() {
        return this.f8074c.isEmpty();
    }

    @Override // androidx.fragment.app.v
    @m0
    public v C(@m0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.L) {
            return super.C(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.v
    @m0
    public v P(@m0 Fragment fragment, @m0 androidx.lifecycle.m.c cVar) {
        if (fragment.mFragmentManager != this.L) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.L);
        }
        if (cVar == androidx.lifecycle.m.c.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + " after the Fragment has been created");
        }
        if (cVar != androidx.lifecycle.m.c.DESTROYED) {
            return super.P(fragment, cVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + cVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.v
    @m0
    public v Q(@o0 Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.L) {
            return super.Q(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.v
    @m0
    public v U(@m0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.L) {
            return super.U(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void V(int i7) {
        if (this.f8080i) {
            if (FragmentManager.T0(2)) {
                Log.v(O, "Bump nesting in " + this + " by " + i7);
            }
            int size = this.f8074c.size();
            for (int i8 = 0; i8 < size; i8++) {
                v.a aVar = this.f8074c.get(i8);
                Fragment fragment = aVar.f8092b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i7;
                    if (FragmentManager.T0(2)) {
                        Log.v(O, "Bump nesting of " + aVar.f8092b + " to " + aVar.f8092b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int W(boolean z7) {
        if (this.M) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.T0(2)) {
            Log.v(O, "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new b0(O));
            X("  ", printWriter);
            printWriter.close();
        }
        this.M = true;
        if (this.f8080i) {
            this.N = this.L.o();
        } else {
            this.N = -1;
        }
        this.L.f0(this, z7);
        return this.N;
    }

    public void X(String str, PrintWriter printWriter) {
        Y(str, printWriter, true);
    }

    public void Y(String str, PrintWriter printWriter, boolean z7) {
        String str2;
        if (z7) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f8082k);
            printWriter.print(" mIndex=");
            printWriter.print(this.N);
            printWriter.print(" mCommitted=");
            printWriter.println(this.M);
            if (this.f8079h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f8079h));
            }
            if (this.f8075d != 0 || this.f8076e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8075d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8076e));
            }
            if (this.f8077f != 0 || this.f8078g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8077f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8078g));
            }
            if (this.f8083l != 0 || this.f8084m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8083l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f8084m);
            }
            if (this.f8085n != 0 || this.f8086o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8085n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f8086o);
            }
        }
        if (this.f8074c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f8074c.size();
        for (int i7 = 0; i7 < size; i7++) {
            v.a aVar = this.f8074c.get(i7);
            switch (aVar.f8091a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f8091a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i7);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f8092b);
            if (z7) {
                if (aVar.f8093c != 0 || aVar.f8094d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f8093c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f8094d));
                }
                if (aVar.f8095e != 0 || aVar.f8096f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f8095e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f8096f));
                }
            }
        }
    }

    void Z() {
        int size = this.f8074c.size();
        for (int i7 = 0; i7 < size; i7++) {
            v.a aVar = this.f8074c.get(i7);
            Fragment fragment = aVar.f8092b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f8079h);
                fragment.setSharedElementNames(this.f8087p, this.f8088q);
            }
            switch (aVar.f8091a) {
                case 1:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, false);
                    this.L.k(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f8091a);
                case 3:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.x1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.Q0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, false);
                    this.L.Q1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.C(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, false);
                    this.L.q(fragment);
                    break;
                case 8:
                    this.L.N1(fragment);
                    break;
                case 9:
                    this.L.N1(null);
                    break;
                case 10:
                    this.L.M1(fragment, aVar.f8098h);
                    break;
            }
            if (!this.f8089r && aVar.f8091a != 1 && fragment != null && !FragmentManager.Q) {
                this.L.d1(fragment);
            }
        }
        if (this.f8089r || FragmentManager.Q) {
            return;
        }
        FragmentManager fragmentManager = this.L;
        fragmentManager.e1(fragmentManager.f7811q, true);
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public int a() {
        return this.N;
    }

    void a0(boolean z7) {
        for (int size = this.f8074c.size() - 1; size >= 0; size--) {
            v.a aVar = this.f8074c.get(size);
            Fragment fragment = aVar.f8092b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.G1(this.f8079h));
                fragment.setSharedElementNames(this.f8088q, this.f8087p);
            }
            switch (aVar.f8091a) {
                case 1:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, true);
                    this.L.x1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f8091a);
                case 3:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.k(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.Q1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, true);
                    this.L.Q0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.q(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f8093c, aVar.f8094d, aVar.f8095e, aVar.f8096f);
                    this.L.K1(fragment, true);
                    this.L.C(fragment);
                    break;
                case 8:
                    this.L.N1(null);
                    break;
                case 9:
                    this.L.N1(fragment);
                    break;
                case 10:
                    this.L.M1(fragment, aVar.f8097g);
                    break;
            }
            if (!this.f8089r && aVar.f8091a != 3 && fragment != null && !FragmentManager.Q) {
                this.L.d1(fragment);
            }
        }
        if (this.f8089r || !z7 || FragmentManager.Q) {
            return;
        }
        FragmentManager fragmentManager = this.L;
        fragmentManager.e1(fragmentManager.f7811q, true);
    }

    @Override // androidx.fragment.app.FragmentManager.k
    @o0
    public CharSequence b() {
        return this.f8083l != 0 ? this.L.H0().f().getText(this.f8083l) : this.f8084m;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    Fragment b0(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i7 = 0;
        while (i7 < this.f8074c.size()) {
            v.a aVar = this.f8074c.get(i7);
            int i8 = aVar.f8091a;
            if (i8 == 1) {
                arrayList.add(aVar.f8092b);
            } else if (i8 == 2) {
                Fragment fragment3 = aVar.f8092b;
                int i9 = fragment3.mContainerId;
                boolean z7 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.mContainerId == i9) {
                        if (fragment4 == fragment3) {
                            z7 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f8074c.add(i7, new v.a(9, fragment4));
                                i7++;
                                fragment2 = null;
                            }
                            v.a aVar2 = new v.a(3, fragment4);
                            aVar2.f8093c = aVar.f8093c;
                            aVar2.f8095e = aVar.f8095e;
                            aVar2.f8094d = aVar.f8094d;
                            aVar2.f8096f = aVar.f8096f;
                            this.f8074c.add(i7, aVar2);
                            arrayList.remove(fragment4);
                            i7++;
                        }
                    }
                }
                if (z7) {
                    this.f8074c.remove(i7);
                    i7--;
                } else {
                    aVar.f8091a = 1;
                    arrayList.add(fragment3);
                }
            } else if (i8 == 3 || i8 == 6) {
                arrayList.remove(aVar.f8092b);
                Fragment fragment5 = aVar.f8092b;
                if (fragment5 == fragment2) {
                    this.f8074c.add(i7, new v.a(9, fragment5));
                    i7++;
                    fragment2 = null;
                }
            } else if (i8 == 7) {
                arrayList.add(aVar.f8092b);
            } else if (i8 == 8) {
                this.f8074c.add(i7, new v.a(9, fragment2));
                i7++;
                fragment2 = aVar.f8092b;
            }
            i7++;
        }
        return fragment2;
    }

    @Override // androidx.fragment.app.FragmentManager.p
    public boolean c(@m0 ArrayList<a> arrayList, @m0 ArrayList<Boolean> arrayList2) {
        if (FragmentManager.T0(2)) {
            Log.v(O, "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f8080i) {
            return true;
        }
        this.L.i(this);
        return true;
    }

    boolean c0(int i7) {
        int size = this.f8074c.size();
        for (int i8 = 0; i8 < size; i8++) {
            Fragment fragment = this.f8074c.get(i8).f8092b;
            int i9 = fragment != null ? fragment.mContainerId : 0;
            if (i9 != 0 && i9 == i7) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public int d() {
        return this.f8085n;
    }

    boolean d0(ArrayList<a> arrayList, int i7, int i8) {
        if (i8 == i7) {
            return false;
        }
        int size = this.f8074c.size();
        int i9 = -1;
        for (int i10 = 0; i10 < size; i10++) {
            Fragment fragment = this.f8074c.get(i10).f8092b;
            int i11 = fragment != null ? fragment.mContainerId : 0;
            if (i11 != 0 && i11 != i9) {
                for (int i12 = i7; i12 < i8; i12++) {
                    a aVar = arrayList.get(i12);
                    int size2 = aVar.f8074c.size();
                    for (int i13 = 0; i13 < size2; i13++) {
                        Fragment fragment2 = aVar.f8074c.get(i13).f8092b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i11) {
                            return true;
                        }
                    }
                }
                i9 = i11;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    public int e() {
        return this.f8083l;
    }

    @Override // androidx.fragment.app.FragmentManager.k
    @o0
    public CharSequence f() {
        return this.f8085n != 0 ? this.L.H0().f().getText(this.f8085n) : this.f8086o;
    }

    boolean f0() {
        for (int i7 = 0; i7 < this.f8074c.size(); i7++) {
            if (e0(this.f8074c.get(i7))) {
                return true;
            }
        }
        return false;
    }

    public void g0() {
        if (this.f8090s != null) {
            for (int i7 = 0; i7 < this.f8090s.size(); i7++) {
                this.f8090s.get(i7).run();
            }
            this.f8090s = null;
        }
    }

    @Override // androidx.fragment.app.FragmentManager.k
    @o0
    public String getName() {
        return this.f8082k;
    }

    void h0(Fragment.l lVar) {
        for (int i7 = 0; i7 < this.f8074c.size(); i7++) {
            v.a aVar = this.f8074c.get(i7);
            if (e0(aVar)) {
                aVar.f8092b.setOnStartEnterTransitionListener(lVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    Fragment i0(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f8074c.size() - 1; size >= 0; size--) {
            v.a aVar = this.f8074c.get(size);
            int i7 = aVar.f8091a;
            if (i7 == 1) {
                arrayList.remove(aVar.f8092b);
            } else if (i7 != 3) {
                switch (i7) {
                    case 6:
                        arrayList.add(aVar.f8092b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f8092b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f8092b;
                        break;
                    case 10:
                        aVar.f8098h = aVar.f8097g;
                        break;
                }
            } else {
                arrayList.add(aVar.f8092b);
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.v
    public int r() {
        return W(false);
    }

    @Override // androidx.fragment.app.v
    public int s() {
        return W(true);
    }

    @Override // androidx.fragment.app.v
    public void t() {
        x();
        this.L.i0(this, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.N >= 0) {
            sb.append(" #");
            sb.append(this.N);
        }
        if (this.f8082k != null) {
            sb.append(" ");
            sb.append(this.f8082k);
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }

    @Override // androidx.fragment.app.v
    public void u() {
        x();
        this.L.i0(this, true);
    }

    @Override // androidx.fragment.app.v
    @m0
    public v w(@m0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.L) {
            return super.w(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.v
    void y(int i7, Fragment fragment, @o0 String str, int i8) {
        super.y(i7, fragment, str, i8);
        fragment.mFragmentManager = this.L;
    }

    @Override // androidx.fragment.app.v
    @m0
    public v z(@m0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.L) {
            return super.z(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }
}
