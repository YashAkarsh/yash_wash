package androidx.constraintlayout.core.state.helpers;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.constraintlayout.core.state.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private float f3339n0;

    public a(androidx.constraintlayout.core.state.h hVar) {
        super(hVar, androidx.constraintlayout.core.state.h.e.ALIGN_VERTICALLY);
        this.f3339n0 = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.c, androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
        Iterator<Object> it = this.f3286l0.iterator();
        while (it.hasNext()) {
            androidx.constraintlayout.core.state.a aVarE = this.f3284j0.e(it.next());
            aVarE.u();
            Object obj = this.O;
            if (obj != null) {
                aVarE.A0(obj);
            } else {
                Object obj2 = this.P;
                if (obj2 != null) {
                    aVarE.z0(obj2);
                } else {
                    aVarE.A0(androidx.constraintlayout.core.state.h.f3294j);
                }
            }
            Object obj3 = this.Q;
            if (obj3 != null) {
                aVarE.A(obj3);
            } else {
                Object obj4 = this.R;
                if (obj4 != null) {
                    aVarE.z(obj4);
                } else {
                    aVarE.z(androidx.constraintlayout.core.state.h.f3294j);
                }
            }
            float f8 = this.f3339n0;
            if (f8 != 0.5f) {
                aVarE.X(f8);
            }
        }
    }
}
