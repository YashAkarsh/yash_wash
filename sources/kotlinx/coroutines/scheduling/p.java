package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.j2;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes3.dex */
final class p extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final p f37199b = new p();

    private p() {
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        d.f37167h.q1(runnable, o.f37198j, false);
    }

    @Override // kotlinx.coroutines.o0
    @j2
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        d.f37167h.q1(runnable, o.f37198j, true);
    }
}
