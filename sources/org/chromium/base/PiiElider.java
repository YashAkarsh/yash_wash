package org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.app.l2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.base.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes3.dex */
public class PiiElider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38709a = "XXX@EMAIL.ELIDED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38710b = "HTTP://WEBADDRESS.ELIDED";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38711c = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f38712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f38713e = "[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f38714f = "a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f38715g = "[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f38716h = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f38717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f38718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f38719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f38720l = "1.2.3.4";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f38721m = "01:23:45:67:89:AB";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f38722n = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f38723o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f38724p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f38725q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f38726r;

    static {
        Pattern patternCompile = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        f38712d = patternCompile;
        Pattern patternCompile2 = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + patternCompile + ")");
        f38717i = patternCompile2;
        f38718j = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
        f38719k = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + patternCompile2 + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[" + f38711c + "\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        f38723o = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        f38724p = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        f38725q = new String[]{"org.chromium.", "com.google."};
        f38726r = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", l2.C, "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String a(String str) {
        return f38724p.matcher(str).replaceAll(f38722n);
    }

    public static String b(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).replaceAll(f38709a);
    }

    public static String c(String str) {
        return Patterns.IP_ADDRESS.matcher(str).replaceAll(f38720l);
    }

    public static String d(String str) {
        return f38723o.matcher(str).replaceAll(f38721m);
    }

    public static String e(String str) {
        if (f38718j.matcher(str).find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = f38719k.matcher(sb);
        int i7 = 0;
        while (matcher.find(i7)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strSubstring = sb.substring(iStart, iEnd);
            if (f(strSubstring) || g(strSubstring)) {
                i7 = iEnd;
            } else {
                sb.replace(iStart, iEnd, f38710b);
                i7 = iStart + 24;
                matcher = f38719k.matcher(sb);
            }
        }
        return sb.toString();
    }

    private static boolean f(String str) {
        for (String str2 : f38725q) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean g(String str) {
        for (String str2 : f38726r) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @UsedByReflection("jni_android.cc")
    public static String sanitizeStacktrace(String str) {
        String[] strArrSplit = str.split("\\n");
        strArrSplit[0] = e(strArrSplit[0]);
        for (int i7 = 1; i7 < strArrSplit.length; i7++) {
            if (strArrSplit[i7].startsWith("Caused by:")) {
                strArrSplit[i7] = e(strArrSplit[i7]);
            }
        }
        return TextUtils.join("\n", strArrSplit);
    }
}
