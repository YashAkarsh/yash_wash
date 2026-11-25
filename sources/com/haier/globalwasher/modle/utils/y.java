package com.haier.globalwasher.modle.utils;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes2.dex */
public class y {
    public static long a() {
        if (!d()) {
            return 0L;
        }
        StatFs statFs = new StatFs(c());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
    }

    public static long b() {
        if (!d()) {
            return 0L;
        }
        StatFs statFs = new StatFs(c());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static String c() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean d() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
