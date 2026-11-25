package com.haier.library.okhttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f27605e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f27606f = "\"([^\"]*)\"";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f27607g = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f27608h = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f27611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f27612d;

    private j0(String str, String str2, String str3, @Nullable String str4) {
        this.f27609a = str;
        this.f27610b = str2;
        this.f27611c = str3;
        this.f27612d = str4;
    }

    public static j0 a(String str) {
        Matcher matcher = f27607g.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + kotlin.text.h0.f35376b);
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f27608h.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + kotlin.text.h0.f35376b);
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + kotlin.text.h0.f35376b);
                }
                str2 = strGroup3;
            }
        }
        return new j0(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    public static j0 d(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String b() {
        return this.f27610b;
    }

    @Nullable
    public Charset c(@Nullable Charset charset) {
        try {
            String str = this.f27612d;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String e() {
        return this.f27611c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof j0) && ((j0) obj).f27609a.equals(this.f27609a);
    }

    @Nullable
    public Charset f() {
        return c(null);
    }

    public int hashCode() {
        return this.f27609a.hashCode();
    }

    public String toString() {
        return this.f27609a;
    }
}
