package androidx.core.widget;

import android.os.Build;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public interface b {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static final boolean f7024a0;

    static {
        f7024a0 = Build.VERSION.SDK_INT >= 27;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@m0 int[] iArr, int i7) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i7);
}
