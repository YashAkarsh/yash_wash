package com.bumptech.glide.load.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.bumptech.glide.load.data.c<InputStream> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f14211h = "MediaStoreThumbFetcher";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f14212i = 512;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f14213j = 384;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final e f14214k = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f14216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.data.c<InputStream> f14217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f14219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f14220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputStream f14221g;

    static class a {
        a() {
        }

        public boolean a(File file) {
            return file.exists();
        }

        public File b(String str) {
            return new File(str);
        }

        public long c(File file) {
            return file.length();
        }
    }

    static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f14222a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f14223b = "kind = 1 AND image_id = ?";

        b() {
        }

        @Override // com.bumptech.glide.load.data.i.c
        public Cursor a(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f14222a, f14223b, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    interface c {
        Cursor a(Context context, Uri uri);
    }

    static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final a f14224c = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f14225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c f14226b;

        public d(c cVar) {
            this(f14224c, cVar);
        }

        private Uri c(Cursor cursor) {
            String string = cursor.getString(0);
            if (!TextUtils.isEmpty(string)) {
                File fileB = this.f14225a.b(string);
                if (this.f14225a.a(fileB) && this.f14225a.c(fileB) > 0) {
                    return Uri.fromFile(fileB);
                }
            }
            return null;
        }

        public int a(Context context, Uri uri) {
            InputStream inputStreamOpenInputStream = null;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                int iC = new m(inputStreamOpenInputStream).c();
                if (inputStreamOpenInputStream == null) {
                    return iC;
                }
                try {
                    return iC;
                } catch (IOException unused) {
                    return iC;
                }
            } catch (IOException e8) {
                if (Log.isLoggable(i.f14211h, 3)) {
                    Log.d(i.f14211h, "Failed to open uri: " + uri, e8);
                }
                return -1;
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0019  */
        public InputStream b(Context context, Uri uri) throws FileNotFoundException {
            Uri uriC;
            Cursor cursorA = this.f14226b.a(context, uri);
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        uriC = c(cursorA);
                    } else {
                        uriC = null;
                    }
                } catch (Throwable th) {
                    cursorA.close();
                    throw th;
                }
            } else {
                uriC = null;
            }
            if (cursorA != null) {
                cursorA.close();
            }
            if (uriC != null) {
                return context.getContentResolver().openInputStream(uriC);
            }
            return null;
        }

        public d(a aVar, c cVar) {
            this.f14225a = aVar;
            this.f14226b = cVar;
        }
    }

    static class e {
        e() {
        }

        public d a(Uri uri, int i7, int i8) {
            if (!i.f(uri) || i7 > 512 || i8 > i.f14213j) {
                return null;
            }
            return i.g(uri) ? new d(new f()) : new d(new b());
        }
    }

    static class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f14227a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f14228b = "kind = 1 AND video_id = ?";

        f() {
        }

        @Override // com.bumptech.glide.load.data.i.c
        public Cursor a(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f14227a, f14228b, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public i(Context context, Uri uri, com.bumptech.glide.load.data.c<InputStream> cVar, int i7, int i8) {
        this(context, uri, cVar, i7, i8, f14214k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Uri uri) {
        return f(uri) && uri.getPathSegments().contains("video");
    }

    private InputStream i(d dVar) {
        InputStream inputStreamB;
        try {
            inputStreamB = dVar.b(this.f14215a, this.f14216b);
        } catch (FileNotFoundException e8) {
            if (Log.isLoggable(f14211h, 3)) {
                Log.d(f14211h, "Failed to find thumbnail file", e8);
            }
            inputStreamB = null;
        }
        int iA = inputStreamB != null ? dVar.a(this.f14215a, this.f14216b) : -1;
        return iA != -1 ? new com.bumptech.glide.load.data.d(inputStreamB, iA) : inputStreamB;
    }

    @Override // com.bumptech.glide.load.data.c
    public String a() {
        return this.f14216b.toString();
    }

    @Override // com.bumptech.glide.load.data.c
    public void b() {
        InputStream inputStream = this.f14221g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        this.f14217c.b();
    }

    @Override // com.bumptech.glide.load.data.c
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream c(p pVar) throws Exception {
        d dVarA = this.f14220f.a(this.f14216b, this.f14218d, this.f14219e);
        if (dVarA != null) {
            this.f14221g = i(dVarA);
        }
        if (this.f14221g == null) {
            this.f14221g = this.f14217c.c(pVar);
        }
        return this.f14221g;
    }

    i(Context context, Uri uri, com.bumptech.glide.load.data.c<InputStream> cVar, int i7, int i8, e eVar) {
        this.f14215a = context;
        this.f14216b = uri;
        this.f14217c = cVar;
        this.f14218d = i7;
        this.f14219e = i8;
        this.f14220f = eVar;
    }
}
