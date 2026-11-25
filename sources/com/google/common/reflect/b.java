package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.base.f0;
import com.google.common.base.g0;
import com.google.common.base.k0;
import com.google.common.base.l0;
import com.google.common.collect.af;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.h5;
import com.google.common.collect.u8;
import com.google.common.collect.uc;
import com.google.common.collect.ue;
import com.google.common.collect.v7;
import com.google.common.collect.wb;
import com.google.common.io.g2;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f22429b = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g0<C0287b> f22430c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final k0 f22431d = k0.k(" ").g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f22432e = ".class";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8<d> f22433a;

    static class a implements g0<C0287b> {
        a() {
        }

        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(C0287b c0287b) {
            return c0287b.f22434c.indexOf(36) == -1;
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.b$b, reason: collision with other inner class name */
    @s1.a
    public static final class C0287b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22434c;

        C0287b(String str, ClassLoader classLoader) {
            super(str, classLoader);
            this.f22434c = b.e(str);
        }

        public String g() {
            return this.f22434c;
        }

        public String h() {
            return h.b(this.f22434c);
        }

        public String i() {
            int iLastIndexOf = this.f22434c.lastIndexOf(36);
            if (iLastIndexOf != -1) {
                return com.google.common.base.e.j().V(this.f22434c.substring(iLastIndexOf + 1));
            }
            String strH = h();
            return strH.isEmpty() ? this.f22434c : this.f22434c.substring(strH.length() + 1);
        }

        public Class<?> j() {
            try {
                return this.f22437b.loadClass(this.f22434c);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException(e8);
            }
        }

        @Override // com.google.common.reflect.b.d
        public String toString() {
            return this.f22434c;
        }
    }

    @s1.d
    static final class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ue<ClassLoader, String> f22435b = uc.d().g().a();

        c() {
        }

        private void m(File file, ClassLoader classLoader, String str, Set<File> set) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                b.f22429b.warning("Cannot read directory " + file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        m(canonicalFile, classLoader, str + name + "/", set);
                        set.remove(canonicalFile);
                    }
                } else {
                    String str2 = str + name;
                    if (!str2.equals("META-INF/MANIFEST.MF")) {
                        this.f22435b.get(classLoader).add(str2);
                    }
                }
            }
        }

        @Override // com.google.common.reflect.b.e
        protected void h(ClassLoader classLoader, File file) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            m(file, classLoader, "", hashSet);
        }

        @Override // com.google.common.reflect.b.e
        protected void k(ClassLoader classLoader, JarFile jarFile) {
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                if (!jarEntryNextElement.isDirectory() && !jarEntryNextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    this.f22435b.get(classLoader).add(jarEntryNextElement.getName());
                }
            }
        }

        u8<d> l() {
            u8.a aVarK = u8.k();
            for (Map.Entry<ClassLoader, String> entry : this.f22435b.y()) {
                aVarK.a(d.d(entry.getValue(), entry.getKey()));
            }
            return aVarK.e();
        }
    }

    @s1.a
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ClassLoader f22437b;

        d(String str, ClassLoader classLoader) {
            this.f22436a = (String) e0.E(str);
            this.f22437b = (ClassLoader) e0.E(classLoader);
        }

        static d d(String str, ClassLoader classLoader) {
            return str.endsWith(b.f22432e) ? new C0287b(str, classLoader) : new d(str, classLoader);
        }

        public final com.google.common.io.g a() {
            return g2.a(e());
        }

        public final com.google.common.io.p b(Charset charset) {
            return g2.b(e(), charset);
        }

        public final String c() {
            return this.f22436a;
        }

        public final URL e() {
            URL resource = this.f22437b.getResource(this.f22436a);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f22436a);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f22436a.equals(dVar.f22436a) && this.f22437b == dVar.f22437b;
        }

        public int hashCode() {
            return this.f22436a.hashCode();
        }

        public String toString() {
            return this.f22436a;
        }
    }

    static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<File> f22438a = af.u();

        e() {
        }

        private static d7<URL> a(ClassLoader classLoader) {
            if (classLoader instanceof URLClassLoader) {
                return d7.u(((URLClassLoader) classLoader).getURLs());
            }
            return classLoader.equals(ClassLoader.getSystemClassLoader()) ? e() : d7.x();
        }

        @s1.d
        static v7<File, ClassLoader> b(ClassLoader classLoader) {
            LinkedHashMap linkedHashMapM0 = wb.m0();
            ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                linkedHashMapM0.putAll(b(parent));
            }
            ck<URL> it = a(classLoader).iterator();
            while (it.hasNext()) {
                URL next = it.next();
                if (next.getProtocol().equals("file")) {
                    File fileJ = b.j(next);
                    if (!linkedHashMapM0.containsKey(fileJ)) {
                        linkedHashMapM0.put(fileJ, classLoader);
                    }
                }
            }
            return v7.g(linkedHashMapM0);
        }

        @s1.d
        static URL c(File file, String str) throws MalformedURLException {
            return new URL(file.toURI().toURL(), str);
        }

        @s1.d
        static u8<File> d(File file, Manifest manifest) {
            if (manifest == null) {
                return u8.A();
            }
            u8.a aVarK = u8.k();
            String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (value != null) {
                for (String str : b.f22431d.n(value)) {
                    try {
                        URL urlC = c(file, str);
                        if (urlC.getProtocol().equals("file")) {
                            aVarK.a(b.j(urlC));
                        }
                    } catch (MalformedURLException unused) {
                        b.f22429b.warning("Invalid Class-Path entry: " + str);
                    }
                }
            }
            return aVarK.e();
        }

        @s1.d
        static d7<URL> e() {
            d7.b bVarM = d7.m();
            for (String str : k0.k(l0.PATH_SEPARATOR.b()).n(l0.JAVA_CLASS_PATH.b())) {
                try {
                    try {
                        bVarM.a(new File(str).toURI().toURL());
                    } catch (SecurityException unused) {
                        bVarM.a(new URL("file", (String) null, new File(str).getAbsolutePath()));
                    }
                } catch (MalformedURLException e8) {
                    b.f22429b.log(Level.WARNING, "malformed classpath entry: " + str, (Throwable) e8);
                }
            }
            return bVarM.e();
        }

        private void i(File file, ClassLoader classLoader) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        h(classLoader, file);
                    } else {
                        j(file, classLoader);
                    }
                }
            } catch (SecurityException e8) {
                b.f22429b.warning("Cannot access " + file + ": " + e8);
            }
        }

        private void j(File file, ClassLoader classLoader) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    ck<File> it = d(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        f(it.next(), classLoader);
                    }
                    k(classLoader, jarFile);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        @s1.d
        final void f(File file, ClassLoader classLoader) throws IOException {
            if (this.f22438a.add(file.getCanonicalFile())) {
                i(file, classLoader);
            }
        }

        public final void g(ClassLoader classLoader) throws IOException {
            ck<Map.Entry<File, ClassLoader>> it = b(classLoader).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<File, ClassLoader> next = it.next();
                f(next.getKey(), next.getValue());
            }
        }

        protected abstract void h(ClassLoader classLoader, File file) throws IOException;

        protected abstract void k(ClassLoader classLoader, JarFile jarFile) throws IOException;
    }

    private b(u8<d> u8Var) {
        this.f22433a = u8Var;
    }

    public static b c(ClassLoader classLoader) throws IOException {
        c cVar = new c();
        cVar.g(classLoader);
        return new b(cVar.l());
    }

    @s1.d
    static String e(String str) {
        return str.substring(0, str.length() - 6).replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @s1.d
    static File j(URL url) {
        e0.d(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public u8<C0287b> d() {
        return h5.v(this.f22433a).r(C0287b.class).M();
    }

    public u8<d> f() {
        return this.f22433a;
    }

    public u8<C0287b> g() {
        return h5.v(this.f22433a).r(C0287b.class).p(f22430c).M();
    }

    public u8<C0287b> h(String str) {
        e0.E(str);
        u8.a aVarK = u8.k();
        ck<C0287b> it = g().iterator();
        while (it.hasNext()) {
            C0287b next = it.next();
            if (next.h().equals(str)) {
                aVarK.a(next);
            }
        }
        return aVarK.e();
    }

    public u8<C0287b> i(String str) {
        e0.E(str);
        String str2 = str + ClassUtils.PACKAGE_SEPARATOR_CHAR;
        u8.a aVarK = u8.k();
        ck<C0287b> it = g().iterator();
        while (it.hasNext()) {
            C0287b next = it.next();
            if (next.g().startsWith(str2)) {
                aVarK.a(next);
            }
        }
        return aVarK.e();
    }
}
