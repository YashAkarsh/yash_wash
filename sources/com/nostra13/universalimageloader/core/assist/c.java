package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c extends FilterInputStream {
    public c(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j7) throws IOException {
        long j8 = 0;
        while (j8 < j7) {
            long jSkip = ((FilterInputStream) this).in.skip(j7 - j8);
            if (jSkip == 0) {
                if (read() < 0) {
                    break;
                }
                jSkip = 1;
            }
            j8 += jSkip;
        }
        return j8;
    }
}
