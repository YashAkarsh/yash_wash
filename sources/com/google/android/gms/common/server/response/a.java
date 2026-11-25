package com.google.android.gms.common.server.response;

import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.server.response.FastJsonResponse;
import g1.r;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.h0;
import org.chromium.net.impl.CronetUrlRequest;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@y
public class a<T extends FastJsonResponse> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char[] f15930g = {'u', 'l', 'l'};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char[] f15931h = {'r', 'u', 'e'};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char[] f15932i = {'r', 'u', 'e', h0.f35376b};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f15933j = {'a', 'l', 's', 'e'};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char[] f15934k = {'a', 'l', 's', 'e', h0.f35376b};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f15935l = {'\n'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final j<Integer> f15936m = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final j<Long> f15937n = new c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final j<Float> f15938o = new d();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final j<Double> f15939p = new e();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final j<Boolean> f15940q = new f();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final j<String> f15941r = new g();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final j<BigInteger> f15942s = new h();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final j<BigDecimal> f15943t = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f15944a = new char[1];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f15945b = new char[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f15946c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StringBuilder f15947d = new StringBuilder(32);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f15948e = new StringBuilder(1024);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Stack<Integer> f15949f = new Stack<>();

    /* JADX INFO: renamed from: com.google.android.gms.common.server.response.a$a, reason: collision with other inner class name */
    @c1.a
    @y
    public static class C0185a extends Exception {
        public C0185a(@m0 String str) {
            super(str);
        }

        public C0185a(@m0 String str, @m0 Throwable th) {
            super("Error instantiating inner object", th);
        }

        public C0185a(@m0 Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(BufferedReader bufferedReader, boolean z7) throws IOException, C0185a {
        char cK = k(bufferedReader);
        if (cK == '\"') {
            if (z7) {
                throw new C0185a("No boolean value found in string");
            }
            return A(bufferedReader, true);
        }
        if (cK == 'f') {
            z(bufferedReader, z7 ? f15934k : f15933j);
            return false;
        }
        if (cK == 'n') {
            z(bufferedReader, f15930g);
            return false;
        }
        if (cK == 't') {
            z(bufferedReader, z7 ? f15932i : f15931h);
            return true;
        }
        StringBuilder sb = new StringBuilder(19);
        sb.append("Unexpected token: ");
        sb.append(cK);
        throw new C0185a(sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0273  */
    /* JADX WARN: Code duplicated, block: B:137:0x028f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0276 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws IOException, C0185a {
        int i7;
        HashMap map;
        char cK;
        Map<String, FastJsonResponse.Field<?, ?>> mapD = fastJsonResponse.d();
        String strS = s(bufferedReader);
        if (strS == null) {
            y(1);
            return false;
        }
        while (strS != null) {
            FastJsonResponse.Field<?, ?> field = mapD.get(strS);
            if (field == null) {
                strS = t(bufferedReader);
            } else {
                this.f15949f.push(4);
                int i8 = field.f15913b;
                switch (i8) {
                    case 0:
                        if (field.f15914c) {
                            fastJsonResponse.X(field, w(bufferedReader, f15936m));
                        } else {
                            fastJsonResponse.W(field, n(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb = new StringBuilder(55);
                                sb.append("Expected end of object or field separator, but found: ");
                                sb.append(cK);
                                throw new C0185a(sb.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 1:
                        if (field.f15914c) {
                            fastJsonResponse.I(field, w(bufferedReader, f15942s));
                        } else {
                            fastJsonResponse.F(field, v(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb2 = new StringBuilder(55);
                                sb2.append("Expected end of object or field separator, but found: ");
                                sb2.append(cK);
                                throw new C0185a(sb2.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 2:
                        if (field.f15914c) {
                            fastJsonResponse.a0(field, w(bufferedReader, f15937n));
                        } else {
                            fastJsonResponse.Z(field, p(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb3 = new StringBuilder(55);
                                sb3.append("Expected end of object or field separator, but found: ");
                                sb3.append(cK);
                                throw new C0185a(sb3.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 3:
                        if (field.f15914c) {
                            fastJsonResponse.U(field, w(bufferedReader, f15938o));
                        } else {
                            fastJsonResponse.S(field, m(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb4 = new StringBuilder(55);
                                sb4.append("Expected end of object or field separator, but found: ");
                                sb4.append(cK);
                                throw new C0185a(sb4.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 4:
                        if (field.f15914c) {
                            fastJsonResponse.Q(field, w(bufferedReader, f15939p));
                        } else {
                            fastJsonResponse.O(field, l(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb5 = new StringBuilder(55);
                                sb5.append("Expected end of object or field separator, but found: ");
                                sb5.append(cK);
                                throw new C0185a(sb5.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 5:
                        if (field.f15914c) {
                            fastJsonResponse.D(field, w(bufferedReader, f15943t));
                        } else {
                            fastJsonResponse.A(field, u(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb6 = new StringBuilder(55);
                                sb6.append("Expected end of object or field separator, but found: ");
                                sb6.append(cK);
                                throw new C0185a(sb6.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 6:
                        if (field.f15914c) {
                            fastJsonResponse.L(field, w(bufferedReader, f15940q));
                        } else {
                            fastJsonResponse.K(field, A(bufferedReader, false));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb7 = new StringBuilder(55);
                                sb7.append("Expected end of object or field separator, but found: ");
                                sb7.append(cK);
                                throw new C0185a(sb7.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 7:
                        if (field.f15914c) {
                            fastJsonResponse.u(field, w(bufferedReader, f15941r));
                        } else {
                            fastJsonResponse.s(field, q(bufferedReader));
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb8 = new StringBuilder(55);
                                sb8.append("Expected end of object or field separator, but found: ");
                                sb8.append(cK);
                                throw new C0185a(sb8.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 8:
                        fastJsonResponse.N(field, g1.c.a(r(bufferedReader, this.f15946c, this.f15948e, f15935l)));
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb9 = new StringBuilder(55);
                                sb9.append("Expected end of object or field separator, but found: ");
                                sb9.append(cK);
                                throw new C0185a(sb9.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 9:
                        fastJsonResponse.N(field, g1.c.b(r(bufferedReader, this.f15946c, this.f15948e, f15935l)));
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb10 = new StringBuilder(55);
                                sb10.append("Expected end of object or field separator, but found: ");
                                sb10.append(cK);
                                throw new C0185a(sb10.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 10:
                        char cK2 = k(bufferedReader);
                        if (cK2 == 'n') {
                            z(bufferedReader, f15930g);
                            map = null;
                        } else {
                            if (cK2 != '{') {
                                throw new C0185a("Expected start of a map object");
                            }
                            this.f15949f.push(1);
                            map = new HashMap();
                            while (true) {
                                char cK3 = k(bufferedReader);
                                if (cK3 == 0) {
                                    throw new C0185a("Unexpected EOF");
                                }
                                if (cK3 == '\"') {
                                    String strB = b(bufferedReader, this.f15945b, this.f15947d, null);
                                    if (k(bufferedReader) != ':') {
                                        String strValueOf = String.valueOf(strB);
                                        throw new C0185a(strValueOf.length() != 0 ? "No map value found for key ".concat(strValueOf) : new String("No map value found for key "));
                                    }
                                    if (k(bufferedReader) != '\"') {
                                        String strValueOf2 = String.valueOf(strB);
                                        throw new C0185a(strValueOf2.length() != 0 ? "Expected String value for key ".concat(strValueOf2) : new String("Expected String value for key "));
                                    }
                                    map.put(strB, b(bufferedReader, this.f15945b, this.f15947d, null));
                                    char cK4 = k(bufferedReader);
                                    if (cK4 != ',') {
                                        if (cK4 != '}') {
                                            StringBuilder sb11 = new StringBuilder(48);
                                            sb11.append("Unexpected character while parsing string map: ");
                                            sb11.append(cK4);
                                            throw new C0185a(sb11.toString());
                                        }
                                        y(1);
                                    }
                                } else if (cK3 == '}') {
                                    y(1);
                                }
                                i7 = 4;
                                y(i7);
                                y(2);
                                cK = k(bufferedReader);
                                if (cK == ',') {
                                    strS = s(bufferedReader);
                                } else {
                                    if (cK != '}') {
                                        StringBuilder sb12 = new StringBuilder(55);
                                        sb12.append("Expected end of object or field separator, but found: ");
                                        sb12.append(cK);
                                        throw new C0185a(sb12.toString());
                                    }
                                    strS = null;
                                }
                            }
                        }
                        fastJsonResponse.t(field, map);
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb13 = new StringBuilder(55);
                                sb13.append("Expected end of object or field separator, but found: ");
                                sb13.append(cK);
                                throw new C0185a(sb13.toString());
                            }
                            strS = null;
                        }
                        break;
                    case 11:
                        if (!field.f15914c) {
                            char cK5 = k(bufferedReader);
                            if (cK5 == 'n') {
                                z(bufferedReader, f15930g);
                                fastJsonResponse.b(field, field.f15917f, null);
                            } else {
                                this.f15949f.push(1);
                                if (cK5 != '{') {
                                    throw new C0185a("Expected start of object");
                                }
                                try {
                                    FastJsonResponse fastJsonResponseA1 = field.a1();
                                    B(bufferedReader, fastJsonResponseA1);
                                    fastJsonResponse.b(field, field.f15917f, fastJsonResponseA1);
                                } catch (IllegalAccessException e8) {
                                    throw new C0185a("Error instantiating inner object", e8);
                                } catch (InstantiationException e9) {
                                    throw new C0185a("Error instantiating inner object", e9);
                                }
                            }
                            break;
                        } else {
                            char cK6 = k(bufferedReader);
                            if (cK6 == 'n') {
                                z(bufferedReader, f15930g);
                                fastJsonResponse.a(field, field.f15917f, null);
                            } else {
                                this.f15949f.push(5);
                                if (cK6 != '[') {
                                    throw new C0185a("Expected array start");
                                }
                                fastJsonResponse.a(field, field.f15917f, x(bufferedReader, field));
                            }
                        }
                        i7 = 4;
                        y(i7);
                        y(2);
                        cK = k(bufferedReader);
                        if (cK == ',') {
                            strS = s(bufferedReader);
                        } else {
                            if (cK != '}') {
                                StringBuilder sb14 = new StringBuilder(55);
                                sb14.append("Expected end of object or field separator, but found: ");
                                sb14.append(cK);
                                throw new C0185a(sb14.toString());
                            }
                            strS = null;
                        }
                        break;
                    default:
                        StringBuilder sb15 = new StringBuilder(30);
                        sb15.append("Invalid field type ");
                        sb15.append(i8);
                        throw new C0185a(sb15.toString());
                }
            }
        }
        y(1);
        return true;
    }

    private static final String b(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @o0 char[] cArr2) throws IOException, C0185a {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            int i7 = bufferedReader.read(cArr);
            if (i7 == -1) {
                throw new C0185a("Unexpected EOF while parsing string");
            }
            for (int i8 = 0; i8 < i7; i8++) {
                char c8 = cArr[i8];
                if (Character.isISOControl(c8)) {
                    if (cArr2 != null) {
                        int i9 = 0;
                        while (true) {
                            if (i9 <= 0) {
                                if (cArr2[i9] == c8) {
                                    break;
                                }
                                i9++;
                            }
                        }
                    }
                    throw new C0185a("Unexpected control character while reading string");
                }
                if (c8 != '\"') {
                    if (c8 == '\\') {
                        z8 = !z8;
                        z7 = true;
                    }
                } else if (!z8) {
                    sb.append(cArr, 0, i8);
                    bufferedReader.reset();
                    bufferedReader.skip(i8 + 1);
                    return z7 ? r.c(sb.toString()) : sb.toString();
                }
                z8 = false;
            }
            sb.append(cArr, 0, i7);
            bufferedReader.mark(cArr.length);
        }
    }

    private final char k(BufferedReader bufferedReader) throws IOException, C0185a {
        if (bufferedReader.read(this.f15944a) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.f15944a[0])) {
            if (bufferedReader.read(this.f15944a) == -1) {
                return (char) 0;
            }
        }
        return this.f15944a[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double l(BufferedReader bufferedReader) throws IOException, C0185a {
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.f15946c, 0, iO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float m(BufferedReader bufferedReader) throws IOException, C0185a {
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.f15946c, 0, iO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(BufferedReader bufferedReader) throws IOException, C0185a {
        int i7;
        int i8;
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return 0;
        }
        char[] cArr = this.f15946c;
        if (iO <= 0) {
            throw new C0185a("No number to parse");
        }
        char c8 = cArr[0];
        int i9 = c8 == '-' ? Integer.MIN_VALUE : -2147483647;
        int i10 = c8 == '-' ? 1 : 0;
        if (i10 < iO) {
            i8 = i10 + 1;
            int iDigit = Character.digit(cArr[i10], 10);
            if (iDigit < 0) {
                throw new C0185a("Unexpected non-digit character");
            }
            i7 = -iDigit;
        } else {
            i7 = 0;
            i8 = i10;
        }
        while (i8 < iO) {
            int i11 = i8 + 1;
            int iDigit2 = Character.digit(cArr[i8], 10);
            if (iDigit2 < 0) {
                throw new C0185a("Unexpected non-digit character");
            }
            if (i7 < -214748364) {
                throw new C0185a("Number too large");
            }
            int i12 = i7 * 10;
            if (i12 < i9 + iDigit2) {
                throw new C0185a("Number too large");
            }
            i7 = i12 - iDigit2;
            i8 = i11;
        }
        if (i10 == 0) {
            return -i7;
        }
        if (i8 > 1) {
            return i7;
        }
        throw new C0185a("No digits to parse");
    }

    private final int o(BufferedReader bufferedReader, char[] cArr) throws IOException, C0185a {
        int i7;
        char cK = k(bufferedReader);
        if (cK == 0) {
            throw new C0185a("Unexpected EOF");
        }
        if (cK == ',') {
            throw new C0185a("Missing value");
        }
        if (cK == 'n') {
            z(bufferedReader, f15930g);
            return 0;
        }
        bufferedReader.mark(1024);
        if (cK == '\"') {
            i7 = 0;
            boolean z7 = false;
            while (i7 < 1024 && bufferedReader.read(cArr, i7, 1) != -1) {
                char c8 = cArr[i7];
                if (Character.isISOControl(c8)) {
                    throw new C0185a("Unexpected control character while reading string");
                }
                if (c8 != '\"') {
                    if (c8 == '\\') {
                        z7 = !z7;
                    }
                    i7++;
                } else if (!z7) {
                    bufferedReader.reset();
                    bufferedReader.skip(i7 + 1);
                    return i7;
                }
                z7 = false;
                i7++;
            }
        } else {
            cArr[0] = cK;
            i7 = 1;
            while (i7 < 1024 && bufferedReader.read(cArr, i7, 1) != -1) {
                char c9 = cArr[i7];
                if (c9 == '}' || c9 == ',' || Character.isWhitespace(c9) || cArr[i7] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i7 - 1);
                    cArr[i7] = 0;
                    return i7;
                }
                i7++;
            }
        }
        if (i7 == 1024) {
            throw new C0185a("Absurdly long value");
        }
        throw new C0185a("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long p(BufferedReader bufferedReader) throws IOException, C0185a {
        long j7;
        int i7;
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return 0L;
        }
        char[] cArr = this.f15946c;
        if (iO <= 0) {
            throw new C0185a("No number to parse");
        }
        char c8 = cArr[0];
        long j8 = c8 == '-' ? Long.MIN_VALUE : -9223372036854775807L;
        int i8 = c8 == '-' ? 1 : 0;
        if (i8 < iO) {
            i7 = i8 + 1;
            int iDigit = Character.digit(cArr[i8], 10);
            if (iDigit < 0) {
                throw new C0185a("Unexpected non-digit character");
            }
            j7 = -iDigit;
        } else {
            j7 = 0;
            i7 = i8;
        }
        while (i7 < iO) {
            int i9 = i7 + 1;
            int iDigit2 = Character.digit(cArr[i7], 10);
            if (iDigit2 < 0) {
                throw new C0185a("Unexpected non-digit character");
            }
            if (j7 < v5.a.f40434c) {
                throw new C0185a("Number too large");
            }
            long j9 = j7 * 10;
            int i10 = iO;
            long j10 = iDigit2;
            if (j9 < j8 + j10) {
                throw new C0185a("Number too large");
            }
            j7 = j9 - j10;
            iO = i10;
            i7 = i9;
        }
        if (i8 == 0) {
            return -j7;
        }
        if (i7 > 1) {
            return j7;
        }
        throw new C0185a("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public final String q(BufferedReader bufferedReader) throws IOException, C0185a {
        return r(bufferedReader, this.f15945b, this.f15947d, null);
    }

    @o0
    private final String r(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, @o0 char[] cArr2) throws IOException, C0185a {
        char cK = k(bufferedReader);
        if (cK == '\"') {
            return b(bufferedReader, cArr, sb, cArr2);
        }
        if (cK != 'n') {
            throw new C0185a("Expected string");
        }
        z(bufferedReader, f15930g);
        return null;
    }

    @o0
    private final String s(BufferedReader bufferedReader) throws IOException, C0185a {
        this.f15949f.push(2);
        char cK = k(bufferedReader);
        if (cK == '\"') {
            this.f15949f.push(3);
            String strB = b(bufferedReader, this.f15945b, this.f15947d, null);
            y(3);
            if (k(bufferedReader) == ':') {
                return strB;
            }
            throw new C0185a("Expected key/value separator");
        }
        if (cK == ']') {
            y(2);
            y(1);
            y(5);
            return null;
        }
        if (cK == '}') {
            y(2);
            return null;
        }
        StringBuilder sb = new StringBuilder(19);
        sb.append("Unexpected token: ");
        sb.append(cK);
        throw new C0185a(sb.toString());
    }

    @o0
    private final String t(BufferedReader bufferedReader) throws IOException, C0185a {
        bufferedReader.mark(1024);
        char cK = k(bufferedReader);
        int i7 = 1;
        if (cK != '\"') {
            if (cK == ',') {
                throw new C0185a("Missing value");
            }
            if (cK == '[') {
                this.f15949f.push(5);
                bufferedReader.mark(32);
                if (k(bufferedReader) == ']') {
                    y(5);
                } else {
                    bufferedReader.reset();
                    boolean z7 = false;
                    boolean z8 = false;
                    while (i7 > 0) {
                        char cK2 = k(bufferedReader);
                        if (cK2 == 0) {
                            throw new C0185a("Unexpected EOF while parsing array");
                        }
                        if (Character.isISOControl(cK2)) {
                            throw new C0185a("Unexpected control character while reading array");
                        }
                        if (cK2 == '\"') {
                            if (!z8) {
                                z7 = !z7;
                            }
                            cK2 = '\"';
                        }
                        if (cK2 == '[') {
                            if (!z7) {
                                i7++;
                            }
                            cK2 = '[';
                        }
                        if (cK2 == ']' && !z7) {
                            i7--;
                        }
                        z8 = (cK2 == '\\' && z7) ? !z8 : false;
                    }
                    y(5);
                }
            } else if (cK != '{') {
                bufferedReader.reset();
                o(bufferedReader, this.f15946c);
            } else {
                this.f15949f.push(1);
                bufferedReader.mark(32);
                char cK3 = k(bufferedReader);
                if (cK3 == '}') {
                    y(1);
                } else {
                    if (cK3 != '\"') {
                        StringBuilder sb = new StringBuilder(18);
                        sb.append("Unexpected token ");
                        sb.append(cK3);
                        throw new C0185a(sb.toString());
                    }
                    bufferedReader.reset();
                    s(bufferedReader);
                    while (t(bufferedReader) != null) {
                    }
                    y(1);
                }
            }
        } else {
            if (bufferedReader.read(this.f15944a) == -1) {
                throw new C0185a("Unexpected EOF while parsing string");
            }
            char c8 = this.f15944a[0];
            boolean z9 = false;
            while (true) {
                if (c8 == '\"') {
                    if (!z9) {
                        break;
                    }
                    c8 = '\"';
                    z9 = true;
                }
                z9 = c8 == '\\' ? !z9 : false;
                if (bufferedReader.read(this.f15944a) == -1) {
                    throw new C0185a("Unexpected EOF while parsing string");
                }
                c8 = this.f15944a[0];
                if (Character.isISOControl(c8)) {
                    throw new C0185a("Unexpected control character while reading string");
                }
            }
        }
        char cK4 = k(bufferedReader);
        if (cK4 == ',') {
            y(2);
            return s(bufferedReader);
        }
        if (cK4 == '}') {
            y(2);
            return null;
        }
        StringBuilder sb2 = new StringBuilder(18);
        sb2.append("Unexpected token ");
        sb2.append(cK4);
        throw new C0185a(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public final BigDecimal u(BufferedReader bufferedReader) throws IOException, C0185a {
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return null;
        }
        return new BigDecimal(new String(this.f15946c, 0, iO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public final BigInteger v(BufferedReader bufferedReader) throws IOException, C0185a {
        int iO = o(bufferedReader, this.f15946c);
        if (iO == 0) {
            return null;
        }
        return new BigInteger(new String(this.f15946c, 0, iO));
    }

    @o0
    private final <O> ArrayList<O> w(BufferedReader bufferedReader, j<O> jVar) throws IOException, C0185a {
        char cK = k(bufferedReader);
        if (cK == 'n') {
            z(bufferedReader, f15930g);
            return null;
        }
        if (cK != '[') {
            throw new C0185a("Expected start of array");
        }
        this.f15949f.push(5);
        ArrayList<O> arrayList = new ArrayList<>();
        while (true) {
            bufferedReader.mark(1024);
            char cK2 = k(bufferedReader);
            if (cK2 == 0) {
                throw new C0185a("Unexpected EOF");
            }
            if (cK2 != ',') {
                if (cK2 == ']') {
                    y(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(jVar.a(this, bufferedReader));
            }
        }
    }

    @o0
    private final <T extends FastJsonResponse> ArrayList<T> x(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws IOException, C0185a {
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList();
        char cK = k(bufferedReader);
        if (cK == ']') {
            y(5);
            return jVar;
        }
        if (cK == 'n') {
            z(bufferedReader, f15930g);
            y(5);
            return null;
        }
        if (cK != '{') {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(cK);
            throw new C0185a(sb.toString());
        }
        this.f15949f.push(1);
        while (true) {
            try {
                FastJsonResponse fastJsonResponseA1 = field.a1();
                if (!B(bufferedReader, fastJsonResponseA1)) {
                    return jVar;
                }
                jVar.add(fastJsonResponseA1);
                char cK2 = k(bufferedReader);
                if (cK2 != ',') {
                    if (cK2 == ']') {
                        y(5);
                        return jVar;
                    }
                    StringBuilder sb2 = new StringBuilder(19);
                    sb2.append("Unexpected token: ");
                    sb2.append(cK2);
                    throw new C0185a(sb2.toString());
                }
                if (k(bufferedReader) != '{') {
                    throw new C0185a("Expected start of next object in array");
                }
                this.f15949f.push(1);
            } catch (IllegalAccessException e8) {
                throw new C0185a("Error instantiating inner object", e8);
            } catch (InstantiationException e9) {
                throw new C0185a("Error instantiating inner object", e9);
            }
        }
    }

    private final void y(int i7) throws C0185a {
        if (this.f15949f.isEmpty()) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i7);
            sb.append(" but had empty stack");
            throw new C0185a(sb.toString());
        }
        int iIntValue = this.f15949f.pop().intValue();
        if (iIntValue == i7) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i7);
        sb2.append(" but had ");
        sb2.append(iIntValue);
        throw new C0185a(sb2.toString());
    }

    private final void z(BufferedReader bufferedReader, char[] cArr) throws IOException, C0185a {
        int i7 = 0;
        while (true) {
            int length = cArr.length;
            if (i7 >= length) {
                return;
            }
            int i8 = bufferedReader.read(this.f15945b, 0, length - i7);
            if (i8 == -1) {
                throw new C0185a("Unexpected EOF");
            }
            for (int i9 = 0; i9 < i8; i9++) {
                if (cArr[i9 + i7] != this.f15945b[i9]) {
                    throw new C0185a("Unexpected character");
                }
            }
            i7 += i8;
        }
    }

    @c1.a
    public void a(@m0 InputStream inputStream, @m0 T t7) throws C0185a {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.f15949f.push(0);
                char cK = k(bufferedReader);
                if (cK == 0) {
                    throw new C0185a("No data to parse");
                }
                if (cK == '[') {
                    this.f15949f.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> mapD = t7.d();
                    if (mapD.size() != 1) {
                        throw new C0185a("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = mapD.entrySet().iterator().next().getValue();
                    t7.a(value, value.f15917f, x(bufferedReader, value));
                } else {
                    if (cK != '{') {
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(cK);
                        throw new C0185a(sb.toString());
                    }
                    this.f15949f.push(1);
                    B(bufferedReader, t7);
                }
                y(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e8) {
                throw new C0185a(e8);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
