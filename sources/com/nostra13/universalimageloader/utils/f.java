package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32923a = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f32924b = "uil-images";

    private f() {
    }

    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z7) {
        File fileC = (z7 && "mounted".equals(Environment.getExternalStorageState()) && f(context)) ? c(context) : null;
        if (fileC == null) {
            fileC = context.getCacheDir();
        }
        if (fileC != null) {
            return fileC;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        d.i("Can't define system cache directory! '%s' will be used.", str);
        return new File(str);
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                d.i("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                d.g("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File d(Context context) {
        File fileA = a(context);
        File file = new File(fileA, f32924b);
        return (file.exists() || file.mkdir()) ? file : fileA;
    }

    public static File e(Context context, String str) {
        File file = ("mounted".equals(Environment.getExternalStorageState()) && f(context)) ? new File(Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    private static boolean f(Context context) {
        return context.checkCallingOrSelfPermission(f32923a) == 0;
    }
}
