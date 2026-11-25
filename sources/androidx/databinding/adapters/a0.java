package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.Switch;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:thumb", method = "setThumbDrawable", type = Switch.class), @androidx.databinding.g(attribute = "android:track", method = "setTrackDrawable", type = Switch.class)})
@TargetApi(14)
public class a0 {
    @androidx.databinding.d({"android:switchTextAppearance"})
    public static void a(Switch r7, int i7) {
        r7.setSwitchTextAppearance(null, i7);
    }
}
