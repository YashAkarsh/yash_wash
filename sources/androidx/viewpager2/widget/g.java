package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.m0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class g extends RecyclerView.s {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f11228n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f11229o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f11230p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f11231q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f11232r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f11233s = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2.j f11234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final ViewPager2 f11235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final RecyclerView f11236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final LinearLayoutManager f11237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f11240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11242i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11244k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11245l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f11246m;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f11248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f11249c;

        a() {
        }

        void a() {
            this.f11247a = -1;
            this.f11248b = 0.0f;
            this.f11249c = 0;
        }
    }

    g(@m0 ViewPager2 viewPager2) {
        this.f11235b = viewPager2;
        RecyclerView recyclerView = viewPager2.f11182j;
        this.f11236c = recyclerView;
        this.f11237d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f11240g = new a();
        q();
    }

    private void c(int i7, float f8, int i8) {
        ViewPager2.j jVar = this.f11234a;
        if (jVar != null) {
            jVar.b(i7, f8, i8);
        }
    }

    private void d(int i7) {
        ViewPager2.j jVar = this.f11234a;
        if (jVar != null) {
            jVar.c(i7);
        }
    }

    private void e(int i7) {
        if ((this.f11238e == 3 && this.f11239f == 0) || this.f11239f == i7) {
            return;
        }
        this.f11239f = i7;
        ViewPager2.j jVar = this.f11234a;
        if (jVar != null) {
            jVar.a(i7);
        }
    }

    private int f() {
        return this.f11237d.y2();
    }

    private boolean l() {
        int i7 = this.f11238e;
        return i7 == 1 || i7 == 4;
    }

    private void q() {
        this.f11238e = 0;
        this.f11239f = 0;
        this.f11240g.a();
        this.f11241h = -1;
        this.f11242i = -1;
        this.f11243j = false;
        this.f11244k = false;
        this.f11246m = false;
        this.f11245l = false;
    }

    private void s(boolean z7) {
        this.f11246m = z7;
        this.f11238e = z7 ? 4 : 1;
        int i7 = this.f11242i;
        if (i7 != -1) {
            this.f11241h = i7;
            this.f11242i = -1;
        } else if (this.f11241h == -1) {
            this.f11241h = f();
        }
        e(1);
    }

    private void t() {
        int top;
        a aVar = this.f11240g;
        int iY2 = this.f11237d.y2();
        aVar.f11247a = iY2;
        if (iY2 == -1) {
            aVar.a();
            return;
        }
        View viewJ = this.f11237d.J(iY2);
        if (viewJ == null) {
            aVar.a();
            return;
        }
        int iJ0 = this.f11237d.j0(viewJ);
        int iU0 = this.f11237d.u0(viewJ);
        int iX0 = this.f11237d.x0(viewJ);
        int iO = this.f11237d.O(viewJ);
        ViewGroup.LayoutParams layoutParams = viewJ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iJ0 += marginLayoutParams.leftMargin;
            iU0 += marginLayoutParams.rightMargin;
            iX0 += marginLayoutParams.topMargin;
            iO += marginLayoutParams.bottomMargin;
        }
        int height = viewJ.getHeight() + iX0 + iO;
        int width = viewJ.getWidth() + iJ0 + iU0;
        if (this.f11237d.Q2() == 0) {
            top = (viewJ.getLeft() - iJ0) - this.f11236c.getPaddingLeft();
            if (this.f11235b.k()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewJ.getTop() - iX0) - this.f11236c.getPaddingTop();
        }
        int i7 = -top;
        aVar.f11249c = i7;
        if (i7 >= 0) {
            aVar.f11248b = height == 0 ? 0.0f : i7 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f11237d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f11249c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(@m0 RecyclerView recyclerView, int i7) {
        boolean z7 = true;
        if (!(this.f11238e == 1 && this.f11239f == 1) && i7 == 1) {
            s(false);
            return;
        }
        if (l() && i7 == 2) {
            if (this.f11244k) {
                e(2);
                this.f11243j = true;
                return;
            }
            return;
        }
        if (l() && i7 == 0) {
            t();
            if (this.f11244k) {
                a aVar = this.f11240g;
                if (aVar.f11249c == 0) {
                    int i8 = this.f11241h;
                    int i9 = aVar.f11247a;
                    if (i8 != i9) {
                        d(i9);
                    }
                } else {
                    z7 = false;
                }
            } else {
                int i10 = this.f11240g.f11247a;
                if (i10 != -1) {
                    c(i10, 0.0f, 0);
                }
            }
            if (z7) {
                e(0);
                q();
            }
        }
        if (this.f11238e == 2 && i7 == 0 && this.f11245l) {
            t();
            a aVar2 = this.f11240g;
            if (aVar2.f11249c == 0) {
                int i11 = this.f11242i;
                int i12 = aVar2.f11247a;
                if (i11 != i12) {
                    if (i12 == -1) {
                        i12 = 0;
                    }
                    d(i12);
                }
                e(0);
                q();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(@m0 RecyclerView recyclerView, int i7, int i8) {
        boolean z7;
        int i9;
        this.f11244k = true;
        t();
        if (this.f11243j) {
            this.f11243j = false;
            if (i8 > 0) {
                z7 = true;
            } else {
                if (i8 == 0) {
                    if ((i7 < 0) == this.f11235b.k()) {
                        z7 = true;
                    }
                }
                z7 = false;
            }
            if (z7) {
                a aVar = this.f11240g;
                if (aVar.f11249c != 0) {
                    i9 = aVar.f11247a + 1;
                } else {
                    i9 = this.f11240g.f11247a;
                }
            } else {
                i9 = this.f11240g.f11247a;
            }
            this.f11242i = i9;
            if (this.f11241h != i9) {
                d(i9);
            }
        } else if (this.f11238e == 0) {
            int i10 = this.f11240g.f11247a;
            if (i10 == -1) {
                i10 = 0;
            }
            d(i10);
        }
        a aVar2 = this.f11240g;
        int i11 = aVar2.f11247a;
        if (i11 == -1) {
            i11 = 0;
        }
        c(i11, aVar2.f11248b, aVar2.f11249c);
        a aVar3 = this.f11240g;
        int i12 = aVar3.f11247a;
        int i13 = this.f11242i;
        if ((i12 == i13 || i13 == -1) && aVar3.f11249c == 0 && this.f11239f != 1) {
            e(0);
            q();
        }
    }

    double g() {
        t();
        a aVar = this.f11240g;
        return ((double) aVar.f11247a) + ((double) aVar.f11248b);
    }

    int h() {
        return this.f11239f;
    }

    boolean i() {
        return this.f11239f == 1;
    }

    boolean j() {
        return this.f11246m;
    }

    boolean k() {
        return this.f11239f == 0;
    }

    void m() {
        this.f11238e = 4;
        s(true);
    }

    void n() {
        this.f11245l = true;
    }

    void o() {
        if (!i() || this.f11246m) {
            this.f11246m = false;
            t();
            a aVar = this.f11240g;
            if (aVar.f11249c != 0) {
                e(2);
                return;
            }
            int i7 = aVar.f11247a;
            if (i7 != this.f11241h) {
                d(i7);
            }
            e(0);
            q();
        }
    }

    void p(int i7, boolean z7) {
        this.f11238e = z7 ? 2 : 3;
        this.f11246m = false;
        boolean z8 = this.f11242i != i7;
        this.f11242i = i7;
        e(2);
        if (z8) {
            d(i7);
        }
    }

    void r(ViewPager2.j jVar) {
        this.f11234a = jVar;
    }
}
