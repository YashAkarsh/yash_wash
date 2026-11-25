package n5;

import h5.h;
import kotlin.internal.f;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "ProcessKt")
public final class a {
    @f
    private static final Void a(int i7) {
        System.exit(i7);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
