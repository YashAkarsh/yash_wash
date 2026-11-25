package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.s;
import c.h1;
import c.o0;
import com.airbnb.lottie.utils.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12168a;

    public b(Context context) {
        this.f12168a = context.getApplicationContext();
    }

    private static String c(String str, a aVar, boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z7 ? aVar.b() : aVar.f12167a);
        return sb.toString();
    }

    @o0
    private File d(String str) throws FileNotFoundException {
        File file = new File(e(), c(str, a.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), c(str, a.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File e() {
        File file = new File(this.f12168a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void a() {
        File fileE = e();
        if (fileE.exists()) {
            File[] fileArrListFiles = fileE.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileE.listFiles()) {
                    file.delete();
                }
            }
            fileE.delete();
        }
    }

    @h1
    @o0
    s<a, InputStream> b(String str) {
        try {
            File fileD = d(str);
            if (fileD == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileD);
            a aVar = fileD.getAbsolutePath().endsWith(".zip") ? a.ZIP : a.JSON;
            f.a("Cache hit for " + str + " at " + fileD.getAbsolutePath());
            return new s<>(aVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void f(String str, a aVar) {
        File file = new File(e(), c(str, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        f.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        f.e("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + com.alibaba.android.arouter.utils.b.f12515h);
    }

    File g(String str, InputStream inputStream, a aVar) throws IOException {
        File file = new File(e(), c(str, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i7 = inputStream.read(bArr);
                    if (i7 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i7);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
