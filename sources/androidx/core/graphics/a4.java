package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5774a = "TypefaceCompatUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5775b = ".font";

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static ParcelFileDescriptor a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }

    private a4() {
    }

    public static void a(@c.o0 Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @c.o0
    @c.t0(19)
    public static ByteBuffer b(@c.m0 Context context, @c.m0 Resources resources, int i7) {
        File fileE = e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (c(fileE, resources, i7)) {
                return g(fileE);
            }
            return null;
        } finally {
            fileE.delete();
        }
    }

    public static boolean c(@c.m0 File file, @c.m0 Resources resources, int i7) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i7);
            try {
                boolean zD = d(file, inputStreamOpenRawResource);
                a(inputStreamOpenRawResource);
                return zD;
            } catch (Throwable th) {
                th = th;
                a(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean d(@c.m0 File file, @c.m0 InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i7 = inputStream.read(bArr);
                        if (i7 == -1) {
                            a(fileOutputStream2);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i7);
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = fileOutputStream2;
                    Log.e(f5774a, "Error copying resource contents to temp file: " + e.getMessage());
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @c.o0
    public static File e(@c.m0 Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = f5775b + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i7 = 0; i7 < 100; i7++) {
            File file = new File(cacheDir, str + i7);
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    @c.o0
    @c.t0(19)
    public static ByteBuffer f(@c.m0 Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorA = a.a(context.getContentResolver(), uri, "r", cancellationSignal);
            if (parcelFileDescriptorA == null) {
                if (parcelFileDescriptorA != null) {
                    parcelFileDescriptorA.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorA.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorA.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorA.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @c.o0
    @c.t0(19)
    private static ByteBuffer g(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @c.t0(19)
    @c.x0({c.x0.a.LIBRARY})
    @c.m0
    public static Map<Uri, ByteBuffer> h(@c.m0 Context context, @c.m0 androidx.core.provider.j.c[] cVarArr, @c.o0 CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (androidx.core.provider.j.c cVar : cVarArr) {
            if (cVar.b() == 0) {
                Uri uriD = cVar.d();
                if (!map.containsKey(uriD)) {
                    map.put(uriD, f(context, cancellationSignal, uriD));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
