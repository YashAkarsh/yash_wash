package kotlinx.coroutines.internal;

import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 {
    @j2
    public static /* synthetic */ void a() {
    }

    @j2
    public static final <T> T b(@a7.d Object obj, @a7.d i5.a<? extends T> aVar) {
        T tInvoke;
        synchronized (obj) {
            try {
                tInvoke = aVar.invoke();
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                kotlin.jvm.internal.i0.c(1);
            }
        }
        return tInvoke;
    }
}
