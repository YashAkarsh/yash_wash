package kotlin.io;

import java.io.Closeable;
import java.io.IOException;
import kotlin.a1;
import kotlin.g1;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "CloseableKt")
public final class c {
    @g1(version = "1.1")
    @a1
    public static final void a(@a7.e Closeable closeable, @a7.e Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.p.a(th, th2);
            }
        }
    }

    @kotlin.internal.f
    private static final <T extends Closeable, R> R b(T t7, i5.l<? super T, ? extends R> block) throws IOException {
        l0.p(block, "block");
        try {
            R rZ = block.z(t7);
            i0.d(1);
            if (kotlin.internal.m.a(1, 1, 0)) {
                a(t7, null);
            } else if (t7 != null) {
                t7.close();
            }
            i0.c(1);
            return rZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i0.d(1);
                if (kotlin.internal.m.a(1, 1, 0)) {
                    a(t7, th);
                } else if (t7 != null) {
                    try {
                        t7.close();
                    } catch (Throwable unused) {
                    }
                }
                i0.c(1);
                throw th2;
            }
        }
    }
}
