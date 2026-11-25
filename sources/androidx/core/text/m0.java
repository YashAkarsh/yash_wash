package androidx.core.text;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    @a7.d
    public static final String a(@a7.d String str) {
        kotlin.jvm.internal.l0.p(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        kotlin.jvm.internal.l0.o(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
