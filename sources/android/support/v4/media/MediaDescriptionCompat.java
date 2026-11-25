package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f188j = "android.media.extra.BT_FOLDER_TYPE";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f189k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f190l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f191m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f192n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f193o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f194p = 5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f195q = 6;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f196r = "android.media.extra.DOWNLOAD_STATUS";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f197s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f198t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f199u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    public static final String f200v = "android.support.v4.media.description.MEDIA_URI";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    public static final String f201w = "android.support.v4.media.description.NULL_BUNDLE_FLAG";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bitmap f206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Uri f209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f210i;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(f.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i7) {
            return new MediaDescriptionCompat[i7];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f218h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f211a, this.f212b, this.f213c, this.f214d, this.f215e, this.f216f, this.f217g, this.f218h);
        }

        public b b(@o0 CharSequence charSequence) {
            this.f214d = charSequence;
            return this;
        }

        public b c(@o0 Bundle bundle) {
            this.f217g = bundle;
            return this;
        }

        public b d(@o0 Bitmap bitmap) {
            this.f215e = bitmap;
            return this;
        }

        public b e(@o0 Uri uri) {
            this.f216f = uri;
            return this;
        }

        public b f(@o0 String str) {
            this.f211a = str;
            return this;
        }

        public b g(@o0 Uri uri) {
            this.f218h = uri;
            return this;
        }

        public b h(@o0 CharSequence charSequence) {
            this.f213c = charSequence;
            return this;
        }

        public b i(@o0 CharSequence charSequence) {
            this.f212b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f202a = str;
        this.f203b = charSequence;
        this.f204c = charSequence2;
        this.f205d = charSequence3;
        this.f206e = bitmap;
        this.f207f = uri;
        this.f208g = bundle;
        this.f209h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        b bVar = new b();
        bVar.f(f.f(obj));
        bVar.i(f.h(obj));
        bVar.h(f.g(obj));
        bVar.b(f.b(obj));
        bVar.d(f.d(obj));
        bVar.e(f.e(obj));
        Bundle bundleC = f.c(obj);
        if (bundleC != null) {
            MediaSessionCompat.b(bundleC);
            uri = (Uri) bundleC.getParcelable(f200v);
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleC;
        } else if (!bundleC.containsKey(f201w) || bundleC.size() != 2) {
            bundleC.remove(f200v);
            bundleC.remove(f201w);
            bundle = bundleC;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else {
            bVar.g(g.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.f210i = obj;
        return mediaDescriptionCompatA;
    }

    @o0
    public CharSequence b() {
        return this.f205d;
    }

    @o0
    public Bundle d() {
        return this.f208g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public Bitmap e() {
        return this.f206e;
    }

    @o0
    public Uri f() {
        return this.f207f;
    }

    public Object g() {
        Object obj = this.f210i;
        if (obj != null) {
            return obj;
        }
        Object objB = f.a.b();
        f.a.g(objB, this.f202a);
        f.a.i(objB, this.f203b);
        f.a.h(objB, this.f204c);
        f.a.c(objB, this.f205d);
        f.a.e(objB, this.f206e);
        f.a.f(objB, this.f207f);
        f.a.d(objB, this.f208g);
        g.a.a(objB, this.f209h);
        Object objA = f.a.a(objB);
        this.f210i = objA;
        return objA;
    }

    @o0
    public String h() {
        return this.f202a;
    }

    @o0
    public Uri i() {
        return this.f209h;
    }

    @o0
    public CharSequence j() {
        return this.f204c;
    }

    @o0
    public CharSequence k() {
        return this.f203b;
    }

    public String toString() {
        return ((Object) this.f203b) + ", " + ((Object) this.f204c) + ", " + ((Object) this.f205d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        f.i(g(), parcel, i7);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f202a = parcel.readString();
        this.f203b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f204c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f205d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f206e = (Bitmap) parcel.readParcelable(classLoader);
        this.f207f = (Uri) parcel.readParcelable(classLoader);
        this.f208g = parcel.readBundle(classLoader);
        this.f209h = (Uri) parcel.readParcelable(classLoader);
    }
}
