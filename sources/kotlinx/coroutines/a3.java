package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a3 extends o0 {
    @Override // kotlinx.coroutines.o0
    @a7.d
    public o0 a1(int i7) {
        kotlinx.coroutines.internal.t.a(i7);
        return this;
    }

    @a7.d
    public abstract a3 e1();

    @j2
    @a7.e
    protected final String i1() {
        a3 a3VarE1;
        a3 a3VarE = n1.e();
        if (this == a3VarE) {
            return "Dispatchers.Main";
        }
        try {
            a3VarE1 = a3VarE.e1();
        } catch (UnsupportedOperationException unused) {
            a3VarE1 = null;
        }
        if (this == a3VarE1) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        String strI1 = i1();
        if (strI1 != null) {
            return strI1;
        }
        return a1.a(this) + '@' + a1.b(this);
    }
}
