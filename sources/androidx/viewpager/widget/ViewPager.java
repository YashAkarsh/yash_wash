package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import androidx.customview.view.AbsSavedState;
import c.m0;
import c.o0;
import c.r0;
import c.u;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final String I0 = "ViewPager";
    private static final boolean J0 = false;
    private static final boolean K0 = false;
    private static final int L0 = 1;
    private static final int M0 = 600;
    private static final int N0 = 25;
    private static final int O0 = 16;
    private static final int P0 = 400;
    private static final int T0 = -1;
    private static final int U0 = 2;
    private static final int V0 = 0;
    private static final int W0 = 1;
    private static final int X0 = 2;
    public static final int Z0 = 0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f11083a1 = 1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f11084b1 = 2;
    private int A;
    private i A0;
    private int B;
    private List<h> B0;
    private int C;
    private j C0;
    private float D;
    private int D0;
    private float E;
    private int E0;
    private float F;
    private ArrayList<View> F0;
    private float G;
    private final Runnable G0;
    private int H;
    private int H0;
    private VelocityTracker I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f11085J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private long O;
    private EdgeEffect P;
    private EdgeEffect Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private List<i> V;
    private i W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<f> f11087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f11088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f11089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    androidx.viewpager.widget.a f11090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f11091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Parcelable f11093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ClassLoader f11094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Scroller f11095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private k f11097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f11099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f11100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f11102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f11103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11104s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11105t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11106u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f11107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11108w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11109x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f11110y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f11111z;
    static final int[] Q0 = {R.attr.layout_gravity};
    private static final Comparator<f> R0 = new a();
    private static final Interpolator S0 = new b();
    private static final m Y0 = new m();

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f11118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Parcelable f11119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ClassLoader f11120e;

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

        public SavedState(@m0 Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f11118c + com.alipay.sdk.util.j.f13808d;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f11118c);
            parcel.writeParcelable(this.f11119d, i7);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f11118c = parcel.readInt();
            this.f11119d = parcel.readParcelable(classLoader);
            this.f11120e = classLoader;
        }
    }

    static class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f11125b - fVar2.f11125b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.J();
        }
    }

    class d implements z1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f11122a = new Rect();

        d() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            w5 w5VarG1 = n2.g1(view, w5Var);
            if (w5VarG1.A()) {
                return w5VarG1;
            }
            Rect rect = this.f11122a;
            rect.left = w5VarG1.p();
            rect.top = w5VarG1.r();
            rect.right = w5VarG1.q();
            rect.bottom = w5VarG1.o();
            int childCount = ViewPager.this.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                w5 w5VarP = n2.p(ViewPager.this.getChildAt(i7), w5VarG1);
                rect.left = Math.min(w5VarP.p(), rect.left);
                rect.top = Math.min(w5VarP.r(), rect.top);
                rect.right = Math.min(w5VarP.q(), rect.right);
                rect.bottom = Math.min(w5VarP.o(), rect.bottom);
            }
            return w5VarG1.D(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f11124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f11126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f11127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f11128e;

        f() {
        }
    }

    class g extends androidx.core.view.a {
        g() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f11090e;
            return aVar != null && aVar.e() > 1;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f11090e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.e());
            accessibilityEvent.setFromIndex(ViewPager.this.f11091f);
            accessibilityEvent.setToIndex(ViewPager.this.f11091f);
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            super.g(view, l0Var);
            l0Var.W0(ViewPager.class.getName());
            l0Var.F1(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                l0Var.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                l0Var.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i7, Bundle bundle) {
            if (super.j(view, i7, bundle)) {
                return true;
            }
            if (i7 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f11091f + 1);
                return true;
            }
            if (i7 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f11091f - 1);
            return true;
        }
    }

    public interface h {
        void a(@m0 ViewPager viewPager, @o0 androidx.viewpager.widget.a aVar, @o0 androidx.viewpager.widget.a aVar2);
    }

    public interface i {
        void h(int i7, float f8, @r0 int i8);

        void t(int i7);

        void u(int i7);
    }

    public interface j {
        void a(@m0 View view, float f8);
    }

    private class k extends DataSetObserver {
        k() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.j();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.j();
        }
    }

    public static class l implements i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void h(int i7, float f8, int i8) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void t(int i7) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void u(int i7) {
        }
    }

    static class m implements Comparator<View> {
        m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z7 = layoutParams.f11112a;
            if (z7 != layoutParams2.f11112a) {
                return z7 ? 1 : -1;
            }
            return layoutParams.f11116e - layoutParams2.f11116e;
        }
    }

    public ViewPager(@m0 Context context) {
        super(context);
        this.f11087b = new ArrayList<>();
        this.f11088c = new f();
        this.f11089d = new Rect();
        this.f11092g = -1;
        this.f11093h = null;
        this.f11094i = null;
        this.f11102q = -3.4028235E38f;
        this.f11103r = Float.MAX_VALUE;
        this.f11109x = 1;
        this.H = -1;
        this.R = true;
        this.S = false;
        this.G0 = new c();
        this.H0 = 0;
        z();
    }

    private static boolean A(@m0 View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean C(float f8, float f9) {
        return (f8 < ((float) this.B) && f9 > 0.0f) || (f8 > ((float) (getWidth() - this.B)) && f9 < 0.0f);
    }

    private void E(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i7);
            this.H = motionEvent.getPointerId(i7);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean H(int i7) {
        if (this.f11087b.size() == 0) {
            if (this.R) {
                return false;
            }
            this.T = false;
            D(0, 0.0f, 0);
            if (this.T) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarX = x();
        int clientWidth = getClientWidth();
        int i8 = this.f11098m;
        int i9 = clientWidth + i8;
        float f8 = clientWidth;
        int i10 = fVarX.f11125b;
        float f9 = ((i7 / f8) - fVarX.f11128e) / (fVarX.f11127d + (i8 / f8));
        this.T = false;
        D(i10, f9, (int) (i9 * f9));
        if (this.T) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean I(float f8) {
        boolean z7;
        boolean z8;
        float f9 = this.D - f8;
        this.D = f8;
        float scrollX = getScrollX() + f9;
        float clientWidth = getClientWidth();
        float f10 = this.f11102q * clientWidth;
        float f11 = this.f11103r * clientWidth;
        boolean z9 = false;
        f fVar = this.f11087b.get(0);
        ArrayList<f> arrayList = this.f11087b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f11125b != 0) {
            f10 = fVar.f11128e * clientWidth;
            z7 = false;
        } else {
            z7 = true;
        }
        if (fVar2.f11125b != this.f11090e.e() - 1) {
            f11 = fVar2.f11128e * clientWidth;
            z8 = false;
        } else {
            z8 = true;
        }
        if (scrollX < f10) {
            if (z7) {
                this.P.onPull(Math.abs(f10 - scrollX) / clientWidth);
                z9 = true;
            }
            scrollX = f10;
        } else if (scrollX > f11) {
            if (z8) {
                this.Q.onPull(Math.abs(scrollX - f11) / clientWidth);
                z9 = true;
            }
            scrollX = f11;
        }
        int i7 = (int) scrollX;
        this.D += scrollX - i7;
        scrollTo(i7, getScrollY());
        H(i7);
        return z9;
    }

    private void L(int i7, int i8, int i9, int i10) {
        if (i8 > 0 && !this.f11087b.isEmpty()) {
            if (!this.f11095j.isFinished()) {
                this.f11095j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i8 - getPaddingLeft()) - getPaddingRight()) + i10)) * (((i7 - getPaddingLeft()) - getPaddingRight()) + i9)), getScrollY());
                return;
            }
        }
        f fVarY = y(this.f11091f);
        int iMin = (int) ((fVarY != null ? Math.min(fVarY.f11128e, this.f11103r) : 0.0f) * ((i7 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            i(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void M() {
        int i7 = 0;
        while (i7 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i7).getLayoutParams()).f11112a) {
                removeViewAt(i7);
                i7--;
            }
            i7++;
        }
    }

    private void P(boolean z7) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z7);
        }
    }

    private boolean Q() {
        this.H = -1;
        q();
        this.P.onRelease();
        this.Q.onRelease();
        return this.P.isFinished() || this.Q.isFinished();
    }

    private void R(int i7, boolean z7, int i8, boolean z8) {
        f fVarY = y(i7);
        int clientWidth = fVarY != null ? (int) (getClientWidth() * Math.max(this.f11102q, Math.min(fVarY.f11128e, this.f11103r))) : 0;
        if (z7) {
            W(clientWidth, 0, i8);
            if (z8) {
                m(i7);
                return;
            }
            return;
        }
        if (z8) {
            m(i7);
        }
        i(false);
        scrollTo(clientWidth, 0);
        H(clientWidth);
    }

    private void X() {
        if (this.E0 != 0) {
            ArrayList<View> arrayList = this.F0;
            if (arrayList == null) {
                this.F0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                this.F0.add(getChildAt(i7));
            }
            Collections.sort(this.F0, Y0);
        }
    }

    private void f(f fVar, int i7, f fVar2) {
        int i8;
        int i9;
        f fVar3;
        f fVar4;
        int iE = this.f11090e.e();
        int clientWidth = getClientWidth();
        float f8 = clientWidth > 0 ? this.f11098m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i10 = fVar2.f11125b;
            int i11 = fVar.f11125b;
            if (i10 < i11) {
                float fH = fVar2.f11128e + fVar2.f11127d + f8;
                int i12 = i10 + 1;
                int i13 = 0;
                while (i12 <= fVar.f11125b && i13 < this.f11087b.size()) {
                    f fVar5 = this.f11087b.get(i13);
                    while (true) {
                        fVar4 = fVar5;
                        if (i12 <= fVar4.f11125b || i13 >= this.f11087b.size() - 1) {
                            break;
                        }
                        i13++;
                        fVar5 = this.f11087b.get(i13);
                    }
                    while (i12 < fVar4.f11125b) {
                        fH += this.f11090e.h(i12) + f8;
                        i12++;
                    }
                    fVar4.f11128e = fH;
                    fH += fVar4.f11127d + f8;
                    i12++;
                }
            } else if (i10 > i11) {
                int size = this.f11087b.size() - 1;
                float fH2 = fVar2.f11128e;
                while (true) {
                    i10--;
                    if (i10 < fVar.f11125b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f11087b.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i10 >= fVar3.f11125b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.f11087b.get(size);
                    }
                    while (i10 > fVar3.f11125b) {
                        fH2 -= this.f11090e.h(i10) + f8;
                        i10--;
                    }
                    fH2 -= fVar3.f11127d + f8;
                    fVar3.f11128e = fH2;
                }
            }
        }
        int size2 = this.f11087b.size();
        float fH3 = fVar.f11128e;
        int i14 = fVar.f11125b;
        int i15 = i14 - 1;
        this.f11102q = i14 == 0 ? fH3 : -3.4028235E38f;
        int i16 = iE - 1;
        this.f11103r = i14 == i16 ? (fVar.f11127d + fH3) - 1.0f : Float.MAX_VALUE;
        int i17 = i7 - 1;
        while (i17 >= 0) {
            f fVar7 = this.f11087b.get(i17);
            while (true) {
                i9 = fVar7.f11125b;
                if (i15 <= i9) {
                    break;
                }
                fH3 -= this.f11090e.h(i15) + f8;
                i15--;
            }
            fH3 -= fVar7.f11127d + f8;
            fVar7.f11128e = fH3;
            if (i9 == 0) {
                this.f11102q = fH3;
            }
            i17--;
            i15--;
        }
        float fH4 = fVar.f11128e + fVar.f11127d + f8;
        int i18 = fVar.f11125b + 1;
        int i19 = i7 + 1;
        while (i19 < size2) {
            f fVar8 = this.f11087b.get(i19);
            while (true) {
                i8 = fVar8.f11125b;
                if (i18 >= i8) {
                    break;
                }
                fH4 += this.f11090e.h(i18) + f8;
                i18++;
            }
            if (i8 == i16) {
                this.f11103r = (fVar8.f11127d + fH4) - 1.0f;
            }
            fVar8.f11128e = fH4;
            fH4 += fVar8.f11127d + f8;
            i19++;
            i18++;
        }
        this.S = false;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void i(boolean z7) {
        boolean z8 = this.H0 == 2;
        if (z8) {
            setScrollingCacheEnabled(false);
            if (!this.f11095j.isFinished()) {
                this.f11095j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f11095j.getCurrX();
                int currY = this.f11095j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        H(currX);
                    }
                }
            }
        }
        this.f11108w = false;
        for (int i7 = 0; i7 < this.f11087b.size(); i7++) {
            f fVar = this.f11087b.get(i7);
            if (fVar.f11126c) {
                fVar.f11126c = false;
                z8 = true;
            }
        }
        if (z8) {
            if (z7) {
                n2.p1(this, this.G0);
            } else {
                this.G0.run();
            }
        }
    }

    private int k(int i7, float f8, int i8, int i9) {
        if (Math.abs(i9) <= this.L || Math.abs(i8) <= this.f11085J) {
            i7 += (int) (f8 + (i7 >= this.f11091f ? 0.4f : 0.6f));
        } else if (i8 <= 0) {
            i7++;
        }
        if (this.f11087b.size() <= 0) {
            return i7;
        }
        f fVar = this.f11087b.get(0);
        ArrayList<f> arrayList = this.f11087b;
        return Math.max(fVar.f11125b, Math.min(i7, arrayList.get(arrayList.size() - 1).f11125b));
    }

    private void l(int i7, float f8, int i8) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.h(i7, f8, i8);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                i iVar2 = this.V.get(i9);
                if (iVar2 != null) {
                    iVar2.h(i7, f8, i8);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.h(i7, f8, i8);
        }
    }

    private void m(int i7) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.u(i7);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                i iVar2 = this.V.get(i8);
                if (iVar2 != null) {
                    iVar2.u(i7);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.u(i7);
        }
    }

    private void n(int i7) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.t(i7);
        }
        List<i> list = this.V;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                i iVar2 = this.V.get(i8);
                if (iVar2 != null) {
                    iVar2.t(i7);
                }
            }
        }
        i iVar3 = this.A0;
        if (iVar3 != null) {
            iVar3.t(i7);
        }
    }

    private void p(boolean z7) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7).setLayerType(z7 ? this.D0 : 0, null);
        }
    }

    private void q() {
        this.f11110y = false;
        this.f11111z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z7) {
        if (this.f11107v != z7) {
            this.f11107v = z7;
        }
    }

    private Rect u(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f x() {
        int i7;
        int clientWidth = getClientWidth();
        float f8 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f9 = clientWidth > 0 ? this.f11098m / clientWidth : 0.0f;
        int i8 = 0;
        boolean z7 = true;
        f fVar = null;
        int i9 = -1;
        float f10 = 0.0f;
        while (i8 < this.f11087b.size()) {
            f fVar2 = this.f11087b.get(i8);
            if (!z7 && fVar2.f11125b != (i7 = i9 + 1)) {
                fVar2 = this.f11088c;
                fVar2.f11128e = f8 + f10 + f9;
                fVar2.f11125b = i7;
                fVar2.f11127d = this.f11090e.h(i7);
                i8--;
            }
            f fVar3 = fVar2;
            f8 = fVar3.f11128e;
            float f11 = fVar3.f11127d + f8 + f9;
            if (!z7 && scrollX < f8) {
                return fVar;
            }
            if (scrollX < f11 || i8 == this.f11087b.size() - 1) {
                return fVar3;
            }
            int i10 = fVar3.f11125b;
            float f12 = fVar3.f11127d;
            i8++;
            z7 = false;
            i9 = i10;
            f10 = f12;
            fVar = fVar3;
        }
        return fVar;
    }

    public boolean B() {
        return this.N;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    @c.i
    protected void D(int i7, float f8, int i8) {
        int iMax;
        int width;
        int left;
        if (this.U > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f11112a) {
                    int i10 = layoutParams.f11113b & 7;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i11 = iMax;
                    width = paddingLeft;
                    paddingLeft = i11;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        l(i7, f8, i8);
        if (this.C0 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = getChildAt(i12);
                if (!((LayoutParams) childAt2.getLayoutParams()).f11112a) {
                    this.C0.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.T = true;
    }

    boolean F() {
        int i7 = this.f11091f;
        if (i7 <= 0) {
            return false;
        }
        setCurrentItem(i7 - 1, true);
        return true;
    }

    boolean G() {
        androidx.viewpager.widget.a aVar = this.f11090e;
        if (aVar == null || this.f11091f >= aVar.e() - 1) {
            return false;
        }
        setCurrentItem(this.f11091f + 1, true);
        return true;
    }

    void J() {
        K(this.f11091f);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f7 A[PHI: r7 r10 r15
      0x00f7: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00f7: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00f7: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    void K(int i7) {
        f fVarY;
        String hexString;
        f fVarA;
        f fVarW;
        f fVar;
        int i8 = this.f11091f;
        if (i8 != i7) {
            fVarY = y(i8);
            this.f11091f = i7;
        } else {
            fVarY = null;
        }
        if (this.f11090e == null) {
            X();
            return;
        }
        if (this.f11108w) {
            X();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.f11090e.t(this);
        int i9 = this.f11109x;
        int iMax = Math.max(0, this.f11091f - i9);
        int iE = this.f11090e.e();
        int iMin = Math.min(iE - 1, this.f11091f + i9);
        if (iE != this.f11086a) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f11086a + ", found: " + iE + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f11090e.getClass());
        }
        int i10 = 0;
        while (true) {
            if (i10 < this.f11087b.size()) {
                fVarA = this.f11087b.get(i10);
                int i11 = fVarA.f11125b;
                int i12 = this.f11091f;
                if (i11 >= i12) {
                    if (i11 != i12) {
                        break;
                    } else {
                        break;
                    }
                }
                i10++;
            }
            fVarA = null;
            break;
        }
        if (fVarA == null && iE > 0) {
            fVarA = a(this.f11091f, i10);
        }
        if (fVarA != null) {
            int i13 = i10 - 1;
            f fVar2 = i13 >= 0 ? this.f11087b.get(i13) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - fVarA.f11127d) + (getPaddingLeft() / clientWidth);
            float f8 = 0.0f;
            for (int i14 = this.f11091f - 1; i14 >= 0; i14--) {
                if (f8 < paddingLeft || i14 >= iMax) {
                    if (fVar2 == null || i14 != fVar2.f11125b) {
                        f8 += a(i14, i13 + 1).f11127d;
                        i10++;
                        if (i13 >= 0) {
                            fVar = this.f11087b.get(i13);
                        } else {
                            fVar = null;
                        }
                    } else {
                        f8 += fVar2.f11127d;
                        i13--;
                        if (i13 >= 0) {
                            fVar = this.f11087b.get(i13);
                        } else {
                            fVar = null;
                        }
                    }
                    fVar2 = fVar;
                } else {
                    if (fVar2 == null) {
                        break;
                    }
                    if (i14 == fVar2.f11125b && !fVar2.f11126c) {
                        this.f11087b.remove(i13);
                        this.f11090e.b(this, i14, fVar2.f11124a);
                        i13--;
                        i10--;
                        if (i13 >= 0) {
                            fVar = this.f11087b.get(i13);
                        } else {
                            fVar = null;
                        }
                        fVar2 = fVar;
                    }
                }
            }
            float f9 = fVarA.f11127d;
            int i15 = i10 + 1;
            if (f9 < 2.0f) {
                f fVar3 = i15 < this.f11087b.size() ? this.f11087b.get(i15) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i16 = this.f11091f;
                while (true) {
                    i16++;
                    if (i16 >= iE) {
                        break;
                    }
                    if (f9 >= paddingRight && i16 > iMin) {
                        if (fVar3 == null) {
                            break;
                        }
                        if (i16 == fVar3.f11125b && !fVar3.f11126c) {
                            this.f11087b.remove(i15);
                            this.f11090e.b(this, i16, fVar3.f11124a);
                            if (i15 < this.f11087b.size()) {
                                fVar3 = this.f11087b.get(i15);
                            }
                        }
                    } else if (fVar3 == null || i16 != fVar3.f11125b) {
                        f fVarA2 = a(i16, i15);
                        i15++;
                        f9 += fVarA2.f11127d;
                        fVar3 = i15 < this.f11087b.size() ? this.f11087b.get(i15) : null;
                    } else {
                        f9 += fVar3.f11127d;
                        i15++;
                        if (i15 < this.f11087b.size()) {
                            fVar3 = this.f11087b.get(i15);
                        }
                    }
                }
            }
            f(fVarA, i10, fVarY);
            this.f11090e.q(this, this.f11091f, fVarA.f11124a);
        }
        this.f11090e.d(this);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.f11117f = i17;
            if (!layoutParams.f11112a && layoutParams.f11114c == 0.0f && (fVarW = w(childAt)) != null) {
                layoutParams.f11114c = fVarW.f11127d;
                layoutParams.f11116e = fVarW.f11125b;
            }
        }
        X();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            f fVarV = viewFindFocus != null ? v(viewFindFocus) : null;
            if (fVarV == null || fVarV.f11125b != this.f11091f) {
                for (int i18 = 0; i18 < getChildCount(); i18++) {
                    View childAt2 = getChildAt(i18);
                    f fVarW2 = w(childAt2);
                    if (fVarW2 != null && fVarW2.f11125b == this.f11091f && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    public void N(@m0 h hVar) {
        List<h> list = this.B0;
        if (list != null) {
            list.remove(hVar);
        }
    }

    public void O(@m0 i iVar) {
        List<i> list = this.V;
        if (list != null) {
            list.remove(iVar);
        }
    }

    void S(int i7, boolean z7, boolean z8) {
        T(i7, z7, z8, 0);
    }

    void T(int i7, boolean z7, boolean z8, int i8) {
        androidx.viewpager.widget.a aVar = this.f11090e;
        if (aVar == null || aVar.e() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z8 && this.f11091f == i7 && this.f11087b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i7 < 0) {
            i7 = 0;
        } else if (i7 >= this.f11090e.e()) {
            i7 = this.f11090e.e() - 1;
        }
        int i9 = this.f11109x;
        int i10 = this.f11091f;
        if (i7 > i10 + i9 || i7 < i10 - i9) {
            for (int i11 = 0; i11 < this.f11087b.size(); i11++) {
                this.f11087b.get(i11).f11126c = true;
            }
        }
        boolean z9 = this.f11091f != i7;
        if (!this.R) {
            K(i7);
            R(i7, z7, i8, z9);
        } else {
            this.f11091f = i7;
            if (z9) {
                m(i7);
            }
            requestLayout();
        }
    }

    i U(i iVar) {
        i iVar2 = this.A0;
        this.A0 = iVar;
        return iVar2;
    }

    void V(int i7, int i8) {
        W(i7, i8, 0);
    }

    void W(int i7, int i8, int i9) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f11095j;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f11096k ? this.f11095j.getCurrX() : this.f11095j.getStartX();
            this.f11095j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i10 = scrollX;
        int scrollY = getScrollY();
        int i11 = i7 - i10;
        int i12 = i8 - scrollY;
        if (i11 == 0 && i12 == 0) {
            i(false);
            J();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i13 = clientWidth / 2;
        float f8 = clientWidth;
        float f9 = i13;
        float fO = f9 + (o(Math.min(1.0f, (Math.abs(i11) * 1.0f) / f8)) * f9);
        int iAbs2 = Math.abs(i9);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fO / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i11) / ((f8 * this.f11090e.h(this.f11091f)) + this.f11098m)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f11096k = false;
        this.f11095j.startScroll(i10, scrollY, i11, i12, iMin);
        n2.n1(this);
    }

    f a(int i7, int i8) {
        f fVar = new f();
        fVar.f11125b = i7;
        fVar.f11124a = this.f11090e.j(this, i7);
        fVar.f11127d = this.f11090e.h(i7);
        if (i8 < 0 || i8 >= this.f11087b.size()) {
            this.f11087b.add(fVar);
        } else {
            this.f11087b.add(i8, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i7, int i8) {
        f fVarW;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 0 && (fVarW = w(childAt)) != null && fVarW.f11125b == this.f11091f) {
                    childAt.addFocusables(arrayList, i7, i8);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i8 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f fVarW;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (fVarW = w(childAt)) != null && fVarW.f11125b == this.f11091f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zA = layoutParams2.f11112a | A(view);
        layoutParams2.f11112a = zA;
        if (!this.f11106u) {
            super.addView(view, i7, layoutParams);
        } else {
            if (zA) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f11115d = true;
            addViewInLayout(view, i7, layoutParams);
        }
    }

    public void b(@m0 h hVar) {
        if (this.B0 == null) {
            this.B0 = new ArrayList();
        }
        this.B0.add(hVar);
    }

    public void c(@m0 i iVar) {
        if (this.V == null) {
            this.V = new ArrayList();
        }
        this.V.add(iVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i7) {
        if (this.f11090e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i7 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f11102q));
        }
        return i7 > 0 && scrollX < ((int) (((float) clientWidth) * this.f11103r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f11096k = true;
        if (this.f11095j.isFinished() || !this.f11095j.computeScrollOffset()) {
            i(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f11095j.getCurrX();
        int currY = this.f11095j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!H(currX)) {
                this.f11095j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        n2.n1(this);
    }

    public boolean d(int i7) {
        boolean z7;
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        boolean zF = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z7 = false;
                    break;
                }
                if (parent == this) {
                    z7 = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z7) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e(I0, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i7);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i7 == 17) {
                zRequestFocus = (viewFindFocus == null || u(this.f11089d, viewFindNextFocus).left < u(this.f11089d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : F();
            } else if (i7 == 66) {
                zRequestFocus = (viewFindFocus == null || u(this.f11089d, viewFindNextFocus).left > u(this.f11089d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : G();
            }
            zF = zRequestFocus;
        } else if (i7 == 17 || i7 == 1) {
            zF = F();
        } else if (i7 == 66 || i7 == 2) {
            zF = G();
        }
        if (zF) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i7));
        }
        return zF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarW;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (fVarW = w(childAt)) != null && fVarW.f11125b == this.f11091f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f11090e) != null && aVar.e() > 1)) {
            if (!this.P.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f11102q * width);
                this.P.setSize(height, width);
                zDraw = false | this.P.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.Q.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f11103r + 1.0f)) * width2);
                this.Q.setSize(height2, width2);
                zDraw |= this.Q.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.P.finish();
            this.Q.finish();
        }
        if (zDraw) {
            n2.n1(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11099n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean e() {
        if (this.f11110y) {
            return false;
        }
        this.N = true;
        setScrollState(1);
        this.D = 0.0f;
        this.F = 0.0f;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker == null) {
            this.I = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.O = jUptimeMillis;
        return true;
    }

    protected boolean g(View view, boolean z7, int i7, int i8, int i9) {
        int i10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i11 = i8 + scrollX;
                if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && (i10 = i9 + scrollY) >= childAt.getTop() && i10 < childAt.getBottom() && g(childAt, true, i7, i11 - childAt.getLeft(), i10 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z7 && view.canScrollHorizontally(-i7);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @o0
    public androidx.viewpager.widget.a getAdapter() {
        return this.f11090e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i7, int i8) {
        if (this.E0 == 2) {
            i8 = (i7 - 1) - i8;
        }
        return ((LayoutParams) this.F0.get(i8).getLayoutParams()).f11117f;
    }

    public int getCurrentItem() {
        return this.f11091f;
    }

    public int getOffscreenPageLimit() {
        return this.f11109x;
    }

    public int getPageMargin() {
        return this.f11098m;
    }

    public void h() {
        List<i> list = this.V;
        if (list != null) {
            list.clear();
        }
    }

    void j() {
        int iE = this.f11090e.e();
        this.f11086a = iE;
        boolean z7 = this.f11087b.size() < (this.f11109x * 2) + 1 && this.f11087b.size() < iE;
        int iMax = this.f11091f;
        int i7 = 0;
        boolean z8 = false;
        while (i7 < this.f11087b.size()) {
            f fVar = this.f11087b.get(i7);
            int iF = this.f11090e.f(fVar.f11124a);
            if (iF != -1) {
                if (iF == -2) {
                    this.f11087b.remove(i7);
                    i7--;
                    if (!z8) {
                        this.f11090e.t(this);
                        z8 = true;
                    }
                    this.f11090e.b(this, fVar.f11125b, fVar.f11124a);
                    int i8 = this.f11091f;
                    if (i8 == fVar.f11125b) {
                        iMax = Math.max(0, Math.min(i8, iE - 1));
                    }
                } else {
                    int i9 = fVar.f11125b;
                    if (i9 != iF) {
                        if (i9 == this.f11091f) {
                            iMax = iF;
                        }
                        fVar.f11125b = iF;
                    }
                }
                z7 = true;
            }
            i7++;
        }
        if (z8) {
            this.f11090e.d(this);
        }
        Collections.sort(this.f11087b, R0);
        if (z7) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
                if (!layoutParams.f11112a) {
                    layoutParams.f11114c = 0.0f;
                }
            }
            S(iMax, false, true);
            requestLayout();
        }
    }

    float o(float f8) {
        return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.R = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.G0);
        Scroller scroller = this.f11095j;
        if (scroller != null && !scroller.isFinished()) {
            this.f11095j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i7;
        float f8;
        super.onDraw(canvas);
        if (this.f11098m <= 0 || this.f11099n == null || this.f11087b.size() <= 0 || this.f11090e == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f9 = width;
        float f10 = this.f11098m / f9;
        int i8 = 0;
        f fVar = this.f11087b.get(0);
        float f11 = fVar.f11128e;
        int size = this.f11087b.size();
        int i9 = fVar.f11125b;
        int i10 = this.f11087b.get(size - 1).f11125b;
        while (i9 < i10) {
            while (true) {
                i7 = fVar.f11125b;
                if (i9 <= i7 || i8 >= size) {
                    break;
                }
                i8++;
                fVar = this.f11087b.get(i8);
            }
            if (i9 == i7) {
                float f12 = fVar.f11128e;
                float f13 = fVar.f11127d;
                f8 = (f12 + f13) * f9;
                f11 = f12 + f13 + f10;
            } else {
                float fH = this.f11090e.h(i9);
                f8 = (f11 + fH) * f9;
                f11 += fH + f10;
            }
            if (this.f11098m + f8 > scrollX) {
                this.f11099n.setBounds(Math.round(f8), this.f11100o, Math.round(this.f11098m + f8), this.f11101p);
                this.f11099n.draw(canvas);
            }
            if (f8 > scrollX + width) {
                return;
            }
            i9++;
            f10 = f10;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            Q();
            return false;
        }
        if (action != 0) {
            if (this.f11110y) {
                return true;
            }
            if (this.f11111z) {
                return false;
            }
        }
        if (action == 0) {
            float x7 = motionEvent.getX();
            this.F = x7;
            this.D = x7;
            float y7 = motionEvent.getY();
            this.G = y7;
            this.E = y7;
            this.H = motionEvent.getPointerId(0);
            this.f11111z = false;
            this.f11096k = true;
            this.f11095j.computeScrollOffset();
            if (this.H0 != 2 || Math.abs(this.f11095j.getFinalX() - this.f11095j.getCurrX()) <= this.M) {
                i(false);
                this.f11110y = false;
            } else {
                this.f11095j.abortAnimation();
                this.f11108w = false;
                J();
                this.f11110y = true;
                P(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i7 = this.H;
            if (i7 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i7);
                float x8 = motionEvent.getX(iFindPointerIndex);
                float f8 = x8 - this.D;
                float fAbs = Math.abs(f8);
                float y8 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y8 - this.G);
                if (f8 != 0.0f && !C(this.D, f8) && g(this, false, (int) f8, (int) x8, (int) y8)) {
                    this.D = x8;
                    this.E = y8;
                    this.f11111z = true;
                    return false;
                }
                int i8 = this.C;
                if (fAbs > i8 && fAbs * 0.5f > fAbs2) {
                    this.f11110y = true;
                    P(true);
                    setScrollState(1);
                    float f9 = this.F;
                    float f10 = this.C;
                    this.D = f8 > 0.0f ? f9 + f10 : f9 - f10;
                    this.E = y8;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i8) {
                    this.f11111z = true;
                }
                if (this.f11110y && I(x8)) {
                    n2.n1(this);
                }
            }
        } else if (action == 6) {
            E(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        return this.f11110y;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        boolean z8;
        f fVarW;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f11112a) {
                    int i15 = layoutParams.f11113b;
                    int i16 = i15 & 7;
                    int i17 = i15 & 112;
                    if (i16 != 1) {
                        if (i16 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i16 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i11 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i17 != 16) {
                            if (i17 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i17 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i12 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i18 = paddingLeft + scrollX;
                            childAt.layout(i18, paddingTop, childAt.getMeasuredWidth() + i18, paddingTop + childAt.getMeasuredHeight());
                            i13++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i12 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i19 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i19;
                        int i110 = paddingLeft + scrollX;
                        childAt.layout(i110, paddingTop, childAt.getMeasuredWidth() + i110, paddingTop + childAt.getMeasuredHeight());
                        i13++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i11 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i20 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i20;
                    if (i17 != 16) {
                        if (i17 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i17 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i12 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i111 = paddingLeft + scrollX;
                        childAt.layout(i111, paddingTop, childAt.getMeasuredWidth() + i111, paddingTop + childAt.getMeasuredHeight());
                        i13++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i12 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i112 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i112;
                    int i113 = paddingLeft + scrollX;
                    childAt.layout(i113, paddingTop, childAt.getMeasuredWidth() + i113, paddingTop + childAt.getMeasuredHeight());
                    i13++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i21 = (i11 - paddingLeft) - paddingRight;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f11112a && (fVarW = w(childAt2)) != null) {
                    float f8 = i21;
                    int i23 = ((int) (fVarW.f11128e * f8)) + paddingLeft;
                    if (layoutParams2.f11115d) {
                        layoutParams2.f11115d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f8 * layoutParams2.f11114c), 1073741824), View.MeasureSpec.makeMeasureSpec((i12 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i23, paddingTop, childAt2.getMeasuredWidth() + i23, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f11100o = paddingTop;
        this.f11101p = i12 - paddingBottom;
        this.U = i13;
        if (this.R) {
            z8 = false;
            R(this.f11091f, false, 0, false);
        } else {
            z8 = false;
        }
        this.R = z8;
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i9;
        setMeasuredDimension(View.getDefaultSize(0, i7), View.getDefaultSize(0, i8));
        int measuredWidth = getMeasuredWidth();
        this.B = Math.min(measuredWidth / 10, this.A);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            boolean z7 = true;
            int i11 = 1073741824;
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f11112a) {
                int i12 = layoutParams2.f11113b;
                int i13 = i12 & 7;
                int i14 = i12 & 112;
                boolean z8 = i14 == 48 || i14 == 80;
                if (i13 != 3 && i13 != 5) {
                    z7 = false;
                }
                int i15 = Integer.MIN_VALUE;
                if (z8) {
                    i9 = Integer.MIN_VALUE;
                    i15 = 1073741824;
                } else {
                    i9 = z7 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i16 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i16 != -2) {
                    if (i16 == -1) {
                        i16 = paddingLeft;
                    }
                    i15 = 1073741824;
                } else {
                    i16 = paddingLeft;
                }
                int i17 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i17 == -2) {
                    i17 = measuredHeight;
                    i11 = i9;
                } else if (i17 == -1) {
                    i17 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i16, i15), View.MeasureSpec.makeMeasureSpec(i17, i11));
                if (z8) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z7) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i10++;
        }
        this.f11104s = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f11105t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f11106u = true;
        J();
        this.f11106u = false;
        int childCount2 = getChildCount();
        for (int i18 = 0; i18 < childCount2; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f11112a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f11114c), 1073741824), this.f11105t);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i7, Rect rect) {
        int i8;
        int i9;
        int i10;
        f fVarW;
        int childCount = getChildCount();
        if ((i7 & 2) != 0) {
            i9 = childCount;
            i8 = 0;
            i10 = 1;
        } else {
            i8 = childCount - 1;
            i9 = -1;
            i10 = -1;
        }
        while (i8 != i9) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && (fVarW = w(childAt)) != null && fVarW.f11125b == this.f11091f && childAt.requestFocus(i7, rect)) {
                return true;
            }
            i8 += i10;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        androidx.viewpager.widget.a aVar = this.f11090e;
        if (aVar != null) {
            aVar.n(savedState.f11119d, savedState.f11120e);
            S(savedState.f11118c, false, true);
        } else {
            this.f11092g = savedState.f11118c;
            this.f11093h = savedState.f11119d;
            this.f11094i = savedState.f11120e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11118c = this.f11091f;
        androidx.viewpager.widget.a aVar = this.f11090e;
        if (aVar != null) {
            savedState.f11119d = aVar.o();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 != i9) {
            int i11 = this.f11098m;
            L(i7, i9, i11, i11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00dc  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        if (this.N) {
            return true;
        }
        boolean zQ = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f11090e) == null || aVar.e() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f11095j.abortAnimation();
            this.f11108w = false;
            J();
            float x7 = motionEvent.getX();
            this.F = x7;
            this.D = x7;
            float y7 = motionEvent.getY();
            this.G = y7;
            this.E = y7;
            this.H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.D = motionEvent.getX(actionIndex);
                        this.H = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        E(motionEvent);
                        this.D = motionEvent.getX(motionEvent.findPointerIndex(this.H));
                    }
                } else if (this.f11110y) {
                    R(this.f11091f, true, 0, false);
                    zQ = Q();
                }
            } else if (!this.f11110y) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.H);
                if (iFindPointerIndex == -1) {
                    zQ = Q();
                } else {
                    float x8 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x8 - this.D);
                    float y8 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y8 - this.E);
                    if (fAbs > this.C && fAbs > fAbs2) {
                        this.f11110y = true;
                        P(true);
                        float f8 = this.F;
                        this.D = x8 - f8 > 0.0f ? f8 + this.C : f8 - this.C;
                        this.E = y8;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.f11110y) {
                        zQ = false | I(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
                    }
                }
            } else if (this.f11110y) {
                zQ = false | I(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
            }
        } else if (this.f11110y) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.f11108w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarX = x();
            float f9 = clientWidth;
            T(k(fVarX.f11125b, ((scrollX / f9) - fVarX.f11128e) / (fVarX.f11127d + (this.f11098m / f9)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.H)) - this.F)), true, true, xVelocity);
            zQ = Q();
        }
        if (zQ) {
            n2.n1(this);
        }
        return true;
    }

    public void r() {
        if (!this.N) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f11090e != null) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.f11108w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarX = x();
            T(k(fVarX.f11125b, ((scrollX / clientWidth) - fVarX.f11128e) / fVarX.f11127d, xVelocity, (int) (this.D - this.F)), true, true, xVelocity);
        }
        q();
        this.N = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f11106u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public boolean s(@m0 KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? F() : d(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? G() : d(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return d(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return d(1);
                }
            }
        }
        return false;
    }

    public void setAdapter(@o0 androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f11090e;
        if (aVar2 != null) {
            aVar2.r(null);
            this.f11090e.t(this);
            for (int i7 = 0; i7 < this.f11087b.size(); i7++) {
                f fVar = this.f11087b.get(i7);
                this.f11090e.b(this, fVar.f11125b, fVar.f11124a);
            }
            this.f11090e.d(this);
            this.f11087b.clear();
            M();
            this.f11091f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f11090e;
        this.f11090e = aVar;
        this.f11086a = 0;
        if (aVar != null) {
            if (this.f11097l == null) {
                this.f11097l = new k();
            }
            this.f11090e.r(this.f11097l);
            this.f11108w = false;
            boolean z7 = this.R;
            this.R = true;
            this.f11086a = this.f11090e.e();
            if (this.f11092g >= 0) {
                this.f11090e.n(this.f11093h, this.f11094i);
                S(this.f11092g, false, true);
                this.f11092g = -1;
                this.f11093h = null;
                this.f11094i = null;
            } else if (z7) {
                requestLayout();
            } else {
                J();
            }
        }
        List<h> list = this.B0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.B0.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.B0.get(i8).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i7) {
        this.f11108w = false;
        S(i7, !this.R, false);
    }

    public void setOffscreenPageLimit(int i7) {
        if (i7 < 1) {
            Log.w(I0, "Requested offscreen page limit " + i7 + " too small; defaulting to 1");
            i7 = 1;
        }
        if (i7 != this.f11109x) {
            this.f11109x = i7;
            J();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.W = iVar;
    }

    public void setPageMargin(int i7) {
        int i8 = this.f11098m;
        this.f11098m = i7;
        int width = getWidth();
        L(width, width, i7, i8);
        requestLayout();
    }

    public void setPageMarginDrawable(@o0 Drawable drawable) {
        this.f11099n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z7, @o0 j jVar) {
        setPageTransformer(z7, jVar, 2);
    }

    void setScrollState(int i7) {
        if (this.H0 == i7) {
            return;
        }
        this.H0 = i7;
        if (this.C0 != null) {
            p(i7 != 0);
        }
        n(i7);
    }

    public void t(float f8) {
        if (!this.N) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f11090e == null) {
            return;
        }
        this.D += f8;
        float scrollX = getScrollX() - f8;
        float clientWidth = getClientWidth();
        float f9 = this.f11102q * clientWidth;
        float f10 = this.f11103r * clientWidth;
        f fVar = this.f11087b.get(0);
        ArrayList<f> arrayList = this.f11087b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f11125b != 0) {
            f9 = fVar.f11128e * clientWidth;
        }
        if (fVar2.f11125b != this.f11090e.e() - 1) {
            f10 = fVar2.f11128e * clientWidth;
        }
        if (scrollX < f9) {
            scrollX = f9;
        } else if (scrollX > f10) {
            scrollX = f10;
        }
        int i7 = (int) scrollX;
        this.D += scrollX - i7;
        scrollTo(i7, getScrollY());
        H(i7);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.O, SystemClock.uptimeMillis(), 2, this.D, 0.0f, 0);
        this.I.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    f v(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return w(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11099n;
    }

    f w(View view) {
        for (int i7 = 0; i7 < this.f11087b.size(); i7++) {
            f fVar = this.f11087b.get(i7);
            if (this.f11090e.k(view, fVar.f11124a)) {
                return fVar;
            }
        }
        return null;
    }

    f y(int i7) {
        for (int i8 = 0; i8 < this.f11087b.size(); i8++) {
            f fVar = this.f11087b.get(i8);
            if (fVar.f11125b == i7) {
                return fVar;
            }
        }
        return null;
    }

    void z() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f11095j = new Scroller(context, S0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.f11085J = (int) (400.0f * f8);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.P = new EdgeEffect(context);
        this.Q = new EdgeEffect(context);
        this.L = (int) (25.0f * f8);
        this.M = (int) (2.0f * f8);
        this.A = (int) (f8 * 16.0f);
        n2.B1(this, new g());
        if (n2.V(this) == 0) {
            n2.R1(this, 1);
        }
        n2.a2(this, new d());
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f11114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f11116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11117f;

        public LayoutParams() {
            super(-1, -1);
            this.f11114c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11114c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.Q0);
            this.f11113b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z7, @o0 j jVar, int i7) {
        boolean z8 = jVar != null;
        boolean z9 = z8 != (this.C0 != null);
        this.C0 = jVar;
        setChildrenDrawingOrderEnabled(z8);
        if (z8) {
            this.E0 = z7 ? 2 : 1;
            this.D0 = i7;
        } else {
            this.E0 = 0;
        }
        if (z9) {
            J();
        }
    }

    public void setCurrentItem(int i7, boolean z7) {
        this.f11108w = false;
        S(i7, z7, false);
    }

    public void setPageMarginDrawable(@u int i7) {
        setPageMarginDrawable(androidx.core.content.d.i(getContext(), i7));
    }

    public ViewPager(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11087b = new ArrayList<>();
        this.f11088c = new f();
        this.f11089d = new Rect();
        this.f11092g = -1;
        this.f11093h = null;
        this.f11094i = null;
        this.f11102q = -3.4028235E38f;
        this.f11103r = Float.MAX_VALUE;
        this.f11109x = 1;
        this.H = -1;
        this.R = true;
        this.S = false;
        this.G0 = new c();
        this.H0 = 0;
        z();
    }
}
