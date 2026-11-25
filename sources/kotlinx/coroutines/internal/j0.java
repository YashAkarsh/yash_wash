package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {
    @a7.e
    public abstract d<?> a();

    public final boolean b(@a7.d j0 j0Var) {
        d<?> dVarA;
        d<?> dVarA2 = a();
        return (dVarA2 == null || (dVarA = j0Var.a()) == null || dVarA2.g() >= dVarA.g()) ? false : true;
    }

    @a7.e
    public abstract Object c(@a7.e Object obj);

    @a7.d
    public String toString() {
        return kotlinx.coroutines.a1.a(this) + '@' + kotlinx.coroutines.a1.b(this);
    }
}
