package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class g extends ByteArrayOutputStream {
    public g(int i7) {
        super(i7);
    }

    @a7.d
    public final byte[] b() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        l0.o(buf, "buf");
        return buf;
    }
}
