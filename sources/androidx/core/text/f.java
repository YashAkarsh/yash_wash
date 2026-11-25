package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"InlinedApi"})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6248a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6249b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6250c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6251d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6252e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6253f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6254g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6255h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6256i = 256;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6257j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6258k = 63;

    @t0(24)
    static class a {
        private a() {
        }

        @c.t
        static Spanned a(String str, int i7) {
            return Html.fromHtml(str, i7);
        }

        @c.t
        static Spanned b(String str, int i7, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i7, imageGetter, tagHandler);
        }

        @c.t
        static String c(Spanned spanned, int i7) {
            return Html.toHtml(spanned, i7);
        }
    }

    private f() {
    }

    @c.m0
    public static Spanned a(@c.m0 String str, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? a.a(str, i7) : Html.fromHtml(str);
    }

    @c.m0
    public static Spanned b(@c.m0 String str, int i7, @c.o0 Html.ImageGetter imageGetter, @c.o0 Html.TagHandler tagHandler) {
        return Build.VERSION.SDK_INT >= 24 ? a.b(str, i7, imageGetter, tagHandler) : Html.fromHtml(str, imageGetter, tagHandler);
    }

    @c.m0
    public static String c(@c.m0 Spanned spanned, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? a.c(spanned, i7) : Html.toHtml(spanned);
    }
}
