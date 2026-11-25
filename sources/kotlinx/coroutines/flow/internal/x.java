package kotlinx.coroutines.flow.internal;

import kotlin.a1;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    static final class a extends n0 implements i5.p<Integer, kotlin.coroutines.g.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v<?> f36405a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(v<?> vVar) {
            super(2);
            this.f36405a = vVar;
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ Integer a0(Integer num, kotlin.coroutines.g.b bVar) {
            return b(num.intValue(), bVar);
        }

        @a7.d
        public final Integer b(int i7, @a7.d kotlin.coroutines.g.b bVar) {
            kotlin.coroutines.g.c<?> key = bVar.getKey();
            kotlin.coroutines.g.b bVar2 = this.f36405a.f36398e.get(key);
            if (key != o2.f37103s0) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i7 + 1);
            }
            o2 o2Var = (o2) bVar2;
            o2 o2VarB = x.b((o2) bVar, o2Var);
            if (o2VarB == o2Var) {
                if (o2Var != null) {
                    i7++;
                }
                return Integer.valueOf(i7);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + o2VarB + ", expected child of " + o2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.d<? super l2>, Object> f36406a;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36407d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36409f;

            public a(kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36407d = obj;
                this.f36409f |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(i5.p<? super kotlinx.coroutines.flow.j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
            this.f36406a = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA0 = this.f36406a.a0(jVar, dVar);
            return objA0 == kotlin.coroutines.intrinsics.d.h() ? objA0 : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            i0.e(4);
            new a(dVar);
            i0.e(5);
            this.f36406a.a0(jVar, dVar);
            return l2.f34958a;
        }
    }

    @h5.h(name = "checkContext")
    public static final void a(@a7.d v<?> vVar, @a7.d kotlin.coroutines.g gVar) {
        if (((Number) gVar.fold(0, new a(vVar))).intValue() == vVar.f36399f) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + vVar.f36398e + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @a7.e
    public static final o2 b(@a7.e o2 o2Var, @a7.e o2 o2Var2) {
        while (o2Var != null) {
            if (o2Var == o2Var2) {
                return o2Var;
            }
            if (!(o2Var instanceof kotlinx.coroutines.internal.n0)) {
                return o2Var;
            }
            o2Var = ((kotlinx.coroutines.internal.n0) o2Var).F1();
        }
        return null;
    }

    @a7.d
    @a1
    public static final <T> kotlinx.coroutines.flow.i<T> c(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.flow.j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new b(pVar);
    }
}
