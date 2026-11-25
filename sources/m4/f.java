package m4;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean A(Uri uri) {
        return "com.fihtdc.filemanager.provider".equals(uri.getAuthority());
    }

    public static boolean B(Uri uri) {
        return "com.coloros.fileprovider".equals(uri.getAuthority());
    }

    public static boolean C(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i7);
            }
        }
    }

    public static void b(String str, String str2) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            k4.b.s(str + " not exist");
            return;
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            try {
                k4.b.h("createNewFile: " + String.valueOf(file2.createNewFile()));
            } catch (IOException e8) {
                k4.b.h("createFile failed: " + e8.toString());
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (FileNotFoundException e9) {
                e = e9;
                k4.b.h(e.toString());
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            fileInputStream = null;
        }
        try {
            k4.b.e(String.format("copyFile from %s to %s", str, str2));
            a(fileInputStream, fileOutputStream);
        } catch (IOException e11) {
            k4.b.h(e11.toString());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public static void c(File file, Uri uri, Context context) throws Throwable {
        InputStream inputStreamOpenInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i7 = inputStreamOpenInputStream.read(bArr);
                                if (i7 <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i7);
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                            if (fileOutputStream2 == null) {
                                return;
                            } else {
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (inputStreamOpenInputStream != null) {
                                inputStreamOpenInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            throw th;
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
        }
        fileOutputStream.close();
    }

    /* JADX WARN: Code duplicated, block: B:81:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream] */
    public static void d(Context context, boolean z7, String str, String str2) throws Throwable {
        ?? fileOutputStream;
        Throwable th;
        Throwable th2;
        IOException e8;
        FileNotFoundException e9;
        Object obj;
        if (new File(str2).exists() && !z7) {
            return;
        }
        ?? r7 = 0;
         = 0;
         = 0;
         = 0;
        ?? r8 = 0;
        ?? r9 = 0;
        ?? r10 = 0;
        try {
            try {
                try {
                    context = context.getAssets().open(str);
                    try {
                        fileOutputStream = new FileOutputStream(str2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i7 = context.read(bArr, 0, 1024);
                                if (i7 < 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i7);
                                }
                            }
                            String str3 = "source = " + str + ", dest = " + str2;
                            k4.b.p(str3);
                            try {
                                fileOutputStream.close();
                                obj = str3;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                obj = e10;
                            }
                            context.close();
                            context = context;
                            r7 = obj;
                        } catch (FileNotFoundException e11) {
                            e9 = e11;
                            r8 = fileOutputStream;
                            e9.printStackTrace();
                            r7 = r8;
                            if (r8 != 0) {
                                try {
                                    r8.close();
                                    r7 = r8;
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                    r7 = e12;
                                }
                            }
                            if (context != 0) {
                                context.close();
                                context = context;
                                r7 = r7;
                            }
                        } catch (IOException e13) {
                            e8 = e13;
                            r9 = fileOutputStream;
                            e8.printStackTrace();
                            r7 = r9;
                            if (r9 != 0) {
                                try {
                                    r9.close();
                                    r7 = r9;
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                    r7 = e14;
                                }
                            }
                            if (context != 0) {
                                context.close();
                                context = context;
                                r7 = r7;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            r10 = fileOutputStream;
                            if (r10 != 0) {
                                try {
                                    r10.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (context != 0) {
                                throw th2;
                            }
                            try {
                                context.close();
                                throw th2;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                throw th2;
                            }
                        }
                    } catch (FileNotFoundException e17) {
                        e9 = e17;
                    } catch (IOException e18) {
                        e8 = e18;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (r10 != 0) {
                            r10.close();
                        }
                        if (context != 0) {
                            throw th2;
                        }
                        context.close();
                        throw th2;
                    }
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            } catch (FileNotFoundException e20) {
                e9 = e20;
                context = 0;
            } catch (IOException e21) {
                e8 = e21;
                context = 0;
            } catch (Throwable th5) {
                th2 = th5;
                context = 0;
            }
        } catch (Throwable th6) {
            fileOutputStream = r7;
            th = th6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:84:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream] */
    public static void e(AssetManager assetManager, boolean z7, String str, String str2) throws Throwable {
        ?? fileOutputStream;
        Throwable th;
        Throwable th2;
        IOException e8;
        FileNotFoundException e9;
        Object obj;
        if (new File(str2).exists() && !z7) {
            return;
        }
        ?? r7 = 0;
         = 0;
         = 0;
         = 0;
        ?? r8 = 0;
        ?? r9 = 0;
        ?? r10 = 0;
        try {
            try {
                try {
                    assetManager = assetManager.open(str);
                    try {
                        fileOutputStream = new FileOutputStream(str2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i7 = assetManager.read(bArr, 0, 1024);
                                if (i7 < 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i7);
                                }
                            }
                            String str3 = "source = " + str + ", dest = " + str2;
                            k4.b.p(str3);
                            try {
                                fileOutputStream.close();
                                obj = str3;
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                obj = e10;
                            }
                            assetManager.close();
                            assetManager = assetManager;
                            r7 = obj;
                        } catch (FileNotFoundException e11) {
                            e9 = e11;
                            r8 = fileOutputStream;
                            e9.printStackTrace();
                            r7 = r8;
                            if (r8 != 0) {
                                try {
                                    r8.close();
                                    r7 = r8;
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                    r7 = e12;
                                }
                            }
                            if (assetManager != 0) {
                                assetManager.close();
                                assetManager = assetManager;
                                r7 = r7;
                            }
                        } catch (IOException e13) {
                            e8 = e13;
                            r9 = fileOutputStream;
                            e8.printStackTrace();
                            r7 = r9;
                            if (r9 != 0) {
                                try {
                                    r9.close();
                                    r7 = r9;
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                    r7 = e14;
                                }
                            }
                            if (assetManager != 0) {
                                assetManager.close();
                                assetManager = assetManager;
                                r7 = r7;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            r10 = fileOutputStream;
                            if (r10 != 0) {
                                try {
                                    r10.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (assetManager != 0) {
                                throw th2;
                            }
                            try {
                                assetManager.close();
                                throw th2;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                throw th2;
                            }
                        }
                    } catch (FileNotFoundException e17) {
                        e9 = e17;
                    } catch (IOException e18) {
                        e8 = e18;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (r10 != 0) {
                            r10.close();
                        }
                        if (assetManager != 0) {
                            throw th2;
                        }
                        assetManager.close();
                        throw th2;
                    }
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            } catch (FileNotFoundException e20) {
                e9 = e20;
                assetManager = 0;
            } catch (IOException e21) {
                e8 = e21;
                assetManager = 0;
            } catch (Throwable th5) {
                th2 = th5;
                assetManager = 0;
            }
        } catch (Throwable th6) {
            fileOutputStream = r7;
            th = th6;
        }
    }

    public static File f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean g(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e8) {
            k4.b.h(e8.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static String h(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        ?? r7 = 0;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                            if (columnIndexOrThrow >= 0) {
                                String string = cursorQuery.getString(columnIndexOrThrow);
                                cursorQuery.close();
                                return string;
                            }
                            k4.b.s("column '_data' does not exist. ");
                        }
                    } catch (Exception e8) {
                        e = e8;
                        e.printStackTrace();
                        k4.b.s(e.toString());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
    }

    public static String i(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf2 = str.lastIndexOf(35);
        if (iLastIndexOf2 > 0) {
            str = str.substring(0, iLastIndexOf2);
        }
        int iLastIndexOf3 = str.lastIndexOf(63);
        if (iLastIndexOf3 > 0) {
            str = str.substring(0, iLastIndexOf3);
        }
        int iLastIndexOf4 = str.lastIndexOf(47);
        if (iLastIndexOf4 >= 0) {
            str = str.substring(iLastIndexOf4 + 1);
        }
        return (str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) < 0) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static String j(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf2 = str.lastIndexOf(35);
        k4.b.e("fragment=" + iLastIndexOf2);
        if (iLastIndexOf2 > 0) {
            str = str.substring(0, iLastIndexOf2);
        }
        int iLastIndexOf3 = str.lastIndexOf(63);
        k4.b.e("query=" + iLastIndexOf3);
        if (iLastIndexOf3 > 0) {
            str = str.substring(0, iLastIndexOf3);
        }
        int iLastIndexOf4 = str.lastIndexOf(47);
        if (iLastIndexOf4 >= 0) {
            str = str.substring(iLastIndexOf4 + 1);
        }
        return (str.isEmpty() || !Pattern.matches("[a-zA-Z_0-9\\+\\.\\-\\(\\)\\%]+", str) || (iLastIndexOf = str.lastIndexOf(46)) < 0) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static long k(String str) {
        File file = new File(str);
        if (!file.isDirectory()) {
            return file.length();
        }
        long jK = 0;
        for (File file2 : file.listFiles()) {
            jK += k(file2.getAbsolutePath());
        }
        return jK;
    }

    public static String l(Context context, Uri uri) throws Throwable {
        Uri uri2;
        try {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (w(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (v(uri)) {
                        String documentId = DocumentsContract.getDocumentId(uri);
                        String[] strArrSplit2 = documentId.split(":");
                        return "raw".equalsIgnoreCase(strArrSplit2[0]) ? strArrSplit2[1] : h(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    }
                    if (z(uri)) {
                        String[] strArrSplit3 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit3[0];
                        if (MessengerShareContentUtility.MEDIA_IMAGE.equals(str)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(str)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = "audio".equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
                        }
                        return h(context, uri2, "_id=?", new String[]{strArrSplit3[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    if (x(uri)) {
                        return uri.getLastPathSegment();
                    }
                    if (B(uri)) {
                        String path = uri.getPath();
                        File file = new File(path);
                        if (!file.exists()) {
                            return path.contains("/file_share/") ? path.replace("/file_share", "") : path;
                        }
                        k4.b.p(String.format(Locale.US, ">>>> %s\n%s\n%d", file.getPath(), file.getName(), Long.valueOf(file.length())));
                        return path;
                    }
                    if (y(uri)) {
                        String path2 = uri.getPath();
                        File file2 = new File(path2);
                        if (!file2.exists()) {
                            return path2.contains("/root/") ? path2.replace("/root", "") : path2;
                        }
                        k4.b.p(String.format(Locale.US, ">>>> %s\n%s\n%d", file2.getPath(), file2.getName(), Long.valueOf(file2.length())));
                        return path2;
                    }
                    if (!A(uri)) {
                        String strH = h(context, uri, null, null);
                        return !TextUtils.isEmpty(strH) ? strH : uri.getPath();
                    }
                    String path3 = uri.getPath();
                    File file3 = new File(path3);
                    if (!file3.exists()) {
                        return path3.contains("/shared_files/") ? path3.replace("/shared_files", "") : path3;
                    }
                    k4.b.p(String.format(Locale.US, ">>>> %s\n%s\n%d", file3.getPath(), file3.getName(), Long.valueOf(file3.length())));
                    return path3;
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    k4.b.p("file:" + uri.getPath());
                    return uri.getPath();
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            k4.b.h(e8.toString());
        }
        return null;
    }

    public static String m() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static File n(String str, String str2) {
        return o(str, str2, true);
    }

    public static File o(String str, String str2, boolean z7) {
        return p(r(str) + File.separator + str2, z7);
    }

    public static File p(String str, boolean z7) {
        File file = new File(str);
        try {
            if (!file.exists() && z7) {
                file.createNewFile();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return file;
    }

    public static File q(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        File file = new File(sb.toString());
        file.mkdirs();
        return file;
    }

    public static String r(String str) {
        return q(str).getAbsolutePath();
    }

    public static String s(File file) {
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        return t(file.getName());
    }

    public static String t(String str) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str) || str.endsWith(com.alibaba.android.arouter.utils.b.f12515h) || (iLastIndexOf = str.lastIndexOf(com.alibaba.android.arouter.utils.b.f12515h)) == -1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1).toLowerCase(Locale.US);
    }

    public static int u(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoInput(true);
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            return contentLength;
        } catch (Exception e8) {
            k4.b.h(e8.toString());
            return 0;
        }
    }

    public static boolean v(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean w(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean x(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean y(Uri uri) {
        return "com.huawei.hidisk.fileprovider".equals(uri.getAuthority());
    }

    public static boolean z(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
