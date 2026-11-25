package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.coroutines.j
@g1(version = "1.7")
@q2(markerClass = {s.class})
public abstract class i<T, R> {
    public /* synthetic */ i(kotlin.jvm.internal.w wVar) {
        this();
    }

    @a7.e
    public abstract Object a(T t7, @a7.d kotlin.coroutines.d<? super R> dVar);

    @a7.e
    public abstract <U, S> Object c(@a7.d g<U, S> gVar, U u7, @a7.d kotlin.coroutines.d<? super S> dVar);

    @a7.d
    @k(level = m.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @b1(expression = "this.callRecursive(value)", imports = {}))
    public final Void f(@a7.d g<?, ?> gVar, @a7.e Object obj) {
        kotlin.jvm.internal.l0.p(gVar, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    private i() {
    }
}
