package com.nostra13.universalimageloader.utils;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private a() {
    }

    public static File a(String str, com.nostra13.universalimageloader.cache.disc.b bVar) {
        File fileC = bVar.c(str);
        if (fileC.exists()) {
            return fileC;
        }
        return null;
    }

    public static boolean b(String str, com.nostra13.universalimageloader.cache.disc.b bVar) {
        return bVar.c(str).delete();
    }
}
