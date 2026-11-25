package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.h;
import com.nostra13.universalimageloader.utils.d;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class c implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f32910c = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f32911d = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Reference<ImageView> f32912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f32913b;

    public c(ImageView imageView) {
        this(imageView, true);
    }

    private static int i(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(obj)).intValue();
            if (iIntValue <= 0 || iIntValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return iIntValue;
        } catch (Exception e8) {
            d.d(e8);
            return 0;
        }
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int a() {
        ImageView imageView = this.f32912a.get();
        return imageView == null ? super.hashCode() : imageView.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int b() {
        ImageView imageView = this.f32912a.get();
        int width = 0;
        if (imageView == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (this.f32913b && layoutParams != null && layoutParams.width != -2) {
            width = imageView.getWidth();
        }
        if (width <= 0 && layoutParams != null) {
            width = layoutParams.width;
        }
        return width <= 0 ? i(imageView, "mMaxWidth") : width;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean c(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ImageView imageView = this.f32912a.get();
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                return true;
            }
        } else {
            d.i(f32910c, new Object[0]);
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int e() {
        ImageView imageView = this.f32912a.get();
        int height = 0;
        if (imageView == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (this.f32913b && layoutParams != null && layoutParams.height != -2) {
            height = imageView.getHeight();
        }
        if (height <= 0 && layoutParams != null) {
            height = layoutParams.height;
        }
        return height <= 0 ? i(imageView, "mMaxHeight") : height;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean f() {
        return this.f32912a.get() == null;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public h g() {
        ImageView imageView = this.f32912a.get();
        if (imageView != null) {
            return h.a(imageView);
        }
        return null;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean h(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ImageView imageView = this.f32912a.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                return true;
            }
        } else {
            d.i(f32911d, new Object[0]);
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImageView d() {
        return this.f32912a.get();
    }

    public c(ImageView imageView, boolean z7) {
        this.f32912a = new WeakReference(imageView);
        this.f32913b = z7;
    }
}
