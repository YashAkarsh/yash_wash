package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.util.u;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.x0;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f6323a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator<b> f6324b = new Comparator() { // from class: androidx.core.text.util.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.o((e.b) obj, (e.b) obj2);
        }
    };

    @t0(24)
    static class a {
        private a() {
        }

        @t
        static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @t
        static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        URLSpan f6325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6328d;

        b() {
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private e() {
    }

    private static void b(@m0 TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void c(@m0 TextView textView, @m0 Pattern pattern, @o0 String str) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            e(textView, pattern, str, null, null, null);
        }
    }

    public static void d(@m0 TextView textView, @m0 Pattern pattern, @o0 String str, @o0 Linkify.MatchFilter matchFilter, @o0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            e(textView, pattern, str, null, matchFilter, transformFilter);
        }
    }

    public static void e(@m0 TextView textView, @m0 Pattern pattern, @o0 String str, @o0 String[] strArr, @o0 Linkify.MatchFilter matchFilter, @o0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            a.a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (i(spannableStringValueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            b(textView);
        }
    }

    public static boolean f(@m0 Spannable spannable, int i7) {
        if (r()) {
            return Linkify.addLinks(spannable, i7);
        }
        if (i7 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i7 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList<b> arrayList = new ArrayList();
        if ((i7 & 1) != 0) {
            m(arrayList, spannable, u.f6411w, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i7 & 2) != 0) {
            m(arrayList, spannable, u.A, new String[]{androidx.core.net.d.f6068b}, null, null);
        }
        if ((i7 & 8) != 0) {
            n(arrayList, spannable);
        }
        q(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (b bVar : arrayList) {
            if (bVar.f6325a == null) {
                k(bVar.f6326b, bVar.f6327c, bVar.f6328d, spannable);
            }
        }
        return true;
    }

    public static boolean g(@m0 Spannable spannable, @m0 Pattern pattern, @o0 String str) {
        return r() ? Linkify.addLinks(spannable, pattern, str) : i(spannable, pattern, str, null, null, null);
    }

    public static boolean h(@m0 Spannable spannable, @m0 Pattern pattern, @o0 String str, @o0 Linkify.MatchFilter matchFilter, @o0 Linkify.TransformFilter transformFilter) {
        return r() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : i(spannable, pattern, str, null, matchFilter, transformFilter);
    }

    public static boolean i(@m0 Spannable spannable, @m0 Pattern pattern, @o0 String str, @o0 String[] strArr, @o0 Linkify.MatchFilter matchFilter, @o0 Linkify.TransformFilter transformFilter) {
        if (r()) {
            return a.b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f6323a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i7 = 0;
        while (i7 < strArr.length) {
            String str2 = strArr[i7];
            i7++;
            strArr2[i7] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z7 = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) && strGroup != null) {
                k(p(strGroup, strArr2, matcher, transformFilter), iStart, iEnd, spannable);
                z7 = true;
            }
        }
        return z7;
    }

    public static boolean j(@m0 TextView textView, int i7) {
        if (r()) {
            return Linkify.addLinks(textView, i7);
        }
        if (i7 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString spannableStringValueOf = SpannableString.valueOf(text);
            if (f(spannableStringValueOf, i7)) {
                b(textView);
                textView.setText(spannableStringValueOf);
                return true;
            }
        } else if (f((Spannable) text, i7)) {
            b(textView);
            return true;
        }
        return false;
    }

    private static void k(String str, int i7, int i8, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i7, i8, 33);
    }

    private static String l(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : androidx.core.text.util.a.c(str);
    }

    private static void m(ArrayList<b> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                if (strGroup != null) {
                    b bVar = new b();
                    bVar.f6326b = p(strGroup, strArr, matcher, transformFilter);
                    bVar.f6327c = iStart;
                    bVar.f6328d = iEnd;
                    arrayList.add(bVar);
                }
            }
        }
    }

    private static void n(ArrayList<b> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i7 = 0;
        while (true) {
            try {
                String strL = l(string);
                if (strL != null && (iIndexOf = string.indexOf(strL)) >= 0) {
                    b bVar = new b();
                    int length = strL.length() + iIndexOf;
                    bVar.f6327c = iIndexOf + i7;
                    i7 += length;
                    bVar.f6328d = i7;
                    string = string.substring(length);
                    try {
                        bVar.f6326b = "geo:0,0?q=" + URLEncoder.encode(strL, "UTF-8");
                        arrayList.add(bVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(b bVar, b bVar2) {
        int i7 = bVar.f6327c;
        int i8 = bVar2.f6327c;
        if (i7 < i8) {
            return -1;
        }
        if (i7 > i8) {
            return 1;
        }
        return Integer.compare(bVar2.f6328d, bVar.f6328d);
    }

    private static String p(@m0 String str, @m0 String[] strArr, Matcher matcher, @o0 Linkify.TransformFilter transformFilter) {
        boolean z7;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                z7 = false;
                break;
            }
            String str2 = strArr[i7];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z7 = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                    break;
                }
                break;
            }
            i7++;
        }
        if (z7 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void q(ArrayList<b> arrayList, Spannable spannable) {
        int i7;
        int i8 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            b bVar = new b();
            bVar.f6325a = uRLSpan;
            bVar.f6327c = spannable.getSpanStart(uRLSpan);
            bVar.f6328d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(bVar);
        }
        Collections.sort(arrayList, f6324b);
        int size = arrayList.size();
        while (i8 < size - 1) {
            b bVar2 = arrayList.get(i8);
            int i9 = i8 + 1;
            b bVar3 = arrayList.get(i9);
            int i10 = bVar2.f6327c;
            int i11 = bVar3.f6327c;
            if (i10 <= i11 && (i7 = bVar2.f6328d) > i11) {
                int i12 = bVar3.f6328d;
                int i13 = (i12 > i7 && i7 - i10 <= i12 - i11) ? i7 - i10 < i12 - i11 ? i8 : -1 : i9;
                if (i13 != -1) {
                    Object obj = arrayList.get(i13).f6325a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i13);
                    size--;
                }
            }
            i8 = i9;
        }
    }

    private static boolean r() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
