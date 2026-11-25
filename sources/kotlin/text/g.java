package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "CharsetsKt")
public final class g {
    @kotlin.internal.f
    private static final Charset a(String charsetName) {
        l0.p(charsetName, "charsetName");
        Charset charsetForName = Charset.forName(charsetName);
        l0.o(charsetForName, "forName(charsetName)");
        return charsetForName;
    }
}
