package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
@z6.a
final class e extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final e f36971a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final a f36972b = new a();

    public static final class a extends ClassValue<i5.l<? super Throwable, ? extends Throwable>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i5.l<Throwable, Throwable> computeValue(@a7.e Class<?> cls) {
            if (cls != null) {
                return n.b(cls);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
        }
    }

    private e() {
    }

    @Override // kotlinx.coroutines.internal.k
    @a7.d
    public i5.l<Throwable, Throwable> a(@a7.d Class<? extends Throwable> cls) {
        return (i5.l) f36972b.get(cls);
    }
}
