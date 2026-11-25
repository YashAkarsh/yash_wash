package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.p1;
import kotlin.u0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class s extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<Iterator<T>> f35157a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i5.a<? extends Iterator<? extends T>> aVar) {
            this.f35157a = aVar;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return this.f35157a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f35158a;

        public b(Iterator it) {
            this.f35158a = it;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return this.f35158a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    static final class c<R> extends kotlin.coroutines.jvm.internal.k implements i5.p<o<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35160d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35161e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f35162f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m<T> f35163g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<Integer, T, C> f35164h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i5.l<C, Iterator<R>> f35165i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(m<? extends T> mVar, i5.p<? super Integer, ? super T, ? extends C> pVar, i5.l<? super C, ? extends Iterator<? extends R>> lVar, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f35163g = mVar;
            this.f35164h = pVar;
            this.f35165i = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            c cVar = new c(this.f35163g, this.f35164h, this.f35165i, dVar);
            cVar.f35162f = obj;
            return cVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            o oVar;
            int i7;
            Iterator it;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = this.f35161e;
            if (i8 == 0) {
                e1.n(obj);
                oVar = (o) this.f35162f;
                i7 = 0;
                it = this.f35163g.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i9 = this.f35160d;
                it = (Iterator) this.f35159c;
                oVar = (o) this.f35162f;
                e1.n(obj);
                i7 = i9;
            }
            while (it.hasNext()) {
                Object next = it.next();
                i5.p<Integer, T, C> pVar = this.f35164h;
                int i10 = i7 + 1;
                if (i7 < 0) {
                    kotlin.collections.y.X();
                }
                Iterator<R> itZ = this.f35165i.z((C) pVar.a0(kotlin.coroutines.jvm.internal.b.f(i7), (T) next));
                this.f35162f = oVar;
                this.f35159c = it;
                this.f35160d = i10;
                this.f35161e = 1;
                if (oVar.g(itZ, this) == objH) {
                    return objH;
                }
                i7 = i10;
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d o<? super R> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((c) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class d<T> extends n0 implements i5.l<m<? extends T>, Iterator<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f35166a = new d();

        d() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> z(@a7.d m<? extends T> it) {
            l0.p(it, "it");
            return it.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class e<T> extends n0 implements i5.l<Iterable<? extends T>, Iterator<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35167a = new e();

        e() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> z(@a7.d Iterable<? extends T> it) {
            l0.p(it, "it");
            return it.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class f<T> extends n0 implements i5.l<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f35168a = new f();

        f() {
            super(1);
        }

        @Override // i5.l
        public final T z(T t7) {
            return t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class g<T> extends n0 implements i5.l<T, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<T> f35169a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(i5.a<? extends T> aVar) {
            super(1);
            this.f35169a = aVar;
        }

        @Override // i5.l
        @a7.e
        public final T z(@a7.d T it) {
            l0.p(it, "it");
            return this.f35169a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class h<T> extends n0 implements i5.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T f35170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(T t7) {
            super(0);
            this.f35170a = t7;
        }

        @Override // i5.a
        @a7.e
        public final T invoke() {
            return this.f35170a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {f4.d.f33916f, 71}, m = "invokeSuspend", n = {}, s = {})
    static final class i<T> extends kotlin.coroutines.jvm.internal.k implements i5.p<o<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f35171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f35172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ m<T> f35173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i5.a<m<T>> f35174f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(m<? extends T> mVar, i5.a<? extends m<? extends T>> aVar, kotlin.coroutines.d<? super i> dVar) {
            super(2, dVar);
            this.f35173e = mVar;
            this.f35174f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            i iVar = new i(this.f35173e, this.f35174f, dVar);
            iVar.f35172d = obj;
            return iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35171c;
            if (i7 == 0) {
                e1.n(obj);
                o oVar = (o) this.f35172d;
                Iterator<? extends T> it = this.f35173e.iterator();
                if (it.hasNext()) {
                    this.f35171c = 1;
                    if (oVar.g(it, this) == objH) {
                        return objH;
                    }
                } else {
                    m<T> mVarInvoke = this.f35174f.invoke();
                    this.f35171c = 2;
                    if (oVar.h(mVarInvoke, this) == objH) {
                        return objH;
                    }
                }
            } else {
                if (i7 != 1 && i7 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d o<? super T> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((i) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    static final class j<T> extends kotlin.coroutines.jvm.internal.k implements i5.p<o<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f35175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f35177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m<T> f35178f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.random.f f35179g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(m<? extends T> mVar, kotlin.random.f fVar, kotlin.coroutines.d<? super j> dVar) {
            super(2, dVar);
            this.f35178f = mVar;
            this.f35179g = fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            j jVar = new j(this.f35178f, this.f35179g, dVar);
            jVar.f35177e = obj;
            return jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            List listD3;
            o oVar;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f35176d;
            if (i7 == 0) {
                e1.n(obj);
                o oVar2 = (o) this.f35177e;
                listD3 = u.d3(this.f35178f);
                oVar = oVar2;
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                listD3 = (List) this.f35175c;
                o oVar3 = (o) this.f35177e;
                e1.n(obj);
                oVar = oVar3;
            }
            while (!listD3.isEmpty()) {
                int iM = this.f35179g.m(listD3.size());
                Object objL0 = d0.L0(listD3);
                if (iM < listD3.size()) {
                    objL0 = listD3.set(iM, objL0);
                }
                this.f35177e = oVar;
                this.f35175c = listD3;
                this.f35176d = 1;
                if (oVar.a(objL0, this) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d o<? super T> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((j) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.internal.f
    private static final <T> m<T> d(i5.a<? extends Iterator<? extends T>> iterator) {
        l0.p(iterator, "iterator");
        return new a(iterator);
    }

    @a7.d
    public static <T> m<T> e(@a7.d Iterator<? extends T> it) {
        l0.p(it, "<this>");
        return f(new b(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static <T> m<T> f(@a7.d m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return mVar instanceof kotlin.sequences.a ? mVar : new kotlin.sequences.a(mVar);
    }

    @a7.d
    public static <T> m<T> g() {
        return kotlin.sequences.g.f35118a;
    }

    @a7.d
    public static final <T, C, R> m<R> h(@a7.d m<? extends T> source, @a7.d i5.p<? super Integer, ? super T, ? extends C> transform, @a7.d i5.l<? super C, ? extends Iterator<? extends R>> iterator) {
        l0.p(source, "source");
        l0.p(transform, "transform");
        l0.p(iterator, "iterator");
        return q.b(new c(source, transform, iterator, null));
    }

    @a7.d
    public static final <T> m<T> i(@a7.d m<? extends m<? extends T>> mVar) {
        l0.p(mVar, "<this>");
        return j(mVar, d.f35166a);
    }

    private static final <T, R> m<R> j(m<? extends T> mVar, i5.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return mVar instanceof z ? ((z) mVar).e(lVar) : new kotlin.sequences.i(mVar, f.f35168a, lVar);
    }

    @a7.d
    @h5.h(name = "flattenSequenceOfIterable")
    public static final <T> m<T> k(@a7.d m<? extends Iterable<? extends T>> mVar) {
        l0.p(mVar, "<this>");
        return j(mVar, e.f35167a);
    }

    @a7.d
    public static final <T> m<T> l(@a7.d i5.a<? extends T> nextFunction) {
        l0.p(nextFunction, "nextFunction");
        return f(new kotlin.sequences.j(nextFunction, new g(nextFunction)));
    }

    @a7.d
    public static <T> m<T> m(@a7.d i5.a<? extends T> seedFunction, @a7.d i5.l<? super T, ? extends T> nextFunction) {
        l0.p(seedFunction, "seedFunction");
        l0.p(nextFunction, "nextFunction");
        return new kotlin.sequences.j(seedFunction, nextFunction);
    }

    @a7.d
    @kotlin.internal.h
    public static <T> m<T> n(@a7.e T t7, @a7.d i5.l<? super T, ? extends T> nextFunction) {
        l0.p(nextFunction, "nextFunction");
        return t7 == null ? kotlin.sequences.g.f35118a : new kotlin.sequences.j(new h(t7), nextFunction);
    }

    @a7.d
    @g1(version = "1.3")
    public static final <T> m<T> o(@a7.d m<? extends T> mVar, @a7.d i5.a<? extends m<? extends T>> defaultValue) {
        l0.p(mVar, "<this>");
        l0.p(defaultValue, "defaultValue");
        return q.b(new i(mVar, defaultValue, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> m<T> p(m<? extends T> mVar) {
        return mVar == 0 ? g() : mVar;
    }

    @a7.d
    public static final <T> m<T> q(@a7.d T... elements) {
        l0.p(elements, "elements");
        return elements.length == 0 ? g() : kotlin.collections.p.l6(elements);
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T> m<T> r(@a7.d m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return s(mVar, kotlin.random.f.f34998a);
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T> m<T> s(@a7.d m<? extends T> mVar, @a7.d kotlin.random.f random) {
        l0.p(mVar, "<this>");
        l0.p(random, "random");
        return q.b(new j(mVar, random, null));
    }

    @a7.d
    public static final <T, R> u0<List<T>, List<R>> t(@a7.d m<? extends u0<? extends T, ? extends R>> mVar) {
        l0.p(mVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (u0<? extends T, ? extends R> u0Var : mVar) {
            arrayList.add(u0Var.e());
            arrayList2.add(u0Var.f());
        }
        return p1.a(arrayList, arrayList2);
    }
}
