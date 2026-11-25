package androidx.test.runner.screenshot;

import androidx.test.annotation.Beta;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Beta
public interface ScreenCaptureProcessor {
    String a(ScreenCapture capture) throws IOException;
}
