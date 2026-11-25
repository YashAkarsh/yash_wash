package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f34744a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        @a7.e
        public static final Method f34745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        @a7.e
        public static final Method f34746c;

        /* JADX WARN: Code duplicated, block: B:10:0x003b  */
        static {
            Method method;
            Method method2;
            boolean z7;
            Method[] throwableMethods = Throwable.class.getMethods();
            l0.o(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i7 = 0;
            while (true) {
                method = null;
                if (i7 >= length) {
                    method2 = null;
                    break;
                }
                method2 = throwableMethods[i7];
                if (l0.g(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    l0.o(parameterTypes, "it.parameterTypes");
                    if (l0.g(kotlin.collections.p.bu(parameterTypes), Throwable.class)) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    z7 = false;
                }
                if (z7) {
                    break;
                } else {
                    i7++;
                }
            }
            f34745b = method2;
            for (Method method3 : throwableMethods) {
                if (l0.g(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f34746c = method;
        }

        private a() {
        }
    }

    public void a(@a7.d Throwable cause, @a7.d Throwable exception) {
        l0.p(cause, "cause");
        l0.p(exception, "exception");
        Method method = a.f34745b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @a7.d
    public kotlin.random.f b() {
        return new kotlin.random.b();
    }

    @a7.e
    public kotlin.text.j c(@a7.d MatchResult matchResult, @a7.d String name) {
        l0.p(matchResult, "matchResult");
        l0.p(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @a7.d
    public List<Throwable> d(@a7.d Throwable exception) {
        Object objInvoke;
        List<Throwable> listT;
        l0.p(exception, "exception");
        Method method = a.f34746c;
        return (method == null || (objInvoke = method.invoke(exception, new Object[0])) == null || (listT = kotlin.collections.o.t((Throwable[]) objInvoke)) == null) ? y.F() : listT;
    }
}
