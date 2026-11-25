package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f6843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f6844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f6845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f6847e;

    public u1(@c.m0 View view) {
        this.f6845c = view;
    }

    private boolean h(int i7, int i8, int i9, int i10, @c.o0 int[] iArr, int i11, @c.o0 int[] iArr2) {
        ViewParent viewParentI;
        int i12;
        int i13;
        int[] iArr3;
        if (!m() || (viewParentI = i(i11)) == null) {
            return false;
        }
        if (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f6845c.getLocationInWindow(iArr);
            i12 = iArr[0];
            i13 = iArr[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        l4.i(viewParentI, this.f6845c, i7, i8, i9, i10, i11, iArr3);
        if (iArr != null) {
            this.f6845c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i12;
            iArr[1] = iArr[1] - i13;
        }
        return true;
    }

    private ViewParent i(int i7) {
        if (i7 == 0) {
            return this.f6843a;
        }
        if (i7 != 1) {
            return null;
        }
        return this.f6844b;
    }

    private int[] j() {
        if (this.f6847e == null) {
            this.f6847e = new int[2];
        }
        return this.f6847e;
    }

    private void q(int i7, ViewParent viewParent) {
        if (i7 == 0) {
            this.f6843a = viewParent;
        } else {
            if (i7 != 1) {
                return;
            }
            this.f6844b = viewParent;
        }
    }

    public boolean a(float f8, float f9, boolean z7) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return l4.c(viewParentI, this.f6845c, f8, f9, z7);
    }

    public boolean b(float f8, float f9) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return l4.d(viewParentI, this.f6845c, f8, f9);
    }

    public boolean c(int i7, int i8, @c.o0 int[] iArr, @c.o0 int[] iArr2) {
        return d(i7, i8, iArr, iArr2, 0);
    }

    public boolean d(int i7, int i8, @c.o0 int[] iArr, @c.o0 int[] iArr2, int i9) {
        ViewParent viewParentI;
        int i10;
        int i11;
        if (!m() || (viewParentI = i(i9)) == null) {
            return false;
        }
        if (i7 == 0 && i8 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f6845c.getLocationInWindow(iArr2);
            i10 = iArr2[0];
            i11 = iArr2[1];
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        l4.f(viewParentI, this.f6845c, i7, i8, iArr, i9);
        if (iArr2 != null) {
            this.f6845c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i10;
            iArr2[1] = iArr2[1] - i11;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i7, int i8, int i9, int i10, @c.o0 int[] iArr, int i11, @c.o0 int[] iArr2) {
        h(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    public boolean f(int i7, int i8, int i9, int i10, @c.o0 int[] iArr) {
        return h(i7, i8, i9, i10, iArr, 0, null);
    }

    public boolean g(int i7, int i8, int i9, int i10, @c.o0 int[] iArr, int i11) {
        return h(i7, i8, i9, i10, iArr, i11, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i7) {
        return i(i7) != null;
    }

    public boolean m() {
        return this.f6846d;
    }

    public void n() {
        n2.G2(this.f6845c);
    }

    public void o(@c.m0 View view) {
        n2.G2(this.f6845c);
    }

    public void p(boolean z7) {
        if (this.f6846d) {
            n2.G2(this.f6845c);
        }
        this.f6846d = z7;
    }

    public boolean r(int i7) {
        return s(i7, 0);
    }

    public boolean s(int i7, int i8) {
        if (l(i8)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f6845c;
        for (ViewParent parent = this.f6845c.getParent(); parent != null; parent = parent.getParent()) {
            if (l4.m(parent, view, this.f6845c, i7, i8)) {
                q(i8, parent);
                l4.k(parent, view, this.f6845c, i7, i8);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void t() {
        u(0);
    }

    public void u(int i7) {
        ViewParent viewParentI = i(i7);
        if (viewParentI != null) {
            l4.o(viewParentI, this.f6845c, i7);
            q(i7, null);
        }
    }
}
