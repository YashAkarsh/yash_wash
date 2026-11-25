package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class p {
    private p() {
    }

    static <T> ObjectAnimator a(T t7, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t7, property, (TypeConverter) null, path);
    }
}
