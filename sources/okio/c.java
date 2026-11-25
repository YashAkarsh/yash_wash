package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
@kotlin.k(message = "changed in Okio 2.x")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f38422a = new c();

    private c() {
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    public final m0 a(@a7.d File file) {
        kotlin.jvm.internal.l0.p(file, "file");
        return a0.a(file);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    public final m0 b() {
        return a0.b();
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "sink.buffer()", imports = {"okio.buffer"}))
    public final n c(@a7.d m0 sink) {
        kotlin.jvm.internal.l0.p(sink, "sink");
        return a0.c(sink);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "source.buffer()", imports = {"okio.buffer"}))
    public final o d(@a7.d o0 source) {
        kotlin.jvm.internal.l0.p(source, "source");
        return a0.d(source);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "file.sink()", imports = {"okio.sink"}))
    public final m0 e(@a7.d File file) {
        kotlin.jvm.internal.l0.p(file, "file");
        return b0.j(file, false, 1, null);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "outputStream.sink()", imports = {"okio.sink"}))
    public final m0 f(@a7.d OutputStream outputStream) {
        kotlin.jvm.internal.l0.p(outputStream, "outputStream");
        return a0.h(outputStream);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "socket.sink()", imports = {"okio.sink"}))
    public final m0 g(@a7.d Socket socket) {
        kotlin.jvm.internal.l0.p(socket, "socket");
        return a0.i(socket);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "path.sink(*options)", imports = {"okio.sink"}))
    public final m0 h(@a7.d Path path, @a7.d OpenOption... options) {
        kotlin.jvm.internal.l0.p(path, "path");
        kotlin.jvm.internal.l0.p(options, "options");
        return a0.j(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "file.source()", imports = {"okio.source"}))
    public final o0 i(@a7.d File file) {
        kotlin.jvm.internal.l0.p(file, "file");
        return a0.l(file);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "inputStream.source()", imports = {"okio.source"}))
    public final o0 j(@a7.d InputStream inputStream) {
        kotlin.jvm.internal.l0.p(inputStream, "inputStream");
        return a0.m(inputStream);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "socket.source()", imports = {"okio.source"}))
    public final o0 k(@a7.d Socket socket) {
        kotlin.jvm.internal.l0.p(socket, "socket");
        return a0.n(socket);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "path.source(*options)", imports = {"okio.source"}))
    public final o0 l(@a7.d Path path, @a7.d OpenOption... options) {
        kotlin.jvm.internal.l0.p(path, "path");
        kotlin.jvm.internal.l0.p(options, "options");
        return a0.o(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }
}
