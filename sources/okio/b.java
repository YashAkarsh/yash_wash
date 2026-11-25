package okio;

import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "-DeflaterSinkExtensions")
public final class b {
    @a7.d
    public static final q a(@a7.d m0 deflate, @a7.d Deflater deflater) {
        kotlin.jvm.internal.l0.p(deflate, "$this$deflate");
        kotlin.jvm.internal.l0.p(deflater, "deflater");
        return new q(deflate, deflater);
    }

    public static /* synthetic */ q b(m0 deflate, Deflater deflater, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            deflater = new Deflater();
        }
        kotlin.jvm.internal.l0.p(deflate, "$this$deflate");
        kotlin.jvm.internal.l0.p(deflater, "deflater");
        return new q(deflate, deflater);
    }
}
