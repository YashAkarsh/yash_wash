package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.l0;
import c.m0;
import c.o0;
import c.x0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private static final String Q = "StaggeredGridLManager";
    static final boolean R = false;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 0;

    @Deprecated
    public static final int V = 1;
    public static final int W = 2;
    static final int X = Integer.MIN_VALUE;
    private static final float Y = 0.33333334f;
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f9258J;
    private int[] O;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    c[] f9260t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @m0
    w f9261u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @m0
    w f9262v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f9263w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f9264x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @m0
    private final p f9265y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9259s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f9266z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f9267g = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c f9268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f9269f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int h() {
            c cVar = this.f9268e;
            if (cVar == null) {
                return -1;
            }
            return cVar.f9300e;
        }

        public boolean i() {
            return this.f9269f;
        }

        public void j(boolean z7) {
            this.f9269f = z7;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @x0({x0.a.LIBRARY})
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int[] f9280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f9282f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f9283g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f9284h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f9285i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9286j;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState() {
        }

        void a() {
            this.f9280d = null;
            this.f9279c = 0;
            this.f9277a = -1;
            this.f9278b = -1;
        }

        void b() {
            this.f9280d = null;
            this.f9279c = 0;
            this.f9281e = 0;
            this.f9282f = null;
            this.f9283g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f9277a);
            parcel.writeInt(this.f9278b);
            parcel.writeInt(this.f9279c);
            if (this.f9279c > 0) {
                parcel.writeIntArray(this.f9280d);
            }
            parcel.writeInt(this.f9281e);
            if (this.f9281e > 0) {
                parcel.writeIntArray(this.f9282f);
            }
            parcel.writeInt(this.f9284h ? 1 : 0);
            parcel.writeInt(this.f9285i ? 1 : 0);
            parcel.writeInt(this.f9286j ? 1 : 0);
            parcel.writeList(this.f9283g);
        }

        SavedState(Parcel parcel) {
            this.f9277a = parcel.readInt();
            this.f9278b = parcel.readInt();
            int i7 = parcel.readInt();
            this.f9279c = i7;
            if (i7 > 0) {
                int[] iArr = new int[i7];
                this.f9280d = iArr;
                parcel.readIntArray(iArr);
            }
            int i8 = parcel.readInt();
            this.f9281e = i8;
            if (i8 > 0) {
                int[] iArr2 = new int[i8];
                this.f9282f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f9284h = parcel.readInt() == 1;
            this.f9285i = parcel.readInt() == 1;
            this.f9286j = parcel.readInt() == 1;
            this.f9283g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f9279c = savedState.f9279c;
            this.f9277a = savedState.f9277a;
            this.f9278b = savedState.f9278b;
            this.f9280d = savedState.f9280d;
            this.f9281e = savedState.f9281e;
            this.f9282f = savedState.f9282f;
            this.f9284h = savedState.f9284h;
            this.f9285i = savedState.f9285i;
            this.f9286j = savedState.f9286j;
            this.f9283g = savedState.f9283g;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.q2();
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f9292e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f9293f;

        b() {
            c();
        }

        void a() {
            this.f9289b = this.f9290c ? StaggeredGridLayoutManager.this.f9261u.i() : StaggeredGridLayoutManager.this.f9261u.n();
        }

        void b(int i7) {
            if (this.f9290c) {
                this.f9289b = StaggeredGridLayoutManager.this.f9261u.i() - i7;
            } else {
                this.f9289b = StaggeredGridLayoutManager.this.f9261u.n() + i7;
            }
        }

        void c() {
            this.f9288a = -1;
            this.f9289b = Integer.MIN_VALUE;
            this.f9290c = false;
            this.f9291d = false;
            this.f9292e = false;
            int[] iArr = this.f9293f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f9293f;
            if (iArr == null || iArr.length < length) {
                this.f9293f = new int[StaggeredGridLayoutManager.this.f9260t.length];
            }
            for (int i7 = 0; i7 < length; i7++) {
                this.f9293f[i7] = cVarArr[i7].u(Integer.MIN_VALUE);
            }
        }
    }

    class c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f9295g = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<View> f9296a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9297b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9298c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9299d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f9300e;

        c(int i7) {
            this.f9300e = i7;
        }

        void A(int i7) {
            this.f9297b = i7;
            this.f9298c = i7;
        }

        void a(View view) {
            LayoutParams layoutParamsS = s(view);
            layoutParamsS.f9268e = this;
            this.f9296a.add(view);
            this.f9298c = Integer.MIN_VALUE;
            if (this.f9296a.size() == 1) {
                this.f9297b = Integer.MIN_VALUE;
            }
            if (layoutParamsS.e() || layoutParamsS.d()) {
                this.f9299d += StaggeredGridLayoutManager.this.f9261u.e(view);
            }
        }

        void b(boolean z7, int i7) {
            int iQ = z7 ? q(Integer.MIN_VALUE) : u(Integer.MIN_VALUE);
            e();
            if (iQ == Integer.MIN_VALUE) {
                return;
            }
            if (!z7 || iQ >= StaggeredGridLayoutManager.this.f9261u.i()) {
                if (z7 || iQ <= StaggeredGridLayoutManager.this.f9261u.n()) {
                    if (i7 != Integer.MIN_VALUE) {
                        iQ += i7;
                    }
                    this.f9298c = iQ;
                    this.f9297b = iQ;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList<View> arrayList = this.f9296a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParamsS = s(view);
            this.f9298c = StaggeredGridLayoutManager.this.f9261u.d(view);
            if (layoutParamsS.f9269f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsS.b())) != null && fullSpanItemF.f9274b == 1) {
                this.f9298c += fullSpanItemF.a(this.f9300e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.f9296a.get(0);
            LayoutParams layoutParamsS = s(view);
            this.f9297b = StaggeredGridLayoutManager.this.f9261u.g(view);
            if (layoutParamsS.f9269f && (fullSpanItemF = StaggeredGridLayoutManager.this.E.f(layoutParamsS.b())) != null && fullSpanItemF.f9274b == -1) {
                this.f9297b -= fullSpanItemF.a(this.f9300e);
            }
        }

        void e() {
            this.f9296a.clear();
            v();
            this.f9299d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f9266z ? n(this.f9296a.size() - 1, -1, true) : n(0, this.f9296a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f9266z ? m(this.f9296a.size() - 1, -1, true) : m(0, this.f9296a.size(), true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.f9266z ? n(this.f9296a.size() - 1, -1, false) : n(0, this.f9296a.size(), false);
        }

        public int i() {
            return StaggeredGridLayoutManager.this.f9266z ? n(0, this.f9296a.size(), true) : n(this.f9296a.size() - 1, -1, true);
        }

        public int j() {
            return StaggeredGridLayoutManager.this.f9266z ? m(0, this.f9296a.size(), true) : m(this.f9296a.size() - 1, -1, true);
        }

        public int k() {
            return StaggeredGridLayoutManager.this.f9266z ? n(0, this.f9296a.size(), false) : n(this.f9296a.size() - 1, -1, false);
        }

        int l(int i7, int i8, boolean z7, boolean z8, boolean z9) {
            int iN = StaggeredGridLayoutManager.this.f9261u.n();
            int i9 = StaggeredGridLayoutManager.this.f9261u.i();
            int i10 = i8 > i7 ? 1 : -1;
            while (i7 != i8) {
                View view = this.f9296a.get(i7);
                int iG = StaggeredGridLayoutManager.this.f9261u.g(view);
                int iD = StaggeredGridLayoutManager.this.f9261u.d(view);
                boolean z10 = false;
                boolean z11 = !z9 ? iG >= i9 : iG > i9;
                if (!z9 ? iD > iN : iD >= iN) {
                    z10 = true;
                }
                if (z11 && z10) {
                    if (z7 && z8) {
                        if (iG >= iN && iD <= i9) {
                            return StaggeredGridLayoutManager.this.s0(view);
                        }
                    } else {
                        if (z8) {
                            return StaggeredGridLayoutManager.this.s0(view);
                        }
                        if (iG < iN || iD > i9) {
                            return StaggeredGridLayoutManager.this.s0(view);
                        }
                    }
                }
                i7 += i10;
            }
            return -1;
        }

        int m(int i7, int i8, boolean z7) {
            return l(i7, i8, false, false, z7);
        }

        int n(int i7, int i8, boolean z7) {
            return l(i7, i8, z7, true, false);
        }

        public int o() {
            return this.f9299d;
        }

        int p() {
            int i7 = this.f9298c;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            c();
            return this.f9298c;
        }

        int q(int i7) {
            int i8 = this.f9298c;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            if (this.f9296a.size() == 0) {
                return i7;
            }
            c();
            return this.f9298c;
        }

        public View r(int i7, int i8) {
            View view = null;
            if (i8 != -1) {
                int size = this.f9296a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f9296a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f9266z && staggeredGridLayoutManager.s0(view2) >= i7) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f9266z && staggeredGridLayoutManager2.s0(view2) <= i7) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f9296a.size();
                int i9 = 0;
                while (i9 < size2) {
                    View view3 = this.f9296a.get(i9);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f9266z && staggeredGridLayoutManager3.s0(view3) <= i7) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f9266z && staggeredGridLayoutManager4.s0(view3) >= i7) || !view3.hasFocusable()) {
                        break;
                    }
                    i9++;
                    view = view3;
                }
            }
            return view;
        }

        LayoutParams s(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int t() {
            int i7 = this.f9297b;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            d();
            return this.f9297b;
        }

        int u(int i7) {
            int i8 = this.f9297b;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            if (this.f9296a.size() == 0) {
                return i7;
            }
            d();
            return this.f9297b;
        }

        void v() {
            this.f9297b = Integer.MIN_VALUE;
            this.f9298c = Integer.MIN_VALUE;
        }

        void w(int i7) {
            int i8 = this.f9297b;
            if (i8 != Integer.MIN_VALUE) {
                this.f9297b = i8 + i7;
            }
            int i9 = this.f9298c;
            if (i9 != Integer.MIN_VALUE) {
                this.f9298c = i9 + i7;
            }
        }

        void x() {
            int size = this.f9296a.size();
            View viewRemove = this.f9296a.remove(size - 1);
            LayoutParams layoutParamsS = s(viewRemove);
            layoutParamsS.f9268e = null;
            if (layoutParamsS.e() || layoutParamsS.d()) {
                this.f9299d -= StaggeredGridLayoutManager.this.f9261u.e(viewRemove);
            }
            if (size == 1) {
                this.f9297b = Integer.MIN_VALUE;
            }
            this.f9298c = Integer.MIN_VALUE;
        }

        void y() {
            View viewRemove = this.f9296a.remove(0);
            LayoutParams layoutParamsS = s(viewRemove);
            layoutParamsS.f9268e = null;
            if (this.f9296a.size() == 0) {
                this.f9298c = Integer.MIN_VALUE;
            }
            if (layoutParamsS.e() || layoutParamsS.d()) {
                this.f9299d -= StaggeredGridLayoutManager.this.f9261u.e(viewRemove);
            }
            this.f9297b = Integer.MIN_VALUE;
        }

        void z(View view) {
            LayoutParams layoutParamsS = s(view);
            layoutParamsS.f9268e = this;
            this.f9296a.add(0, view);
            this.f9297b = Integer.MIN_VALUE;
            if (this.f9296a.size() == 1) {
                this.f9298c = Integer.MIN_VALUE;
            }
            if (layoutParamsS.e() || layoutParamsS.d()) {
                this.f9299d += StaggeredGridLayoutManager.this.f9261u.e(view);
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        RecyclerView.o.d dVarT0 = RecyclerView.o.t0(context, attributeSet, i7, i8);
        p3(dVarT0.f9220a);
        r3(dVarT0.f9221b);
        q3(dVarT0.f9222c);
        this.f9265y = new p();
        y2();
    }

    private int B2(int i7) {
        int iQ = Q();
        for (int i8 = 0; i8 < iQ; i8++) {
            int iS0 = s0(P(i8));
            if (iS0 >= 0 && iS0 < i7) {
                return iS0;
            }
        }
        return 0;
    }

    private int H2(int i7) {
        for (int iQ = Q() - 1; iQ >= 0; iQ--) {
            int iS0 = s0(P(iQ));
            if (iS0 >= 0 && iS0 < i7) {
                return iS0;
            }
        }
        return 0;
    }

    private void J2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z7) {
        int i7;
        int iO2 = O2(Integer.MIN_VALUE);
        if (iO2 != Integer.MIN_VALUE && (i7 = this.f9261u.i() - iO2) > 0) {
            int i8 = i7 - (-l3(-i7, vVar, a0Var));
            if (!z7 || i8 <= 0) {
                return;
            }
            this.f9261u.t(i8);
        }
    }

    private void K2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z7) {
        int iN;
        int iR2 = R2(Integer.MAX_VALUE);
        if (iR2 != Integer.MAX_VALUE && (iN = iR2 - this.f9261u.n()) > 0) {
            int iL3 = iN - l3(iN, vVar, a0Var);
            if (!z7 || iL3 <= 0) {
                return;
            }
            this.f9261u.t(-iL3);
        }
    }

    private int O2(int i7) {
        int iQ = this.f9260t[0].q(i7);
        for (int i8 = 1; i8 < this.f9259s; i8++) {
            int iQ2 = this.f9260t[i8].q(i7);
            if (iQ2 > iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    private int P2(int i7) {
        int iU = this.f9260t[0].u(i7);
        for (int i8 = 1; i8 < this.f9259s; i8++) {
            int iU2 = this.f9260t[i8].u(i7);
            if (iU2 > iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    private int Q2(int i7) {
        int iQ = this.f9260t[0].q(i7);
        for (int i8 = 1; i8 < this.f9259s; i8++) {
            int iQ2 = this.f9260t[i8].q(i7);
            if (iQ2 < iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    private int R2(int i7) {
        int iU = this.f9260t[0].u(i7);
        for (int i8 = 1; i8 < this.f9259s; i8++) {
            int iU2 = this.f9260t[i8].u(i7);
            if (iU2 < iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    private c S2(p pVar) {
        int i7;
        int i8;
        int i9;
        if (d3(pVar.f9680e)) {
            i8 = this.f9259s - 1;
            i7 = -1;
            i9 = -1;
        } else {
            i7 = this.f9259s;
            i8 = 0;
            i9 = 1;
        }
        c cVar = null;
        if (pVar.f9680e == 1) {
            int iN = this.f9261u.n();
            int i10 = Integer.MAX_VALUE;
            while (i8 != i7) {
                c cVar2 = this.f9260t[i8];
                int iQ = cVar2.q(iN);
                if (iQ < i10) {
                    cVar = cVar2;
                    i10 = iQ;
                }
                i8 += i9;
            }
            return cVar;
        }
        int i11 = this.f9261u.i();
        int i12 = Integer.MIN_VALUE;
        while (i8 != i7) {
            c cVar3 = this.f9260t[i8];
            int iU = cVar3.u(i11);
            if (iU > i12) {
                cVar = cVar3;
                i12 = iU;
            }
            i8 += i9;
        }
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void W2(int i7, int i8, int i9) {
        int i10;
        int i11;
        int iN2;
        int iN3 = this.A ? N2() : L2();
        if (i9 == 8) {
            if (i7 < i8) {
                i10 = i8 + 1;
            } else {
                i10 = i7 + 1;
                i11 = i8;
            }
            this.E.h(i11);
            if (i9 != 1) {
                this.E.j(i7, i8);
            } else if (i9 != 2) {
                this.E.k(i7, i8);
            } else if (i9 == 8) {
                this.E.k(i7, 1);
                this.E.j(i8, 1);
            }
            if (i10 <= iN3) {
                return;
            }
            if (this.A) {
                iN2 = L2();
            } else {
                iN2 = N2();
            }
            if (i11 <= iN2) {
                N1();
            }
        }
        i10 = i7 + i8;
        i11 = i7;
        this.E.h(i11);
        if (i9 != 1) {
            this.E.j(i7, i8);
        } else if (i9 != 2) {
            this.E.k(i7, i8);
        } else if (i9 == 8) {
            this.E.k(i7, 1);
            this.E.j(i8, 1);
        }
        if (i10 <= iN3) {
            return;
        }
        if (this.A) {
            iN2 = L2();
        } else {
            iN2 = N2();
        }
        if (i11 <= iN2) {
            N1();
        }
    }

    private void a3(View view, int i7, int i8, boolean z7) {
        m(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.K;
        int iZ3 = z3(i7, i9 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.K;
        int iZ4 = z3(i8, i10 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z7 ? e2(view, iZ3, iZ4, layoutParams) : c2(view, iZ3, iZ4, layoutParams)) {
            view.measure(iZ3, iZ4);
        }
    }

    private void b3(View view, LayoutParams layoutParams, boolean z7) {
        if (layoutParams.f9269f) {
            if (this.f9263w == 1) {
                a3(view, this.f9258J, RecyclerView.o.R(e0(), f0(), r0() + m0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z7);
                return;
            } else {
                a3(view, RecyclerView.o.R(z0(), A0(), o0() + p0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.f9258J, z7);
                return;
            }
        }
        if (this.f9263w == 1) {
            a3(view, RecyclerView.o.R(this.f9264x, A0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.o.R(e0(), f0(), r0() + m0(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z7);
        } else {
            a3(view, RecyclerView.o.R(z0(), A0(), o0() + p0(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.o.R(this.f9264x, f0(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z7);
        }
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015a  */
    private void c3(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z7) {
        boolean z8;
        SavedState savedState;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && a0Var.d() == 0) {
            D1(vVar);
            bVar.c();
            return;
        }
        boolean z9 = (bVar.f9292e && this.C == -1 && this.I == null) ? false : true;
        if (z9) {
            bVar.c();
            if (this.I != null) {
                l2(bVar);
            } else {
                k3();
                bVar.f9290c = this.A;
            }
            v3(a0Var, bVar);
            bVar.f9292e = true;
        }
        if (this.I == null && this.C == -1 && (bVar.f9290c != this.G || Z2() != this.H)) {
            this.E.b();
            bVar.f9291d = true;
        }
        if (Q() > 0 && ((savedState = this.I) == null || savedState.f9279c < 1)) {
            if (bVar.f9291d) {
                for (int i7 = 0; i7 < this.f9259s; i7++) {
                    this.f9260t[i7].e();
                    int i8 = bVar.f9289b;
                    if (i8 != Integer.MIN_VALUE) {
                        this.f9260t[i7].A(i8);
                    }
                }
            } else if (z9 || this.L.f9293f == null) {
                for (int i9 = 0; i9 < this.f9259s; i9++) {
                    this.f9260t[i9].b(this.A, bVar.f9289b);
                }
                this.L.d(this.f9260t);
            } else {
                for (int i10 = 0; i10 < this.f9259s; i10++) {
                    c cVar = this.f9260t[i10];
                    cVar.e();
                    cVar.A(this.L.f9293f[i10]);
                }
            }
        }
        z(vVar);
        this.f9265y.f9676a = false;
        this.M = false;
        x3(this.f9262v.o());
        w3(bVar.f9288a, a0Var);
        if (bVar.f9290c) {
            o3(-1);
            z2(vVar, this.f9265y, a0Var);
            o3(1);
            p pVar = this.f9265y;
            pVar.f9678c = bVar.f9288a + pVar.f9679d;
            z2(vVar, pVar, a0Var);
        } else {
            o3(1);
            z2(vVar, this.f9265y, a0Var);
            o3(-1);
            p pVar2 = this.f9265y;
            pVar2.f9678c = bVar.f9288a + pVar2.f9679d;
            z2(vVar, pVar2, a0Var);
        }
        j3();
        if (Q() > 0) {
            if (this.A) {
                J2(vVar, a0Var, true);
                K2(vVar, a0Var, false);
            } else {
                K2(vVar, a0Var, true);
                J2(vVar, a0Var, false);
            }
        }
        if (z7 && !a0Var.j()) {
            if (this.F != 0 && Q() > 0 && (this.M || X2() != null)) {
                H1(this.P);
                z8 = q2();
            }
        }
        if (a0Var.j()) {
            this.L.c();
        }
        this.G = bVar.f9290c;
        this.H = Z2();
        if (z8) {
            this.L.c();
            c3(vVar, a0Var, false);
        }
    }

    private boolean d3(int i7) {
        if (this.f9263w == 0) {
            return (i7 == -1) != this.A;
        }
        return ((i7 == -1) == this.A) == Z2();
    }

    private void f3(View view) {
        for (int i7 = this.f9259s - 1; i7 >= 0; i7--) {
            this.f9260t[i7].z(view);
        }
    }

    private void g3(RecyclerView.v vVar, p pVar) {
        int iMin;
        if (!pVar.f9676a || pVar.f9684i) {
            return;
        }
        if (pVar.f9677b == 0) {
            if (pVar.f9680e == -1) {
                h3(vVar, pVar.f9682g);
                return;
            } else {
                i3(vVar, pVar.f9681f);
                return;
            }
        }
        if (pVar.f9680e == -1) {
            int i7 = pVar.f9681f;
            int iP2 = i7 - P2(i7);
            h3(vVar, iP2 < 0 ? pVar.f9682g : pVar.f9682g - Math.min(iP2, pVar.f9677b));
        } else {
            int iQ2 = Q2(pVar.f9682g) - pVar.f9682g;
            if (iQ2 < 0) {
                iMin = pVar.f9681f;
            } else {
                iMin = Math.min(iQ2, pVar.f9677b) + pVar.f9681f;
            }
            i3(vVar, iMin);
        }
    }

    private void h3(RecyclerView.v vVar, int i7) {
        for (int iQ = Q() - 1; iQ >= 0; iQ--) {
            View viewP = P(iQ);
            if (this.f9261u.g(viewP) < i7 || this.f9261u.r(viewP) < i7) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewP.getLayoutParams();
            if (layoutParams.f9269f) {
                for (int i8 = 0; i8 < this.f9259s; i8++) {
                    if (this.f9260t[i8].f9296a.size() == 1) {
                        return;
                    }
                }
                for (int i9 = 0; i9 < this.f9259s; i9++) {
                    this.f9260t[i9].x();
                }
            } else if (layoutParams.f9268e.f9296a.size() == 1) {
                return;
            } else {
                layoutParams.f9268e.x();
            }
            F1(viewP, vVar);
        }
    }

    private void i3(RecyclerView.v vVar, int i7) {
        while (Q() > 0) {
            View viewP = P(0);
            if (this.f9261u.d(viewP) > i7 || this.f9261u.q(viewP) > i7) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewP.getLayoutParams();
            if (layoutParams.f9269f) {
                for (int i8 = 0; i8 < this.f9259s; i8++) {
                    if (this.f9260t[i8].f9296a.size() == 1) {
                        return;
                    }
                }
                for (int i9 = 0; i9 < this.f9259s; i9++) {
                    this.f9260t[i9].y();
                }
            } else if (layoutParams.f9268e.f9296a.size() == 1) {
                return;
            } else {
                layoutParams.f9268e.y();
            }
            F1(viewP, vVar);
        }
    }

    private void j3() {
        if (this.f9262v.l() == 1073741824) {
            return;
        }
        int iQ = Q();
        float fMax = 0.0f;
        for (int i7 = 0; i7 < iQ; i7++) {
            View viewP = P(i7);
            float fE = this.f9262v.e(viewP);
            if (fE >= fMax) {
                if (((LayoutParams) viewP.getLayoutParams()).i()) {
                    fE = (fE * 1.0f) / this.f9259s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i8 = this.f9264x;
        int iRound = Math.round(fMax * this.f9259s);
        if (this.f9262v.l() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f9262v.o());
        }
        x3(iRound);
        if (this.f9264x == i8) {
            return;
        }
        for (int i9 = 0; i9 < iQ; i9++) {
            View viewP2 = P(i9);
            LayoutParams layoutParams = (LayoutParams) viewP2.getLayoutParams();
            if (!layoutParams.f9269f) {
                if (Z2() && this.f9263w == 1) {
                    int i10 = this.f9259s;
                    int i11 = layoutParams.f9268e.f9300e;
                    viewP2.offsetLeftAndRight(((-((i10 - 1) - i11)) * this.f9264x) - ((-((i10 - 1) - i11)) * i8));
                } else {
                    int i12 = layoutParams.f9268e.f9300e;
                    int i13 = this.f9264x * i12;
                    int i14 = i12 * i8;
                    if (this.f9263w == 1) {
                        viewP2.offsetLeftAndRight(i13 - i14);
                    } else {
                        viewP2.offsetTopAndBottom(i13 - i14);
                    }
                }
            }
        }
    }

    private void k2(View view) {
        for (int i7 = this.f9259s - 1; i7 >= 0; i7--) {
            this.f9260t[i7].a(view);
        }
    }

    private void k3() {
        if (this.f9263w == 1 || !Z2()) {
            this.A = this.f9266z;
        } else {
            this.A = !this.f9266z;
        }
    }

    private void l2(b bVar) {
        SavedState savedState = this.I;
        int i7 = savedState.f9279c;
        if (i7 > 0) {
            if (i7 == this.f9259s) {
                for (int i8 = 0; i8 < this.f9259s; i8++) {
                    this.f9260t[i8].e();
                    SavedState savedState2 = this.I;
                    int i9 = savedState2.f9280d[i8];
                    if (i9 != Integer.MIN_VALUE) {
                        i9 += savedState2.f9285i ? this.f9261u.i() : this.f9261u.n();
                    }
                    this.f9260t[i8].A(i9);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f9277a = savedState3.f9278b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f9286j;
        q3(savedState4.f9284h);
        k3();
        SavedState savedState5 = this.I;
        int i10 = savedState5.f9277a;
        if (i10 != -1) {
            this.C = i10;
            bVar.f9290c = savedState5.f9285i;
        } else {
            bVar.f9290c = this.A;
        }
        if (savedState5.f9281e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f9271a = savedState5.f9282f;
            lazySpanLookup.f9272b = savedState5.f9283g;
        }
    }

    private void o2(View view, LayoutParams layoutParams, p pVar) {
        if (pVar.f9680e == 1) {
            if (layoutParams.f9269f) {
                k2(view);
                return;
            } else {
                layoutParams.f9268e.a(view);
                return;
            }
        }
        if (layoutParams.f9269f) {
            f3(view);
        } else {
            layoutParams.f9268e.z(view);
        }
    }

    private void o3(int i7) {
        p pVar = this.f9265y;
        pVar.f9680e = i7;
        pVar.f9679d = this.A != (i7 == -1) ? -1 : 1;
    }

    private int p2(int i7) {
        if (Q() == 0) {
            return this.A ? 1 : -1;
        }
        return (i7 < L2()) != this.A ? -1 : 1;
    }

    private boolean r2(c cVar) {
        if (this.A) {
            if (cVar.p() < this.f9261u.i()) {
                ArrayList<View> arrayList = cVar.f9296a;
                return !cVar.s(arrayList.get(arrayList.size() - 1)).f9269f;
            }
        } else if (cVar.t() > this.f9261u.n()) {
            return !cVar.s(cVar.f9296a.get(0)).f9269f;
        }
        return false;
    }

    private int s2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        return z.a(a0Var, this.f9261u, D2(!this.N), C2(!this.N), this, this.N);
    }

    private void s3(int i7, int i8) {
        for (int i9 = 0; i9 < this.f9259s; i9++) {
            if (!this.f9260t[i9].f9296a.isEmpty()) {
                y3(this.f9260t[i9], i7, i8);
            }
        }
    }

    private int t2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        return z.b(a0Var, this.f9261u, D2(!this.N), C2(!this.N), this, this.N, this.A);
    }

    private boolean t3(RecyclerView.a0 a0Var, b bVar) {
        bVar.f9288a = this.G ? H2(a0Var.d()) : B2(a0Var.d());
        bVar.f9289b = Integer.MIN_VALUE;
        return true;
    }

    private int u2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        return z.c(a0Var, this.f9261u, D2(!this.N), C2(!this.N), this, this.N);
    }

    private int v2(int i7) {
        if (i7 == 1) {
            return (this.f9263w != 1 && Z2()) ? 1 : -1;
        }
        if (i7 == 2) {
            return (this.f9263w != 1 && Z2()) ? -1 : 1;
        }
        if (i7 == 17) {
            return this.f9263w == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i7 == 33) {
            return this.f9263w == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i7 != 66) {
            return (i7 == 130 && this.f9263w == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f9263w == 0 ? 1 : Integer.MIN_VALUE;
    }

    private LazySpanLookup.FullSpanItem w2(int i7) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f9275c = new int[this.f9259s];
        for (int i8 = 0; i8 < this.f9259s; i8++) {
            fullSpanItem.f9275c[i8] = i7 - this.f9260t[i8].q(i7);
        }
        return fullSpanItem;
    }

    private void w3(int i7, RecyclerView.a0 a0Var) {
        int iO;
        int iO2;
        int iG;
        p pVar = this.f9265y;
        boolean z7 = false;
        pVar.f9677b = 0;
        pVar.f9678c = i7;
        if (!M0() || (iG = a0Var.g()) == -1) {
            iO = 0;
            iO2 = 0;
        } else {
            if (this.A == (iG < i7)) {
                iO = this.f9261u.o();
                iO2 = 0;
            } else {
                iO2 = this.f9261u.o();
                iO = 0;
            }
        }
        if (U()) {
            this.f9265y.f9681f = this.f9261u.n() - iO2;
            this.f9265y.f9682g = this.f9261u.i() + iO;
        } else {
            this.f9265y.f9682g = this.f9261u.h() + iO;
            this.f9265y.f9681f = -iO2;
        }
        p pVar2 = this.f9265y;
        pVar2.f9683h = false;
        pVar2.f9676a = true;
        if (this.f9261u.l() == 0 && this.f9261u.h() == 0) {
            z7 = true;
        }
        pVar2.f9684i = z7;
    }

    private LazySpanLookup.FullSpanItem x2(int i7) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f9275c = new int[this.f9259s];
        for (int i8 = 0; i8 < this.f9259s; i8++) {
            fullSpanItem.f9275c[i8] = this.f9260t[i8].u(i7) - i7;
        }
        return fullSpanItem;
    }

    private void y2() {
        this.f9261u = w.b(this, this.f9263w);
        this.f9262v = w.b(this, 1 - this.f9263w);
    }

    private void y3(c cVar, int i7, int i8) {
        int iO = cVar.o();
        if (i7 == -1) {
            if (cVar.t() + iO <= i8) {
                this.B.set(cVar.f9300e, false);
            }
        } else if (cVar.p() - iO >= i8) {
            this.B.set(cVar.f9300e, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int z2(RecyclerView.v vVar, p pVar, RecyclerView.a0 a0Var) {
        int i7;
        int iO2;
        c cVarS2;
        int iE;
        int i8;
        int iE2;
        int iE3;
        boolean z7;
        ?? r9 = 0;
        this.B.set(0, this.f9259s, true);
        if (this.f9265y.f9684i) {
            i7 = pVar.f9680e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i7 = pVar.f9680e == 1 ? pVar.f9682g + pVar.f9677b : pVar.f9681f - pVar.f9677b;
        }
        int i9 = i7;
        s3(pVar.f9680e, i9);
        int i10 = this.A ? this.f9261u.i() : this.f9261u.n();
        ?? r7 = false;
        while (pVar.a(a0Var) && (this.f9265y.f9684i || !this.B.isEmpty())) {
            View viewB = pVar.b(vVar);
            LayoutParams layoutParams = (LayoutParams) viewB.getLayoutParams();
            int iB = layoutParams.b();
            int iG = this.E.g(iB);
            ?? r8 = iG == -1 ? 1 : r9;
            if (r8 != 0) {
                cVarS2 = layoutParams.f9269f ? this.f9260t[r9] : S2(pVar);
                this.E.n(iB, cVarS2);
            } else {
                cVarS2 = this.f9260t[iG];
            }
            c cVar = cVarS2;
            layoutParams.f9268e = cVar;
            if (pVar.f9680e == 1) {
                e(viewB);
            } else {
                f(viewB, r9);
            }
            b3(viewB, layoutParams, r9);
            if (pVar.f9680e == 1) {
                int iO3 = layoutParams.f9269f ? O2(i10) : cVar.q(i10);
                int iE4 = this.f9261u.e(viewB) + iO3;
                if (r8 != 0 && layoutParams.f9269f) {
                    LazySpanLookup.FullSpanItem fullSpanItemW2 = w2(iO3);
                    fullSpanItemW2.f9274b = -1;
                    fullSpanItemW2.f9273a = iB;
                    this.E.a(fullSpanItemW2);
                }
                i8 = iE4;
                iE = iO3;
            } else {
                int iR2 = layoutParams.f9269f ? R2(i10) : cVar.u(i10);
                iE = iR2 - this.f9261u.e(viewB);
                if (r8 != 0 && layoutParams.f9269f) {
                    LazySpanLookup.FullSpanItem fullSpanItemX2 = x2(iR2);
                    fullSpanItemX2.f9274b = 1;
                    fullSpanItemX2.f9273a = iB;
                    this.E.a(fullSpanItemX2);
                }
                i8 = iR2;
            }
            if (layoutParams.f9269f && pVar.f9679d == -1) {
                if (r8 != 0) {
                    this.M = true;
                } else {
                    if (!(pVar.f9680e == 1 ? m2() : n2())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.E.f(iB);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f9276d = true;
                        }
                        this.M = true;
                    }
                }
            }
            o2(viewB, layoutParams, pVar);
            if (Z2() && this.f9263w == 1) {
                int i11 = layoutParams.f9269f ? this.f9262v.i() : this.f9262v.i() - (((this.f9259s - 1) - cVar.f9300e) * this.f9264x);
                iE3 = i11;
                iE2 = i11 - this.f9262v.e(viewB);
            } else {
                int iN = layoutParams.f9269f ? this.f9262v.n() : (cVar.f9300e * this.f9264x) + this.f9262v.n();
                iE2 = iN;
                iE3 = this.f9262v.e(viewB) + iN;
            }
            if (this.f9263w == 1) {
                P0(viewB, iE2, iE, iE3, i8);
            } else {
                P0(viewB, iE, iE2, i8, iE3);
            }
            if (layoutParams.f9269f) {
                s3(this.f9265y.f9680e, i9);
            } else {
                y3(cVar, this.f9265y.f9680e, i9);
            }
            g3(vVar, this.f9265y);
            if (!this.f9265y.f9683h || !viewB.hasFocusable()) {
                z7 = false;
            } else if (layoutParams.f9269f) {
                this.B.clear();
                z7 = false;
            } else {
                z7 = false;
                this.B.set(cVar.f9300e, false);
            }
            r9 = z7;
            r7 = true;
        }
        ?? r10 = r9;
        if (r7 == false) {
            g3(vVar, this.f9265y);
        }
        if (this.f9265y.f9680e == -1) {
            iO2 = this.f9261u.n() - R2(this.f9261u.n());
        } else {
            iO2 = O2(this.f9261u.i()) - this.f9261u.i();
        }
        return iO2 > 0 ? Math.min(pVar.f9677b, iO2) : r10 == true ? 1 : 0;
    }

    private int z3(int i7, int i8, int i9) {
        if (i8 == 0 && i9 == 0) {
            return i7;
        }
        int mode = View.MeasureSpec.getMode(i7);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i7) - i8) - i9), mode) : i7;
    }

    public int[] A2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f9259s];
        } else if (iArr.length < this.f9259s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f9259s + ", array size:" + iArr.length);
        }
        for (int i7 = 0; i7 < this.f9259s; i7++) {
            iArr[i7] = this.f9260t[i7].f();
        }
        return iArr;
    }

    View C2(boolean z7) {
        int iN = this.f9261u.n();
        int i7 = this.f9261u.i();
        View view = null;
        for (int iQ = Q() - 1; iQ >= 0; iQ--) {
            View viewP = P(iQ);
            int iG = this.f9261u.g(viewP);
            int iD = this.f9261u.d(viewP);
            if (iD > iN && iG < i7) {
                if (iD <= i7 || !z7) {
                    return viewP;
                }
                if (view == null) {
                    view = viewP;
                }
            }
        }
        return view;
    }

    View D2(boolean z7) {
        int iN = this.f9261u.n();
        int i7 = this.f9261u.i();
        int iQ = Q();
        View view = null;
        for (int i8 = 0; i8 < iQ; i8++) {
            View viewP = P(i8);
            int iG = this.f9261u.g(viewP);
            if (this.f9261u.d(viewP) > iN && iG < i7) {
                if (iG >= iN || !z7) {
                    return viewP;
                }
                if (view == null) {
                    view = viewP;
                }
            }
        }
        return view;
    }

    int E2() {
        View viewC2 = this.A ? C2(true) : D2(true);
        if (viewC2 == null) {
            return -1;
        }
        return s0(viewC2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean F0() {
        return this.F != 0;
    }

    public int[] F2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f9259s];
        } else if (iArr.length < this.f9259s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f9259s + ", array size:" + iArr.length);
        }
        for (int i7 = 0; i7 < this.f9259s; i7++) {
            iArr[i7] = this.f9260t[i7].h();
        }
        return iArr;
    }

    public int[] G2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f9259s];
        } else if (iArr.length < this.f9259s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f9259s + ", array size:" + iArr.length);
        }
        for (int i7 = 0; i7 < this.f9259s; i7++) {
            iArr[i7] = this.f9260t[i7].i();
        }
        return iArr;
    }

    public int[] I2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f9259s];
        } else if (iArr.length < this.f9259s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f9259s + ", array size:" + iArr.length);
        }
        for (int i7 = 0; i7 < this.f9259s; i7++) {
            iArr[i7] = this.f9260t[i7].k();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams K() {
        return this.f9263w == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams L(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    int L2() {
        if (Q() == 0) {
            return 0;
        }
        return s0(P(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams M(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int M2() {
        return this.F;
    }

    int N2() {
        int iQ = Q();
        if (iQ == 0) {
            return 0;
        }
        return s0(P(iQ - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return l3(i7, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i7) {
        SavedState savedState = this.I;
        if (savedState != null && savedState.f9277a != i7) {
            savedState.a();
        }
        this.C = i7;
        this.D = Integer.MIN_VALUE;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return l3(i7, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(int i7) {
        super.T0(i7);
        for (int i8 = 0; i8 < this.f9259s; i8++) {
            this.f9260t[i8].w(i7);
        }
    }

    public int T2() {
        return this.f9263w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(int i7) {
        super.U0(i7);
        for (int i8 = 0; i8 < this.f9259s; i8++) {
            this.f9260t[i8].w(i7);
        }
    }

    public boolean U2() {
        return this.f9266z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int V(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f9263w == 1 ? this.f9259s : super.V(vVar, a0Var);
    }

    public int V2() {
        return this.f9259s;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    View X2() {
        int i7;
        int i8;
        boolean z7;
        int iQ = Q() - 1;
        BitSet bitSet = new BitSet(this.f9259s);
        bitSet.set(0, this.f9259s, true);
        byte b8 = (this.f9263w == 1 && Z2()) ? (byte) 1 : (byte) -1;
        if (this.A) {
            i7 = -1;
        } else {
            i7 = iQ + 1;
            iQ = 0;
        }
        int i9 = iQ < i7 ? 1 : -1;
        while (iQ != i7) {
            View viewP = P(iQ);
            LayoutParams layoutParams = (LayoutParams) viewP.getLayoutParams();
            if (bitSet.get(layoutParams.f9268e.f9300e)) {
                if (r2(layoutParams.f9268e)) {
                    return viewP;
                }
                bitSet.clear(layoutParams.f9268e.f9300e);
            }
            if (!layoutParams.f9269f && (i8 = iQ + i9) != i7) {
                View viewP2 = P(i8);
                if (this.A) {
                    int iD = this.f9261u.d(viewP);
                    int iD2 = this.f9261u.d(viewP2);
                    if (iD < iD2) {
                        return viewP;
                    }
                    if (iD == iD2) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    int iG = this.f9261u.g(viewP);
                    int iG2 = this.f9261u.g(viewP2);
                    if (iG > iG2) {
                        return viewP;
                    }
                    if (iG == iG2) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                if (z7) {
                    if ((layoutParams.f9268e.f9300e - ((LayoutParams) viewP2.getLayoutParams()).f9268e.f9300e < 0) != (b8 < 0)) {
                        return viewP;
                    }
                } else {
                    continue;
                }
            }
            iQ += i9;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y1(Rect rect, int i7, int i8) {
        int iQ;
        int iQ2;
        int iO0 = o0() + p0();
        int iR0 = r0() + m0();
        if (this.f9263w == 1) {
            iQ2 = RecyclerView.o.q(i8, rect.height() + iR0, k0());
            iQ = RecyclerView.o.q(i7, (this.f9264x * this.f9259s) + iO0, l0());
        } else {
            iQ = RecyclerView.o.q(i7, rect.width() + iO0, l0());
            iQ2 = RecyclerView.o.q(i8, (this.f9264x * this.f9259s) + iR0, k0());
        }
        X1(iQ, iQ2);
    }

    public void Y2() {
        this.E.b();
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.Z0(recyclerView, vVar);
        H1(this.P);
        for (int i7 = 0; i7 < this.f9259s; i7++) {
            this.f9260t[i7].e();
        }
        recyclerView.requestLayout();
    }

    boolean Z2() {
        return i0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i7) {
        int iP2 = p2(i7);
        PointF pointF = new PointF();
        if (iP2 == 0) {
            return null;
        }
        if (this.f9263w == 0) {
            pointF.x = iP2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iP2;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    @o0
    public View a1(View view, int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewI;
        View viewR;
        if (Q() == 0 || (viewI = I(view)) == null) {
            return null;
        }
        k3();
        int iV2 = v2(i7);
        if (iV2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewI.getLayoutParams();
        boolean z7 = layoutParams.f9269f;
        c cVar = layoutParams.f9268e;
        int iN2 = iV2 == 1 ? N2() : L2();
        w3(iN2, a0Var);
        o3(iV2);
        p pVar = this.f9265y;
        pVar.f9678c = pVar.f9679d + iN2;
        pVar.f9677b = (int) (this.f9261u.o() * Y);
        p pVar2 = this.f9265y;
        pVar2.f9683h = true;
        pVar2.f9676a = false;
        z2(vVar, pVar2, a0Var);
        this.G = this.A;
        if (!z7 && (viewR = cVar.r(iN2, iV2)) != null && viewR != viewI) {
            return viewR;
        }
        if (d3(iV2)) {
            for (int i8 = this.f9259s - 1; i8 >= 0; i8--) {
                View viewR2 = this.f9260t[i8].r(iN2, iV2);
                if (viewR2 != null && viewR2 != viewI) {
                    return viewR2;
                }
            }
        } else {
            for (int i9 = 0; i9 < this.f9259s; i9++) {
                View viewR3 = this.f9260t[i9].r(iN2, iV2);
                if (viewR3 != null && viewR3 != viewI) {
                    return viewR3;
                }
            }
        }
        boolean z8 = (this.f9266z ^ true) == (iV2 == -1);
        if (!z7) {
            View viewJ = J(z8 ? cVar.g() : cVar.j());
            if (viewJ != null && viewJ != viewI) {
                return viewJ;
            }
        }
        if (d3(iV2)) {
            for (int i10 = this.f9259s - 1; i10 >= 0; i10--) {
                if (i10 != cVar.f9300e) {
                    View viewJ2 = J(z8 ? this.f9260t[i10].g() : this.f9260t[i10].j());
                    if (viewJ2 != null && viewJ2 != viewI) {
                        return viewJ2;
                    }
                }
            }
        } else {
            for (int i11 = 0; i11 < this.f9259s; i11++) {
                View viewJ3 = J(z8 ? this.f9260t[i11].g() : this.f9260t[i11].j());
                if (viewJ3 != null && viewJ3 != viewI) {
                    return viewJ3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(AccessibilityEvent accessibilityEvent) {
        super.b1(accessibilityEvent);
        if (Q() > 0) {
            View viewD2 = D2(false);
            View viewC2 = C2(false);
            if (viewD2 == null || viewC2 == null) {
                return;
            }
            int iS0 = s0(viewD2);
            int iS1 = s0(viewC2);
            if (iS0 < iS1) {
                accessibilityEvent.setFromIndex(iS0);
                accessibilityEvent.setToIndex(iS1);
            } else {
                accessibilityEvent.setFromIndex(iS1);
                accessibilityEvent.setToIndex(iS0);
            }
        }
    }

    void e3(int i7, RecyclerView.a0 a0Var) {
        int iL2;
        int i8;
        if (i7 > 0) {
            iL2 = N2();
            i8 = 1;
        } else {
            iL2 = L2();
            i8 = -1;
        }
        this.f9265y.f9676a = true;
        w3(iL2, a0Var);
        o3(i8);
        p pVar = this.f9265y;
        pVar.f9678c = iL2 + pVar.f9679d;
        pVar.f9677b = Math.abs(i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i7) {
        q qVar = new q(recyclerView.getContext());
        qVar.q(i7);
        g2(qVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g1(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, l0 l0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.f1(view, l0Var);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f9263w == 0) {
            l0Var.Z0(l0.c.h(layoutParams2.h(), layoutParams2.f9269f ? this.f9259s : 1, -1, -1, false, false));
        } else {
            l0Var.Z0(l0.c.h(-1, -1, layoutParams2.h(), layoutParams2.f9269f ? this.f9259s : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(String str) {
        if (this.I == null) {
            super.i(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(RecyclerView recyclerView, int i7, int i8) {
        W2(i7, i8, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void j1(RecyclerView recyclerView) {
        this.E.b();
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.I == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(RecyclerView recyclerView, int i7, int i8, int i9) {
        W2(i7, i8, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l1(RecyclerView recyclerView, int i7, int i8) {
        W2(i7, i8, 2);
    }

    int l3(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (Q() == 0 || i7 == 0) {
            return 0;
        }
        e3(i7, a0Var);
        int iZ2 = z2(vVar, this.f9265y, a0Var);
        if (this.f9265y.f9677b >= iZ2) {
            i7 = i7 < 0 ? -iZ2 : iZ2;
        }
        this.f9261u.t(-i7);
        this.G = this.A;
        p pVar = this.f9265y;
        pVar.f9677b = 0;
        g3(vVar, pVar);
        return i7;
    }

    boolean m2() {
        int iQ = this.f9260t[0].q(Integer.MIN_VALUE);
        for (int i7 = 1; i7 < this.f9259s; i7++) {
            if (this.f9260t[i7].q(Integer.MIN_VALUE) != iQ) {
                return false;
            }
        }
        return true;
    }

    public void m3(int i7, int i8) {
        SavedState savedState = this.I;
        if (savedState != null) {
            savedState.a();
        }
        this.C = i7;
        this.D = i8;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n() {
        return this.f9263w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n1(RecyclerView recyclerView, int i7, int i8, Object obj) {
        W2(i7, i8, 4);
    }

    boolean n2() {
        int iU = this.f9260t[0].u(Integer.MIN_VALUE);
        for (int i7 = 1; i7 < this.f9259s; i7++) {
            if (this.f9260t[i7].u(Integer.MIN_VALUE) != iU) {
                return false;
            }
        }
        return true;
    }

    public void n3(int i7) {
        i(null);
        if (i7 == this.F) {
            return;
        }
        if (i7 != 0 && i7 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.F = i7;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean o() {
        return this.f9263w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        c3(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean p(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p1(RecyclerView.a0 a0Var) {
        super.p1(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public void p3(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        i(null);
        if (i7 == this.f9263w) {
            return;
        }
        this.f9263w = i7;
        w wVar = this.f9261u;
        this.f9261u = this.f9262v;
        this.f9262v = wVar;
        N1();
    }

    boolean q2() {
        int iL2;
        int iN2;
        if (Q() == 0 || this.F == 0 || !E0()) {
            return false;
        }
        if (this.A) {
            iL2 = N2();
            iN2 = L2();
        } else {
            iL2 = L2();
            iN2 = N2();
        }
        if (iL2 == 0 && X2() != null) {
            this.E.b();
            O1();
            N1();
            return true;
        }
        if (!this.M) {
            return false;
        }
        int i7 = this.A ? -1 : 1;
        int i8 = iN2 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.E.e(iL2, i8, i7, true);
        if (fullSpanItemE == null) {
            this.M = false;
            this.E.d(i8);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.E.e(iL2, fullSpanItemE.f9273a, i7 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.E.d(fullSpanItemE.f9273a);
        } else {
            this.E.d(fullSpanItemE2.f9273a + 1);
        }
        O1();
        N1();
        return true;
    }

    public void q3(boolean z7) {
        i(null);
        SavedState savedState = this.I;
        if (savedState != null && savedState.f9284h != z7) {
            savedState.f9284h = z7;
        }
        this.f9266z = z7;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    @x0({x0.a.LIBRARY})
    public void r(int i7, int i8, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int iQ;
        int iU;
        if (this.f9263w != 0) {
            i7 = i8;
        }
        if (Q() == 0 || i7 == 0) {
            return;
        }
        e3(i7, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f9259s) {
            this.O = new int[this.f9259s];
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f9259s; i10++) {
            p pVar = this.f9265y;
            if (pVar.f9679d == -1) {
                iQ = pVar.f9681f;
                iU = this.f9260t[i10].u(iQ);
            } else {
                iQ = this.f9260t[i10].q(pVar.f9682g);
                iU = this.f9265y.f9682g;
            }
            int i11 = iQ - iU;
            if (i11 >= 0) {
                this.O[i9] = i11;
                i9++;
            }
        }
        Arrays.sort(this.O, 0, i9);
        for (int i12 = 0; i12 < i9 && this.f9265y.a(a0Var); i12++) {
            cVar.a(this.f9265y.f9678c, this.O[i12]);
            p pVar2 = this.f9265y;
            pVar2.f9678c += pVar2.f9679d;
        }
    }

    public void r3(int i7) {
        i(null);
        if (i7 != this.f9259s) {
            Y2();
            this.f9259s = i7;
            this.B = new BitSet(this.f9259s);
            this.f9260t = new c[this.f9259s];
            for (int i8 = 0; i8 < this.f9259s; i8++) {
                this.f9260t[i8] = new c(i8);
            }
            N1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return s2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.I = (SavedState) parcelable;
            N1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return t2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable u1() {
        int iU;
        int iN;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f9284h = this.f9266z;
        savedState.f9285i = this.G;
        savedState.f9286j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f9271a) == null) {
            savedState.f9281e = 0;
        } else {
            savedState.f9282f = iArr;
            savedState.f9281e = iArr.length;
            savedState.f9283g = lazySpanLookup.f9272b;
        }
        if (Q() > 0) {
            savedState.f9277a = this.G ? N2() : L2();
            savedState.f9278b = E2();
            int i7 = this.f9259s;
            savedState.f9279c = i7;
            savedState.f9280d = new int[i7];
            for (int i8 = 0; i8 < this.f9259s; i8++) {
                if (this.G) {
                    iU = this.f9260t[i8].q(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        iN = this.f9261u.i();
                        iU -= iN;
                    }
                } else {
                    iU = this.f9260t[i8].u(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        iN = this.f9261u.n();
                        iU -= iN;
                    }
                }
                savedState.f9280d[i8] = iU;
            }
        } else {
            savedState.f9277a = -1;
            savedState.f9278b = -1;
            savedState.f9279c = 0;
        }
        return savedState;
    }

    boolean u3(RecyclerView.a0 a0Var, b bVar) {
        int i7;
        if (!a0Var.j() && (i7 = this.C) != -1) {
            if (i7 >= 0 && i7 < a0Var.d()) {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f9277a == -1 || savedState.f9279c < 1) {
                    View viewJ = J(this.C);
                    if (viewJ != null) {
                        bVar.f9288a = this.A ? N2() : L2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f9290c) {
                                bVar.f9289b = (this.f9261u.i() - this.D) - this.f9261u.d(viewJ);
                            } else {
                                bVar.f9289b = (this.f9261u.n() + this.D) - this.f9261u.g(viewJ);
                            }
                            return true;
                        }
                        if (this.f9261u.e(viewJ) > this.f9261u.o()) {
                            bVar.f9289b = bVar.f9290c ? this.f9261u.i() : this.f9261u.n();
                            return true;
                        }
                        int iG = this.f9261u.g(viewJ) - this.f9261u.n();
                        if (iG < 0) {
                            bVar.f9289b = -iG;
                            return true;
                        }
                        int i8 = this.f9261u.i() - this.f9261u.d(viewJ);
                        if (i8 < 0) {
                            bVar.f9289b = i8;
                            return true;
                        }
                        bVar.f9289b = Integer.MIN_VALUE;
                    } else {
                        int i9 = this.C;
                        bVar.f9288a = i9;
                        int i10 = this.D;
                        if (i10 == Integer.MIN_VALUE) {
                            bVar.f9290c = p2(i9) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i10);
                        }
                        bVar.f9291d = true;
                    }
                } else {
                    bVar.f9289b = Integer.MIN_VALUE;
                    bVar.f9288a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return u2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f9263w == 0 ? this.f9259s : super.v0(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(int i7) {
        if (i7 == 0) {
            q2();
        }
    }

    void v3(RecyclerView.a0 a0Var, b bVar) {
        if (u3(a0Var, bVar) || t3(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f9288a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.a0 a0Var) {
        return s2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.a0 a0Var) {
        return t2(a0Var);
    }

    void x3(int i7) {
        this.f9264x = i7 / this.f9259s;
        this.f9258J = View.MeasureSpec.makeMeasureSpec(i7, this.f9262v.l());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.a0 a0Var) {
        return u2(a0Var);
    }

    static class LazySpanLookup {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f9270c = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f9271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f9272b;

        LazySpanLookup() {
        }

        private int i(int i7) {
            if (this.f9272b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i7);
            if (fullSpanItemF != null) {
                this.f9272b.remove(fullSpanItemF);
            }
            int size = this.f9272b.size();
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    i8 = -1;
                    break;
                }
                if (this.f9272b.get(i8).f9273a >= i7) {
                    break;
                }
                i8++;
            }
            if (i8 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f9272b.get(i8);
            this.f9272b.remove(i8);
            return fullSpanItem.f9273a;
        }

        private void l(int i7, int i8) {
            List<FullSpanItem> list = this.f9272b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f9272b.get(size);
                int i9 = fullSpanItem.f9273a;
                if (i9 >= i7) {
                    fullSpanItem.f9273a = i9 + i8;
                }
            }
        }

        private void m(int i7, int i8) {
            List<FullSpanItem> list = this.f9272b;
            if (list == null) {
                return;
            }
            int i9 = i7 + i8;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f9272b.get(size);
                int i10 = fullSpanItem.f9273a;
                if (i10 >= i7) {
                    if (i10 < i9) {
                        this.f9272b.remove(size);
                    } else {
                        fullSpanItem.f9273a = i10 - i8;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f9272b == null) {
                this.f9272b = new ArrayList();
            }
            int size = this.f9272b.size();
            for (int i7 = 0; i7 < size; i7++) {
                FullSpanItem fullSpanItem2 = this.f9272b.get(i7);
                if (fullSpanItem2.f9273a == fullSpanItem.f9273a) {
                    this.f9272b.remove(i7);
                }
                if (fullSpanItem2.f9273a >= fullSpanItem.f9273a) {
                    this.f9272b.add(i7, fullSpanItem);
                    return;
                }
            }
            this.f9272b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.f9271a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f9272b = null;
        }

        void c(int i7) {
            int[] iArr = this.f9271a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i7, 10) + 1];
                this.f9271a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i7 >= iArr.length) {
                int[] iArr3 = new int[o(i7)];
                this.f9271a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f9271a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i7) {
            List<FullSpanItem> list = this.f9272b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f9272b.get(size).f9273a >= i7) {
                        this.f9272b.remove(size);
                    }
                }
            }
            return h(i7);
        }

        public FullSpanItem e(int i7, int i8, int i9, boolean z7) {
            List<FullSpanItem> list = this.f9272b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem = this.f9272b.get(i10);
                int i11 = fullSpanItem.f9273a;
                if (i11 >= i8) {
                    return null;
                }
                if (i11 >= i7 && (i9 == 0 || fullSpanItem.f9274b == i9 || (z7 && fullSpanItem.f9276d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i7) {
            List<FullSpanItem> list = this.f9272b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f9272b.get(size);
                if (fullSpanItem.f9273a == i7) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i7) {
            int[] iArr = this.f9271a;
            if (iArr == null || i7 >= iArr.length) {
                return -1;
            }
            return iArr[i7];
        }

        int h(int i7) {
            int[] iArr = this.f9271a;
            if (iArr == null || i7 >= iArr.length) {
                return -1;
            }
            int i8 = i(i7);
            if (i8 == -1) {
                int[] iArr2 = this.f9271a;
                Arrays.fill(iArr2, i7, iArr2.length, -1);
                return this.f9271a.length;
            }
            int i9 = i8 + 1;
            Arrays.fill(this.f9271a, i7, i9, -1);
            return i9;
        }

        void j(int i7, int i8) {
            int[] iArr = this.f9271a;
            if (iArr == null || i7 >= iArr.length) {
                return;
            }
            int i9 = i7 + i8;
            c(i9);
            int[] iArr2 = this.f9271a;
            System.arraycopy(iArr2, i7, iArr2, i9, (iArr2.length - i7) - i8);
            Arrays.fill(this.f9271a, i7, i9, -1);
            l(i7, i8);
        }

        void k(int i7, int i8) {
            int[] iArr = this.f9271a;
            if (iArr == null || i7 >= iArr.length) {
                return;
            }
            int i9 = i7 + i8;
            c(i9);
            int[] iArr2 = this.f9271a;
            System.arraycopy(iArr2, i9, iArr2, i7, (iArr2.length - i7) - i8);
            int[] iArr3 = this.f9271a;
            Arrays.fill(iArr3, iArr3.length - i8, iArr3.length, -1);
            m(i7, i8);
        }

        void n(int i7, c cVar) {
            c(i7);
            this.f9271a[i7] = cVar.f9300e;
        }

        int o(int i7) {
            int length = this.f9271a.length;
            while (length <= i7) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f9273a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f9274b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int[] f9275c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f9276d;

            static class a implements Parcelable.Creator<FullSpanItem> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i7) {
                    return new FullSpanItem[i7];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f9273a = parcel.readInt();
                this.f9274b = parcel.readInt();
                this.f9276d = parcel.readInt() == 1;
                int i7 = parcel.readInt();
                if (i7 > 0) {
                    int[] iArr = new int[i7];
                    this.f9275c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i7) {
                int[] iArr = this.f9275c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i7];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f9273a + ", mGapDir=" + this.f9274b + ", mHasUnwantedGapAfter=" + this.f9276d + ", mGapPerSpan=" + Arrays.toString(this.f9275c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i7) {
                parcel.writeInt(this.f9273a);
                parcel.writeInt(this.f9274b);
                parcel.writeInt(this.f9276d ? 1 : 0);
                int[] iArr = this.f9275c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f9275c);
                }
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i7, int i8) {
        this.f9263w = i8;
        r3(i7);
        this.f9265y = new p();
        y2();
    }
}
