package okio;

import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "-InflaterSourceExtensions")
public final class h {
    @a7.d
    public static final y a(@a7.d o0 inflate, @a7.d Inflater inflater) {
        kotlin.jvm.internal.l0.p(inflate, "$this$inflate");
        kotlin.jvm.internal.l0.p(inflater, "inflater");
        return new y(inflate, inflater);
    }

    public static /* synthetic */ y b(o0 inflate, Inflater inflater, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            inflater = new Inflater();
        }
        kotlin.jvm.internal.l0.p(inflate, "$this$inflate");
        kotlin.jvm.internal.l0.p(inflater, "inflater");
        return new y(inflate, inflater);
    }
}
