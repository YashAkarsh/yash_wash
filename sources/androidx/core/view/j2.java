package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* JADX INFO: loaded from: classes.dex */
public interface j2 {
    @c.o0
    ColorStateList getSupportBackgroundTintList();

    @c.o0
    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList);

    void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode);
}
