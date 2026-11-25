package androidx.tracing;

import android.os.Trace;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(18)
final class c {
    private c() {
    }

    public static void a(@m0 String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
