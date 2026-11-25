package kotlin.coroutines;

import i5.p;
import java.io.Serializable;
import kotlin.g1;
import kotlin.jvm.internal.k1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public final class c implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final g f34669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final g.b f34670b;

    private static final class a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final C0429a f34671b = new C0429a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f34672c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final g[] f34673a;

        /* JADX INFO: renamed from: kotlin.coroutines.c$a$a, reason: collision with other inner class name */
        public static final class C0429a {
            public /* synthetic */ C0429a(w wVar) {
                this();
            }

            private C0429a() {
            }
        }

        public a(@a7.d g[] elements) {
            l0.p(elements, "elements");
            this.f34673a = elements;
        }

        private final Object readResolve() {
            g[] gVarArr = this.f34673a;
            g gVarPlus = i.f34682a;
            for (g gVar : gVarArr) {
                gVarPlus = gVarPlus.plus(gVar);
            }
            return gVarPlus;
        }

        @a7.d
        public final g[] a() {
            return this.f34673a;
        }
    }

    static final class b extends n0 implements p<String, g.b, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34674a = new b();

        b() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String a0(@a7.d String acc, @a7.d g.b element) {
            l0.p(acc, "acc");
            l0.p(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    /* JADX INFO: renamed from: kotlin.coroutines.c$c, reason: collision with other inner class name */
    static final class C0430c extends n0 implements p<l2, g.b, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g[] f34675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.f f34676b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0430c(g[] gVarArr, k1.f fVar) {
            super(2);
            this.f34675a = gVarArr;
            this.f34676b = fVar;
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ l2 a0(l2 l2Var, g.b bVar) {
            b(l2Var, bVar);
            return l2.f34958a;
        }

        public final void b(@a7.d l2 l2Var, @a7.d g.b element) {
            l0.p(l2Var, "<anonymous parameter 0>");
            l0.p(element, "element");
            g[] gVarArr = this.f34675a;
            k1.f fVar = this.f34676b;
            int i7 = fVar.f34870a;
            fVar.f34870a = i7 + 1;
            gVarArr[i7] = element;
        }
    }

    public c(@a7.d g left, @a7.d g.b element) {
        l0.p(left, "left");
        l0.p(element, "element");
        this.f34669a = left;
        this.f34670b = element;
    }

    private final boolean a(g.b bVar) {
        return l0.g(get(bVar.getKey()), bVar);
    }

    private final boolean d(c cVar) {
        while (a(cVar.f34670b)) {
            g gVar = cVar.f34669a;
            if (!(gVar instanceof c)) {
                l0.n(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int h() {
        int i7 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f34669a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i7;
            }
            i7++;
        }
    }

    private final Object writeReplace() {
        int iH = h();
        g[] gVarArr = new g[iH];
        k1.f fVar = new k1.f();
        fold(l2.f34958a, new C0430c(gVarArr, fVar));
        if (fVar.f34870a == iH) {
            return new a(gVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(@a7.e Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.h() != h() || !cVar.d(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d p<? super R, ? super g.b, ? extends R> operation) {
        l0.p(operation, "operation");
        return operation.a0((Object) this.f34669a.fold(r7, operation), this.f34670b);
    }

    @Override // kotlin.coroutines.g
    @a7.e
    public <E extends g.b> E get(@a7.d g.c<E> key) {
        l0.p(key, "key");
        c cVar = this;
        while (true) {
            E e8 = (E) cVar.f34670b.get(key);
            if (e8 != null) {
                return e8;
            }
            g gVar = cVar.f34669a;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(key);
            }
            cVar = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f34669a.hashCode() + this.f34670b.hashCode();
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public g minusKey(@a7.d g.c<?> key) {
        l0.p(key, "key");
        if (this.f34670b.get(key) != null) {
            return this.f34669a;
        }
        g gVarMinusKey = this.f34669a.minusKey(key);
        if (gVarMinusKey == this.f34669a) {
            return this;
        }
        return gVarMinusKey == i.f34682a ? this.f34670b : new c(gVarMinusKey, this.f34670b);
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public g plus(@a7.d g gVar) {
        return g.a.a(this, gVar);
    }

    @a7.d
    public String toString() {
        return '[' + ((String) fold("", b.f34674a)) + ']';
    }
}
