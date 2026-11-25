package g1;

import android.os.ParcelFileDescriptor;
import c.m0;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
@Deprecated
public final class q {
    private q() {
    }

    @c1.a
    public static void a(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    @c1.a
    public static void b(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @c1.a
    @Deprecated
    public static long c(@m0 InputStream inputStream, @m0 OutputStream outputStream) throws IOException {
        return d(inputStream, outputStream, false, 1024);
    }

    @c1.a
    @Deprecated
    public static long d(@m0 InputStream inputStream, @m0 OutputStream outputStream, boolean z7, int i7) throws IOException {
        byte[] bArr = new byte[i7];
        long j7 = 0;
        while (true) {
            try {
                int i8 = inputStream.read(bArr, 0, i7);
                if (i8 == -1) {
                    break;
                }
                j7 += (long) i8;
                outputStream.write(bArr, 0, i8);
            } catch (Throwable th) {
                if (z7) {
                    b(inputStream);
                    b(outputStream);
                }
                throw th;
            }
        }
        if (z7) {
            b(inputStream);
            b(outputStream);
        }
        return j7;
    }

    @c1.a
    public static boolean e(@m0 byte[] bArr) {
        if (bArr.length > 1) {
            if ((((bArr[1] & 255) << 8) | (bArr[0] & 255)) == 35615) {
                return true;
            }
        }
        return false;
    }

    @c1.a
    @m0
    @Deprecated
    public static byte[] f(@m0 InputStream inputStream) throws IOException {
        return g(inputStream, true);
    }

    @c1.a
    @m0
    @Deprecated
    public static byte[] g(@m0 InputStream inputStream, boolean z7) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(inputStream, byteArrayOutputStream, z7, 1024);
        return byteArrayOutputStream.toByteArray();
    }

    @c1.a
    @m0
    @Deprecated
    public static byte[] h(@m0 InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.google.android.gms.common.internal.u.k(inputStream);
        com.google.android.gms.common.internal.u.k(byteArrayOutputStream);
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
    }
}
