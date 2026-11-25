package androidx.test.runner.screenshot;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.test.annotation.Beta;
import c.g1;
import com.alibaba.android.arouter.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class BasicScreenCaptureProcessor implements ScreenCaptureProcessor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f10517e = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f10518f = Build.DEVICE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f10519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f10520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f10521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected File f10522d;

    public BasicScreenCaptureProcessor() {
        this(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "screenshots"));
    }

    @g1
    static void d(String deviceName) {
        f10518f = deviceName;
    }

    @g1
    static void e(int sdkInt) {
        f10517e = sdkInt;
    }

    @Override // androidx.test.runner.screenshot.ScreenCaptureProcessor
    public String a(ScreenCapture capture) throws Throwable {
        String strValueOf = String.valueOf(capture.c() == null ? b() : c(capture.c()));
        String lowerCase = capture.b().toString().toLowerCase();
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(lowerCase).length());
        sb.append(strValueOf);
        sb.append(b.f12515h);
        sb.append(lowerCase);
        String string = sb.toString();
        File file = this.f10522d;
        file.mkdirs();
        if (!file.isDirectory() && !file.canWrite()) {
            throw new IOException(String.format("The directory %s does not exist and could not be created or is not writable.", file));
        }
        File file2 = new File(file, string);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
            try {
                capture.a().compress(capture.b(), 100, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e8) {
                    Log.e(this.f10519a, "Could not close output steam.", e8);
                }
                return string;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e9) {
                        Log.e(this.f10519a, "Could not close output steam.", e9);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected String b() {
        String str = this.f10521c;
        String str2 = this.f10520b;
        String str3 = f10518f;
        int i7 = f10517e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str2);
        sb.append(i7);
        return c(sb.toString());
    }

    protected String c(String prefix) {
        String str = this.f10520b;
        String strValueOf = String.valueOf(UUID.randomUUID());
        StringBuilder sb = new StringBuilder(String.valueOf(prefix).length() + String.valueOf(str).length() + strValueOf.length());
        sb.append(prefix);
        sb.append(str);
        sb.append(strValueOf);
        return sb.toString();
    }

    BasicScreenCaptureProcessor(File defaultScreenshotPath) {
        this.f10519a = "BasicScreenCaptureProcessor";
        this.f10520b = "-";
        this.f10521c = "screenshot";
        this.f10522d = defaultScreenshotPath;
    }
}
