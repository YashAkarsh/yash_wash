package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class z1 {

    public static final class a implements ImageDecoder.OnHeaderDecodedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.q<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, kotlin.l2> f5910a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i5.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, kotlin.l2> qVar) {
            this.f5910a = qVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(@a7.d ImageDecoder decoder, @a7.d ImageDecoder.ImageInfo info, @a7.d ImageDecoder.Source source) {
            kotlin.jvm.internal.l0.p(decoder, "decoder");
            kotlin.jvm.internal.l0.p(info, "info");
            kotlin.jvm.internal.l0.p(source, "source");
            this.f5910a.v(decoder, info, source);
        }
    }

    public static final class b implements ImageDecoder.OnHeaderDecodedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.q<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, kotlin.l2> f5911a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(i5.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, kotlin.l2> qVar) {
            this.f5911a = qVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(@a7.d ImageDecoder decoder, @a7.d ImageDecoder.ImageInfo info, @a7.d ImageDecoder.Source source) {
            kotlin.jvm.internal.l0.p(decoder, "decoder");
            kotlin.jvm.internal.l0.p(info, "info");
            kotlin.jvm.internal.l0.p(source, "source");
            this.f5911a.v(decoder, info, source);
        }
    }

    @a7.d
    @c.t0(28)
    public static final Bitmap a(@a7.d ImageDecoder.Source source, @a7.d i5.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, kotlin.l2> action) throws IOException {
        kotlin.jvm.internal.l0.p(source, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, w1.a(new a(action)));
        kotlin.jvm.internal.l0.o(bitmapDecodeBitmap, "crossinline action: Imag…ction(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @a7.d
    @c.t0(28)
    public static final Drawable b(@a7.d ImageDecoder.Source source, @a7.d i5.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, kotlin.l2> action) throws IOException {
        kotlin.jvm.internal.l0.p(source, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, w1.a(new b(action)));
        kotlin.jvm.internal.l0.o(drawableDecodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
