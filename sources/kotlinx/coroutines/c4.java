package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class c4 extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final c4 f35537b = new c4();

    private c4() {
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        f4 f4Var = (f4) gVar.get(f4.f36001b);
        if (f4Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        f4Var.f36002a = true;
    }

    @Override // kotlinx.coroutines.o0
    public boolean Y0(@a7.d kotlin.coroutines.g gVar) {
        return false;
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    @d2
    public o0 a1(int i7) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
