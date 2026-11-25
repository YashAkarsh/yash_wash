package androidx.constraintlayout.core.state.helpers;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3354a;

        static {
            int[] iArr = new int[androidx.constraintlayout.core.state.h.b.values().length];
            f3354a = iArr;
            try {
                iArr[androidx.constraintlayout.core.state.h.b.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3354a[androidx.constraintlayout.core.state.h.b.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3354a[androidx.constraintlayout.core.state.h.b.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(androidx.constraintlayout.core.state.h hVar) {
        super(hVar, androidx.constraintlayout.core.state.h.e.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.c, androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.e
    public void apply() {
        Iterator<Object> it = this.f3286l0.iterator();
        while (it.hasNext()) {
            this.f3284j0.e(it.next()).u();
        }
        Iterator<Object> it2 = this.f3286l0.iterator();
        androidx.constraintlayout.core.state.a aVar = null;
        androidx.constraintlayout.core.state.a aVar2 = null;
        while (it2.hasNext()) {
            androidx.constraintlayout.core.state.a aVarE = this.f3284j0.e(it2.next());
            if (aVar2 == null) {
                Object obj = this.O;
                if (obj != null) {
                    aVarE.A0(obj).b0(this.f3249m).d0(this.f3255s);
                } else {
                    Object obj2 = this.P;
                    if (obj2 != null) {
                        aVarE.z0(obj2).b0(this.f3249m).d0(this.f3255s);
                    } else {
                        Object obj3 = this.K;
                        if (obj3 != null) {
                            aVarE.A0(obj3).b0(this.f3247k).d0(this.f3253q);
                        } else {
                            Object obj4 = this.L;
                            if (obj4 != null) {
                                aVarE.z0(obj4).b0(this.f3247k).d0(this.f3253q);
                            } else {
                                aVarE.A0(androidx.constraintlayout.core.state.h.f3294j);
                            }
                        }
                    }
                }
                aVar2 = aVarE;
            }
            if (aVar != null) {
                aVar.A(aVarE.getKey());
                aVarE.z0(aVar.getKey());
            }
            aVar = aVarE;
        }
        if (aVar != null) {
            Object obj5 = this.Q;
            if (obj5 != null) {
                aVar.A(obj5).b0(this.f3250n).d0(this.f3256t);
            } else {
                Object obj6 = this.R;
                if (obj6 != null) {
                    aVar.z(obj6).b0(this.f3250n).d0(this.f3256t);
                } else {
                    Object obj7 = this.M;
                    if (obj7 != null) {
                        aVar.A(obj7).b0(this.f3248l).d0(this.f3254r);
                    } else {
                        Object obj8 = this.N;
                        if (obj8 != null) {
                            aVar.z(obj8).b0(this.f3248l).d0(this.f3254r);
                        } else {
                            aVar.z(androidx.constraintlayout.core.state.h.f3294j);
                        }
                    }
                }
            }
        }
        if (aVar2 == null) {
            return;
        }
        float f8 = this.f3345n0;
        if (f8 != 0.5f) {
            aVar2.X(f8);
        }
        int i7 = a.f3354a[this.f3346o0.ordinal()];
        if (i7 == 1) {
            aVar2.r0(0);
        } else if (i7 == 2) {
            aVar2.r0(1);
        } else {
            if (i7 != 3) {
                return;
            }
            aVar2.r0(2);
        }
    }
}
