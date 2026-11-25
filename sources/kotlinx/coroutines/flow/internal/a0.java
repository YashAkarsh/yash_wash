package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.j0;
import kotlinx.coroutines.flow.t0;

/* JADX INFO: loaded from: classes3.dex */
final class a0 extends j0<Integer> implements t0<Integer> {
    public a0(int i7) {
        super(1, Integer.MAX_VALUE, kotlinx.coroutines.channels.m.DROP_OLDEST);
        m(Integer.valueOf(i7));
    }

    @Override // kotlinx.coroutines.flow.t0
    @a7.d
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(S().intValue());
        }
        return numValueOf;
    }

    public final boolean h0(int i7) {
        boolean zM;
        synchronized (this) {
            zM = m(Integer.valueOf(S().intValue() + i7));
        }
        return zM;
    }
}
