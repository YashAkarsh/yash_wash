package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    @SuppressLint({"SyntheticAccessor"})
    public static final void a(@a7.d Spannable spannable) {
        kotlin.jvm.internal.l0.p(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        kotlin.jvm.internal.l0.o(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void b(@a7.d Spannable spannable, int i7, int i8, @a7.d Object span) {
        kotlin.jvm.internal.l0.p(spannable, "<this>");
        kotlin.jvm.internal.l0.p(span, "span");
        spannable.setSpan(span, i7, i8, 17);
    }

    public static final void c(@a7.d Spannable spannable, @a7.d kotlin.ranges.k range, @a7.d Object span) {
        kotlin.jvm.internal.l0.p(spannable, "<this>");
        kotlin.jvm.internal.l0.p(range, "range");
        kotlin.jvm.internal.l0.p(span, "span");
        spannable.setSpan(span, range.d().intValue(), range.f().intValue(), 17);
    }

    @a7.d
    public static final Spannable d(@a7.d CharSequence charSequence) {
        kotlin.jvm.internal.l0.p(charSequence, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        kotlin.jvm.internal.l0.o(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }
}
