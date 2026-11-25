package x0;

import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class a implements m<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f40570a;

    public a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Bytes must not be null");
        }
        this.f40570a = bArr;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return this.f40570a.length;
    }

    @Override // com.bumptech.glide.load.engine.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f40570a;
    }
}
