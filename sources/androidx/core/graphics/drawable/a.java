package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    @a7.d
    public static final BitmapDrawable a(@a7.d Bitmap bitmap, @a7.d Resources resources) {
        l0.p(bitmap, "<this>");
        l0.p(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
