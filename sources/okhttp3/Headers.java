package okhttp3;

import a7.d;
import a7.e;
import h5.h;
import h5.l;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.b1;
import kotlin.collections.d0;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.s1;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.m;
import kotlin.p1;
import kotlin.ranges.i;
import kotlin.ranges.q;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.u0;
import okhttp3.internal.http.c;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002('B\u0017\b\u0002\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"¢\u0006\u0004\b%\u0010&J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u001b\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0016H\u0096\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006)"}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/u0;", "", "name", "get", "Ljava/util/Date;", "getDate", "Ljava/time/Instant;", "getInstant", "", "-deprecated_size", "()I", "size", "index", "value", "", "names", "", "values", "", "byteCount", "", "iterator", "Lokhttp3/Headers$Builder;", "newBuilder", "", "other", "", "equals", "hashCode", "toString", "", "toMultimap", "", "namesAndValues", "[Ljava/lang/String;", "<init>", "([Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Headers implements Iterable<u0<? extends String, ? extends String>>, j5.a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    @i0(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        @d
        private final List<String> namesAndValues = new ArrayList(20);

        @d
        public final Builder add(@d String line) {
            l0.p(line, "line");
            int iQ3 = c0.q3(line, ':', 0, false, 6, null);
            if (!(iQ3 != -1)) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String strSubstring = line.substring(0, iQ3);
            l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (strSubstring == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = c0.E5(strSubstring).toString();
            String strSubstring2 = line.substring(iQ3 + 1);
            l0.o(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        @d
        public final Builder addAll(@d Headers headers) {
            l0.p(headers, "headers");
            int size = headers.size();
            for (int i7 = 0; i7 < size; i7++) {
                addLenient$okhttp(headers.name(i7), headers.value(i7));
            }
            return this;
        }

        @d
        public final Builder addLenient$okhttp(@d String line) {
            l0.p(line, "line");
            int iQ3 = c0.q3(line, ':', 1, false, 4, null);
            if (iQ3 != -1) {
                String strSubstring = line.substring(0, iQ3);
                l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iQ3 + 1);
                l0.o(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                l0.o(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", strSubstring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        @d
        public final Builder addUnsafeNonAscii(@d String name, @d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @d
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @e
        public final String get(@d String name) {
            l0.p(name, "name");
            i iVarE1 = q.e1(q.W(this.namesAndValues.size() - 2, 0), 2);
            int iG = iVarE1.g();
            int iH = iVarE1.h();
            int iJ = iVarE1.j();
            if (iJ >= 0) {
                if (iG > iH) {
                    return null;
                }
            } else if (iG < iH) {
                return null;
            }
            while (!b0.K1(name, this.namesAndValues.get(iG), true)) {
                if (iG == iH) {
                    return null;
                }
                iG += iJ;
            }
            return this.namesAndValues.get(iG + 1);
        }

        @d
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @d
        public final Builder removeAll(@d String name) {
            l0.p(name, "name");
            int i7 = 0;
            while (i7 < this.namesAndValues.size()) {
                if (b0.K1(name, this.namesAndValues.get(i7), true)) {
                    this.namesAndValues.remove(i7);
                    this.namesAndValues.remove(i7);
                    i7 -= 2;
                }
                i7 += 2;
            }
            return this;
        }

        @d
        public final Builder set(@d String name, @d Date value) {
            l0.p(name, "name");
            l0.p(value, "value");
            set(name, c.b(value));
            return this;
        }

        @d
        @z6.a
        public final Builder set(@d String name, @d Instant value) {
            l0.p(name, "name");
            l0.p(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        @d
        public final Builder set(@d String name, @d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @d
        public final Builder add(@d String name, @d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @d
        public final Builder addLenient$okhttp(@d String name, @d String value) {
            l0.p(name, "name");
            l0.p(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(c0.E5(value).toString());
            return this;
        }

        @d
        public final Builder add(@d String name, @d Date value) {
            l0.p(name, "name");
            l0.p(value, "value");
            add(name, c.b(value));
            return this;
        }

        @d
        @z6.a
        public final Builder add(@d String name, @d Instant value) {
            l0.p(name, "name");
            l0.p(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }
    }

    @i0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J#\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\f2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011H\u0007¢\u0006\u0004\b\r\u0010\u0012J#\u0010\r\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011H\u0007¢\u0006\u0004\b\u0010\u0010\u0012¨\u0006\u0017"}, d2 = {"Lokhttp3/Headers$Companion;", "", "", "", "namesAndValues", "name", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/l2;", "checkName", "value", "checkValue", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "", "(Ljava/util/Map;)Lokhttp3/Headers;", "toHeaders", "headers", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(okhttp3.internal.d.v("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(okhttp3.internal.d.v("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str2, str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            i iVarE1 = q.e1(q.W(strArr.length - 2, 0), 2);
            int iG = iVarE1.g();
            int iH = iVarE1.h();
            int iJ = iVarE1.j();
            if (iJ >= 0) {
                if (iG > iH) {
                    return null;
                }
            } else if (iG < iH) {
                return null;
            }
            while (!b0.K1(str, strArr[iG], true)) {
                if (iG == iH) {
                    return null;
                }
                iG += iJ;
            }
            return strArr[iG + 1];
        }

        @d
        @k(level = m.ERROR, message = "function name changed", replaceWith = @b1(expression = "headersOf(*namesAndValues)", imports = {}))
        @h(name = "-deprecated_of")
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m52deprecated_of(@d String... namesAndValues) {
            l0.p(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @d
        @h(name = "of")
        @l
        public final Headers of(@d String... namesAndValues) throws CloneNotSupportedException {
            l0.p(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = namesAndValues.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) objClone;
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                String str = strArr[i7];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr[i7] = c0.E5(str).toString();
            }
            i iVarE1 = q.e1(q.z1(0, strArr.length), 2);
            int iG = iVarE1.g();
            int iH = iVarE1.h();
            int iJ = iVarE1.j();
            if (iJ < 0 ? iG >= iH : iG <= iH) {
                while (true) {
                    String str2 = strArr[iG];
                    String str3 = strArr[iG + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (iG == iH) {
                        break;
                    }
                    iG += iJ;
                }
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @d
        @k(level = m.ERROR, message = "function moved to extension", replaceWith = @b1(expression = "headers.toHeaders()", imports = {}))
        @h(name = "-deprecated_of")
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m51deprecated_of(@d Map<String, String> headers) {
            l0.p(headers, "headers");
            return of(headers);
        }

        @d
        @h(name = "of")
        @l
        public final Headers of(@d Map<String, String> toHeaders) {
            l0.p(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i7 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null) {
                    String string = c0.E5(key).toString();
                    if (value != null) {
                        String string2 = c0.E5(value).toString();
                        checkName(string);
                        checkValue(string2, string);
                        strArr[i7] = string;
                        strArr[i7 + 1] = string2;
                        i7 += 2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @d
    @h(name = "of")
    @l
    public static final Headers of(@d Map<String, String> map) {
        return Companion.of(map);
    }

    @k(level = m.ERROR, message = "moved to val", replaceWith = @b1(expression = "size", imports = {}))
    @h(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m50deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i7 = 0; i7 < length2; i7++) {
            length += (long) this.namesAndValues[i7].length();
        }
        return length;
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    @e
    public final String get(@d String name) {
        l0.p(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    @e
    public final Date getDate(@d String name) {
        l0.p(name, "name");
        String str = get(name);
        if (str != null) {
            return c.a(str);
        }
        return null;
    }

    @z6.a
    @e
    public final Instant getInstant(@d String name) {
        l0.p(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @d
    public Iterator<u0<? extends String, ? extends String>> iterator() {
        int size = size();
        u0[] u0VarArr = new u0[size];
        for (int i7 = 0; i7 < size; i7++) {
            u0VarArr[i7] = p1.a(name(i7), value(i7));
        }
        return kotlin.jvm.internal.i.a(u0VarArr);
    }

    @d
    public final String name(int i7) {
        return this.namesAndValues[i7 * 2];
    }

    @d
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(b0.S1(s1.f34921a));
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            treeSet.add(name(i7));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        l0.o(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    @d
    public final Builder newBuilder() {
        Builder builder = new Builder();
        d0.q0(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @h(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @d
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(b0.S1(s1.f34921a));
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            String strName = name(i7);
            Locale locale = Locale.US;
            l0.o(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            l0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i7));
        }
        return treeMap;
    }

    @d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            sb.append(name(i7));
            sb.append(": ");
            sb.append(value(i7));
            sb.append("\n");
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @d
    public final String value(int i7) {
        return this.namesAndValues[(i7 * 2) + 1];
    }

    @d
    public final List<String> values(@d String name) {
        l0.p(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            if (b0.K1(name, name(i7), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i7));
            }
        }
        if (arrayList == null) {
            return y.F();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        l0.o(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, w wVar) {
        this(strArr);
    }

    @d
    @h(name = "of")
    @l
    public static final Headers of(@d String... strArr) {
        return Companion.of(strArr);
    }
}
