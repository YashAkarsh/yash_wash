package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f38421a = Logger.getLogger("okio.Okio");

    @a7.d
    public static final m0 b(@a7.d File appendingSink) throws FileNotFoundException {
        kotlin.jvm.internal.l0.p(appendingSink, "$this$appendingSink");
        return a0.h(new FileOutputStream(appendingSink, true));
    }

    private static final Logger c() {
        return f38421a;
    }

    public static final boolean d(@a7.d AssertionError isAndroidGetsocknameError) {
        kotlin.jvm.internal.l0.p(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = isAndroidGetsocknameError.getMessage();
        return message != null ? kotlin.text.c0.V2(message, "getsockname failed", false, 2, null) : false;
    }

    @a7.d
    @h5.i
    public static final m0 e(@a7.d File file) throws FileNotFoundException {
        return j(file, false, 1, null);
    }

    @a7.d
    @h5.i
    public static final m0 f(@a7.d File sink, boolean z7) throws FileNotFoundException {
        kotlin.jvm.internal.l0.p(sink, "$this$sink");
        return a0.h(new FileOutputStream(sink, z7));
    }

    @a7.d
    public static final m0 g(@a7.d OutputStream sink) {
        kotlin.jvm.internal.l0.p(sink, "$this$sink");
        return new e0(sink, new q0());
    }

    @a7.d
    public static final m0 h(@a7.d Socket sink) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "$this$sink");
        n0 n0Var = new n0(sink);
        OutputStream outputStream = sink.getOutputStream();
        kotlin.jvm.internal.l0.o(outputStream, "getOutputStream()");
        return n0Var.z(new e0(outputStream, n0Var));
    }

    @a7.d
    @z6.a
    public static final m0 i(@a7.d Path sink, @a7.d OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(sink, "$this$sink");
        kotlin.jvm.internal.l0.p(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return a0.h(outputStreamNewOutputStream);
    }

    public static /* synthetic */ m0 j(File file, boolean z7, int i7, Object obj) throws FileNotFoundException {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return a0.g(file, z7);
    }

    @a7.d
    public static final o0 k(@a7.d File source) throws FileNotFoundException {
        kotlin.jvm.internal.l0.p(source, "$this$source");
        return a0.m(new FileInputStream(source));
    }

    @a7.d
    public static final o0 l(@a7.d InputStream source) {
        kotlin.jvm.internal.l0.p(source, "$this$source");
        return new z(source, new q0());
    }

    @a7.d
    public static final o0 m(@a7.d Socket source) throws IOException {
        kotlin.jvm.internal.l0.p(source, "$this$source");
        n0 n0Var = new n0(source);
        InputStream inputStream = source.getInputStream();
        kotlin.jvm.internal.l0.o(inputStream, "getInputStream()");
        return n0Var.A(new z(inputStream, n0Var));
    }

    @a7.d
    @z6.a
    public static final o0 n(@a7.d Path source, @a7.d OpenOption... options) throws IOException {
        kotlin.jvm.internal.l0.p(source, "$this$source");
        kotlin.jvm.internal.l0.p(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(source, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.l0.o(inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return a0.m(inputStreamNewInputStream);
    }
}
