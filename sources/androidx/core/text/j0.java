package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    @a7.d
    public static final SpannableStringBuilder a(@a7.d SpannableStringBuilder spannableStringBuilder, @c.l int i7, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i7);
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder b(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannedString c(@a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        builderAction.z(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @a7.d
    public static final SpannableStringBuilder d(@a7.d SpannableStringBuilder spannableStringBuilder, @c.l int i7, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i7);
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder e(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d Object span, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(span, "span");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder f(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d Object[] spans, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(spans, "spans");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        for (Object obj : spans) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder g(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder h(@a7.d SpannableStringBuilder spannableStringBuilder, float f8, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f8);
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder i(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder j(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder k(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @a7.d
    public static final SpannableStringBuilder l(@a7.d SpannableStringBuilder spannableStringBuilder, @a7.d i5.l<? super SpannableStringBuilder, l2> builderAction) {
        kotlin.jvm.internal.l0.p(spannableStringBuilder, "<this>");
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        builderAction.z(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
