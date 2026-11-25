package kotlinx.coroutines.channels;

import kotlin.b1;
import kotlinx.coroutines.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
public interface n<E> extends m0<E>, i0<E> {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @a7.d
    public static final b f35616t0 = b.f35623a;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f35617u0 = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f35618v0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f35619w0 = -1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f35620x0 = -2;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f35621y0 = -3;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @a7.d
    public static final String f35622z0 = "kotlinx.coroutines.channels.defaultBuffer";

    public static final class a {
        @a7.d
        public static <E> kotlinx.coroutines.selects.d<E> b(@a7.d n<E> nVar) {
            return i0.a.d(nVar);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@a7.d n<E> nVar, E e8) {
            return m0.a.c(nVar, e8);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
        @a7.e
        public static <E> E d(@a7.d n<E> nVar) {
            return (E) i0.a.h(nVar);
        }

        @kotlin.internal.h
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
        @a7.e
        public static <E> Object e(@a7.d n<E> nVar, @a7.d kotlin.coroutines.d<? super E> dVar) {
            return i0.a.i(nVar, dVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f35624b = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f35625c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f35626d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f35627e = -2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f35628f = -3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        public static final String f35629g = "kotlinx.coroutines.channels.defaultBuffer";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f35623a = new b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f35630h = t0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private b() {
        }

        public final int a() {
            return f35630h;
        }
    }
}
