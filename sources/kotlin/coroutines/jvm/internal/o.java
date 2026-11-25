package kotlin.coroutines.jvm.internal;

import kotlin.g1;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.l1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class o extends d implements e0<Object>, n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34715d;

    public o(int i7, @a7.e kotlin.coroutines.d<Object> dVar) {
        super(dVar);
        this.f34715d = i7;
    }

    @Override // kotlin.jvm.internal.e0
    public int getArity() {
        return this.f34715d;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @a7.d
    public String toString() {
        if (F() != null) {
            return super.toString();
        }
        String strW = l1.w(this);
        l0.o(strW, "renderLambdaToString(this)");
        return strW;
    }

    public o(int i7) {
        this(i7, null);
    }
}
