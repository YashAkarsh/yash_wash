package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    @a7.d
    public static final Spanned a(@a7.d String str, int i7, @a7.e Html.ImageGetter imageGetter, @a7.e Html.TagHandler tagHandler) {
        kotlin.jvm.internal.l0.p(str, "<this>");
        Spanned spannedB = f.b(str, i7, imageGetter, tagHandler);
        kotlin.jvm.internal.l0.o(spannedB, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedB;
    }

    public static /* synthetic */ Spanned b(String str, int i7, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        if ((i8 & 2) != 0) {
            imageGetter = null;
        }
        if ((i8 & 4) != 0) {
            tagHandler = null;
        }
        kotlin.jvm.internal.l0.p(str, "<this>");
        Spanned spannedB = f.b(str, i7, imageGetter, tagHandler);
        kotlin.jvm.internal.l0.o(spannedB, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedB;
    }

    @a7.d
    public static final String c(@a7.d Spanned spanned, int i7) {
        kotlin.jvm.internal.l0.p(spanned, "<this>");
        String strC = f.c(spanned, i7);
        kotlin.jvm.internal.l0.o(strC, "toHtml(this, option)");
        return strC;
    }

    public static /* synthetic */ String d(Spanned spanned, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        kotlin.jvm.internal.l0.p(spanned, "<this>");
        String strC = f.c(spanned, i7);
        kotlin.jvm.internal.l0.o(strC, "toHtml(this, option)");
        return strC;
    }
}
