package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.e2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class l {

    public static final class a implements kotlinx.coroutines.flow.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.ranges.n f36435a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.l$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d19"}, s = {"L$0"})
        public static final class C0473a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36436d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36437e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36439g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36440h;

            public C0473a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36436d = obj;
                this.f36437e |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public a(kotlin.ranges.n nVar) {
            this.f36435a = nVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super Long> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            C0473a c0473a;
            kotlinx.coroutines.flow.j jVar2;
            Iterator<Long> it;
            if (dVar instanceof C0473a) {
                c0473a = (C0473a) dVar;
                int i7 = c0473a.f36437e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    c0473a.f36437e = i7 - Integer.MIN_VALUE;
                } else {
                    c0473a = new C0473a(dVar);
                }
            } else {
                c0473a = new C0473a(dVar);
            }
            Object obj = c0473a.f36436d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = c0473a.f36437e;
            if (i8 == 0) {
                e1.n(obj);
                jVar2 = jVar;
                it = this.f36435a.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c0473a.f36440h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) c0473a.f36439g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (it.hasNext()) {
                Long lG = kotlin.coroutines.jvm.internal.b.g(((kotlin.collections.v0) it).b());
                c0473a.f36439g = jVar2;
                c0473a.f36440h = it;
                c0473a.f36437e = 1;
                if (jVar2.f(lG, c0473a) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a f36441a;

        public b(i5.a aVar) {
            this.f36441a = aVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objF = jVar.f((Object) this.f36441a.invoke(), dVar);
            return objF == kotlin.coroutines.intrinsics.d.h() ? objF : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l f36442a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", i = {}, l = {113, 113}, m = "collect", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36443d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36444e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36446g;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36443d = obj;
                this.f36444e |= Integer.MIN_VALUE;
                return c.this.a(null, this);
            }
        }

        public c(i5.l lVar) {
            this.f36442a = lVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36444e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36444e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object objZ = aVar.f36443d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36444e;
            if (i8 != 0) {
                if (i8 == 1) {
                    jVar = (kotlinx.coroutines.flow.j) aVar.f36446g;
                    e1.n(objZ);
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(objZ);
                }
                return l2.f34958a;
            }
            e1.n(objZ);
            i5.l lVar = this.f36442a;
            aVar.f36446g = jVar;
            aVar.f36444e = 1;
            kotlin.jvm.internal.i0.e(6);
            objZ = lVar.z(aVar);
            kotlin.jvm.internal.i0.e(7);
            if (objZ == objH) {
                return objH;
            }
            aVar.f36446g = null;
            aVar.f36444e = 2;
            if (jVar.f(objZ, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f36447a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d3"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36448d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36449e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36451g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36452h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36448d = obj;
                this.f36449e |= Integer.MIN_VALUE;
                return d.this.a(null, this);
            }
        }

        public d(Iterable iterable) {
            this.f36447a = iterable;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            kotlinx.coroutines.flow.j jVar2;
            Iterator<T> it;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36449e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36449e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36448d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36449e;
            if (i8 == 0) {
                e1.n(obj);
                jVar2 = jVar;
                it = this.f36447a.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.f36452h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36451g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (it.hasNext()) {
                T next = it.next();
                aVar.f36451g = jVar2;
                aVar.f36452h = it;
                aVar.f36449e = 1;
                if (jVar2.f(next, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f36453a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d5"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36454d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36455e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36457g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36458h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36454d = obj;
                this.f36455e |= Integer.MIN_VALUE;
                return e.this.a(null, this);
            }
        }

        public e(Iterator it) {
            this.f36453a = it;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            kotlinx.coroutines.flow.j jVar2;
            Iterator it;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36455e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36455e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36454d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36455e;
            if (i8 == 0) {
                e1.n(obj);
                jVar2 = jVar;
                it = this.f36453a;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.f36458h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36457g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (it.hasNext()) {
                Object next = it.next();
                aVar.f36457g = jVar2;
                aVar.f36458h = it;
                aVar.f36455e = 1;
                if (jVar2.f(next, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f36459a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d7"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36460d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36461e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36463g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36464h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36460d = obj;
                this.f36461e |= Integer.MIN_VALUE;
                return f.this.a(null, this);
            }
        }

        public f(kotlin.sequences.m mVar) {
            this.f36459a = mVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            kotlinx.coroutines.flow.j jVar2;
            Iterator<T> it;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36461e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36461e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36460d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36461e;
            if (i8 == 0) {
                e1.n(obj);
                jVar2 = jVar;
                it = this.f36459a.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.f36464h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36463g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (it.hasNext()) {
                T next = it.next();
                aVar.f36463g = jVar2;
                aVar.f36464h = it;
                aVar.f36461e = 1;
                if (jVar2.f(next, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f36465a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d11"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36466d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36467e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36469g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36470h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f36471i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36472j;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36466d = obj;
                this.f36467e |= Integer.MIN_VALUE;
                return g.this.a(null, this);
            }
        }

        public g(Object[] objArr) {
            this.f36465a = objArr;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            int i7;
            Object[] objArr;
            kotlinx.coroutines.flow.j jVar2;
            int i8;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i9 = aVar.f36467e;
                if ((i9 & Integer.MIN_VALUE) != 0) {
                    aVar.f36467e = i9 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36466d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i10 = aVar.f36467e;
            if (i10 == 0) {
                e1.n(obj);
                Object[] objArr2 = this.f36465a;
                int length = objArr2.length;
                i7 = 0;
                objArr = objArr2;
                jVar2 = jVar;
                i8 = length;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i8 = aVar.f36472j;
                int i11 = aVar.f36471i;
                Object[] objArr3 = (Object[]) aVar.f36470h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36469g;
                e1.n(obj);
                jVar2 = jVar3;
                objArr = objArr3;
                i7 = i11;
            }
            Object[] objArr4 = objArr;
            while (i7 < i8) {
                Object obj2 = objArr4[i7];
                i7++;
                aVar.f36469g = jVar2;
                aVar.f36470h = objArr4;
                aVar.f36471i = i7;
                aVar.f36472j = i8;
                aVar.f36467e = 1;
                if (jVar2.f(obj2, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    public static final class h implements kotlinx.coroutines.flow.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f36473a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d13"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36474d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36475e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36477g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36478h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f36479i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36480j;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36474d = obj;
                this.f36475e |= Integer.MIN_VALUE;
                return h.this.a(null, this);
            }
        }

        public h(int[] iArr) {
            this.f36473a = iArr;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super Integer> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            int i7;
            int[] iArr;
            kotlinx.coroutines.flow.j jVar2;
            int i8;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i9 = aVar.f36475e;
                if ((i9 & Integer.MIN_VALUE) != 0) {
                    aVar.f36475e = i9 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36474d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i10 = aVar.f36475e;
            if (i10 == 0) {
                e1.n(obj);
                int[] iArr2 = this.f36473a;
                int length = iArr2.length;
                i7 = 0;
                iArr = iArr2;
                jVar2 = jVar;
                i8 = length;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i8 = aVar.f36480j;
                int i11 = aVar.f36479i;
                int[] iArr3 = (int[]) aVar.f36478h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36477g;
                e1.n(obj);
                jVar2 = jVar3;
                iArr = iArr3;
                i7 = i11;
            }
            int[] iArr4 = iArr;
            while (i7 < i8) {
                int i12 = iArr4[i7];
                i7++;
                Integer numF = kotlin.coroutines.jvm.internal.b.f(i12);
                aVar.f36477g = jVar2;
                aVar.f36478h = iArr4;
                aVar.f36479i = i7;
                aVar.f36480j = i8;
                aVar.f36475e = 1;
                if (jVar2.f(numF, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    public static final class i implements kotlinx.coroutines.flow.i<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f36481a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d15"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36482d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36483e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36485g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36486h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f36487i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36488j;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36482d = obj;
                this.f36483e |= Integer.MIN_VALUE;
                return i.this.a(null, this);
            }
        }

        public i(long[] jArr) {
            this.f36481a = jArr;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super Long> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            int i7;
            long[] jArr;
            kotlinx.coroutines.flow.j jVar2;
            int i8;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i9 = aVar.f36483e;
                if ((i9 & Integer.MIN_VALUE) != 0) {
                    aVar.f36483e = i9 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36482d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i10 = aVar.f36483e;
            if (i10 == 0) {
                e1.n(obj);
                long[] jArr2 = this.f36481a;
                int length = jArr2.length;
                i7 = 0;
                jArr = jArr2;
                jVar2 = jVar;
                i8 = length;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i8 = aVar.f36488j;
                int i11 = aVar.f36487i;
                long[] jArr3 = (long[]) aVar.f36486h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36485g;
                e1.n(obj);
                jVar2 = jVar3;
                jArr = jArr3;
                i7 = i11;
            }
            long[] jArr4 = jArr;
            while (i7 < i8) {
                long j7 = jArr4[i7];
                i7++;
                Long lG = kotlin.coroutines.jvm.internal.b.g(j7);
                aVar.f36485g = jVar2;
                aVar.f36486h = jArr4;
                aVar.f36487i = i7;
                aVar.f36488j = i8;
                aVar.f36483e = 1;
                if (jVar2.f(lG, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    public static final class j implements kotlinx.coroutines.flow.i<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.ranges.k f36489a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", f = "Builders.kt", i = {0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2d17"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36490d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36491e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36493g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36494h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36490d = obj;
                this.f36491e |= Integer.MIN_VALUE;
                return j.this.a(null, this);
            }
        }

        public j(kotlin.ranges.k kVar) {
            this.f36489a = kVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super Integer> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            kotlinx.coroutines.flow.j jVar2;
            Iterator<Integer> it;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36491e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36491e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36490d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36491e;
            if (i8 == 0) {
                e1.n(obj);
                jVar2 = jVar;
                it = this.f36489a.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) aVar.f36494h;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36493g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (it.hasNext()) {
                Integer numF = kotlin.coroutines.jvm.internal.b.f(((kotlin.collections.u0) it).b());
                aVar.f36493g = jVar2;
                aVar.f36494h = it;
                aVar.f36491e = 1;
                if (jVar2.f(numF, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class k<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f36495a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0, 0}, l = {114}, m = "collect", n = {"this", "$this$flowOf_u24lambda_u2d8"}, s = {"L$0", "L$1"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36496d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36497e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36499g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36500h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f36501i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36502j;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36496d = obj;
                this.f36497e |= Integer.MIN_VALUE;
                return k.this.a(null, this);
            }
        }

        public k(Object[] objArr) {
            this.f36495a = objArr;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            int i7;
            k<T> kVar;
            kotlinx.coroutines.flow.j jVar2;
            int length;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i8 = aVar.f36497e;
                if ((i8 & Integer.MIN_VALUE) != 0) {
                    aVar.f36497e = i8 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36496d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i9 = aVar.f36497e;
            if (i9 == 0) {
                e1.n(obj);
                i7 = 0;
                kVar = this;
                jVar2 = jVar;
                length = this.f36495a.length;
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                length = aVar.f36502j;
                i7 = aVar.f36501i;
                kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36500h;
                kVar = (k) aVar.f36499g;
                e1.n(obj);
                jVar2 = jVar3;
            }
            while (i7 < length) {
                Object obj2 = kVar.f36495a[i7];
                i7++;
                aVar.f36499g = kVar;
                aVar.f36500h = jVar2;
                aVar.f36501i = i7;
                aVar.f36502j = length;
                aVar.f36497e = 1;
                if (jVar2.f(obj2, aVar) == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.l$l, reason: collision with other inner class name */
    public static final class C0474l<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f36503a;

        public C0474l(Object obj) {
            this.f36503a = obj;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objF = jVar.f((Object) this.f36503a, dVar);
            return objF == kotlin.coroutines.intrinsics.d.h() ? objF : l2.f34958a;
        }
    }

    @a7.d
    @e2
    public static final <T> kotlinx.coroutines.flow.i<T> a(@a7.d i5.a<? extends T> aVar) {
        return new b(aVar);
    }

    @a7.d
    @e2
    public static final <T> kotlinx.coroutines.flow.i<T> b(@a7.d i5.l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
        return new c(lVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> c(@a7.d Iterable<? extends T> iterable) {
        return new d(iterable);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> d(@a7.d Iterator<? extends T> it) {
        return new e(it);
    }

    @a7.d
    public static final kotlinx.coroutines.flow.i<Integer> e(@a7.d kotlin.ranges.k kVar) {
        return new j(kVar);
    }

    @a7.d
    public static final kotlinx.coroutines.flow.i<Long> f(@a7.d kotlin.ranges.n nVar) {
        return new a(nVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> g(@a7.d kotlin.sequences.m<? extends T> mVar) {
        return new f(mVar);
    }

    @a7.d
    public static final kotlinx.coroutines.flow.i<Integer> h(@a7.d int[] iArr) {
        return new h(iArr);
    }

    @a7.d
    public static final kotlinx.coroutines.flow.i<Long> i(@a7.d long[] jArr) {
        return new i(jArr);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> j(@a7.d T[] tArr) {
        return new g(tArr);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> k(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new kotlinx.coroutines.flow.b(pVar, null, 0, null, 14, null);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> l(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new kotlinx.coroutines.flow.f(pVar, null, 0, null, 14, null);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> m() {
        return kotlinx.coroutines.flow.h.f36259a;
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> n(@a7.d @kotlin.b i5.p<? super kotlinx.coroutines.flow.j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new h0(pVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> o(T t7) {
        return new C0474l(t7);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> p(@a7.d T... tArr) {
        return new k(tArr);
    }
}
