package junit.framework;

import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class n implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f34372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vector<i> f34373b;

    static class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34374b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.f34374b = str2;
        }

        @Override // junit.framework.j
        protected void S() {
            j.J(this.f34374b);
        }
    }

    public n() {
        this.f34373b = new Vector<>(10);
    }

    private void e(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (l(method)) {
            list.add(name);
            b(h(cls, name));
        } else if (m(method)) {
            b(t("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
        }
    }

    private void g(Class<?> cls) {
        this.f34372a = cls.getName();
        try {
            k(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                b(t("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = cls; i.class.isAssignableFrom(superclass); superclass = superclass.getSuperclass()) {
                for (Method method : org.junit.internal.h.a(superclass)) {
                    e(method, arrayList, cls);
                }
            }
            if (this.f34373b.size() == 0) {
                b(t("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            b(t("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public static i h(Class<?> cls, String str) {
        Object objNewInstance;
        try {
            Constructor<?> constructorK = k(cls);
            try {
                if (constructorK.getParameterTypes().length == 0) {
                    objNewInstance = constructorK.newInstance(new Object[0]);
                    if (objNewInstance instanceof j) {
                        ((j) objNewInstance).T(str);
                    }
                } else {
                    objNewInstance = constructorK.newInstance(str);
                }
                return (i) objNewInstance;
            } catch (IllegalAccessException e8) {
                return t("Cannot access test case: " + str + " (" + i(e8) + ")");
            } catch (InstantiationException e9) {
                return t("Cannot instantiate test case: " + str + " (" + i(e9) + ")");
            } catch (InvocationTargetException e10) {
                return t("Exception in constructor: " + str + " (" + i(e10.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return t("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    private static String i(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Constructor<?> k(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    private boolean l(Method method) {
        return m(method) && Modifier.isPublic(method.getModifiers());
    }

    private boolean m(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith(InstrumentationResultPrinter.f10180n) && method.getReturnType().equals(Void.TYPE);
    }

    private i q(Class<?> cls) {
        if (j.class.isAssignableFrom(cls)) {
            return new n(cls.asSubclass(j.class));
        }
        return t(cls.getCanonicalName() + " does not extend TestCase");
    }

    public static i t(String str) {
        return new a("warning", str);
    }

    @Override // junit.framework.i
    public int a() {
        Iterator<i> it = this.f34373b.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += it.next().a();
        }
        return iA;
    }

    public void b(i iVar) {
        this.f34373b.add(iVar);
    }

    @Override // junit.framework.i
    public void c(m mVar) {
        for (i iVar : this.f34373b) {
            if (mVar.n()) {
                return;
            } else {
                n(iVar, mVar);
            }
        }
    }

    public void f(Class<? extends j> cls) {
        b(new n(cls));
    }

    public String j() {
        return this.f34372a;
    }

    public void n(i iVar, m mVar) {
        iVar.c(mVar);
    }

    public void o(String str) {
        this.f34372a = str;
    }

    public i p(int i7) {
        return this.f34373b.get(i7);
    }

    public int r() {
        return this.f34373b.size();
    }

    public Enumeration<i> s() {
        return this.f34373b.elements();
    }

    public String toString() {
        return j() != null ? j() : super.toString();
    }

    public n(Class<?> cls) {
        this.f34373b = new Vector<>(10);
        g(cls);
    }

    public n(Class<? extends j> cls, String str) {
        this(cls);
        o(str);
    }

    public n(String str) {
        this.f34373b = new Vector<>(10);
        o(str);
    }

    public n(Class<?>... clsArr) {
        this.f34373b = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            b(q(cls));
        }
    }

    public n(Class<? extends j>[] clsArr, String str) {
        this(clsArr);
        o(str);
    }
}
