package kotlin.sequences;

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
import kotlin.collections.c0;
import kotlin.collections.d0;
import kotlin.collections.g0;
import kotlin.collections.n1;
import kotlin.collections.q1;
import kotlin.collections.r0;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.k1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.p1;
import kotlin.q2;
import kotlin.t0;
import kotlin.u0;
import kotlin.w1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class u extends kotlin.sequences.t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f35181a;

        public a(kotlin.sequences.m mVar) {
            this.f35181a = mVar;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<T> iterator() {
            return this.f35181a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class a0<T> extends n0 implements i5.p<T, T, u0<? extends T, ? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f35182a = new a0();

        a0() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final u0<T, T> a0(T t7, T t8) {
            return p1.a(t7, t8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class b<T> extends n0 implements i5.l<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35183a = new b();

        b() {
            super(1);
        }

        @Override // i5.l
        public final T z(T t7) {
            return t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2864}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
    static final class b0<R> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35186e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35187f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35188g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T, T, R> f35189h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b0(kotlin.sequences.m<? extends T> mVar, i5.p<? super T, ? super T, ? extends R> pVar, kotlin.coroutines.d<? super b0> dVar) {
            super(2, dVar);
            this.f35188g = mVar;
            this.f35189h = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b0 b0Var = new b0(this.f35188g, this.f35189h, dVar);
            b0Var.f35187f = obj;
            return b0Var;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Object next;
            Iterator it;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35186e;
            if (i7 == 0) {
                e1.n(obj);
                kotlin.sequences.o oVar2 = (kotlin.sequences.o) this.f35187f;
                Iterator it2 = this.f35188g.iterator();
                if (!it2.hasNext()) {
                    return l2.f34958a;
                }
                oVar = oVar2;
                next = it2.next();
                it = it2;
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = this.f35185d;
                it = (Iterator) this.f35184c;
                oVar = (kotlin.sequences.o) this.f35187f;
                e1.n(obj);
                next = obj2;
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                R rA0 = this.f35189h.a0((T) next, (T) next2);
                this.f35187f = oVar;
                this.f35184c = it;
                this.f35185d = next2;
                this.f35186e = 1;
                if (oVar.a(rA0, this) == objH) {
                    return objH;
                }
                next = next2;
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super R> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((b0) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class c<T> extends n0 implements i5.l<Integer, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i7) {
            super(1);
            this.f35190a = i7;
        }

        public final T b(int i7) {
            throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.f35190a + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ Object z(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class d<T> extends n0 implements i5.l<r0<? extends T>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<Integer, T, Boolean> f35191a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(i5.p<? super Integer, ? super T, Boolean> pVar) {
            super(1);
            this.f35191a = pVar;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.d r0<? extends T> it) {
            l0.p(it, "it");
            return this.f35191a.a0(Integer.valueOf(it.e()), it.f());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class e<T> extends n0 implements i5.l<r0<? extends T>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35192a = new e();

        e() {
            super(1);
        }

        @Override // i5.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T z(@a7.d r0<? extends T> it) {
            l0.p(it, "it");
            return it.f();
        }
    }

    public static final class f extends n0 implements i5.l<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f35193a = new f();

        public f() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.e Object obj) {
            l0.y(3, "R");
            return Boolean.valueOf(obj instanceof Object);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class g<T> extends n0 implements i5.l<T, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f35194a = new g();

        g() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.e T t7) {
            return Boolean.valueOf(t7 == null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* synthetic */ class h<R> extends h0 implements i5.l<Iterable<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final h f35195j = new h();

        h() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> z(@a7.d Iterable<? extends R> p7) {
            l0.p(p7, "p0");
            return p7.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* synthetic */ class i<R> extends h0 implements i5.l<kotlin.sequences.m<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final i f35196j = new i();

        i() {
            super(1, kotlin.sequences.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> z(@a7.d kotlin.sequences.m<? extends R> p7) {
            l0.p(p7, "p0");
            return p7.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* synthetic */ class j<R> extends h0 implements i5.l<Iterable<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final j f35197j = new j();

        j() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> z(@a7.d Iterable<? extends R> p7) {
            l0.p(p7, "p0");
            return p7.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* synthetic */ class k<R> extends h0 implements i5.l<kotlin.sequences.m<? extends R>, Iterator<? extends R>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final k f35198j = new k();

        k() {
            super(1, kotlin.sequences.m.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final Iterator<R> z(@a7.d kotlin.sequences.m<? extends R> p7) {
            l0.p(p7, "p0");
            return p7.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class l<K, T> implements kotlin.collections.n0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f35200b;

        /* JADX WARN: Multi-variable type inference failed */
        public l(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends K> lVar) {
            this.f35199a = mVar;
            this.f35200b = lVar;
        }

        @Override // kotlin.collections.n0
        public K a(T t7) {
            return this.f35200b.z(t7);
        }

        @Override // kotlin.collections.n0
        @a7.d
        public Iterator<T> b() {
            return this.f35199a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class m<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ T f35202b;

        static final class a extends n0 implements i5.l<T, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k1.a f35203a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ T f35204b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k1.a aVar, T t7) {
                super(1);
                this.f35203a = aVar;
                this.f35204b = t7;
            }

            @Override // i5.l
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean z(T t7) {
                boolean z7 = true;
                if (!this.f35203a.f34865a && l0.g(t7, this.f35204b)) {
                    this.f35203a.f34865a = true;
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        m(kotlin.sequences.m<? extends T> mVar, T t7) {
            this.f35201a = mVar;
            this.f35202b = t7;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return u.p0(this.f35201a, new a(new k1.a(), this.f35202b)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class n<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T[] f35205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35206b;

        static final class a extends n0 implements i5.l<T, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collection<T> f35207a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Collection<? extends T> collection) {
                super(1);
                this.f35207a = collection;
            }

            @Override // i5.l
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean z(T t7) {
                return Boolean.valueOf(this.f35207a.contains(t7));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        n(T[] tArr, kotlin.sequences.m<? extends T> mVar) {
            this.f35205a = tArr;
            this.f35206b = mVar;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return u.u0(this.f35206b, new a(kotlin.collections.s.c(this.f35205a))).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class o<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f35208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35209b;

        static final class a extends n0 implements i5.l<T, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collection<T> f35210a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Collection<? extends T> collection) {
                super(1);
                this.f35210a = collection;
            }

            @Override // i5.l
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean z(T t7) {
                return Boolean.valueOf(this.f35210a.contains(t7));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        o(Iterable<? extends T> iterable, kotlin.sequences.m<? extends T> mVar) {
            this.f35208a = iterable;
            this.f35209b = mVar;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            Collection collectionA = kotlin.collections.s.a(this.f35208a);
            return collectionA.isEmpty() ? this.f35209b.iterator() : u.u0(this.f35209b, new a(collectionA)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class p<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35212b;

        static final class a extends n0 implements i5.l<T, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Collection<T> f35213a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Collection<? extends T> collection) {
                super(1);
                this.f35213a = collection;
            }

            @Override // i5.l
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean z(T t7) {
                return Boolean.valueOf(this.f35213a.contains(t7));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        p(kotlin.sequences.m<? extends T> mVar, kotlin.sequences.m<? extends T> mVar2) {
            this.f35211a = mVar;
            this.f35212b = mVar2;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            Collection collectionB = kotlin.collections.s.b(this.f35211a);
            return collectionB.isEmpty() ? this.f35212b.iterator() : u.u0(this.f35212b, new a(collectionB)).iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class q<T> extends n0 implements i5.l<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, l2> f35214a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        q(i5.l<? super T, l2> lVar) {
            super(1);
            this.f35214a = lVar;
        }

        @Override // i5.l
        public final T z(T t7) {
            this.f35214a.z(t7);
            return t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class r<T> extends n0 implements i5.p<Integer, T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<Integer, T, l2> f35215a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        r(i5.p<? super Integer, ? super T, l2> pVar) {
            super(2);
            this.f35215a = pVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i5.p
        public /* bridge */ /* synthetic */ Object a0(Integer num, Object obj) {
            return b(num.intValue(), obj);
        }

        public final T b(int i7, T t7) {
            this.f35215a.a0(Integer.valueOf(i7), t7);
            return t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class s<T> extends n0 implements i5.l<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35216a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        s(kotlin.sequences.m<? extends T> mVar) {
            super(1);
            this.f35216a = mVar;
        }

        @Override // i5.l
        @a7.d
        public final T z(@a7.e T t7) {
            if (t7 != null) {
                return t7;
            }
            throw new IllegalArgumentException("null element found in " + this.f35216a + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2286, 2290}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
    static final class t<R> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ R f35221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i5.p<R, T, R> f35223i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        t(R r7, kotlin.sequences.m<? extends T> mVar, i5.p<? super R, ? super T, ? extends R> pVar, kotlin.coroutines.d<? super t> dVar) {
            super(2, dVar);
            this.f35221g = r7;
            this.f35222h = mVar;
            this.f35223i = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            t tVar = new t(this.f35221g, this.f35222h, this.f35223i, dVar);
            tVar.f35220f = obj;
            return tVar;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0053  */
        /* JADX WARN: Code duplicated, block: B:23:0x006b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:24:? A[LOOP:0: B:15:0x004d->B:24:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Object objA0;
            kotlin.sequences.o oVar2;
            Iterator it;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35219e;
            if (i7 != 0) {
                if (i7 == 1) {
                    oVar = (kotlin.sequences.o) this.f35220f;
                    e1.n(obj);
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.f35218d;
                    Object obj2 = this.f35217c;
                    oVar2 = (kotlin.sequences.o) this.f35220f;
                    e1.n(obj);
                    objA0 = obj2;
                }
                while (it.hasNext()) {
                    objA0 = this.f35223i.a0((R) objA0, (T) it.next());
                    this.f35220f = oVar2;
                    this.f35217c = objA0;
                    this.f35218d = it;
                    this.f35219e = 2;
                    if (oVar2.a(objA0, this) == objH) {
                        return objH;
                    }
                }
                return l2.f34958a;
            }
            e1.n(obj);
            oVar = (kotlin.sequences.o) this.f35220f;
            R r7 = this.f35221g;
            this.f35220f = oVar;
            this.f35219e = 1;
            if (oVar.a(r7, this) == objH) {
                return objH;
            }
            objA0 = this.f35221g;
            oVar2 = oVar;
            it = this.f35222h.iterator();
            while (it.hasNext()) {
                objA0 = this.f35223i.a0((R) objA0, (T) it.next());
                this.f35220f = oVar2;
                this.f35217c = objA0;
                this.f35218d = it;
                this.f35219e = 2;
                if (oVar2.a(objA0, this) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super R> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((t) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.u$u, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2314, 2319}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
    static final class C0438u<R> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35225d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35226e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35227f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f35228g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ R f35229h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35230i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.q<Integer, R, T, R> f35231j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0438u(R r7, kotlin.sequences.m<? extends T> mVar, i5.q<? super Integer, ? super R, ? super T, ? extends R> qVar, kotlin.coroutines.d<? super C0438u> dVar) {
            super(2, dVar);
            this.f35229h = r7;
            this.f35230i = mVar;
            this.f35231j = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            C0438u c0438u = new C0438u(this.f35229h, this.f35230i, this.f35231j, dVar);
            c0438u.f35228g = obj;
            return c0438u;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0056  */
        /* JADX WARN: Code duplicated, block: B:19:0x0060  */
        /* JADX WARN: Code duplicated, block: B:23:0x007c A[LOOP:0: B:15:0x0050->B:23:0x007c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:27:0x007b A[SYNTHETIC] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Object obj2;
            Iterator it;
            int i7;
            kotlin.sequences.o oVar2;
            int i8;
            R rV;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i9 = this.f35227f;
            if (i9 != 0) {
                if (i9 == 1) {
                    oVar = (kotlin.sequences.o) this.f35228g;
                    e1.n(obj);
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i10 = this.f35226e;
                    it = (Iterator) this.f35225d;
                    Object obj3 = this.f35224c;
                    oVar2 = (kotlin.sequences.o) this.f35228g;
                    e1.n(obj);
                    obj2 = obj3;
                    i7 = i10;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    i5.q<Integer, R, T, R> qVar = this.f35231j;
                    i8 = i7 + 1;
                    if (i7 < 0) {
                        kotlin.collections.y.X();
                    }
                    rV = qVar.v(kotlin.coroutines.jvm.internal.b.f(i7), (R) obj2, (T) next);
                    this.f35228g = oVar2;
                    this.f35224c = rV;
                    this.f35225d = it;
                    this.f35226e = i8;
                    this.f35227f = 2;
                    if (oVar2.a(rV, this) == objH) {
                        return objH;
                    }
                    obj2 = rV;
                    i7 = i8;
                }
                return l2.f34958a;
            }
            e1.n(obj);
            oVar = (kotlin.sequences.o) this.f35228g;
            R r7 = this.f35229h;
            this.f35228g = oVar;
            this.f35227f = 1;
            if (oVar.a(r7, this) == objH) {
                return objH;
            }
            obj2 = this.f35229h;
            it = this.f35230i.iterator();
            i7 = 0;
            oVar2 = oVar;
            while (it.hasNext()) {
                Object next2 = it.next();
                i5.q<Integer, R, T, R> qVar2 = this.f35231j;
                i8 = i7 + 1;
                if (i7 < 0) {
                    kotlin.collections.y.X();
                }
                rV = qVar2.v(kotlin.coroutines.jvm.internal.b.f(i7), (R) obj2, (T) next2);
                this.f35228g = oVar2;
                this.f35224c = rV;
                this.f35225d = it;
                this.f35226e = i8;
                this.f35227f = 2;
                if (oVar2.a(rV, this) == objH) {
                    return objH;
                }
                obj2 = rV;
                i7 = i8;
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super R> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((C0438u) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2344, 2347}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class v<S> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super S>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35236g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<S, T, S> f35237h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        v(kotlin.sequences.m<? extends T> mVar, i5.p<? super S, ? super T, ? extends S> pVar, kotlin.coroutines.d<? super v> dVar) {
            super(2, dVar);
            this.f35236g = mVar;
            this.f35237h = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            v vVar = new v(this.f35236g, this.f35237h, dVar);
            vVar.f35235f = obj;
            return vVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Object next;
            Iterator it;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35234e;
            if (i7 == 0) {
                e1.n(obj);
                oVar = (kotlin.sequences.o) this.f35235f;
                Iterator it2 = this.f35236g.iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    this.f35235f = oVar;
                    this.f35232c = it2;
                    this.f35233d = next;
                    this.f35234e = 1;
                    if (oVar.a(next, this) == objH) {
                        return objH;
                    }
                    it = it2;
                }
                return l2.f34958a;
            }
            if (i7 != 1 && i7 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            next = this.f35233d;
            it = (Iterator) this.f35232c;
            oVar = (kotlin.sequences.o) this.f35235f;
            e1.n(obj);
            while (it.hasNext()) {
                next = this.f35237h.a0((S) next, (T) it.next());
                this.f35235f = oVar;
                this.f35232c = it;
                this.f35233d = next;
                this.f35234e = 2;
                if (oVar.a(next, this) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super S> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((v) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2373, 2377}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    static final class w<S> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super S>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35240e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35241f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f35242g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35243h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i5.q<Integer, S, T, S> f35244i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        w(kotlin.sequences.m<? extends T> mVar, i5.q<? super Integer, ? super S, ? super T, ? extends S> qVar, kotlin.coroutines.d<? super w> dVar) {
            super(2, dVar);
            this.f35243h = mVar;
            this.f35244i = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            w wVar = new w(this.f35243h, this.f35244i, dVar);
            wVar.f35242g = obj;
            return wVar;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0066  */
        /* JADX WARN: Code duplicated, block: B:20:0x006c  */
        /* JADX WARN: Code duplicated, block: B:24:0x008c A[LOOP:0: B:16:0x0060->B:24:0x008c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:28:0x008b A[SYNTHETIC] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.sequences.o oVar;
            Iterator it;
            Object next;
            int i7;
            S sV;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = this.f35241f;
            int i9 = 1;
            if (i8 == 0) {
                e1.n(obj);
                oVar = (kotlin.sequences.o) this.f35242g;
                it = this.f35243h.iterator();
                if (it.hasNext()) {
                    next = it.next();
                    this.f35242g = oVar;
                    this.f35238c = it;
                    this.f35239d = next;
                    this.f35241f = 1;
                    if (oVar.a(next, this) == objH) {
                        return objH;
                    }
                }
                return l2.f34958a;
            }
            if (i8 == 1) {
                next = this.f35239d;
                it = (Iterator) this.f35238c;
                oVar = (kotlin.sequences.o) this.f35242g;
                e1.n(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i10 = this.f35240e;
                Object obj2 = this.f35239d;
                it = (Iterator) this.f35238c;
                oVar = (kotlin.sequences.o) this.f35242g;
                e1.n(obj);
                i9 = i10;
                next = obj2;
            }
            while (it.hasNext()) {
                i5.q<Integer, S, T, S> qVar = this.f35244i;
                i7 = i9 + 1;
                if (i9 < 0) {
                    kotlin.collections.y.X();
                }
                sV = qVar.v(kotlin.coroutines.jvm.internal.b.f(i9), (S) next, (T) it.next());
                this.f35242g = oVar;
                this.f35238c = it;
                this.f35239d = sV;
                this.f35240e = i7;
                this.f35241f = 2;
                if (oVar.a(sV, this) == objH) {
                    return objH;
                }
                next = sV;
                i9 = i7;
            }
            return l2.f34958a;
            while (it.hasNext()) {
                i5.q<Integer, S, T, S> qVar2 = this.f35244i;
                i7 = i9 + 1;
                if (i9 < 0) {
                    kotlin.collections.y.X();
                }
                sV = qVar2.v(kotlin.coroutines.jvm.internal.b.f(i9), (S) next, (T) it.next());
                this.f35242g = oVar;
                this.f35238c = it;
                this.f35239d = sV;
                this.f35240e = i7;
                this.f35241f = 2;
                if (oVar.a(sV, this) == objH) {
                    return objH;
                }
                next = sV;
                i9 = i7;
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super S> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((w) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class x<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35245a;

        /* JADX WARN: Multi-variable type inference failed */
        x(kotlin.sequences.m<? extends T> mVar) {
            this.f35245a = mVar;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            List listD3 = u.d3(this.f35245a);
            c0.k0(listD3);
            return listD3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class y<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m<T> f35246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator<? super T> f35247b;

        /* JADX WARN: Multi-variable type inference failed */
        y(kotlin.sequences.m<? extends T> mVar, Comparator<? super T> comparator) {
            this.f35246a = mVar;
            this.f35247b = comparator;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            List listD3 = u.d3(this.f35246a);
            c0.n0(listD3, this.f35247b);
            return listD3.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    static final class z<R, T> extends n0 implements i5.p<T, R, u0<? extends T, ? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f35248a = new z();

        z() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final u0<T, R> a0(T t7, R r7) {
            return p1.a(t7, r7);
        }
    }

    @kotlin.internal.f
    private static final <T> T A0(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        T t7 = null;
        for (T t8 : mVar) {
            if (predicate.z(t8).booleanValue()) {
                t7 = t8;
            }
        }
        return t7;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R> R A1(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> kotlin.sequences.m<R> A2(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return w2(mVar, r7, operation);
    }

    public static final <T> T B0(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R> R B1(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> kotlin.sequences.m<R> B2(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return x2(mVar, r7, operation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T C0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        for (T t7 : mVar) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @g1(version = "1.4")
    @a7.e
    public static final <T extends Comparable<? super T>> T C1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T C2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        return next;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    @g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R D0(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> transform) {
        R rZ;
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            rZ = transform.z(it.next());
            if (rZ != null) {
                if (rZ != null) {
                    return rZ;
                }
                throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
            }
        }
        rZ = null;
        if (rZ != null) {
            return rZ;
        }
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    @g1(version = "1.4")
    @a7.e
    public static final Double D1(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final <T> T D2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : mVar) {
            if (predicate.z(t8).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R E0(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                return rZ;
            }
        }
        return null;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Float E1(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.e
    public static final <T> T E2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @a7.e
    public static <T> T F0(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final double F1(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @a7.e
    public static final <T> T F2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        boolean z7 = false;
        T t7 = null;
        for (T t8 : mVar) {
            if (predicate.z(t8).booleanValue()) {
                if (z7) {
                    return null;
                }
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @a7.e
    public static final <T> T G0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        for (T t7 : mVar) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    @g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final float G1(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> kotlin.sequences.m<T> G2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new x(mVar);
    }

    @a7.d
    public static final <T, R> kotlin.sequences.m<R> H0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return new kotlin.sequences.i(mVar, transform, i.f35196j);
    }

    @a7.d
    @g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final <T extends Comparable<? super T>> T H1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> kotlin.sequences.m<T> H2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        return K2(mVar, new kotlin.comparisons.b.C0428b(selector));
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @t0
    @a7.d
    public static final <T, R> kotlin.sequences.m<R> I0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return kotlin.sequences.s.h(mVar, transform, j.f35197j);
    }

    @g1(version = "1.4")
    @a7.e
    public static final <T> T I1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> kotlin.sequences.m<T> I2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        return K2(mVar, new kotlin.comparisons.b.d(selector));
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C J0(kotlin.sequences.m<? extends T> mVar, C destination, i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            d0.o0(destination, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    @g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final <T> T J1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> kotlin.sequences.m<T> J2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return K2(mVar, kotlin.comparisons.b.q());
    }

    public static final <T> boolean K(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (!predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequence")
    @t0
    @a7.d
    public static final <T, R> kotlin.sequences.m<R> K0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return kotlin.sequences.s.h(mVar, transform, k.f35198j);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T K1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @a7.d
    public static <T> kotlin.sequences.m<T> K2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return new y(mVar, comparator);
    }

    public static final <T> boolean L(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar.iterator().hasNext();
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequenceTo")
    @t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C L0(kotlin.sequences.m<? extends T> mVar, C destination, i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            d0.p0(destination, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T L1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int L2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Integer> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += selector.z(it.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean M(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIterable")
    @t0
    @a7.d
    public static final <T, R> kotlin.sequences.m<R> M0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return new kotlin.sequences.i(mVar, transform, h.f35195j);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> double M1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double M2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += selector.z(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static <T> Iterable<T> N(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new a(mVar);
    }

    @g1(version = "1.4")
    @h5.h(name = "flatMapIterableTo")
    @t0
    @a7.d
    public static final <T, R, C extends Collection<? super R>> C N0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d0.o0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> float N1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Float> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(it.next()).floatValue());
        }
        return fFloatValue;
    }

    @h5.h(name = "sumOfByte")
    public static final int N2(@a7.d kotlin.sequences.m<Byte> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> kotlin.sequences.m<T> O(kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C O0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            d0.p0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R extends Comparable<? super R>> R O1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @h5.h(name = "sumOfDouble")
    public static final double O2(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final <T, K, V> Map<K, V> P(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends u0<? extends K, ? extends V>> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            u0<? extends K, ? extends V> u0VarZ = transform.z(it.next());
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    public static final <T, R> R P0(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            r7 = operation.a0(r7, it.next());
        }
        return r7;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R extends Comparable<? super R>> R P1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @t0
    @kotlin.internal.f
    private static final <T> double P2(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += selector.z(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final <T, K> Map<K, T> Q(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(mVar, "<this>");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : mVar) {
            linkedHashMap.put(keySelector.z(t7), t7);
        }
        return linkedHashMap;
    }

    public static final <T, R> R Q0(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            r7 = operation.v(Integer.valueOf(i7), r7, t7);
            i7 = i8;
        }
        return r7;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> Double Q1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @h5.h(name = "sumOfFloat")
    public static final float Q2(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T, K, V> Map<K, V> R(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        l0.p(mVar, "<this>");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : mVar) {
            linkedHashMap.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return linkedHashMap;
    }

    public static final <T> void R0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, l2> action) {
        l0.p(mVar, "<this>");
        l0.p(action, "action");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            action.z(it.next());
        }
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> Float R1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Float> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @h5.h(name = "sumOfInt")
    public static final int R2(@a7.d kotlin.sequences.m<Integer> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, ? super T>> M S(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        for (T t7 : mVar) {
            destination.put(keySelector.z(t7), t7);
        }
        return destination;
    }

    public static final <T> void S0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        l0.p(mVar, "<this>");
        l0.p(action, "action");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            action.a0(Integer.valueOf(i7), t7);
            i7 = i8;
        }
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R> R S1(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @t0
    @kotlin.internal.f
    private static final <T> int S2(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Integer> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += selector.z(it.next()).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M T(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        for (T t7 : mVar) {
            destination.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return destination;
    }

    @a7.d
    public static final <T, K> Map<K, List<T>> T0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(mVar, "<this>");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : mVar) {
            K kZ = keySelector.z(t7);
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(t7);
        }
        return linkedHashMap;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R> R T1(kotlin.sequences.m<? extends T> mVar, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @h5.h(name = "sumOfLong")
    public static final long T2(@a7.d kotlin.sequences.m<Long> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M U(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d M destination, @a7.d i5.l<? super T, ? extends u0<? extends K, ? extends V>> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            u0<? extends K, ? extends V> u0VarZ = transform.z(it.next());
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @a7.d
    public static final <T, K, V> Map<K, List<V>> U0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        l0.p(mVar, "<this>");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : mVar) {
            K kZ = keySelector.z(t7);
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(t7));
        }
        return linkedHashMap;
    }

    @g1(version = "1.4")
    @a7.e
    public static final <T extends Comparable<? super T>> T U1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @t0
    @kotlin.internal.f
    private static final <T> long U2(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Long> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += selector.z(it.next()).longValue();
        }
        return jLongValue;
    }

    @a7.d
    @g1(version = "1.3")
    public static final <K, V> Map<K, V> V(@a7.d kotlin.sequences.m<? extends K> mVar, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        l0.p(mVar, "<this>");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k7 : mVar) {
            linkedHashMap.put(k7, valueSelector.z(k7));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, List<T>>> M V0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        for (T t7 : mVar) {
            K kZ = keySelector.z(t7);
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(t7);
        }
        return destination;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Double V1(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @h5.h(name = "sumOfShort")
    public static final int V2(@a7.d kotlin.sequences.m<Short> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    @a7.d
    @g1(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M W(@a7.d kotlin.sequences.m<? extends K> mVar, @a7.d M destination, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        for (K k7 : mVar) {
            destination.put(k7, valueSelector.z(k7));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, K, V, M extends Map<? super K, List<V>>> M W0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        for (T t7 : mVar) {
            K kZ = keySelector.z(t7);
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(t7));
        }
        return destination;
    }

    @g1(version = "1.4")
    @a7.e
    public static final Float W1(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> int W2(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, w1> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            iH = w1.h(iH + selector.z(it.next()).g0());
        }
        return iH;
    }

    @h5.h(name = "averageOfByte")
    public static final double X(@a7.d kotlin.sequences.m<Byte> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Byte> it = mVar.iterator();
        double dByteValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i7);
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T, K> kotlin.collections.n0<T, K> X0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(mVar, "<this>");
        l0.p(keySelector, "keySelector");
        return new l(mVar, keySelector);
    }

    @g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final double X1(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> long X2(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, a2> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            jH = a2.h(jH + selector.z(it.next()).g0());
        }
        return jH;
    }

    @h5.h(name = "averageOfDouble")
    public static final double Y(@a7.d kotlin.sequences.m<Double> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Double> it = mVar.iterator();
        double dDoubleValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i7);
    }

    public static final <T> int Y0(@a7.d kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        int i7 = 0;
        for (T t8 : mVar) {
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            if (l0.g(t7, t8)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final float Y1(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> Y2(@a7.d kotlin.sequences.m<? extends T> mVar, int i7) {
        l0.p(mVar, "<this>");
        if (i7 >= 0) {
            if (i7 == 0) {
                return kotlin.sequences.s.g();
            }
            return mVar instanceof kotlin.sequences.e ? ((kotlin.sequences.e) mVar).a(i7) : new kotlin.sequences.w(mVar, i7);
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @h5.h(name = "averageOfFloat")
    public static final double Z(@a7.d kotlin.sequences.m<Float> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Float> it = mVar.iterator();
        double dFloatValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i7);
    }

    public static final <T> int Z0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        int i7 = 0;
        for (T t7 : mVar) {
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            if (predicate.z(t7).booleanValue()) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @a7.d
    @g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final <T extends Comparable<? super T>> T Z1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> Z2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        return new kotlin.sequences.x(mVar, predicate);
    }

    @h5.h(name = "averageOfInt")
    public static final double a0(@a7.d kotlin.sequences.m<Integer> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Integer> it = mVar.iterator();
        double dIntValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i7);
    }

    public static final <T> int a1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        int i7 = -1;
        int i8 = 0;
        for (T t7 : mVar) {
            if (i8 < 0) {
                kotlin.collections.y.X();
            }
            if (predicate.z(t7).booleanValue()) {
                i7 = i8;
            }
            i8++;
        }
        return i7;
    }

    @g1(version = "1.4")
    @a7.e
    public static final <T> T a2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C a3(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @h5.h(name = "averageOfLong")
    public static final double b0(@a7.d kotlin.sequences.m<Long> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Long> it = mVar.iterator();
        double dLongValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i7);
    }

    @a7.d
    public static final <T, A extends Appendable> A b1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) throws IOException {
        l0.p(mVar, "<this>");
        l0.p(buffer, "buffer");
        l0.p(separator, "separator");
        l0.p(prefix, "prefix");
        l0.p(postfix, "postfix");
        l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (T t7 : mVar) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            kotlin.text.t.b(buffer, t7, lVar);
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final <T> T b2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static <T> HashSet<T> b3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (HashSet) a3(mVar, new HashSet());
    }

    @h5.h(name = "averageOfShort")
    public static final double c0(@a7.d kotlin.sequences.m<Short> mVar) {
        l0.p(mVar, "<this>");
        Iterator<Short> it = mVar.iterator();
        double dShortValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i7);
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> c2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Iterable<? extends T> elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return new o(elements, mVar);
    }

    @a7.d
    public static <T> List<T> c3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return kotlin.collections.y.R(d3(mVar));
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> kotlin.sequences.m<List<T>> d0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7) {
        l0.p(mVar, "<this>");
        return g3(mVar, i7, i7, true);
    }

    @a7.d
    public static final <T> String d1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) {
        l0.p(mVar, "<this>");
        l0.p(separator, "separator");
        l0.p(prefix, "prefix");
        l0.p(postfix, "postfix");
        l0.p(truncated, "truncated");
        String string = ((StringBuilder) b1(mVar, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> d2(@a7.d kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        return new m(mVar, t7);
    }

    @a7.d
    public static final <T> List<T> d3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (List) a3(mVar, new ArrayList());
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T, R> kotlin.sequences.m<R> e0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7, @a7.d i5.l<? super List<? extends T>, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return h3(mVar, i7, i7, true, transform);
    }

    public static /* synthetic */ String e1(kotlin.sequences.m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        return d1(mVar, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> e2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d kotlin.sequences.m<? extends T> elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return new p(elements, mVar);
    }

    @a7.d
    public static final <T> Set<T> e3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final <T> boolean f0(@a7.d kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        return Y0(mVar, t7) >= 0;
    }

    public static <T> T f1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> kotlin.sequences.m<T> f2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d T[] elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return elements.length == 0 ? mVar : new n(elements, mVar);
    }

    @a7.d
    public static final <T> Set<T> f3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return n1.r((Set) a3(mVar, new LinkedHashSet()));
    }

    public static <T> int g0(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            it.next();
            i7++;
            if (i7 < 0) {
                kotlin.collections.y.W();
            }
        }
        return i7;
    }

    public static final <T> T g1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : mVar) {
            if (predicate.z(t8).booleanValue()) {
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @kotlin.internal.f
    private static final <T> kotlin.sequences.m<T> g2(kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        return d2(mVar, t7);
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> kotlin.sequences.m<List<T>> g3(@a7.d kotlin.sequences.m<? extends T> mVar, int i7, int i8, boolean z7) {
        l0.p(mVar, "<this>");
        return q1.c(mVar, i7, i8, z7, false);
    }

    public static final <T> int h0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue() && (i7 = i7 + 1) < 0) {
                kotlin.collections.y.W();
            }
        }
        return i7;
    }

    public static final <T> int h1(@a7.d kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        int i7 = -1;
        int i8 = 0;
        for (T t8 : mVar) {
            if (i8 < 0) {
                kotlin.collections.y.X();
            }
            if (l0.g(t7, t8)) {
                i7 = i8;
            }
            i8++;
        }
        return i7;
    }

    public static final <T> boolean h2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return !mVar.iterator().hasNext();
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T, R> kotlin.sequences.m<R> h3(@a7.d kotlin.sequences.m<? extends T> mVar, int i7, int i8, boolean z7, @a7.d i5.l<? super List<? extends T>, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return k1(q1.c(mVar, i7, i8, z7, true), transform);
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> i0(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return j0(mVar, b.f35183a);
    }

    @a7.e
    public static final <T> T i1(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static final <T> boolean i2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ kotlin.sequences.m i3(kotlin.sequences.m mVar, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return g3(mVar, i7, i8, z7);
    }

    @a7.d
    public static final <T, K> kotlin.sequences.m<T> j0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends K> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        return new kotlin.sequences.c(mVar, selector);
    }

    @a7.e
    public static final <T> T j1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        T t7 = null;
        for (T t8 : mVar) {
            if (predicate.z(t8).booleanValue()) {
                t7 = t8;
            }
        }
        return t7;
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T> kotlin.sequences.m<T> j2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, l2> action) {
        l0.p(mVar, "<this>");
        l0.p(action, "action");
        return k1(mVar, new q(action));
    }

    public static /* synthetic */ kotlin.sequences.m j3(kotlin.sequences.m mVar, int i7, int i8, boolean z7, i5.l lVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return h3(mVar, i7, i8, z7, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static <T> kotlin.sequences.m<T> k0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7) {
        l0.p(mVar, "<this>");
        if (i7 >= 0) {
            if (i7 == 0) {
                return mVar;
            }
            return mVar instanceof kotlin.sequences.e ? ((kotlin.sequences.e) mVar).b(i7) : new kotlin.sequences.d(mVar, i7);
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static <T, R> kotlin.sequences.m<R> k1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return new kotlin.sequences.z(mVar, transform);
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T> kotlin.sequences.m<T> k2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        l0.p(mVar, "<this>");
        l0.p(action, "action");
        return l1(mVar, new r(action));
    }

    @a7.d
    public static final <T> kotlin.sequences.m<r0<T>> k3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return new kotlin.sequences.k(mVar);
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> l0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        return new kotlin.sequences.f(mVar, predicate);
    }

    @a7.d
    public static final <T, R> kotlin.sequences.m<R> l1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return new kotlin.sequences.y(mVar, transform);
    }

    @a7.d
    public static final <T> u0<List<T>, List<T>> l2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t7 : mVar) {
            if (predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            } else {
                arrayList2.add(t7);
            }
        }
        return new u0<>(arrayList, arrayList2);
    }

    @a7.d
    public static final <T, R> kotlin.sequences.m<u0<T, R>> l3(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d kotlin.sequences.m<? extends R> other) {
        l0.p(mVar, "<this>");
        l0.p(other, "other");
        return new kotlin.sequences.l(mVar, other, z.f35248a);
    }

    public static final <T> T m0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7) {
        l0.p(mVar, "<this>");
        return (T) n0(mVar, i7, new c(i7));
    }

    @a7.d
    public static final <T, R> kotlin.sequences.m<R> m1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return v0(new kotlin.sequences.y(mVar, transform));
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> m2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d Iterable<? extends T> elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return kotlin.sequences.s.i(kotlin.sequences.s.q(mVar, g0.v1(elements)));
    }

    @a7.d
    public static final <T, R, V> kotlin.sequences.m<V> m3(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d kotlin.sequences.m<? extends R> other, @a7.d i5.p<? super T, ? super R, ? extends V> transform) {
        l0.p(mVar, "<this>");
        l0.p(other, "other");
        l0.p(transform, "transform");
        return new kotlin.sequences.l(mVar, other, transform);
    }

    public static final <T> T n0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7, @a7.d i5.l<? super Integer, ? extends T> defaultValue) {
        l0.p(mVar, "<this>");
        l0.p(defaultValue, "defaultValue");
        if (i7 < 0) {
            return defaultValue.z(Integer.valueOf(i7));
        }
        int i8 = 0;
        for (T t7 : mVar) {
            int i9 = i8 + 1;
            if (i7 == i8) {
                return t7;
            }
            i8 = i9;
        }
        return defaultValue.z(Integer.valueOf(i7));
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C n1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            R rA0 = transform.a0(Integer.valueOf(i7), t7);
            if (rA0 != null) {
                destination.add(rA0);
            }
            i7 = i8;
        }
        return destination;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> n2(@a7.d kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        return kotlin.sequences.s.i(kotlin.sequences.s.q(mVar, kotlin.sequences.s.q(t7)));
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> kotlin.sequences.m<u0<T, T>> n3(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return o3(mVar, a0.f35182a);
    }

    @a7.e
    public static final <T> T o0(@a7.d kotlin.sequences.m<? extends T> mVar, int i7) {
        l0.p(mVar, "<this>");
        if (i7 < 0) {
            return null;
        }
        int i8 = 0;
        for (T t7 : mVar) {
            int i9 = i8 + 1;
            if (i7 == i8) {
                return t7;
            }
            i8 = i9;
        }
        return null;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C o1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            destination.add(transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> o2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d kotlin.sequences.m<? extends T> elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return kotlin.sequences.s.i(kotlin.sequences.s.q(mVar, elements));
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T, R> kotlin.sequences.m<R> o3(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super T, ? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return kotlin.sequences.q.b(new b0(mVar, transform, null));
    }

    @a7.d
    public static <T> kotlin.sequences.m<T> p0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        return new kotlin.sequences.h(mVar, true, predicate);
    }

    @a7.d
    public static <T, R> kotlin.sequences.m<R> p1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(transform, "transform");
        return v0(new kotlin.sequences.z(mVar, transform));
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> p2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d T[] elements) {
        l0.p(mVar, "<this>");
        l0.p(elements, "elements");
        return m2(mVar, kotlin.collections.o.t(elements));
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> q0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        return new kotlin.sequences.z(new kotlin.sequences.h(new kotlin.sequences.k(mVar), true, new d(predicate)), e.f35192a);
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C q1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                destination.add(rZ);
            }
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> kotlin.sequences.m<T> q2(kotlin.sequences.m<? extends T> mVar, T t7) {
        l0.p(mVar, "<this>");
        return n2(mVar, t7);
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C r0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int i7 = 0;
        for (T t7 : mVar) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            if (predicate.a0(Integer.valueOf(i7), t7).booleanValue()) {
                destination.add(t7);
            }
            i7 = i8;
        }
        return destination;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C r1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            destination.add(transform.z(it.next()));
        }
        return destination;
    }

    public static final <S, T extends S> S r2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.a0(next, it.next());
        }
        return next;
    }

    public static final /* synthetic */ <R> kotlin.sequences.m<R> s0(kotlin.sequences.m<?> mVar) {
        l0.p(mVar, "<this>");
        l0.w();
        kotlin.sequences.m<R> mVarP0 = p0(mVar, f.f35193a);
        l0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return mVarP0;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T s1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    public static final <S, T extends S> S s2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty sequence can't be reduced.");
        }
        S next = it.next();
        int i7 = 1;
        while (it.hasNext()) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            next = operation.v(Integer.valueOf(i7), next, it.next());
            i7 = i8;
        }
        return next;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C t0(kotlin.sequences.m<?> mVar, C destination) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        for (Object obj : mVar) {
            l0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T t1(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @g1(version = "1.4")
    @a7.e
    public static final <S, T extends S> S t2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i7 = 1;
        while (it.hasNext()) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            next = operation.v(Integer.valueOf(i7), next, it.next());
            i7 = i8;
        }
        return next;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> u0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        return new kotlin.sequences.h(mVar, false, predicate);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> double u1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <S, T extends S> S u2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.a0(next, it.next());
        }
        return next;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> v0(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        kotlin.sequences.m<T> mVarU0 = u0(mVar, g.f35194a);
        l0.n(mVarU0, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return mVarU0;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> float v1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Float> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(it.next()).floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T> kotlin.sequences.m<T> v2(@a7.d kotlin.sequences.m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return k1(mVar, new s(mVar));
    }

    @a7.d
    public static final <C extends Collection<? super T>, T> C w0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        for (T t7 : mVar) {
            if (t7 != null) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R extends Comparable<? super R>> R w1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T, R> kotlin.sequences.m<R> w2(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return kotlin.sequences.q.b(new t(r7, mVar, operation, null));
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C x0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        for (T t7 : mVar) {
            if (!predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T, R extends Comparable<? super R>> R x1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T, R> kotlin.sequences.m<R> x2(@a7.d kotlin.sequences.m<? extends T> mVar, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return kotlin.sequences.q.b(new C0438u(r7, mVar, operation, null));
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C y0(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        for (T t7 : mVar) {
            if (predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> Double y1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Double> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <S, T extends S> kotlin.sequences.m<S> y2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return kotlin.sequences.q.b(new v(mVar, operation, null));
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @kotlin.internal.f
    private static final <T> T z0(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Boolean> predicate) {
        l0.p(mVar, "<this>");
        l0.p(predicate, "predicate");
        for (T t7 : mVar) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    @t0
    private static final <T> Float z1(kotlin.sequences.m<? extends T> mVar, i5.l<? super T, Float> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.d
    @g1(version = "1.4")
    public static final <S, T extends S> kotlin.sequences.m<S> z2(@a7.d kotlin.sequences.m<? extends T> mVar, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        l0.p(mVar, "<this>");
        l0.p(operation, "operation");
        return kotlin.sequences.q.b(new w(mVar, operation, null));
    }
}
