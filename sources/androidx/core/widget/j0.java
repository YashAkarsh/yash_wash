package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public interface j0 {
    @o0
    ColorStateList getSupportImageTintList();

    @o0
    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(@o0 ColorStateList colorStateList);

    void setSupportImageTintMode(@o0 PorterDuff.Mode mode);
}
