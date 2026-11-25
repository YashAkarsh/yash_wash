package com.google.common.io;

import com.google.common.collect.bk;
import com.google.common.collect.ib;
import com.google.common.collect.u8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f22037a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bk<File> f22038b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.common.graph.s0<File> f22039c = new c();

    static class a implements b0<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f22040a = ib.q();

        a() {
        }

        @Override // com.google.common.io.b0
        public boolean b(String str) {
            this.f22040a.add(str);
            return true;
        }

        @Override // com.google.common.io.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a() {
            return this.f22040a;
        }
    }

    static class b extends bk<File> {
        b() {
        }

        @Override // com.google.common.collect.bk
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Iterable<File> b(File file) {
            return x.n(file);
        }

        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    }

    static class c implements com.google.common.graph.s0<File> {
        c() {
        }

        @Override // com.google.common.graph.s0
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public Iterable<File> b(File file) {
            return x.n(file);
        }
    }

    private static final class d extends com.google.common.io.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f22041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u8<w> f22042b;

        /* synthetic */ d(File file, w[] wVarArr, a aVar) {
            this(file, wVarArr);
        }

        @Override // com.google.common.io.f
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public FileOutputStream c() throws IOException {
            return new FileOutputStream(this.f22041a, this.f22042b.contains(w.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.f22041a + ", " + this.f22042b + ")";
        }

        private d(File file, w... wVarArr) {
            this.f22041a = (File) com.google.common.base.e0.E(file);
            this.f22042b = u8.t(wVarArr);
        }
    }

    private static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f22043a;

        /* synthetic */ e(File file, a aVar) {
            this(file);
        }

        @Override // com.google.common.io.g
        public byte[] o() throws Throwable {
            s sVarB = s.b();
            try {
                FileInputStream fileInputStream = (FileInputStream) sVarB.c(m());
                byte[] bArrV = h.v(fileInputStream, fileInputStream.getChannel().size());
                sVarB.close();
                return bArrV;
            } catch (Throwable th) {
                try {
                    throw sVarB.e(th);
                } catch (Throwable th2) {
                    sVarB.close();
                    throw th2;
                }
            }
        }

        @Override // com.google.common.io.g
        public long p() throws IOException {
            if (this.f22043a.isFile()) {
                return this.f22043a.length();
            }
            throw new FileNotFoundException(this.f22043a.toString());
        }

        @Override // com.google.common.io.g
        public com.google.common.base.a0<Long> q() {
            return this.f22043a.isFile() ? com.google.common.base.a0.g(Long.valueOf(this.f22043a.length())) : com.google.common.base.a0.a();
        }

        @Override // com.google.common.io.g
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public FileInputStream m() throws IOException {
            return new FileInputStream(this.f22043a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f22043a + ")";
        }

        private e(File file) {
            this.f22043a = (File) com.google.common.base.e0.E(file);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class f implements com.google.common.base.g0<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f22044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f22045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ f[] f22046c;

        static enum a extends f {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(File file) {
                return file.isDirectory();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }
        }

        static enum b extends f {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(File file) {
                return file.isFile();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }
        }

        static {
            a aVar = new a("IS_DIRECTORY", 0);
            f22044a = aVar;
            b bVar = new b("IS_FILE", 1);
            f22045b = bVar;
            f22046c = new f[]{aVar, bVar};
        }

        private f(String str, int i7) {
            super(str, i7);
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f22046c.clone();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return com.google.common.base.f0.a(this, obj);
        }

        /* synthetic */ f(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    private x() {
    }

    public static BufferedWriter A(File file, Charset charset) throws FileNotFoundException {
        com.google.common.base.e0.E(file);
        com.google.common.base.e0.E(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @u1.a
    @Deprecated
    public static <T> T B(File file, com.google.common.io.e<T> eVar) throws IOException {
        return (T) d(file).n(eVar);
    }

    @Deprecated
    public static String C(File file, Charset charset) throws IOException {
        return f(file, charset).s();
    }

    @u1.a
    @Deprecated
    public static <T> T D(File file, Charset charset, b0<T> b0Var) throws IOException {
        return (T) f(file, charset).u(b0Var);
    }

    public static List<String> E(File file, Charset charset) throws IOException {
        return (List) f(file, charset).u(new a());
    }

    public static String F(String str) {
        com.google.common.base.e0.E(str);
        if (str.length() == 0) {
            return com.alibaba.android.arouter.utils.b.f12515h;
        }
        Iterable<String> iterableN = com.google.common.base.k0.h('/').g().n(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : iterableN) {
            str2.hashCode();
            if (!str2.equals(com.alibaba.android.arouter.utils.b.f12515h)) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String strK = com.google.common.base.w.o('/').k(arrayList);
        if (str.charAt(0) == '/') {
            strK = "/" + strK;
        }
        while (strK.startsWith("/../")) {
            strK = strK.substring(3);
        }
        if (strK.equals("/..")) {
            return "/";
        }
        return "".equals(strK) ? com.alibaba.android.arouter.utils.b.f12515h : strK;
    }

    public static byte[] G(File file) throws IOException {
        return d(file).o();
    }

    @Deprecated
    public static String H(File file, Charset charset) throws IOException {
        return f(file, charset).r();
    }

    public static void I(File file) throws IOException {
        com.google.common.base.e0.E(file);
        if (file.createNewFile() || file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to update modification time of " + file);
    }

    @Deprecated
    public static void J(CharSequence charSequence, File file, Charset charset) throws Throwable {
        e(file, charset, new w[0]).c(charSequence);
    }

    public static void K(byte[] bArr, File file) throws Throwable {
        c(file, new w[0]).d(bArr);
    }

    @Deprecated
    public static void b(CharSequence charSequence, File file, Charset charset) throws Throwable {
        e(file, charset, w.APPEND).c(charSequence);
    }

    public static com.google.common.io.f c(File file, w... wVarArr) {
        return new d(file, wVarArr, null);
    }

    public static g d(File file) {
        return new e(file, null);
    }

    public static j e(File file, Charset charset, w... wVarArr) {
        return c(file, wVarArr).a(charset);
    }

    public static p f(File file, Charset charset) {
        return d(file).a(charset);
    }

    public static void g(File file, File file2) throws Throwable {
        com.google.common.base.e0.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        d(file).f(c(file2, new w[0]));
    }

    public static void h(File file, OutputStream outputStream) throws Throwable {
        d(file).g(outputStream);
    }

    @Deprecated
    public static void i(File file, Charset charset, Appendable appendable) throws Throwable {
        f(file, charset).g(appendable);
    }

    public static void j(File file) throws IOException {
        com.google.common.base.e0.E(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create parent directories of " + file);
    }

    public static File k() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        String str = System.currentTimeMillis() + "-";
        for (int i7 = 0; i7 < 10000; i7++) {
            File file2 = new File(file, str + i7);
            if (file2.mkdir()) {
                return file2;
            }
        }
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + "9999)");
    }

    public static boolean l(File file, File file2) throws IOException {
        com.google.common.base.e0.E(file);
        com.google.common.base.e0.E(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return d(file).e(d(file2));
        }
        return false;
    }

    public static com.google.common.graph.t0<File> m() {
        return com.google.common.graph.t0.h(f22039c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<File> n(File file) {
        File[] fileArrListFiles;
        return (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) ? Collections.emptyList() : Collections.unmodifiableList(Arrays.asList(fileArrListFiles));
    }

    @Deprecated
    static bk<File> o() {
        return f22038b;
    }

    public static String p(String str) {
        com.google.common.base.e0.E(str);
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf + 1);
    }

    public static String q(String str) {
        com.google.common.base.e0.E(str);
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? name : name.substring(0, iLastIndexOf);
    }

    @Deprecated
    public static com.google.common.hash.r r(File file, com.google.common.hash.s sVar) throws IOException {
        return d(file).j(sVar);
    }

    public static com.google.common.base.g0<File> s() {
        return f.f22044a;
    }

    public static com.google.common.base.g0<File> t() {
        return f.f22045b;
    }

    public static MappedByteBuffer u(File file) throws IOException {
        com.google.common.base.e0.E(file);
        return v(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer v(File file, FileChannel.MapMode mapMode) throws IOException {
        return x(file, mapMode, -1L);
    }

    public static MappedByteBuffer w(File file, FileChannel.MapMode mapMode, long j7) throws IOException {
        com.google.common.base.e0.p(j7 >= 0, "size (%s) may not be negative", j7);
        return x(file, mapMode, j7);
    }

    private static MappedByteBuffer x(File file, FileChannel.MapMode mapMode, long j7) throws Throwable {
        com.google.common.base.e0.E(file);
        com.google.common.base.e0.E(mapMode);
        s sVarB = s.b();
        try {
            FileChannel fileChannel = (FileChannel) sVarB.c(((RandomAccessFile) sVarB.c(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j7 == -1) {
                j7 = fileChannel.size();
            }
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j7);
            sVarB.close();
            return map;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public static void y(File file, File file2) throws Throwable {
        com.google.common.base.e0.E(file);
        com.google.common.base.e0.E(file2);
        com.google.common.base.e0.y(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        g(file, file2);
        if (file.delete()) {
            return;
        }
        if (file2.delete()) {
            throw new IOException("Unable to delete " + file);
        }
        throw new IOException("Unable to delete " + file2);
    }

    public static BufferedReader z(File file, Charset charset) throws FileNotFoundException {
        com.google.common.base.e0.E(file);
        com.google.common.base.e0.E(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }
}
