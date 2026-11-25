package kotlinx.coroutines.channels;

import com.facebook.internal.AnalyticsEvents;
import kotlin.a1;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes2.dex */
@h5.f
public final class r<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final b f35656b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final c f35657c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Object f35658a;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Throwable f35659a;

        public a(@a7.e Throwable th) {
            this.f35659a = th;
        }

        public boolean equals(@a7.e Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.l0.g(this.f35659a, ((a) obj).f35659a);
        }

        public int hashCode() {
            Throwable th = this.f35659a;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        @Override // kotlinx.coroutines.channels.r.c
        @a7.d
        public String toString() {
            return "Closed(" + this.f35659a + ')';
        }
    }

    @j2
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        @j2
        public final <E> Object a(@a7.e Throwable th) {
            return r.c(new a(th));
        }

        @a7.d
        @j2
        public final <E> Object b() {
            return r.c(r.f35657c);
        }

        @a7.d
        @j2
        public final <E> Object c(E e8) {
            return r.c(e8);
        }

        private b() {
        }
    }

    public static class c {
        @a7.d
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    @a1
    private /* synthetic */ r(Object obj) {
        this.f35658a = obj;
    }

    public static final /* synthetic */ r b(Object obj) {
        return new r(obj);
    }

    @a7.d
    @a1
    public static <T> Object c(@a7.e Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof r) && kotlin.jvm.internal.l0.g(obj, ((r) obj2).o());
    }

    public static final boolean e(Object obj, Object obj2) {
        return kotlin.jvm.internal.l0.g(obj, obj2);
    }

    @a7.e
    public static final Throwable f(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar == null) {
            return null;
        }
        return aVar.f35659a;
    }

    @a1
    public static /* synthetic */ void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.e
    public static final T h(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T i(Object obj) throws Throwable {
        Throwable th;
        if (!(obj instanceof c)) {
            return obj;
        }
        if (!(obj instanceof a) || (th = ((a) obj).f35659a) == null) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        throw th;
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean k(Object obj) {
        return obj instanceof a;
    }

    public static final boolean l(Object obj) {
        return obj instanceof c;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof c);
    }

    @a7.d
    public static String n(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f35658a, obj);
    }

    public int hashCode() {
        return j(this.f35658a);
    }

    public final /* synthetic */ Object o() {
        return this.f35658a;
    }

    @a7.d
    public String toString() {
        return n(this.f35658a);
    }
}
