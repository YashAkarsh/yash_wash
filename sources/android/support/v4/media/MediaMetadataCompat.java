package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final String A = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String B = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String C = "android.media.metadata.DISPLAY_ICON";
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String D = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String E = "android.media.metadata.MEDIA_ID";
    public static final String F = "android.media.metadata.MEDIA_URI";
    public static final String G = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String H = "android.media.metadata.ADVERTISEMENT";
    public static final String I = "android.media.metadata.DOWNLOAD_STATUS";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final int f219J = 0;
    static final int K = 1;
    static final int L = 2;
    static final int M = 3;
    static final androidx.collection.a<String, Integer> N;
    private static final String[] O;
    private static final String[] P;
    private static final String[] Q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f220d = "MediaMetadata";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f221e = "android.media.metadata.TITLE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f222f = "android.media.metadata.ARTIST";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f223g = "android.media.metadata.DURATION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f224h = "android.media.metadata.ALBUM";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f225i = "android.media.metadata.AUTHOR";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f226j = "android.media.metadata.WRITER";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f227k = "android.media.metadata.COMPOSER";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f228l = "android.media.metadata.COMPILATION";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f229m = "android.media.metadata.DATE";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f230n = "android.media.metadata.YEAR";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f231o = "android.media.metadata.GENRE";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f232p = "android.media.metadata.TRACK_NUMBER";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f233q = "android.media.metadata.NUM_TRACKS";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f234r = "android.media.metadata.DISC_NUMBER";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f235s = "android.media.metadata.ALBUM_ARTIST";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f236t = "android.media.metadata.ART";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f237u = "android.media.metadata.ART_URI";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f238v = "android.media.metadata.ALBUM_ART";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f239w = "android.media.metadata.ALBUM_ART_URI";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f240x = "android.media.metadata.USER_RATING";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f241y = "android.media.metadata.RATING";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f242z = "android.media.metadata.DISPLAY_TITLE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Bundle f243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaDescriptionCompat f245c;

    static class a implements Parcelable.Creator<MediaMetadataCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat[] newArray(int i7) {
            return new MediaMetadataCompat[i7];
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    static {
        androidx.collection.a<String, Integer> aVar = new androidx.collection.a<>();
        N = aVar;
        aVar.put(f221e, 1);
        aVar.put(f222f, 1);
        aVar.put(f223g, 0);
        aVar.put(f224h, 1);
        aVar.put(f225i, 1);
        aVar.put(f226j, 1);
        aVar.put(f227k, 1);
        aVar.put(f228l, 1);
        aVar.put(f229m, 1);
        aVar.put(f230n, 0);
        aVar.put(f231o, 1);
        aVar.put(f232p, 0);
        aVar.put(f233q, 0);
        aVar.put(f234r, 0);
        aVar.put(f235s, 1);
        aVar.put(f236t, 2);
        aVar.put(f237u, 1);
        aVar.put(f238v, 2);
        aVar.put(f239w, 1);
        aVar.put(f240x, 3);
        aVar.put(f241y, 3);
        aVar.put(f242z, 1);
        aVar.put(A, 1);
        aVar.put(B, 1);
        aVar.put(C, 2);
        aVar.put(D, 1);
        aVar.put(E, 1);
        aVar.put(G, 0);
        aVar.put(F, 1);
        aVar.put(H, 0);
        aVar.put(I, 0);
        O = new String[]{f221e, f222f, f224h, f235s, f226j, f225i, f227k};
        P = new String[]{C, f236t, f238v};
        Q = new String[]{D, f237u, f239w};
        CREATOR = new a();
    }

    MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f243a = bundle2;
        MediaSessionCompat.b(bundle2);
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        h.g(obj, parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.f244b = obj;
        return mediaMetadataCompatCreateFromParcel;
    }

    public boolean a(String str) {
        return this.f243a.containsKey(str);
    }

    public Bitmap d(String str) {
        try {
            return (Bitmap) this.f243a.getParcelable(str);
        } catch (Exception e8) {
            Log.w(f220d, "Failed to retrieve a key as Bitmap.", e8);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle e() {
        return new Bundle(this.f243a);
    }

    public MediaDescriptionCompat f() {
        Bitmap bitmapD;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.f245c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String strJ = j(E);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence charSequenceK = k(f242z);
        if (TextUtils.isEmpty(charSequenceK)) {
            int i7 = 0;
            int i8 = 0;
            while (i7 < 3) {
                String[] strArr = O;
                if (i8 >= strArr.length) {
                    break;
                }
                int i9 = i8 + 1;
                CharSequence charSequenceK2 = k(strArr[i8]);
                if (!TextUtils.isEmpty(charSequenceK2)) {
                    charSequenceArr[i7] = charSequenceK2;
                    i7++;
                }
                i8 = i9;
            }
        } else {
            charSequenceArr[0] = charSequenceK;
            charSequenceArr[1] = k(A);
            charSequenceArr[2] = k(B);
        }
        int i10 = 0;
        while (true) {
            String[] strArr2 = P;
            if (i10 >= strArr2.length) {
                bitmapD = null;
                break;
            }
            bitmapD = d(strArr2[i10]);
            if (bitmapD != null) {
                break;
            }
            i10++;
        }
        int i11 = 0;
        while (true) {
            String[] strArr3 = Q;
            if (i11 >= strArr3.length) {
                uri = null;
                break;
            }
            String strJ2 = j(strArr3[i11]);
            if (!TextUtils.isEmpty(strJ2)) {
                uri = Uri.parse(strJ2);
                break;
            }
            i11++;
        }
        String strJ3 = j(F);
        Uri uri2 = TextUtils.isEmpty(strJ3) ? null : Uri.parse(strJ3);
        MediaDescriptionCompat.b bVar = new MediaDescriptionCompat.b();
        bVar.f(strJ);
        bVar.i(charSequenceArr[0]);
        bVar.h(charSequenceArr[1]);
        bVar.b(charSequenceArr[2]);
        bVar.d(bitmapD);
        bVar.e(uri);
        bVar.g(uri2);
        Bundle bundle = new Bundle();
        if (this.f243a.containsKey(G)) {
            bundle.putLong(MediaDescriptionCompat.f188j, g(G));
        }
        if (this.f243a.containsKey(I)) {
            bundle.putLong(MediaDescriptionCompat.f196r, g(I));
        }
        if (!bundle.isEmpty()) {
            bVar.c(bundle);
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        this.f245c = mediaDescriptionCompatA;
        return mediaDescriptionCompatA;
    }

    public long g(String str) {
        return this.f243a.getLong(str, 0L);
    }

    public Object h() {
        if (this.f244b == null) {
            Parcel parcelObtain = Parcel.obtain();
            writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            this.f244b = h.a(parcelObtain);
            parcelObtain.recycle();
        }
        return this.f244b;
    }

    public RatingCompat i(String str) {
        try {
            return RatingCompat.a(this.f243a.getParcelable(str));
        } catch (Exception e8) {
            Log.w(f220d, "Failed to retrieve a key as Rating.", e8);
            return null;
        }
    }

    public String j(String str) {
        CharSequence charSequence = this.f243a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence k(String str) {
        return this.f243a.getCharSequence(str);
    }

    public Set<String> l() {
        return this.f243a.keySet();
    }

    public int n() {
        return this.f243a.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeBundle(this.f243a);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f246a;

        public c() {
            this.f246a = new Bundle();
        }

        private Bitmap g(Bitmap bitmap, int i7) {
            float f8 = i7;
            float fMin = Math.min(f8 / bitmap.getWidth(), f8 / bitmap.getHeight());
            return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), true);
        }

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.f246a);
        }

        public c b(String str, Bitmap bitmap) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.N;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 2) {
                this.f246a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public c c(String str, long j7) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.N;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 0) {
                this.f246a.putLong(str, j7);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public c d(String str, RatingCompat ratingCompat) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.N;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 3) {
                this.f246a.putParcelable(str, (Parcelable) ratingCompat.d());
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public c e(String str, String str2) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.N;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 1) {
                this.f246a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public c f(String str, CharSequence charSequence) {
            androidx.collection.a<String, Integer> aVar = MediaMetadataCompat.N;
            if (!aVar.containsKey(str) || aVar.get(str).intValue() == 1) {
                this.f246a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }

        public c(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.f243a);
            this.f246a = bundle;
            MediaSessionCompat.b(bundle);
        }

        @x0({x0.a.LIBRARY_GROUP})
        public c(MediaMetadataCompat mediaMetadataCompat, int i7) {
            this(mediaMetadataCompat);
            for (String str : this.f246a.keySet()) {
                Object obj = this.f246a.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i7 || bitmap.getWidth() > i7) {
                        b(str, g(bitmap, i7));
                    }
                }
            }
        }
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f243a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
