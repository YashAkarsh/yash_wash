package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.l0;
import okio.m;
import okio.o0;
import okio.y;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f38301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f38302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f38303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f38304d;

    public c(boolean z7) {
        this.f38304d = z7;
        m mVar = new m();
        this.f38301a = mVar;
        Inflater inflater = new Inflater(true);
        this.f38302b = inflater;
        this.f38303c = new y((o0) mVar, inflater);
    }

    public final void b(@a7.d m buffer) throws IOException {
        l0.p(buffer, "buffer");
        if (!(this.f38301a.B1() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.f38304d) {
            this.f38302b.reset();
        }
        this.f38301a.C0(buffer);
        this.f38301a.writeInt(65535);
        long bytesRead = this.f38302b.getBytesRead() + this.f38301a.B1();
        do {
            this.f38303c.b(buffer, Long.MAX_VALUE);
        } while (this.f38302b.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f38303c.close();
    }
}
