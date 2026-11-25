package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f9671j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f9672k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f9673l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f9674m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f9675n = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f9680e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f9684i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f9676a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f9681f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f9682g = 0;

    p() {
    }

    boolean a(RecyclerView.a0 a0Var) {
        int i7 = this.f9678c;
        return i7 >= 0 && i7 < a0Var.d();
    }

    View b(RecyclerView.v vVar) {
        View viewP = vVar.p(this.f9678c);
        this.f9678c += this.f9679d;
        return viewP;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f9677b + ", mCurrentPosition=" + this.f9678c + ", mItemDirection=" + this.f9679d + ", mLayoutDirection=" + this.f9680e + ", mStartLine=" + this.f9681f + ", mEndLine=" + this.f9682g + '}';
    }
}
