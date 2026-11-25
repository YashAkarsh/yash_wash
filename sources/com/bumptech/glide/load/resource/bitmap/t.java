package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class t implements com.bumptech.glide.load.resource.bitmap.a<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f14606c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14607d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f14608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14609b;

    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public t() {
        this(f14606c, -1);
    }

    private static int c(int i7) {
        if (i7 >= 0) {
            return i7;
        }
        throw new IllegalArgumentException("Requested frame must be non-negative");
    }

    @Override // com.bumptech.glide.load.resource.bitmap.a
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Bitmap b(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8, w0.a aVar) throws IOException {
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f14608a.a();
        mediaMetadataRetrieverA.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i9 = this.f14609b;
        Bitmap frameAtTime = i9 >= 0 ? mediaMetadataRetrieverA.getFrameAtTime(i9) : mediaMetadataRetrieverA.getFrameAtTime();
        mediaMetadataRetrieverA.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public t(int i7) {
        this(f14606c, c(i7));
    }

    t(a aVar) {
        this(aVar, -1);
    }

    t(a aVar, int i7) {
        this.f14608a = aVar;
        this.f14609b = i7;
    }
}
