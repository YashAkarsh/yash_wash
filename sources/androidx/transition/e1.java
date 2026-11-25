package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class e1 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10689a = "android:visibilityPropagation:visibility";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10690b = "android:visibilityPropagation:center";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f10691c = {f10689a, f10690b};

    private static int d(d0 d0Var, int i7) {
        int[] iArr;
        if (d0Var == null || (iArr = (int[]) d0Var.f10674a.get(f10690b)) == null) {
            return -1;
        }
        return iArr[i7];
    }

    @Override // androidx.transition.a0
    public void a(d0 d0Var) {
        View view = d0Var.f10675b;
        Integer numValueOf = (Integer) d0Var.f10674a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        d0Var.f10674a.put(f10689a, numValueOf);
        int[] iArr = {iRound, 0};
        view.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iRound + (view.getWidth() / 2);
        int iRound2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iRound2;
        iArr[1] = iRound2 + (view.getHeight() / 2);
        d0Var.f10674a.put(f10690b, iArr);
    }

    @Override // androidx.transition.a0
    public String[] b() {
        return f10691c;
    }

    public int e(d0 d0Var) {
        Integer num;
        if (d0Var == null || (num = (Integer) d0Var.f10674a.get(f10689a)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(d0 d0Var) {
        return d(d0Var, 0);
    }

    public int g(d0 d0Var) {
        return d(d0Var, 1);
    }
}
