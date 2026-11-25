package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f38239d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f38240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f38241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f38242c;

    public static final class a {
        private a() {
        }

        @a7.d
        public final j a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new j(method, method3, method2);
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public j(@a7.e Method method, @a7.e Method method2, @a7.e Method method3) {
        this.f38240a = method;
        this.f38241b = method2;
        this.f38242c = method3;
    }

    @a7.e
    public final Object a(@a7.d String closer) {
        l0.p(closer, "closer");
        Method method = this.f38240a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.f38241b;
                l0.m(method2);
                method2.invoke(objInvoke, closer);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(@a7.e Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f38242c;
            l0.m(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
