package org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ContentUriUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38647a = "ContentUriUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f38648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f38649c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f38650d = false;

    public interface a {
        Uri a(File file);
    }

    private ContentUriUtils() {
    }

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

    private static AssetFileDescriptor b(String str) {
        ContentResolver contentResolver = o.e().getContentResolver();
        Uri uri = Uri.parse(str);
        try {
            try {
                if (g(uri)) {
                    String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
                    if (streamTypes != null && streamTypes.length > 0) {
                        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, streamTypes[0], null);
                        if (assetFileDescriptorOpenTypedAssetFileDescriptor == null || assetFileDescriptorOpenTypedAssetFileDescriptor.getStartOffset() == 0) {
                            return assetFileDescriptorOpenTypedAssetFileDescriptor;
                        }
                        try {
                            assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                        throw new SecurityException("Cannot open files with non-zero offset type.");
                    }
                } else {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        return new AssetFileDescriptor(parcelFileDescriptorOpenFileDescriptor, 0L, -1L);
                    }
                }
            } catch (FileNotFoundException e8) {
                Log.w(f38647a, "Cannot find content uri: " + str, e8);
            }
        } catch (SecurityException e9) {
            Log.w(f38647a, "Cannot open content uri: " + str, e9);
        } catch (Exception e10) {
            Log.w(f38647a, "Unknown content uri: " + str, e10);
        }
        return null;
    }

    public static Uri c(File file) {
        synchronized (f38649c) {
            a aVar = f38648b;
            if (aVar == null) {
                return null;
            }
            return aVar.a(file);
        }
    }

    @CalledByNative
    public static boolean contentUriExists(String str) {
        AssetFileDescriptor assetFileDescriptorB = b(str);
        boolean z7 = assetFileDescriptorB != null;
        if (assetFileDescriptorB != null) {
            try {
                assetFileDescriptorB.close();
            } catch (IOException unused) {
            }
        }
        return z7;
    }

    public static String d(Uri uri, Context context, String str) throws Exception {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() >= 1) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex(str);
                        if (columnIndex == -1) {
                            a(null, cursorQuery);
                            return "";
                        }
                        String string = cursorQuery.getString(columnIndex);
                        if (e(cursorQuery) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                            string = string + com.alibaba.android.arouter.utils.b.f12515h + extensionFromMimeType;
                        }
                        a(null, cursorQuery);
                        return string;
                        return "";
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        a(th, cursorQuery);
                        throw th2;
                    }
                }
            }
            if (cursorQuery != null) {
                a(null, cursorQuery);
            }
        } catch (NullPointerException unused) {
        }
        return "";
    }

    @CalledByNative
    public static void delete(String str) {
        o.e().getContentResolver().delete(Uri.parse(str), null, null);
    }

    private static boolean e(Cursor cursor) {
        int columnIndex;
        return Build.VERSION.SDK_INT >= 24 && (columnIndex = cursor.getColumnIndex("flags")) > -1 && (cursor.getLong(columnIndex) & 512) != 0;
    }

    public static boolean f(String str) {
        Uri uri;
        return (str == null || (uri = Uri.parse(str)) == null || !"content".equals(uri.getScheme())) ? false : true;
    }

    private static boolean g(Uri uri) throws Exception {
        if (uri == null || !DocumentsContract.isDocumentUri(o.e(), uri)) {
            return false;
        }
        try {
            Cursor cursorQuery = o.e().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() >= 1) {
                        cursorQuery.moveToFirst();
                        boolean zE = e(cursorQuery);
                        a(null, cursorQuery);
                        return zE;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        a(th, cursorQuery);
                        throw th2;
                    }
                }
            }
            if (cursorQuery != null) {
                a(null, cursorQuery);
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    @CalledByNative
    public static String getMimeType(String str) {
        ContentResolver contentResolver = o.e().getContentResolver();
        Uri uri = Uri.parse(str);
        if (!g(uri)) {
            return contentResolver.getType(uri);
        }
        String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
        if (streamTypes == null || streamTypes.length <= 0) {
            return null;
        }
        return streamTypes[0];
    }

    public static void h(a aVar) {
        synchronized (f38649c) {
            f38648b = aVar;
        }
    }

    @c.o0
    @CalledByNative
    public static String maybeGetDisplayName(String str) {
        try {
            String strD = d(Uri.parse(str), o.e(), "_display_name");
            if (TextUtils.isEmpty(strD)) {
                return null;
            }
            return strD;
        } catch (Exception e8) {
            Log.w(f38647a, "Cannot open content uri: " + str, e8);
            return null;
        }
    }

    @CalledByNative
    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptorB = b(str);
        if (assetFileDescriptorB != null) {
            return assetFileDescriptorB.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }
}
