package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n0<R> implements e0<R>, Serializable {
    private final int arity;

    public n0(int i7) {
        this.arity = i7;
    }

    @Override // kotlin.jvm.internal.e0
    public int getArity() {
        return this.arity;
    }

    @a7.d
    public String toString() {
        String strX = l1.x(this);
        l0.o(strX, "renderLambdaToString(this)");
        return strX;
    }
}
