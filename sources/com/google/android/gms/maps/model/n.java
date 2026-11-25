package com.google.android.gms.maps.model;

import c.o0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public abstract class n implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16700c;

    public n(int i7, int i8) {
        this.f16699b = i7;
        this.f16700c = i8;
    }

    @Override // com.google.android.gms.maps.model.m
    @o0
    public final Tile a(int i7, int i8, int i9) {
        URL urlB = b(i7, i8, i9);
        if (urlB == null) {
            return m.f16698a;
        }
        try {
            com.google.android.gms.internal.maps.p.b(4352);
            int i10 = this.f16699b;
            int i11 = this.f16700c;
            InputStream inputStream = urlB.openConnection().getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.google.android.gms.common.internal.u.l(inputStream, "from must not be null.");
            com.google.android.gms.common.internal.u.l(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int i12 = inputStream.read(bArr);
                if (i12 == -1) {
                    return new Tile(i10, i11, byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, i12);
            }
        } catch (IOException unused) {
            return null;
        } finally {
            com.google.android.gms.internal.maps.p.a();
        }
    }

    @o0
    public abstract URL b(int i7, int i8, int i9);
}
