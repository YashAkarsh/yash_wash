package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class n {
    @a7.d
    @t0(26)
    public static final Icon a(@a7.d Bitmap bitmap) {
        l0.p(bitmap, "<this>");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        l0.o(iconCreateWithAdaptiveBitmap, "createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @a7.d
    @t0(26)
    public static final Icon b(@a7.d Bitmap bitmap) {
        l0.p(bitmap, "<this>");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        l0.o(iconCreateWithBitmap, "createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @a7.d
    @t0(26)
    public static final Icon c(@a7.d Uri uri) {
        l0.p(uri, "<this>");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        l0.o(iconCreateWithContentUri, "createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @a7.d
    @t0(26)
    public static final Icon d(@a7.d byte[] bArr) {
        l0.p(bArr, "<this>");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        l0.o(iconCreateWithData, "createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
