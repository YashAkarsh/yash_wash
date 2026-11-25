package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.g2;

/* JADX INFO: loaded from: classes.dex */
public final class s extends b {
    public s f(int i7, ByteBuffer byteBuffer) {
        b(i7, 2, byteBuffer);
        return this;
    }

    public short g(int i7) {
        return this.f7513d.getShort(a(i7));
    }

    public int h(int i7) {
        return g(i7) & g2.f34732d;
    }
}
