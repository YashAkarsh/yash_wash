package com.haier.library.okhttp.b.h;

import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27350a = new C0359a();

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.h.a$a, reason: collision with other inner class name */
    static class C0359a implements a {
        C0359a() {
        }

        @Override // com.haier.library.okhttp.b.h.a
        public b0 a(File file) throws FileNotFoundException {
            try {
                return t.l(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.l(file);
            }
        }

        @Override // com.haier.library.okhttp.b.h.a
        public b0 b(File file) throws FileNotFoundException {
            try {
                return t.p(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.p(file);
            }
        }

        @Override // com.haier.library.okhttp.b.h.a
        public void c(File file, File file2) throws IOException {
            d(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // com.haier.library.okhttp.b.h.a
        public void d(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.haier.library.okhttp.b.h.a
        public boolean e(File file) {
            return file.exists();
        }

        @Override // com.haier.library.okhttp.b.h.a
        public long f(File file) {
            return file.length();
        }

        @Override // com.haier.library.okhttp.b.h.a
        public void g(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // com.haier.library.okhttp.b.h.a
        public c0 h(File file) throws FileNotFoundException {
            return t.g(file);
        }
    }

    b0 a(File file) throws FileNotFoundException;

    b0 b(File file) throws FileNotFoundException;

    void c(File file, File file2) throws IOException;

    void d(File file) throws IOException;

    boolean e(File file);

    long f(File file);

    void g(File file) throws IOException;

    c0 h(File file) throws FileNotFoundException;
}
