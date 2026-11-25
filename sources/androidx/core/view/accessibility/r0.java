package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6527b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final Object f6528a;

    @c.t0(16)
    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final r0 f6529a;

        a(r0 r0Var) {
            this.f6529a = r0Var;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i7) {
            l0 l0VarB = this.f6529a.b(i7);
            if (l0VarB == null) {
                return null;
            }
            return l0VarB.W1();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i7) {
            List<l0> listC = this.f6529a.c(str, i7);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add(listC.get(i8).W1());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i7, int i8, Bundle bundle) {
            return this.f6529a.f(i7, i8, bundle);
        }
    }

    @c.t0(19)
    static class b extends a {
        b(r0 r0Var) {
            super(r0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i7) {
            l0 l0VarD = this.f6529a.d(i7);
            if (l0VarD == null) {
                return null;
            }
            return l0VarD.W1();
        }
    }

    @c.t0(26)
    static class c extends b {
        c(r0 r0Var) {
            super(r0Var);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i7, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f6529a.a(i7, l0.X1(accessibilityNodeInfo), str, bundle);
        }
    }

    public r0() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6528a = new c(this);
        } else {
            this.f6528a = new b(this);
        }
    }

    public void a(int i7, @c.m0 l0 l0Var, @c.m0 String str, @c.o0 Bundle bundle) {
    }

    @c.o0
    public l0 b(int i7) {
        return null;
    }

    @c.o0
    public List<l0> c(@c.m0 String str, int i7) {
        return null;
    }

    @c.o0
    public l0 d(int i7) {
        return null;
    }

    @c.o0
    public Object e() {
        return this.f6528a;
    }

    public boolean f(int i7, int i8, @c.o0 Bundle bundle) {
        return false;
    }

    public r0(@c.o0 Object obj) {
        this.f6528a = obj;
    }
}
