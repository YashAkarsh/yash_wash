package okhttp3;

import a7.d;
import a7.e;
import com.google.common.net.c;
import h5.h;
import h5.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.b1;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.m;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.o;
import kotlinx.coroutines.s0;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Cookie {

    @d
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;

    @d
    private final String name;

    @d
    private final String path;
    private final boolean persistent;
    private final boolean secure;

    @d
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @i0(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = 253402300799999L;
        private String path = "/";

        @d
        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j7 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j7, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        @d
        public final Builder domain(@d String domain) {
            l0.p(domain, "domain");
            return domain(domain, false);
        }

        @d
        public final Builder expiresAt(long j7) {
            if (j7 <= 0) {
                j7 = Long.MIN_VALUE;
            }
            if (j7 > 253402300799999L) {
                j7 = 253402300799999L;
            }
            this.expiresAt = j7;
            this.persistent = true;
            return this;
        }

        @d
        public final Builder hostOnlyDomain(@d String domain) {
            l0.p(domain, "domain");
            return domain(domain, true);
        }

        @d
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @d
        public final Builder name(@d String name) {
            l0.p(name, "name");
            if (!l0.g(c0.E5(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.name = name;
            return this;
        }

        @d
        public final Builder path(@d String path) {
            l0.p(path, "path");
            if (!b0.u2(path, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.path = path;
            return this;
        }

        @d
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @d
        public final Builder value(@d String value) {
            l0.p(value, "value");
            if (!l0.g(c0.E5(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.value = value;
            return this;
        }

        private final Builder domain(String str, boolean z7) {
            String strE = okhttp3.internal.a.e(str);
            if (strE != null) {
                this.domain = strE;
                this.hostOnly = z7;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    @i0(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i7, int i8, boolean z7) {
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z7)) {
                    return i7;
                }
                i7++;
            }
            return i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (l0.g(str, str2)) {
                return true;
            }
            return b0.J1(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !okhttp3.internal.d.h(str);
        }

        private final String parseDomain(String str) {
            if (!(!b0.J1(str, com.alibaba.android.arouter.utils.b.f12515h, false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strE = okhttp3.internal.a.e(c0.c4(str, com.alibaba.android.arouter.utils.b.f12515h));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i7, int i8) {
            int iDateCharacterOffset = dateCharacterOffset(str, i7, i8, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int iR3 = -1;
            int i12 = -1;
            int i13 = -1;
            while (iDateCharacterOffset < i8) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i8, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i10 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    l0.o(strGroup, "matcher.group(1)");
                    i10 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    l0.o(strGroup2, "matcher.group(2)");
                    i12 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    l0.o(strGroup3, "matcher.group(3)");
                    i13 = Integer.parseInt(strGroup3);
                } else if (i11 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    l0.o(strGroup4, "matcher.group(1)");
                    i11 = Integer.parseInt(strGroup4);
                } else if (iR3 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    l0.o(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    l0.o(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    l0.o(strPattern, "MONTH_PATTERN.pattern()");
                    iR3 = c0.r3(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i9 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    l0.o(strGroup6, "matcher.group(1)");
                    i9 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i8, false);
            }
            if (70 <= i9 && 99 >= i9) {
                i9 += 1900;
            }
            if (i9 >= 0 && 69 >= i9) {
                i9 += 2000;
            }
            if (!(i9 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iR3 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i11 && 31 >= i11)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i10 >= 0 && 23 >= i10)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i12 >= 0 && 59 >= i12)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i13 >= 0 && 59 >= i13)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(okhttp3.internal.d.f37859f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i9);
            gregorianCalendar.set(2, iR3 - 1);
            gregorianCalendar.set(5, i11);
            gregorianCalendar.set(11, i10);
            gregorianCalendar.set(12, i12);
            gregorianCalendar.set(13, i13);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long j7 = Long.parseLong(str);
                if (j7 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j7;
            } catch (NumberFormatException e8) {
                if (new o("-?\\d+").k(str)) {
                    return b0.u2(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e8;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (l0.g(strEncodedPath, str)) {
                return true;
            }
            return b0.u2(strEncodedPath, str, false, 2, null) && (b0.J1(str, "/", false, 2, null) || strEncodedPath.charAt(str.length()) == '/');
        }

        @e
        @l
        public final Cookie parse(@d HttpUrl url, @d String setCookie) {
            l0.p(url, "url");
            l0.p(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00dc A[PHI: r1
          0x00dc: PHI (r1v25 long) = (r1v8 long), (r1v12 long) binds: [B:45:0x00da, B:56:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        @e
        public final Cookie parse$okhttp(long j7, @d HttpUrl url, @d String setCookie) {
            long j8;
            long j9;
            Cookie cookie;
            String str;
            String str2;
            l0.p(url, "url");
            l0.p(setCookie, "setCookie");
            int iR = okhttp3.internal.d.r(setCookie, ';', 0, 0, 6, null);
            int iR2 = okhttp3.internal.d.r(setCookie, '=', 0, iR, 2, null);
            if (iR2 == iR) {
                return null;
            }
            String strH0 = okhttp3.internal.d.h0(setCookie, 0, iR2, 1, null);
            if ((strH0.length() == 0) || okhttp3.internal.d.B(strH0) != -1) {
                return null;
            }
            String strG0 = okhttp3.internal.d.g0(setCookie, iR2 + 1, iR);
            if (okhttp3.internal.d.B(strG0) != -1) {
                return null;
            }
            int i7 = iR + 1;
            int length = setCookie.length();
            String domain = null;
            String str3 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = true;
            long maxAge = -1;
            long expires = 253402300799999L;
            while (i7 < length) {
                int iP = okhttp3.internal.d.p(setCookie, ';', i7, length);
                int iP2 = okhttp3.internal.d.p(setCookie, '=', i7, iP);
                String strG1 = okhttp3.internal.d.g0(setCookie, i7, iP2);
                String strG2 = iP2 < iP ? okhttp3.internal.d.g0(setCookie, iP2 + 1, iP) : "";
                if (b0.K1(strG1, "expires", true)) {
                    try {
                        expires = parseExpires(strG2, 0, strG2.length());
                        z9 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (b0.K1(strG1, "max-age", true)) {
                    maxAge = parseMaxAge(strG2);
                    z9 = true;
                } else if (b0.K1(strG1, "domain", true)) {
                    domain = parseDomain(strG2);
                    z10 = false;
                } else if (b0.K1(strG1, "path", true)) {
                    str3 = strG2;
                } else if (b0.K1(strG1, "secure", true)) {
                    z7 = true;
                } else if (b0.K1(strG1, "httponly", true)) {
                    z8 = true;
                }
                i7 = iP + 1;
            }
            long j10 = Long.MIN_VALUE;
            if (maxAge == Long.MIN_VALUE) {
                j8 = j10;
            } else if (maxAge != -1) {
                j10 = j7 + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : Long.MAX_VALUE);
                if (j10 >= j7) {
                    j9 = 253402300799999L;
                    if (j10 <= 253402300799999L) {
                        j8 = j10;
                    }
                } else {
                    j9 = 253402300799999L;
                }
                j8 = j9;
            } else {
                j8 = expires;
            }
            String strHost = url.host();
            if (domain == null) {
                str = strHost;
                cookie = null;
            } else {
                if (!domainMatch(strHost, domain)) {
                    return null;
                }
                cookie = null;
                str = domain;
            }
            if (strHost.length() != str.length() && PublicSuffixDatabase.f38290j.c().e(str) == null) {
                return cookie;
            }
            String strSubstring = "/";
            String str4 = str3;
            if (str4 == null || !b0.u2(str4, "/", false, 2, cookie)) {
                String strEncodedPath = url.encodedPath();
                int iE3 = c0.E3(strEncodedPath, '/', 0, false, 6, null);
                if (iE3 != 0) {
                    if (strEncodedPath == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    strSubstring = strEncodedPath.substring(0, iE3);
                    l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                str2 = strSubstring;
            } else {
                str2 = str4;
            }
            return new Cookie(strH0, strG0, j8, str, str2, z7, z8, z9, z10, null);
        }

        @d
        @l
        public final List<Cookie> parseAll(@d HttpUrl url, @d Headers headers) {
            l0.p(url, "url");
            l0.p(headers, "headers");
            List<String> listValues = headers.values(c.f22173u0);
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i7 = 0; i7 < size; i7++) {
                Cookie cookie = parse(url, listValues.get(i7));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return y.F();
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            l0.o(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
            return listUnmodifiableList;
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }
    }

    private Cookie(String str, String str2, long j7, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j7;
        this.domain = str3;
        this.path = str4;
        this.secure = z7;
        this.httpOnly = z8;
        this.persistent = z9;
        this.hostOnly = z10;
    }

    @e
    @l
    public static final Cookie parse(@d HttpUrl httpUrl, @d String str) {
        return Companion.parse(httpUrl, str);
    }

    @d
    @l
    public static final List<Cookie> parseAll(@d HttpUrl httpUrl, @d Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "domain", imports = {}))
    @h(name = "-deprecated_domain")
    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m32deprecated_domain() {
        return this.domain;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "expiresAt", imports = {}))
    @h(name = "-deprecated_expiresAt")
    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m33deprecated_expiresAt() {
        return this.expiresAt;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "hostOnly", imports = {}))
    @h(name = "-deprecated_hostOnly")
    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m34deprecated_hostOnly() {
        return this.hostOnly;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "httpOnly", imports = {}))
    @h(name = "-deprecated_httpOnly")
    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m35deprecated_httpOnly() {
        return this.httpOnly;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "name", imports = {}))
    @h(name = "-deprecated_name")
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m36deprecated_name() {
        return this.name;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "path", imports = {}))
    @h(name = "-deprecated_path")
    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m37deprecated_path() {
        return this.path;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "persistent", imports = {}))
    @h(name = "-deprecated_persistent")
    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m38deprecated_persistent() {
        return this.persistent;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "secure", imports = {}))
    @h(name = "-deprecated_secure")
    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m39deprecated_secure() {
        return this.secure;
    }

    @d
    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "value", imports = {}))
    @h(name = "-deprecated_value")
    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m40deprecated_value() {
        return this.value;
    }

    @d
    @h(name = "domain")
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (l0.g(cookie.name, this.name) && l0.g(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && l0.g(cookie.domain, this.domain) && l0.g(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @h(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @z6.a
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + s0.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + a.a(this.secure)) * 31) + a.a(this.httpOnly)) * 31) + a.a(this.persistent)) * 31) + a.a(this.hostOnly);
    }

    @h(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @h(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@d HttpUrl url) {
        l0.p(url, "url");
        if ((this.hostOnly ? l0.g(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    @d
    @h(name = "name")
    public final String name() {
        return this.name;
    }

    @d
    @h(name = "path")
    public final String path() {
        return this.path;
    }

    @h(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @h(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @d
    public String toString() {
        return toString$okhttp(false);
    }

    @d
    public final String toString$okhttp(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(okhttp3.internal.http.c.b(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z7) {
                sb.append(com.alibaba.android.arouter.utils.b.f12515h);
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        l0.o(string, "toString()");
        return string;
    }

    @d
    @h(name = "value")
    public final String value() {
        return this.value;
    }

    public /* synthetic */ Cookie(String str, String str2, long j7, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10, w wVar) {
        this(str, str2, j7, str3, str4, z7, z8, z9, z10);
    }
}
