package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.internal.n0;

/* JADX INFO: loaded from: classes3.dex */
final class o<T> extends n0<T> {
    public o(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        super(gVar, dVar);
    }

    @Override // kotlinx.coroutines.w2
    public boolean n0(@a7.d Throwable th) {
        if (th instanceof l) {
            return true;
        }
        return e0(th);
    }
}
