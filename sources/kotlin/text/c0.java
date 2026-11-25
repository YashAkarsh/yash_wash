package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.p1;
import kotlin.q2;
import kotlin.t0;
import kotlin.u0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class c0 extends b0 {

    public static final class a extends kotlin.collections.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f35333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f35334b;

        a(CharSequence charSequence) {
            this.f35334b = charSequence;
        }

        @Override // kotlin.collections.u
        public char b() {
            CharSequence charSequence = this.f35334b;
            int i7 = this.f35333a;
            this.f35333a = i7 + 1;
            return charSequence.charAt(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35333a < this.f35334b.length();
        }
    }

    static final class b extends n0 implements i5.p<CharSequence, Integer, u0<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f35335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f35336b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(char[] cArr, boolean z7) {
            super(2);
            this.f35335a = cArr;
            this.f35336b = z7;
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ u0<? extends Integer, ? extends Integer> a0(CharSequence charSequence, Integer num) {
            return b(charSequence, num.intValue());
        }

        @a7.e
        public final u0<Integer, Integer> b(@a7.d CharSequence $receiver, int i7) {
            l0.p($receiver, "$this$$receiver");
            int iT3 = c0.t3($receiver, this.f35335a, i7, this.f35336b);
            if (iT3 < 0) {
                return null;
            }
            return p1.a(Integer.valueOf(iT3), 1);
        }
    }

    static final class c extends n0 implements i5.p<CharSequence, Integer, u0<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f35337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f35338b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<String> list, boolean z7) {
            super(2);
            this.f35337a = list;
            this.f35338b = z7;
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ u0<? extends Integer, ? extends Integer> a0(CharSequence charSequence, Integer num) {
            return b(charSequence, num.intValue());
        }

        @a7.e
        public final u0<Integer, Integer> b(@a7.d CharSequence $receiver, int i7) {
            l0.p($receiver, "$this$$receiver");
            u0 u0VarD3 = c0.d3($receiver, this.f35337a, i7, this.f35338b, false);
            if (u0VarD3 != null) {
                return p1.a(u0VarD3.e(), Integer.valueOf(((String) u0VarD3.f()).length()));
            }
            return null;
        }
    }

    static final class d extends n0 implements i5.l<kotlin.ranges.k, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35339a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence) {
            super(1);
            this.f35339a = charSequence;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d kotlin.ranges.k it) {
            l0.p(it, "it");
            return c0.j5(this.f35339a, it);
        }
    }

    static final class e extends n0 implements i5.l<kotlin.ranges.k, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35340a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence) {
            super(1);
            this.f35340a = charSequence;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d kotlin.ranges.k it) {
            l0.p(it, "it");
            return c0.j5(this.f35340a, it);
        }
    }

    @kotlin.internal.f
    private static final boolean A3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String A4(String str, String str2, String str3, String str4, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str4 = str;
        }
        return y4(str, str2, str3, str4);
    }

    public static /* synthetic */ String A5(String str, char c8, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return y5(str, c8, str2);
    }

    @a7.d
    public static final kotlin.collections.u B3(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return new a(charSequence);
    }

    @a7.d
    public static final String B4(@a7.d String str, char c8, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iE3 = E3(str, c8, 0, false, 6, null);
        return iE3 == -1 ? missingDelimiterValue : I4(str, 0, iE3, replacement).toString();
    }

    public static /* synthetic */ String B5(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return z5(str, str2, str3);
    }

    public static final int C3(@a7.d CharSequence charSequence, char c8, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? H3(charSequence, new char[]{c8}, i7, z7) : ((String) charSequence).lastIndexOf(c8, i7);
    }

    @a7.d
    public static final String C4(@a7.d String str, @a7.d String delimiter, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, delimiter, 0, false, 6, null);
        return iF3 == -1 ? missingDelimiterValue : I4(str, 0, iF3, replacement).toString();
    }

    @g1(version = "1.5")
    public static final boolean C5(@a7.d String str) {
        l0.p(str, "<this>");
        if (l0.g(str, "true")) {
            return true;
        }
        if (l0.g(str, com.paytm.pgsdk.d.G)) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    public static final int D3(@a7.d CharSequence charSequence, @a7.d String string, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(string, "string");
        return (z7 || !(charSequence instanceof String)) ? o3(charSequence, string, i7, 0, z7, true) : ((String) charSequence).lastIndexOf(string, i7);
    }

    public static /* synthetic */ String D4(String str, char c8, String str2, String str3, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str3 = str;
        }
        return B4(str, c8, str2, str3);
    }

    @g1(version = "1.5")
    @a7.e
    public static final Boolean D5(@a7.d String str) {
        l0.p(str, "<this>");
        if (l0.g(str, "true")) {
            return Boolean.TRUE;
        }
        if (l0.g(str, com.paytm.pgsdk.d.G)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int E3(CharSequence charSequence, char c8, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = i3(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return C3(charSequence, c8, i7, z7);
    }

    public static /* synthetic */ String E4(String str, String str2, String str3, String str4, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str4 = str;
        }
        return C4(str, str2, str3, str4);
    }

    @a7.d
    public static CharSequence E5(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zR = kotlin.text.d.r(charSequence.charAt(!z7 ? i7 : length));
            if (z7) {
                if (!zR) {
                    break;
                }
                length--;
            } else if (zR) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }

    public static /* synthetic */ int F3(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = i3(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return D3(charSequence, str, i7, z7);
    }

    @kotlin.internal.f
    private static final String F4(CharSequence charSequence, o regex, String replacement) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        l0.p(replacement, "replacement");
        return regex.o(charSequence, replacement);
    }

    @a7.d
    public static final CharSequence F5(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zBooleanValue = predicate.z(Character.valueOf(charSequence.charAt(!z7 ? i7 : length))).booleanValue();
            if (z7) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }

    public static final int G3(@a7.d CharSequence charSequence, @a7.d Collection<String> strings, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(strings, "strings");
        u0<Integer, String> u0VarD3 = d3(charSequence, strings, i7, z7, true);
        if (u0VarD3 != null) {
            return u0VarD3.e().intValue();
        }
        return -1;
    }

    @g1(version = "1.5")
    @h5.h(name = "replaceFirstCharWithChar")
    @t0
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String G4(String str, i5.l<? super Character, Character> transform) {
        l0.p(str, "<this>");
        l0.p(transform, "transform");
        if (!(str.length() > 0)) {
            return str;
        }
        char cCharValue = transform.z(Character.valueOf(str.charAt(0))).charValue();
        String strSubstring = str.substring(1);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return cCharValue + strSubstring;
    }

    @a7.d
    public static final CharSequence G5(@a7.d CharSequence charSequence, @a7.d char... chars) {
        l0.p(charSequence, "<this>");
        l0.p(chars, "chars");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zO8 = kotlin.collections.p.O8(chars, charSequence.charAt(!z7 ? i7 : length));
            if (z7) {
                if (!zO8) {
                    break;
                }
                length--;
            } else if (zO8) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }

    public static final int H3(@a7.d CharSequence charSequence, @a7.d char[] chars, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.p.xt(chars), i7);
        }
        for (int iU = kotlin.ranges.q.u(i7, i3(charSequence)); -1 < iU; iU--) {
            char cCharAt = charSequence.charAt(iU);
            boolean z8 = false;
            for (char c8 : chars) {
                if (kotlin.text.e.J(c8, cCharAt, z7)) {
                    z8 = true;
                    break;
                }
            }
            if (z8) {
                return iU;
            }
        }
        return -1;
    }

    @g1(version = "1.5")
    @h5.h(name = "replaceFirstCharWithCharSequence")
    @t0
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String H4(String str, i5.l<? super Character, ? extends CharSequence> transform) {
        l0.p(str, "<this>");
        l0.p(transform, "transform");
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) transform.z(Character.valueOf(str.charAt(0))));
        String strSubstring = str.substring(1);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @kotlin.internal.f
    private static final String H5(String str) {
        l0.p(str, "<this>");
        return E5(str).toString();
    }

    public static /* synthetic */ int I3(CharSequence charSequence, Collection collection, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = i3(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return G3(charSequence, collection, i7, z7);
    }

    @a7.d
    public static final CharSequence I4(@a7.d CharSequence charSequence, int i7, int i8, @a7.d CharSequence replacement) {
        l0.p(charSequence, "<this>");
        l0.p(replacement, "replacement");
        if (i8 >= i7) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i7);
            l0.o(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i8, charSequence.length());
            l0.o(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i8 + ") is less than start index (" + i7 + ").");
    }

    @a7.d
    public static final String I5(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        int length = str.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zBooleanValue = predicate.z(Character.valueOf(str.charAt(!z7 ? i7 : length))).booleanValue();
            if (z7) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return str.subSequence(i7, length + 1).toString();
    }

    public static /* synthetic */ int J3(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = i3(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return H3(charSequence, cArr, i7, z7);
    }

    @a7.d
    public static final CharSequence J4(@a7.d CharSequence charSequence, @a7.d kotlin.ranges.k range, @a7.d CharSequence replacement) {
        l0.p(charSequence, "<this>");
        l0.p(range, "range");
        l0.p(replacement, "replacement");
        return I4(charSequence, range.d().intValue(), range.f().intValue() + 1, replacement);
    }

    @a7.d
    public static final String J5(@a7.d String str, @a7.d char... chars) {
        l0.p(str, "<this>");
        l0.p(chars, "chars");
        int length = str.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zO8 = kotlin.collections.p.O8(chars, str.charAt(!z7 ? i7 : length));
            if (z7) {
                if (!zO8) {
                    break;
                }
                length--;
            } else if (zO8) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return str.subSequence(i7, length + 1).toString();
    }

    @a7.d
    public static final kotlin.sequences.m<String> K3(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return Z4(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @kotlin.internal.f
    private static final String K4(String str, int i7, int i8, CharSequence replacement) {
        l0.p(str, "<this>");
        l0.p(replacement, "replacement");
        return I4(str, i7, i8, replacement).toString();
    }

    @a7.d
    public static final CharSequence K5(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (!kotlin.text.d.r(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return "";
    }

    @a7.d
    public static final List<String> L3(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return kotlin.sequences.u.c3(K3(charSequence));
    }

    @kotlin.internal.f
    private static final String L4(String str, kotlin.ranges.k range, CharSequence replacement) {
        l0.p(str, "<this>");
        l0.p(range, "range");
        l0.p(replacement, "replacement");
        return J4(str, range, replacement).toString();
    }

    @a7.d
    public static final CharSequence L5(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i7 = length - 1;
            if (!predicate.z(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i7 < 0) {
                return "";
            }
            length = i7;
        }
    }

    @kotlin.internal.f
    private static final boolean M3(CharSequence charSequence, o regex) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.k(charSequence);
    }

    public static final void M4(int i7) {
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i7).toString());
    }

    @a7.d
    public static final CharSequence M5(@a7.d CharSequence charSequence, @a7.d char... chars) {
        l0.p(charSequence, "<this>");
        l0.p(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (!kotlin.collections.p.O8(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return "";
    }

    @a7.d
    public static final String N2(@a7.d CharSequence charSequence, @a7.d CharSequence other, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        int i7 = 0;
        while (i7 < iMin && kotlin.text.e.J(charSequence.charAt(i7), other.charAt(i7), z7)) {
            i7++;
        }
        int i8 = i7 - 1;
        if (j3(charSequence, i8) || j3(other, i8)) {
            i7--;
        }
        return charSequence.subSequence(0, i7).toString();
    }

    @kotlin.internal.f
    private static final String N3(String str) {
        return str == null ? "" : str;
    }

    @kotlin.internal.f
    private static final List<String> N4(CharSequence charSequence, o regex, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.p(charSequence, i7);
    }

    @kotlin.internal.f
    private static final String N5(String str) {
        l0.p(str, "<this>");
        return K5(str).toString();
    }

    public static /* synthetic */ String O2(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return N2(charSequence, charSequence2, z7);
    }

    @a7.d
    public static final CharSequence O3(@a7.d CharSequence charSequence, int i7, char c8) {
        l0.p(charSequence, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException("Desired length " + i7 + " is less than zero.");
        }
        if (i7 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i7);
        sb.append(charSequence);
        kotlin.collections.u0 it = new kotlin.ranges.k(1, i7 - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(c8);
        }
        return sb;
    }

    @a7.d
    public static final List<String> O4(@a7.d CharSequence charSequence, @a7.d char[] delimiters, boolean z7, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return Q4(charSequence, String.valueOf(delimiters[0]), z7, i7);
        }
        Iterable iterableN = kotlin.sequences.u.N(Y3(charSequence, delimiters, 0, z7, i7, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.z.Z(iterableN, 10));
        Iterator it = iterableN.iterator();
        while (it.hasNext()) {
            arrayList.add(j5(charSequence, (kotlin.ranges.k) it.next()));
        }
        return arrayList;
    }

    @a7.d
    public static final String O5(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i7 = length - 1;
            if (!predicate.z(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i7 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i7;
        }
        return charSequenceSubSequence.toString();
    }

    @a7.d
    public static final String P2(@a7.d CharSequence charSequence, @a7.d CharSequence other, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        int length = charSequence.length();
        int length2 = other.length();
        int iMin = Math.min(length, length2);
        int i7 = 0;
        while (i7 < iMin && kotlin.text.e.J(charSequence.charAt((length - i7) - 1), other.charAt((length2 - i7) - 1), z7)) {
            i7++;
        }
        if (j3(charSequence, (length - i7) - 1) || j3(other, (length2 - i7) - 1)) {
            i7--;
        }
        return charSequence.subSequence(length - i7, length).toString();
    }

    @a7.d
    public static final String P3(@a7.d String str, int i7, char c8) {
        l0.p(str, "<this>");
        return O3(str, i7, c8).toString();
    }

    @a7.d
    public static final List<String> P4(@a7.d CharSequence charSequence, @a7.d String[] delimiters, boolean z7, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return Q4(charSequence, str, z7, i7);
            }
        }
        Iterable iterableN = kotlin.sequences.u.N(Z3(charSequence, delimiters, 0, z7, i7, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.z.Z(iterableN, 10));
        Iterator it = iterableN.iterator();
        while (it.hasNext()) {
            arrayList.add(j5(charSequence, (kotlin.ranges.k) it.next()));
        }
        return arrayList;
    }

    @a7.d
    public static final String P5(@a7.d String str, @a7.d char... chars) {
        CharSequence charSequenceSubSequence;
        l0.p(str, "<this>");
        l0.p(chars, "chars");
        int length = str.length() - 1;
        if (length < 0) {
            charSequenceSubSequence = "";
            break;
        }
        while (true) {
            int i7 = length - 1;
            if (!kotlin.collections.p.O8(chars, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
            if (i7 < 0) {
                charSequenceSubSequence = "";
                break;
            }
            length = i7;
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ String Q2(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return P2(charSequence, charSequence2, z7);
    }

    public static /* synthetic */ CharSequence Q3(CharSequence charSequence, int i7, char c8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c8 = ' ';
        }
        return O3(charSequence, i7, c8);
    }

    private static final List<String> Q4(CharSequence charSequence, String str, boolean z7, int i7) {
        M4(i7);
        int length = 0;
        int iN3 = n3(charSequence, str, 0, z7);
        if (iN3 == -1 || i7 == 1) {
            return kotlin.collections.x.l(charSequence.toString());
        }
        boolean z8 = i7 > 0;
        ArrayList arrayList = new ArrayList(z8 ? kotlin.ranges.q.u(i7, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iN3).toString());
            length = str.length() + iN3;
            if (z8 && arrayList.size() == i7 - 1) {
                break;
            }
            iN3 = n3(charSequence, str, length, z7);
        } while (iN3 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    @a7.d
    public static final CharSequence Q5(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!kotlin.text.d.r(charSequence.charAt(i7))) {
                return charSequence.subSequence(i7, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean R2(@a7.d CharSequence charSequence, char c8, boolean z7) {
        l0.p(charSequence, "<this>");
        return q3(charSequence, c8, 0, z7, 2, null) >= 0;
    }

    public static /* synthetic */ String R3(String str, int i7, char c8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c8 = ' ';
        }
        return P3(str, i7, c8);
    }

    static /* synthetic */ List R4(CharSequence charSequence, o regex, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.p(charSequence, i7);
    }

    @a7.d
    public static final CharSequence R5(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return charSequence.subSequence(i7, charSequence.length());
            }
        }
        return "";
    }

    public static final boolean S2(@a7.d CharSequence charSequence, @a7.d CharSequence other, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        if (other instanceof String) {
            if (r3(charSequence, (String) other, 0, z7, 2, null) >= 0) {
                return true;
            }
        } else if (p3(charSequence, other, 0, charSequence.length(), z7, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @a7.d
    public static final CharSequence S3(@a7.d CharSequence charSequence, int i7, char c8) {
        l0.p(charSequence, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException("Desired length " + i7 + " is less than zero.");
        }
        if (i7 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i7);
        kotlin.collections.u0 it = new kotlin.ranges.k(1, i7 - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.b();
            sb.append(c8);
        }
        sb.append(charSequence);
        return sb;
    }

    public static /* synthetic */ List S4(CharSequence charSequence, char[] cArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return O4(charSequence, cArr, z7, i7);
    }

    @a7.d
    public static final CharSequence S5(@a7.d CharSequence charSequence, @a7.d char... chars) {
        l0.p(charSequence, "<this>");
        l0.p(chars, "chars");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!kotlin.collections.p.O8(chars, charSequence.charAt(i7))) {
                return charSequence.subSequence(i7, charSequence.length());
            }
        }
        return "";
    }

    @kotlin.internal.f
    private static final boolean T2(CharSequence charSequence, o regex) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.b(charSequence);
    }

    @a7.d
    public static String T3(@a7.d String str, int i7, char c8) {
        l0.p(str, "<this>");
        return S3(str, i7, c8).toString();
    }

    public static /* synthetic */ List T4(CharSequence charSequence, String[] strArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return P4(charSequence, strArr, z7, i7);
    }

    @kotlin.internal.f
    private static final String T5(String str) {
        l0.p(str, "<this>");
        return Q5(str).toString();
    }

    public static /* synthetic */ boolean U2(CharSequence charSequence, char c8, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return R2(charSequence, c8, z7);
    }

    public static /* synthetic */ CharSequence U3(CharSequence charSequence, int i7, char c8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c8 = ' ';
        }
        return S3(charSequence, i7, c8);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final kotlin.sequences.m<String> U4(CharSequence charSequence, o regex, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.r(charSequence, i7);
    }

    @a7.d
    public static final String U5(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        CharSequence charSequenceSubSequence;
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!predicate.z(Character.valueOf(str.charAt(i7))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i7, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean V2(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return S2(charSequence, charSequence2, z7);
    }

    public static /* synthetic */ String V3(String str, int i7, char c8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c8 = ' ';
        }
        return T3(str, i7, c8);
    }

    @a7.d
    public static final kotlin.sequences.m<String> V4(@a7.d CharSequence charSequence, @a7.d char[] delimiters, boolean z7, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(delimiters, "delimiters");
        return kotlin.sequences.u.k1(Y3(charSequence, delimiters, 0, z7, i7, 2, null), new e(charSequence));
    }

    @a7.d
    public static final String V5(@a7.d String str, @a7.d char... chars) {
        CharSequence charSequenceSubSequence;
        l0.p(str, "<this>");
        l0.p(chars, "chars");
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!kotlin.collections.p.O8(chars, str.charAt(i7))) {
                charSequenceSubSequence = str.subSequence(i7, str.length());
                return charSequenceSubSequence.toString();
            }
        }
        charSequenceSubSequence = "";
        return charSequenceSubSequence.toString();
    }

    public static final boolean W2(@a7.e CharSequence charSequence, @a7.e CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return b0.K1((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!kotlin.text.e.J(charSequence.charAt(i7), charSequence2.charAt(i7), true)) {
                return false;
            }
        }
        return true;
    }

    private static final kotlin.sequences.m<kotlin.ranges.k> W3(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8) {
        M4(i8);
        return new h(charSequence, i7, i8, new b(cArr, z7));
    }

    @a7.d
    public static final kotlin.sequences.m<String> W4(@a7.d CharSequence charSequence, @a7.d String[] delimiters, boolean z7, int i7) {
        l0.p(charSequence, "<this>");
        l0.p(delimiters, "delimiters");
        return kotlin.sequences.u.k1(Z3(charSequence, delimiters, 0, z7, i7, 2, null), new d(charSequence));
    }

    public static final boolean X2(@a7.e CharSequence charSequence, @a7.e CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return l0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (charSequence.charAt(i7) != charSequence2.charAt(i7)) {
                return false;
            }
        }
        return true;
    }

    private static final kotlin.sequences.m<kotlin.ranges.k> X3(CharSequence charSequence, String[] strArr, int i7, boolean z7, int i8) {
        M4(i8);
        return new h(charSequence, i7, i8, new c(kotlin.collections.o.t(strArr), z7));
    }

    static /* synthetic */ kotlin.sequences.m X4(CharSequence charSequence, o regex, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        return regex.r(charSequence, i7);
    }

    public static final boolean Y2(@a7.d CharSequence charSequence, char c8, boolean z7) {
        l0.p(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.e.J(charSequence.charAt(i3(charSequence)), c8, z7);
    }

    static /* synthetic */ kotlin.sequences.m Y3(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        return W3(charSequence, cArr, i7, z7, i8);
    }

    public static /* synthetic */ kotlin.sequences.m Y4(CharSequence charSequence, char[] cArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return V4(charSequence, cArr, z7, i7);
    }

    public static final boolean Z2(@a7.d CharSequence charSequence, @a7.d CharSequence suffix, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(suffix, "suffix");
        return (!z7 && (charSequence instanceof String) && (suffix instanceof String)) ? b0.J1((String) charSequence, (String) suffix, false, 2, null) : a4(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z7);
    }

    static /* synthetic */ kotlin.sequences.m Z3(CharSequence charSequence, String[] strArr, int i7, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        return X3(charSequence, strArr, i7, z7, i8);
    }

    public static /* synthetic */ kotlin.sequences.m Z4(CharSequence charSequence, String[] strArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return W4(charSequence, strArr, z7, i7);
    }

    public static /* synthetic */ boolean a3(CharSequence charSequence, char c8, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return Y2(charSequence, c8, z7);
    }

    public static final boolean a4(@a7.d CharSequence charSequence, int i7, @a7.d CharSequence other, int i8, int i9, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        if (i8 < 0 || i7 < 0 || i7 > charSequence.length() - i9 || i8 > other.length() - i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!kotlin.text.e.J(charSequence.charAt(i7 + i10), other.charAt(i8 + i10), z7)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a5(@a7.d CharSequence charSequence, char c8, boolean z7) {
        l0.p(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.e.J(charSequence.charAt(0), c8, z7);
    }

    public static /* synthetic */ boolean b3(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return Z2(charSequence, charSequence2, z7);
    }

    @a7.d
    public static final CharSequence b4(@a7.d CharSequence charSequence, @a7.d CharSequence prefix) {
        l0.p(charSequence, "<this>");
        l0.p(prefix, "prefix");
        return f5(charSequence, prefix, false, 2, null) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean b5(@a7.d CharSequence charSequence, @a7.d CharSequence prefix, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(prefix, "prefix");
        return (!z7 && (charSequence instanceof String) && (prefix instanceof String)) ? b0.t2((String) charSequence, (String) prefix, i7, false, 4, null) : a4(charSequence, i7, prefix, 0, prefix.length(), z7);
    }

    @a7.e
    public static final u0<Integer, String> c3(@a7.d CharSequence charSequence, @a7.d Collection<String> strings, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(strings, "strings");
        return d3(charSequence, strings, i7, z7, false);
    }

    @a7.d
    public static String c4(@a7.d String str, @a7.d CharSequence prefix) {
        l0.p(str, "<this>");
        l0.p(prefix, "prefix");
        if (!f5(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final boolean c5(@a7.d CharSequence charSequence, @a7.d CharSequence prefix, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(prefix, "prefix");
        return (!z7 && (charSequence instanceof String) && (prefix instanceof String)) ? b0.u2((String) charSequence, (String) prefix, false, 2, null) : a4(charSequence, 0, prefix, 0, prefix.length(), z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u0<Integer, String> d3(CharSequence charSequence, Collection<String> collection, int i7, boolean z7, boolean z8) {
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z7 && collection.size() == 1) {
            String str3 = (String) kotlin.collections.g0.a5(collection);
            int iR3 = !z8 ? r3(charSequence, str3, i7, false, 4, null) : F3(charSequence, str3, i7, false, 4, null);
            if (iR3 < 0) {
                return null;
            }
            return p1.a(Integer.valueOf(iR3), str3);
        }
        kotlin.ranges.i kVar = !z8 ? new kotlin.ranges.k(kotlin.ranges.q.n(i7, 0), charSequence.length()) : kotlin.ranges.q.W(kotlin.ranges.q.u(i7, i3(charSequence)), 0);
        if (charSequence instanceof String) {
            int iG = kVar.g();
            int iH = kVar.h();
            int iJ = kVar.j();
            if ((iJ > 0 && iG <= iH) || (iJ < 0 && iH <= iG)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str2 = (String) next2;
                    } while (!b0.d2(str2, 0, (String) charSequence, iG, str2.length(), z7));
                    String str4 = (String) next2;
                    if (str4 != null) {
                        return p1.a(Integer.valueOf(iG), str4);
                    }
                    if (iG != iH) {
                        iG += iJ;
                    }
                }
            }
        } else {
            int iG2 = kVar.g();
            int iH2 = kVar.h();
            int iJ2 = kVar.j();
            if ((iJ2 > 0 && iG2 <= iH2) || (iJ2 < 0 && iH2 <= iG2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        str = (String) next;
                    } while (!a4(str, 0, charSequence, iG2, str.length(), z7));
                    String str5 = (String) next;
                    if (str5 != null) {
                        return p1.a(Integer.valueOf(iG2), str5);
                    }
                    if (iG2 != iH2) {
                        iG2 += iJ2;
                    }
                }
            }
        }
        return null;
    }

    @a7.d
    public static final CharSequence d4(@a7.d CharSequence charSequence, int i7, int i8) {
        l0.p(charSequence, "<this>");
        if (i8 < i7) {
            throw new IndexOutOfBoundsException("End index (" + i8 + ") is less than start index (" + i7 + ").");
        }
        if (i8 == i7) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i8 - i7));
        sb.append(charSequence, 0, i7);
        l0.o(sb, "this.append(value, startIndex, endIndex)");
        sb.append(charSequence, i8, charSequence.length());
        l0.o(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    public static /* synthetic */ boolean d5(CharSequence charSequence, char c8, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return a5(charSequence, c8, z7);
    }

    public static /* synthetic */ u0 e3(CharSequence charSequence, Collection collection, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return c3(charSequence, collection, i7, z7);
    }

    @a7.d
    public static final CharSequence e4(@a7.d CharSequence charSequence, @a7.d kotlin.ranges.k range) {
        l0.p(charSequence, "<this>");
        l0.p(range, "range");
        return d4(charSequence, range.d().intValue(), range.f().intValue() + 1);
    }

    public static /* synthetic */ boolean e5(CharSequence charSequence, CharSequence charSequence2, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return b5(charSequence, charSequence2, i7, z7);
    }

    @a7.e
    public static final u0<Integer, String> f3(@a7.d CharSequence charSequence, @a7.d Collection<String> strings, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(strings, "strings");
        return d3(charSequence, strings, i7, z7, true);
    }

    @kotlin.internal.f
    private static final String f4(String str, int i7, int i8) {
        l0.p(str, "<this>");
        return d4(str, i7, i8).toString();
    }

    public static /* synthetic */ boolean f5(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return c5(charSequence, charSequence2, z7);
    }

    public static /* synthetic */ u0 g3(CharSequence charSequence, Collection collection, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = i3(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return f3(charSequence, collection, i7, z7);
    }

    @kotlin.internal.f
    private static final String g4(String str, kotlin.ranges.k range) {
        l0.p(str, "<this>");
        l0.p(range, "range");
        return e4(str, range).toString();
    }

    @a7.d
    public static final CharSequence g5(@a7.d CharSequence charSequence, @a7.d kotlin.ranges.k range) {
        l0.p(charSequence, "<this>");
        l0.p(range, "range");
        return charSequence.subSequence(range.d().intValue(), range.f().intValue() + 1);
    }

    @a7.d
    public static final kotlin.ranges.k h3(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return new kotlin.ranges.k(0, charSequence.length() - 1);
    }

    @a7.d
    public static final CharSequence h4(@a7.d CharSequence charSequence, @a7.d CharSequence suffix) {
        l0.p(charSequence, "<this>");
        l0.p(suffix, "suffix");
        return b3(charSequence, suffix, false, 2, null) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @kotlin.k(message = "Use parameters named startIndex and endIndex.", replaceWith = @b1(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @kotlin.internal.f
    private static final CharSequence h5(String str, int i7, int i8) {
        l0.p(str, "<this>");
        return str.subSequence(i7, i8);
    }

    public static int i3(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    @a7.d
    public static String i4(@a7.d String str, @a7.d CharSequence suffix) {
        l0.p(str, "<this>");
        l0.p(suffix, "suffix");
        if (!b3(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @kotlin.internal.f
    private static final String i5(CharSequence charSequence, int i7, int i8) {
        l0.p(charSequence, "<this>");
        return charSequence.subSequence(i7, i8).toString();
    }

    public static final boolean j3(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        return new kotlin.ranges.k(0, charSequence.length() + (-2)).m(i7) && Character.isHighSurrogate(charSequence.charAt(i7)) && Character.isLowSurrogate(charSequence.charAt(i7 + 1));
    }

    @a7.d
    public static final CharSequence j4(@a7.d CharSequence charSequence, @a7.d CharSequence delimiter) {
        l0.p(charSequence, "<this>");
        l0.p(delimiter, "delimiter");
        return k4(charSequence, delimiter, delimiter);
    }

    @a7.d
    public static final String j5(@a7.d CharSequence charSequence, @a7.d kotlin.ranges.k range) {
        l0.p(charSequence, "<this>");
        l0.p(range, "range");
        return charSequence.subSequence(range.d().intValue(), range.f().intValue() + 1).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <C extends CharSequence & R, R> R k3(C c8, i5.a<? extends R> defaultValue) {
        l0.p(defaultValue, "defaultValue");
        return b0.U1(c8) ? defaultValue.invoke() : c8;
    }

    @a7.d
    public static final CharSequence k4(@a7.d CharSequence charSequence, @a7.d CharSequence prefix, @a7.d CharSequence suffix) {
        l0.p(charSequence, "<this>");
        l0.p(prefix, "prefix");
        l0.p(suffix, "suffix");
        return (charSequence.length() >= prefix.length() + suffix.length() && f5(charSequence, prefix, false, 2, null) && b3(charSequence, suffix, false, 2, null)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @a7.d
    public static final String k5(@a7.d String str, @a7.d kotlin.ranges.k range) {
        l0.p(str, "<this>");
        l0.p(range, "range");
        String strSubstring = str.substring(range.d().intValue(), range.f().intValue() + 1);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <C extends CharSequence & R, R> R l3(C c8, i5.a<? extends R> defaultValue) {
        l0.p(defaultValue, "defaultValue");
        return c8.length() == 0 ? defaultValue.invoke() : c8;
    }

    @a7.d
    public static String l4(@a7.d String str, @a7.d CharSequence delimiter) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        return m4(str, delimiter, delimiter);
    }

    static /* synthetic */ String l5(CharSequence charSequence, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = charSequence.length();
        }
        l0.p(charSequence, "<this>");
        return charSequence.subSequence(i7, i8).toString();
    }

    public static final int m3(@a7.d CharSequence charSequence, char c8, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? t3(charSequence, new char[]{c8}, i7, z7) : ((String) charSequence).indexOf(c8, i7);
    }

    @a7.d
    public static final String m4(@a7.d String str, @a7.d CharSequence prefix, @a7.d CharSequence suffix) {
        l0.p(str, "<this>");
        l0.p(prefix, "prefix");
        l0.p(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !f5(str, prefix, false, 2, null) || !b3(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @a7.d
    public static final String m5(@a7.d String str, char c8, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iQ3 = q3(str, c8, 0, false, 6, null);
        if (iQ3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iQ3 + 1, str.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int n3(@a7.d CharSequence charSequence, @a7.d String string, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(string, "string");
        return (z7 || !(charSequence instanceof String)) ? p3(charSequence, string, i7, charSequence.length(), z7, false, 16, null) : ((String) charSequence).indexOf(string, i7);
    }

    @kotlin.internal.f
    private static final String n4(CharSequence charSequence, o regex, i5.l<? super m, ? extends CharSequence> transform) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        l0.p(transform, "transform");
        return regex.m(charSequence, transform);
    }

    @a7.d
    public static final String n5(@a7.d String str, @a7.d String delimiter, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, delimiter, 0, false, 6, null);
        if (iR3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iR3 + delimiter.length(), str.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    private static final int o3(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8) {
        kotlin.ranges.i kVar = !z8 ? new kotlin.ranges.k(kotlin.ranges.q.n(i7, 0), kotlin.ranges.q.u(i8, charSequence.length())) : kotlin.ranges.q.W(kotlin.ranges.q.u(i7, i3(charSequence)), kotlin.ranges.q.n(i8, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iG = kVar.g();
            int iH = kVar.h();
            int iJ = kVar.j();
            if ((iJ <= 0 || iG > iH) && (iJ >= 0 || iH > iG)) {
                return -1;
            }
            while (!b0.d2((String) charSequence2, 0, (String) charSequence, iG, charSequence2.length(), z7)) {
                if (iG == iH) {
                    return -1;
                }
                iG += iJ;
            }
            return iG;
        }
        int iG2 = kVar.g();
        int iH2 = kVar.h();
        int iJ2 = kVar.j();
        if ((iJ2 <= 0 || iG2 > iH2) && (iJ2 >= 0 || iH2 > iG2)) {
            return -1;
        }
        while (!a4(charSequence2, 0, charSequence, iG2, charSequence2.length(), z7)) {
            if (iG2 == iH2) {
                return -1;
            }
            iG2 += iJ2;
        }
        return iG2;
    }

    @kotlin.internal.f
    private static final String o4(CharSequence charSequence, o regex, String replacement) {
        l0.p(charSequence, "<this>");
        l0.p(regex, "regex");
        l0.p(replacement, "replacement");
        return regex.n(charSequence, replacement);
    }

    public static /* synthetic */ String o5(String str, char c8, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return m5(str, c8, str2);
    }

    static /* synthetic */ int p3(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8, int i9, Object obj) {
        if ((i9 & 16) != 0) {
            z8 = false;
        }
        return o3(charSequence, charSequence2, i7, i8, z7, z8);
    }

    @a7.d
    public static final String p4(@a7.d String str, char c8, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iQ3 = q3(str, c8, 0, false, 6, null);
        return iQ3 == -1 ? missingDelimiterValue : I4(str, iQ3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String p5(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return n5(str, str2, str3);
    }

    public static /* synthetic */ int q3(CharSequence charSequence, char c8, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return m3(charSequence, c8, i7, z7);
    }

    @a7.d
    public static final String q4(@a7.d String str, @a7.d String delimiter, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, delimiter, 0, false, 6, null);
        return iR3 == -1 ? missingDelimiterValue : I4(str, iR3 + delimiter.length(), str.length(), replacement).toString();
    }

    @a7.d
    public static String q5(@a7.d String str, char c8, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iE3 = E3(str, c8, 0, false, 6, null);
        if (iE3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iE3 + 1, str.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ int r3(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return n3(charSequence, str, i7, z7);
    }

    public static /* synthetic */ String r4(String str, char c8, String str2, String str3, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str3 = str;
        }
        return p4(str, c8, str2, str3);
    }

    @a7.d
    public static final String r5(@a7.d String str, @a7.d String delimiter, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, delimiter, 0, false, 6, null);
        if (iF3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iF3 + delimiter.length(), str.length());
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int s3(@a7.d CharSequence charSequence, @a7.d Collection<String> strings, int i7, boolean z7) {
        l0.p(charSequence, "<this>");
        l0.p(strings, "strings");
        u0<Integer, String> u0VarD3 = d3(charSequence, strings, i7, z7, false);
        if (u0VarD3 != null) {
            return u0VarD3.e().intValue();
        }
        return -1;
    }

    public static /* synthetic */ String s4(String str, String str2, String str3, String str4, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str4 = str;
        }
        return q4(str, str2, str3, str4);
    }

    public static /* synthetic */ String s5(String str, char c8, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return q5(str, c8, str2);
    }

    public static final int t3(@a7.d CharSequence charSequence, @a7.d char[] chars, int i7, boolean z7) {
        boolean z8;
        l0.p(charSequence, "<this>");
        l0.p(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.p.xt(chars), i7);
        }
        kotlin.collections.u0 it = new kotlin.ranges.k(kotlin.ranges.q.n(i7, 0), i3(charSequence)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            char cCharAt = charSequence.charAt(iB);
            int length = chars.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    z8 = false;
                    break;
                }
                if (kotlin.text.e.J(chars[i8], cCharAt, z7)) {
                    z8 = true;
                    break;
                }
                i8++;
            }
            if (z8) {
                return iB;
            }
        }
        return -1;
    }

    @a7.d
    public static final String t4(@a7.d String str, char c8, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iE3 = E3(str, c8, 0, false, 6, null);
        return iE3 == -1 ? missingDelimiterValue : I4(str, iE3 + 1, str.length(), replacement).toString();
    }

    public static /* synthetic */ String t5(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return r5(str, str2, str3);
    }

    public static /* synthetic */ int u3(CharSequence charSequence, Collection collection, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return s3(charSequence, collection, i7, z7);
    }

    @a7.d
    public static final String u4(@a7.d String str, @a7.d String delimiter, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, delimiter, 0, false, 6, null);
        return iF3 == -1 ? missingDelimiterValue : I4(str, iF3 + delimiter.length(), str.length(), replacement).toString();
    }

    @a7.d
    public static final String u5(@a7.d String str, char c8, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iQ3 = q3(str, c8, 0, false, 6, null);
        if (iQ3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iQ3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ int v3(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return t3(charSequence, cArr, i7, z7);
    }

    public static /* synthetic */ String v4(String str, char c8, String str2, String str3, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str3 = str;
        }
        return t4(str, c8, str2, str3);
    }

    @a7.d
    public static final String v5(@a7.d String str, @a7.d String delimiter, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, delimiter, 0, false, 6, null);
        if (iR3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iR3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @kotlin.internal.f
    private static final boolean w3(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String w4(String str, String str2, String str3, String str4, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str4 = str;
        }
        return u4(str, str2, str3, str4);
    }

    public static /* synthetic */ String w5(String str, char c8, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return u5(str, c8, str2);
    }

    @kotlin.internal.f
    private static final boolean x3(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return !b0.U1(charSequence);
    }

    @a7.d
    public static final String x4(@a7.d String str, char c8, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iQ3 = q3(str, c8, 0, false, 6, null);
        return iQ3 == -1 ? missingDelimiterValue : I4(str, 0, iQ3, replacement).toString();
    }

    public static /* synthetic */ String x5(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return v5(str, str2, str3);
    }

    @kotlin.internal.f
    private static final boolean y3(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return charSequence.length() > 0;
    }

    @a7.d
    public static final String y4(@a7.d String str, @a7.d String delimiter, @a7.d String replacement, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(replacement, "replacement");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iR3 = r3(str, delimiter, 0, false, 6, null);
        return iR3 == -1 ? missingDelimiterValue : I4(str, 0, iR3, replacement).toString();
    }

    @a7.d
    public static final String y5(@a7.d String str, char c8, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iE3 = E3(str, c8, 0, false, 6, null);
        if (iE3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iE3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @kotlin.internal.f
    private static final boolean z3(CharSequence charSequence) {
        return charSequence == null || b0.U1(charSequence);
    }

    public static /* synthetic */ String z4(String str, char c8, String str2, String str3, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            str3 = str;
        }
        return x4(str, c8, str2, str3);
    }

    @a7.d
    public static final String z5(@a7.d String str, @a7.d String delimiter, @a7.d String missingDelimiterValue) {
        l0.p(str, "<this>");
        l0.p(delimiter, "delimiter");
        l0.p(missingDelimiterValue, "missingDelimiterValue");
        int iF3 = F3(str, delimiter, 0, false, 6, null);
        if (iF3 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iF3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
