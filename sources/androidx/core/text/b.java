package androidx.core.text;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final boolean a(@a7.d CharSequence charSequence) {
        kotlin.jvm.internal.l0.p(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int b(@a7.d CharSequence charSequence) {
        kotlin.jvm.internal.l0.p(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
