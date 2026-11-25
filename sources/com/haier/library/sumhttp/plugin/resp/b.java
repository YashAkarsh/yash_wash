package com.haier.library.sumhttp.plugin.resp;

import com.haier.library.sumhttp.plugin.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b extends h<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f27970i;

    public b(File file) {
        this.f27970i = file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.haier.library.sumhttp.plugin.h
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean a(com.haier.library.okhttp.b bVar) throws com.haier.library.sumhttp.plugin.c, IOException {
        if (bVar == null) {
            return Boolean.FALSE;
        }
        InputStream inputStreamB = bVar.b();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f27970i);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i7 = inputStreamB.read(bArr, 0, 1024);
                    if (i7 == -1) {
                        Boolean bool = Boolean.TRUE;
                        fileOutputStream.close();
                        return bool;
                    }
                    fileOutputStream.write(bArr, 0, i7);
                    return Boolean.FALSE;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // com.haier.library.sumhttp.plugin.h
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean a(String str) throws com.haier.library.sumhttp.plugin.c {
        return null;
    }
}
