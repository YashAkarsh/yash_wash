package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityRecord f6530a;

    @c.t0(15)
    static class a {
        private a() {
        }

        @c.t
        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        @c.t
        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        @c.t
        static void c(AccessibilityRecord accessibilityRecord, int i7) {
            accessibilityRecord.setMaxScrollX(i7);
        }

        @c.t
        static void d(AccessibilityRecord accessibilityRecord, int i7) {
            accessibilityRecord.setMaxScrollY(i7);
        }
    }

    @c.t0(16)
    static class b {
        private b() {
        }

        @c.t
        static void a(AccessibilityRecord accessibilityRecord, View view, int i7) {
            accessibilityRecord.setSource(view, i7);
        }
    }

    @Deprecated
    public s0(Object obj) {
        this.f6530a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static s0 A(s0 s0Var) {
        return new s0(AccessibilityRecord.obtain(s0Var.f6530a));
    }

    public static void N(@c.m0 AccessibilityRecord accessibilityRecord, int i7) {
        a.c(accessibilityRecord, i7);
    }

    public static void P(@c.m0 AccessibilityRecord accessibilityRecord, int i7) {
        a.d(accessibilityRecord, i7);
    }

    public static void Y(@c.m0 AccessibilityRecord accessibilityRecord, @c.o0 View view, int i7) {
        b.a(accessibilityRecord, view, i7);
    }

    public static int j(@c.m0 AccessibilityRecord accessibilityRecord) {
        return a.a(accessibilityRecord);
    }

    public static int l(@c.m0 AccessibilityRecord accessibilityRecord) {
        return a.b(accessibilityRecord);
    }

    @Deprecated
    public static s0 z() {
        return new s0(AccessibilityRecord.obtain());
    }

    @Deprecated
    public void B() {
        this.f6530a.recycle();
    }

    @Deprecated
    public void C(int i7) {
        this.f6530a.setAddedCount(i7);
    }

    @Deprecated
    public void D(CharSequence charSequence) {
        this.f6530a.setBeforeText(charSequence);
    }

    @Deprecated
    public void E(boolean z7) {
        this.f6530a.setChecked(z7);
    }

    @Deprecated
    public void F(CharSequence charSequence) {
        this.f6530a.setClassName(charSequence);
    }

    @Deprecated
    public void G(CharSequence charSequence) {
        this.f6530a.setContentDescription(charSequence);
    }

    @Deprecated
    public void H(int i7) {
        this.f6530a.setCurrentItemIndex(i7);
    }

    @Deprecated
    public void I(boolean z7) {
        this.f6530a.setEnabled(z7);
    }

    @Deprecated
    public void J(int i7) {
        this.f6530a.setFromIndex(i7);
    }

    @Deprecated
    public void K(boolean z7) {
        this.f6530a.setFullScreen(z7);
    }

    @Deprecated
    public void L(int i7) {
        this.f6530a.setItemCount(i7);
    }

    @Deprecated
    public void M(int i7) {
        N(this.f6530a, i7);
    }

    @Deprecated
    public void O(int i7) {
        P(this.f6530a, i7);
    }

    @Deprecated
    public void Q(Parcelable parcelable) {
        this.f6530a.setParcelableData(parcelable);
    }

    @Deprecated
    public void R(boolean z7) {
        this.f6530a.setPassword(z7);
    }

    @Deprecated
    public void S(int i7) {
        this.f6530a.setRemovedCount(i7);
    }

    @Deprecated
    public void T(int i7) {
        this.f6530a.setScrollX(i7);
    }

    @Deprecated
    public void U(int i7) {
        this.f6530a.setScrollY(i7);
    }

    @Deprecated
    public void V(boolean z7) {
        this.f6530a.setScrollable(z7);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void W(View view) {
        this.f6530a.setSource(view);
    }

    @Deprecated
    public void X(View view, int i7) {
        Y(this.f6530a, view, i7);
    }

    @Deprecated
    public void Z(int i7) {
        this.f6530a.setToIndex(i7);
    }

    @Deprecated
    public int a() {
        return this.f6530a.getAddedCount();
    }

    @Deprecated
    public CharSequence b() {
        return this.f6530a.getBeforeText();
    }

    @Deprecated
    public CharSequence c() {
        return this.f6530a.getClassName();
    }

    @Deprecated
    public CharSequence d() {
        return this.f6530a.getContentDescription();
    }

    @Deprecated
    public int e() {
        return this.f6530a.getCurrentItemIndex();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        AccessibilityRecord accessibilityRecord = this.f6530a;
        if (accessibilityRecord == null) {
            return s0Var.f6530a == null;
        }
        return accessibilityRecord.equals(s0Var.f6530a);
    }

    @Deprecated
    public int f() {
        return this.f6530a.getFromIndex();
    }

    @Deprecated
    public Object g() {
        return this.f6530a;
    }

    @Deprecated
    public int h() {
        return this.f6530a.getItemCount();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f6530a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public int i() {
        return j(this.f6530a);
    }

    @Deprecated
    public int k() {
        return l(this.f6530a);
    }

    @Deprecated
    public Parcelable m() {
        return this.f6530a.getParcelableData();
    }

    @Deprecated
    public int n() {
        return this.f6530a.getRemovedCount();
    }

    @Deprecated
    public int o() {
        return this.f6530a.getScrollX();
    }

    @Deprecated
    public int p() {
        return this.f6530a.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public l0 q() {
        return l0.Y1(this.f6530a.getSource());
    }

    @Deprecated
    public List<CharSequence> r() {
        return this.f6530a.getText();
    }

    @Deprecated
    public int s() {
        return this.f6530a.getToIndex();
    }

    @Deprecated
    public int t() {
        return this.f6530a.getWindowId();
    }

    @Deprecated
    public boolean u() {
        return this.f6530a.isChecked();
    }

    @Deprecated
    public boolean v() {
        return this.f6530a.isEnabled();
    }

    @Deprecated
    public boolean w() {
        return this.f6530a.isFullScreen();
    }

    @Deprecated
    public boolean x() {
        return this.f6530a.isPassword();
    }

    @Deprecated
    public boolean y() {
        return this.f6530a.isScrollable();
    }
}
