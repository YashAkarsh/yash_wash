package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a1;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final a f35411c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Pattern f35412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private Set<? extends q> f35413b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i7) {
            return (i7 & 2) != 0 ? i7 | 64 : i7;
        }

        @a7.d
        public final String c(@a7.d String literal) {
            l0.p(literal, "literal");
            String strQuote = Pattern.quote(literal);
            l0.o(strQuote, "quote(literal)");
            return strQuote;
        }

        @a7.d
        public final String d(@a7.d String literal) {
            l0.p(literal, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(literal);
            l0.o(strQuoteReplacement, "quoteReplacement(literal)");
            return strQuoteReplacement;
        }

        @a7.d
        public final o e(@a7.d String literal) {
            l0.p(literal, "literal");
            return new o(literal, q.f35433e);
        }

        private a() {
        }
    }

    private static final class b implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        public static final a f35414c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f35415d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final String f35416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35417b;

        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
                this();
            }

            private a() {
            }
        }

        public b(@a7.d String pattern, int i7) {
            l0.p(pattern, "pattern");
            this.f35416a = pattern;
            this.f35417b = i7;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.f35416a, this.f35417b);
            l0.o(patternCompile, "compile(pattern, flags)");
            return new o(patternCompile);
        }

        public final int a() {
            return this.f35417b;
        }

        @a7.d
        public final String b() {
            return this.f35416a;
        }
    }

    static final class c extends n0 implements i5.a<m> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f35419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f35420c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i7) {
            super(0);
            this.f35419b = charSequence;
            this.f35420c = i7;
        }

        @Override // i5.a
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m invoke() {
            return o.this.c(this.f35419b, this.f35420c);
        }
    }

    /* synthetic */ class d extends kotlin.jvm.internal.h0 implements i5.l<m, m> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f35421j = new d();

        d() {
            super(1, m.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final m z(@a7.d m p7) {
            l0.p(p7, "p0");
            return p7.next();
        }
    }

    static final class e extends n0 implements i5.l<q, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i7) {
            super(1);
            this.f35422a = i7;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(q qVar) {
            q qVar2 = qVar;
            return Boolean.valueOf((this.f35422a & qVar2.a()) == qVar2.getValue());
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {276, 284, 288}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    static final class f extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super String>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35425e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35426f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ CharSequence f35428h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f35429i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(CharSequence charSequence, int i7, kotlin.coroutines.d<? super f> dVar) {
            super(2, dVar);
            this.f35428h = charSequence;
            this.f35429i = i7;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            f fVar = o.this.new f(this.f35428h, this.f35429i, dVar);
            fVar.f35426f = obj;
            return fVar;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0072 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x007d  */
        /* JADX WARN: Code duplicated, block: B:27:0x009e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            f fVar;
            kotlin.sequences.o oVar;
            Matcher matcher;
            int i7;
            String string;
            String string2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = this.f35425e;
            if (i8 == 0) {
                e1.n(obj);
                kotlin.sequences.o oVar2 = (kotlin.sequences.o) this.f35426f;
                Matcher matcher2 = o.this.f35412a.matcher(this.f35428h);
                if (this.f35429i != 1 && matcher2.find()) {
                    int iEnd = 0;
                    fVar = this;
                    oVar = oVar2;
                    matcher = matcher2;
                    i7 = 0;
                    string = fVar.f35428h.subSequence(iEnd, matcher.start()).toString();
                    fVar.f35426f = oVar;
                    fVar.f35423c = matcher;
                    fVar.f35424d = i7;
                    fVar.f35425e = 2;
                    if (oVar.a(string, fVar) == objH) {
                        return objH;
                    }
                    iEnd = matcher.end();
                    i7++;
                    if (i7 != fVar.f35429i - 1) {
                    }
                    CharSequence charSequence = fVar.f35428h;
                    string2 = charSequence.subSequence(iEnd, charSequence.length()).toString();
                    fVar.f35426f = null;
                    fVar.f35423c = null;
                    fVar.f35425e = 3;
                    if (oVar.a(string2, fVar) == objH) {
                        return objH;
                    }
                    return l2.f34958a;
                }
                String string3 = this.f35428h.toString();
                this.f35425e = 1;
                if (oVar2.a(string3, this) == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    if (i8 == 2) {
                        i7 = this.f35424d;
                        Matcher matcher3 = (Matcher) this.f35423c;
                        oVar = (kotlin.sequences.o) this.f35426f;
                        e1.n(obj);
                        fVar = this;
                        matcher = matcher3;
                        iEnd = matcher.end();
                        i7++;
                        if (i7 != fVar.f35429i - 1 || !matcher.find()) {
                            CharSequence charSequence2 = fVar.f35428h;
                            string2 = charSequence2.subSequence(iEnd, charSequence2.length()).toString();
                            fVar.f35426f = null;
                            fVar.f35423c = null;
                            fVar.f35425e = 3;
                            if (oVar.a(string2, fVar) == objH) {
                                return objH;
                            }
                        }
                        string = fVar.f35428h.subSequence(iEnd, matcher.start()).toString();
                        fVar.f35426f = oVar;
                        fVar.f35423c = matcher;
                        fVar.f35424d = i7;
                        fVar.f35425e = 2;
                        if (oVar.a(string, fVar) == objH) {
                            return objH;
                        }
                        iEnd = matcher.end();
                        i7++;
                        if (i7 != fVar.f35429i - 1) {
                        }
                        CharSequence charSequence3 = fVar.f35428h;
                        string2 = charSequence3.subSequence(iEnd, charSequence3.length()).toString();
                        fVar.f35426f = null;
                        fVar.f35423c = null;
                        fVar.f35425e = 3;
                        if (oVar.a(string2, fVar) == objH) {
                            return objH;
                        }
                    } else {
                        if (i8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super String> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((f) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    @a1
    public o(@a7.d Pattern nativePattern) {
        l0.p(nativePattern, "nativePattern");
        this.f35412a = nativePattern;
    }

    public static /* synthetic */ m d(o oVar, CharSequence charSequence, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return oVar.c(charSequence, i7);
    }

    public static /* synthetic */ kotlin.sequences.m f(o oVar, CharSequence charSequence, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return oVar.e(charSequence, i7);
    }

    public static /* synthetic */ List q(o oVar, CharSequence charSequence, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return oVar.p(charSequence, i7);
    }

    public static /* synthetic */ kotlin.sequences.m t(o oVar, CharSequence charSequence, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return oVar.r(charSequence, i7);
    }

    private final Object writeReplace() {
        String strPattern = this.f35412a.pattern();
        l0.o(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.f35412a.flags());
    }

    public final boolean b(@a7.d CharSequence input) {
        l0.p(input, "input");
        return this.f35412a.matcher(input).find();
    }

    @a7.e
    public final m c(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        Matcher matcher = this.f35412a.matcher(input);
        l0.o(matcher, "nativePattern.matcher(input)");
        return p.f(matcher, i7, input);
    }

    @a7.d
    public final kotlin.sequences.m<m> e(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        if (i7 >= 0 && i7 <= input.length()) {
            return kotlin.sequences.s.m(new c(input, i7), d.f35421j);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i7 + ", input length: " + input.length());
    }

    @a7.d
    public final Set<q> g() {
        Set set = this.f35413b;
        if (set != null) {
            return set;
        }
        int iFlags = this.f35412a.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(q.class);
        l0.o(enumSetAllOf, "");
        kotlin.collections.d0.N0(enumSetAllOf, new e(iFlags));
        Set<q> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        l0.o(setUnmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this.f35413b = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    @a7.d
    public final String h() {
        String strPattern = this.f35412a.pattern();
        l0.o(strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    @g1(version = "1.7")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public final m i(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        Matcher matcherRegion = this.f35412a.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i7, input.length());
        if (!matcherRegion.lookingAt()) {
            return null;
        }
        l0.o(matcherRegion, "this");
        return new n(matcherRegion, input);
    }

    @a7.e
    public final m j(@a7.d CharSequence input) {
        l0.p(input, "input");
        Matcher matcher = this.f35412a.matcher(input);
        l0.o(matcher, "nativePattern.matcher(input)");
        return p.h(matcher, input);
    }

    public final boolean k(@a7.d CharSequence input) {
        l0.p(input, "input");
        return this.f35412a.matcher(input).matches();
    }

    @g1(version = "1.7")
    @q2(markerClass = {kotlin.s.class})
    public final boolean l(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        return this.f35412a.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i7, input.length()).lookingAt();
    }

    @a7.d
    public final String m(@a7.d CharSequence input, @a7.d i5.l<? super m, ? extends CharSequence> transform) {
        l0.p(input, "input");
        l0.p(transform, "transform");
        int iIntValue = 0;
        m mVarD = d(this, input, 0, 2, null);
        if (mVarD == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, iIntValue, mVarD.d().d().intValue());
            sb.append(transform.z(mVarD));
            iIntValue = mVarD.d().f().intValue() + 1;
            mVarD = mVarD.next();
            if (iIntValue >= length) {
                break;
            }
        } while (mVarD != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        l0.o(string, "sb.toString()");
        return string;
    }

    @a7.d
    public final String n(@a7.d CharSequence input, @a7.d String replacement) {
        l0.p(input, "input");
        l0.p(replacement, "replacement");
        String strReplaceAll = this.f35412a.matcher(input).replaceAll(replacement);
        l0.o(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    @a7.d
    public final String o(@a7.d CharSequence input, @a7.d String replacement) {
        l0.p(input, "input");
        l0.p(replacement, "replacement");
        String strReplaceFirst = this.f35412a.matcher(input).replaceFirst(replacement);
        l0.o(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    @a7.d
    public final List<String> p(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        c0.M4(i7);
        Matcher matcher = this.f35412a.matcher(input);
        if (i7 == 1 || !matcher.find()) {
            return kotlin.collections.x.l(input.toString());
        }
        ArrayList arrayList = new ArrayList(i7 > 0 ? kotlin.ranges.q.u(i7, 10) : 10);
        int i8 = i7 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i8 >= 0 && arrayList.size() == i8) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    @a7.d
    @g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    public final kotlin.sequences.m<String> r(@a7.d CharSequence input, int i7) {
        l0.p(input, "input");
        c0.M4(i7);
        return kotlin.sequences.q.b(new f(input, i7, null));
    }

    @a7.d
    public String toString() {
        String string = this.f35412a.toString();
        l0.o(string, "nativePattern.toString()");
        return string;
    }

    @a7.d
    public final Pattern u() {
        return this.f35412a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@a7.d String pattern) {
        l0.p(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        l0.o(patternCompile, "compile(pattern)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@a7.d String pattern, @a7.d q option) {
        l0.p(pattern, "pattern");
        l0.p(option, "option");
        Pattern patternCompile = Pattern.compile(pattern, f35411c.b(option.getValue()));
        l0.o(patternCompile, "compile(pattern, ensureUnicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@a7.d String pattern, @a7.d Set<? extends q> options) {
        l0.p(pattern, "pattern");
        l0.p(options, "options");
        Pattern patternCompile = Pattern.compile(pattern, f35411c.b(p.k(options)));
        l0.o(patternCompile, "compile(pattern, ensureU…odeCase(options.toInt()))");
        this(patternCompile);
    }
}
