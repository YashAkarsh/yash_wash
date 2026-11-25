package androidx.core.text;

import android.text.TextUtils;
import c.t0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Locale f6295a = new Locale("", "");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6296b = "Arab";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6297c = "Hebr";

    @t0(17)
    static class a {
        private a() {
        }

        @c.t
        static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    private p0() {
    }

    private static int a(@c.m0 Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(@c.o0 Locale locale) {
        return a.a(locale);
    }

    @c.m0
    public static String c(@c.m0 String str) {
        return TextUtils.htmlEncode(str);
    }
}
