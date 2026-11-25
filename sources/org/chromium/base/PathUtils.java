package org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.system.Os;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
public abstract class PathUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38697a = "PathUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38698b = "textures";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f38699c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f38700d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f38701e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f38702f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f38703g = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static FutureTask<String[]> f38704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f38705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f38706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f38707k = false;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f38708a = PathUtils.f();

        private a() {
        }
    }

    private PathUtils() {
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    @SuppressLint({"NewApi"})
    private static void d(String str, int i7) {
        try {
            Os.chmod(str, i7);
        } catch (Exception unused) {
            t.j(f38697a, "Failed to set permissions for path \"" + str + "\"", new Object[0]);
        }
    }

    private static String e(int i7) {
        return a.f38708a[i7];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] f() {
        try {
            if (!f38704h.cancel(false)) {
                return f38704h.get();
            }
            m0 m0VarQ = m0.q();
            try {
                String[] strArrI = i();
                if (m0VarQ != null) {
                    a(null, m0VarQ);
                }
                return strArrI;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (m0VarQ != null) {
                        a(th, m0VarQ);
                    }
                    throw th2;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public static void g(String str) {
        h(str, null);
    }

    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() throws Exception {
        m0 m0VarQ = m0.q();
        try {
            File[] externalFilesDirs = o.e().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
            if (m0VarQ != null) {
                a(null, m0VarQ);
            }
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < externalFilesDirs.length; i7++) {
                File file = externalFilesDirs[i7];
                if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                    arrayList.add(externalFilesDirs[i7].getAbsolutePath());
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m0VarQ != null) {
                    a(th, m0VarQ);
                }
                throw th2;
            }
        }
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return e(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return e(0);
    }

    @CalledByNative
    private static String getDownloadsDirectory() throws Exception {
        m0 m0VarE = m0.e();
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String path = BuildInfo.c() ? getAllPrivateDownloadsDirectories()[0] : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            RecordHistogram.t("Android.StrictMode.DownloadsDir", SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (m0VarE != null) {
                a(null, m0VarE);
            }
            return path;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (m0VarE != null) {
                    a(th, m0VarE);
                }
                throw th2;
            }
        }
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo applicationInfo = o.e().getApplicationInfo();
        int i7 = applicationInfo.flags;
        return ((i7 & 128) != 0 || (i7 & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return e(1);
    }

    public static void h(String str, String str2) {
        if (f38703g.getAndSet(true)) {
            return;
        }
        f38705i = str;
        f38706j = str2;
        f38704h = new FutureTask<>(new Callable() { // from class: org.chromium.base.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PathUtils.i();
            }
        });
        org.chromium.base.task.c.f38898g.execute(f38704h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] i() {
        String[] strArr = new String[3];
        Context contextE = o.e();
        String path = contextE.getDir(f38705i, 0).getPath();
        strArr[0] = path;
        d(path, 448);
        strArr[1] = contextE.getDir(f38698b, 0).getPath();
        if (contextE.getCacheDir() != null) {
            if (f38706j == null) {
                strArr[2] = contextE.getCacheDir().getPath();
            } else {
                strArr[2] = new File(contextE.getCacheDir(), f38706j).getPath();
            }
        }
        return strArr;
    }
}
