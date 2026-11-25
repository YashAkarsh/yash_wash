package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes.dex */
public final class m2 {
    @a7.d
    public static final PorterDuffColorFilter a(@a7.d PorterDuff.Mode mode, int i7) {
        kotlin.jvm.internal.l0.p(mode, "<this>");
        return new PorterDuffColorFilter(i7, mode);
    }

    @a7.d
    public static final PorterDuffXfermode b(@a7.d PorterDuff.Mode mode) {
        kotlin.jvm.internal.l0.p(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
