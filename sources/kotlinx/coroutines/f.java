package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {}, l = {54}, m = "joinAll", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f35991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35994h;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35993g = obj;
            this.f35994h |= Integer.MIN_VALUE;
            return f.d(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {}, l = {66}, m = "joinAll", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f35996e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35997f;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35996e = obj;
            this.f35997f |= Integer.MIN_VALUE;
            return f.c(null, this);
        }
    }

    @a7.e
    public static final <T> Object a(@a7.d Collection<? extends d1<? extends T>> collection, @a7.d kotlin.coroutines.d<? super List<? extends T>> dVar) {
        if (collection.isEmpty()) {
            return kotlin.collections.y.F();
        }
        Object[] array = collection.toArray(new d1[0]);
        if (array != null) {
            return new e((d1[]) array).b(dVar);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @a7.e
    public static final <T> Object b(@a7.d d1<? extends T>[] d1VarArr, @a7.d kotlin.coroutines.d<? super List<? extends T>> dVar) {
        return d1VarArr.length == 0 ? kotlin.collections.y.F() : new e(d1VarArr).b(dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final Object c(@a7.d Collection<? extends o2> collection, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        b bVar;
        Iterator it;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i7 = bVar.f35997f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                bVar.f35997f = i7 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.f35996e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = bVar.f35997f;
        if (i8 == 0) {
            kotlin.e1.n(obj);
            it = collection.iterator();
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) bVar.f35995d;
            kotlin.e1.n(obj);
        }
        while (it.hasNext()) {
            o2 o2Var = (o2) it.next();
            bVar.f35995d = it;
            bVar.f35997f = 1;
            if (o2Var.H(bVar) == objH) {
                return objH;
            }
        }
        return kotlin.l2.f34958a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final Object d(@a7.d o2[] o2VarArr, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        a aVar;
        int i7;
        o2[] o2VarArr2;
        int length;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i8 = aVar.f35994h;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.f35994h = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f35993g;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i9 = aVar.f35994h;
        if (i9 == 0) {
            kotlin.e1.n(obj);
            i7 = 0;
            o2VarArr2 = o2VarArr;
            length = o2VarArr.length;
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = aVar.f35992f;
            i7 = aVar.f35991e;
            o2[] o2VarArr3 = (o2[]) aVar.f35990d;
            kotlin.e1.n(obj);
            o2VarArr2 = o2VarArr3;
        }
        while (i7 < length) {
            o2 o2Var = o2VarArr2[i7];
            i7++;
            aVar.f35990d = o2VarArr2;
            aVar.f35991e = i7;
            aVar.f35992f = length;
            aVar.f35994h = 1;
            if (o2Var.H(aVar) == objH) {
                return objH;
            }
        }
        return kotlin.l2.f34958a;
    }
}
