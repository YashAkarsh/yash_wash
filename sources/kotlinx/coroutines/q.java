package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface q<T> extends kotlin.coroutines.d<T> {

    public static final class a {
        public static /* synthetic */ boolean a(q qVar, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return qVar.e(th);
        }

        public static /* synthetic */ Object b(q qVar, Object obj, Object obj2, int i7, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i7 & 2) != 0) {
                obj2 = null;
            }
            return qVar.t(obj, obj2);
        }
    }

    @j2
    @a7.e
    Object J(@a7.d Throwable th);

    @d2
    void L(@a7.d o0 o0Var, @a7.d Throwable th);

    @d2
    void N(@a7.d o0 o0Var, T t7);

    @j2
    void O();

    boolean b();

    @j2
    @a7.e
    Object c0(T t7, @a7.e Object obj, @a7.e i5.l<? super Throwable, kotlin.l2> lVar);

    boolean e(@a7.e Throwable th);

    void i0(@a7.d i5.l<? super Throwable, kotlin.l2> lVar);

    boolean isCancelled();

    boolean r();

    @j2
    @a7.e
    Object t(T t7, @a7.e Object obj);

    @j2
    void t0(@a7.d Object obj);

    @d2
    void x(T t7, @a7.e i5.l<? super Throwable, kotlin.l2> lVar);
}
