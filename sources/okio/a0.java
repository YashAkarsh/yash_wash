package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    @a7.d
    public static final m0 a(@a7.d File file) throws FileNotFoundException {
        return b0.b(file);
    }

    @a7.d
    @h5.h(name = "blackhole")
    public static final m0 b() {
        return c0.a();
    }

    @a7.d
    public static final n c(@a7.d m0 m0Var) {
        return c0.b(m0Var);
    }

    @a7.d
    public static final o d(@a7.d o0 o0Var) {
        return c0.c(o0Var);
    }

    public static final boolean e(@a7.d AssertionError assertionError) {
        return b0.d(assertionError);
    }

    @a7.d
    @h5.i
    public static final m0 f(@a7.d File file) throws FileNotFoundException {
        return b0.j(file, false, 1, null);
    }

    @a7.d
    @h5.i
    public static final m0 g(@a7.d File file, boolean z7) throws FileNotFoundException {
        return b0.f(file, z7);
    }

    @a7.d
    public static final m0 h(@a7.d OutputStream outputStream) {
        return b0.g(outputStream);
    }

    @a7.d
    public static final m0 i(@a7.d Socket socket) throws IOException {
        return b0.h(socket);
    }

    @a7.d
    @z6.a
    public static final m0 j(@a7.d Path path, @a7.d OpenOption... openOptionArr) throws IOException {
        return b0.i(path, openOptionArr);
    }

    @a7.d
    public static final o0 l(@a7.d File file) throws FileNotFoundException {
        return b0.k(file);
    }

    @a7.d
    public static final o0 m(@a7.d InputStream inputStream) {
        return b0.l(inputStream);
    }

    @a7.d
    public static final o0 n(@a7.d Socket socket) throws IOException {
        return b0.m(socket);
    }

    @a7.d
    @z6.a
    public static final o0 o(@a7.d Path path, @a7.d OpenOption... openOptionArr) throws IOException {
        return b0.n(path, openOptionArr);
    }
}
