package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long A = 16384;
    public static final int A0 = -1;
    public static final long B = 32768;
    public static final int B0 = 0;
    public static final long C = 65536;
    public static final int C0 = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    public static final long D = 131072;
    public static final int D0 = 2;
    public static final long E = 262144;
    public static final int E0 = 0;

    @Deprecated
    public static final long F = 524288;
    public static final int F0 = 1;
    public static final long G = 1048576;
    public static final int G0 = 2;
    public static final long H = 2097152;
    public static final int H0 = 3;
    public static final int I = 0;
    public static final int I0 = 4;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f436J = 1;
    public static final int J0 = 5;
    public static final int K = 2;
    public static final int K0 = 6;
    public static final int L = 3;
    public static final int L0 = 7;
    public static final int M = 4;
    public static final int M0 = 8;
    public static final int N = 5;
    public static final int N0 = 9;
    public static final int O = 6;
    public static final int O0 = 10;
    public static final int P = 7;
    public static final int P0 = 11;
    public static final int Q = 8;
    private static final int Q0 = 127;
    public static final int R = 9;
    private static final int R0 = 126;
    public static final int S = 10;
    public static final int T = 11;
    public static final long U = -1;
    public static final int V = -1;
    public static final int W = 0;
    public static final int X = 1;
    public static final int Y = 2;
    public static final int Z = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f437m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f438n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f439o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f440p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f441q = 16;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f442r = 32;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f443s = 64;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f444t = 128;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f445u = 256;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f446v = 512;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f447w = 1024;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f448x = 2048;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f449y = 4096;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f450z = 8192;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final CharSequence f457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List<CustomAction> f459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Bundle f461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f462l;

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i7) {
            return new PlaybackStateCompat[i7];
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

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    PlaybackStateCompat(int i7, long j7, long j8, float f8, long j9, int i8, CharSequence charSequence, long j10, List<CustomAction> list, long j11, Bundle bundle) {
        this.f451a = i7;
        this.f452b = j7;
        this.f453c = j8;
        this.f454d = f8;
        this.f455e = j9;
        this.f456f = i8;
        this.f457g = charSequence;
        this.f458h = j10;
        this.f459i = new ArrayList(list);
        this.f460j = j11;
        this.f461k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList = null;
        if (obj == null) {
            return null;
        }
        List<Object> listD = o.d(obj);
        if (listD != null) {
            arrayList = new ArrayList(listD.size());
            Iterator<Object> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.a(it.next()));
            }
        }
        Bundle bundleA = p.a(obj);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(o.i(obj), o.h(obj), o.c(obj), o.g(obj), o.a(obj), 0, o.e(obj), o.f(obj), arrayList, o.b(obj), bundleA);
        playbackStateCompat.f462l = obj;
        return playbackStateCompat;
    }

    public static int s(long j7) {
        if (j7 == 4) {
            return 126;
        }
        if (j7 == 2) {
            return 127;
        }
        if (j7 == 32) {
            return 87;
        }
        if (j7 == 16) {
            return 88;
        }
        if (j7 == 1) {
            return 86;
        }
        if (j7 == 64) {
            return 90;
        }
        if (j7 == 8) {
            return 89;
        }
        return j7 == 512 ? 85 : 0;
    }

    public long b() {
        return this.f455e;
    }

    public long d() {
        return this.f460j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f453c;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public long f(Long l7) {
        return Math.max(0L, this.f452b + ((long) (this.f454d * (l7 != null ? l7.longValue() : SystemClock.elapsedRealtime() - this.f458h))));
    }

    public List<CustomAction> g() {
        return this.f459i;
    }

    public int h() {
        return this.f456f;
    }

    public CharSequence i() {
        return this.f457g;
    }

    @o0
    public Bundle j() {
        return this.f461k;
    }

    public long k() {
        return this.f458h;
    }

    public float l() {
        return this.f454d;
    }

    public Object n() {
        ArrayList arrayList;
        if (this.f462l == null) {
            if (this.f459i != null) {
                arrayList = new ArrayList(this.f459i.size());
                Iterator<CustomAction> it = this.f459i.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().d());
                }
            } else {
                arrayList = null;
            }
            this.f462l = p.b(this.f451a, this.f452b, this.f453c, this.f454d, this.f455e, this.f457g, this.f458h, arrayList, this.f460j, this.f461k);
        }
        return this.f462l;
    }

    public long o() {
        return this.f452b;
    }

    public int p() {
        return this.f451a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f451a + ", position=" + this.f452b + ", buffered position=" + this.f453c + ", speed=" + this.f454d + ", updated=" + this.f458h + ", actions=" + this.f455e + ", error code=" + this.f456f + ", error message=" + this.f457g + ", custom actions=" + this.f459i + ", active item id=" + this.f460j + com.alipay.sdk.util.j.f13808d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f451a);
        parcel.writeLong(this.f452b);
        parcel.writeFloat(this.f454d);
        parcel.writeLong(this.f458h);
        parcel.writeLong(this.f453c);
        parcel.writeLong(this.f455e);
        TextUtils.writeToParcel(this.f457g, parcel, i7);
        parcel.writeTypedList(this.f459i);
        parcel.writeLong(this.f460j);
        parcel.writeBundle(this.f461k);
        parcel.writeInt(this.f456f);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<CustomAction> f472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f476e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f477f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f478g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CharSequence f479h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f480i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f481j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Bundle f482k;

        public c() {
            this.f472a = new ArrayList();
            this.f481j = -1L;
        }

        public c a(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.f472a.add(customAction);
            return this;
        }

        public c b(String str, String str2, int i7) {
            return a(new CustomAction(str, str2, i7, null));
        }

        public PlaybackStateCompat c() {
            return new PlaybackStateCompat(this.f473b, this.f474c, this.f475d, this.f476e, this.f477f, this.f478g, this.f479h, this.f480i, this.f472a, this.f481j, this.f482k);
        }

        public c d(long j7) {
            this.f477f = j7;
            return this;
        }

        public c e(long j7) {
            this.f481j = j7;
            return this;
        }

        public c f(long j7) {
            this.f475d = j7;
            return this;
        }

        public c g(int i7, CharSequence charSequence) {
            this.f478g = i7;
            this.f479h = charSequence;
            return this;
        }

        public c h(CharSequence charSequence) {
            this.f479h = charSequence;
            return this;
        }

        public c i(Bundle bundle) {
            this.f482k = bundle;
            return this;
        }

        public c j(int i7, long j7, float f8) {
            return k(i7, j7, f8, SystemClock.elapsedRealtime());
        }

        public c k(int i7, long j7, float f8, long j8) {
            this.f473b = i7;
            this.f474c = j7;
            this.f480i = j8;
            this.f476e = f8;
            return this;
        }

        public c(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f472a = arrayList;
            this.f481j = -1L;
            this.f473b = playbackStateCompat.f451a;
            this.f474c = playbackStateCompat.f452b;
            this.f476e = playbackStateCompat.f454d;
            this.f480i = playbackStateCompat.f458h;
            this.f475d = playbackStateCompat.f453c;
            this.f477f = playbackStateCompat.f455e;
            this.f478g = playbackStateCompat.f456f;
            this.f479h = playbackStateCompat.f457g;
            List<CustomAction> list = playbackStateCompat.f459i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f481j = playbackStateCompat.f460j;
            this.f482k = playbackStateCompat.f461k;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object f467e;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i7) {
                return new CustomAction[i7];
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f468a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CharSequence f469b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f470c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Bundle f471d;

            public b(String str, CharSequence charSequence, int i7) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                }
                if (i7 == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }
                this.f468a = str;
                this.f469b = charSequence;
                this.f470c = i7;
            }

            public CustomAction a() {
                return new CustomAction(this.f468a, this.f469b, this.f470c, this.f471d);
            }

            public b b(Bundle bundle) {
                this.f471d = bundle;
                return this;
            }
        }

        CustomAction(String str, CharSequence charSequence, int i7, Bundle bundle) {
            this.f463a = str;
            this.f464b = charSequence;
            this.f465c = i7;
            this.f466d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            CustomAction customAction = new CustomAction(o.a.a(obj), o.a.d(obj), o.a.c(obj), o.a.b(obj));
            customAction.f467e = obj;
            return customAction;
        }

        public String b() {
            return this.f463a;
        }

        public Object d() {
            Object obj = this.f467e;
            if (obj != null) {
                return obj;
            }
            Object objE = o.a.e(this.f463a, this.f464b, this.f465c, this.f466d);
            this.f467e = objE;
            return objE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bundle e() {
            return this.f466d;
        }

        public int f() {
            return this.f465c;
        }

        public CharSequence g() {
            return this.f464b;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f464b) + ", mIcon=" + this.f465c + ", mExtras=" + this.f466d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f463a);
            TextUtils.writeToParcel(this.f464b, parcel, i7);
            parcel.writeInt(this.f465c);
            parcel.writeBundle(this.f466d);
        }

        CustomAction(Parcel parcel) {
            this.f463a = parcel.readString();
            this.f464b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f465c = parcel.readInt();
            this.f466d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f451a = parcel.readInt();
        this.f452b = parcel.readLong();
        this.f454d = parcel.readFloat();
        this.f458h = parcel.readLong();
        this.f453c = parcel.readLong();
        this.f455e = parcel.readLong();
        this.f457g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f459i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f460j = parcel.readLong();
        this.f461k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f456f = parcel.readInt();
    }
}
