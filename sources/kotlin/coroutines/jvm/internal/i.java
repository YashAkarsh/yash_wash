package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final i f34707a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final a f34708b = new a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private static a f34709c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Method f34710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Method f34711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Method f34712c;

        public a(@a7.e Method method, @a7.e Method method2, @a7.e Method method3) {
            this.f34710a = method;
            this.f34711b = method2;
            this.f34712c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f34709c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f34708b;
            f34709c = aVar3;
            return aVar3;
        }
    }

    @a7.e
    public final String b(@a7.d kotlin.coroutines.jvm.internal.a continuation) {
        l0.p(continuation, "continuation");
        a aVarA = f34709c;
        if (aVarA == null) {
            aVarA = a(continuation);
        }
        if (aVarA == f34708b) {
            return null;
        }
        Method method = aVarA.f34710a;
        Object objInvoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.f34711b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.f34712c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
