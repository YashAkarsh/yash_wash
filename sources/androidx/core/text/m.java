package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.t0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class m {
    @t0(17)
    public static final int a(@a7.d Locale locale) {
        kotlin.jvm.internal.l0.p(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
