package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final o f37010a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final String f37011b = "META-INF/services/";

    private o() {
    }

    private final d0 a(Class<d0> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> S b(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.g0.Q5(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> f(URL url) throws IOException {
        String string = url.toString();
        if (!kotlin.text.b0.u2(string, "jar", false, 2, null)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listG = f37010a.g(bufferedReader);
                kotlin.io.c.a(bufferedReader, null);
                return listG;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.c.a(bufferedReader, th);
                    throw th2;
                }
            }
        }
        String strW5 = kotlin.text.c0.w5(kotlin.text.c0.p5(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strP5 = kotlin.text.c0.p5(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strW5, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strP5)), "UTF-8"));
            try {
                List<String> listG2 = f37010a.g(bufferedReader2);
                kotlin.io.c.a(bufferedReader2, null);
                jarFile.close();
                return listG2;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    kotlin.io.c.a(bufferedReader2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    jarFile.close();
                    throw th6;
                } catch (Throwable th7) {
                    kotlin.p.a(th5, th7);
                    throw th5;
                }
            }
        }
    }

    private final List<String> g(BufferedReader bufferedReader) throws IOException {
        boolean z7;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return kotlin.collections.g0.Q5(linkedHashSet);
            }
            String string = kotlin.text.c0.E5(kotlin.text.c0.x5(line, "#", null, 2, null)).toString();
            int i7 = 0;
            while (true) {
                if (i7 >= string.length()) {
                    z7 = true;
                    break;
                }
                char cCharAt = string.charAt(i7);
                i7++;
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z7 = false;
                    break;
                }
            }
            if (!z7) {
                throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Illegal service provider class name: ", string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }

    private final <R> R h(JarFile jarFile, i5.l<? super JarFile, ? extends R> lVar) throws IOException {
        try {
            R rZ = lVar.z(jarFile);
            kotlin.jvm.internal.i0.d(1);
            jarFile.close();
            kotlin.jvm.internal.i0.c(1);
            return rZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.i0.d(1);
                try {
                    jarFile.close();
                    kotlin.jvm.internal.i0.c(1);
                    throw th2;
                } catch (Throwable th3) {
                    kotlin.p.a(th, th3);
                    throw th;
                }
            }
        }
    }

    @a7.d
    public final List<d0> d() {
        d0 d0Var;
        if (!p.a()) {
            return c(d0.class, d0.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            d0 d0Var2 = null;
            try {
                d0Var = (d0) d0.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, d0.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                d0Var = null;
            }
            if (d0Var != null) {
                arrayList.add(d0Var);
            }
            try {
                d0Var2 = (d0) d0.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, d0.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (d0Var2 == null) {
                return arrayList;
            }
            arrayList.add(d0Var2);
            return arrayList;
        } catch (Throwable unused3) {
            return c(d0.class, d0.class.getClassLoader());
        }
    }

    @a7.d
    public final <S> List<S> e(@a7.d Class<S> cls, @a7.d ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(kotlin.jvm.internal.l0.C(f37011b, cls.getName())));
        kotlin.jvm.internal.l0.o(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.d0.o0(arrayList, f37010a.f((URL) it.next()));
        }
        Set setV5 = kotlin.collections.g0.V5(arrayList);
        if (!(!setV5.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.z.Z(setV5, 10));
        Iterator it2 = setV5.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f37010a.b((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
