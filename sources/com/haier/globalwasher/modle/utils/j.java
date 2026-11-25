package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static void a(Context context) {
        c(context.getCacheDir());
        if (y.d()) {
            c(context.getExternalCacheDir());
        }
    }

    public static File b(Context context, String str) {
        return new File((y.d() ? context.getExternalCacheDir().getAbsolutePath() : context.getCacheDir().getAbsolutePath()) + File.separator + str);
    }

    public static void c(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : fileArrListFiles) {
                c(file2);
            }
            file.delete();
        }
    }

    public static File d(Context context, String str) {
        return new File(context.getExternalCacheDir() + File.separator + str);
    }

    public static File e() {
        return new File(Environment.getExternalStorageDirectory().getPath());
    }

    public static long f(File file) {
        long jF = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i7 = 0; i7 < fileArrListFiles.length; i7++) {
                jF += fileArrListFiles[i7].isDirectory() ? f(fileArrListFiles[i7]) : fileArrListFiles[i7].length();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return jF;
    }

    public static boolean g() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
