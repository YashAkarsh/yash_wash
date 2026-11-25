package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.l0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean X = false;
    private static final String Y = "GridLayoutManager";
    public static final int Z = -1;
    boolean O;
    int P;
    int[] Q;
    View[] R;
    final SparseIntArray S;
    final SparseIntArray T;
    b U;
    final Rect V;
    private boolean W;

    public static final class a extends b {
        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int e(int i7, int i8) {
            return i7 % i8;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i7) {
            return 1;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f9016a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseIntArray f9017b = new SparseIntArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9018c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9019d = false;

        static int a(SparseIntArray sparseIntArray, int i7) {
            int size = sparseIntArray.size() - 1;
            int i8 = 0;
            while (i8 <= size) {
                int i9 = (i8 + size) >>> 1;
                if (sparseIntArray.keyAt(i9) < i7) {
                    i8 = i9 + 1;
                } else {
                    size = i9 - 1;
                }
            }
            int i10 = i8 - 1;
            if (i10 < 0 || i10 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i10);
        }

        int b(int i7, int i8) {
            if (!this.f9019d) {
                return d(i7, i8);
            }
            int i9 = this.f9017b.get(i7, -1);
            if (i9 != -1) {
                return i9;
            }
            int iD = d(i7, i8);
            this.f9017b.put(i7, iD);
            return iD;
        }

        int c(int i7, int i8) {
            if (!this.f9018c) {
                return e(i7, i8);
            }
            int i9 = this.f9016a.get(i7, -1);
            if (i9 != -1) {
                return i9;
            }
            int iE = e(i7, i8);
            this.f9016a.put(i7, iE);
            return iE;
        }

        public int d(int i7, int i8) {
            int i9;
            int i10;
            int iC;
            int iA;
            if (!this.f9019d || (iA = a(this.f9017b, i7)) == -1) {
                i9 = 0;
                i10 = 0;
                iC = 0;
            } else {
                i9 = this.f9017b.get(iA);
                i10 = iA + 1;
                iC = c(iA, i8) + f(iA);
                if (iC == i8) {
                    i9++;
                    iC = 0;
                }
            }
            int iF = f(i7);
            while (i10 < i7) {
                int iF2 = f(i10);
                iC += iF2;
                if (iC == i8) {
                    i9++;
                    iC = 0;
                } else if (iC > i8) {
                    i9++;
                    iC = iF2;
                }
                i10++;
            }
            return iC + iF > i8 ? i9 + 1 : i9;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0024  */
        /* JADX WARN: Code duplicated, block: B:14:0x002b  */
        /* JADX WARN: Code duplicated, block: B:15:0x002d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f9018c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f9016a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f9016a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b.e(int, int):int");
        }

        public abstract int f(int i7);

        public void g() {
            this.f9017b.clear();
        }

        public void h() {
            this.f9016a.clear();
        }

        public boolean i() {
            return this.f9019d;
        }

        public boolean j() {
            return this.f9018c;
        }

        public void k(boolean z7) {
            if (!z7) {
                this.f9017b.clear();
            }
            this.f9019d = z7;
        }

        public void l(boolean z7) {
            if (!z7) {
                this.f9017b.clear();
            }
            this.f9018c = z7;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.O = false;
        this.P = -1;
        this.S = new SparseIntArray();
        this.T = new SparseIntArray();
        this.U = new a();
        this.V = new Rect();
        Q3(RecyclerView.o.t0(context, attributeSet, i7, i8).f9221b);
    }

    static int[] A3(int[] iArr, int i7, int i8) {
        int i9;
        if (iArr == null || iArr.length != i7 + 1 || iArr[iArr.length - 1] != i8) {
            iArr = new int[i7 + 1];
        }
        int i10 = 0;
        iArr[0] = 0;
        int i11 = i8 / i7;
        int i12 = i8 % i7;
        int i13 = 0;
        for (int i14 = 1; i14 <= i7; i14++) {
            i10 += i12;
            if (i10 <= 0 || i7 - i10 >= i12) {
                i9 = i11;
            } else {
                i9 = i11 + 1;
                i10 -= i7;
            }
            i13 += i9;
            iArr[i14] = i13;
        }
        return iArr;
    }

    private void B3() {
        this.S.clear();
        this.T.clear();
    }

    private int C3(RecyclerView.a0 a0Var) {
        if (Q() != 0 && a0Var.d() != 0) {
            r2();
            boolean zV2 = V2();
            View viewX2 = x2(!zV2, true);
            View viewW2 = w2(!zV2, true);
            if (viewX2 != null && viewW2 != null) {
                int iB = this.U.b(s0(viewX2), this.P);
                int iB2 = this.U.b(s0(viewW2), this.P);
                int iMax = this.f9026x ? Math.max(0, ((this.U.b(a0Var.d() - 1, this.P) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zV2) {
                    return Math.round((iMax * (Math.abs(this.f9023u.d(viewW2) - this.f9023u.g(viewX2)) / ((this.U.b(s0(viewW2), this.P) - this.U.b(s0(viewX2), this.P)) + 1))) + (this.f9023u.n() - this.f9023u.g(viewX2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int D3(RecyclerView.a0 a0Var) {
        if (Q() != 0 && a0Var.d() != 0) {
            r2();
            View viewX2 = x2(!V2(), true);
            View viewW2 = w2(!V2(), true);
            if (viewX2 != null && viewW2 != null) {
                if (!V2()) {
                    return this.U.b(a0Var.d() - 1, this.P) + 1;
                }
                return (int) (((this.f9023u.d(viewW2) - this.f9023u.g(viewX2)) / ((this.U.b(s0(viewW2), this.P) - this.U.b(s0(viewX2), this.P)) + 1)) * (this.U.b(a0Var.d() - 1, this.P) + 1));
            }
        }
        return 0;
    }

    private void E3(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i7) {
        boolean z7 = i7 == 1;
        int iJ3 = J3(vVar, a0Var, aVar.f9033b);
        if (z7) {
            while (iJ3 > 0) {
                int i8 = aVar.f9033b;
                if (i8 <= 0) {
                    return;
                }
                int i9 = i8 - 1;
                aVar.f9033b = i9;
                iJ3 = J3(vVar, a0Var, i9);
            }
            return;
        }
        int iD = a0Var.d() - 1;
        int i10 = aVar.f9033b;
        while (i10 < iD) {
            int i11 = i10 + 1;
            int iJ4 = J3(vVar, a0Var, i11);
            if (iJ4 <= iJ3) {
                break;
            }
            i10 = i11;
            iJ3 = iJ4;
        }
        aVar.f9033b = i10;
    }

    private void F3() {
        View[] viewArr = this.R;
        if (viewArr == null || viewArr.length != this.P) {
            this.R = new View[this.P];
        }
    }

    private int I3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7) {
        if (!a0Var.j()) {
            return this.U.b(i7, this.P);
        }
        int iG = vVar.g(i7);
        if (iG != -1) {
            return this.U.b(iG, this.P);
        }
        Log.w(Y, "Cannot find span size for pre layout position. " + i7);
        return 0;
    }

    private int J3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7) {
        if (!a0Var.j()) {
            return this.U.c(i7, this.P);
        }
        int i8 = this.T.get(i7, -1);
        if (i8 != -1) {
            return i8;
        }
        int iG = vVar.g(i7);
        if (iG != -1) {
            return this.U.c(iG, this.P);
        }
        Log.w(Y, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i7);
        return 0;
    }

    private int K3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7) {
        if (!a0Var.j()) {
            return this.U.f(i7);
        }
        int i8 = this.S.get(i7, -1);
        if (i8 != -1) {
            return i8;
        }
        int iG = vVar.g(i7);
        if (iG != -1) {
            return this.U.f(iG);
        }
        Log.w(Y, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i7);
        return 1;
    }

    private void M3(float f8, int i7) {
        z3(Math.max(Math.round(f8 * this.P), i7));
    }

    private void O3(View view, int i7, boolean z7) {
        int iR;
        int iR2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f9115b;
        int i8 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i9 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int iG3 = G3(layoutParams.f9014e, layoutParams.f9015f);
        if (this.f9021s == 1) {
            iR2 = RecyclerView.o.R(iG3, i7, i9, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            iR = RecyclerView.o.R(this.f9023u.o(), f0(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int iR3 = RecyclerView.o.R(iG3, i7, i8, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int iR4 = RecyclerView.o.R(this.f9023u.o(), A0(), i9, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            iR = iR3;
            iR2 = iR4;
        }
        P3(view, iR2, iR, z7);
    }

    private void P3(View view, int i7, int i8, boolean z7) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z7 ? e2(view, i7, i8, layoutParams) : c2(view, i7, i8, layoutParams)) {
            view.measure(i7, i8);
        }
    }

    private void T3() {
        int iE0;
        int iR0;
        if (Q2() == 1) {
            iE0 = z0() - p0();
            iR0 = o0();
        } else {
            iE0 = e0() - m0();
            iR0 = r0();
        }
        z3(iE0 - iR0);
    }

    private void x3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i7, boolean z7) {
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        if (z7) {
            i10 = 1;
            i9 = i7;
            i8 = 0;
        } else {
            i8 = i7 - 1;
            i9 = -1;
            i10 = -1;
        }
        while (i8 != i9) {
            View view = this.R[i8];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int iK3 = K3(vVar, a0Var, s0(view));
            layoutParams.f9015f = iK3;
            layoutParams.f9014e = i11;
            i11 += iK3;
            i8 += i10;
        }
    }

    private void y3() {
        int iQ = Q();
        for (int i7 = 0; i7 < iQ; i7++) {
            LayoutParams layoutParams = (LayoutParams) P(i7).getLayoutParams();
            int iB = layoutParams.b();
            this.S.put(iB, layoutParams.i());
            this.T.put(iB, layoutParams.h());
        }
    }

    private void z3(int i7) {
        this.Q = A3(this.Q, this.P, i7);
    }

    int G3(int i7, int i8) {
        if (this.f9021s != 1 || !U2()) {
            int[] iArr = this.Q;
            return iArr[i8 + i7] - iArr[i7];
        }
        int[] iArr2 = this.Q;
        int i9 = this.P;
        return iArr2[i9 - i7] - iArr2[(i9 - i7) - i8];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (iS0 >= 0 && iS0 < i9 && J3(vVar, a0Var, iS0) == 0) {
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

    public int H3() {
        return this.P;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams K() {
        return this.f9021s == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams L(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public b L3() {
        return this.U;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams M(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public boolean N3() {
        return this.W;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        T3();
        F3();
        return super.Q1(i7, vVar, a0Var);
    }

    public void Q3(int i7) {
        if (i7 == this.P) {
            return;
        }
        this.O = true;
        if (i7 >= 1) {
            this.P = i7;
            this.U.h();
            N1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i7);
        }
    }

    public void R3(b bVar) {
        this.U = bVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i7, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        T3();
        F3();
        return super.S1(i7, vVar, a0Var);
    }

    public void S3(boolean z7) {
        this.W = z7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int V(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f9021s == 1) {
            return this.P;
        }
        if (a0Var.d() < 1) {
            return 0;
        }
        return I3(vVar, a0Var, a0Var.d() - 1) + 1;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0211  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void W2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i7;
        int i8;
        int iF;
        int i9;
        int i10;
        int i11;
        int i12;
        int iF2;
        int iF3;
        int i13;
        int i14;
        int iR;
        int iR2;
        View viewE;
        int iM = this.f9023u.m();
        boolean z7 = iM != 1073741824;
        int i15 = Q() > 0 ? this.Q[this.P] : 0;
        if (z7) {
            T3();
        }
        boolean z8 = cVar.f9052e == 1;
        int iJ3 = this.P;
        if (!z8) {
            iJ3 = J3(vVar, a0Var, cVar.f9051d) + K3(vVar, a0Var, cVar.f9051d);
        }
        int i16 = 0;
        while (i16 < this.P && cVar.c(a0Var) && iJ3 > 0) {
            int i17 = cVar.f9051d;
            int iK3 = K3(vVar, a0Var, i17);
            if (iK3 > this.P) {
                throw new IllegalArgumentException("Item at position " + i17 + " requires " + iK3 + " spans but GridLayoutManager has only " + this.P + " spans.");
            }
            iJ3 -= iK3;
            if (iJ3 < 0 || (viewE = cVar.e(vVar)) == null) {
                break;
            }
            this.R[i16] = viewE;
            i16++;
        }
        if (i16 == 0) {
            bVar.f9038b = true;
            return;
        }
        x3(vVar, a0Var, i16, z8);
        float f8 = 0.0f;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            View view = this.R[i19];
            if (cVar.f9059l == null) {
                if (z8) {
                    e(view);
                } else {
                    f(view, 0);
                }
            } else if (z8) {
                c(view);
            } else {
                d(view, 0);
            }
            m(view, this.V);
            O3(view, iM, false);
            int iE = this.f9023u.e(view);
            if (iE > i18) {
                i18 = iE;
            }
            float f9 = (this.f9023u.f(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).f9015f;
            if (f9 > f8) {
                f8 = f9;
            }
        }
        if (z7) {
            M3(f8, i15);
            i18 = 0;
            for (int i20 = 0; i20 < i16; i20++) {
                View view2 = this.R[i20];
                O3(view2, 1073741824, true);
                int iE2 = this.f9023u.e(view2);
                if (iE2 > i18) {
                    i18 = iE2;
                }
            }
        }
        for (int i21 = 0; i21 < i16; i21++) {
            View view3 = this.R[i21];
            if (this.f9023u.e(view3) != i18) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f9115b;
                int i22 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i23 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int iG3 = G3(layoutParams.f9014e, layoutParams.f9015f);
                if (this.f9021s == 1) {
                    iR2 = RecyclerView.o.R(iG3, 1073741824, i23, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    iR = View.MeasureSpec.makeMeasureSpec(i18 - i22, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i23, 1073741824);
                    iR = RecyclerView.o.R(iG3, 1073741824, i22, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    iR2 = iMakeMeasureSpec;
                }
                P3(view3, iR2, iR, true);
            }
        }
        bVar.f9037a = i18;
        if (this.f9021s == 1) {
            if (cVar.f9053f == -1) {
                i11 = cVar.f9049b;
                i14 = i11 - i18;
            } else {
                i14 = cVar.f9049b;
                i11 = i14 + i18;
            }
            i9 = i14;
            i10 = 0;
            iF = 0;
        } else {
            if (cVar.f9053f == -1) {
                i8 = cVar.f9049b;
                i7 = i8 - i18;
            } else {
                i7 = cVar.f9049b;
                i8 = i7 + i18;
            }
            iF = i7;
            i9 = 0;
            i10 = i8;
            i11 = 0;
        }
        int i24 = 0;
        while (i24 < i16) {
            View view4 = this.R[i24];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f9021s == 1) {
                if (U2()) {
                    int iO0 = o0() + this.Q[this.P - layoutParams2.f9014e];
                    iF = iO0 - this.f9023u.f(view4);
                    iF3 = i11;
                    iF2 = iO0;
                    i12 = i9;
                } else {
                    int iO1 = o0() + this.Q[layoutParams2.f9014e];
                    iF3 = i11;
                    i13 = iO1;
                    i12 = i9;
                    iF2 = this.f9023u.f(view4) + iO1;
                }
                P0(view4, i13, i12, iF2, iF3);
                if (layoutParams2.e() || layoutParams2.d()) {
                    bVar.f9039c = true;
                }
                bVar.f9040d |= view4.hasFocusable();
                i24++;
                i11 = iF3;
                i10 = iF2;
                i9 = i12;
                iF = i13;
            } else {
                int iR0 = r0() + this.Q[layoutParams2.f9014e];
                i12 = iR0;
                iF2 = i10;
                iF3 = this.f9023u.f(view4) + iR0;
            }
            i13 = iF;
            P0(view4, i13, i12, iF2, iF3);
            if (layoutParams2.e()) {
                bVar.f9039c = true;
            } else {
                bVar.f9039c = true;
            }
            bVar.f9040d |= view4.hasFocusable();
            i24++;
            i11 = iF3;
            i10 = iF2;
            i9 = i12;
            iF = i13;
        }
        Arrays.fill(this.R, (Object) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y1(Rect rect, int i7, int i8) {
        int iQ;
        int iQ2;
        if (this.Q == null) {
            super.Y1(rect, i7, i8);
        }
        int iO0 = o0() + p0();
        int iR0 = r0() + m0();
        if (this.f9021s == 1) {
            iQ2 = RecyclerView.o.q(i8, rect.height() + iR0, k0());
            int[] iArr = this.Q;
            iQ = RecyclerView.o.q(i7, iArr[iArr.length - 1] + iO0, l0());
        } else {
            iQ = RecyclerView.o.q(i7, rect.width() + iO0, l0());
            int[] iArr2 = this.Q;
            iQ2 = RecyclerView.o.q(i8, iArr2[iArr2.length - 1] + iR0, k0());
        }
        X1(iQ, iQ2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void Z2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i7) {
        super.Z2(vVar, a0Var, aVar, i7);
        T3();
        if (a0Var.d() > 0 && !a0Var.j()) {
            E3(vVar, a0Var, aVar, i7);
        }
        F3();
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View a1(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a1(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g1(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, l0 l0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.f1(view, l0Var);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int iI3 = I3(vVar, a0Var, layoutParams2.b());
        if (this.f9021s == 0) {
            l0Var.Z0(l0.c.h(layoutParams2.h(), layoutParams2.i(), iI3, 1, false, false));
        } else {
            l0Var.Z0(l0.c.h(iI3, 1, layoutParams2.h(), layoutParams2.i(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(RecyclerView recyclerView, int i7, int i8) {
        this.U.h();
        this.U.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void j1(RecyclerView recyclerView) {
        this.U.h();
        this.U.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.D == null && !this.O;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(RecyclerView recyclerView, int i7, int i8, int i9) {
        this.U.h();
        this.U.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l1(RecyclerView recyclerView, int i7, int i8) {
        this.U.h();
        this.U.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void l2(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int iF = this.P;
        for (int i7 = 0; i7 < this.P && cVar.c(a0Var) && iF > 0; i7++) {
            int i8 = cVar.f9051d;
            cVar2.a(i8, Math.max(0, cVar.f9054g));
            iF -= this.U.f(i8);
            cVar.f9051d += cVar.f9052e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n1(RecyclerView recyclerView, int i7, int i8, Object obj) {
        this.U.h();
        this.U.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void n3(boolean z7) {
        if (z7) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.n3(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void o1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.j()) {
            y3();
        }
        super.o1(vVar, a0Var);
        B3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean p(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void p1(RecyclerView.a0 a0Var) {
        super.p1(a0Var);
        this.O = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return this.W ? C3(a0Var) : super.u(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return this.W ? D3(a0Var) : super.v(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f9021s == 0) {
            return this.P;
        }
        if (a0Var.d() < 1) {
            return 0;
        }
        return I3(vVar, a0Var, a0Var.d() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int x(RecyclerView.a0 a0Var) {
        return this.W ? C3(a0Var) : super.x(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y(RecyclerView.a0 a0Var) {
        return this.W ? D3(a0Var) : super.y(a0Var);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f9013g = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9014e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9015f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9014e = -1;
            this.f9015f = 0;
        }

        public int h() {
            return this.f9014e;
        }

        public int i() {
            return this.f9015f;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f9014e = -1;
            this.f9015f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9014e = -1;
            this.f9015f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9014e = -1;
            this.f9015f = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9014e = -1;
            this.f9015f = 0;
        }
    }

    public GridLayoutManager(Context context, int i7) {
        super(context);
        this.O = false;
        this.P = -1;
        this.S = new SparseIntArray();
        this.T = new SparseIntArray();
        this.U = new a();
        this.V = new Rect();
        Q3(i7);
    }

    public GridLayoutManager(Context context, int i7, int i8, boolean z7) {
        super(context, i8, z7);
        this.O = false;
        this.P = -1;
        this.S = new SparseIntArray();
        this.T = new SparseIntArray();
        this.U = new a();
        this.V = new Rect();
        Q3(i7);
    }
}
