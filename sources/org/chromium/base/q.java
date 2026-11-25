package org.chromium.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38859a = "FileUtils";

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static void b(List<String> list) {
        for (String str : list) {
            if (ContentUriUtils.f(str)) {
                ContentUriUtils.delete(str);
            } else {
                File file = new File(str);
                if (file.exists()) {
                    j(file);
                }
            }
        }
    }

    public static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i7);
            }
        }
    }

    public static void d(InputStream inputStream, File file) throws Exception {
        File file2 = new File(file.getPath() + ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            t.p(f38859a, "Writing to %s", file);
            c(inputStream, fileOutputStream);
            a(null, fileOutputStream);
            if (!file2.renameTo(file)) {
                throw new IOException();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a(th, fileOutputStream);
                throw th2;
            }
        }
    }

    public static boolean e(Context context, String str, File file) throws Exception {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                d(inputStreamOpen, file);
                if (inputStreamOpen == null) {
                    return true;
                }
                a(null, inputStreamOpen);
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamOpen != null) {
                        a(th, inputStreamOpen);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static String f(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1).toLowerCase(Locale.US);
    }

    public static Uri g(File file) {
        Uri uriC;
        try {
            uriC = ContentUriUtils.c(file);
        } catch (IllegalArgumentException e8) {
            t.j(f38859a, "Could not create content uri: " + e8, new Object[0]);
            uriC = null;
        }
        return uriC == null ? Uri.fromFile(file) : uriC;
    }

    @c.o0
    public static Bitmap h(Context context, Uri uri) throws Exception {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    t.B(f38859a, "Null ParcelFileDescriptor from uri " + uri, new Object[0]);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        a(null, parcelFileDescriptorOpenFileDescriptor);
                    }
                    return null;
                }
                FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                if (fileDescriptor == null) {
                    t.B(f38859a, "Null FileDescriptor from uri " + uri, new Object[0]);
                    a(null, parcelFileDescriptorOpenFileDescriptor);
                    return null;
                }
                Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                if (bitmapDecodeFileDescriptor != null) {
                    a(null, parcelFileDescriptorOpenFileDescriptor);
                    return bitmapDecodeFileDescriptor;
                }
                t.B(f38859a, "Failed to decode image from uri " + uri, new Object[0]);
                a(null, parcelFileDescriptorOpenFileDescriptor);
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        a(th, parcelFileDescriptorOpenFileDescriptor);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            t.B(f38859a, "IO exception when reading uri " + uri, new Object[0]);
            return null;
        }
    }

    @c.m0
    public static byte[] i(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean j(File file) {
        File[] fileArrListFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                j(file2);
            }
        }
        boolean zDelete = file.delete();
        if (!zDelete) {
            t.j(f38859a, "Failed to delete: %s", file);
        }
        return zDelete;
    }
}
