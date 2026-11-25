package kotlinx.coroutines.channels;

import kotlinx.coroutines.f3;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    @a7.d
    @f3
    public static final <E> i<E> a(int i7) {
        if (i7 == -2) {
            return new g(n.f35616t0.a());
        }
        if (i7 == -1) {
            return new z();
        }
        if (i7 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        }
        if (i7 != Integer.MAX_VALUE) {
            return new g(i7);
        }
        throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    }
}
