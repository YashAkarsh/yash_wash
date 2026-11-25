package kotlin.sequences;

import java.util.Iterator;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f35150a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f35151b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f35152c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f35153d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f35154e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f35155f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p f35156a;

        public a(i5.p pVar) {
            this.f35156a = pVar;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return q.a(this.f35156a);
        }
    }

    @a7.d
    @g1(version = "1.3")
    public static <T> Iterator<T> a(@a7.d @kotlin.b i5.p<? super o<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> block) {
        l0.p(block, "block");
        n nVar = new n();
        nVar.l(kotlin.coroutines.intrinsics.c.c(block, nVar, nVar));
        return nVar;
    }

    @a7.d
    @g1(version = "1.3")
    public static <T> m<T> b(@a7.d @kotlin.b i5.p<? super o<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> block) {
        l0.p(block, "block");
        return new a(block);
    }
}
