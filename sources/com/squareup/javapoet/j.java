package com.squareup.javapoet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Appendable f33319g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f33320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f33322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f33324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f33325f;

    static class a implements Appendable {
        a() {
        }

        @Override // java.lang.Appendable
        public Appendable append(char c8) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i7, int i8) {
            return this;
        }
    }

    class b extends SimpleJavaFileObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f33326a;

        b(URI uri, JavaFileObject.Kind kind) {
            super(uri, kind);
            this.f33326a = System.currentTimeMillis();
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(boolean z7) {
            return j.this.toString();
        }

        public long c() {
            return this.f33326a;
        }

        public InputStream d() throws IOException {
            return new ByteArrayInputStream(a(true).getBytes());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f33329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b f33330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set<String> f33331d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f33332e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f33333f;

        /* synthetic */ c(String str, p pVar, a aVar) {
            this(str, pVar);
        }

        public c i(String str, Object... objArr) {
            this.f33330c.b(str, objArr);
            return this;
        }

        public c j(com.squareup.javapoet.c cVar, String... strArr) {
            r.b(cVar != null, "className == null", new Object[0]);
            r.b(strArr != null, "names == null", new Object[0]);
            r.b(strArr.length > 0, "names array is empty", new Object[0]);
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                String str = strArr[i7];
                r.b(str != null, "null entry in names array: %s", Arrays.toString(strArr));
                this.f33331d.add(cVar.f33287x + com.alibaba.android.arouter.utils.b.f12515h + str);
            }
            return this;
        }

        public c k(Class<?> cls, String... strArr) {
            return j(com.squareup.javapoet.c.w(cls), strArr);
        }

        public c l(Enum<?> r7) {
            return j(com.squareup.javapoet.c.w(r7.getDeclaringClass()), r7.name());
        }

        public j m() {
            return new j(this, null);
        }

        public c n(String str) {
            this.f33333f = str;
            return this;
        }

        public c o(boolean z7) {
            this.f33332e = z7;
            return this;
        }

        private c(String str, p pVar) {
            this.f33330c = d.a();
            this.f33331d = new TreeSet();
            this.f33333f = "  ";
            this.f33328a = str;
            this.f33329b = pVar;
        }
    }

    /* synthetic */ j(c cVar, a aVar) {
        this(cVar);
    }

    public static c a(String str, p pVar) {
        r.c(str, "packageName == null", new Object[0]);
        r.c(pVar, "typeSpec == null", new Object[0]);
        return new c(str, pVar, null);
    }

    private void b(e eVar) throws IOException {
        eVar.v(this.f33321b);
        if (!this.f33320a.b()) {
            eVar.f(this.f33320a);
        }
        if (!this.f33321b.isEmpty()) {
            eVar.c("package $L;\n", this.f33321b);
            eVar.b("\n");
        }
        if (!this.f33324e.isEmpty()) {
            Iterator<String> it = this.f33324e.iterator();
            while (it.hasNext()) {
                eVar.c("import static $L;\n", (String) it.next());
            }
            eVar.b("\n");
        }
        int i7 = 0;
        for (com.squareup.javapoet.c cVar : new TreeSet(eVar.p().values())) {
            if (!this.f33323d || !cVar.C().equals("java.lang")) {
                eVar.c("import $L;\n", cVar);
                i7++;
            }
        }
        if (i7 > 0) {
            eVar.b("\n");
        }
        this.f33322c.f(eVar, null, Collections.emptySet());
        eVar.t();
    }

    public c c() {
        c cVar = new c(this.f33321b, this.f33322c, null);
        cVar.f33330c.a(this.f33320a);
        cVar.f33332e = this.f33323d;
        cVar.f33333f = this.f33325f;
        return cVar;
    }

    public JavaFileObject d() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f33321b.isEmpty()) {
            str = this.f33322c.f33396b;
        } else {
            str = this.f33321b.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + '/' + this.f33322c.f33396b;
        }
        sb.append(str);
        sb.append(JavaFileObject.Kind.SOURCE.extension);
        return new b(URI.create(sb.toString()), JavaFileObject.Kind.SOURCE);
    }

    public void e(File file) throws IOException {
        g(file.toPath());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public void f(Appendable appendable) throws IOException {
        e eVar = new e(f33319g, this.f33325f, this.f33324e);
        b(eVar);
        b(new e(appendable, this.f33325f, eVar.z(), this.f33324e));
    }

    public void g(Path path) throws IOException {
        r.b(Files.notExists(path, new LinkOption[0]) || Files.isDirectory(path, new LinkOption[0]), "path %s exists but is not a directory.", path);
        if (!this.f33321b.isEmpty()) {
            for (String str : this.f33321b.split("\\.")) {
                path = path.resolve(str);
            }
            Files.createDirectories(path, new FileAttribute[0]);
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(path.resolve(this.f33322c.f33396b + ".java"), new OpenOption[0]));
        try {
            f(outputStreamWriter);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public void h(Filer filer) throws Exception {
        String str;
        if (this.f33321b.isEmpty()) {
            str = this.f33322c.f33396b;
        } else {
            str = this.f33321b + com.alibaba.android.arouter.utils.b.f12515h + this.f33322c.f33396b;
        }
        List<Element> list = this.f33322c.f33410p;
        JavaFileObject javaFileObjectCreateSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer writerOpenWriter = javaFileObjectCreateSourceFile.openWriter();
            try {
                f(writerOpenWriter);
                if (writerOpenWriter != null) {
                    writerOpenWriter.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (writerOpenWriter != null) {
                        try {
                            writerOpenWriter.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e8) {
            try {
                javaFileObjectCreateSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e8;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            f(sb);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private j(c cVar) {
        this.f33320a = cVar.f33330c.i();
        this.f33321b = cVar.f33328a;
        this.f33322c = cVar.f33329b;
        this.f33323d = cVar.f33332e;
        this.f33324e = r.i(cVar.f33331d);
        this.f33325f = cVar.f33333f;
    }
}
