package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class f extends b {
    public f f(int i7, ByteBuffer byteBuffer) {
        b(i7, 1, byteBuffer);
        return this;
    }

    public byte g(int i7) {
        return this.f7513d.get(a(i7));
    }

    public int h(int i7) {
        return g(i7) & 255;
    }
}
