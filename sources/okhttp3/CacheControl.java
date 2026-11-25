package okhttp3;

import a7.d;
import com.google.common.net.c;
import h5.e;
import h5.h;
import h5.l;
import java.util.concurrent.TimeUnit;
import kotlin.b1;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.m;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);

    @d
    @e
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    @d
    @e
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @i0(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j7) {
            if (j7 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j7;
        }

        @d
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        @d
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        @d
        public final Builder maxAge(int i7, @d TimeUnit timeUnit) {
            l0.p(timeUnit, "timeUnit");
            if (i7 >= 0) {
                this.maxAgeSeconds = clampToInt(timeUnit.toSeconds(i7));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i7).toString());
        }

        @d
        public final Builder maxStale(int i7, @d TimeUnit timeUnit) {
            l0.p(timeUnit, "timeUnit");
            if (i7 >= 0) {
                this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(i7));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i7).toString());
        }

        @d
        public final Builder minFresh(int i7, @d TimeUnit timeUnit) {
            l0.p(timeUnit, "timeUnit");
            if (i7 >= 0) {
                this.minFreshSeconds = clampToInt(timeUnit.toSeconds(i7));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i7).toString());
        }

        @d
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @d
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @d
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @d
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @i0(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        private final int indexOfElement(String str, String str2, int i7) {
            int length = str.length();
            while (i7 < length) {
                if (c0.U2(str2, str.charAt(i7), false, 2, null)) {
                    return i7;
                }
                i7++;
            }
            return str.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i7, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                i7 = 0;
            }
            return companion.indexOfElement(str, str2, i7);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004a  */
        /* JADX WARN: Code duplicated, block: B:17:0x005d  */
        /* JADX WARN: Code duplicated, block: B:19:0x006d  */
        /* JADX WARN: Code duplicated, block: B:34:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:40:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:42:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:43:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:45:0x00f3  */
        /* JADX WARN: Code duplicated, block: B:47:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:49:0x0104  */
        /* JADX WARN: Code duplicated, block: B:50:0x0109  */
        /* JADX WARN: Code duplicated, block: B:52:0x0111  */
        /* JADX WARN: Code duplicated, block: B:53:0x0113  */
        /* JADX WARN: Code duplicated, block: B:55:0x011b  */
        /* JADX WARN: Code duplicated, block: B:56:0x011d  */
        /* JADX WARN: Code duplicated, block: B:58:0x0125  */
        /* JADX WARN: Code duplicated, block: B:59:0x0128  */
        /* JADX WARN: Code duplicated, block: B:61:0x0130  */
        /* JADX WARN: Code duplicated, block: B:62:0x0138  */
        /* JADX WARN: Code duplicated, block: B:64:0x0140  */
        /* JADX WARN: Code duplicated, block: B:65:0x0146  */
        /* JADX WARN: Code duplicated, block: B:67:0x014f  */
        /* JADX WARN: Code duplicated, block: B:68:0x0152  */
        /* JADX WARN: Code duplicated, block: B:70:0x015a  */
        /* JADX WARN: Code duplicated, block: B:71:0x015d  */
        /* JADX WARN: Code duplicated, block: B:73:0x0165  */
        /* JADX WARN: Code duplicated, block: B:86:0x0170 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:97:0x0167 A[SYNTHETIC] */
        @d
        @l
        public final CacheControl parse(@d Headers headers) {
            int i7;
            int i8;
            int iIndexOfElement;
            String strSubstring;
            String string;
            boolean z7;
            int iIndexOfElement2;
            String string2;
            byte b8;
            Headers headers2 = headers;
            l0.p(headers2, "headers");
            int size = headers.size();
            boolean z8 = true;
            boolean z9 = true;
            int i9 = 0;
            String str = null;
            boolean z10 = false;
            boolean z11 = false;
            int iF0 = -1;
            int iF1 = -1;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            int iF2 = -1;
            int iF3 = -1;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            while (i9 < size) {
                String strName = headers2.name(i9);
                String strValue = headers2.value(i9);
                if (b0.K1(strName, c.f22132a, z8)) {
                    if (str == null) {
                        str = strValue;
                    }
                    i8 = 0;
                    while (i8 < strValue.length()) {
                        iIndexOfElement = indexOfElement(strValue, "=,;", i8);
                        strSubstring = strValue.substring(i8, iIndexOfElement);
                        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = c0.E5(strSubstring).toString();
                        int i10 = size;
                        if (iIndexOfElement != strValue.length()) {
                            z7 = z9;
                            if (strValue.charAt(iIndexOfElement) == ',' && strValue.charAt(iIndexOfElement) != ';') {
                                int iG = okhttp3.internal.d.G(strValue, iIndexOfElement + 1);
                                if (iG >= strValue.length() || strValue.charAt(iG) != '\"') {
                                    iIndexOfElement2 = indexOfElement(strValue, ",;", iG);
                                    String strSubstring2 = strValue.substring(iG, iIndexOfElement2);
                                    l0.o(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = c0.E5(strSubstring2).toString();
                                } else {
                                    int i11 = iG + 1;
                                    int iQ3 = c0.q3(strValue, h0.f35376b, i11, false, 4, null);
                                    string2 = strValue.substring(i11, iQ3);
                                    l0.o(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    iIndexOfElement2 = iQ3 + 1;
                                }
                            }
                            z8 = true;
                            if (b0.K1("no-cache", string, true)) {
                                z10 = true;
                            } else if (b0.K1("no-store", string, true)) {
                                z11 = true;
                            } else {
                                if (b0.K1("max-age", string, true)) {
                                    b8 = -1;
                                    iF0 = okhttp3.internal.d.f0(string2, -1);
                                } else {
                                    b8 = -1;
                                    if (b0.K1("s-maxage", string, true)) {
                                        iF1 = okhttp3.internal.d.f0(string2, -1);
                                    } else if (b0.K1("private", string, true)) {
                                        z12 = true;
                                    } else if (b0.K1("public", string, true)) {
                                        z13 = true;
                                    } else if (b0.K1("must-revalidate", string, true)) {
                                        z14 = true;
                                    } else if (b0.K1("max-stale", string, true)) {
                                        iF2 = okhttp3.internal.d.f0(string2, Integer.MAX_VALUE);
                                    } else if (b0.K1("min-fresh", string, true)) {
                                        iF3 = okhttp3.internal.d.f0(string2, -1);
                                    } else if (b0.K1("only-if-cached", string, true)) {
                                        z15 = true;
                                    } else if (b0.K1("no-transform", string, true)) {
                                        z16 = true;
                                    } else if (b0.K1("immutable", string, true)) {
                                        z17 = true;
                                    }
                                    i8 = iIndexOfElement2;
                                    size = i10;
                                    z9 = z7;
                                }
                                i8 = iIndexOfElement2;
                                size = i10;
                                z9 = z7;
                            }
                            i8 = iIndexOfElement2;
                            size = i10;
                            z9 = z7;
                        } else {
                            z7 = z9;
                        }
                        iIndexOfElement2 = iIndexOfElement + 1;
                        string2 = null;
                        z8 = true;
                        if (b0.K1("no-cache", string, true)) {
                            z10 = true;
                        } else if (b0.K1("no-store", string, true)) {
                            z11 = true;
                        } else {
                            if (b0.K1("max-age", string, true)) {
                                b8 = -1;
                                iF0 = okhttp3.internal.d.f0(string2, -1);
                            } else {
                                b8 = -1;
                                if (b0.K1("s-maxage", string, true)) {
                                    iF1 = okhttp3.internal.d.f0(string2, -1);
                                } else if (b0.K1("private", string, true)) {
                                    z12 = true;
                                } else if (b0.K1("public", string, true)) {
                                    z13 = true;
                                } else if (b0.K1("must-revalidate", string, true)) {
                                    z14 = true;
                                } else if (b0.K1("max-stale", string, true)) {
                                    iF2 = okhttp3.internal.d.f0(string2, Integer.MAX_VALUE);
                                } else if (b0.K1("min-fresh", string, true)) {
                                    iF3 = okhttp3.internal.d.f0(string2, -1);
                                } else if (b0.K1("only-if-cached", string, true)) {
                                    z15 = true;
                                } else if (b0.K1("no-transform", string, true)) {
                                    z16 = true;
                                } else if (b0.K1("immutable", string, true)) {
                                    z17 = true;
                                }
                                i8 = iIndexOfElement2;
                                size = i10;
                                z9 = z7;
                            }
                            i8 = iIndexOfElement2;
                            size = i10;
                            z9 = z7;
                        }
                        i8 = iIndexOfElement2;
                        size = i10;
                        z9 = z7;
                    }
                    i7 = size;
                    i9++;
                    headers2 = headers;
                    size = i7;
                } else {
                    if (!b0.K1(strName, c.f22140e, z8)) {
                        i7 = size;
                    }
                    i9++;
                    headers2 = headers;
                    size = i7;
                }
                z9 = false;
                i8 = 0;
                while (i8 < strValue.length()) {
                    iIndexOfElement = indexOfElement(strValue, "=,;", i8);
                    strSubstring = strValue.substring(i8, iIndexOfElement);
                    l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = c0.E5(strSubstring).toString();
                    int i12 = size;
                    if (iIndexOfElement != strValue.length()) {
                        z7 = z9;
                        if (strValue.charAt(iIndexOfElement) == ',') {
                        }
                        z8 = true;
                        if (b0.K1("no-cache", string, true)) {
                            z10 = true;
                        } else if (b0.K1("no-store", string, true)) {
                            z11 = true;
                        } else {
                            if (b0.K1("max-age", string, true)) {
                                b8 = -1;
                                iF0 = okhttp3.internal.d.f0(string2, -1);
                            } else {
                                b8 = -1;
                                if (b0.K1("s-maxage", string, true)) {
                                    iF1 = okhttp3.internal.d.f0(string2, -1);
                                } else if (b0.K1("private", string, true)) {
                                    z12 = true;
                                } else if (b0.K1("public", string, true)) {
                                    z13 = true;
                                } else if (b0.K1("must-revalidate", string, true)) {
                                    z14 = true;
                                } else if (b0.K1("max-stale", string, true)) {
                                    iF2 = okhttp3.internal.d.f0(string2, Integer.MAX_VALUE);
                                } else if (b0.K1("min-fresh", string, true)) {
                                    iF3 = okhttp3.internal.d.f0(string2, -1);
                                } else if (b0.K1("only-if-cached", string, true)) {
                                    z15 = true;
                                } else if (b0.K1("no-transform", string, true)) {
                                    z16 = true;
                                } else if (b0.K1("immutable", string, true)) {
                                    z17 = true;
                                }
                                i8 = iIndexOfElement2;
                                size = i12;
                                z9 = z7;
                            }
                            i8 = iIndexOfElement2;
                            size = i12;
                            z9 = z7;
                        }
                        i8 = iIndexOfElement2;
                        size = i12;
                        z9 = z7;
                    } else {
                        z7 = z9;
                    }
                    iIndexOfElement2 = iIndexOfElement + 1;
                    string2 = null;
                    z8 = true;
                    if (b0.K1("no-cache", string, true)) {
                        z10 = true;
                    } else if (b0.K1("no-store", string, true)) {
                        z11 = true;
                    } else {
                        if (b0.K1("max-age", string, true)) {
                            b8 = -1;
                            iF0 = okhttp3.internal.d.f0(string2, -1);
                        } else {
                            b8 = -1;
                            if (b0.K1("s-maxage", string, true)) {
                                iF1 = okhttp3.internal.d.f0(string2, -1);
                            } else if (b0.K1("private", string, true)) {
                                z12 = true;
                            } else if (b0.K1("public", string, true)) {
                                z13 = true;
                            } else if (b0.K1("must-revalidate", string, true)) {
                                z14 = true;
                            } else if (b0.K1("max-stale", string, true)) {
                                iF2 = okhttp3.internal.d.f0(string2, Integer.MAX_VALUE);
                            } else if (b0.K1("min-fresh", string, true)) {
                                iF3 = okhttp3.internal.d.f0(string2, -1);
                            } else if (b0.K1("only-if-cached", string, true)) {
                                z15 = true;
                            } else if (b0.K1("no-transform", string, true)) {
                                z16 = true;
                            } else if (b0.K1("immutable", string, true)) {
                                z17 = true;
                            }
                            i8 = iIndexOfElement2;
                            size = i12;
                            z9 = z7;
                        }
                        i8 = iIndexOfElement2;
                        size = i12;
                        z9 = z7;
                    }
                    i8 = iIndexOfElement2;
                    size = i12;
                    z9 = z7;
                }
                i7 = size;
                i9++;
                headers2 = headers;
                size = i7;
            }
            return new CacheControl(z10, z11, iF0, iF1, z12, z13, z14, iF2, iF3, z15, z16, z17, !z9 ? null : str, null);
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }
    }

    private CacheControl(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, String str) {
        this.noCache = z7;
        this.noStore = z8;
        this.maxAgeSeconds = i7;
        this.sMaxAgeSeconds = i8;
        this.isPrivate = z9;
        this.isPublic = z10;
        this.mustRevalidate = z11;
        this.maxStaleSeconds = i9;
        this.minFreshSeconds = i10;
        this.onlyIfCached = z12;
        this.noTransform = z13;
        this.immutable = z14;
        this.headerValue = str;
    }

    @d
    @l
    public static final CacheControl parse(@d Headers headers) {
        return Companion.parse(headers);
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "immutable", imports = {}))
    @h(name = "-deprecated_immutable")
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m14deprecated_immutable() {
        return this.immutable;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "maxAgeSeconds", imports = {}))
    @h(name = "-deprecated_maxAgeSeconds")
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m15deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "maxStaleSeconds", imports = {}))
    @h(name = "-deprecated_maxStaleSeconds")
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m16deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "minFreshSeconds", imports = {}))
    @h(name = "-deprecated_minFreshSeconds")
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m17deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "mustRevalidate", imports = {}))
    @h(name = "-deprecated_mustRevalidate")
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m18deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "noCache", imports = {}))
    @h(name = "-deprecated_noCache")
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m19deprecated_noCache() {
        return this.noCache;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "noStore", imports = {}))
    @h(name = "-deprecated_noStore")
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m20deprecated_noStore() {
        return this.noStore;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "noTransform", imports = {}))
    @h(name = "-deprecated_noTransform")
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m21deprecated_noTransform() {
        return this.noTransform;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "onlyIfCached", imports = {}))
    @h(name = "-deprecated_onlyIfCached")
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m22deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "sMaxAgeSeconds", imports = {}))
    @h(name = "-deprecated_sMaxAgeSeconds")
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m23deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @h(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @h(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @h(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @h(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @h(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @h(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @h(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @h(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @h(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @h(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @d
    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=");
            sb.append(this.maxAgeSeconds);
            sb.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=");
            sb.append(this.sMaxAgeSeconds);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=");
            sb.append(this.maxStaleSeconds);
            sb.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=");
            sb.append(this.minFreshSeconds);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }

    public /* synthetic */ CacheControl(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, String str, w wVar) {
        this(z7, z8, i7, i8, z9, z10, z11, i9, i10, z12, z13, z14, str);
    }
}
