package androidx.tracing;

import android.os.Trace;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(29)
final class d {
    private d() {
    }

    public static void a(@m0 String str, int i7) {
        Trace.beginAsyncSection(str, i7);
    }

    public static void b(@m0 String str, int i7) {
        Trace.endAsyncSection(str, i7);
    }

    public static void c(@m0 String str, int i7) {
        Trace.setCounter(str, i7);
    }
}
