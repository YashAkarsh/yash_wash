package okhttp3.internal.cache2;

import a7.d;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.l0;
import okio.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f37697a;

    public a(@d FileChannel fileChannel) {
        l0.p(fileChannel, "fileChannel");
        this.f37697a = fileChannel;
    }

    public final void a(long j7, @d m sink, long j8) throws IOException {
        l0.p(sink, "sink");
        if (j8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j8 > 0) {
            long jTransferTo = this.f37697a.transferTo(j7, j8, sink);
            j7 += jTransferTo;
            j8 -= jTransferTo;
        }
    }

    public final void b(long j7, @d m source, long j8) throws IOException {
        l0.p(source, "source");
        if (j8 < 0 || j8 > source.B1()) {
            throw new IndexOutOfBoundsException();
        }
        while (j8 > 0) {
            long jTransferFrom = this.f37697a.transferFrom(source, j7, j8);
            j7 += jTransferFrom;
            j8 -= jTransferFrom;
        }
    }
}
