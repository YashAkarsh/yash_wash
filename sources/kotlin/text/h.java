package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;
import kotlin.u0;

/* JADX INFO: loaded from: classes2.dex */
final class h implements kotlin.sequences.m<kotlin.ranges.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final CharSequence f35364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final i5.p<CharSequence, Integer, u0<Integer, Integer>> f35367d;

    public static final class a implements Iterator<kotlin.ranges.k>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f35368a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.e
        private kotlin.ranges.k f35371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35372e;

        a() {
            int iB = kotlin.ranges.q.B(h.this.f35365b, 0, h.this.f35364a.length());
            this.f35369b = iB;
            this.f35370c = iB;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        private final void a() {
            u0 u0Var;
            if (this.f35370c < 0) {
                this.f35368a = 0;
                this.f35371d = null;
                return;
            }
            if (h.this.f35366c > 0) {
                int i7 = this.f35372e + 1;
                this.f35372e = i7;
                if (i7 >= h.this.f35366c) {
                    this.f35371d = new kotlin.ranges.k(this.f35369b, c0.i3(h.this.f35364a));
                    this.f35370c = -1;
                } else if (this.f35370c > h.this.f35364a.length() && (u0Var = (u0) h.this.f35367d.a0(h.this.f35364a, Integer.valueOf(this.f35370c))) != null) {
                    int iIntValue = ((Number) u0Var.a()).intValue();
                    int iIntValue2 = ((Number) u0Var.b()).intValue();
                    this.f35371d = kotlin.ranges.q.z1(this.f35369b, iIntValue);
                    int i8 = iIntValue + iIntValue2;
                    this.f35369b = i8;
                    this.f35370c = i8 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f35371d = new kotlin.ranges.k(this.f35369b, c0.i3(h.this.f35364a));
                    this.f35370c = -1;
                }
            } else if (this.f35370c > h.this.f35364a.length()) {
                this.f35371d = new kotlin.ranges.k(this.f35369b, c0.i3(h.this.f35364a));
                this.f35370c = -1;
            } else {
                int iIntValue3 = ((Number) u0Var.a()).intValue();
                int iIntValue4 = ((Number) u0Var.b()).intValue();
                this.f35371d = kotlin.ranges.q.z1(this.f35369b, iIntValue3);
                int i9 = iIntValue3 + iIntValue4;
                this.f35369b = i9;
                this.f35370c = i9 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.f35368a = 1;
        }

        public final int b() {
            return this.f35372e;
        }

        public final int d() {
            return this.f35369b;
        }

        @a7.e
        public final kotlin.ranges.k e() {
            return this.f35371d;
        }

        public final int f() {
            return this.f35370c;
        }

        public final int g() {
            return this.f35368a;
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public kotlin.ranges.k next() {
            if (this.f35368a == -1) {
                a();
            }
            if (this.f35368a == 0) {
                throw new NoSuchElementException();
            }
            kotlin.ranges.k kVar = this.f35371d;
            l0.n(kVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f35371d = null;
            this.f35368a = -1;
            return kVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35368a == -1) {
                a();
            }
            return this.f35368a == 1;
        }

        public final void i(int i7) {
            this.f35372e = i7;
        }

        public final void j(int i7) {
            this.f35369b = i7;
        }

        public final void k(@a7.e kotlin.ranges.k kVar) {
            this.f35371d = kVar;
        }

        public final void l(int i7) {
            this.f35370c = i7;
        }

        public final void m(int i7) {
            this.f35368a = i7;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@a7.d CharSequence input, int i7, int i8, @a7.d i5.p<? super CharSequence, ? super Integer, u0<Integer, Integer>> getNextMatch) {
        l0.p(input, "input");
        l0.p(getNextMatch, "getNextMatch");
        this.f35364a = input;
        this.f35365b = i7;
        this.f35366c = i8;
        this.f35367d = getNextMatch;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<kotlin.ranges.k> iterator() {
        return new a();
    }
}
