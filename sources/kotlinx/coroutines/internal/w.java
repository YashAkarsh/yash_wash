package kotlinx.coroutines.internal;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public class w extends y {
    @Override // kotlinx.coroutines.internal.y
    public boolean L0() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.e
    protected y N0() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.y
    public /* bridge */ /* synthetic */ boolean O0() {
        return ((Boolean) X0()).booleanValue();
    }

    public final /* synthetic */ <T extends y> void V0(i5.l<? super T, l2> lVar) {
        for (y yVarH0 = (y) G0(); !kotlin.jvm.internal.l0.g(yVarH0, this); yVarH0 = yVarH0.H0()) {
            kotlin.jvm.internal.l0.y(3, "T");
            if (yVarH0 instanceof y) {
                lVar.z(yVarH0);
            }
        }
    }

    public final boolean W0() {
        return G0() == this;
    }

    @a7.d
    public final Void X0() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final void Y0() {
        y yVar = (y) G0();
        y yVar2 = this;
        while (!kotlin.jvm.internal.l0.g(yVar, this)) {
            y yVarH0 = yVar.H0();
            yVar.U0(yVar2, yVarH0);
            yVar2 = yVar;
            yVar = yVarH0;
        }
        U0(yVar2, (y) G0());
    }
}
