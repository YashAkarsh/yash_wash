package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.util.r;
import androidx.core.util.v;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.v1;
import androidx.core.view.w1;
import androidx.core.view.w5;
import androidx.core.view.y1;
import androidx.core.view.z1;
import androidx.customview.view.AbsSavedState;
import c.b0;
import c.g1;
import c.l;
import c.m0;
import c.o0;
import c.u;
import c.x0;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements v1, w1 {
    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final Comparator<View> D;
    private static final v.a<Rect> E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final String f4978u = "CoordinatorLayout";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f4979v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f4980w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f4981x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Class<?>[] f4982y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f4983z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<View> f4984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a<View> f4985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<View> f4986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<View> f4987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f4988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f4989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f4990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f4993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f4994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f4995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private g f4996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private w5 f4998o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f5000q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f5001r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private z1 f5002s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final y1 f5003t;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public static void F(@m0 View view, @o0 Object obj) {
            ((f) view.getLayoutParams()).f5024r = obj;
        }

        @o0
        public static Object e(@m0 View view) {
            return ((f) view.getLayoutParams()).f5024r;
        }

        @Deprecated
        public boolean A(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7) {
            return false;
        }

        public boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7, int i8) {
            if (i8 == 0) {
                return A(coordinatorLayout, v7, view, view2, i7);
            }
            return false;
        }

        @Deprecated
        public void C(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view) {
        }

        public void D(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7) {
            if (i7 == 0) {
                C(coordinatorLayout, v7, view);
            }
        }

        public boolean E(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7) {
            return d(coordinatorLayout, v7) > 0.0f;
        }

        public boolean b(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 Rect rect) {
            return false;
        }

        @l
        public int c(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7) {
            return n2.f6743t;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float d(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7) {
            return 0.0f;
        }

        public boolean f(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view) {
            return false;
        }

        @m0
        public w5 g(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 w5 w5Var) {
            return w5Var;
        }

        public void h(@m0 f fVar) {
        }

        public boolean i(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view) {
            return false;
        }

        public void j(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view) {
        }

        public void k() {
        }

        public boolean l(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
            return false;
        }

        public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
            return false;
        }

        public boolean n(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7, int i8, int i9, int i10) {
            return false;
        }

        public boolean o(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, float f8, float f9, boolean z7) {
            return false;
        }

        public boolean p(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, float f8, float f9) {
            return false;
        }

        @Deprecated
        public void q(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, @m0 int[] iArr) {
        }

        public void r(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, @m0 int[] iArr, int i9) {
            if (i9 == 0) {
                q(coordinatorLayout, v7, view, i7, i8, iArr);
            }
        }

        @Deprecated
        public void s(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, int i9, int i10) {
        }

        @Deprecated
        public void t(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, int i9, int i10, int i11) {
            if (i11 == 0) {
                s(coordinatorLayout, v7, view, i7, i8, i9, i10);
            }
        }

        public void u(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, int i9, int i10, int i11, @m0 int[] iArr) {
            iArr[0] = iArr[0] + i9;
            iArr[1] = iArr[1] + i10;
            t(coordinatorLayout, v7, view, i7, i8, i9, i10, i11);
        }

        @Deprecated
        public void v(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7) {
        }

        public void w(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7, int i8) {
            if (i8 == 0) {
                v(coordinatorLayout, v7, view, view2, i7);
            }
        }

        public boolean x(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 Rect rect, boolean z7) {
            return false;
        }

        public void y(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 Parcelable parcelable) {
        }

        @o0
        public Parcelable z(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    class a implements z1 {
        a() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            return CoordinatorLayout.this.b0(w5Var);
        }
    }

    public interface b {
        @m0
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface c {
        Class<? extends Behavior> value();
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f5001r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.M(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f5001r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.M(0);
            return true;
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fF0 = n2.F0(view);
            float fF1 = n2.F0(view2);
            if (fF0 > fF1) {
                return -1;
            }
            return fF0 < fF1 ? 1 : 0;
        }
    }

    static {
        Package r7 = CoordinatorLayout.class.getPackage();
        f4979v = r7 != null ? r7.getName() : null;
        D = new h();
        f4982y = new Class[]{Context.class, AttributeSet.class};
        f4983z = new ThreadLocal<>();
        E = new v.c(12);
    }

    public CoordinatorLayout(@m0 Context context) {
        this(context, null);
    }

    private void A(View view, int i7, Rect rect, Rect rect2, f fVar, int i8, int i9) {
        int iWidth;
        int iHeight;
        int iD = n0.d(W(fVar.f5009c), i7);
        int iD2 = n0.d(X(fVar.f5010d), i7);
        int i10 = iD & 7;
        int i11 = iD & 112;
        int i12 = iD2 & 7;
        int i13 = iD2 & 112;
        if (i12 != 1) {
            iWidth = i12 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i13 != 16) {
            iHeight = i13 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i10 == 1) {
            iWidth -= i8 / 2;
        } else if (i10 != 5) {
            iWidth -= i8;
        }
        if (i11 == 16) {
            iHeight -= i9 / 2;
        } else if (i11 != 80) {
            iHeight -= i9;
        }
        rect2.set(iWidth, iHeight, i8 + iWidth, i9 + iHeight);
    }

    private int B(int i7) {
        int[] iArr = this.f4993j;
        if (iArr == null) {
            Log.e(f4978u, "No keylines defined for " + this + " - attempted index lookup " + i7);
            return 0;
        }
        if (i7 >= 0 && i7 < iArr.length) {
            return iArr[i7];
        }
        Log.e(f4978u, "Keyline index " + i7 + " out of range for " + this);
        return 0;
    }

    private void E(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i7) : i7));
        }
        Comparator<View> comparator = D;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean F(View view) {
        return this.f4985b.j(view);
    }

    private void H(View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        Rect rectG = g();
        rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f4998o != null && n2.U(this) && !n2.U(view)) {
            rectG.left += this.f4998o.p();
            rectG.top += this.f4998o.r();
            rectG.right -= this.f4998o.q();
            rectG.bottom -= this.f4998o.o();
        }
        Rect rectG2 = g();
        n0.b(X(fVar.f5009c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i7);
        view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        T(rectG);
        T(rectG2);
    }

    private void I(View view, View view2, int i7) {
        Rect rectG = g();
        Rect rectG2 = g();
        try {
            y(view2, rectG);
            z(view, i7, rectG, rectG2);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        } finally {
            T(rectG);
            T(rectG2);
        }
    }

    private void J(View view, int i7, int i8) {
        f fVar = (f) view.getLayoutParams();
        int iD = n0.d(Y(fVar.f5009c), i8);
        int i9 = iD & 7;
        int i10 = iD & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i8 == 1) {
            i7 = width - i7;
        }
        int iB = B(i7) - measuredWidth;
        if (i9 == 1) {
            iB += measuredWidth / 2;
        } else if (i9 == 5) {
            iB += measuredWidth;
        }
        int i11 = 0;
        if (i10 == 16) {
            i11 = 0 + (measuredHeight / 2);
        } else if (i10 == 80) {
            i11 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iB, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void K(View view, Rect rect, int i7) {
        boolean z7;
        boolean z8;
        int width;
        int i8;
        int i9;
        int i10;
        int height;
        int i11;
        int i12;
        int i13;
        if (n2.U0(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            Behavior behaviorF = fVar.f();
            Rect rectG = g();
            Rect rectG2 = g();
            rectG2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorF == null || !behaviorF.b(this, view, rectG)) {
                rectG.set(rectG2);
            } else if (!rectG2.contains(rectG)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectG.toShortString() + " | Bounds:" + rectG2.toShortString());
            }
            T(rectG2);
            if (rectG.isEmpty()) {
                T(rectG);
                return;
            }
            int iD = n0.d(fVar.f5014h, i7);
            boolean z9 = true;
            if ((iD & 48) != 48 || (i12 = (rectG.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f5016j) >= (i13 = rect.top)) {
                z7 = false;
            } else {
                a0(view, i13 - i12);
                z7 = true;
            }
            if ((iD & 80) == 80 && (height = ((getHeight() - rectG.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f5016j) < (i11 = rect.bottom)) {
                a0(view, height - i11);
                z7 = true;
            }
            if (!z7) {
                a0(view, 0);
            }
            if ((iD & 3) != 3 || (i9 = (rectG.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f5015i) >= (i10 = rect.left)) {
                z8 = false;
            } else {
                Z(view, i10 - i9);
                z8 = true;
            }
            if ((iD & 5) != 5 || (width = ((getWidth() - rectG.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f5015i) >= (i8 = rect.right)) {
                z9 = z8;
            } else {
                Z(view, width - i8);
            }
            if (!z9) {
                Z(view, 0);
            }
            T(rectG);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior P(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f4979v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f4983z;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f4982y);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e8) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e8);
        }
    }

    private boolean Q(MotionEvent motionEvent, int i7) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f4986c;
        E(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zL = false;
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            View view = list.get(i8);
            f fVar = (f) view.getLayoutParams();
            Behavior behaviorF = fVar.f();
            if (!(zL || z7) || actionMasked == 0) {
                if (!zL && behaviorF != null) {
                    if (i7 == 0) {
                        zL = behaviorF.l(this, view, motionEvent);
                    } else if (i7 == 1) {
                        zL = behaviorF.E(this, view, motionEvent);
                    }
                    if (zL) {
                        this.f4994k = view;
                    }
                }
                boolean zC = fVar.c();
                boolean zJ = fVar.j(this, view);
                z7 = zJ && !zC;
                if (zJ && !z7) {
                    break;
                }
            } else if (behaviorF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i7 == 0) {
                    behaviorF.l(this, view, motionEventObtain);
                } else if (i7 == 1) {
                    behaviorF.E(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zL;
    }

    private void R() {
        this.f4984a.clear();
        this.f4985b.c();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            f fVarD = D(childAt);
            fVarD.d(this, childAt);
            this.f4985b.b(childAt);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (i8 != i7) {
                    View childAt2 = getChildAt(i8);
                    if (fVarD.b(this, childAt, childAt2)) {
                        if (!this.f4985b.d(childAt2)) {
                            this.f4985b.b(childAt2);
                        }
                        this.f4985b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4984a.addAll(this.f4985b.i());
        Collections.reverse(this.f4984a);
    }

    private static void T(@m0 Rect rect) {
        rect.setEmpty();
        E.a(rect);
    }

    private void V(boolean z7) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            Behavior behaviorF = ((f) childAt.getLayoutParams()).f();
            if (behaviorF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z7) {
                    behaviorF.l(this, childAt, motionEventObtain);
                } else {
                    behaviorF.E(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            ((f) getChildAt(i8).getLayoutParams()).n();
        }
        this.f4994k = null;
        this.f4991h = false;
    }

    private static int W(int i7) {
        if (i7 == 0) {
            return 17;
        }
        return i7;
    }

    private static int X(int i7) {
        if ((i7 & 7) == 0) {
            i7 |= n0.f6717b;
        }
        return (i7 & 112) == 0 ? i7 | 48 : i7;
    }

    private static int Y(int i7) {
        return i7 == 0 ? BadgeDrawable.f16994q : i7;
    }

    private void Z(View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        int i8 = fVar.f5015i;
        if (i8 != i7) {
            n2.e1(view, i7 - i8);
            fVar.f5015i = i7;
        }
    }

    private void a0(View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        int i8 = fVar.f5016j;
        if (i8 != i7) {
            n2.f1(view, i7 - i8);
            fVar.f5016j = i7;
        }
    }

    private void c0() {
        if (!n2.U(this)) {
            n2.a2(this, null);
            return;
        }
        if (this.f5002s == null) {
            this.f5002s = new a();
        }
        n2.a2(this, this.f5002s);
        setSystemUiVisibility(f4.e.a.f33921a);
    }

    @m0
    private static Rect g() {
        Rect rectB = E.b();
        return rectB == null ? new Rect() : rectB;
    }

    private static int i(int i7, int i8, int i9) {
        if (i7 < i8) {
            return i8;
        }
        return i7 > i9 ? i9 : i7;
    }

    private void j(f fVar, Rect rect, int i7, int i8) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i7) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i8) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i7 + iMax, i8 + iMax2);
    }

    private w5 k(w5 w5Var) {
        Behavior behaviorF;
        if (w5Var.A()) {
            return w5Var;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (n2.U(childAt) && (behaviorF = ((f) childAt.getLayoutParams()).f()) != null) {
                w5Var = behaviorF.g(this, childAt, w5Var);
                if (w5Var.A()) {
                    break;
                }
            }
        }
        return w5Var;
    }

    void C(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f D(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f5008b) {
            if (view instanceof b) {
                Behavior behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e(f4978u, "Attached behavior class is null");
                }
                fVar.q(behavior);
                fVar.f5008b = true;
            } else {
                c cVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    cVar = (c) superclass.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        fVar.q(cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e8) {
                        Log.e(f4978u, "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e8);
                    }
                }
                fVar.f5008b = true;
            }
        }
        return fVar;
    }

    public boolean G(@m0 View view, int i7, int i8) {
        Rect rectG = g();
        y(view, rectG);
        try {
            return rectG.contains(i7, i8);
        } finally {
            T(rectG);
        }
    }

    void L(View view, int i7) {
        Behavior behaviorF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f5017k != null) {
            Rect rectG = g();
            Rect rectG2 = g();
            Rect rectG3 = g();
            y(fVar.f5017k, rectG);
            v(view, false, rectG2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            A(view, i7, rectG, rectG3, fVar, measuredWidth, measuredHeight);
            boolean z7 = (rectG3.left == rectG2.left && rectG3.top == rectG2.top) ? false : true;
            j(fVar, rectG3, measuredWidth, measuredHeight);
            int i8 = rectG3.left - rectG2.left;
            int i9 = rectG3.top - rectG2.top;
            if (i8 != 0) {
                n2.e1(view, i8);
            }
            if (i9 != 0) {
                n2.f1(view, i9);
            }
            if (z7 && (behaviorF = fVar.f()) != null) {
                behaviorF.i(this, view, fVar.f5017k);
            }
            T(rectG);
            T(rectG2);
            T(rectG3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    final void M(int i7) {
        int i8;
        Behavior behaviorF;
        boolean zI;
        int iZ = n2.Z(this);
        int size = this.f4984a.size();
        Rect rectG = g();
        Rect rectG2 = g();
        Rect rectG3 = g();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.f4984a.get(i9);
            f fVar = (f) view.getLayoutParams();
            if (i7 != 0 || view.getVisibility() != 8) {
                for (int i10 = 0; i10 < i9; i10++) {
                    if (fVar.f5018l == this.f4984a.get(i10)) {
                        L(view, iZ);
                    }
                }
                v(view, true, rectG2);
                if (fVar.f5013g != 0 && !rectG2.isEmpty()) {
                    int iD = n0.d(fVar.f5013g, iZ);
                    int i11 = iD & 112;
                    if (i11 == 48) {
                        rectG.top = Math.max(rectG.top, rectG2.bottom);
                    } else if (i11 == 80) {
                        rectG.bottom = Math.max(rectG.bottom, getHeight() - rectG2.top);
                    }
                    int i12 = iD & 7;
                    if (i12 == 3) {
                        rectG.left = Math.max(rectG.left, rectG2.right);
                    } else if (i12 == 5) {
                        rectG.right = Math.max(rectG.right, getWidth() - rectG2.left);
                    }
                }
                if (fVar.f5014h != 0 && view.getVisibility() == 0) {
                    K(view, rectG, iZ);
                }
                if (i7 != 2) {
                    C(view, rectG3);
                    if (!rectG3.equals(rectG2)) {
                        S(view, rectG2);
                        for (i8 = i9 + 1; i8 < size; i8++) {
                            View view2 = this.f4984a.get(i8);
                            f fVar2 = (f) view2.getLayoutParams();
                            behaviorF = fVar2.f();
                            if (behaviorF == null && behaviorF.f(this, view2, view)) {
                                if (i7 == 0 && fVar2.g()) {
                                    fVar2.l();
                                } else {
                                    if (i7 != 2) {
                                        zI = behaviorF.i(this, view2, view);
                                    } else {
                                        behaviorF.j(this, view2, view);
                                        zI = true;
                                    }
                                    if (i7 == 1) {
                                        fVar2.r(zI);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i8 < size) {
                        View view3 = this.f4984a.get(i8);
                        f fVar3 = (f) view3.getLayoutParams();
                        behaviorF = fVar3.f();
                        if (behaviorF == null) {
                        }
                    }
                }
            }
        }
        T(rectG);
        T(rectG2);
        T(rectG3);
    }

    public void N(@m0 View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f5017k;
        if (view2 != null) {
            I(view, view2, i7);
            return;
        }
        int i8 = fVar.f5011e;
        if (i8 >= 0) {
            J(view, i8, i7);
        } else {
            H(view, i7);
        }
    }

    public void O(View view, int i7, int i8, int i9, int i10) {
        measureChildWithMargins(view, i7, i8, i9, i10);
    }

    void S(View view, Rect rect) {
        ((f) view.getLayoutParams()).s(rect);
    }

    void U() {
        if (this.f4992i && this.f4996m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4996m);
        }
        this.f4997n = false;
    }

    final w5 b0(w5 w5Var) {
        if (r.a(this.f4998o, w5Var)) {
            return w5Var;
        }
        this.f4998o = w5Var;
        boolean z7 = w5Var != null && w5Var.r() > 0;
        this.f4999p = z7;
        setWillNotDraw(!z7 && getBackground() == null);
        w5 w5VarK = k(w5Var);
        requestLayout();
        return w5VarK;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j7) {
        f fVar = (f) view.getLayoutParams();
        Behavior behavior = fVar.f5007a;
        if (behavior != null) {
            float fD = behavior.d(this, view);
            if (fD > 0.0f) {
                if (this.f4988e == null) {
                    this.f4988e = new Paint();
                }
                this.f4988e.setColor(fVar.f5007a.c(this, view));
                this.f4988e.setAlpha(i(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f4988e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5000q;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // androidx.core.view.w1
    public void e(@m0 View view, int i7, int i8, int i9, int i10, int i11, @m0 int[] iArr) {
        Behavior behaviorF;
        boolean z7;
        int iMin;
        int childCount = getChildCount();
        boolean z8 = false;
        int iMax = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.k(i11) && (behaviorF = fVar.f()) != null) {
                    int[] iArr2 = this.f4989f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.u(this, childAt, view, i7, i8, i9, i10, i11, iArr2);
                    int[] iArr3 = this.f4989f;
                    iMax = i9 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i10 > 0) {
                        z7 = true;
                        iMin = Math.max(i12, this.f4989f[1]);
                    } else {
                        z7 = true;
                        iMin = Math.min(i12, this.f4989f[1]);
                    }
                    i12 = iMin;
                    z8 = z7;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i12;
        if (z8) {
            M(1);
        }
    }

    @Override // androidx.core.view.v1
    public void f(View view, int i7, int i8, int i9, int i10, int i11) {
        e(view, i7, i8, i9, i10, 0, this.f4990g);
    }

    @g1
    final List<View> getDependencySortedChildren() {
        R();
        return Collections.unmodifiableList(this.f4984a);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public final w5 getLastWindowInsets() {
        return this.f4998o;
    }

    @Override // android.view.ViewGroup, androidx.core.view.x1
    public int getNestedScrollAxes() {
        return this.f5003t.a();
    }

    @o0
    public Drawable getStatusBarBackground() {
        return this.f5000q;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    void h() {
        if (this.f4992i) {
            if (this.f4996m == null) {
                this.f4996m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4996m);
        }
        this.f4997n = true;
    }

    public void l(@m0 View view) {
        List listG = this.f4985b.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i7 = 0; i7 < listG.size(); i7++) {
            View view2 = (View) listG.get(i7);
            Behavior behaviorF = ((f) view2.getLayoutParams()).f();
            if (behaviorF != null) {
                behaviorF.i(this, view2, view);
            }
        }
    }

    public boolean m(@m0 View view, @m0 View view2) {
        boolean z7 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectG = g();
        v(view, view.getParent() != this, rectG);
        Rect rectG2 = g();
        v(view2, view2.getParent() != this, rectG2);
        try {
            if (rectG.left <= rectG2.right && rectG.top <= rectG2.bottom && rectG.right >= rectG2.left && rectG.bottom >= rectG2.top) {
                z7 = true;
            }
            return z7;
        } finally {
            T(rectG);
            T(rectG2);
        }
    }

    void n() {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (F(getChildAt(i7))) {
                z7 = true;
                break;
            }
        }
        if (z7 != this.f4997n) {
            if (z7) {
                h();
            } else {
                U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        V(false);
        if (this.f4997n) {
            if (this.f4996m == null) {
                this.f4996m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4996m);
        }
        if (this.f4998o == null && n2.U(this)) {
            n2.v1(this);
        }
        this.f4992i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        V(false);
        if (this.f4997n && this.f4996m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4996m);
        }
        View view = this.f4995l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4992i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f4999p || this.f5000q == null) {
            return;
        }
        w5 w5Var = this.f4998o;
        int iR = w5Var != null ? w5Var.r() : 0;
        if (iR > 0) {
            this.f5000q.setBounds(0, 0, getWidth(), iR);
            this.f5000q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            V(true);
        }
        boolean zQ = Q(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            V(true);
        }
        return zQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        Behavior behaviorF;
        int iZ = n2.Z(this);
        int size = this.f4984a.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f4984a.get(i11);
            if (view.getVisibility() != 8 && ((behaviorF = ((f) view.getLayoutParams()).f()) == null || !behaviorF.m(this, view, iZ))) {
                N(view, iZ);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int i9;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        Behavior behaviorF;
        f fVar;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        R();
        n();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iZ = n2.Z(this);
        boolean z7 = iZ == 1;
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        int i16 = paddingLeft + paddingRight;
        int i17 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z8 = this.f4998o != null && n2.U(this);
        int size3 = this.f4984a.size();
        int i18 = suggestedMinimumWidth;
        int i19 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i20 = 0;
        while (i20 < size3) {
            View view = this.f4984a.get(i20);
            if (view.getVisibility() == 8) {
                i14 = i20;
                i11 = size3;
                i12 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i21 = fVar2.f5011e;
                if (i21 < 0 || mode == 0) {
                    i9 = iCombineMeasuredStates;
                } else {
                    int iB = B(i21);
                    int iD = n0.d(Y(fVar2.f5009c), iZ) & 7;
                    i9 = iCombineMeasuredStates;
                    if ((iD == 3 && !z7) || (iD == 5 && z7)) {
                        iMax = Math.max(0, (size - paddingRight) - iB);
                    } else if ((iD == 5 && !z7) || (iD == 3 && z7)) {
                        iMax = Math.max(0, iB - paddingLeft);
                    }
                    if (z8 || n2.U(view)) {
                        iMakeMeasureSpec = i7;
                        iMakeMeasureSpec2 = i8;
                    } else {
                        int iP = this.f4998o.p() + this.f4998o.q();
                        int iR = this.f4998o.r() + this.f4998o.o();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iP, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iR, mode2);
                    }
                    behaviorF = fVar2.f();
                    if (behaviorF != null) {
                        fVar = fVar2;
                        i13 = i9;
                        i14 = i20;
                        i10 = i19;
                        i12 = paddingLeft;
                        i15 = i18;
                        i11 = size3;
                        if (!behaviorF.n(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i15, i16 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                        int iMax3 = Math.max(i10, i17 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                        i18 = iMax2;
                        i19 = iMax3;
                    } else {
                        fVar = fVar2;
                        i10 = i19;
                        i11 = size3;
                        i12 = paddingLeft;
                        i13 = i9;
                        i14 = i20;
                        i15 = i18;
                    }
                    O(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i15, i16 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin + ((ViewGroup.MarginLayoutParams) fVar4).rightMargin);
                    int iMax5 = Math.max(i10, i17 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                    i18 = iMax4;
                    i19 = iMax5;
                }
                iMax = 0;
                if (z8) {
                    iMakeMeasureSpec = i7;
                    iMakeMeasureSpec2 = i8;
                } else {
                    iMakeMeasureSpec = i7;
                    iMakeMeasureSpec2 = i8;
                }
                behaviorF = fVar2.f();
                if (behaviorF != null) {
                    fVar = fVar2;
                    i13 = i9;
                    i14 = i20;
                    i10 = i19;
                    i12 = paddingLeft;
                    i15 = i18;
                    i11 = size3;
                    if (!behaviorF.n(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i15, i16 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin + ((ViewGroup.MarginLayoutParams) fVar5).rightMargin);
                    int iMax7 = Math.max(i10, i17 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                    i18 = iMax6;
                    i19 = iMax7;
                } else {
                    fVar = fVar2;
                    i10 = i19;
                    i11 = size3;
                    i12 = paddingLeft;
                    i13 = i9;
                    i14 = i20;
                    i15 = i18;
                }
                O(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i15, i16 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar6).leftMargin + ((ViewGroup.MarginLayoutParams) fVar6).rightMargin);
                int iMax9 = Math.max(i10, i17 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar6).topMargin + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                i18 = iMax8;
                i19 = iMax9;
            }
            i20 = i14 + 1;
            paddingLeft = i12;
            size3 = i11;
        }
        int i22 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i18, i7, (-16777216) & i22), View.resolveSizeAndState(i19, i8, i22 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedFling(View view, float f8, float f9, boolean z7) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.k(0) && (behaviorF = fVar.f()) != null) {
                    zO |= behaviorF.o(this, childAt, view, f8, f9, z7);
                }
            }
        }
        if (zO) {
            M(1);
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedPreFling(View view, float f8, float f9) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean zP = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.k(0) && (behaviorF = fVar.f()) != null) {
                    zP |= behaviorF.p(this, childAt, view, f8, f9);
                }
            }
        }
        return zP;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        s(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        f(view, i7, i8, i9, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScrollAccepted(View view, View view2, int i7) {
        q(view, view2, i7, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f5004c;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            Behavior behaviorF = D(childAt).f();
            if (id != -1 && behaviorF != null && (parcelable2 = sparseArray.get(id)) != null) {
                behaviorF.y(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableZ;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            Behavior behaviorF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && behaviorF != null && (parcelableZ = behaviorF.z(this, childAt)) != null) {
                sparseArray.append(id, parcelableZ);
            }
        }
        savedState.f5004c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onStartNestedScroll(View view, View view2, int i7) {
        return p(view, view2, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onStopNestedScroll(View view) {
        r(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r3
      0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zQ;
        boolean zE;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4994k == null) {
            zQ = Q(motionEvent, 1);
            if (!zQ) {
                zE = false;
            }
            motionEventObtain = null;
            if (this.f4994k == null) {
                zE |= super.onTouchEvent(motionEvent);
            } else if (zQ) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                V(false);
            }
            return zE;
        }
        zQ = false;
        Behavior behaviorF = ((f) this.f4994k.getLayoutParams()).f();
        if (behaviorF != null) {
            zE = behaviorF.E(this, this.f4994k, motionEvent);
        } else {
            zE = false;
        }
        motionEventObtain = null;
        if (this.f4994k == null) {
            zE |= super.onTouchEvent(motionEvent);
        } else if (zQ) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            V(false);
        } else {
            V(false);
        }
        return zE;
    }

    @Override // androidx.core.view.v1
    public boolean p(View view, View view2, int i7, int i8) {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                Behavior behaviorF = fVar.f();
                if (behaviorF != null) {
                    boolean zB = behaviorF.B(this, childAt, view, view2, i7, i8);
                    z7 |= zB;
                    fVar.t(i8, zB);
                } else {
                    fVar.t(i8, false);
                }
            }
        }
        return z7;
    }

    @Override // androidx.core.view.v1
    public void q(View view, View view2, int i7, int i8) {
        Behavior behaviorF;
        this.f5003t.c(view, view2, i7, i8);
        this.f4995l = view2;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.k(i8) && (behaviorF = fVar.f()) != null) {
                behaviorF.w(this, childAt, view, view2, i7, i8);
            }
        }
    }

    @Override // androidx.core.view.v1
    public void r(View view, int i7) {
        this.f5003t.e(view, i7);
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.k(i7)) {
                Behavior behaviorF = fVar.f();
                if (behaviorF != null) {
                    behaviorF.D(this, childAt, view, i7);
                }
                fVar.m(i7);
                fVar.l();
            }
        }
        this.f4995l = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        Behavior behaviorF = ((f) view.getLayoutParams()).f();
        if (behaviorF == null || !behaviorF.x(this, view, rect, z7)) {
            return super.requestChildRectangleOnScreen(view, rect, z7);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (!z7 || this.f4991h) {
            return;
        }
        V(false);
        this.f4991h = true;
    }

    @Override // androidx.core.view.v1
    public void s(View view, int i7, int i8, int[] iArr, int i9) {
        Behavior behaviorF;
        int childCount = getChildCount();
        boolean z7 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.k(i9) && (behaviorF = fVar.f()) != null) {
                    int[] iArr2 = this.f4989f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorF.r(this, childAt, view, i7, i8, iArr2, i9);
                    int[] iArr3 = this.f4989f;
                    iMax = i7 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f4989f;
                    iMax2 = i8 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z7 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z7) {
            M(1);
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z7) {
        super.setFitsSystemWindows(z7);
        c0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f5001r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@o0 Drawable drawable) {
        Drawable drawable2 = this.f5000q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f5000q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f5000q.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.d.m(this.f5000q, n2.Z(this));
                this.f5000q.setVisible(getVisibility() == 0, false);
                this.f5000q.setCallback(this);
            }
            n2.n1(this);
        }
    }

    public void setStatusBarBackgroundColor(@l int i7) {
        setStatusBarBackground(new ColorDrawable(i7));
    }

    public void setStatusBarBackgroundResource(@u int i7) {
        setStatusBarBackground(i7 != 0 ? androidx.core.content.d.i(getContext(), i7) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f5000q;
        if (drawable == null || drawable.isVisible() == z7) {
            return;
        }
        this.f5000q.setVisible(z7, false);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void v(View view, boolean z7, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z7) {
            y(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5000q;
    }

    @m0
    public List<View> w(@m0 View view) {
        List<View> listH = this.f4985b.h(view);
        this.f4987d.clear();
        if (listH != null) {
            this.f4987d.addAll(listH);
        }
        return this.f4987d;
    }

    @m0
    public List<View> x(@m0 View view) {
        List listG = this.f4985b.g(view);
        this.f4987d.clear();
        if (listG != null) {
            this.f4987d.addAll(listG);
        }
        return this.f4987d;
    }

    void y(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void z(View view, int i7, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        A(view, i7, rect, rect2, fVar, measuredWidth, measuredHeight);
        j(fVar, rect2, measuredWidth, measuredHeight);
    }

    public CoordinatorLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i7);
        this.f4984a = new ArrayList();
        this.f4985b = new androidx.coordinatorlayout.widget.a<>();
        this.f4986c = new ArrayList();
        this.f4987d = new ArrayList();
        this.f4989f = new int[2];
        this.f4990g = new int[2];
        this.f5003t = new y1(this);
        if (i7 == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i7, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i7 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4993j = resources.getIntArray(resourceId);
            float f8 = resources.getDisplayMetrics().density;
            int length = this.f4993j.length;
            for (int i8 = 0; i8 < length; i8++) {
                int[] iArr = this.f4993j;
                iArr[i8] = (int) (iArr[i8] * f8);
            }
        }
        this.f5000q = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        c0();
        super.setOnHierarchyChangeListener(new e());
        if (n2.V(this) == 0) {
            n2.R1(this, 1);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SparseArray<Parcelable> f5004c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i7 = parcel.readInt();
            int[] iArr = new int[i7];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f5004c = new SparseArray<>(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                this.f5004c.append(iArr[i8], parcelableArray[i8]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            SparseArray<Parcelable> sparseArray = this.f5004c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr[i8] = this.f5004c.keyAt(i8);
                parcelableArr[i8] = this.f5004c.valueAt(i8);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i7);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Behavior f5007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f5012f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5013g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5014h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f5015i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f5016j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        View f5017k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        View f5018l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f5019m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f5020n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f5021o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f5022p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final Rect f5023q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Object f5024r;

        public f(int i7, int i8) {
            super(i7, i8);
            this.f5008b = false;
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = -1;
            this.f5012f = -1;
            this.f5013g = 0;
            this.f5014h = 0;
            this.f5023q = new Rect();
        }

        private void o(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f5012f);
            this.f5017k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f5018l = null;
                    this.f5017k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f5012f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f5018l = null;
                this.f5017k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f5018l = null;
                    this.f5017k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f5018l = viewFindViewById;
        }

        private boolean u(View view, int i7) {
            int iD = n0.d(((f) view.getLayoutParams()).f5013g, i7);
            return iD != 0 && (n0.d(this.f5014h, i7) & iD) == iD;
        }

        private boolean v(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f5017k.getId() != this.f5012f) {
                return false;
            }
            View view2 = this.f5017k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f5018l = null;
                    this.f5017k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f5018l = view2;
            return true;
        }

        boolean a() {
            return this.f5017k == null && this.f5012f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.f5018l || u(view2, n2.Z(coordinatorLayout)) || ((behavior = this.f5007a) != null && behavior.f(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f5007a == null) {
                this.f5019m = false;
            }
            return this.f5019m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f5012f == -1) {
                this.f5018l = null;
                this.f5017k = null;
                return null;
            }
            if (this.f5017k == null || !v(view, coordinatorLayout)) {
                o(view, coordinatorLayout);
            }
            return this.f5017k;
        }

        @b0
        public int e() {
            return this.f5012f;
        }

        @o0
        public Behavior f() {
            return this.f5007a;
        }

        boolean g() {
            return this.f5022p;
        }

        Rect h() {
            return this.f5023q;
        }

        void i() {
            this.f5018l = null;
            this.f5017k = null;
        }

        boolean j(CoordinatorLayout coordinatorLayout, View view) {
            boolean z7 = this.f5019m;
            if (z7) {
                return true;
            }
            Behavior behavior = this.f5007a;
            boolean zA = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z7;
            this.f5019m = zA;
            return zA;
        }

        boolean k(int i7) {
            if (i7 == 0) {
                return this.f5020n;
            }
            if (i7 != 1) {
                return false;
            }
            return this.f5021o;
        }

        void l() {
            this.f5022p = false;
        }

        void m(int i7) {
            t(i7, false);
        }

        void n() {
            this.f5019m = false;
        }

        public void p(@b0 int i7) {
            i();
            this.f5012f = i7;
        }

        public void q(@o0 Behavior behavior) {
            Behavior behavior2 = this.f5007a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.k();
                }
                this.f5007a = behavior;
                this.f5024r = null;
                this.f5008b = true;
                if (behavior != null) {
                    behavior.h(this);
                }
            }
        }

        void r(boolean z7) {
            this.f5022p = z7;
        }

        void s(Rect rect) {
            this.f5023q.set(rect);
        }

        void t(int i7, boolean z7) {
            if (i7 == 0) {
                this.f5020n = z7;
            } else {
                if (i7 != 1) {
                    return;
                }
                this.f5021o = z7;
            }
        }

        f(@m0 Context context, @o0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5008b = false;
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = -1;
            this.f5012f = -1;
            this.f5013g = 0;
            this.f5014h = 0;
            this.f5023q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f5009c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f5012f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f5010d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f5011e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f5013g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f5014h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f5008b = zHasValue;
            if (zHasValue) {
                this.f5007a = CoordinatorLayout.P(context, attributeSet, typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.f5007a;
            if (behavior != null) {
                behavior.h(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f5008b = false;
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = -1;
            this.f5012f = -1;
            this.f5013g = 0;
            this.f5014h = 0;
            this.f5023q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5008b = false;
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = -1;
            this.f5012f = -1;
            this.f5013g = 0;
            this.f5014h = 0;
            this.f5023q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5008b = false;
            this.f5009c = 0;
            this.f5010d = 0;
            this.f5011e = -1;
            this.f5012f = -1;
            this.f5013g = 0;
            this.f5014h = 0;
            this.f5023q = new Rect();
        }
    }
}
