package androidx.core.os;

import kotlin.b1;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {
    @kotlin.k(message = "Use androidx.tracing.Trace instead", replaceWith = @b1(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T a(@a7.d String sectionName, @a7.d i5.a<? extends T> block) {
        kotlin.jvm.internal.l0.p(sectionName, "sectionName");
        kotlin.jvm.internal.l0.p(block, "block");
        r0.b(sectionName);
        try {
            return block.invoke();
        } finally {
            kotlin.jvm.internal.i0.d(1);
            r0.d();
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
