package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import c.m0;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements m.j, RecyclerView.z.b {
    private static final String I = "LinearLayoutManager";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final boolean f9020J = false;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = Integer.MIN_VALUE;
    private static final float N = 0.33333334f;
    int A;
    int B;
    private boolean C;
    SavedState D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f9021s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f9022t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    w f9023u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f9024v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9025w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f9026x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f9027y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f9028z;

    @x0({x0.a.LIBRARY})
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9031c;

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

        boolean a() {
            return this.f9029a >= 0;
        }

        void b() {
            this.f9029a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f9029a);
            parcel.writeInt(this.f9030b);
            parcel.writeInt(this.f9031c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f9029a = parcel.readInt();
            this.f9030b = parcel.readInt();
            this.f9031c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f9029a = savedState.f9029a;
            this.f9030b = savedState.f9030b;
            this.f9031c = savedState.f9031c;
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        w f9032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f9036e;

        a() {
            e();
        }

        void a() {
            this.f9034c = this.f9035d ? this.f9032a.i() : this.f9032a.n();
        }

        public void b(View view, int i7) {
            if (this.f9035d) {
                this.f9034c = this.f9032a.d(view) + this.f9032a.p();
            } else {
                this.f9034c = this.f9032a.g(view);
            }
            this.f9033b = i7;
        }

        public void c(View view, int i7) {
            int iP = this.f9032a.p();
            if (iP >= 0) {
                b(view, i7);
                return;
            }
            this.f9033b = i7;
            if (this.f9035d) {
                int i8 = (this.f9032a.i() - iP) - this.f9032a.d(view);
                this.f9034c = this.f9032a.i() - i8;
                if (i8 > 0) {
                    int iE = this.f9034c - this.f9032a.e(view);
                    int iN = this.f9032a.n();
                    int iMin = iE - (iN + Math.min(this.f9032a.g(view) - iN, 0));
                    if (iMin < 0) {
                        this.f9034c += Math.min(i8, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f9032a.g(view);
            int iN2 = iG - this.f9032a.n();
            this.f9034c = iG;
            if (iN2 > 0) {
                int i9 = (this.f9032a.i() - Math.min(0, (this.f9032a.i() - iP) - this.f9032a.d(view))) - (iG + this.f9032a.e(view));
                if (i9 < 0) {
                    this.f9034c -= Math.min(iN2, -i9);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.e() && layoutParams.b() >= 0 && layoutParams.b() < a0Var.d();
        }

        void e() {
            this.f9033b = -1;
            this.f9034c = Integer.MIN_VALUE;
            this.f9035d = false;
            this.f9036e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f9033b + ", mCoordinate=" + this.f9034c + ", mLayoutFromEnd=" + this.f9035d + ", mValid=" + this.f9036e + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9040d;

        protected b() {
        }

        void a() {
            this.f9037a = 0;
            this.f9038b = false;
            this.f9039c = false;
            this.f9040d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final String f9041n = "LLM#LayoutState";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final int f9042o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final int f9043p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final int f9044q = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final int f9045r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final int f9046s = 1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        static final int f9047t = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f9054g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f9058k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f9060m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9048a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f9055h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f9056i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9057j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List<RecyclerView.d0> f9059l = null;

        c() {
        }

        private View f() {
            int size = this.f9059l.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = this.f9059l.get(i7).f9157a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.e() && this.f9051d == layoutParams.b()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewG = g(view);
            if (viewG == null) {
                this.f9051d = -1;
            } else {
                this.f9051d = ((RecyclerView.LayoutParams) viewG.getLayoutParams()).b();
            }
        }

        boolean c(RecyclerView.a0 a0Var) {
            int i7 = this.f9051d;
            return i7 >= 0 && i7 < a0Var.d();
        }

        void d() {
            Log.d(f9041n, "avail:" + this.f9050c + ", ind:" + this.f9051d + ", dir:" + this.f9052e + ", offset:" + this.f9049b + ", layoutDir:" + this.f9053f);
        }

        View e(RecyclerView.v vVar) {
            if (this.f9059l != null) {
                return f();
            }
            View viewP = vVar.p(this.f9051d);
            this.f9051d += this.f9052e;
            return viewP;
        }

        public View g(View view) {
            int iB;
            int size = this.f9059l.size();
            View view2 = null;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < size; i8++) {
                View view3 = this.f9059l.get(i8).f9157a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.e() && (iB = (layoutParams.b() - this.f9051d) * this.f9052e) >= 0 && iB < i7) {
                    view2 = view3;
                    if (iB == 0) {
                        break;
                    }
                    i7 = iB;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private View A2() {
        return D2(Q() - 1, -1);
    }

    private View B2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return H2(vVar, a0Var, Q() - 1, -1, a0Var.d());
    }

    private View F2() {
        return this.f9026x ? u2() : A2();
    }

    private View G2() {
        return this.f9026x ? A2() : u2();
    }

    private View I2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f9026x ? v2(vVar, a0Var) : B2(vVar, a0Var);
    }

    private View J2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f9026x ? B2(vVar, a0Var) : v2(vVar, a0Var);
    }

    private int K2(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z7) {
        int i8;
        int i9 = this.f9023u.i() - i7;
        if (i9 <= 0) {
            return 0;
        }
        int i10 = -g3(-i9, vVar, a0Var);
        int i11 = i7 + i10;
        if (!z7 || (i8 = this.f9023u.i() - i11) <= 0) {
            return i10;
        }
        this.f9023u.t(i8);
        return i8 + i10;
    }

    private int L2(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z7) {
        int iN;
        int iN2 = i7 - this.f9023u.n();
        if (iN2 <= 0) {
            return 0;
        }
        int i8 = -g3(iN2, vVar, a0Var);
        int i9 = i7 + i8;
        if (!z7 || (iN = i9 - this.f9023u.n()) <= 0) {
            return i8;
        }
        this.f9023u.t(-iN);
        return i8 - iN;
    }

    private View M2() {
        return P(this.f9026x ? 0 : Q() - 1);
    }

    private View N2() {
        return P(this.f9026x ? Q() - 1 : 0);
    }

    private void X2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7, int i8) {
        if (!a0Var.n() || Q() == 0 || a0Var.j() || !j2()) {
            return;
        }
        List<RecyclerView.d0> listL = vVar.l();
        int size = listL.size();
        int iS0 = s0(P(0));
        int iE = 0;
        int iE2 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView.d0 d0Var = listL.get(i9);
            if (!d0Var.w()) {
                if (((d0Var.m() < iS0) != this.f9026x ? (byte) -1 : (byte) 1) == -1) {
                    iE += this.f9023u.e(d0Var.f9157a);
                } else {
                    iE2 += this.f9023u.e(d0Var.f9157a);
                }
            }
        }
        this.f9022t.f9059l = listL;
        if (iE > 0) {
            u3(s0(N2()), i7);
            c cVar = this.f9022t;
            cVar.f9055h = iE;
            cVar.f9050c = 0;
            cVar.a();
            s2(vVar, this.f9022t, a0Var, false);
        }
        if (iE2 > 0) {
            s3(s0(M2()), i8);
            c cVar2 = this.f9022t;
            cVar2.f9055h = iE2;
            cVar2.f9050c = 0;
            cVar2.a();
            s2(vVar, this.f9022t, a0Var, false);
        }
        this.f9022t.f9059l = null;
    }

    private void Y2() {
        Log.d(I, "internal representation of views on the screen");
        for (int i7 = 0; i7 < Q(); i7++) {
            View viewP = P(i7);
            Log.d(I, "item " + s0(viewP) + ", coord:" + this.f9023u.g(viewP));
        }
        Log.d(I, "==============");
    }

    private void a3(RecyclerView.v vVar, c cVar) {
        if (!cVar.f9048a || cVar.f9060m) {
            return;
        }
        int i7 = cVar.f9054g;
        int i8 = cVar.f9056i;
        if (cVar.f9053f == -1) {
            c3(vVar, i7, i8);
        } else {
            d3(vVar, i7, i8);
        }
    }

    private void b3(RecyclerView.v vVar, int i7, int i8) {
        if (i7 == i8) {
            return;
        }
        if (i8 <= i7) {
            while (i7 > i8) {
                G1(i7, vVar);
                i7--;
            }
        } else {
            for (int i9 = i8 - 1; i9 >= i7; i9--) {
                G1(i9, vVar);
            }
        }
    }

    private void c3(RecyclerView.v vVar, int i7, int i8) {
        int iQ = Q();
        if (i7 < 0) {
            return;
        }
        int iH = (this.f9023u.h() - i7) + i8;
        if (this.f9026x) {
            for (int i9 = 0; i9 < iQ; i9++) {
                View viewP = P(i9);
                if (this.f9023u.g(viewP) < iH || this.f9023u.r(viewP) < iH) {
                    b3(vVar, 0, i9);
                    return;
                }
            }
            return;
        }
        int i10 = iQ - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            View viewP2 = P(i11);
            if (this.f9023u.g(viewP2) < iH || this.f9023u.r(viewP2) < iH) {
                b3(vVar, i10, i11);
                return;
            }
        }
    }

    private void d3(RecyclerView.v vVar, int i7, int i8) {
        if (i7 < 0) {
            return;
        }
        int i9 = i7 - i8;
        int iQ = Q();
        if (!this.f9026x) {
            for (int i10 = 0; i10 < iQ; i10++) {
                View viewP = P(i10);
                if (this.f9023u.d(viewP) > i9 || this.f9023u.q(viewP) > i9) {
                    b3(vVar, 0, i10);
                    return;
                }
            }
            return;
        }
        int i11 = iQ - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            View viewP2 = P(i12);
            if (this.f9023u.d(viewP2) > i9 || this.f9023u.q(viewP2) > i9) {
                b3(vVar, i11, i12);
                return;
            }
        }
    }

    private void f3() {
        if (this.f9021s == 1 || !U2()) {
            this.f9026x = this.f9025w;
        } else {
            this.f9026x = !this.f9025w;
        }
    }

    private int m2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        r2();
        return z.a(a0Var, this.f9023u, x2(!this.f9028z, true), w2(!this.f9028z, true), this, this.f9028z);
    }

    private int n2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        r2();
        return z.b(a0Var, this.f9023u, x2(!this.f9028z, true), w2(!this.f9028z, true), this, this.f9028z, this.f9026x);
    }

    private int o2(RecyclerView.a0 a0Var) {
        if (Q() == 0) {
            return 0;
        }
        r2();
        return z.c(a0Var, this.f9023u, x2(!this.f9028z, true), w2(!this.f9028z, true), this, this.f9028z);
    }

    private boolean o3(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (Q() == 0) {
            return false;
        }
        View viewD0 = d0();
        if (viewD0 != null && aVar.d(viewD0, a0Var)) {
            aVar.c(viewD0, s0(viewD0));
            return true;
        }
        if (this.f9024v != this.f9027y) {
            return false;
        }
        View viewI2 = aVar.f9035d ? I2(vVar, a0Var) : J2(vVar, a0Var);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, s0(viewI2));
        if (!a0Var.j() && j2()) {
            if (this.f9023u.g(viewI2) >= this.f9023u.i() || this.f9023u.d(viewI2) < this.f9023u.n()) {
                aVar.f9034c = aVar.f9035d ? this.f9023u.i() : this.f9023u.n();
            }
        }
        return true;
    }

    private boolean p3(RecyclerView.a0 a0Var, a aVar) {
        int i7;
        if (!a0Var.j() && (i7 = this.A) != -1) {
            if (i7 >= 0 && i7 < a0Var.d()) {
                aVar.f9033b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z7 = this.D.f9031c;
                    aVar.f9035d = z7;
                    if (z7) {
                        aVar.f9034c = this.f9023u.i() - this.D.f9030b;
                    } else {
                        aVar.f9034c = this.f9023u.n() + this.D.f9030b;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z8 = this.f9026x;
                    aVar.f9035d = z8;
                    if (z8) {
                        aVar.f9034c = this.f9023u.i() - this.B;
                    } else {
                        aVar.f9034c = this.f9023u.n() + this.B;
                    }
                    return true;
                }
                View viewJ = J(this.A);
                if (viewJ == null) {
                    if (Q() > 0) {
                        aVar.f9035d = (this.A < s0(P(0))) == this.f9026x;
                    }
                    aVar.a();
                } else {
                    if (this.f9023u.e(viewJ) > this.f9023u.o()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f9023u.g(viewJ) - this.f9023u.n() < 0) {
                        aVar.f9034c = this.f9023u.n();
                        aVar.f9035d = false;
                        return true;
                    }
                    if (this.f9023u.i() - this.f9023u.d(viewJ) < 0) {
                        aVar.f9034c = this.f9023u.i();
                        aVar.f9035d = true;
                        return true;
                    }
                    aVar.f9034c = aVar.f9035d ? this.f9023u.d(viewJ) + this.f9023u.p() : this.f9023u.g(viewJ);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void q3(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (p3(a0Var, aVar) || o3(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f9033b = this.f9027y ? a0Var.d() - 1 : 0;
    }

    private void r3(int i7, int i8, boolean z7, RecyclerView.a0 a0Var) {
        int iN;
        this.f9022t.f9060m = e3();
        this.f9022t.f9053f = i7;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]);
        int iMax2 = Math.max(0, this.H[1]);
        boolean z8 = i7 == 1;
        c cVar = this.f9022t;
        int i9 = z8 ? iMax2 : iMax;
        cVar.f9055h = i9;
        if (!z8) {
            iMax = iMax2;
        }
        cVar.f9056i = iMax;
        if (z8) {
            cVar.f9055h = i9 + this.f9023u.j();
            View viewM2 = M2();
            c cVar2 = this.f9022t;
            cVar2.f9052e = this.f9026x ? -1 : 1;
            int iS0 = s0(viewM2);
            c cVar3 = this.f9022t;
            cVar2.f9051d = iS0 + cVar3.f9052e;
            cVar3.f9049b = this.f9023u.d(viewM2);
            iN = this.f9023u.d(viewM2) - this.f9023u.i();
        } else {
            View viewN2 = N2();
            this.f9022t.f9055h += this.f9023u.n();
            c cVar4 = this.f9022t;
            cVar4.f9052e = this.f9026x ? 1 : -1;
            int iS1 = s0(viewN2);
            c cVar5 = this.f9022t;
            cVar4.f9051d = iS1 + cVar5.f9052e;
            cVar5.f9049b = this.f9023u.g(viewN2);
            iN = (-this.f9023u.g(viewN2)) + this.f9023u.n();
        }
        c cVar6 = this.f9022t;
        cVar6.f9050c = i8;
        if (z7) {
            cVar6.f9050c = i8 - iN;
        }
        cVar6.f9054g = iN;
    }

    private void s3(int i7, int i8) {
        this.f9022t.f9050c = this.f9023u.i() - i8;
        c cVar = this.f9022t;
        cVar.f9052e = this.f9026x ? -1 : 1;
        cVar.f9051d = i7;
        cVar.f9053f = 1;
        cVar.f9049b = i8;
        cVar.f9054g = Integer.MIN_VALUE;
    }

    private void t3(a aVar) {
        s3(aVar.f9033b, aVar.f9034c);
    }

    private View u2() {
        return D2(0, Q());
    }

    private void u3(int i7, int i8) {
        this.f9022t.f9050c = i8 - this.f9023u.n();
        c cVar = this.f9022t;
        cVar.f9051d = i7;
        cVar.f9052e = this.f9026x ? 1 : -1;
        cVar.f9053f = -1;
        cVar.f9049b = i8;
        cVar.f9054g = Integer.MIN_VALUE;
    }

    private View v2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return H2(vVar, a0Var, 0, Q(), a0Var.d());
    }

    private void v3(a aVar) {
        u3(aVar.f9033b, aVar.f9034c);
    }

    public int C2() {
        View viewE2 = E2(Q() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return s0(viewE2);
    }

    View D2(int i7, int i8) {
        byte b8;
        int i9;
        int i10;
        r2();
        if (i8 > i7) {
            b8 = 1;
        } else {
            b8 = i8 < i7 ? (byte) -1 : (byte) 0;
        }
        if (b8 == 0) {
            return P(i7);
        }
        if (this.f9023u.g(P(i7)) < this.f9023u.n()) {
            i9 = 16644;
            i10 = 16388;
        } else {
            i9 = 4161;
            i10 = androidx.fragment.app.v.I;
        }
        return this.f9021s == 0 ? this.f9204e.a(i7, i8, i9, i10) : this.f9205f.a(i7, i8, i9, i10);
    }

    View E2(int i7, int i8, boolean z7, boolean z8) {
        r2();
        int i9 = z7 ? 24579 : 320;
        int i10 = z8 ? 320 : 0;
        return this.f9021s == 0 ? this.f9204e.a(i7, i8, i9, i10) : this.f9205f.a(i7, i8, i9, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean F0() {
        return true;
    }

    View H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7, int i8, int i9) {
        r2();
        int iN = this.f9023u.n();
        int i10 = this.f9023u.i();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i7 != i8) {
            View viewP = P(i7);
            int iS0 = s0(viewP);
            if (iS0 >= 0 && iS0 < i9) {
                if (((RecyclerView.LayoutParams) viewP.getLayoutParams()).e()) {
                    if (view2 == null) {
                        view2 = viewP;
                    }
                } else {
                    if (this.f9023u.g(viewP) < i10 && this.f9023u.d(viewP) >= iN) {
                        return viewP;
                    }
                    if (view == null) {
                        view = viewP;
                    }
                }
            }
            i7 += i11;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J(int i7) {
        int iQ = Q();
        if (iQ == 0) {
            return null;
        }
        int iS0 = i7 - s0(P(0));
        if (iS0 >= 0 && iS0 < iQ) {
            View viewP = P(iS0);
            if (s0(viewP) == i7) {
                return viewP;
            }
        }
        return super.J(i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams K() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int O2(RecyclerView.a0 a0Var) {
        if (a0Var.h()) {
            return this.f9023u.o();
        }
        return 0;
    }

    public int P2() {
        return this.G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f9021s == 1) {
            return 0;
        }
        return g3(i7, vVar, a0Var);
    }

    public int Q2() {
        return this.f9021s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i7) {
        this.A = i7;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        N1();
    }

    public boolean R2() {
        return this.C;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f9021s == 0) {
            return 0;
        }
        return g3(i7, vVar, a0Var);
    }

    public boolean S2() {
        return this.f9025w;
    }

    public boolean T2() {
        return this.f9027y;
    }

    protected boolean U2() {
        return i0() == 1;
    }

    public boolean V2() {
        return this.f9028z;
    }

    void W2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i7;
        int i8;
        int i9;
        int iO0;
        int iF;
        View viewE = cVar.e(vVar);
        if (viewE == null) {
            bVar.f9038b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewE.getLayoutParams();
        if (cVar.f9059l == null) {
            if (this.f9026x == (cVar.f9053f == -1)) {
                e(viewE);
            } else {
                f(viewE, 0);
            }
        } else {
            if (this.f9026x == (cVar.f9053f == -1)) {
                c(viewE);
            } else {
                d(viewE, 0);
            }
        }
        R0(viewE, 0, 0);
        bVar.f9037a = this.f9023u.e(viewE);
        if (this.f9021s == 1) {
            if (U2()) {
                iF = z0() - p0();
                iO0 = iF - this.f9023u.f(viewE);
            } else {
                iO0 = o0();
                iF = this.f9023u.f(viewE) + iO0;
            }
            if (cVar.f9053f == -1) {
                int i10 = cVar.f9049b;
                i9 = i10;
                i8 = iF;
                i7 = i10 - bVar.f9037a;
            } else {
                int i11 = cVar.f9049b;
                i7 = i11;
                i8 = iF;
                i9 = bVar.f9037a + i11;
            }
        } else {
            int iR0 = r0();
            int iF2 = this.f9023u.f(viewE) + iR0;
            if (cVar.f9053f == -1) {
                int i12 = cVar.f9049b;
                i8 = i12;
                i7 = iR0;
                i9 = iF2;
                iO0 = i12 - bVar.f9037a;
            } else {
                int i13 = cVar.f9049b;
                i7 = iR0;
                i8 = bVar.f9037a + i13;
                i9 = iF2;
                iO0 = i13;
            }
        }
        P0(viewE, iO0, i7, i8, i9);
        if (layoutParams.e() || layoutParams.d()) {
            bVar.f9039c = true;
        }
        bVar.f9040d = viewE.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.Z0(recyclerView, vVar);
        if (this.C) {
            D1(vVar);
            vVar.d();
        }
    }

    void Z2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i7) {
        if (Q() == 0) {
            return null;
        }
        int i8 = (i7 < s0(P(0))) != this.f9026x ? -1 : 1;
        return this.f9021s == 0 ? new PointF(i8, 0.0f) : new PointF(0.0f, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View a1(View view, int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iP2;
        f3();
        if (Q() == 0 || (iP2 = p2(i7)) == Integer.MIN_VALUE) {
            return null;
        }
        r2();
        r3(iP2, (int) (this.f9023u.o() * N), false, a0Var);
        c cVar = this.f9022t;
        cVar.f9054g = Integer.MIN_VALUE;
        cVar.f9048a = false;
        s2(vVar, cVar, a0Var, true);
        View viewG2 = iP2 == -1 ? G2() : F2();
        View viewN2 = iP2 == -1 ? N2() : M2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    @Override // androidx.recyclerview.widget.m.j
    public void b(@m0 View view, @m0 View view2, int i7, int i8) {
        i("Cannot drop a view during a scroll or layout calculation");
        r2();
        f3();
        int iS0 = s0(view);
        int iS1 = s0(view2);
        byte b8 = iS0 < iS1 ? (byte) 1 : (byte) -1;
        if (this.f9026x) {
            if (b8 == 1) {
                h3(iS1, this.f9023u.i() - (this.f9023u.g(view2) + this.f9023u.e(view)));
                return;
            } else {
                h3(iS1, this.f9023u.i() - this.f9023u.d(view2));
                return;
            }
        }
        if (b8 == -1) {
            h3(iS1, this.f9023u.g(view2));
        } else {
            h3(iS1, this.f9023u.d(view2) - this.f9023u.e(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(AccessibilityEvent accessibilityEvent) {
        super.b1(accessibilityEvent);
        if (Q() > 0) {
            accessibilityEvent.setFromIndex(y2());
            accessibilityEvent.setToIndex(C2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean d2() {
        return (f0() == 1073741824 || A0() == 1073741824 || !B0()) ? false : true;
    }

    boolean e3() {
        return this.f9023u.l() == 0 && this.f9023u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i7) {
        q qVar = new q(recyclerView.getContext());
        qVar.q(i7);
        g2(qVar);
    }

    int g3(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (Q() == 0 || i7 == 0) {
            return 0;
        }
        r2();
        this.f9022t.f9048a = true;
        int i8 = i7 > 0 ? 1 : -1;
        int iAbs = Math.abs(i7);
        r3(i8, iAbs, true, a0Var);
        c cVar = this.f9022t;
        int iS2 = cVar.f9054g + s2(vVar, cVar, a0Var, false);
        if (iS2 < 0) {
            return 0;
        }
        if (iAbs > iS2) {
            i7 = i8 * iS2;
        }
        this.f9023u.t(-i7);
        this.f9022t.f9058k = i7;
        return i7;
    }

    public void h3(int i7, int i8) {
        this.A = i7;
        this.B = i8;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(String str) {
        if (this.D == null) {
            super.i(str);
        }
    }

    public void i3(int i7) {
        this.G = i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.D == null && this.f9024v == this.f9027y;
    }

    public void j3(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i7);
        }
        i(null);
        if (i7 != this.f9021s || this.f9023u == null) {
            w wVarB = w.b(this, i7);
            this.f9023u = wVarB;
            this.E.f9032a = wVarB;
            this.f9021s = i7;
            N1();
        }
    }

    protected void k2(@m0 RecyclerView.a0 a0Var, @m0 int[] iArr) {
        int i7;
        int iO2 = O2(a0Var);
        if (this.f9022t.f9053f == -1) {
            i7 = 0;
        } else {
            i7 = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i7;
    }

    public void k3(boolean z7) {
        this.C = z7;
    }

    void l2(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i7 = cVar.f9051d;
        if (i7 < 0 || i7 >= a0Var.d()) {
            return;
        }
        cVar2.a(i7, Math.max(0, cVar.f9054g));
    }

    public void l3(boolean z7) {
        i(null);
        if (z7 == this.f9025w) {
            return;
        }
        this.f9025w = z7;
        N1();
    }

    public void m3(boolean z7) {
        this.f9028z = z7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n() {
        return this.f9021s == 0;
    }

    public void n3(boolean z7) {
        i(null);
        if (this.f9027y == z7) {
            return;
        }
        this.f9027y = z7;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean o() {
        return this.f9021s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i7;
        int i8;
        int i9;
        int i10;
        int iK2;
        int i11;
        View viewJ;
        int iG;
        int i12;
        int i13 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.d() == 0) {
            D1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f9029a;
        }
        r2();
        this.f9022t.f9048a = false;
        f3();
        View viewD0 = d0();
        a aVar = this.E;
        if (!aVar.f9036e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f9035d = this.f9026x ^ this.f9027y;
            q3(vVar, a0Var, aVar2);
            this.E.f9036e = true;
        } else if (viewD0 != null && (this.f9023u.g(viewD0) >= this.f9023u.i() || this.f9023u.d(viewD0) <= this.f9023u.n())) {
            this.E.c(viewD0, s0(viewD0));
        }
        c cVar = this.f9022t;
        cVar.f9053f = cVar.f9058k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(a0Var, iArr);
        int iMax = Math.max(0, this.H[0]) + this.f9023u.n();
        int iMax2 = Math.max(0, this.H[1]) + this.f9023u.j();
        if (a0Var.j() && (i11 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewJ = J(i11)) != null) {
            if (this.f9026x) {
                i12 = this.f9023u.i() - this.f9023u.d(viewJ);
                iG = this.B;
            } else {
                iG = this.f9023u.g(viewJ) - this.f9023u.n();
                i12 = this.B;
            }
            int i14 = i12 - iG;
            if (i14 > 0) {
                iMax += i14;
            } else {
                iMax2 -= i14;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f9035d ? !this.f9026x : this.f9026x) {
            i13 = 1;
        }
        Z2(vVar, a0Var, aVar3, i13);
        z(vVar);
        this.f9022t.f9060m = e3();
        this.f9022t.f9057j = a0Var.j();
        this.f9022t.f9056i = 0;
        a aVar4 = this.E;
        if (aVar4.f9035d) {
            v3(aVar4);
            c cVar2 = this.f9022t;
            cVar2.f9055h = iMax;
            s2(vVar, cVar2, a0Var, false);
            c cVar3 = this.f9022t;
            i8 = cVar3.f9049b;
            int i15 = cVar3.f9051d;
            int i16 = cVar3.f9050c;
            if (i16 > 0) {
                iMax2 += i16;
            }
            t3(this.E);
            c cVar4 = this.f9022t;
            cVar4.f9055h = iMax2;
            cVar4.f9051d += cVar4.f9052e;
            s2(vVar, cVar4, a0Var, false);
            c cVar5 = this.f9022t;
            i7 = cVar5.f9049b;
            int i17 = cVar5.f9050c;
            if (i17 > 0) {
                u3(i15, i8);
                c cVar6 = this.f9022t;
                cVar6.f9055h = i17;
                s2(vVar, cVar6, a0Var, false);
                i8 = this.f9022t.f9049b;
            }
        } else {
            t3(aVar4);
            c cVar7 = this.f9022t;
            cVar7.f9055h = iMax2;
            s2(vVar, cVar7, a0Var, false);
            c cVar8 = this.f9022t;
            i7 = cVar8.f9049b;
            int i18 = cVar8.f9051d;
            int i19 = cVar8.f9050c;
            if (i19 > 0) {
                iMax += i19;
            }
            v3(this.E);
            c cVar9 = this.f9022t;
            cVar9.f9055h = iMax;
            cVar9.f9051d += cVar9.f9052e;
            s2(vVar, cVar9, a0Var, false);
            c cVar10 = this.f9022t;
            i8 = cVar10.f9049b;
            int i20 = cVar10.f9050c;
            if (i20 > 0) {
                s3(i18, i7);
                c cVar11 = this.f9022t;
                cVar11.f9055h = i20;
                s2(vVar, cVar11, a0Var, false);
                i7 = this.f9022t.f9049b;
            }
        }
        if (Q() > 0) {
            if (this.f9026x ^ this.f9027y) {
                int iK3 = K2(i7, vVar, a0Var, true);
                i9 = i8 + iK3;
                i10 = i7 + iK3;
                iK2 = L2(i9, vVar, a0Var, false);
            } else {
                int iL2 = L2(i8, vVar, a0Var, true);
                i9 = i8 + iL2;
                i10 = i7 + iL2;
                iK2 = K2(i10, vVar, a0Var, false);
            }
            i8 = i9 + iK2;
            i7 = i10 + iK2;
        }
        X2(vVar, a0Var, i8, i7);
        if (a0Var.j()) {
            this.E.e();
        } else {
            this.f9023u.u();
        }
        this.f9024v = this.f9027y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p1(RecyclerView.a0 a0Var) {
        super.p1(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    int p2(int i7) {
        if (i7 == 1) {
            return (this.f9021s != 1 && U2()) ? 1 : -1;
        }
        if (i7 == 2) {
            return (this.f9021s != 1 && U2()) ? -1 : 1;
        }
        if (i7 == 17) {
            return this.f9021s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i7 == 33) {
            return this.f9021s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i7 != 66) {
            return (i7 == 130 && this.f9021s == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f9021s == 0 ? 1 : Integer.MIN_VALUE;
    }

    c q2() {
        return new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r(int i7, int i8, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.f9021s != 0) {
            i7 = i8;
        }
        if (Q() == 0 || i7 == 0) {
            return;
        }
        r2();
        r3(i7 > 0 ? 1 : -1, Math.abs(i7), true, a0Var);
        l2(a0Var, this.f9022t, cVar);
    }

    void r2() {
        if (this.f9022t == null) {
            this.f9022t = q2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void s(int i7, RecyclerView.o.c cVar) {
        boolean z7;
        int i8;
        SavedState savedState = this.D;
        if (savedState == null || !savedState.a()) {
            f3();
            z7 = this.f9026x;
            i8 = this.A;
            if (i8 == -1) {
                i8 = z7 ? i7 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z7 = savedState2.f9031c;
            i8 = savedState2.f9029a;
        }
        int i9 = z7 ? -1 : 1;
        for (int i10 = 0; i10 < this.G && i8 >= 0 && i8 < i7; i10++) {
            cVar.a(i8, 0);
            i8 += i9;
        }
    }

    int s2(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z7) {
        int i7 = cVar.f9050c;
        int i8 = cVar.f9054g;
        if (i8 != Integer.MIN_VALUE) {
            if (i7 < 0) {
                cVar.f9054g = i8 + i7;
            }
            a3(vVar, cVar);
        }
        int i9 = cVar.f9050c + cVar.f9055h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f9060m && i9 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            W2(vVar, a0Var, cVar, bVar);
            if (!bVar.f9038b) {
                cVar.f9049b += bVar.f9037a * cVar.f9053f;
                if (!bVar.f9039c || cVar.f9059l != null || !a0Var.j()) {
                    int i10 = cVar.f9050c;
                    int i11 = bVar.f9037a;
                    cVar.f9050c = i10 - i11;
                    i9 -= i11;
                }
                int i12 = cVar.f9054g;
                if (i12 != Integer.MIN_VALUE) {
                    int i13 = i12 + bVar.f9037a;
                    cVar.f9054g = i13;
                    int i14 = cVar.f9050c;
                    if (i14 < 0) {
                        cVar.f9054g = i13 + i14;
                    }
                    a3(vVar, cVar);
                }
                if (z7 && bVar.f9040d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i7 - cVar.f9050c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return m2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            N1();
        }
    }

    public int t2() {
        View viewE2 = E2(0, Q(), true, false);
        if (viewE2 == null) {
            return -1;
        }
        return s0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return n2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable u1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (Q() > 0) {
            r2();
            boolean z7 = this.f9024v ^ this.f9026x;
            savedState.f9031c = z7;
            if (z7) {
                View viewM2 = M2();
                savedState.f9030b = this.f9023u.i() - this.f9023u.d(viewM2);
                savedState.f9029a = s0(viewM2);
            } else {
                View viewN2 = N2();
                savedState.f9029a = s0(viewN2);
                savedState.f9030b = this.f9023u.g(viewN2) - this.f9023u.n();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return o2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.a0 a0Var) {
        return m2(a0Var);
    }

    View w2(boolean z7, boolean z8) {
        return this.f9026x ? E2(0, Q(), z7, z8) : E2(Q() - 1, -1, z7, z8);
    }

    void w3() {
        Log.d(I, "validating child count " + Q());
        if (Q() < 1) {
            return;
        }
        int iS0 = s0(P(0));
        int iG = this.f9023u.g(P(0));
        if (this.f9026x) {
            for (int i7 = 1; i7 < Q(); i7++) {
                View viewP = P(i7);
                int iS1 = s0(viewP);
                int iG2 = this.f9023u.g(viewP);
                if (iS1 < iS0) {
                    Y2();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iG2 < iG);
                    throw new RuntimeException(sb.toString());
                }
                if (iG2 > iG) {
                    Y2();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i8 = 1; i8 < Q(); i8++) {
            View viewP2 = P(i8);
            int iS2 = s0(viewP2);
            int iG3 = this.f9023u.g(viewP2);
            if (iS2 < iS0) {
                Y2();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iG3 < iG);
                throw new RuntimeException(sb2.toString());
            }
            if (iG3 < iG) {
                Y2();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.a0 a0Var) {
        return n2(a0Var);
    }

    View x2(boolean z7, boolean z8) {
        return this.f9026x ? E2(Q() - 1, -1, z7, z8) : E2(0, Q(), z7, z8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.a0 a0Var) {
        return o2(a0Var);
    }

    public int y2() {
        View viewE2 = E2(0, Q(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return s0(viewE2);
    }

    public int z2() {
        View viewE2 = E2(Q() - 1, -1, true, false);
        if (viewE2 == null) {
            return -1;
        }
        return s0(viewE2);
    }

    public LinearLayoutManager(Context context, int i7, boolean z7) {
        this.f9021s = 1;
        this.f9025w = false;
        this.f9026x = false;
        this.f9027y = false;
        this.f9028z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        j3(i7);
        l3(z7);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f9021s = 1;
        this.f9025w = false;
        this.f9026x = false;
        this.f9027y = false;
        this.f9028z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d dVarT0 = RecyclerView.o.t0(context, attributeSet, i7, i8);
        j3(dVarT0.f9220a);
        l3(dVarT0.f9222c);
        n3(dVarT0.f9223d);
    }
}
