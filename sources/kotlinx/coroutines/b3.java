package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class b3 extends kotlinx.coroutines.internal.w implements h2 {
    @Override // kotlinx.coroutines.h2
    @a7.d
    public b3 D() {
        return this;
    }

    @a7.d
    public final String Z0(@a7.d String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z7 = true;
        for (kotlinx.coroutines.internal.y yVarH0 = (kotlinx.coroutines.internal.y) G0(); !kotlin.jvm.internal.l0.g(yVarH0, this); yVarH0 = yVarH0.H0()) {
            if (yVarH0 instanceof v2) {
                v2 v2Var = (v2) yVarH0;
                if (z7) {
                    z7 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(v2Var);
            }
        }
        sb.append("]");
        String string = sb.toString();
        kotlin.jvm.internal.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.h2
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.d
    public String toString() {
        return super.toString();
    }
}
