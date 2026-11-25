package androidx.constraintlayout.core.state.helpers;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3355a;

        static {
            int[] iArr = new int[androidx.constraintlayout.core.state.h.b.values().length];
            f3355a = iArr;
            try {
                iArr[androidx.constraintlayout.core.state.h.b.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3355a[androidx.constraintlayout.core.state.h.b.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3355a[androidx.constraintlayout.core.state.h.b.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(androidx.constraintlayout.core.state.h hVar) {
        super(hVar, androidx.constraintlayout.core.state.h.e.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.c, androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
        Iterator<Object> it = this.f3286l0.iterator();
        while (it.hasNext()) {
            this.f3284j0.e(it.next()).v();
        }
        Iterator<Object> it2 = this.f3286l0.iterator();
        androidx.constraintlayout.core.state.a aVar = null;
        androidx.constraintlayout.core.state.a aVar2 = null;
        while (it2.hasNext()) {
            androidx.constraintlayout.core.state.a aVarE = this.f3284j0.e(it2.next());
            if (aVar2 == null) {
                Object obj = this.S;
                if (obj != null) {
                    aVarE.D0(obj).b0(this.f3251o).d0(this.f3257u);
                } else {
                    Object obj2 = this.T;
                    if (obj2 != null) {
                        aVarE.C0(obj2).b0(this.f3251o).d0(this.f3257u);
                    } else {
                        aVarE.D0(androidx.constraintlayout.core.state.h.f3294j);
                    }
                }
                aVar2 = aVarE;
            }
            if (aVar != null) {
                aVar.p(aVarE.getKey());
                aVarE.C0(aVar.getKey());
            }
            aVar = aVarE;
        }
        if (aVar != null) {
            Object obj3 = this.U;
            if (obj3 != null) {
                aVar.p(obj3).b0(this.f3252p).d0(this.f3258v);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    aVar.o(obj4).b0(this.f3252p).d0(this.f3258v);
                } else {
                    aVar.o(androidx.constraintlayout.core.state.h.f3294j);
                }
            }
        }
        if (aVar2 == null) {
            return;
        }
        float f8 = this.f3345n0;
        if (f8 != 0.5f) {
            aVar2.I0(f8);
        }
        int i7 = a.f3355a[this.f3346o0.ordinal()];
        if (i7 == 1) {
            aVar2.u0(0);
        } else if (i7 == 2) {
            aVar2.u0(1);
        } else {
            if (i7 != 3) {
                return;
            }
            aVar2.u0(2);
        }
    }
}
