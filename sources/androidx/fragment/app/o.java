package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class o extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8026j = "FragmentPagerAdapter";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f8027k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f8028l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8029m = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FragmentManager f8030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v f8032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Fragment f8033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8034i;

    @Deprecated
    public o(@m0 FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String x(int i7, long j7) {
        return "android:switcher:" + i7 + ":" + j7;
    }

    @Override // androidx.viewpager.widget.a
    public void b(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f8032g == null) {
            this.f8032g = this.f8030e.r();
        }
        this.f8032g.w(fragment);
        if (fragment.equals(this.f8033h)) {
            this.f8033h = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void d(@m0 ViewGroup viewGroup) {
        v vVar = this.f8032g;
        if (vVar != null) {
            if (!this.f8034i) {
                try {
                    this.f8034i = true;
                    vVar.u();
                    this.f8034i = false;
                } catch (Throwable th) {
                    this.f8034i = false;
                    throw th;
                }
            }
            this.f8032g = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    @m0
    public Object j(@m0 ViewGroup viewGroup, int i7) {
        if (this.f8032g == null) {
            this.f8032g = this.f8030e.r();
        }
        long jW = w(i7);
        Fragment fragmentQ0 = this.f8030e.q0(x(viewGroup.getId(), jW));
        if (fragmentQ0 != null) {
            this.f8032g.q(fragmentQ0);
        } else {
            fragmentQ0 = v(i7);
            this.f8032g.h(viewGroup.getId(), fragmentQ0, x(viewGroup.getId(), jW));
        }
        if (fragmentQ0 != this.f8033h) {
            fragmentQ0.setMenuVisibility(false);
            if (this.f8031f == 1) {
                this.f8032g.P(fragmentQ0, androidx.lifecycle.m.c.STARTED);
            } else {
                fragmentQ0.setUserVisibleHint(false);
            }
        }
        return fragmentQ0;
    }

    @Override // androidx.viewpager.widget.a
    public boolean k(@m0 View view, @m0 Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void n(@o0 Parcelable parcelable, @o0 ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    @o0
    public Parcelable o() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void q(@m0 ViewGroup viewGroup, int i7, @m0 Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f8033h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f8031f == 1) {
                    if (this.f8032g == null) {
                        this.f8032g = this.f8030e.r();
                    }
                    this.f8032g.P(this.f8033h, androidx.lifecycle.m.c.STARTED);
                } else {
                    this.f8033h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f8031f == 1) {
                if (this.f8032g == null) {
                    this.f8032g = this.f8030e.r();
                }
                this.f8032g.P(fragment, androidx.lifecycle.m.c.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f8033h = fragment;
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

    public long w(int i7) {
        return i7;
    }

    public o(@m0 FragmentManager fragmentManager, int i7) {
        this.f8032g = null;
        this.f8033h = null;
        this.f8030e = fragmentManager;
        this.f8031f = i7;
    }
}
