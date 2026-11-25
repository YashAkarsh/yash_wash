package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
final class b0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StringBuilder f7945b = new StringBuilder(128);

    b0(String str) {
        this.f7944a = str;
    }

    private void b() {
        if (this.f7945b.length() > 0) {
            Log.d(this.f7944a, this.f7945b.toString());
            StringBuilder sb = this.f7945b;
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
                this.f7945b.append(c8);
            }
        }
    }
}
