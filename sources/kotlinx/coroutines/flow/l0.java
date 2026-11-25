package kotlinx.coroutines.flow;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends kotlinx.coroutines.flow.internal.d<j0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public long f36504a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    @a7.e
    public kotlin.coroutines.d<? super l2> f36505b;

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@a7.d j0<?> j0Var) {
        if (this.f36504a >= 0) {
            return false;
        }
        this.f36504a = j0Var.f0();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @a7.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.d<l2>[] b(@a7.d j0<?> j0Var) {
        long j7 = this.f36504a;
        this.f36504a = -1L;
        this.f36505b = null;
        return j0Var.e0(j7);
    }
}
