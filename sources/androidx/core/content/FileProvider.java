package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import c.g1;
import c.i1;
import c.m0;
import c.o0;
import c.t0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5596d = "android.support.FILE_PROVIDER_PATHS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5597e = "root-path";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f5598f = "files-path";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5599g = "cache-path";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5600h = "external-path";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5601i = "external-files-path";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f5602j = "external-cache-path";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5603k = "external-media-path";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f5604l = "name";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f5605m = "path";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f5606n = "displayName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f5595c = {"_display_name", "_size"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final File f5607o = new File("/");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @c.z("sCache")
    private static final HashMap<String, b> f5608p = new HashMap<>();

    @t0(21)
    static class a {
        private a() {
        }

        @c.t
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HashMap<String, File> f5612b = new HashMap<>();

        c(String str) {
            this.f5611a = str;
        }

        @Override // androidx.core.content.FileProvider.b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f5612b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // androidx.core.content.FileProvider.b
        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f5612b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f5611a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        void c(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f5612b.put(str, file.getCanonicalFile());
            } catch (IOException e8) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e8);
            }
        }
    }

    public FileProvider() {
        this.f5610b = 0;
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] b(Object[] objArr, int i7) {
        Object[] objArr2 = new Object[i7];
        System.arraycopy(objArr, 0, objArr2, 0, i7);
        return objArr2;
    }

    private static String[] c(String[] strArr, int i7) {
        String[] strArr2 = new String[i7];
        System.arraycopy(strArr, 0, strArr2, 0, i7);
        return strArr2;
    }

    @g1
    static XmlResourceParser d(Context context, String str, @o0 ProviderInfo providerInfo, int i7) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i7 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt(f5596d, i7);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), f5596d);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    private static b e(Context context, String str, int i7) {
        b bVarI;
        HashMap<String, b> map = f5608p;
        synchronized (map) {
            bVarI = map.get(str);
            if (bVarI == null) {
                try {
                    try {
                        bVarI = i(context, str, i7);
                        map.put(str, bVarI);
                    } catch (XmlPullParserException e8) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e8);
                    }
                } catch (IOException e9) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e9);
                }
            }
        }
        return bVarI;
    }

    public static Uri f(@m0 Context context, @m0 String str, @m0 File file) {
        return e(context, str, 0).b(file);
    }

    @m0
    @SuppressLint({"StreamFiles"})
    public static Uri g(@m0 Context context, @m0 String str, @m0 File file, @m0 String str2) {
        return f(context, str, file).buildUpon().appendQueryParameter(f5606n, str2).build();
    }

    private static int h(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static b i(Context context, String str, int i7) throws XmlPullParserException, IOException {
        c cVar = new c(str);
        XmlResourceParser xmlResourceParserD = d(context, str, context.getPackageManager().resolveContentProvider(str, 128), i7);
        while (true) {
            int next = xmlResourceParserD.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = xmlResourceParserD.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserD.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserD.getAttributeValue(null, f5605m);
                if (f5597e.equals(name)) {
                    externalStorageDirectory = f5607o;
                } else if (f5598f.equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if (f5599g.equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if (f5600h.equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if (f5601i.equals(name)) {
                    File[] fileArrK = d.k(context, null);
                    if (fileArrK.length > 0) {
                        externalStorageDirectory = fileArrK[0];
                    }
                } else if (f5602j.equals(name)) {
                    File[] fileArrJ = d.j(context);
                    if (fileArrJ.length > 0) {
                        externalStorageDirectory = fileArrJ[0];
                    }
                } else if (f5603k.equals(name)) {
                    File[] fileArrA = a.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    cVar.c(attributeValue, a(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@m0 Context context, @m0 ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(com.alipay.sdk.util.j.f13806b)[0];
        HashMap<String, b> map = f5608p;
        synchronized (map) {
            map.remove(str);
        }
        this.f5609a = e(context, str, this.f5610b);
    }

    @Override // android.content.ContentProvider
    public int delete(@m0 Uri uri, @o0 String str, @o0 String[] strArr) {
        return this.f5609a.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @o0
    public String getType(@m0 Uri uri) {
        File fileA = this.f5609a.a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@m0 Uri uri, @m0 ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@m0 Uri uri, @m0 String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f5609a.a(uri), h(str));
    }

    @Override // android.content.ContentProvider
    @m0
    public Cursor query(@m0 Uri uri, @o0 String[] strArr, @o0 String str, @o0 String[] strArr2, @o0 String str2) {
        int i7;
        File fileA = this.f5609a.a(uri);
        String queryParameter = uri.getQueryParameter(f5606n);
        if (strArr == null) {
            strArr = f5595c;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i8 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i8] = "_display_name";
                i7 = i8 + 1;
                objArr[i8] = queryParameter == null ? fileA.getName() : queryParameter;
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i8] = "_size";
                    i7 = i8 + 1;
                    objArr[i8] = Long.valueOf(fileA.length());
                }
            }
            i8 = i7;
        }
        String[] strArrC = c(strArr3, i8);
        Object[] objArrB = b(objArr, i8);
        MatrixCursor matrixCursor = new MatrixCursor(strArrC, 1);
        matrixCursor.addRow(objArrB);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@m0 Uri uri, @m0 ContentValues contentValues, @o0 String str, @o0 String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    protected FileProvider(@i1 int i7) {
        this.f5610b = i7;
    }
}
