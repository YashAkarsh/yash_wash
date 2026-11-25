package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final String f13953o = "journal";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final String f13954p = "journal.tmp";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final String f13955q = "journal.bkp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final String f13956r = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f13957s = "1";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final long f13958t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f13959u = "CLEAN";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f13960v = "DIRTY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f13961w = "REMOVE";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f13962x = "READ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f13963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f13964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f13965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f13966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f13969g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f13971i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13973k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13970h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, c> f13972j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f13974l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f13975m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f13976n = new CallableC0160a();

    /* JADX INFO: renamed from: com.bumptech.glide.disklrucache.a$a, reason: collision with other inner class name */
    class CallableC0160a implements Callable<Void> {
        CallableC0160a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f13971i == null) {
                    return null;
                }
                a.this.Q0();
                if (a.this.o0()) {
                    a.this.x0();
                    a.this.f13973k = 0;
                }
                return null;
            }
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f13978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f13979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13980c;

        /* synthetic */ b(a aVar, c cVar, CallableC0160a callableC0160a) {
            this(cVar);
        }

        private InputStream h(int i7) throws IOException {
            synchronized (a.this) {
                if (this.f13978a.f13987f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f13978a.f13986e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f13978a.j(i7));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public void a() throws IOException {
            a.this.E(this, false);
        }

        public void b() {
            if (this.f13980c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            a.this.E(this, true);
            this.f13980c = true;
        }

        public File f(int i7) throws IOException {
            File fileK;
            synchronized (a.this) {
                if (this.f13978a.f13987f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f13978a.f13986e) {
                    this.f13979b[i7] = true;
                }
                fileK = this.f13978a.k(i7);
                if (!a.this.f13963a.exists()) {
                    a.this.f13963a.mkdirs();
                }
            }
            return fileK;
        }

        public String g(int i7) throws IOException {
            InputStream inputStreamH = h(i7);
            if (inputStreamH != null) {
                return a.l0(inputStreamH);
            }
            return null;
        }

        public void i(int i7, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(f(i7)), com.bumptech.glide.disklrucache.c.f14004b);
                try {
                    outputStreamWriter2.write(str);
                    com.bumptech.glide.disklrucache.c.a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.bumptech.glide.disklrucache.c.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private b(c cVar) {
            this.f13978a = cVar;
            this.f13979b = cVar.f13986e ? null : new boolean[a.this.f13969g];
        }
    }

    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f13983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f13984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f13985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f13986e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private b f13987f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f13988g;

        /* synthetic */ c(a aVar, String str, CallableC0160a callableC0160a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f13969g) {
                throw m(strArr);
            }
            for (int i7 = 0; i7 < strArr.length; i7++) {
                try {
                    this.f13983b[i7] = Long.parseLong(strArr[i7]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i7) {
            return this.f13984c[i7];
        }

        public File k(int i7) {
            return this.f13985d[i7];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j7 : this.f13983b) {
                sb.append(' ');
                sb.append(j7);
            }
            return sb.toString();
        }

        private c(String str) {
            this.f13982a = str;
            this.f13983b = new long[a.this.f13969g];
            this.f13984c = new File[a.this.f13969g];
            this.f13985d = new File[a.this.f13969g];
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i7 = 0; i7 < a.this.f13969g; i7++) {
                sb.append(i7);
                this.f13984c[i7] = new File(a.this.f13963a, sb.toString());
                sb.append(".tmp");
                this.f13985d[i7] = new File(a.this.f13963a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f13991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f13992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f13993d;

        /* synthetic */ d(a aVar, String str, long j7, File[] fileArr, long[] jArr, CallableC0160a callableC0160a) {
            this(str, j7, fileArr, jArr);
        }

        public b a() throws IOException {
            return a.this.K(this.f13990a, this.f13991b);
        }

        public File b(int i7) {
            return this.f13993d[i7];
        }

        public long c(int i7) {
            return this.f13992c[i7];
        }

        public String d(int i7) throws IOException {
            return a.l0(new FileInputStream(this.f13993d[i7]));
        }

        private d(String str, long j7, File[] fileArr, long[] jArr) {
            this.f13990a = str;
            this.f13991b = j7;
            this.f13993d = fileArr;
            this.f13992c = jArr;
        }
    }

    private a(File file, int i7, int i8, long j7) {
        this.f13963a = file;
        this.f13967e = i7;
        this.f13964b = new File(file, f13953o);
        this.f13965c = new File(file, f13954p);
        this.f13966d = new File(file, f13955q);
        this.f13969g = i8;
        this.f13968f = j7;
    }

    private void C() {
        if (this.f13971i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E(b bVar, boolean z7) throws IOException {
        c cVar = bVar.f13978a;
        if (cVar.f13987f != bVar) {
            throw new IllegalStateException();
        }
        if (z7 && !cVar.f13986e) {
            for (int i7 = 0; i7 < this.f13969g; i7++) {
                if (!bVar.f13979b[i7]) {
                    bVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                }
                if (!cVar.k(i7).exists()) {
                    bVar.a();
                    return;
                }
            }
        }
        for (int i8 = 0; i8 < this.f13969g; i8++) {
            File fileK = cVar.k(i8);
            if (!z7) {
                G(fileK);
            } else if (fileK.exists()) {
                File fileJ = cVar.j(i8);
                fileK.renameTo(fileJ);
                long j7 = cVar.f13983b[i8];
                long length = fileJ.length();
                cVar.f13983b[i8] = length;
                this.f13970h = (this.f13970h - j7) + length;
            }
        }
        this.f13973k++;
        cVar.f13987f = null;
        if (cVar.f13986e || z7) {
            cVar.f13986e = true;
            this.f13971i.append((CharSequence) f13959u);
            this.f13971i.append(' ');
            this.f13971i.append((CharSequence) cVar.f13982a);
            this.f13971i.append((CharSequence) cVar.l());
            this.f13971i.append('\n');
            if (z7) {
                long j8 = this.f13974l;
                this.f13974l = 1 + j8;
                cVar.f13988g = j8;
            }
        } else {
            this.f13972j.remove(cVar.f13982a);
            this.f13971i.append((CharSequence) f13961w);
            this.f13971i.append(' ');
            this.f13971i.append((CharSequence) cVar.f13982a);
            this.f13971i.append('\n');
        }
        this.f13971i.flush();
        if (this.f13970h > this.f13968f || o0()) {
            this.f13975m.submit(this.f13976n);
        }
    }

    private static void G(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void I0(File file, File file2, boolean z7) throws IOException {
        if (z7) {
            G(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized b K(String str, long j7) throws IOException {
        C();
        c cVar = this.f13972j.get(str);
        CallableC0160a callableC0160a = null;
        if (j7 != -1 && (cVar == null || cVar.f13988g != j7)) {
            return null;
        }
        if (cVar == null) {
            cVar = new c(this, str, callableC0160a);
            this.f13972j.put(str, cVar);
        } else if (cVar.f13987f != null) {
            return null;
        }
        b bVar = new b(this, cVar, callableC0160a);
        cVar.f13987f = bVar;
        this.f13971i.append((CharSequence) f13960v);
        this.f13971i.append(' ');
        this.f13971i.append((CharSequence) str);
        this.f13971i.append('\n');
        this.f13971i.flush();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() throws IOException {
        while (this.f13970h > this.f13968f) {
            G0(this.f13972j.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l0(InputStream inputStream) throws IOException {
        return com.bumptech.glide.disklrucache.c.c(new InputStreamReader(inputStream, com.bumptech.glide.disklrucache.c.f14004b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o0() {
        int i7 = this.f13973k;
        return i7 >= 2000 && i7 >= this.f13972j.size();
    }

    public static a p0(File file, int i7, int i8, long j7) throws IOException {
        if (j7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f13955q);
        if (file2.exists()) {
            File file3 = new File(file, f13953o);
            if (file3.exists()) {
                file2.delete();
            } else {
                I0(file2, file3, false);
            }
        }
        a aVar = new a(file, i7, i8, j7);
        if (aVar.f13964b.exists()) {
            try {
                aVar.s0();
                aVar.r0();
                return aVar;
            } catch (IOException e8) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e8.getMessage() + ", removing");
                aVar.F();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i7, i8, j7);
        aVar2.x0();
        return aVar2;
    }

    private void r0() throws IOException {
        G(this.f13965c);
        Iterator<c> it = this.f13972j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i7 = 0;
            if (next.f13987f == null) {
                while (i7 < this.f13969g) {
                    this.f13970h += next.f13983b[i7];
                    i7++;
                }
            } else {
                next.f13987f = null;
                while (i7 < this.f13969g) {
                    G(next.j(i7));
                    G(next.k(i7));
                    i7++;
                }
                it.remove();
            }
        }
    }

    private void s0() throws IOException {
        com.bumptech.glide.disklrucache.b bVar = new com.bumptech.glide.disklrucache.b(new FileInputStream(this.f13964b), com.bumptech.glide.disklrucache.c.f14003a);
        try {
            String strR = bVar.r();
            String strR2 = bVar.r();
            String strR3 = bVar.r();
            String strR4 = bVar.r();
            String strR5 = bVar.r();
            if (!f13956r.equals(strR) || !"1".equals(strR2) || !Integer.toString(this.f13967e).equals(strR3) || !Integer.toString(this.f13969g).equals(strR4) || !"".equals(strR5)) {
                throw new IOException("unexpected journal header: [" + strR + ", " + strR2 + ", " + strR4 + ", " + strR5 + "]");
            }
            int i7 = 0;
            while (true) {
                try {
                    v0(bVar.r());
                    i7++;
                } catch (EOFException unused) {
                    this.f13973k = i7 - this.f13972j.size();
                    if (bVar.q()) {
                        x0();
                    } else {
                        this.f13971i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13964b, true), com.bumptech.glide.disklrucache.c.f14003a));
                    }
                    com.bumptech.glide.disklrucache.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.disklrucache.c.a(bVar);
            throw th;
        }
    }

    private void v0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i7 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i7);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i7);
            if (iIndexOf == 6 && str.startsWith(f13961w)) {
                this.f13972j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i7, iIndexOf2);
        }
        c cVar = this.f13972j.get(strSubstring);
        CallableC0160a callableC0160a = null;
        if (cVar == null) {
            cVar = new c(this, strSubstring, callableC0160a);
            this.f13972j.put(strSubstring, cVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(f13959u)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            cVar.f13986e = true;
            cVar.f13987f = null;
            cVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(f13960v)) {
            cVar.f13987f = new b(this, cVar, callableC0160a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(f13962x)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x0() throws IOException {
        Writer writer = this.f13971i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13965c), com.bumptech.glide.disklrucache.c.f14003a));
        try {
            bufferedWriter.write(f13956r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13967e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13969g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.f13972j.values()) {
                if (cVar.f13987f != null) {
                    bufferedWriter.write("DIRTY " + cVar.f13982a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f13982a + cVar.l() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f13964b.exists()) {
                I0(this.f13964b, this.f13966d, true);
            }
            I0(this.f13965c, this.f13964b, false);
            this.f13966d.delete();
            this.f13971i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13964b, true), com.bumptech.glide.disklrucache.c.f14003a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public void F() throws IOException {
        close();
        com.bumptech.glide.disklrucache.c.b(this.f13963a);
    }

    public synchronized boolean G0(String str) throws IOException {
        C();
        c cVar = this.f13972j.get(str);
        if (cVar != null && cVar.f13987f == null) {
            for (int i7 = 0; i7 < this.f13969g; i7++) {
                File fileJ = cVar.j(i7);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.f13970h -= cVar.f13983b[i7];
                cVar.f13983b[i7] = 0;
            }
            this.f13973k++;
            this.f13971i.append((CharSequence) f13961w);
            this.f13971i.append(' ');
            this.f13971i.append((CharSequence) str);
            this.f13971i.append('\n');
            this.f13972j.remove(str);
            if (o0()) {
                this.f13975m.submit(this.f13976n);
            }
            return true;
        }
        return false;
    }

    public b H(String str) throws IOException {
        return K(str, -1L);
    }

    public synchronized void J0(long j7) {
        this.f13968f = j7;
        this.f13975m.submit(this.f13976n);
    }

    public synchronized long L0() {
        return this.f13970h;
    }

    public synchronized d Q(String str) throws IOException {
        C();
        c cVar = this.f13972j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f13986e) {
            return null;
        }
        for (File file : cVar.f13984c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f13973k++;
        this.f13971i.append((CharSequence) f13962x);
        this.f13971i.append(' ');
        this.f13971i.append((CharSequence) str);
        this.f13971i.append('\n');
        if (o0()) {
            this.f13975m.submit(this.f13976n);
        }
        return new d(this, str, cVar.f13988g, cVar.f13984c, cVar.f13983b, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f13971i == null) {
            return;
        }
        for (c cVar : new ArrayList(this.f13972j.values())) {
            if (cVar.f13987f != null) {
                cVar.f13987f.a();
            }
        }
        Q0();
        this.f13971i.close();
        this.f13971i = null;
    }

    public synchronized void flush() throws IOException {
        C();
        Q0();
        this.f13971i.flush();
    }

    public File g0() {
        return this.f13963a;
    }

    public synchronized long h0() {
        return this.f13968f;
    }

    public synchronized boolean isClosed() {
        return this.f13971i == null;
    }
}
