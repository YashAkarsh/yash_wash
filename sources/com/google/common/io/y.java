package com.google.common.io;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f22047a = Logger.getLogger(y.class.getName());

    private y() {
    }

    public static void a(Flushable flushable, boolean z7) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e8) {
            if (!z7) {
                throw e8;
            }
            f22047a.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e8);
        }
    }

    public static void b(Flushable flushable) {
        try {
            a(flushable, true);
        } catch (IOException e8) {
            f22047a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e8);
        }
    }
}
