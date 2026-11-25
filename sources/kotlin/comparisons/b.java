package kotlin.comparisons;

import i5.p;
import java.util.Comparator;
import kotlin.jvm.internal.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Comparable<?>>[] f34637a;

        /* JADX WARN: Multi-variable type inference failed */
        a(i5.l<? super T, ? extends Comparable<?>>[] lVarArr) {
            this.f34637a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            return b.k(t7, t8, this.f34637a);
        }
    }

    /* JADX INFO: renamed from: kotlin.comparisons.b$b, reason: collision with other inner class name */
    public static final class C0428b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Comparable<?>> f34638a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0428b(i5.l<? super T, ? extends Comparable<?>> lVar) {
            this.f34638a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            i5.l<T, Comparable<?>> lVar = this.f34638a;
            return b.g(lVar.z(t7), lVar.z(t8));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f34639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34640b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Comparator<? super K> comparator, i5.l<? super T, ? extends K> lVar) {
            this.f34639a = comparator;
            this.f34640b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            Comparator<? super K> comparator = this.f34639a;
            i5.l<T, K> lVar = this.f34640b;
            return comparator.compare((Object) lVar.z(t7), (Object) lVar.z(t8));
        }
    }

    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Comparable<?>> f34641a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(i5.l<? super T, ? extends Comparable<?>> lVar) {
            this.f34641a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            i5.l<T, Comparable<?>> lVar = this.f34641a;
            return b.g(lVar.z(t8), lVar.z(t7));
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f34642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34643b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<? super K> comparator, i5.l<? super T, ? extends K> lVar) {
            this.f34642a = comparator;
            this.f34643b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            Comparator<? super K> comparator = this.f34642a;
            i5.l<T, K> lVar = this.f34643b;
            return comparator.compare((Object) lVar.z(t8), (Object) lVar.z(t7));
        }
    }

    static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f34644a;

        f(Comparator<? super T> comparator) {
            this.f34644a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@a7.e T t7, @a7.e T t8) {
            if (t7 == t8) {
                return 0;
            }
            if (t7 == null) {
                return -1;
            }
            if (t8 == null) {
                return 1;
            }
            return this.f34644a.compare(t7, t8);
        }
    }

    static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f34645a;

        g(Comparator<? super T> comparator) {
            this.f34645a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(@a7.e T t7, @a7.e T t8) {
            if (t7 == t8) {
                return 0;
            }
            if (t7 == null) {
                return 1;
            }
            if (t8 == null) {
                return -1;
            }
            return this.f34645a.compare(t7, t8);
        }
    }

    static final class h<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f34647b;

        h(Comparator<T> comparator, Comparator<? super T> comparator2) {
            this.f34646a = comparator;
            this.f34647b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34646a.compare(t7, t8);
            return iCompare != 0 ? iCompare : this.f34647b.compare(t7, t8);
        }
    }

    public static final class i<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Comparable<?>> f34649b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, i5.l<? super T, ? extends Comparable<?>> lVar) {
            this.f34648a = comparator;
            this.f34649b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34648a.compare(t7, t8);
            if (iCompare != 0) {
                return iCompare;
            }
            i5.l<T, Comparable<?>> lVar = this.f34649b;
            return b.g(lVar.z(t7), lVar.z(t8));
        }
    }

    public static final class j<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f34651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34652c;

        /* JADX WARN: Multi-variable type inference failed */
        public j(Comparator<T> comparator, Comparator<? super K> comparator2, i5.l<? super T, ? extends K> lVar) {
            this.f34650a = comparator;
            this.f34651b = comparator2;
            this.f34652c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34650a.compare(t7, t8);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f34651b;
            i5.l<T, K> lVar = this.f34652c;
            return comparator.compare((Object) lVar.z(t7), (Object) lVar.z(t8));
        }
    }

    public static final class k<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Comparable<?>> f34654b;

        /* JADX WARN: Multi-variable type inference failed */
        public k(Comparator<T> comparator, i5.l<? super T, ? extends Comparable<?>> lVar) {
            this.f34653a = comparator;
            this.f34654b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34653a.compare(t7, t8);
            if (iCompare != 0) {
                return iCompare;
            }
            i5.l<T, Comparable<?>> lVar = this.f34654b;
            return b.g(lVar.z(t8), lVar.z(t7));
        }
    }

    public static final class l<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super K> f34656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34657c;

        /* JADX WARN: Multi-variable type inference failed */
        public l(Comparator<T> comparator, Comparator<? super K> comparator2, i5.l<? super T, ? extends K> lVar) {
            this.f34655a = comparator;
            this.f34656b = comparator2;
            this.f34657c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34655a.compare(t7, t8);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f34656b;
            i5.l<T, K> lVar = this.f34657c;
            return comparator.compare((Object) lVar.z(t8), (Object) lVar.z(t7));
        }
    }

    public static final class m<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p<T, T, Integer> f34659b;

        /* JADX WARN: Multi-variable type inference failed */
        public m(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
            this.f34658a = comparator;
            this.f34659b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34658a.compare(t7, t8);
            return iCompare != 0 ? iCompare : this.f34659b.a0(t7, t8).intValue();
        }
    }

    static final class n<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator<T> f34660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f34661b;

        n(Comparator<T> comparator, Comparator<? super T> comparator2) {
            this.f34660a = comparator;
            this.f34661b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            int iCompare = this.f34660a.compare(t7, t8);
            return iCompare != 0 ? iCompare : this.f34661b.compare(t8, t7);
        }
    }

    @kotlin.internal.f
    private static final <T> Comparator<T> b(i5.l<? super T, ? extends Comparable<?>> selector) {
        l0.p(selector, "selector");
        return new C0428b(selector);
    }

    @kotlin.internal.f
    private static final <T, K> Comparator<T> c(Comparator<? super K> comparator, i5.l<? super T, ? extends K> selector) {
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        return new c(comparator, selector);
    }

    @a7.d
    public static final <T> Comparator<T> d(@a7.d i5.l<? super T, ? extends Comparable<?>>... selectors) {
        l0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return new a(selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @kotlin.internal.f
    private static final <T> Comparator<T> e(i5.l<? super T, ? extends Comparable<?>> selector) {
        l0.p(selector, "selector");
        return new d(selector);
    }

    @kotlin.internal.f
    private static final <T, K> Comparator<T> f(Comparator<? super K> comparator, i5.l<? super T, ? extends K> selector) {
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        return new e(comparator, selector);
    }

    public static <T extends Comparable<?>> int g(@a7.e T t7, @a7.e T t8) {
        if (t7 == t8) {
            return 0;
        }
        if (t7 == null) {
            return -1;
        }
        if (t8 == null) {
            return 1;
        }
        return t7.compareTo(t8);
    }

    @kotlin.internal.f
    private static final <T> int h(T t7, T t8, i5.l<? super T, ? extends Comparable<?>> selector) {
        l0.p(selector, "selector");
        return g(selector.z(t7), selector.z(t8));
    }

    @kotlin.internal.f
    private static final <T, K> int i(T t7, T t8, Comparator<? super K> comparator, i5.l<? super T, ? extends K> selector) {
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        return comparator.compare(selector.z(t7), selector.z(t8));
    }

    public static final <T> int j(T t7, T t8, @a7.d i5.l<? super T, ? extends Comparable<?>>... selectors) {
        l0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return k(t7, t8, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int k(T t7, T t8, i5.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (i5.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iG = g(lVar.z(t7), lVar.z(t8));
            if (iG != 0) {
                return iG;
            }
        }
        return 0;
    }

    @a7.d
    public static <T extends Comparable<? super T>> Comparator<T> l() {
        kotlin.comparisons.e eVar = kotlin.comparisons.e.f34662a;
        l0.n(eVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return eVar;
    }

    @kotlin.internal.f
    private static final <T extends Comparable<? super T>> Comparator<T> m() {
        return n(l());
    }

    @a7.d
    public static final <T> Comparator<T> n(@a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return new f(comparator);
    }

    @kotlin.internal.f
    private static final <T extends Comparable<? super T>> Comparator<T> o() {
        return p(l());
    }

    @a7.d
    public static final <T> Comparator<T> p(@a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return new g(comparator);
    }

    @a7.d
    public static <T extends Comparable<? super T>> Comparator<T> q() {
        kotlin.comparisons.f fVar = kotlin.comparisons.f.f34663a;
        l0.n(fVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return fVar;
    }

    @a7.d
    public static final <T> Comparator<T> r(@a7.d Comparator<T> comparator) {
        l0.p(comparator, "<this>");
        if (comparator instanceof kotlin.comparisons.g) {
            return ((kotlin.comparisons.g) comparator).a();
        }
        Comparator<T> gVar = kotlin.comparisons.e.f34662a;
        if (l0.g(comparator, gVar)) {
            kotlin.comparisons.f fVar = kotlin.comparisons.f.f34663a;
            l0.n(fVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return fVar;
        }
        if (l0.g(comparator, kotlin.comparisons.f.f34663a)) {
            l0.n(gVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            gVar = new kotlin.comparisons.g<>(comparator);
        }
        return gVar;
    }

    @a7.d
    public static final <T> Comparator<T> s(@a7.d Comparator<T> comparator, @a7.d Comparator<? super T> comparator2) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        return new h(comparator, comparator2);
    }

    @kotlin.internal.f
    private static final <T> Comparator<T> t(Comparator<T> comparator, i5.l<? super T, ? extends Comparable<?>> selector) {
        l0.p(comparator, "<this>");
        l0.p(selector, "selector");
        return new i(comparator, selector);
    }

    @kotlin.internal.f
    private static final <T, K> Comparator<T> u(Comparator<T> comparator, Comparator<? super K> comparator2, i5.l<? super T, ? extends K> selector) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        l0.p(selector, "selector");
        return new j(comparator, comparator2, selector);
    }

    @kotlin.internal.f
    private static final <T> Comparator<T> v(Comparator<T> comparator, i5.l<? super T, ? extends Comparable<?>> selector) {
        l0.p(comparator, "<this>");
        l0.p(selector, "selector");
        return new k(comparator, selector);
    }

    @kotlin.internal.f
    private static final <T, K> Comparator<T> w(Comparator<T> comparator, Comparator<? super K> comparator2, i5.l<? super T, ? extends K> selector) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        l0.p(selector, "selector");
        return new l(comparator, comparator2, selector);
    }

    @kotlin.internal.f
    private static final <T> Comparator<T> x(Comparator<T> comparator, p<? super T, ? super T, Integer> comparison) {
        l0.p(comparator, "<this>");
        l0.p(comparison, "comparison");
        return new m(comparator, comparison);
    }

    @a7.d
    public static final <T> Comparator<T> y(@a7.d Comparator<T> comparator, @a7.d Comparator<? super T> comparator2) {
        l0.p(comparator, "<this>");
        l0.p(comparator2, "comparator");
        return new n(comparator, comparator2);
    }
}
