package kotlinx.coroutines.sync;

import kotlin.l2;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i f37245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37246b;

    public a(@a7.d i iVar, int i7) {
        this.f37245a = iVar;
        this.f37246b = i7;
    }

    @Override // kotlinx.coroutines.p
    public void b(@a7.e Throwable th) {
        this.f37245a.s(this.f37246b);
    }

    @a7.d
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f37245a + ", " + this.f37246b + ']';
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ l2 z(Throwable th) {
        b(th);
        return l2.f34958a;
    }
}
