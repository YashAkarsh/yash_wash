package kotlin.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a2;
import kotlin.b1;
import kotlin.collections.m1;
import kotlin.collections.n1;
import kotlin.collections.q1;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.collections.u0;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.p1;
import kotlin.q2;
import kotlin.t0;
import kotlin.w1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class e0 extends d0 {

    public static final class a implements Iterable<Character>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35341a;

        public a(CharSequence charSequence) {
            this.f35341a = charSequence;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Character> iterator() {
            return c0.B3(this.f35341a);
        }
    }

    public static final class b implements kotlin.sequences.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35342a;

        public b(CharSequence charSequence) {
            this.f35342a = charSequence;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Character> iterator() {
            return c0.B3(this.f35342a);
        }
    }

    static final class c extends n0 implements i5.l<CharSequence, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f35343a = new c();

        c() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d CharSequence it) {
            l0.p(it, "it");
            return it.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    public static final class d<K> implements kotlin.collections.n0<Character, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<Character, K> f35345b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(CharSequence charSequence, i5.l<? super Character, ? extends K> lVar) {
            this.f35344a = charSequence;
            this.f35345b = lVar;
        }

        @Override // kotlin.collections.n0
        public /* bridge */ /* synthetic */ Object a(Character ch) {
            return c(ch.charValue());
        }

        @Override // kotlin.collections.n0
        @a7.d
        public Iterator<Character> b() {
            return c0.B3(this.f35344a);
        }

        public K c(char c8) {
            return this.f35345b.z(Character.valueOf(c8));
        }
    }

    static final class e extends n0 implements i5.l<CharSequence, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35346a = new e();

        e() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d CharSequence it) {
            l0.p(it, "it");
            return it.toString();
        }
    }

    static final class f extends n0 implements i5.l<CharSequence, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f35347a = new f();

        f() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d CharSequence it) {
            l0.p(it, "it");
            return it.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static final class g<R> extends n0 implements i5.l<Integer, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f35349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.l<CharSequence, R> f35350c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(int i7, CharSequence charSequence, i5.l<? super CharSequence, ? extends R> lVar) {
            super(1);
            this.f35348a = i7;
            this.f35349b = charSequence;
            this.f35350c = lVar;
        }

        public final R b(int i7) {
            int length = this.f35348a + i7;
            if (length < 0 || length > this.f35349b.length()) {
                length = this.f35349b.length();
            }
            return this.f35350c.z(this.f35349b.subSequence(i7, length));
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ Object z(Integer num) {
            return b(num.intValue());
        }
    }

    static final class h extends n0 implements i5.a<Iterator<? extends Character>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f35351a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(CharSequence charSequence) {
            super(0);
            this.f35351a = charSequence;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Character> invoke() {
            return c0.B3(this.f35351a);
        }
    }

    @a7.d
    public static String A6(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(kotlin.ranges.q.u(i7, str.length()));
            l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C A7(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            int i9 = i8 + 1;
            R rA0 = transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7)));
            if (rA0 != null) {
                destination.add(rA0);
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final String A8(String str) {
        l0.p(str, "<this>");
        return z8(str).toString();
    }

    @a7.d
    public static final CharSequence B6(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (i7 >= 0) {
            return W8(charSequence, kotlin.ranges.q.n(charSequence.length() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C B7(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            destination.add(transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @a7.d
    @g1(version = "1.4")
    public static final <R> List<R> B8(@a7.d CharSequence charSequence, R r7, @a7.d i5.p<? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r7);
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            r7 = operation.a0(r7, Character.valueOf(charSequence.charAt(i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static String C6(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        if (i7 >= 0) {
            return X8(str, kotlin.ranges.q.n(str.length() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<R> C7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            R rZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            if (rZ != null) {
                arrayList.add(rZ);
            }
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.4")
    public static final <R> List<R> C8(@a7.d CharSequence charSequence, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r7);
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Character.valueOf(charSequence.charAt(i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static final CharSequence D6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int iI3 = c0.i3(charSequence); -1 < iI3; iI3--) {
            if (!predicate.z(Character.valueOf(charSequence.charAt(iI3))).booleanValue()) {
                return charSequence.subSequence(0, iI3 + 1);
            }
        }
        return "";
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C D7(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.l<? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            R rZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            if (rZ != null) {
                destination.add(rZ);
            }
        }
        return destination;
    }

    @a7.d
    @g1(version = "1.4")
    public static final List<Character> D8(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.y.F();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i7 = 1; i7 < length; i7++) {
            cCharAt = operation.a0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i7))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @a7.d
    public static final String E6(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        for (int iI3 = c0.i3(str); -1 < iI3; iI3--) {
            if (!predicate.z(Character.valueOf(str.charAt(iI3))).booleanValue()) {
                String strSubstring = str.substring(0, iI3 + 1);
                l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C E7(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.l<? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            destination.add(transform.z(Character.valueOf(charSequence.charAt(i7))));
        }
        return destination;
    }

    @a7.d
    @g1(version = "1.4")
    public static final List<Character> E8(@a7.d CharSequence charSequence, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.y.F();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i7 = 1; i7 < length; i7++) {
            cCharAt = operation.v(Integer.valueOf(i7), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i7))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @a7.d
    public static final CharSequence F6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
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

    @g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Character F7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) < 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <R> List<R> F8(@a7.d CharSequence charSequence, R r7, @a7.d i5.p<? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r7);
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            r7 = operation.a0(r7, Character.valueOf(charSequence.charAt(i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static final String G6(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!predicate.z(Character.valueOf(str.charAt(i7))).booleanValue()) {
                String strSubstring = str.substring(i7);
                l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char G7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return cCharAt;
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) < 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return cCharAt;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <R> List<R> G8(@a7.d CharSequence charSequence, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r7);
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Character.valueOf(charSequence.charAt(i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final char H6(CharSequence charSequence, int i7, i5.l<? super Integer, Character> defaultValue) {
        l0.p(charSequence, "<this>");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > c0.i3(charSequence)) ? defaultValue.z(Integer.valueOf(i7)).charValue() : charSequence.charAt(i7);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final double H7(CharSequence charSequence, i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Character.valueOf(charSequence.charAt(0))).doubleValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    public static final char H8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @kotlin.internal.f
    private static final Character I6(CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        return l7(charSequence, i7);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final float I7(CharSequence charSequence, i5.l<? super Character, Float> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Character.valueOf(charSequence.charAt(0))).floatValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).floatValue());
        }
        return fFloatValue;
    }

    public static final char I8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                chValueOf = Character.valueOf(cCharAt);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        l0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @a7.d
    public static final CharSequence J6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R extends Comparable<? super R>> R J7(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.e
    public static final Character J8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @a7.d
    public static final String K6(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        l0.o(string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R extends Comparable<? super R>> R K7(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.e
    public static final Character K8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                if (z7) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z7 = true;
            }
        }
        if (z7) {
            return chValueOf;
        }
        return null;
    }

    @a7.d
    public static final CharSequence L6(@a7.d CharSequence charSequence, @a7.d i5.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i7++;
            i8 = i9;
        }
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final Double L7(CharSequence charSequence, i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Character.valueOf(charSequence.charAt(0))).doubleValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    public static final CharSequence L8(@a7.d CharSequence charSequence, @a7.d Iterable<Integer> indices) {
        l0.p(charSequence, "<this>");
        l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    @a7.d
    public static final String M6(@a7.d String str, @a7.d i5.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        int i8 = 0;
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i7++;
            i8 = i9;
        }
        String string = sb.toString();
        l0.o(string, "filterIndexedTo(StringBu…(), predicate).toString()");
        return string;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final Float M7(CharSequence charSequence, i5.l<? super Character, Float> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float fFloatValue = selector.z(Character.valueOf(charSequence.charAt(0))).floatValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.d
    public static final CharSequence M8(@a7.d CharSequence charSequence, @a7.d kotlin.ranges.k indices) {
        l0.p(charSequence, "<this>");
        l0.p(indices, "indices");
        return indices.isEmpty() ? "" : c0.g5(charSequence, indices);
    }

    @a7.d
    public static final <C extends Appendable> C N6(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R> R N7(CharSequence charSequence, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.internal.f
    private static final String N8(String str, Iterable<Integer> indices) {
        l0.p(str, "<this>");
        l0.p(indices, "indices");
        return L8(str, indices).toString();
    }

    @a7.d
    public static final CharSequence O6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (!predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R> R O7(CharSequence charSequence, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    public static final String O8(@a7.d String str, @a7.d kotlin.ranges.k indices) {
        l0.p(str, "<this>");
        l0.p(indices, "indices");
        return indices.isEmpty() ? "" : c0.k5(str, indices);
    }

    @a7.d
    public static final String P6(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (!predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        l0.o(string, "filterNotTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character P7(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (l0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int P8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Integer> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        int iIntValue = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            iIntValue += selector.z(Character.valueOf(charSequence.charAt(i7))).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <C extends Appendable> C Q6(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (!predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    @g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final char Q7(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (l0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Q8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            dDoubleValue += selector.z(Character.valueOf(charSequence.charAt(i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final <C extends Appendable> C R6(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.l<? super Character, Boolean> predicate) throws IOException {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character R7(@a7.d CharSequence charSequence, @a7.d Comparator<? super Character> comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @t0
    @kotlin.internal.f
    private static final double R8(CharSequence charSequence, i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            dDoubleValue += selector.z(Character.valueOf(charSequence.charAt(i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.internal.f
    private static final Character S6(CharSequence charSequence, i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final char S7(@a7.d CharSequence charSequence, @a7.d Comparator<? super Character> comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @t0
    @kotlin.internal.f
    private static final int S8(CharSequence charSequence, i5.l<? super Character, Integer> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        int iIntValue = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            iIntValue += selector.z(Character.valueOf(charSequence.charAt(i7))).intValue();
        }
        return iIntValue;
    }

    @kotlin.internal.f
    private static final Character T6(CharSequence charSequence, i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                    return Character.valueOf(cCharAt);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Character T7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) > 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @t0
    @kotlin.internal.f
    private static final long T8(CharSequence charSequence, i5.l<? super Character, Long> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        long jLongValue = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            jLongValue += selector.z(Character.valueOf(charSequence.charAt(i7))).longValue();
        }
        return jLongValue;
    }

    public static final char U6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    @g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char U7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return cCharAt;
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) > 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return cCharAt;
    }

    @g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int U8(CharSequence charSequence, i5.l<? super Character, w1> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            iH = w1.h(iH + selector.z(Character.valueOf(charSequence.charAt(i7))).g0());
        }
        return iH;
    }

    public static final char V6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final double V7(CharSequence charSequence, i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Character.valueOf(charSequence.charAt(0))).doubleValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long V8(CharSequence charSequence, i5.l<? super Character, a2> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            jH = a2.h(jH + selector.z(Character.valueOf(charSequence.charAt(i7))).g0());
        }
        return jH;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    @g1(version = "1.5")
    @kotlin.internal.f
    private static final <R> R W6(CharSequence charSequence, i5.l<? super Character, ? extends R> transform) {
        R rZ;
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            rZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            if (rZ != null) {
                if (rZ != null) {
                    return rZ;
                }
                throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
            }
        }
        rZ = null;
        if (rZ != null) {
            return rZ;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final float W7(CharSequence charSequence, i5.l<? super Character, Float> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Character.valueOf(charSequence.charAt(0))).floatValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    public static final CharSequence W8(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (i7 >= 0) {
            return charSequence.subSequence(0, kotlin.ranges.q.u(i7, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final <R> R X6(CharSequence charSequence, i5.l<? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            R rZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            if (rZ != null) {
                return rZ;
            }
        }
        return null;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R extends Comparable<? super R>> R X7(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    public static String X8(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(0, kotlin.ranges.q.u(i7, str.length()));
            l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.e
    public static final Character Y6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R extends Comparable<? super R>> R Y7(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    public static final CharSequence Y8(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (i7 >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - kotlin.ranges.q.u(i7, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.e
    public static final Character Z6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final Double Z7(CharSequence charSequence, i5.l<? super Character, Double> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Character.valueOf(charSequence.charAt(0))).doubleValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    public static final String Z8(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        if (i7 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - kotlin.ranges.q.u(i7, length));
            l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<R> a7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends Iterable<? extends R>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            kotlin.collections.d0.o0(arrayList, transform.z(Character.valueOf(charSequence.charAt(i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final Float a8(CharSequence charSequence, i5.l<? super Character, Float> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float fFloatValue = selector.z(Character.valueOf(charSequence.charAt(0))).floatValue();
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Character.valueOf(charSequence.charAt(it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.d
    public static final CharSequence a9(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int iI3 = c0.i3(charSequence); -1 < iI3; iI3--) {
            if (!predicate.z(Character.valueOf(charSequence.charAt(iI3))).booleanValue()) {
                return charSequence.subSequence(iI3 + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @t0
    @kotlin.internal.f
    private static final <R> List<R> b7(CharSequence charSequence, i5.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            kotlin.collections.d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R> R b8(CharSequence charSequence, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    public static final String b9(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        for (int iI3 = c0.i3(str); -1 < iI3; iI3--) {
            if (!predicate.z(Character.valueOf(str.charAt(iI3))).booleanValue()) {
                String strSubstring = str.substring(iI3 + 1);
                l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C c7(CharSequence charSequence, C destination, i5.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            kotlin.collections.d0.o0(destination, transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <R> R c8(CharSequence charSequence, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(charSequence.charAt(0)));
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(charSequence.charAt(it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    public static final CharSequence c9(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return charSequence.subSequence(0, i7);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C d7(@a7.d CharSequence charSequence, @a7.d C destination, @a7.d i5.l<? super Character, ? extends Iterable<? extends R>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            kotlin.collections.d0.o0(destination, transform.z(Character.valueOf(charSequence.charAt(i7))));
        }
        return destination;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character d8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (l0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    public static final String d9(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (!predicate.z(Character.valueOf(str.charAt(i7))).booleanValue()) {
                String strSubstring = str.substring(0, i7);
                l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    public static final <R> R e7(@a7.d CharSequence charSequence, R r7, @a7.d i5.p<? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            r7 = operation.a0(r7, Character.valueOf(charSequence.charAt(i7)));
        }
        return r7;
    }

    @g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final char e8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (l0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @a7.d
    public static final <C extends Collection<? super Character>> C e9(@a7.d CharSequence charSequence, @a7.d C destination) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            destination.add(Character.valueOf(charSequence.charAt(i7)));
        }
        return destination;
    }

    public static final <R> R f7(@a7.d CharSequence charSequence, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            r7 = operation.v(Integer.valueOf(i8), r7, Character.valueOf(charSequence.charAt(i7)));
            i7++;
            i8++;
        }
        return r7;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character f8(@a7.d CharSequence charSequence, @a7.d Comparator<? super Character> comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    public static final HashSet<Character> f9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return (HashSet) e9(charSequence, new HashSet(kotlin.collections.b1.j(kotlin.ranges.q.u(charSequence.length(), 128))));
    }

    public static final boolean g6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (!predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <R> R g7(@a7.d CharSequence charSequence, R r7, @a7.d i5.p<? super Character, ? super R, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        for (int iI3 = c0.i3(charSequence); iI3 >= 0; iI3--) {
            r7 = operation.a0(Character.valueOf(charSequence.charAt(iI3)), r7);
        }
        return r7;
    }

    @g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final char g8(@a7.d CharSequence charSequence, @a7.d Comparator<? super Character> comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @a7.d
    public static final List<Character> g9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            return length != 1 ? h9(charSequence) : kotlin.collections.x.l(Character.valueOf(charSequence.charAt(0)));
        }
        return kotlin.collections.y.F();
    }

    public static final boolean h6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final <R> R h7(@a7.d CharSequence charSequence, R r7, @a7.d i5.q<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        for (int iI3 = c0.i3(charSequence); iI3 >= 0; iI3--) {
            r7 = operation.v(Integer.valueOf(iI3), Character.valueOf(charSequence.charAt(iI3)), r7);
        }
        return r7;
    }

    public static final boolean h8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @a7.d
    public static final List<Character> h9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return (List) e9(charSequence, new ArrayList(charSequence.length()));
    }

    public static final boolean i6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final void i7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, l2> action) {
        l0.p(charSequence, "<this>");
        l0.p(action, "action");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            action.z(Character.valueOf(charSequence.charAt(i7)));
        }
    }

    public static final boolean i8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final Set<Character> i9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            return length != 1 ? (Set) e9(charSequence, new LinkedHashSet(kotlin.collections.b1.j(kotlin.ranges.q.u(charSequence.length(), 128)))) : m1.f(Character.valueOf(charSequence.charAt(0)));
        }
        return n1.k();
    }

    @a7.d
    public static final Iterable<Character> j6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return kotlin.collections.y.F();
            }
        }
        return new a(charSequence);
    }

    public static final void j7(@a7.d CharSequence charSequence, @a7.d i5.p<? super Integer, ? super Character, l2> action) {
        l0.p(charSequence, "<this>");
        l0.p(action, "action");
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            action.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7)));
            i7++;
            i8++;
        }
    }

    @a7.d
    @g1(version = "1.1")
    public static final <S extends CharSequence> S j8(@a7.d S s7, @a7.d i5.l<? super Character, l2> action) {
        l0.p(s7, "<this>");
        l0.p(action, "action");
        for (int i7 = 0; i7 < s7.length(); i7++) {
            action.z(Character.valueOf(s7.charAt(i7)));
        }
        return s7;
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<String> j9(@a7.d CharSequence charSequence, int i7, int i8, boolean z7) {
        l0.p(charSequence, "<this>");
        return k9(charSequence, i7, i8, z7, e.f35346a);
    }

    @a7.d
    public static final kotlin.sequences.m<Character> k6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return kotlin.sequences.s.g();
            }
        }
        return new b(charSequence);
    }

    @kotlin.internal.f
    private static final char k7(CharSequence charSequence, int i7, i5.l<? super Integer, Character> defaultValue) {
        l0.p(charSequence, "<this>");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > c0.i3(charSequence)) ? defaultValue.z(Integer.valueOf(i7)).charValue() : charSequence.charAt(i7);
    }

    @a7.d
    @g1(version = "1.4")
    public static final <S extends CharSequence> S k8(@a7.d S s7, @a7.d i5.p<? super Integer, ? super Character, l2> action) {
        l0.p(s7, "<this>");
        l0.p(action, "action");
        int i7 = 0;
        int i8 = 0;
        while (i7 < s7.length()) {
            action.a0(Integer.valueOf(i8), Character.valueOf(s7.charAt(i7)));
            i7++;
            i8++;
        }
        return s7;
    }

    @a7.d
    @g1(version = "1.2")
    public static final <R> List<R> k9(@a7.d CharSequence charSequence, int i7, int i8, boolean z7, @a7.d i5.l<? super CharSequence, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        q1.a(i7, i8);
        int length = charSequence.length();
        ArrayList arrayList = new ArrayList((length / i8) + (length % i8 == 0 ? 0 : 1));
        int i9 = 0;
        while (true) {
            if (!(i9 >= 0 && i9 < length)) {
                break;
            }
            int i10 = i9 + i7;
            if (i10 < 0 || i10 > length) {
                if (!z7) {
                    break;
                }
                i10 = length;
            }
            arrayList.add(transform.z(charSequence.subSequence(i9, i10)));
            i9 += i8;
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> l6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(charSequence.length()), 16));
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @a7.e
    public static final Character l7(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (i7 < 0 || i7 > c0.i3(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i7));
    }

    @a7.d
    public static final kotlin.u0<CharSequence, CharSequence> l8(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new kotlin.u0<>(sb, sb2);
    }

    public static /* synthetic */ List l9(CharSequence charSequence, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return j9(charSequence, i7, i8, z7);
    }

    @a7.d
    public static final <K> Map<K, Character> m6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        l0.p(charSequence, "<this>");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(charSequence.length()), 16));
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            linkedHashMap.put(keySelector.z(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K> Map<K, List<Character>> m7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        l0.p(charSequence, "<this>");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            K kZ = keySelector.z(Character.valueOf(cCharAt));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final kotlin.u0<String, String> m8(@a7.d String str, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(str, "<this>");
        l0.p(predicate, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        String string = sb.toString();
        l0.o(string, "first.toString()");
        String string2 = sb2.toString();
        l0.o(string2, "second.toString()");
        return new kotlin.u0<>(string, string2);
    }

    public static /* synthetic */ List m9(CharSequence charSequence, int i7, int i8, boolean z7, i5.l lVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return k9(charSequence, i7, i8, z7, lVar);
    }

    @a7.d
    public static final <K, V> Map<K, V> n6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        l0.p(charSequence, "<this>");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(charSequence.length()), 16));
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            linkedHashMap.put(keySelector.z(Character.valueOf(cCharAt)), valueTransform.z(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> n7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        l0.p(charSequence, "<this>");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            K kZ = keySelector.z(Character.valueOf(cCharAt));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final char n8(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return o8(charSequence, kotlin.random.f.f34998a);
    }

    @a7.d
    @g1(version = "1.2")
    public static final kotlin.sequences.m<String> n9(@a7.d CharSequence charSequence, int i7, int i8, boolean z7) {
        l0.p(charSequence, "<this>");
        return o9(charSequence, i7, i8, z7, f.f35347a);
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Character>> M o6(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            destination.put(keySelector.z(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return destination;
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Character>>> M o7(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            K kZ = keySelector.z(Character.valueOf(cCharAt));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return destination;
    }

    @g1(version = "1.3")
    public static final char o8(@a7.d CharSequence charSequence, @a7.d kotlin.random.f random) {
        l0.p(charSequence, "<this>");
        l0.p(random, "random");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(random.m(charSequence.length()));
    }

    @a7.d
    @g1(version = "1.2")
    public static final <R> kotlin.sequences.m<R> o9(@a7.d CharSequence charSequence, int i7, int i8, boolean z7, @a7.d i5.l<? super CharSequence, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        q1.a(i7, i8);
        return kotlin.sequences.u.k1(kotlin.collections.g0.v1(kotlin.ranges.q.e1(z7 ? c0.h3(charSequence) : kotlin.ranges.q.z1(0, (charSequence.length() - i7) + 1), i8)), new g(i7, charSequence, transform));
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M p6(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            destination.put(keySelector.z(Character.valueOf(cCharAt)), valueTransform.z(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M p7(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            K kZ = keySelector.z(Character.valueOf(cCharAt));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Character p8(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return q8(charSequence, kotlin.random.f.f34998a);
    }

    public static /* synthetic */ kotlin.sequences.m p9(CharSequence charSequence, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return n9(charSequence, i7, i8, z7);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M q6(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Character.valueOf(charSequence.charAt(i7)));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @a7.d
    @g1(version = "1.1")
    public static final <K> kotlin.collections.n0<Character, K> q7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        l0.p(charSequence, "<this>");
        l0.p(keySelector, "keySelector");
        return new d(charSequence, keySelector);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character q8(@a7.d CharSequence charSequence, @a7.d kotlin.random.f random) {
        l0.p(charSequence, "<this>");
        l0.p(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.m(charSequence.length())));
    }

    public static /* synthetic */ kotlin.sequences.m q9(CharSequence charSequence, int i7, int i8, boolean z7, i5.l lVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return o9(charSequence, i7, i8, z7, lVar);
    }

    @a7.d
    @g1(version = "1.3")
    public static final <V> Map<Character, V> r6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends V> valueSelector) {
        l0.p(charSequence, "<this>");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(kotlin.ranges.q.u(charSequence.length(), 128)), 16));
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            linkedHashMap.put(Character.valueOf(cCharAt), valueSelector.z(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final int r7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Character.valueOf(charSequence.charAt(i7))).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    public static final char r8(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            cCharAt = operation.a0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it.b()))).charValue();
        }
        return cCharAt;
    }

    @a7.d
    public static final Iterable<r0<Character>> r9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return new s0(new h(charSequence));
    }

    @a7.d
    @g1(version = "1.3")
    public static final <V, M extends Map<? super Character, ? super V>> M s6(@a7.d CharSequence charSequence, @a7.d M destination, @a7.d i5.l<? super Character, ? extends V> valueSelector) {
        l0.p(charSequence, "<this>");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            destination.put(Character.valueOf(cCharAt), valueSelector.z(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    public static final int s7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    public static final char s8(@a7.d CharSequence charSequence, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            cCharAt = operation.v(Integer.valueOf(iB), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iB))).charValue();
        }
        return cCharAt;
    }

    @a7.d
    public static final List<kotlin.u0<Character, Character>> s9(@a7.d CharSequence charSequence, @a7.d CharSequence other) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(p1.a(Character.valueOf(charSequence.charAt(i7)), Character.valueOf(other.charAt(i7))));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<String> t6(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        return j9(charSequence, i7, i7, true);
    }

    public static char t7(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(c0.i3(charSequence));
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character t8(@a7.d CharSequence charSequence, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            cCharAt = operation.v(Integer.valueOf(iB), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iB))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    public static final <V> List<V> t9(@a7.d CharSequence charSequence, @a7.d CharSequence other, @a7.d i5.p<? super Character, ? super Character, ? extends V> transform) {
        l0.p(charSequence, "<this>");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Character.valueOf(charSequence.charAt(i7)), Character.valueOf(other.charAt(i7))));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.2")
    public static final <R> List<R> u6(@a7.d CharSequence charSequence, int i7, @a7.d i5.l<? super CharSequence, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        return k9(charSequence, i7, i7, true, transform);
    }

    public static final char u7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                    return cCharAt;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character u8(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        u0 it = new kotlin.ranges.k(1, c0.i3(charSequence)).iterator();
        while (it.hasNext()) {
            cCharAt = operation.a0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it.b()))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<kotlin.u0<Character, Character>> u9(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(length);
        int i7 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            i7++;
            arrayList.add(p1.a(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i7))));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.2")
    public static final kotlin.sequences.m<String> v6(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        return w6(charSequence, i7, c.f35343a);
    }

    @a7.e
    public static final Character v7(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final char v8(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        int iI3 = c0.i3(charSequence);
        if (iI3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iI3);
        for (int i7 = iI3 - 1; i7 >= 0; i7--) {
            cCharAt = operation.a0(Character.valueOf(charSequence.charAt(i7)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @a7.d
    @g1(version = "1.2")
    public static final <R> List<R> v9(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(length);
        int i7 = 0;
        while (i7 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i7));
            i7++;
            arrayList.add(transform.a0(chValueOf, Character.valueOf(charSequence.charAt(i7))));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.2")
    public static final <R> kotlin.sequences.m<R> w6(@a7.d CharSequence charSequence, int i7, @a7.d i5.l<? super CharSequence, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        return o9(charSequence, i7, i7, true, transform);
    }

    @a7.e
    public static final Character w7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            char cCharAt = charSequence.charAt(length);
            if (predicate.z(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    public static final char w8(@a7.d CharSequence charSequence, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        int iI3 = c0.i3(charSequence);
        if (iI3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iI3);
        for (int i7 = iI3 - 1; i7 >= 0; i7--) {
            cCharAt = operation.v(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i7)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @kotlin.internal.f
    private static final int x6(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return charSequence.length();
    }

    @a7.d
    public static final <R> List<R> x7(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            arrayList.add(transform.z(Character.valueOf(charSequence.charAt(i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Character x8(@a7.d CharSequence charSequence, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        int iI3 = c0.i3(charSequence);
        if (iI3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iI3);
        for (int i7 = iI3 - 1; i7 >= 0; i7--) {
            cCharAt = operation.v(Integer.valueOf(i7), Character.valueOf(charSequence.charAt(i7)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final int y6(@a7.d CharSequence charSequence, @a7.d i5.l<? super Character, Boolean> predicate) {
        l0.p(charSequence, "<this>");
        l0.p(predicate, "predicate");
        int i7 = 0;
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            if (predicate.z(Character.valueOf(charSequence.charAt(i8))).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final <R> List<R> y7(@a7.d CharSequence charSequence, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character y8(@a7.d CharSequence charSequence, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        l0.p(charSequence, "<this>");
        l0.p(operation, "operation");
        int iI3 = c0.i3(charSequence);
        if (iI3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iI3);
        for (int i7 = iI3 - 1; i7 >= 0; i7--) {
            cCharAt = operation.a0(Character.valueOf(charSequence.charAt(i7)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @a7.d
    public static final CharSequence z6(@a7.d CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        if (i7 >= 0) {
            return charSequence.subSequence(kotlin.ranges.q.u(i7, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<R> z7(@a7.d CharSequence charSequence, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        l0.p(charSequence, "<this>");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        int i8 = 0;
        while (i7 < charSequence.length()) {
            int i9 = i8 + 1;
            R rA0 = transform.a0(Integer.valueOf(i8), Character.valueOf(charSequence.charAt(i7)));
            if (rA0 != null) {
                arrayList.add(rA0);
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @a7.d
    public static final CharSequence z8(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        l0.o(sbReverse, "StringBuilder(this).reverse()");
        return sbReverse;
    }
}
