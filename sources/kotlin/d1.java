package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
@g1(version = "1.3")
public final class d1<T> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f34719b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Object f34720a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @h5.h(name = "failure")
        @kotlin.internal.f
        private final <T> Object a(Throwable exception) {
            kotlin.jvm.internal.l0.p(exception, "exception");
            return d1.b(e1.a(exception));
        }

        @h5.h(name = "success")
        @kotlin.internal.f
        private final <T> Object b(T t7) {
            return d1.b(t7);
        }

        private a() {
        }
    }

    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final Throwable f34721a;

        public b(@a7.d Throwable exception) {
            kotlin.jvm.internal.l0.p(exception, "exception");
            this.f34721a = exception;
        }

        public boolean equals(@a7.e Object obj) {
            return (obj instanceof b) && kotlin.jvm.internal.l0.g(this.f34721a, ((b) obj).f34721a);
        }

        public int hashCode() {
            return this.f34721a.hashCode();
        }

        @a7.d
        public String toString() {
            return "Failure(" + this.f34721a + ')';
        }
    }

    @a1
    private /* synthetic */ d1(Object obj) {
        this.f34720a = obj;
    }

    public static final /* synthetic */ d1 a(Object obj) {
        return new d1(obj);
    }

    @a7.d
    @a1
    public static <T> Object b(@a7.e Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof d1) && kotlin.jvm.internal.l0.g(obj, ((d1) obj2).l());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.l0.g(obj, obj2);
    }

    @a7.e
    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f34721a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final T f(Object obj) {
        if (i(obj)) {
            return null;
        }
        return obj;
    }

    @a1
    public static /* synthetic */ void g() {
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof b;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof b);
    }

    @a7.d
    public static String k(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f34720a, obj);
    }

    public int hashCode() {
        return h(this.f34720a);
    }

    public final /* synthetic */ Object l() {
        return this.f34720a;
    }

    @a7.d
    public String toString() {
        return k(this.f34720a);
    }
}
