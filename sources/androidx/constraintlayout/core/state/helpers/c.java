package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.widgets.j;

/* JADX INFO: loaded from: classes.dex */
public class c extends androidx.constraintlayout.core.state.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private androidx.constraintlayout.core.state.h.d f3341n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f3342o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.a f3343p0;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3344a;

        static {
            int[] iArr = new int[androidx.constraintlayout.core.state.h.d.values().length];
            f3344a = iArr;
            try {
                iArr[androidx.constraintlayout.core.state.h.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3344a[androidx.constraintlayout.core.state.h.d.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3344a[androidx.constraintlayout.core.state.h.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3344a[androidx.constraintlayout.core.state.h.d.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3344a[androidx.constraintlayout.core.state.h.d.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3344a[androidx.constraintlayout.core.state.h.d.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public c(androidx.constraintlayout.core.state.h hVar) {
        super(hVar, androidx.constraintlayout.core.state.h.e.BARRIER);
    }

    @Override // androidx.constraintlayout.core.state.c
    public j M0() {
        if (this.f3343p0 == null) {
            this.f3343p0 = new androidx.constraintlayout.core.widgets.a();
        }
        return this.f3343p0;
    }

    public void P0(androidx.constraintlayout.core.state.h.d dVar) {
        this.f3341n0 = dVar;
    }

    @Override // androidx.constraintlayout.core.state.c, androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
        M0();
        int i7 = a.f3344a[this.f3341n0.ordinal()];
        int i8 = 3;
        if (i7 == 3 || i7 == 4) {
            i8 = 1;
        } else if (i7 == 5) {
            i8 = 2;
        } else if (i7 != 6) {
            i8 = 0;
        }
        this.f3343p0.u2(i8);
        this.f3343p0.v2(this.f3342o0);
    }

    @Override // androidx.constraintlayout.core.state.a
    public androidx.constraintlayout.core.state.a b0(int i7) {
        this.f3342o0 = i7;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.a
    public androidx.constraintlayout.core.state.a c0(Object obj) {
        b0(this.f3284j0.f(obj));
        return this;
    }
}
