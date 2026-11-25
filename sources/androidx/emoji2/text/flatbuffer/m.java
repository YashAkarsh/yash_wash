package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class m extends b {
    public m f(int i7, ByteBuffer byteBuffer) {
        b(i7, 4, byteBuffer);
        return this;
    }

    public int g(int i7) {
        return this.f7513d.getInt(a(i7));
    }

    public long h(int i7) {
        return ((long) g(i7)) & 4294967295L;
    }
}
