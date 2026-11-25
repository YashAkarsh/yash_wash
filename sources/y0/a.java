package y0;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a implements f<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f40575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40576b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // y0.f
    public String a() {
        return "BitmapBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // y0.f
    public m<byte[]> b(m<Bitmap> mVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mVar.get().compress(this.f40575a, this.f40576b, byteArrayOutputStream);
        mVar.a();
        return new x0.a(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i7) {
        this.f40575a = compressFormat;
        this.f40576b = i7;
    }
}
