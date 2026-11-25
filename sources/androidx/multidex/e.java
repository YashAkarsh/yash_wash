package androidx.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8748a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8749b = 101010256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8750c = 16384;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8752b;

        a() {
        }
    }

    e() {
    }

    static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        CRC32 crc32 = new CRC32();
        long j7 = aVar.f8752b;
        randomAccessFile.seek(aVar.f8751a);
        byte[] bArr = new byte[16384];
        int i7 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j7));
        while (i7 != -1) {
            crc32.update(bArr, 0, i7);
            j7 -= (long) i7;
            if (j7 == 0) {
                break;
            }
            i7 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j7));
        }
        return crc32.getValue();
    }

    static a b(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j7 = length - PlaybackStateCompat.C;
        long j8 = j7 >= 0 ? j7 : 0L;
        int iReverseBytes = Integer.reverseBytes(f8749b);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                a aVar = new a();
                aVar.f8752b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                aVar.f8751a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return aVar;
            }
            length--;
        } while (length >= j8);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
