package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, com.alibaba.fastjson.asm.j.f12628v}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super List<? extends T>>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f34597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f34598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f34599e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f34600f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f34601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f34602h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f34603i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Iterator<T> f34604j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f34605k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f34606l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(int i7, int i8, Iterator<? extends T> it, boolean z7, boolean z8, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f34602h = i7;
            this.f34603i = i8;
            this.f34604j = it;
            this.f34605k = z7;
            this.f34606l = z8;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f34602h, this.f34603i, this.f34604j, this.f34605k, this.f34606l, dVar);
            aVar.f34601g = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:54:0x010a  */
        /* JADX WARN: Code duplicated, block: B:55:0x010c  */
        /* JADX WARN: Code duplicated, block: B:58:0x011f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x00f9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0106 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a6 -> B:16:0x0058). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011d -> B:59:0x0120). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x014b -> B:72:0x014e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.q1.a.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super List<? extends T>> oVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(oVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements kotlin.sequences.m<List<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f34607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f34610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f34611e;

        public b(kotlin.sequences.m mVar, int i7, int i8, boolean z7, boolean z8) {
            this.f34607a = mVar;
            this.f34608b = i7;
            this.f34609c = i8;
            this.f34610d = z7;
            this.f34611e = z8;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<List<? extends T>> iterator() {
            return q1.b(this.f34607a.iterator(), this.f34608b, this.f34609c, this.f34610d, this.f34611e);
        }
    }

    public static final void a(int i7, int i8) {
        String str;
        if (i7 > 0 && i8 > 0) {
            return;
        }
        if (i7 != i8) {
            str = "Both size " + i7 + " and step " + i8 + " must be greater than zero.";
        } else {
            str = "size " + i7 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @a7.d
    public static final <T> Iterator<List<T>> b(@a7.d Iterator<? extends T> iterator, int i7, int i8, boolean z7, boolean z8) {
        kotlin.jvm.internal.l0.p(iterator, "iterator");
        return !iterator.hasNext() ? i0.f34535a : kotlin.sequences.q.a(new a(i7, i8, iterator, z8, z7, null));
    }

    @a7.d
    public static final <T> kotlin.sequences.m<List<T>> c(@a7.d kotlin.sequences.m<? extends T> mVar, int i7, int i8, boolean z7, boolean z8) {
        kotlin.jvm.internal.l0.p(mVar, "<this>");
        a(i7, i8);
        return new b(mVar, i7, i8, z7, z8);
    }
}
