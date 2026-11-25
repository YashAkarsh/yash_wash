package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:tint", method = "setImageTintList", type = ImageView.class), @androidx.databinding.g(attribute = "android:tintMode", method = "setImageTintMode", type = ImageView.class)})
public class p {
    @androidx.databinding.d({"android:src"})
    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @androidx.databinding.d({"android:src"})
    public static void b(ImageView imageView, Uri uri) {
        imageView.setImageURI(uri);
    }

    @androidx.databinding.d({"android:src"})
    public static void c(ImageView imageView, String str) {
        if (str == null) {
            imageView.setImageURI(null);
        } else {
            imageView.setImageURI(Uri.parse(str));
        }
    }
}
