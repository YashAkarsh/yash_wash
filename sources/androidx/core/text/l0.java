package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {
    public static final /* synthetic */ <T> T[] a(Spanned spanned, int i7, int i8) {
        kotlin.jvm.internal.l0.p(spanned, "<this>");
        kotlin.jvm.internal.l0.y(4, "T");
        T[] tArr = (T[]) spanned.getSpans(i7, i8, Object.class);
        kotlin.jvm.internal.l0.o(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] b(Spanned spanned, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = spanned.length();
        }
        kotlin.jvm.internal.l0.p(spanned, "<this>");
        kotlin.jvm.internal.l0.y(4, "T");
        Object[] spans = spanned.getSpans(i7, i8, Object.class);
        kotlin.jvm.internal.l0.o(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @a7.d
    public static final Spanned c(@a7.d CharSequence charSequence) {
        kotlin.jvm.internal.l0.p(charSequence, "<this>");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        kotlin.jvm.internal.l0.o(spannedStringValueOf, "valueOf(this)");
        return spannedStringValueOf;
    }
}
