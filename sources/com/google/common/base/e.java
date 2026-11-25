package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public abstract class e implements g0<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19340a = 65536;

    class a extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19341c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e eVar, String str) {
            super(eVar);
            this.f19341c = str;
        }

        @Override // com.google.common.base.e.w, com.google.common.base.e
        public String toString() {
            return this.f19341c;
        }
    }

    private static class a0 extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char[] f19344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final char[] f19345d;

        a0(String str, char[] cArr, char[] cArr2) {
            this.f19343b = str;
            this.f19344c = cArr;
            this.f19345d = cArr2;
            e0.d(cArr.length == cArr2.length);
            int i7 = 0;
            while (i7 < cArr.length) {
                e0.d(cArr[i7] <= cArr2[i7]);
                int i8 = i7 + 1;
                if (i8 < cArr.length) {
                    e0.d(cArr2[i7] < cArr[i8]);
                }
                i7 = i8;
            }
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            int iBinarySearch = Arrays.binarySearch(this.f19344c, c8);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i7 = (~iBinarySearch) - 1;
            return i7 >= 0 && c8 <= this.f19345d[i7];
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return this.f19343b;
        }
    }

    private static final class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e f19346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e f19347c;

        b(e eVar, e eVar2) {
            this.f19346b = (e) e0.E(eVar);
            this.f19347c = (e) e0.E(eVar2);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return this.f19346b.B(c8) && this.f19347c.B(c8);
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f19346b.Q(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f19347c.Q(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.and(" + this.f19346b + ", " + this.f19347c + ")";
        }
    }

    private static final class b0 extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final b0 f19348e = new b0();

        private b0() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    private static final class c extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f19349c = new c();

        private c() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.e
        public int A(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return true;
        }

        @Override // com.google.common.base.e
        public boolean C(CharSequence charSequence) {
            e0.E(charSequence);
            return true;
        }

        @Override // com.google.common.base.e
        public boolean E(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.e.i, com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public e negate() {
            return e.G();
        }

        @Override // com.google.common.base.e
        public e I(e eVar) {
            e0.E(eVar);
            return this;
        }

        @Override // com.google.common.base.e
        public String M(CharSequence charSequence) {
            e0.E(charSequence);
            return "";
        }

        @Override // com.google.common.base.e
        public String N(CharSequence charSequence, char c8) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c8);
            return new String(cArr);
        }

        @Override // com.google.common.base.e
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i7 = 0; i7 < charSequence.length(); i7++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        @Override // com.google.common.base.e
        public String U(CharSequence charSequence) {
            e0.E(charSequence);
            return "";
        }

        @Override // com.google.common.base.e
        public e b(e eVar) {
            return (e) e0.E(eVar);
        }

        @Override // com.google.common.base.e
        public String h(CharSequence charSequence, char c8) {
            return charSequence.length() == 0 ? "" : String.valueOf(c8);
        }

        @Override // com.google.common.base.e
        public int i(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.e
        public int n(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.e
        public int o(CharSequence charSequence, int i7) {
            int length = charSequence.length();
            e0.d0(i7, length);
            if (i7 == length) {
                return -1;
            }
            return i7;
        }
    }

    @s1.d
    static final class c0 extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final String f19350c = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f19351d = 1682554634;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f19352e = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final c0 f19353f = new c0();

        c0() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return f19350c.charAt((f19351d * c8) >>> f19352e) == c8;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            for (int i7 = 0; i7 < 32; i7++) {
                bitSet.set(f19350c.charAt(i7));
            }
        }
    }

    private static final class d extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f19354b;

        public d(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f19354b = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Arrays.binarySearch(this.f19354b, c8) >= 0;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            for (char c8 : this.f19354b) {
                bitSet.set(c8);
            }
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c8 : this.f19354b) {
                sb.append(e.R(c8));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.e$e, reason: collision with other inner class name */
    private static final class C0224e extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final C0224e f19355c = new C0224e();

        C0224e() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return c8 <= 127;
        }
    }

    @s1.c
    private static final class f extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BitSet f19356c;

        /* synthetic */ f(BitSet bitSet, String str, a aVar) {
            this(bitSet, str);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return this.f19356c.get(c8);
        }

        @Override // com.google.common.base.e
        void Q(BitSet bitSet) {
            bitSet.or(this.f19356c);
        }

        private f(BitSet bitSet, String str) {
            super(str);
            this.f19356c = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    private static final class g extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final e f19357b = new g();

        private g() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            if (c8 != ' ' && c8 != 133 && c8 != 5760) {
                if (c8 == 8199) {
                    return false;
                }
                if (c8 != 8287 && c8 != 12288 && c8 != 8232 && c8 != 8233) {
                    switch (c8) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c8 >= 8192 && c8 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    private static final class h extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f19358e = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final h f19359f = new h();

        private h() {
            super("CharMatcher.digit()", Z(), Y());
        }

        private static char[] Y() {
            char[] cArr = new char[37];
            for (int i7 = 0; i7 < 37; i7++) {
                cArr[i7] = (char) (f19358e.charAt(i7) + '\t');
            }
            return cArr;
        }

        private static char[] Z() {
            return f19358e.toCharArray();
        }
    }

    static abstract class i extends e {
        i() {
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F */
        public e negate() {
            return new x(this);
        }

        @Override // com.google.common.base.e
        public final e J() {
            return this;
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }
    }

    private static final class j extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g0<? super Character> f19360b;

        j(g0<? super Character> g0Var) {
            this.f19360b = (g0) e0.E(g0Var);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return this.f19360b.apply(Character.valueOf(c8));
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean apply(Character ch) {
            return this.f19360b.apply(e0.E(ch));
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f19360b + ")";
        }
    }

    private static final class k extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f19361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char f19362c;

        k(char c8, char c9) {
            e0.d(c9 >= c8);
            this.f19361b = c8;
            this.f19362c = c9;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return this.f19361b <= c8 && c8 <= this.f19362c;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            bitSet.set(this.f19361b, this.f19362c + 1);
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.inRange('" + e.R(this.f19361b) + "', '" + e.R(this.f19362c) + "')";
        }
    }

    private static final class l extends a0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f19363e = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f19364f = "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final l f19365g = new l();

        private l() {
            super("CharMatcher.invisible()", f19363e.toCharArray(), f19364f.toCharArray());
        }
    }

    private static final class m extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f19366b;

        m(char c8) {
            this.f19366b = c8;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return c8 == this.f19366b;
        }

        @Override // com.google.common.base.e.i, com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F */
        public e negate() {
            return e.s(this.f19366b);
        }

        @Override // com.google.common.base.e
        public e I(e eVar) {
            return eVar.B(this.f19366b) ? eVar : super.I(eVar);
        }

        @Override // com.google.common.base.e
        public String N(CharSequence charSequence, char c8) {
            return charSequence.toString().replace(this.f19366b, c8);
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            bitSet.set(this.f19366b);
        }

        @Override // com.google.common.base.e
        public e b(e eVar) {
            return eVar.B(this.f19366b) ? this : e.G();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.is('" + e.R(this.f19366b) + "')";
        }
    }

    private static final class n extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f19367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char f19368c;

        n(char c8, char c9) {
            this.f19367b = c8;
            this.f19368c = c9;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return c8 == this.f19367b || c8 == this.f19368c;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            bitSet.set(this.f19367b);
            bitSet.set(this.f19368c);
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.anyOf(\"" + e.R(this.f19367b) + e.R(this.f19368c) + "\")";
        }
    }

    private static final class o extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f19369b;

        o(char c8) {
            this.f19369b = c8;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return c8 != this.f19369b;
        }

        @Override // com.google.common.base.e.i, com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F */
        public e negate() {
            return e.q(this.f19369b);
        }

        @Override // com.google.common.base.e
        public e I(e eVar) {
            return eVar.B(this.f19369b) ? e.c() : this;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            bitSet.set(0, this.f19369b);
            bitSet.set(this.f19369b + 1, 65536);
        }

        @Override // com.google.common.base.e
        public e b(e eVar) {
            return eVar.B(this.f19369b) ? super.b(eVar) : eVar;
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.isNot('" + e.R(this.f19369b) + "')";
        }
    }

    private static final class p extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final p f19370b = new p();

        private p() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Character.isDigit(c8);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    private static final class q extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final q f19371c = new q();

        private q() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return c8 <= 31 || (c8 >= 127 && c8 <= 159);
        }
    }

    private static final class r extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final r f19372b = new r();

        private r() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Character.isLetter(c8);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    private static final class s extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final s f19373b = new s();

        private s() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Character.isLetterOrDigit(c8);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    private static final class t extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final t f19374b = new t();

        private t() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Character.isLowerCase(c8);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    private static final class u extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final u f19375b = new u();

        private u() {
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return Character.isUpperCase(c8);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    static abstract class v extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19376b;

        v(String str) {
            this.f19376b = (String) e0.E(str);
        }

        @Override // com.google.common.base.e
        public final String toString() {
            return this.f19376b;
        }
    }

    private static class w extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e f19377b;

        w(e eVar) {
            this.f19377b = (e) e0.E(eVar);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return !this.f19377b.B(c8);
        }

        @Override // com.google.common.base.e
        public boolean C(CharSequence charSequence) {
            return this.f19377b.E(charSequence);
        }

        @Override // com.google.common.base.e
        public boolean E(CharSequence charSequence) {
            return this.f19377b.C(charSequence);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F */
        public e negate() {
            return this.f19377b;
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f19377b.Q(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e
        public int i(CharSequence charSequence) {
            return charSequence.length() - this.f19377b.i(charSequence);
        }

        @Override // com.google.common.base.e
        public String toString() {
            return this.f19377b + ".negate()";
        }
    }

    static class x extends w {
        x(e eVar) {
            super(eVar);
        }

        @Override // com.google.common.base.e
        public final e J() {
            return this;
        }
    }

    private static final class y extends v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final y f19378c = new y();

        private y() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.e
        public int A(CharSequence charSequence) {
            e0.E(charSequence);
            return -1;
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return false;
        }

        @Override // com.google.common.base.e
        public boolean C(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.e
        public boolean E(CharSequence charSequence) {
            e0.E(charSequence);
            return true;
        }

        @Override // com.google.common.base.e.i, com.google.common.base.e, java.util.function.Predicate
        /* JADX INFO: renamed from: F */
        public e negate() {
            return e.c();
        }

        @Override // com.google.common.base.e
        public e I(e eVar) {
            return (e) e0.E(eVar);
        }

        @Override // com.google.common.base.e
        public String M(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public String N(CharSequence charSequence, char c8) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            e0.E(charSequence2);
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public String U(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public String V(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public String W(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public e b(e eVar) {
            e0.E(eVar);
            return this;
        }

        @Override // com.google.common.base.e
        public String h(CharSequence charSequence, char c8) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.e
        public int i(CharSequence charSequence) {
            e0.E(charSequence);
            return 0;
        }

        @Override // com.google.common.base.e
        public int n(CharSequence charSequence) {
            e0.E(charSequence);
            return -1;
        }

        @Override // com.google.common.base.e
        public int o(CharSequence charSequence, int i7) {
            e0.d0(i7, charSequence.length());
            return -1;
        }
    }

    private static final class z extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e f19379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e f19380c;

        z(e eVar, e eVar2) {
            this.f19379b = (e) e0.E(eVar);
            this.f19380c = (e) e0.E(eVar2);
        }

        @Override // com.google.common.base.e
        public boolean B(char c8) {
            return this.f19379b.B(c8) || this.f19380c.B(c8);
        }

        @Override // com.google.common.base.e
        @s1.c
        void Q(BitSet bitSet) {
            this.f19379b.Q(bitSet);
            this.f19380c.Q(bitSet);
        }

        @Override // com.google.common.base.e, com.google.common.base.g0
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.e, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return super.negate();
        }

        @Override // com.google.common.base.e
        public String toString() {
            return "CharMatcher.or(" + this.f19379b + ", " + this.f19380c + ")";
        }
    }

    protected e() {
    }

    public static e G() {
        return y.f19378c;
    }

    public static e H(CharSequence charSequence) {
        return d(charSequence).negate();
    }

    @s1.c
    private static e L(int i7, BitSet bitSet, String str) {
        if (i7 == 0) {
            return G();
        }
        if (i7 == 1) {
            return q((char) bitSet.nextSetBit(0));
        }
        if (i7 != 2) {
            return t(i7, bitSet.length()) ? j0.a0(bitSet, str) : new f(bitSet, str, null);
        }
        char cNextSetBit = (char) bitSet.nextSetBit(0);
        return r(cNextSetBit, (char) bitSet.nextSetBit(cNextSetBit + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String R(char c8) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i7 = 0; i7 < 4; i7++) {
            cArr[5 - i7] = "0123456789ABCDEF".charAt(c8 & 15);
            c8 = (char) (c8 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static e S() {
        return b0.f19348e;
    }

    public static e X() {
        return c0.f19353f;
    }

    public static e c() {
        return c.f19349c;
    }

    public static e d(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return G();
        }
        if (length != 1) {
            return length != 2 ? new d(charSequence) : r(charSequence.charAt(0), charSequence.charAt(1));
        }
        return q(charSequence.charAt(0));
    }

    public static e f() {
        return C0224e.f19355c;
    }

    public static e g() {
        return g.f19357b;
    }

    @Deprecated
    public static e j() {
        return h.f19359f;
    }

    private String k(CharSequence charSequence, int i7, int i8, char c8, StringBuilder sb, boolean z7) {
        while (i7 < i8) {
            char cCharAt = charSequence.charAt(i7);
            if (!B(cCharAt)) {
                sb.append(cCharAt);
                z7 = false;
            } else if (!z7) {
                sb.append(c8);
                z7 = true;
            }
            i7++;
        }
        return sb.toString();
    }

    public static e l(g0<? super Character> g0Var) {
        return g0Var instanceof e ? (e) g0Var : new j(g0Var);
    }

    public static e m(char c8, char c9) {
        return new k(c8, c9);
    }

    @Deprecated
    public static e p() {
        return l.f19365g;
    }

    public static e q(char c8) {
        return new m(c8);
    }

    private static n r(char c8, char c9) {
        return new n(c8, c9);
    }

    public static e s(char c8) {
        return new o(c8);
    }

    @s1.c
    private static boolean t(int i7, int i8) {
        return i7 <= 1023 && i8 > (i7 * 4) * 16;
    }

    @Deprecated
    public static e u() {
        return p.f19370b;
    }

    public static e v() {
        return q.f19371c;
    }

    @Deprecated
    public static e w() {
        return r.f19372b;
    }

    @Deprecated
    public static e x() {
        return s.f19373b;
    }

    @Deprecated
    public static e y() {
        return t.f19374b;
    }

    @Deprecated
    public static e z() {
        return u.f19375b;
    }

    public int A(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (B(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean B(char c8);

    public boolean C(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean D(CharSequence charSequence) {
        return !E(charSequence);
    }

    public boolean E(CharSequence charSequence) {
        return n(charSequence) == -1;
    }

    @Override // java.util.function.Predicate
    /* JADX INFO: renamed from: F */
    public e negate() {
        return new w(this);
    }

    public e I(e eVar) {
        return new z(this, eVar);
    }

    public e J() {
        return d0.i(this);
    }

    @s1.c
    e K() {
        String strSubstring;
        BitSet bitSet = new BitSet();
        Q(bitSet);
        int iCardinality = bitSet.cardinality();
        if (iCardinality * 2 <= 65536) {
            return L(iCardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i7 = 65536 - iCardinality;
        String string = toString();
        if (string.endsWith(".negate()")) {
            strSubstring = string.substring(0, string.length() - 9);
        } else {
            strSubstring = string + ".negate()";
        }
        return new a(L(i7, bitSet, strSubstring), string);
    }

    public String M(CharSequence charSequence) {
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i7 = 1;
        while (true) {
            iN++;
            while (iN != charArray.length) {
                if (B(charArray[iN])) {
                    i7++;
                } else {
                    charArray[iN - i7] = charArray[iN];
                    iN++;
                }
            }
            return new String(charArray, 0, iN - i7);
        }
    }

    public String N(CharSequence charSequence, char c8) {
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iN] = c8;
        while (true) {
            iN++;
            if (iN >= charArray.length) {
                return new String(charArray);
            }
            if (B(charArray[iN])) {
                charArray[iN] = c8;
            }
        }
    }

    public String O(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return M(charSequence);
        }
        int i7 = 0;
        if (length == 1) {
            return N(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) string, i7, iN);
            sb.append(charSequence2);
            i7 = iN + 1;
            iN = o(string, i7);
        } while (iN != -1);
        sb.append((CharSequence) string, i7, length2);
        return sb.toString();
    }

    public String P(CharSequence charSequence) {
        return negate().M(charSequence);
    }

    @s1.c
    void Q(BitSet bitSet) {
        for (int i7 = 65535; i7 >= 0; i7--) {
            if (B((char) i7)) {
                bitSet.set(i7);
            }
        }
    }

    public String T(CharSequence charSequence, char c8) {
        int length = charSequence.length();
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < length && B(charSequence.charAt(i8))) {
            i8++;
        }
        int i9 = i7;
        while (i9 > i8 && B(charSequence.charAt(i9))) {
            i9--;
        }
        if (i8 == 0 && i9 == i7) {
            return h(charSequence, c8);
        }
        int i10 = i9 + 1;
        return k(charSequence, i8, i10, c8, new StringBuilder(i10 - i8), false);
    }

    public String U(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length && B(charSequence.charAt(i7))) {
            i7++;
        }
        int i8 = length - 1;
        while (i8 > i7 && B(charSequence.charAt(i8))) {
            i8--;
        }
        return charSequence.subSequence(i7, i8 + 1).toString();
    }

    public String V(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!B(charSequence.charAt(i7))) {
                return charSequence.subSequence(i7, length).toString();
            }
        }
        return "";
    }

    public String W(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public e b(e eVar) {
        return new b(this, eVar);
    }

    @Override // com.google.common.base.g0
    @Deprecated
    /* JADX INFO: renamed from: e */
    public boolean apply(Character ch) {
        return B(ch.charValue());
    }

    public String h(CharSequence charSequence, char c8) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (B(cCharAt)) {
                if (cCharAt != c8 || (i7 != length - 1 && B(charSequence.charAt(i7 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i7);
                    sb.append(c8);
                    return k(charSequence, i7 + 1, length, c8, sb, true);
                }
                i7++;
            }
            i7++;
        }
        return charSequence.toString();
    }

    public int i(CharSequence charSequence) {
        int i7 = 0;
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            if (B(charSequence.charAt(i8))) {
                i7++;
            }
        }
        return i7;
    }

    public int n(CharSequence charSequence) {
        return o(charSequence, 0);
    }

    public int o(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        e0.d0(i7, length);
        while (i7 < length) {
            if (B(charSequence.charAt(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @Override // com.google.common.base.g0, java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return f0.a(this, obj);
    }

    public String toString() {
        return super.toString();
    }
}
