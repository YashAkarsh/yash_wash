package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f7610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f7611b;

    public void a() {
        b(0, null);
    }

    protected void b(int i7, ByteBuffer byteBuffer) {
        this.f7611b = byteBuffer;
        if (byteBuffer != null) {
            this.f7610a = i7;
        } else {
            this.f7610a = 0;
        }
    }
}
