package f5;

import a7.e;
import h5.h;
import i5.l;
import kotlin.a1;
import kotlin.g1;
import kotlin.internal.f;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.p;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "AutoCloseableKt")
public final class a {
    @g1(version = "1.2")
    @a1
    public static final void a(@e AutoCloseable autoCloseable, @e Throwable th) throws Exception {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            p.a(th, th2);
        }
    }

    @g1(version = "1.2")
    @f
    private static final <T extends AutoCloseable, R> R b(T t7, l<? super T, ? extends R> block) throws Exception {
        l0.p(block, "block");
        try {
            R rZ = block.z(t7);
            i0.d(1);
            a(t7, null);
            i0.c(1);
            return rZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i0.d(1);
                a(t7, th);
                i0.c(1);
                throw th2;
            }
        }
    }
}
