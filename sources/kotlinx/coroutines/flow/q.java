package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class q {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {18}, m = "count", n = {"i"}, s = {"L$0"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36539d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36540e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36541f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36540e = obj;
            this.f36541f |= Integer.MIN_VALUE;
            return k.Z(null, this);
        }
    }

    static final class b<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.f f36542a;

        b(k1.f fVar) {
            this.f36542a = fVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36542a.f34870a++;
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {30}, m = "count", n = {"i"}, s = {"L$0"})
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36545f;

        c(kotlin.coroutines.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36544e = obj;
            this.f36545f |= Integer.MIN_VALUE;
            return k.Y(null, null, this);
        }
    }

    static final class d<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> f36546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.f f36547b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", i = {0}, l = {31}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36548d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36549e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d<T> f36550f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f36551g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(d<? super T> dVar, kotlin.coroutines.d<? super a> dVar2) {
                super(dVar2);
                this.f36550f = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36549e = obj;
                this.f36551g |= Integer.MIN_VALUE;
                return this.f36550f.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, k1.f fVar) {
            this.f36546a = pVar;
            this.f36547b = fVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            d<T> dVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36551g;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36551g = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object objA0 = aVar.f36549e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36551g;
            if (i8 == 0) {
                e1.n(objA0);
                i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> pVar = this.f36546a;
                aVar.f36548d = this;
                aVar.f36551g = 1;
                objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                dVar2 = this;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dVar2 = (d) aVar.f36548d;
                e1.n(objA0);
            }
            if (((Boolean) objA0).booleanValue()) {
                dVar2.f36547b.f34870a++;
            }
            return l2.f34958a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object a(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super Integer> dVar) {
        c cVar;
        k1.f fVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i7 = cVar.f36545f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                cVar.f36545f = i7 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.f36544e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = cVar.f36545f;
        if (i8 == 0) {
            e1.n(obj);
            k1.f fVar2 = new k1.f();
            j<? super Object> dVar2 = new d<>(pVar, fVar2);
            cVar.f36543d = fVar2;
            cVar.f36545f = 1;
            if (iVar.a(dVar2, cVar) == objH) {
                return objH;
            }
            fVar = fVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) cVar.f36543d;
            e1.n(obj);
        }
        return kotlin.coroutines.jvm.internal.b.f(fVar.f34870a);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object b(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super Integer> dVar) {
        a aVar;
        k1.f fVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36541f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36541f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f36540e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36541f;
        if (i8 == 0) {
            e1.n(obj);
            k1.f fVar2 = new k1.f();
            j<? super Object> bVar = new b<>(fVar2);
            aVar.f36539d = fVar2;
            aVar.f36541f = 1;
            if (iVar.a(bVar, aVar) == objH) {
                return objH;
            }
            fVar = fVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) aVar.f36539d;
            e1.n(obj);
        }
        return kotlin.coroutines.jvm.internal.b.f(fVar.f34870a);
    }
}
