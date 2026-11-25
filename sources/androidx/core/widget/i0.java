package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public interface i0 {
    @o0
    ColorStateList getSupportCompoundDrawablesTintList();

    @o0
    PorterDuff.Mode getSupportCompoundDrawablesTintMode();

    void setSupportCompoundDrawablesTintList(@o0 ColorStateList colorStateList);

    void setSupportCompoundDrawablesTintMode(@o0 PorterDuff.Mode mode);
}
