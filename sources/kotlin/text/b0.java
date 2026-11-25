package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.b1;
import kotlin.collections.u0;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.s1;
import kotlin.q2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class b0 extends a0 {
    @a7.d
    @kotlin.k(message = "Use replaceFirstChar instead.", replaceWith = @b1(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @kotlin.l(warningSince = "1.5")
    public static final String A1(@a7.d String str) {
        l0.p(str, "<this>");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase();
        l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final char[] A2(@a7.d String str, int i7, int i8) {
        l0.p(str, "<this>");
        kotlin.collections.c.f34509a.a(i7, i8, str.length());
        char[] cArr = new char[i8 - i7];
        str.getChars(i7, i8, cArr, 0);
        return cArr;
    }

    @g1(version = "1.4")
    @kotlin.internal.h
    @kotlin.k(message = "Use replaceFirstChar instead.", replaceWith = @b1(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @a7.d
    @q2(markerClass = {kotlin.s.class})
    public static final String B1(@a7.d String str, @a7.d Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @kotlin.internal.f
    private static final char[] B2(String str, char[] destination, int i7, int i8, int i9) {
        l0.p(str, "<this>");
        l0.p(destination, "destination");
        str.getChars(i8, i9, destination, i7);
        return destination;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final String C1(@a7.d byte[] bArr) {
        l0.p(bArr, "<this>");
        return new String(bArr, f.f35353b);
    }

    public static /* synthetic */ char[] C2(String str, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return A2(str, i7, i8);
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final String D1(@a7.d byte[] bArr, int i7, int i8, boolean z7) {
        l0.p(bArr, "<this>");
        kotlin.collections.c.f34509a.a(i7, i8, bArr.length);
        if (!z7) {
            return new String(bArr, i7, i8 - i7, f.f35353b);
        }
        String string = f.f35353b.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i7, i8 - i7)).toString();
        l0.o(string, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return string;
    }

    static /* synthetic */ char[] D2(String str, char[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = str.length();
        }
        l0.p(str, "<this>");
        l0.p(destination, "destination");
        str.getChars(i8, i9, destination, i7);
        return destination;
    }

    public static /* synthetic */ String E1(byte[] bArr, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = bArr.length;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return D1(bArr, i7, i8, z7);
    }

    @kotlin.k(message = "Use lowercase() instead.", replaceWith = @b1(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final String E2(String str) {
        l0.p(str, "<this>");
        String lowerCase = str.toLowerCase();
        l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final byte[] F1(@a7.d String str) {
        l0.p(str, "<this>");
        byte[] bytes = str.getBytes(f.f35353b);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @kotlin.k(message = "Use lowercase() instead.", replaceWith = @b1(expression = "lowercase(locale)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final String F2(String str, Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final byte[] G1(@a7.d String str, int i7, int i8, boolean z7) throws CharacterCodingException {
        l0.p(str, "<this>");
        kotlin.collections.c.f34509a.a(i7, i8, str.length());
        if (!z7) {
            String strSubstring = str.substring(i7, i8);
            l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = f.f35353b;
            l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            l0.o(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer byteBufferEncode = f.f35353b.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i7, i8));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            l0.m(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                l0.o(bArrArray2, "{\n        byteBuffer.array()\n    }");
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    @kotlin.internal.f
    private static final Pattern G2(String str, int i7) {
        l0.p(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i7);
        l0.o(patternCompile, "compile(this, flags)");
        return patternCompile;
    }

    public static /* synthetic */ byte[] H1(String str, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return G1(str, i7, i8, z7);
    }

    static /* synthetic */ Pattern H2(String str, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        l0.p(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i7);
        l0.o(patternCompile, "compile(this, flags)");
        return patternCompile;
    }

    public static final boolean I1(@a7.d String str, @a7.d String suffix, boolean z7) {
        l0.p(str, "<this>");
        l0.p(suffix, "suffix");
        return !z7 ? str.endsWith(suffix) : d2(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    @kotlin.k(message = "Use uppercase() instead.", replaceWith = @b1(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final String I2(String str) {
        l0.p(str, "<this>");
        String upperCase = str.toUpperCase();
        l0.o(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static /* synthetic */ boolean J1(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return I1(str, str2, z7);
    }

    @kotlin.k(message = "Use uppercase() instead.", replaceWith = @b1(expression = "uppercase(locale)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final String J2(String str, Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static boolean K1(@a7.e String str, @a7.e String str2, boolean z7) {
        if (str == null) {
            return str2 == null;
        }
        return !z7 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String K2(String str) {
        l0.p(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    public static /* synthetic */ boolean L1(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return K1(str, str2, z7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String L2(String str, Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String M1(String str, Locale locale, Object... args) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        l0.p(args, "args");
        String str2 = String.format(locale, str, Arrays.copyOf(args, args.length));
        l0.o(str2, "format(locale, this, *args)");
        return str2;
    }

    @kotlin.internal.f
    private static final String N1(String str, Object... args) {
        l0.p(str, "<this>");
        l0.p(args, "args");
        String str2 = String.format(str, Arrays.copyOf(args, args.length));
        l0.o(str2, "format(this, *args)");
        return str2;
    }

    @kotlin.internal.f
    private static final String O1(s1 s1Var, String format, Object... args) {
        l0.p(s1Var, "<this>");
        l0.p(format, "format");
        l0.p(args, "args");
        String str = String.format(format, Arrays.copyOf(args, args.length));
        l0.o(str, "format(format, *args)");
        return str;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String P1(s1 s1Var, Locale locale, String format, Object... args) {
        l0.p(s1Var, "<this>");
        l0.p(locale, "locale");
        l0.p(format, "format");
        l0.p(args, "args");
        String str = String.format(locale, format, Arrays.copyOf(args, args.length));
        l0.o(str, "format(locale, format, *args)");
        return str;
    }

    @g1(version = "1.4")
    @h5.h(name = "formatNullable")
    @kotlin.internal.f
    private static final String Q1(String str, Locale locale, Object... args) {
        l0.p(str, "<this>");
        l0.p(args, "args");
        String str2 = String.format(locale, str, Arrays.copyOf(args, args.length));
        l0.o(str2, "format(locale, this, *args)");
        return str2;
    }

    @g1(version = "1.4")
    @h5.h(name = "formatNullable")
    @kotlin.internal.f
    private static final String R1(s1 s1Var, Locale locale, String format, Object... args) {
        l0.p(s1Var, "<this>");
        l0.p(format, "format");
        l0.p(args, "args");
        String str = String.format(locale, format, Arrays.copyOf(args, args.length));
        l0.o(str, "format(locale, format, *args)");
        return str;
    }

    @a7.d
    public static Comparator<String> S1(@a7.d s1 s1Var) {
        l0.p(s1Var, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        l0.o(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    @kotlin.internal.f
    private static final String T1(String str) {
        l0.p(str, "<this>");
        String strIntern = str.intern();
        l0.o(strIntern, "this as java.lang.String).intern()");
        return strIntern;
    }

    public static final boolean U1(@a7.d CharSequence charSequence) {
        boolean z7;
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable iterableH3 = c0.h3(charSequence);
        if ((iterableH3 instanceof Collection) && ((Collection) iterableH3).isEmpty()) {
            z7 = true;
        } else {
            Iterator it = iterableH3.iterator();
            while (it.hasNext()) {
                if (!d.r(charSequence.charAt(((u0) it).b()))) {
                    z7 = false;
                }
            }
            z7 = true;
        }
        return z7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String V1(String str) {
        l0.p(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String W1(String str, Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @kotlin.internal.f
    private static final int X1(String str, char c8, int i7) {
        l0.p(str, "<this>");
        return str.indexOf(c8, i7);
    }

    @kotlin.internal.f
    private static final int Y1(String str, String str2, int i7) {
        l0.p(str, "<this>");
        l0.p(str2, "str");
        return str.indexOf(str2, i7);
    }

    @kotlin.internal.f
    private static final int Z1(String str, char c8, int i7) {
        l0.p(str, "<this>");
        return str.lastIndexOf(c8, i7);
    }

    @kotlin.internal.f
    private static final int a2(String str, String str2, int i7) {
        l0.p(str, "<this>");
        l0.p(str2, "str");
        return str.lastIndexOf(str2, i7);
    }

    @kotlin.internal.f
    private static final int b2(String str, int i7, int i8) {
        l0.p(str, "<this>");
        return str.offsetByCodePoints(i7, i8);
    }

    public static final boolean c2(@a7.d CharSequence charSequence, int i7, @a7.d CharSequence other, int i8, int i9, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        return ((charSequence instanceof String) && (other instanceof String)) ? d2((String) charSequence, i7, (String) other, i8, i9, z7) : c0.a4(charSequence, i7, other, i8, i9, z7);
    }

    @kotlin.internal.f
    private static final String d1(StringBuffer stringBuffer) {
        l0.p(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    public static boolean d2(@a7.d String str, int i7, @a7.d String other, int i8, int i9, boolean z7) {
        l0.p(str, "<this>");
        l0.p(other, "other");
        return !z7 ? str.regionMatches(i7, other, i8, i9) : str.regionMatches(z7, i7, other, i8, i9);
    }

    @kotlin.internal.f
    private static final String e1(StringBuilder stringBuilder) {
        l0.p(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }

    public static /* synthetic */ boolean e2(CharSequence charSequence, int i7, CharSequence charSequence2, int i8, int i9, boolean z7, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z7 = false;
        }
        return c2(charSequence, i7, charSequence2, i8, i9, z7);
    }

    @kotlin.internal.f
    private static final String f1(byte[] bytes) {
        l0.p(bytes, "bytes");
        return new String(bytes, f.f35353b);
    }

    public static /* synthetic */ boolean f2(String str, int i7, String str2, int i8, int i9, boolean z7, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z7 = false;
        }
        return d2(str, i7, str2, i8, i9, z7);
    }

    @kotlin.internal.f
    private static final String g1(byte[] bytes, int i7, int i8) {
        l0.p(bytes, "bytes");
        return new String(bytes, i7, i8, f.f35353b);
    }

    @a7.d
    public static String g2(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
        if (i7 == 0) {
            return "";
        }
        if (i7 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                cArr[i8] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i7);
        u0 it = new kotlin.ranges.k(1, i7).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(charSequence);
        }
        String string = sb.toString();
        l0.o(string, "{\n                    va…tring()\n                }");
        return string;
    }

    @kotlin.internal.f
    private static final String h1(byte[] bytes, int i7, int i8, Charset charset) {
        l0.p(bytes, "bytes");
        l0.p(charset, "charset");
        return new String(bytes, i7, i8, charset);
    }

    @a7.d
    public static final String h2(@a7.d String str, char c8, char c9, boolean z7) {
        l0.p(str, "<this>");
        if (!z7) {
            String strReplace = str.replace(c8, c9);
            l0.o(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (e.J(cCharAt, c8, z7)) {
                cCharAt = c9;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @kotlin.internal.f
    private static final String i1(byte[] bytes, Charset charset) {
        l0.p(bytes, "bytes");
        l0.p(charset, "charset");
        return new String(bytes, charset);
    }

    @a7.d
    public static final String i2(@a7.d String str, @a7.d String oldValue, @a7.d String newValue, boolean z7) {
        l0.p(str, "<this>");
        l0.p(oldValue, "oldValue");
        l0.p(newValue, "newValue");
        int i7 = 0;
        int iN3 = c0.n3(str, oldValue, 0, z7);
        if (iN3 < 0) {
            return str;
        }
        int length = oldValue.length();
        int iN = kotlin.ranges.q.n(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i7, iN3);
            sb.append(newValue);
            i7 = iN3 + length;
            if (iN3 >= str.length()) {
                break;
            }
            iN3 = c0.n3(str, oldValue, iN3 + iN, z7);
        } while (iN3 > 0);
        sb.append((CharSequence) str, i7, str.length());
        String string = sb.toString();
        l0.o(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    @kotlin.internal.f
    private static final String j1(char[] chars) {
        l0.p(chars, "chars");
        return new String(chars);
    }

    public static /* synthetic */ String j2(String str, char c8, char c9, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return h2(str, c8, c9, z7);
    }

    @kotlin.internal.f
    private static final String k1(char[] chars, int i7, int i8) {
        l0.p(chars, "chars");
        return new String(chars, i7, i8);
    }

    public static /* synthetic */ String k2(String str, String str2, String str3, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return i2(str, str2, str3, z7);
    }

    @kotlin.internal.f
    private static final String l1(int[] codePoints, int i7, int i8) {
        l0.p(codePoints, "codePoints");
        return new String(codePoints, i7, i8);
    }

    @a7.d
    public static final String l2(@a7.d String str, char c8, char c9, boolean z7) {
        l0.p(str, "<this>");
        int iQ3 = c0.q3(str, c8, 0, z7, 2, null);
        return iQ3 < 0 ? str : c0.I4(str, iQ3, iQ3 + 1, String.valueOf(c9)).toString();
    }

    @a7.d
    @kotlin.k(message = "Use replaceFirstChar instead.", replaceWith = @b1(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @kotlin.l(warningSince = "1.5")
    public static final String m1(@a7.d String str) {
        l0.p(str, "<this>");
        Locale locale = Locale.getDefault();
        l0.o(locale, "getDefault()");
        return n1(str, locale);
    }

    @a7.d
    public static final String m2(@a7.d String str, @a7.d String oldValue, @a7.d String newValue, boolean z7) {
        l0.p(str, "<this>");
        l0.p(oldValue, "oldValue");
        l0.p(newValue, "newValue");
        int iR3 = c0.r3(str, oldValue, 0, z7, 2, null);
        return iR3 < 0 ? str : c0.I4(str, iR3, oldValue.length() + iR3, newValue).toString();
    }

    @g1(version = "1.4")
    @kotlin.internal.h
    @kotlin.k(message = "Use replaceFirstChar instead.", replaceWith = @b1(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @a7.d
    @q2(markerClass = {kotlin.s.class})
    public static final String n1(@a7.d String str, @a7.d Locale locale) {
        l0.p(str, "<this>");
        l0.p(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            l0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String n2(String str, char c8, char c9, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return l2(str, c8, c9, z7);
    }

    @kotlin.internal.f
    private static final int o1(String str, int i7) {
        l0.p(str, "<this>");
        return str.codePointAt(i7);
    }

    public static /* synthetic */ String o2(String str, String str2, String str3, boolean z7, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        return m2(str, str2, str3, z7);
    }

    @kotlin.internal.f
    private static final int p1(String str, int i7) {
        l0.p(str, "<this>");
        return str.codePointBefore(i7);
    }

    @a7.d
    public static final List<String> p2(@a7.d CharSequence charSequence, @a7.d Pattern regex, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        c0.M4(i7);
        if (i7 == 0) {
            i7 = -1;
        }
        String[] strArrSplit = regex.split(charSequence, i7);
        l0.o(strArrSplit, "regex.split(this, if (limit == 0) -1 else limit)");
        return kotlin.collections.o.t(strArrSplit);
    }

    @kotlin.internal.f
    private static final int q1(String str, int i7, int i8) {
        l0.p(str, "<this>");
        return str.codePointCount(i7, i8);
    }

    public static /* synthetic */ List q2(CharSequence charSequence, Pattern pattern, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return p2(charSequence, pattern, i7);
    }

    public static final int r1(@a7.d String str, @a7.d String other, boolean z7) {
        l0.p(str, "<this>");
        l0.p(other, "other");
        return z7 ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static boolean r2(@a7.d String str, @a7.d String prefix, int i7, boolean z7) {
        l0.p(str, "<this>");
        l0.p(prefix, "prefix");
        return !z7 ? str.startsWith(prefix, i7) : d2(str, i7, prefix, 0, prefix.length(), z7);
    }

    public static /* synthetic */ int s1(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return r1(str, str2, z7);
    }

    public static boolean s2(@a7.d String str, @a7.d String prefix, boolean z7) {
        l0.p(str, "<this>");
        l0.p(prefix, "prefix");
        return !z7 ? str.startsWith(prefix) : d2(str, 0, prefix, 0, prefix.length(), z7);
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final String t1(@a7.d char[] cArr) {
        l0.p(cArr, "<this>");
        return new String(cArr);
    }

    public static /* synthetic */ boolean t2(String str, String str2, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return r2(str, str2, i7, z7);
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final String u1(@a7.d char[] cArr, int i7, int i8) {
        l0.p(cArr, "<this>");
        kotlin.collections.c.f34509a.a(i7, i8, cArr.length);
        return new String(cArr, i7, i8 - i7);
    }

    public static /* synthetic */ boolean u2(String str, String str2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return s2(str, str2, z7);
    }

    public static /* synthetic */ String v1(char[] cArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = cArr.length;
        }
        return u1(cArr, i7, i8);
    }

    @kotlin.internal.f
    private static final String v2(String str, int i7) {
        l0.p(str, "<this>");
        String strSubstring = str.substring(i7);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @g1(version = "1.5")
    public static final boolean w1(@a7.e CharSequence charSequence, @a7.e CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? c0.X2(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    @kotlin.internal.f
    private static final String w2(String str, int i7, int i8) {
        l0.p(str, "<this>");
        String strSubstring = str.substring(i7, i8);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @g1(version = "1.5")
    public static final boolean x1(@a7.e CharSequence charSequence, @a7.e CharSequence charSequence2, boolean z7) {
        return z7 ? c0.W2(charSequence, charSequence2) : w1(charSequence, charSequence2);
    }

    @kotlin.internal.f
    private static final byte[] x2(String str, Charset charset) {
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @kotlin.internal.f
    private static final boolean y1(String str, CharSequence charSequence) {
        l0.p(str, "<this>");
        l0.p(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    static /* synthetic */ byte[] y2(String str, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = f.f35353b;
        }
        l0.p(str, "<this>");
        l0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @kotlin.internal.f
    private static final boolean z1(String str, StringBuffer stringBuilder) {
        l0.p(str, "<this>");
        l0.p(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    @kotlin.internal.f
    private static final char[] z2(String str) {
        l0.p(str, "<this>");
        char[] charArray = str.toCharArray();
        l0.o(charArray, "this as java.lang.String).toCharArray()");
        return charArray;
    }
}
