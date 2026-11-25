package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    static final Logger f22016a = Logger.getLogger(r.class.getName());

    private r() {
    }

    public static void a(Closeable closeable, boolean z7) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e8) {
            if (!z7) {
                throw e8;
            }
            f22016a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e8);
        }
    }

    public static void b(InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    public static void c(Reader reader) {
        try {
            a(reader, true);
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }
}
