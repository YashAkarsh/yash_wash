package kotlinx.coroutines.flow;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class o {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0}, l = {26}, m = "toCollection", n = {ShareConstants.DESTINATION}, s = {"L$0"})
    static final class a<T, C extends Collection<? super T>> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36531d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36532e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36533f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36532e = obj;
            this.f36533f |= Integer.MIN_VALUE;
            return k.V1(null, null, this);
        }
    }

    static final class b<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: Incorrect field signature: TC; */
        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collection f36534a;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        b(Collection collection) {
            this.f36534a = collection;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36534a.add(t7);
            return l2.f34958a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T, C extends Collection<? super T>> Object a(@a7.d i<? extends T> iVar, @a7.d C c8, @a7.d kotlin.coroutines.d<? super C> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36533f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36533f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f36532e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36533f;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection = (Collection) aVar.f36531d;
            e1.n(obj);
            return collection;
        }
        e1.n(obj);
        j<? super Object> bVar = new b<>(c8);
        aVar.f36531d = c8;
        aVar.f36533f = 1;
        return iVar.a(bVar, aVar) == objH ? objH : c8;
    }

    @a7.e
    public static final <T> Object b(@a7.d i<? extends T> iVar, @a7.d List<T> list, @a7.d kotlin.coroutines.d<? super List<? extends T>> dVar) {
        return k.V1(iVar, list, dVar);
    }

    public static /* synthetic */ Object c(i iVar, List list, kotlin.coroutines.d dVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            list = new ArrayList();
        }
        return k.W1(iVar, list, dVar);
    }

    @a7.e
    public static final <T> Object d(@a7.d i<? extends T> iVar, @a7.d Set<T> set, @a7.d kotlin.coroutines.d<? super Set<? extends T>> dVar) {
        return k.V1(iVar, set, dVar);
    }

    public static /* synthetic */ Object e(i iVar, Set set, kotlin.coroutines.d dVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return k.Y1(iVar, set, dVar);
    }
}
