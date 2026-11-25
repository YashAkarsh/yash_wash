package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import androidx.test.InstrumentationRegistry;
import c.g1;

/* JADX INFO: loaded from: classes.dex */
public class UiAutomationWrapper {
    @g1
    UiAutomationWrapper() {
    }

    public Bitmap a() {
        return InstrumentationRegistry.c().getUiAutomation().takeScreenshot();
    }
}
