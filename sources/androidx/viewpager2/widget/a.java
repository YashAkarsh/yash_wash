package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.m0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f11212b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayoutManager f11213a;

    /* JADX INFO: renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    class C0133a implements Comparator<int[]> {
        C0133a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f11212b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(@m0 LinearLayoutManager linearLayoutManager) {
        this.f11213a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i7;
        int bottom;
        int i8;
        int iQ = this.f11213a.Q();
        if (iQ == 0) {
            return true;
        }
        boolean z7 = this.f11213a.Q2() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iQ, 2);
        for (int i9 = 0; i9 < iQ; i9++) {
            View viewP = this.f11213a.P(i9);
            if (viewP == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewP.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f11212b;
            int[] iArr2 = iArr[i9];
            if (z7) {
                top = viewP.getLeft();
                i7 = marginLayoutParams.leftMargin;
            } else {
                top = viewP.getTop();
                i7 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i7;
            int[] iArr3 = iArr[i9];
            if (z7) {
                bottom = viewP.getRight();
                i8 = marginLayoutParams.rightMargin;
            } else {
                bottom = viewP.getBottom();
                i8 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i8;
        }
        Arrays.sort(iArr, new C0133a());
        for (int i10 = 1; i10 < iQ; i10++) {
            if (iArr[i10 - 1][1] != iArr[i10][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i11 = iArr4[1];
        int i12 = iArr4[0];
        return i12 <= 0 && iArr[iQ - 1][1] >= i11 - i12;
    }

    private boolean b() {
        int iQ = this.f11213a.Q();
        for (int i7 = 0; i7 < iQ; i7++) {
            if (c(this.f11213a.P(i7))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                if (c(viewGroup.getChildAt(i7))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.f11213a.Q() <= 1) && b();
    }
}
