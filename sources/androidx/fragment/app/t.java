package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class t extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f8049l = "FragmentStatePagerAdapt";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final boolean f8050m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final int f8051n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8052o = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FragmentManager f8053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v f8055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f8056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<Fragment> f8057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Fragment f8058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8059k;

    @Deprecated
    public t(@m0 FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void b(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f8055g == null) {
            this.f8055g = this.f8053e.r();
        }
        while (this.f8056h.size() <= i7) {
            this.f8056h.add(null);
        }
        this.f8056h.set(i7, fragment.isAdded() ? this.f8053e.I1(fragment) : null);
        this.f8057i.set(i7, null);
        this.f8055g.C(fragment);
        if (fragment.equals(this.f8058j)) {
            this.f8058j = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void d(@m0 ViewGroup viewGroup) {
        v vVar = this.f8055g;
        if (vVar != null) {
            if (!this.f8059k) {
                try {
                    this.f8059k = true;
                    vVar.u();
                    this.f8059k = false;
                } catch (Throwable th) {
                    this.f8059k = false;
                    throw th;
                }
            }
            this.f8055g = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    @m0
    public Object j(@m0 ViewGroup viewGroup, int i7) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f8057i.size() > i7 && (fragment = this.f8057i.get(i7)) != null) {
            return fragment;
        }
        if (this.f8055g == null) {
            this.f8055g = this.f8053e.r();
        }
        Fragment fragmentV = v(i7);
        if (this.f8056h.size() > i7 && (savedState = this.f8056h.get(i7)) != null) {
            fragmentV.setInitialSavedState(savedState);
        }
        while (this.f8057i.size() <= i7) {
            this.f8057i.add(null);
        }
        fragmentV.setMenuVisibility(false);
        if (this.f8054f == 0) {
            fragmentV.setUserVisibleHint(false);
        }
        this.f8057i.set(i7, fragmentV);
        this.f8055g.g(viewGroup.getId(), fragmentV);
        if (this.f8054f == 1) {
            this.f8055g.P(fragmentV, androidx.lifecycle.m.c.STARTED);
        }
        return fragmentV;
    }

    @Override // androidx.viewpager.widget.a
    public boolean k(@m0 View view, @m0 Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void n(@o0 Parcelable parcelable, @o0 ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f8056h.clear();
            this.f8057i.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f8056h.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i7 = Integer.parseInt(str.substring(1));
                    Fragment fragmentC0 = this.f8053e.C0(bundle, str);
                    if (fragmentC0 != null) {
                        while (this.f8057i.size() <= i7) {
                            this.f8057i.add(null);
                        }
                        fragmentC0.setMenuVisibility(false);
                        this.f8057i.set(i7, fragmentC0);
                    } else {
                        Log.w(f8049l, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    @o0
    public Parcelable o() {
        Bundle bundle;
        if (this.f8056h.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f8056h.size()];
            this.f8056h.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i7 = 0; i7 < this.f8057i.size(); i7++) {
            Fragment fragment = this.f8057i.get(i7);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f8053e.u1(bundle, "f" + i7, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void q(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f8058j;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f8054f == 1) {
                    if (this.f8055g == null) {
                        this.f8055g = this.f8053e.r();
                    }
                    this.f8055g.P(this.f8058j, androidx.lifecycle.m.c.STARTED);
                } else {
                    this.f8058j.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f8054f == 1) {
                if (this.f8055g == null) {
                    this.f8055g = this.f8053e.r();
                }
                this.f8055g.P(fragment, androidx.lifecycle.m.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f8058j = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void t(@m0 ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @m0
    public abstract Fragment v(int i7);

    public t(@m0 FragmentManager fragmentManager, int i7) {
        this.f8055g = null;
        this.f8056h = new ArrayList<>();
        this.f8057i = new ArrayList<>();
        this.f8058j = null;
        this.f8053e = fragmentManager;
        this.f8054f = i7;
    }
}
