package androidx.constraintlayout.core.state.helpers;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.constraintlayout.core.state.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f3340n0;

    public b(androidx.constraintlayout.core.state.h hVar) {
        super(hVar, androidx.constraintlayout.core.state.h.e.ALIGN_VERTICALLY);
        this.f3340n0 = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.c, androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
        Iterator<Object> it = this.f3286l0.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.core.state.a aVarE = this.f3284j0.e(it.next());
            aVarE.v();
            Object obj = this.S;
            if (obj != null) {
                aVarE.D0(obj);
            } else {
                Object obj2 = this.T;
                if (obj2 != null) {
                    aVarE.C0(obj2);
                } else {
                    aVarE.D0(androidx.constraintlayout.core.state.h.f3294j);
                }
            }
            Object obj3 = this.U;
            if (obj3 != null) {
                aVarE.p(obj3);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    aVarE.o(obj4);
                } else {
                    aVarE.o(androidx.constraintlayout.core.state.h.f3294j);
                }
            }
            float f8 = this.f3340n0;
            if (f8 != 0.5f) {
                aVarE.I0(f8);
            }
        }
    }
}
