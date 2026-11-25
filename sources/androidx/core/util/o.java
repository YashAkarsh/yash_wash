package androidx.core.util;

import android.util.Log;
import c.x0;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@Deprecated
public class o extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f6376b = new StringBuilder(128);

    public o(String str) {
        this.f6375a = str;
    }

    private void b() {
        if (this.f6376b.length() > 0) {
            Log.d(this.f6375a, this.f6376b.toString());
            StringBuilder sb = this.f6376b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        b();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            char c8 = cArr[i7 + i9];
            if (c8 == '\n') {
                b();
            } else {
                this.f6376b.append(c8);
            }
        }
    }
}
