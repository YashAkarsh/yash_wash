package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ByteBuffer f7513d;

    protected int a(int i7) {
        return this.f7510a + (i7 * this.f7512c);
    }

    protected void b(int i7, int i8, ByteBuffer byteBuffer) {
        this.f7513d = byteBuffer;
        if (byteBuffer != null) {
            this.f7510a = i7;
            this.f7511b = byteBuffer.getInt(i7 - 4);
            this.f7512c = i8;
        } else {
            this.f7510a = 0;
            this.f7511b = 0;
            this.f7512c = 0;
        }
    }

    protected int c() {
        return this.f7510a;
    }

    public int d() {
        return this.f7511b;
    }

    public void e() {
        b(0, 0, null);
    }
}
