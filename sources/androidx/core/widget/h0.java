package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public interface h0 {
    @o0
    ColorStateList getSupportButtonTintList();

    @o0
    PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@o0 ColorStateList colorStateList);

    void setSupportButtonTintMode(@o0 PorterDuff.Mode mode);
}
