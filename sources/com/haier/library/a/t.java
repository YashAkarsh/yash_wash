package com.haier.library.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f26303a = Logger.getLogger(t.class.getName());

    static class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0 f26304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OutputStream f26305b;

        a(d0 d0Var, OutputStream outputStream) {
            this.f26304a = d0Var;
            this.f26305b = outputStream;
        }

        @Override // com.haier.library.a.b0
        public void I1(g gVar, long j7) throws IOException {
            com.haier.library.a.c.d(gVar.f26255b, 0L, j7);
            while (j7 > 0) {
                this.f26304a.j();
                y yVar = gVar.f26254a;
                int iMin = (int) Math.min(j7, yVar.f26333c - yVar.f26332b);
                this.f26305b.write(yVar.f26331a, yVar.f26332b, iMin);
                int i7 = yVar.f26332b + iMin;
                yVar.f26332b = i7;
                long j8 = iMin;
                j7 -= j8;
                gVar.f26255b -= j8;
                if (i7 == yVar.f26333c) {
                    gVar.f26254a = yVar.f();
                    z.b(yVar);
                }
            }
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return this.f26304a;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f26305b.close();
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            this.f26305b.flush();
        }

        public String toString() {
            return "sink(" + this.f26305b + ")";
        }
    }

    static class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0 f26306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InputStream f26307b;

        b(d0 d0Var, InputStream inputStream) {
            this.f26306a = d0Var;
            this.f26307b = inputStream;
        }

        @Override // com.haier.library.a.c0
        public long P0(g gVar, long j7) throws IOException {
            if (j7 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j7);
            }
            if (j7 == 0) {
                return 0L;
            }
            try {
                this.f26306a.j();
                y yVarZ1 = gVar.Z1(1);
                int i7 = this.f26307b.read(yVarZ1.f26331a, yVarZ1.f26333c, (int) Math.min(j7, 8192 - yVarZ1.f26333c));
                if (i7 == -1) {
                    return -1L;
                }
                yVarZ1.f26333c += i7;
                long j8 = i7;
                gVar.f26255b += j8;
                return j8;
            } catch (AssertionError e8) {
                if (t.k(e8)) {
                    throw new IOException(e8);
                }
                throw e8;
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return this.f26306a;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f26307b.close();
        }

        public String toString() {
            return "source(" + this.f26307b + ")";
        }
    }

    static class c implements b0 {
        c() {
        }

        @Override // com.haier.library.a.b0
        public void I1(g gVar, long j7) throws IOException {
            gVar.j0(j7);
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return d0.f26246d;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
        }
    }

    static class d extends com.haier.library.a.a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Socket f26308l;

        d(Socket socket) {
            this.f26308l = socket;
        }

        @Override // com.haier.library.a.a
        protected IOException m(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.f13674p);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.haier.library.a.a
        protected void n() {
            try {
                this.f26308l.close();
            } catch (AssertionError e8) {
                if (!t.k(e8)) {
                    throw e8;
                }
                t.f26303a.log(Level.WARNING, "Failed to close timed out socket " + this.f26308l, (Throwable) e8);
            } catch (Exception e9) {
                t.f26303a.log(Level.WARNING, "Failed to close timed out socket " + this.f26308l, (Throwable) e9);
            }
        }
    }

    private t() {
    }

    public static h a(b0 b0Var) {
        return new w(b0Var);
    }

    public static i b(c0 c0Var) {
        return new x(c0Var);
    }

    public static b0 c() {
        return new c();
    }

    public static b0 d(OutputStream outputStream) {
        return e(outputStream, new d0());
    }

    private static b0 e(OutputStream outputStream, d0 d0Var) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (d0Var != null) {
            return new a(d0Var, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static b0 f(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        com.haier.library.a.a aVarO = o(socket);
        return aVarO.k(e(socket.getOutputStream(), aVarO));
    }

    public static c0 g(File file) throws FileNotFoundException {
        if (file != null) {
            return h(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static c0 h(InputStream inputStream) {
        return i(inputStream, new d0());
    }

    private static c0 i(InputStream inputStream, d0 d0Var) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (d0Var != null) {
            return new b(d0Var, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    @z6.a
    public static c0 j(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return h(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    static boolean k(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static b0 l(File file) throws FileNotFoundException {
        if (file != null) {
            return d(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    @z6.a
    public static b0 m(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return d(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static c0 n(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        com.haier.library.a.a aVarO = o(socket);
        return aVarO.l(i(socket.getInputStream(), aVarO));
    }

    private static com.haier.library.a.a o(Socket socket) {
        return new d(socket);
    }

    public static b0 p(File file) throws FileNotFoundException {
        if (file != null) {
            return d(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }
}
