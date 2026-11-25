package okhttp3.internal.io;

import a7.d;
import h5.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okio.a0;
import okio.b0;
import okio.m0;
import okio.o0;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0509a f38218b = new C0509a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d
    @e
    public static final a f38217a = new C0509a.C0510a();

    /* JADX INFO: renamed from: okhttp3.internal.io.a$a, reason: collision with other inner class name */
    public static final class C0509a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0509a f38219a = null;

        /* JADX INFO: renamed from: okhttp3.internal.io.a$a$a, reason: collision with other inner class name */
        private static final class C0510a implements a {
            @Override // okhttp3.internal.io.a
            @d
            public o0 a(@d File file) throws FileNotFoundException {
                l0.p(file, "file");
                return a0.l(file);
            }

            @Override // okhttp3.internal.io.a
            @d
            public m0 b(@d File file) throws FileNotFoundException {
                l0.p(file, "file");
                try {
                    return b0.j(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return b0.j(file, false, 1, null);
                }
            }

            @Override // okhttp3.internal.io.a
            public void c(@d File directory) throws IOException {
                l0.p(directory, "directory");
                File[] fileArrListFiles = directory.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("not a readable directory: " + directory);
                }
                for (File file : fileArrListFiles) {
                    l0.o(file, "file");
                    if (file.isDirectory()) {
                        c(file);
                    }
                    if (!file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                }
            }

            @Override // okhttp3.internal.io.a
            public boolean d(@d File file) {
                l0.p(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.a
            public void e(@d File from, @d File to) throws IOException {
                l0.p(from, "from");
                l0.p(to, "to");
                f(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.a
            public void f(@d File file) throws IOException {
                l0.p(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override // okhttp3.internal.io.a
            @d
            public m0 g(@d File file) throws FileNotFoundException {
                l0.p(file, "file");
                try {
                    return a0.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return a0.a(file);
                }
            }

            @Override // okhttp3.internal.io.a
            public long h(@d File file) {
                l0.p(file, "file");
                return file.length();
            }

            @d
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private C0509a() {
        }

        public /* synthetic */ C0509a(w wVar) {
            this();
        }
    }

    @d
    o0 a(@d File file) throws FileNotFoundException;

    @d
    m0 b(@d File file) throws FileNotFoundException;

    void c(@d File file) throws IOException;

    boolean d(@d File file);

    void e(@d File file, @d File file2) throws IOException;

    void f(@d File file) throws IOException;

    @d
    m0 g(@d File file) throws FileNotFoundException;

    long h(@d File file);
}
