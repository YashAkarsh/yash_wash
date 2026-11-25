package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.r;
import androidx.media.session.MediaButtonReceiver;
import androidx.media.v;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    @x0({x0.a.LIBRARY})
    public static final String A = "android.support.v4.media.session.action.ARGUMENT_QUERY";

    @x0({x0.a.LIBRARY})
    public static final String B = "android.support.v4.media.session.action.ARGUMENT_URI";

    @x0({x0.a.LIBRARY})
    public static final String C = "android.support.v4.media.session.action.ARGUMENT_RATING";

    @x0({x0.a.LIBRARY})
    public static final String D = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";

    @x0({x0.a.LIBRARY})
    public static final String E = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";

    @x0({x0.a.LIBRARY})
    public static final String F = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";

    @x0({x0.a.LIBRARY})
    public static final String G = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";

    @x0({x0.a.LIBRARY_GROUP})
    public static final String H = "android.support.v4.media.session.TOKEN";

    @x0({x0.a.LIBRARY})
    public static final String I = "android.support.v4.media.session.EXTRA_BINDER";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    public static final String f313J = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    private static final int K = 320;
    private static final String L = "data_calling_pkg";
    private static final String M = "data_calling_pid";
    private static final String N = "data_calling_uid";
    private static final String O = "data_extras";
    static int P = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f314d = "MediaSessionCompat";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f315e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f316f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f317g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f318h = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f319i = "android.support.v4.media.session.action.SKIP_AD";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f320j = "android.support.v4.media.session.action.FOLLOW";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f321k = "android.support.v4.media.session.action.UNFOLLOW";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f322l = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f323m = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f324n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f325o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f326p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f327q = "android.support.v4.media.session.action.PLAY_FROM_URI";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f328r = "android.support.v4.media.session.action.PREPARE";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f329s = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f330t = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f331u = "android.support.v4.media.session.action.PREPARE_FROM_URI";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f332v = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f333w = "android.support.v4.media.session.action.SET_REPEAT_MODE";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f334x = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f335y = "android.support.v4.media.session.action.SET_RATING";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f336z = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaControllerCompat f338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<k> f339c;

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f340d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaDescriptionCompat f341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f343c;

        static class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i7) {
                return new QueueItem[i7];
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j7) {
            this(null, mediaDescriptionCompat, j7);
        }

        public static QueueItem a(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.a(android.support.v4.media.session.k.c.b(obj)), android.support.v4.media.session.k.c.c(obj));
            }
            return null;
        }

        public static List<QueueItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public MediaDescriptionCompat d() {
            return this.f341a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public long e() {
            return this.f342b;
        }

        public Object f() {
            Object obj = this.f343c;
            if (obj != null) {
                return obj;
            }
            Object objA = android.support.v4.media.session.k.c.a(this.f341a.g(), this.f342b);
            this.f343c = objA;
            return objA;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f341a + ", Id=" + this.f342b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            this.f341a.writeToParcel(parcel, i7);
            parcel.writeLong(this.f342b);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j7) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j7 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f341a = mediaDescriptionCompat;
            this.f342b = j7;
            this.f343c = obj;
        }

        QueueItem(Parcel parcel) {
            this.f341a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f342b = parcel.readLong();
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private android.support.v4.media.session.b f346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f347c;

        static class a implements Parcelable.Creator<Token> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i7) {
                return new Token[i7];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        @x0({x0.a.LIBRARY_GROUP})
        public static Token a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            android.support.v4.media.session.b bVarI0 = android.support.v4.media.session.b.a.i0(r.a(bundle, MediaSessionCompat.I));
            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.f313J);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.H);
            if (token == null) {
                return null;
            }
            return new Token(token.f345a, bVarI0, bundle2);
        }

        public static Token b(Object obj) {
            return d(obj, null);
        }

        @x0({x0.a.LIBRARY_GROUP})
        public static Token d(Object obj, android.support.v4.media.session.b bVar) {
            if (obj != null) {
                return new Token(android.support.v4.media.session.k.u(obj), bVar);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @x0({x0.a.LIBRARY_GROUP})
        public android.support.v4.media.session.b e() {
            return this.f346b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f345a;
            if (obj2 == null) {
                return token.f345a == null;
            }
            Object obj3 = token.f345a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @x0({x0.a.LIBRARY_GROUP})
        public Bundle f() {
            return this.f347c;
        }

        public Object g() {
            return this.f345a;
        }

        @x0({x0.a.LIBRARY_GROUP})
        public void h(android.support.v4.media.session.b bVar) {
            this.f346b = bVar;
        }

        public int hashCode() {
            Object obj = this.f345a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @x0({x0.a.LIBRARY_GROUP})
        public void i(Bundle bundle) {
            this.f347c = bundle;
        }

        @x0({x0.a.LIBRARY_GROUP})
        public Bundle j() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.H, this);
            android.support.v4.media.session.b bVar = this.f346b;
            if (bVar != null) {
                r.b(bundle, MediaSessionCompat.I, bVar.asBinder());
            }
            Bundle bundle2 = this.f347c;
            if (bundle2 != null) {
                bundle.putBundle(MediaSessionCompat.f313J, bundle2);
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable((Parcelable) this.f345a, i7);
        }

        Token(Object obj, android.support.v4.media.session.b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, android.support.v4.media.session.b bVar, Bundle bundle) {
            this.f345a = obj;
            this.f346b = bVar;
            this.f347c = bundle;
        }
    }

    class a extends d {
        a() {
        }
    }

    class b extends d {
        b() {
        }
    }

    class c extends d {
        c() {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference<e> f352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f353c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f354d;

        private class a extends Handler {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int f355b = 1;

            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.this.a((androidx.media.j.b) message.obj);
                }
            }
        }

        @t0(21)
        private class b implements android.support.v4.media.session.k.a {
            b() {
            }

            @Override // android.support.v4.media.session.k.a
            public void g() {
                d.this.C();
            }

            @Override // android.support.v4.media.session.k.a
            public void j() {
                d.this.h();
            }

            @Override // android.support.v4.media.session.k.a
            public void k() {
                d.this.z();
            }

            @Override // android.support.v4.media.session.k.a
            public void l() {
                d.this.s();
            }

            @Override // android.support.v4.media.session.k.a
            public void m(String str, Bundle bundle, ResultReceiver resultReceiver) {
                try {
                    QueueItem queueItem = null;
                    IBinder iBinderAsBinder = null;
                    queueItem = null;
                    if (str.equals(MediaControllerCompat.f265e)) {
                        h hVar = (h) d.this.f352b.get();
                        if (hVar != null) {
                            Bundle bundle2 = new Bundle();
                            Token tokenC = hVar.c();
                            android.support.v4.media.session.b bVarE = tokenC.e();
                            if (bVarE != null) {
                                iBinderAsBinder = bVarE.asBinder();
                            }
                            r.b(bundle2, MediaSessionCompat.I, iBinderAsBinder);
                            bundle2.putBundle(MediaSessionCompat.f313J, tokenC.f());
                            resultReceiver.send(0, bundle2);
                            return;
                        }
                        return;
                    }
                    if (str.equals(MediaControllerCompat.f266f)) {
                        d.this.b((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f270j));
                        return;
                    }
                    if (str.equals(MediaControllerCompat.f267g)) {
                        d.this.c((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f270j), bundle.getInt(MediaControllerCompat.f271k));
                        return;
                    }
                    if (str.equals(MediaControllerCompat.f268h)) {
                        d.this.q((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f270j));
                        return;
                    }
                    if (!str.equals(MediaControllerCompat.f269i)) {
                        d.this.d(str, bundle, resultReceiver);
                        return;
                    }
                    h hVar2 = (h) d.this.f352b.get();
                    if (hVar2 == null || hVar2.f367f == null) {
                        return;
                    }
                    int i7 = bundle.getInt(MediaControllerCompat.f271k, -1);
                    if (i7 >= 0 && i7 < hVar2.f367f.size()) {
                        queueItem = hVar2.f367f.get(i7);
                    }
                    if (queueItem != null) {
                        d.this.q(queueItem.d());
                    }
                } catch (BadParcelableException unused) {
                    Log.e(MediaSessionCompat.f314d, "Could not unparcel the extra data.");
                }
            }

            @Override // android.support.v4.media.session.k.a
            public void n(long j7) {
                d.this.B(j7);
            }

            @Override // android.support.v4.media.session.k.a
            public void o(Object obj) {
                d.this.v(RatingCompat.a(obj));
            }

            @Override // android.support.v4.media.session.k.a
            public void p() {
                d.this.i();
            }

            @Override // android.support.v4.media.session.k.a
            public void q() {
                d.this.A();
            }

            @Override // android.support.v4.media.session.k.a
            public boolean r(Intent intent) {
                return d.this.g(intent);
            }

            @Override // android.support.v4.media.session.k.a
            public void s(Object obj, Bundle bundle) {
            }

            @Override // android.support.v4.media.session.k.a
            public void t(String str, Bundle bundle) {
                d.this.k(str, bundle);
            }

            @Override // android.support.v4.media.session.k.a
            public void u(String str, Bundle bundle) {
                d.this.j(str, bundle);
            }

            @Override // android.support.v4.media.session.k.a
            public void v() {
                d.this.f();
            }

            @Override // android.support.v4.media.session.k.a
            public void w(long j7) {
                d.this.t(j7);
            }

            @Override // android.support.v4.media.session.k.a
            public void x(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.D);
                MediaSessionCompat.b(bundle2);
                if (str.equals(MediaSessionCompat.f327q)) {
                    d.this.l((Uri) bundle.getParcelable(MediaSessionCompat.B), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.f328r)) {
                    d.this.m();
                    return;
                }
                if (str.equals(MediaSessionCompat.f329s)) {
                    d.this.n(bundle.getString(MediaSessionCompat.f336z), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.f330t)) {
                    d.this.o(bundle.getString(MediaSessionCompat.A), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.f331u)) {
                    d.this.p((Uri) bundle.getParcelable(MediaSessionCompat.B), bundle2);
                    return;
                }
                if (str.equals(MediaSessionCompat.f332v)) {
                    d.this.u(bundle.getBoolean(MediaSessionCompat.E));
                    return;
                }
                if (str.equals(MediaSessionCompat.f333w)) {
                    d.this.x(bundle.getInt(MediaSessionCompat.F));
                } else if (str.equals(MediaSessionCompat.f334x)) {
                    d.this.y(bundle.getInt(MediaSessionCompat.G));
                } else if (!str.equals(MediaSessionCompat.f335y)) {
                    d.this.e(str, bundle);
                } else {
                    d.this.w((RatingCompat) bundle.getParcelable(MediaSessionCompat.C), bundle2);
                }
            }
        }

        @t0(23)
        private class c extends b implements m.a {
            c() {
                super();
            }

            @Override // android.support.v4.media.session.m.a
            public void e(Uri uri, Bundle bundle) {
                d.this.l(uri, bundle);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$d$d, reason: collision with other inner class name */
        @t0(24)
        private class C0011d extends c implements n.a {
            C0011d() {
                super();
            }

            @Override // android.support.v4.media.session.n.a
            public void a(String str, Bundle bundle) {
                d.this.n(str, bundle);
            }

            @Override // android.support.v4.media.session.n.a
            public void b() {
                d.this.m();
            }

            @Override // android.support.v4.media.session.n.a
            public void c(Uri uri, Bundle bundle) {
                d.this.p(uri, bundle);
            }

            @Override // android.support.v4.media.session.n.a
            public void d(String str, Bundle bundle) {
                d.this.o(str, bundle);
            }
        }

        public d() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f351a = n.a(new C0011d());
            } else {
                this.f351a = m.a(new c());
            }
        }

        public void A() {
        }

        public void B(long j7) {
        }

        public void C() {
        }

        void D(e eVar, Handler handler) {
            this.f352b = new WeakReference<>(eVar);
            a aVar = this.f353c;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f353c = new a(handler.getLooper());
        }

        void a(androidx.media.j.b bVar) {
            if (this.f354d) {
                this.f354d = false;
                this.f353c.removeMessages(1);
                e eVar = this.f352b.get();
                if (eVar == null) {
                    return;
                }
                PlaybackStateCompat playbackStateCompatG = eVar.G();
                long jB = playbackStateCompatG == null ? 0L : playbackStateCompatG.b();
                boolean z7 = playbackStateCompatG != null && playbackStateCompatG.p() == 3;
                boolean z8 = (516 & jB) != 0;
                boolean z9 = (jB & 514) != 0;
                eVar.w(bVar);
                if (z7 && z9) {
                    h();
                } else if (!z7 && z8) {
                    i();
                }
                eVar.w(null);
            }
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            e eVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27 || (eVar = this.f352b.get()) == null || this.f353c == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            androidx.media.j.b bVarA = eVar.A();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(bVarA);
                return false;
            }
            if (keyEvent.getRepeatCount() > 0) {
                a(bVarA);
            } else if (this.f354d) {
                this.f353c.removeMessages(1);
                this.f354d = false;
                PlaybackStateCompat playbackStateCompatG = eVar.G();
                if (((playbackStateCompatG == null ? 0L : playbackStateCompatG.b()) & 32) != 0) {
                    z();
                }
            } else {
                this.f354d = true;
                a aVar = this.f353c;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, bVarA), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void r(int i7) {
        }

        public void s() {
        }

        public void t(long j7) {
        }

        public void u(boolean z7) {
        }

        public void v(RatingCompat ratingCompat) {
        }

        public void w(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void x(int i7) {
        }

        public void y(int i7) {
        }

        public void z() {
        }
    }

    interface e {
        androidx.media.j.b A();

        PlaybackStateCompat G();

        boolean b();

        Token c();

        void f0(boolean z7);

        void i();

        void j(int i7);

        void k(String str, Bundle bundle);

        String l();

        void m(PendingIntent pendingIntent);

        void n(d dVar, Handler handler);

        void o(int i7);

        void p(CharSequence charSequence);

        void q(MediaMetadataCompat mediaMetadataCompat);

        void q0(int i7);

        void r(PendingIntent pendingIntent);

        void s(int i7);

        void setExtras(Bundle bundle);

        void t(List<QueueItem> list);

        Object u();

        void v(boolean z7);

        void w(androidx.media.j.b bVar);

        void x(PlaybackStateCompat playbackStateCompat);

        void x0(int i7);

        Object y();

        void z(v vVar);
    }

    @t0(18)
    static class f extends j {
        private static boolean I = true;

        class a implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            a() {
            }

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j7) {
                f.this.g(18, -1, -1, Long.valueOf(j7), null);
            }
        }

        f(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j
        void N(PlaybackStateCompat playbackStateCompat) {
            long jO = playbackStateCompat.o();
            float fL = playbackStateCompat.l();
            long jK = playbackStateCompat.k();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.p() == 3) {
                long j7 = 0;
                if (jO > 0) {
                    if (jK > 0) {
                        j7 = jElapsedRealtime - jK;
                        if (fL > 0.0f && fL != 1.0f) {
                            j7 = (long) (j7 * fL);
                        }
                    }
                    jO += j7;
                }
            }
            this.f382i.setPlaybackState(e(playbackStateCompat.p()), jO, fL);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j
        void P(PendingIntent pendingIntent, ComponentName componentName) {
            if (I) {
                this.f381h.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.P(pendingIntent, componentName);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j
        int f(long j7) {
            int iF = super.f(j7);
            return (j7 & 256) != 0 ? iF | 256 : iF;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j
        void h(PendingIntent pendingIntent, ComponentName componentName) {
            if (I) {
                try {
                    this.f381h.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w(MediaSessionCompat.f314d, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    I = false;
                }
            }
            if (I) {
                return;
            }
            super.h(pendingIntent, componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j, android.support.v4.media.session.MediaSessionCompat.e
        public void n(d dVar, Handler handler) {
            super.n(dVar, handler);
            if (dVar == null) {
                this.f382i.setPlaybackPositionUpdateListener(null);
            } else {
                this.f382i.setPlaybackPositionUpdateListener(new a());
            }
        }
    }

    @t0(19)
    static class g extends f {

        class a implements RemoteControlClient.OnMetadataUpdateListener {
            a() {
            }

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i7, Object obj) {
                if (i7 == 268435457 && (obj instanceof Rating)) {
                    g.this.g(19, -1, -1, RatingCompat.a(obj), null);
                }
            }
        }

        g(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.j
        RemoteControlClient.MetadataEditor d(Bundle bundle) {
            RemoteControlClient.MetadataEditor metadataEditorD = super.d(bundle);
            PlaybackStateCompat playbackStateCompat = this.f394u;
            if (((playbackStateCompat == null ? 0L : playbackStateCompat.b()) & 128) != 0) {
                metadataEditorD.addEditableKey(268435457);
            }
            if (bundle == null) {
                return metadataEditorD;
            }
            if (bundle.containsKey(MediaMetadataCompat.f230n)) {
                metadataEditorD.putLong(8, bundle.getLong(MediaMetadataCompat.f230n));
            }
            if (bundle.containsKey(MediaMetadataCompat.f241y)) {
                metadataEditorD.putObject(101, (Object) bundle.getParcelable(MediaMetadataCompat.f241y));
            }
            if (bundle.containsKey(MediaMetadataCompat.f240x)) {
                metadataEditorD.putObject(268435457, (Object) bundle.getParcelable(MediaMetadataCompat.f240x));
            }
            return metadataEditorD;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.j
        int f(long j7) {
            int iF = super.f(j7);
            return (j7 & 128) != 0 ? iF | 512 : iF;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.j, android.support.v4.media.session.MediaSessionCompat.e
        public void n(d dVar, Handler handler) {
            super.n(dVar, handler);
            if (dVar == null) {
                this.f382i.setMetadataUpdateListener(null);
            } else {
                this.f382i.setMetadataUpdateListener(new a());
            }
        }
    }

    @t0(28)
    static class i extends h {
        i(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.h, android.support.v4.media.session.MediaSessionCompat.e
        @m0
        public final androidx.media.j.b A() {
            return new androidx.media.j.b(((MediaSession) this.f362a).getCurrentControllerInfo());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.h, android.support.v4.media.session.MediaSessionCompat.e
        public void w(androidx.media.j.b bVar) {
        }

        i(Object obj) {
            super(obj);
        }
    }

    static class j implements e {
        static final int H = 0;
        int A;
        int B;
        Bundle C;
        int D;
        int E;
        v F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ComponentName f375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PendingIntent f376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c f377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Token f378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f379f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final String f380g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AudioManager f381h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final RemoteControlClient f382i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private d f385l;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        volatile d f390q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private androidx.media.j.b f391r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f392s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        MediaMetadataCompat f393t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        PlaybackStateCompat f394u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        PendingIntent f395v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        List<QueueItem> f396w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        CharSequence f397x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f398y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        boolean f399z;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Object f383j = new Object();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final RemoteCallbackList<android.support.v4.media.session.a> f384k = new RemoteCallbackList<>();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f386m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f387n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f388o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f389p = false;
        private v.b G = new a();

        class a extends v.b {
            a() {
            }

            @Override // androidx.media.v.b
            public void a(v vVar) {
                if (j.this.F != vVar) {
                    return;
                }
                j jVar = j.this;
                j.this.M(new ParcelableVolumeInfo(jVar.D, jVar.E, vVar.c(), vVar.b(), vVar.a()));
            }
        }

        private static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f401a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f402b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ResultReceiver f403c;

            public b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f401a = str;
                this.f402b = bundle;
                this.f403c = resultReceiver;
            }
        }

        class c extends android.support.v4.media.session.b.a {
            c() {
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent A1() {
                PendingIntent pendingIntent;
                synchronized (j.this.f383j) {
                    pendingIntent = j.this.f395v;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.b
            public void B5(long j7) {
                z3(11, Long.valueOf(j7));
            }

            @Override // android.support.v4.media.session.b
            public void C5(boolean z7) throws RemoteException {
            }

            @Override // android.support.v4.media.session.b
            public void D0(String str, Bundle bundle) throws RemoteException {
                u6(20, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void E2(android.support.v4.media.session.a aVar) {
                j.this.f384k.unregister(aVar);
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat G() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (j.this.f383j) {
                    j jVar = j.this;
                    playbackStateCompat = jVar.f394u;
                    mediaMetadataCompat = jVar.f393t;
                }
                return MediaSessionCompat.j(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.b
            public void G1(String str, Bundle bundle) throws RemoteException {
                u6(5, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo G5() {
                int i7;
                int i8;
                int i9;
                int streamMaxVolume;
                int streamVolume;
                synchronized (j.this.f383j) {
                    j jVar = j.this;
                    i7 = jVar.D;
                    i8 = jVar.E;
                    v vVar = jVar.F;
                    i9 = 2;
                    if (i7 == 2) {
                        int iC = vVar.c();
                        int iB = vVar.b();
                        streamVolume = vVar.a();
                        streamMaxVolume = iB;
                        i9 = iC;
                    } else {
                        streamMaxVolume = jVar.f381h.getStreamMaxVolume(i8);
                        streamVolume = j.this.f381h.getStreamVolume(i8);
                    }
                }
                return new ParcelableVolumeInfo(i7, i8, i9, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.b
            public void H0(android.support.v4.media.session.a aVar) {
                if (j.this.f386m) {
                    try {
                        aVar.e0();
                    } catch (Exception unused) {
                    }
                } else {
                    j.this.f384k.register(aVar, new androidx.media.j.b(androidx.media.j.b.f8674b, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.b
            public String J() {
                return j.this.f379f;
            }

            @Override // android.support.v4.media.session.b
            public void L2(String str, Bundle bundle) throws RemoteException {
                u6(8, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void N(MediaDescriptionCompat mediaDescriptionCompat) {
                z3(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public void N1() throws RemoteException {
                u0(3);
            }

            @Override // android.support.v4.media.session.b
            public boolean N3(KeyEvent keyEvent) {
                boolean z7 = (j.this.f392s & 1) != 0;
                if (z7) {
                    z3(21, keyEvent);
                }
                return z7;
            }

            @Override // android.support.v4.media.session.b
            public void N4(int i7) {
                y0(28, i7);
            }

            @Override // android.support.v4.media.session.b
            public void O(MediaDescriptionCompat mediaDescriptionCompat) {
                z3(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public int P() {
                return j.this.f398y;
            }

            @Override // android.support.v4.media.session.b
            public boolean R0() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public void R2(String str, Bundle bundle) throws RemoteException {
                u6(9, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void S0(RatingCompat ratingCompat) throws RemoteException {
                z3(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.b
            public CharSequence X() {
                return j.this.f397x;
            }

            @Override // android.support.v4.media.session.b
            public void X0(int i7, int i8, String str) {
                j.this.O(i7, i8);
            }

            @Override // android.support.v4.media.session.b
            public void Y0(Uri uri, Bundle bundle) throws RemoteException {
                u6(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void Y2() throws RemoteException {
                u0(16);
            }

            @Override // android.support.v4.media.session.b
            public void Y3(int i7, int i8, String str) {
                j.this.a(i7, i8);
            }

            @Override // android.support.v4.media.session.b
            public void c4(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                u6(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void c5() throws RemoteException {
                u0(7);
            }

            @Override // android.support.v4.media.session.b
            public void f0(boolean z7) throws RemoteException {
                z3(29, Boolean.valueOf(z7));
            }

            @Override // android.support.v4.media.session.b
            public void f3(Uri uri, Bundle bundle) throws RemoteException {
                u6(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void g4(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
                t6(26, mediaDescriptionCompat, i7);
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (j.this.f383j) {
                    bundle = j.this.C;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.b
            public void h5(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                z3(1, new b(str, bundle, resultReceiverWrapper.f344a));
            }

            @Override // android.support.v4.media.session.b
            public void k3(long j7) throws RemoteException {
                z3(18, Long.valueOf(j7));
            }

            @Override // android.support.v4.media.session.b
            public int l0() {
                return j.this.B;
            }

            @Override // android.support.v4.media.session.b
            public boolean m0() {
                return j.this.f399z;
            }

            @Override // android.support.v4.media.session.b
            public String m4() {
                return j.this.f380g;
            }

            @Override // android.support.v4.media.session.b
            public void next() throws RemoteException {
                u0(14);
            }

            @Override // android.support.v4.media.session.b
            public List<QueueItem> o0() {
                List<QueueItem> list;
                synchronized (j.this.f383j) {
                    list = j.this.f396w;
                }
                return list;
            }

            @Override // android.support.v4.media.session.b
            public void pause() throws RemoteException {
                u0(12);
            }

            @Override // android.support.v4.media.session.b
            public void previous() throws RemoteException {
                u0(15);
            }

            @Override // android.support.v4.media.session.b
            public void q0(int i7) throws RemoteException {
                y0(23, i7);
            }

            @Override // android.support.v4.media.session.b
            public void s0() throws RemoteException {
                u0(17);
            }

            @Override // android.support.v4.media.session.b
            public void stop() throws RemoteException {
                u0(13);
            }

            void t6(int i7, Object obj, int i8) {
                j.this.g(i7, i8, 0, obj, null);
            }

            void u0(int i7) {
                j.this.g(i7, 0, 0, null, null);
            }

            void u6(int i7, Object obj, Bundle bundle) {
                j.this.g(i7, 0, 0, obj, bundle);
            }

            @Override // android.support.v4.media.session.b
            public int v0() {
                return j.this.A;
            }

            @Override // android.support.v4.media.session.b
            public long w() {
                long j7;
                synchronized (j.this.f383j) {
                    j7 = j.this.f392s;
                }
                return j7;
            }

            @Override // android.support.v4.media.session.b
            public void x0(int i7) throws RemoteException {
                y0(30, i7);
            }

            @Override // android.support.v4.media.session.b
            public boolean x1() {
                return (j.this.f392s & 2) != 0;
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat y() {
                return j.this.f393t;
            }

            void y0(int i7, int i8) {
                j.this.g(i7, i8, 0, null, null);
            }

            @Override // android.support.v4.media.session.b
            public void z2(String str, Bundle bundle) throws RemoteException {
                u6(4, str, bundle);
            }

            void z3(int i7, Object obj) {
                j.this.g(i7, 0, 0, obj, null);
            }
        }

        class d extends Handler {
            private static final int A = 26;
            private static final int B = 27;
            private static final int C = 28;
            private static final int D = 29;
            private static final int E = 30;
            private static final int F = 127;
            private static final int G = 126;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int f405b = 1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final int f406c = 2;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final int f407d = 3;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final int f408e = 4;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final int f409f = 5;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final int f410g = 6;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final int f411h = 7;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final int f412i = 8;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final int f413j = 9;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final int f414k = 10;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private static final int f415l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private static final int f416m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private static final int f417n = 13;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private static final int f418o = 14;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private static final int f419p = 15;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private static final int f420q = 16;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            private static final int f421r = 17;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private static final int f422s = 18;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private static final int f423t = 19;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private static final int f424u = 31;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private static final int f425v = 20;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            private static final int f426w = 21;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            private static final int f427x = 22;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            private static final int f428y = 23;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            private static final int f429z = 25;

            public d(Looper looper) {
                super(looper);
            }

            private void a(KeyEvent keyEvent, d dVar) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                PlaybackStateCompat playbackStateCompat = j.this.f394u;
                long jB = playbackStateCompat == null ? 0L : playbackStateCompat.b();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode == 126) {
                        if ((jB & 4) != 0) {
                            dVar.i();
                            return;
                        }
                        return;
                    }
                    if (keyCode == 127) {
                        if ((jB & 2) != 0) {
                            dVar.h();
                            return;
                        }
                        return;
                    }
                    switch (keyCode) {
                        case 86:
                            if ((jB & 1) != 0) {
                                dVar.C();
                            }
                            break;
                        case com.alibaba.fastjson.asm.j.f12630x /* 87 */:
                            if ((jB & 32) != 0) {
                                dVar.z();
                            }
                            break;
                        case 88:
                            if ((jB & 16) != 0) {
                                dVar.A();
                            }
                            break;
                        case com.alibaba.fastjson.asm.j.f12631y /* 89 */:
                            if ((jB & 8) != 0) {
                                dVar.s();
                            }
                            break;
                        case 90:
                            if ((jB & 64) != 0) {
                                dVar.f();
                            }
                            break;
                    }
                }
                Log.w(MediaSessionCompat.f314d, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                d dVar = j.this.f390q;
                if (dVar == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.b(data);
                j.this.w(new androidx.media.j.b(data.getString(MediaSessionCompat.L), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle(MediaSessionCompat.O);
                MediaSessionCompat.b(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            b bVar = (b) message.obj;
                            dVar.d(bVar.f401a, bVar.f402b, bVar.f403c);
                            break;
                        case 2:
                            j.this.a(message.arg1, 0);
                            break;
                        case 3:
                            dVar.m();
                            break;
                        case 4:
                            dVar.n((String) message.obj, bundle);
                            break;
                        case 5:
                            dVar.o((String) message.obj, bundle);
                            break;
                        case 6:
                            dVar.p((Uri) message.obj, bundle);
                            break;
                        case 7:
                            dVar.i();
                            break;
                        case 8:
                            dVar.j((String) message.obj, bundle);
                            break;
                        case 9:
                            dVar.k((String) message.obj, bundle);
                            break;
                        case 10:
                            dVar.l((Uri) message.obj, bundle);
                            break;
                        case 11:
                            dVar.B(((Long) message.obj).longValue());
                            break;
                        case 12:
                            dVar.h();
                            break;
                        case 13:
                            dVar.C();
                            break;
                        case 14:
                            dVar.z();
                            break;
                        case 15:
                            dVar.A();
                            break;
                        case 16:
                            dVar.f();
                            break;
                        case 17:
                            dVar.s();
                            break;
                        case 18:
                            dVar.t(((Long) message.obj).longValue());
                            break;
                        case 19:
                            dVar.v((RatingCompat) message.obj);
                            break;
                        case 20:
                            dVar.e((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!dVar.g(intent)) {
                                a(keyEvent, dVar);
                            }
                            break;
                        case 22:
                            j.this.O(message.arg1, 0);
                            break;
                        case 23:
                            dVar.x(message.arg1);
                            break;
                        case 25:
                            dVar.b((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            dVar.c((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            dVar.q((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            List<QueueItem> list = j.this.f396w;
                            if (list != null) {
                                int i7 = message.arg1;
                                QueueItem queueItem = (i7 < 0 || i7 >= list.size()) ? null : j.this.f396w.get(message.arg1);
                                if (queueItem != null) {
                                    dVar.q(queueItem.d());
                                }
                            }
                            break;
                        case 29:
                            dVar.u(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            dVar.y(message.arg1);
                            break;
                        case 31:
                            dVar.w((RatingCompat) message.obj, bundle);
                            break;
                    }
                } finally {
                    j.this.w(null);
                }
            }
        }

        public j(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.f374a = context;
            this.f379f = context.getPackageName();
            this.f381h = (AudioManager) context.getSystemService("audio");
            this.f380g = str;
            this.f375b = componentName;
            this.f376c = pendingIntent;
            c cVar = new c();
            this.f377d = cVar;
            this.f378e = new Token(cVar);
            this.f398y = 0;
            this.D = 1;
            this.E = 3;
            this.f382i = new RemoteControlClient(pendingIntent);
        }

        private void B(boolean z7) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).l3(z7);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void C(String str, Bundle bundle) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).h6(str, bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void D(Bundle bundle) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).T(bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void E(MediaMetadataCompat mediaMetadataCompat) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).h4(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void F(List<QueueItem> list) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).W(list);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void H(CharSequence charSequence) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).c0(charSequence);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void I(int i7) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).A4(i7);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void J() {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).e0();
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
            this.f384k.kill();
        }

        private void K(int i7) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).W4(i7);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        private void L(PlaybackStateCompat playbackStateCompat) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).g6(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public androidx.media.j.b A() {
            androidx.media.j.b bVar;
            synchronized (this.f383j) {
                bVar = this.f391r;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public PlaybackStateCompat G() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f383j) {
                playbackStateCompat = this.f394u;
            }
            return playbackStateCompat;
        }

        void M(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int iBeginBroadcast = this.f384k.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f384k.getBroadcastItem(iBeginBroadcast)).r6(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.f384k.finishBroadcast();
        }

        void N(PlaybackStateCompat playbackStateCompat) {
            this.f382i.setPlaybackState(e(playbackStateCompat.p()));
        }

        void O(int i7, int i8) {
            if (this.D != 2) {
                this.f381h.setStreamVolume(this.E, i7, i8);
                return;
            }
            v vVar = this.F;
            if (vVar != null) {
                vVar.f(i7);
            }
        }

        void P(PendingIntent pendingIntent, ComponentName componentName) {
            this.f381h.unregisterMediaButtonEventReceiver(componentName);
        }

        boolean Q() {
            if (!this.f387n) {
                if (this.f388o) {
                    P(this.f376c, this.f375b);
                    this.f388o = false;
                }
                if (!this.f389p) {
                    return false;
                }
                this.f382i.setPlaybackState(0);
                this.f381h.unregisterRemoteControlClient(this.f382i);
                this.f389p = false;
                return false;
            }
            boolean z7 = this.f388o;
            if (!z7 && (this.f392s & 1) != 0) {
                h(this.f376c, this.f375b);
                this.f388o = true;
            } else if (z7 && (this.f392s & 1) == 0) {
                P(this.f376c, this.f375b);
                this.f388o = false;
            }
            boolean z8 = this.f389p;
            if (!z8 && (this.f392s & 2) != 0) {
                this.f381h.registerRemoteControlClient(this.f382i);
                this.f389p = true;
                return true;
            }
            if (!z8 || (this.f392s & 2) != 0) {
                return false;
            }
            this.f382i.setPlaybackState(0);
            this.f381h.unregisterRemoteControlClient(this.f382i);
            this.f389p = false;
            return false;
        }

        void a(int i7, int i8) {
            if (this.D != 2) {
                this.f381h.adjustStreamVolume(this.E, i7, i8);
                return;
            }
            v vVar = this.F;
            if (vVar != null) {
                vVar.e(i7);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public boolean b() {
            return this.f387n;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Token c() {
            return this.f378e;
        }

        RemoteControlClient.MetadataEditor d(Bundle bundle) {
            RemoteControlClient.MetadataEditor metadataEditorEditMetadata = this.f382i.editMetadata(true);
            if (bundle == null) {
                return metadataEditorEditMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.f236t)) {
                Bitmap bitmapCopy = (Bitmap) bundle.getParcelable(MediaMetadataCompat.f236t);
                if (bitmapCopy != null) {
                    bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy);
            } else if (bundle.containsKey(MediaMetadataCompat.f238v)) {
                Bitmap bitmapCopy2 = (Bitmap) bundle.getParcelable(MediaMetadataCompat.f238v);
                if (bitmapCopy2 != null) {
                    bitmapCopy2 = bitmapCopy2.copy(bitmapCopy2.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy2);
            }
            if (bundle.containsKey(MediaMetadataCompat.f224h)) {
                metadataEditorEditMetadata.putString(1, bundle.getString(MediaMetadataCompat.f224h));
            }
            if (bundle.containsKey(MediaMetadataCompat.f235s)) {
                metadataEditorEditMetadata.putString(13, bundle.getString(MediaMetadataCompat.f235s));
            }
            if (bundle.containsKey(MediaMetadataCompat.f222f)) {
                metadataEditorEditMetadata.putString(2, bundle.getString(MediaMetadataCompat.f222f));
            }
            if (bundle.containsKey(MediaMetadataCompat.f225i)) {
                metadataEditorEditMetadata.putString(3, bundle.getString(MediaMetadataCompat.f225i));
            }
            if (bundle.containsKey(MediaMetadataCompat.f228l)) {
                metadataEditorEditMetadata.putString(15, bundle.getString(MediaMetadataCompat.f228l));
            }
            if (bundle.containsKey(MediaMetadataCompat.f227k)) {
                metadataEditorEditMetadata.putString(4, bundle.getString(MediaMetadataCompat.f227k));
            }
            if (bundle.containsKey(MediaMetadataCompat.f229m)) {
                metadataEditorEditMetadata.putString(5, bundle.getString(MediaMetadataCompat.f229m));
            }
            if (bundle.containsKey(MediaMetadataCompat.f234r)) {
                metadataEditorEditMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.f234r));
            }
            if (bundle.containsKey(MediaMetadataCompat.f223g)) {
                metadataEditorEditMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.f223g));
            }
            if (bundle.containsKey(MediaMetadataCompat.f231o)) {
                metadataEditorEditMetadata.putString(6, bundle.getString(MediaMetadataCompat.f231o));
            }
            if (bundle.containsKey(MediaMetadataCompat.f221e)) {
                metadataEditorEditMetadata.putString(7, bundle.getString(MediaMetadataCompat.f221e));
            }
            if (bundle.containsKey(MediaMetadataCompat.f232p)) {
                metadataEditorEditMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.f232p));
            }
            if (bundle.containsKey(MediaMetadataCompat.f226j)) {
                metadataEditorEditMetadata.putString(11, bundle.getString(MediaMetadataCompat.f226j));
            }
            return metadataEditorEditMetadata;
        }

        int e(int i7) {
            switch (i7) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        int f(long j7) {
            int i7 = (1 & j7) != 0 ? 32 : 0;
            if ((2 & j7) != 0) {
                i7 |= 16;
            }
            if ((4 & j7) != 0) {
                i7 |= 4;
            }
            if ((8 & j7) != 0) {
                i7 |= 2;
            }
            if ((16 & j7) != 0) {
                i7 |= 1;
            }
            if ((32 & j7) != 0) {
                i7 |= 128;
            }
            if ((64 & j7) != 0) {
                i7 |= 64;
            }
            return (j7 & 512) != 0 ? i7 | 8 : i7;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void f0(boolean z7) {
            if (this.f399z != z7) {
                this.f399z = z7;
                B(z7);
            }
        }

        void g(int i7, int i8, int i9, Object obj, Bundle bundle) {
            synchronized (this.f383j) {
                d dVar = this.f385l;
                if (dVar != null) {
                    Message messageObtainMessage = dVar.obtainMessage(i7, i8, i9, obj);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MediaSessionCompat.L, androidx.media.j.b.f8674b);
                    bundle2.putInt("data_calling_pid", Binder.getCallingPid());
                    bundle2.putInt("data_calling_uid", Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.O, bundle);
                    }
                    messageObtainMessage.setData(bundle2);
                    messageObtainMessage.sendToTarget();
                }
            }
        }

        void h(PendingIntent pendingIntent, ComponentName componentName) {
            this.f381h.registerMediaButtonEventReceiver(componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void i() {
            this.f387n = false;
            this.f386m = true;
            Q();
            J();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void j(int i7) {
            synchronized (this.f383j) {
                this.f392s = i7;
            }
            Q();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void k(String str, Bundle bundle) {
            C(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public String l() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void m(PendingIntent pendingIntent) {
            synchronized (this.f383j) {
                this.f395v = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void n(d dVar, Handler handler) {
            this.f390q = dVar;
            if (dVar != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                synchronized (this.f383j) {
                    d dVar2 = this.f385l;
                    if (dVar2 != null) {
                        dVar2.removeCallbacksAndMessages(null);
                    }
                    this.f385l = new d(handler.getLooper());
                    this.f390q.D(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void o(int i7) {
            v vVar = this.F;
            if (vVar != null) {
                vVar.g(null);
            }
            this.E = i7;
            this.D = 1;
            int i8 = this.D;
            int i9 = this.E;
            M(new ParcelableVolumeInfo(i8, i9, 2, this.f381h.getStreamMaxVolume(i9), this.f381h.getStreamVolume(this.E)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void p(CharSequence charSequence) {
            this.f397x = charSequence;
            H(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void q(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.c(mediaMetadataCompat, MediaSessionCompat.P).a();
            }
            synchronized (this.f383j) {
                this.f393t = mediaMetadataCompat;
            }
            E(mediaMetadataCompat);
            if (this.f387n) {
                d(mediaMetadataCompat == null ? null : mediaMetadataCompat.e()).apply();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void q0(int i7) {
            if (this.A != i7) {
                this.A = i7;
                I(i7);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void r(PendingIntent pendingIntent) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void s(int i7) {
            this.f398y = i7;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void setExtras(Bundle bundle) {
            this.C = bundle;
            D(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void t(List<QueueItem> list) {
            this.f396w = list;
            F(list);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Object u() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void v(boolean z7) {
            if (z7 == this.f387n) {
                return;
            }
            this.f387n = z7;
            if (Q()) {
                q(this.f393t);
                x(this.f394u);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void w(androidx.media.j.b bVar) {
            synchronized (this.f383j) {
                this.f391r = bVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void x(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f383j) {
                this.f394u = playbackStateCompat;
            }
            L(playbackStateCompat);
            if (this.f387n) {
                if (playbackStateCompat == null) {
                    this.f382i.setPlaybackState(0);
                    this.f382i.setTransportControlFlags(0);
                } else {
                    N(playbackStateCompat);
                    this.f382i.setTransportControlFlags(f(playbackStateCompat.b()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void x0(int i7) {
            if (this.B != i7) {
                this.B = i7;
                K(i7);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Object y() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void z(v vVar) {
            if (vVar == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            v vVar2 = this.F;
            if (vVar2 != null) {
                vVar2.g(null);
            }
            this.D = 2;
            this.F = vVar;
            M(new ParcelableVolumeInfo(this.D, this.E, this.F.c(), this.F.b(), this.F.a()));
            vVar.g(this.G);
        }
    }

    public interface k {
        void a();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface l {
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static void b(@o0 Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat c(Context context, Object obj) {
        if (context == null || obj == null) {
            return null;
        }
        return new MediaSessionCompat(context, new h(obj));
    }

    static PlaybackStateCompat j(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long j7;
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long jG = -1;
        if (playbackStateCompat.o() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.p() != 3 && playbackStateCompat.p() != 4 && playbackStateCompat.p() != 5) {
            return playbackStateCompat;
        }
        long jK = playbackStateCompat.k();
        if (jK <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jL = ((long) (playbackStateCompat.l() * (jElapsedRealtime - jK))) + playbackStateCompat.o();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a(MediaMetadataCompat.f223g)) {
            jG = mediaMetadataCompat.g(MediaMetadataCompat.f223g);
        }
        if (jG < 0 || jL <= jG) {
            j7 = jL < 0 ? 0L : jL;
        } else {
            j7 = jG;
        }
        return new PlaybackStateCompat.c(playbackStateCompat).k(playbackStateCompat.p(), j7, playbackStateCompat.l(), jElapsedRealtime).c();
    }

    public void A(CharSequence charSequence) {
        this.f337a.p(charSequence);
    }

    public void B(int i7) {
        this.f337a.s(i7);
    }

    public void C(int i7) {
        this.f337a.q0(i7);
    }

    public void D(PendingIntent pendingIntent) {
        this.f337a.m(pendingIntent);
    }

    public void E(int i7) {
        this.f337a.x0(i7);
    }

    public void a(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f339c.add(kVar);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public String d() {
        return this.f337a.l();
    }

    public MediaControllerCompat e() {
        return this.f338b;
    }

    @m0
    public final androidx.media.j.b f() {
        return this.f337a.A();
    }

    public Object g() {
        return this.f337a.y();
    }

    public Object h() {
        return this.f337a.u();
    }

    public Token i() {
        return this.f337a.c();
    }

    public boolean k() {
        return this.f337a.b();
    }

    public void l() {
        this.f337a.i();
    }

    public void m(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f339c.remove(kVar);
    }

    public void n(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.f337a.k(str, bundle);
    }

    public void o(boolean z7) {
        this.f337a.v(z7);
        Iterator<k> it = this.f339c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void p(d dVar) {
        q(dVar, null);
    }

    public void q(d dVar, Handler handler) {
        if (dVar == null) {
            this.f337a.n(null, null);
            return;
        }
        e eVar = this.f337a;
        if (handler == null) {
            handler = new Handler();
        }
        eVar.n(dVar, handler);
    }

    public void r(boolean z7) {
        this.f337a.f0(z7);
    }

    public void s(Bundle bundle) {
        this.f337a.setExtras(bundle);
    }

    public void t(int i7) {
        this.f337a.j(i7);
    }

    public void u(PendingIntent pendingIntent) {
        this.f337a.r(pendingIntent);
    }

    public void v(MediaMetadataCompat mediaMetadataCompat) {
        this.f337a.q(mediaMetadataCompat);
    }

    public void w(PlaybackStateCompat playbackStateCompat) {
        this.f337a.x(playbackStateCompat);
    }

    public void x(int i7) {
        this.f337a.o(i7);
    }

    public void y(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.f337a.z(vVar);
    }

    public void z(List<QueueItem> list) {
        this.f337a.t(list);
    }

    @x0({x0.a.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ResultReceiver f344a;

        static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i7) {
                return new ResultReceiverWrapper[i7];
            }
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.f344a = resultReceiver;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            this.f344a.writeToParcel(parcel, i7);
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f344a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public MediaSessionCompat(Context context, String str, Bundle bundle) {
        this(context, str, null, null, bundle);
    }

    private MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this.f339c = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.c(context)) == null) {
                    Log.w(f314d, "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    i iVar = new i(context, str, bundle);
                    this.f337a = iVar;
                    p(new a());
                    iVar.r(pendingIntent);
                } else {
                    h hVar = new h(context, str, bundle);
                    this.f337a = hVar;
                    p(new b());
                    hVar.r(pendingIntent);
                }
                this.f338b = new MediaControllerCompat(context, this);
                if (P == 0) {
                    P = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    @t0(21)
    static class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Token f363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f364c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final RemoteCallbackList<android.support.v4.media.session.a> f365d = new RemoteCallbackList<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        PlaybackStateCompat f366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        List<QueueItem> f367f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        MediaMetadataCompat f368g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f369h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f370i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f371j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f372k;

        class a extends android.support.v4.media.session.b.a {
            a() {
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent A1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void B5(long j7) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void C5(boolean z7) throws RemoteException {
            }

            @Override // android.support.v4.media.session.b
            public void D0(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void E2(android.support.v4.media.session.a aVar) {
                h.this.f365d.unregister(aVar);
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat G() {
                h hVar = h.this;
                return MediaSessionCompat.j(hVar.f366e, hVar.f368g);
            }

            @Override // android.support.v4.media.session.b
            public void G1(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo G5() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void H0(android.support.v4.media.session.a aVar) {
                h hVar = h.this;
                if (hVar.f364c) {
                    return;
                }
                String strL = hVar.l();
                if (strL == null) {
                    strL = androidx.media.j.b.f8674b;
                }
                h.this.f365d.register(aVar, new androidx.media.j.b(strL, Binder.getCallingPid(), Binder.getCallingUid()));
            }

            @Override // android.support.v4.media.session.b
            public String J() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void L2(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void N(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void N1() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean N3(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void N4(int i7) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void O(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int P() {
                return h.this.f369h;
            }

            @Override // android.support.v4.media.session.b
            public boolean R0() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public void R2(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void S0(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public CharSequence X() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void X0(int i7, int i8, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y0(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y2() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Y3(int i7, int i8, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void c4(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void c5() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f0(boolean z7) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f3(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void g4(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void h5(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void k3(long j7) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int l0() {
                return h.this.f372k;
            }

            @Override // android.support.v4.media.session.b
            public boolean m0() {
                return h.this.f370i;
            }

            @Override // android.support.v4.media.session.b
            public String m4() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public List<QueueItem> o0() {
                return null;
            }

            @Override // android.support.v4.media.session.b
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void q0(int i7) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s0() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int v0() {
                return h.this.f371j;
            }

            @Override // android.support.v4.media.session.b
            public long w() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void x0(int i7) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean x1() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat y() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void z2(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
        }

        h(Context context, String str, Bundle bundle) {
            Object objB = android.support.v4.media.session.k.b(context, str);
            this.f362a = objB;
            this.f363b = new Token(android.support.v4.media.session.k.c(objB), new a(), bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public androidx.media.j.b A() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public PlaybackStateCompat G() {
            return this.f366e;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public boolean b() {
            return android.support.v4.media.session.k.e(this.f362a);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Token c() {
            return this.f363b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void f0(boolean z7) {
            if (this.f370i != z7) {
                this.f370i = z7;
                for (int iBeginBroadcast = this.f365d.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f365d.getBroadcastItem(iBeginBroadcast)).l3(z7);
                    } catch (RemoteException unused) {
                    }
                }
                this.f365d.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void i() {
            this.f364c = true;
            android.support.v4.media.session.k.f(this.f362a);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void j(int i7) {
            android.support.v4.media.session.k.k(this.f362a, i7);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void k(String str, Bundle bundle) {
            android.support.v4.media.session.k.g(this.f362a, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public String l() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return n.b(this.f362a);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void m(PendingIntent pendingIntent) {
            android.support.v4.media.session.k.s(this.f362a, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void n(d dVar, Handler handler) {
            android.support.v4.media.session.k.i(this.f362a, dVar == null ? null : dVar.f351a, handler);
            if (dVar != null) {
                dVar.D(this, handler);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void o(int i7) {
            android.support.v4.media.session.k.o(this.f362a, i7);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void p(CharSequence charSequence) {
            android.support.v4.media.session.k.r(this.f362a, charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void q(MediaMetadataCompat mediaMetadataCompat) {
            this.f368g = mediaMetadataCompat;
            android.support.v4.media.session.k.m(this.f362a, mediaMetadataCompat == null ? null : mediaMetadataCompat.h());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void q0(int i7) {
            if (this.f371j != i7) {
                this.f371j = i7;
                for (int iBeginBroadcast = this.f365d.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f365d.getBroadcastItem(iBeginBroadcast)).A4(i7);
                    } catch (RemoteException unused) {
                    }
                }
                this.f365d.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void r(PendingIntent pendingIntent) {
            android.support.v4.media.session.k.l(this.f362a, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void s(int i7) {
            android.support.v4.media.session.l.a(this.f362a, i7);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void setExtras(Bundle bundle) {
            android.support.v4.media.session.k.j(this.f362a, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void t(List<QueueItem> list) {
            ArrayList arrayList;
            this.f367f = list;
            if (list != null) {
                arrayList = new ArrayList();
                Iterator<QueueItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f());
                }
            } else {
                arrayList = null;
            }
            android.support.v4.media.session.k.q(this.f362a, arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Object u() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void v(boolean z7) {
            android.support.v4.media.session.k.h(this.f362a, z7);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void w(androidx.media.j.b bVar) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void x(PlaybackStateCompat playbackStateCompat) {
            this.f366e = playbackStateCompat;
            for (int iBeginBroadcast = this.f365d.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f365d.getBroadcastItem(iBeginBroadcast)).g6(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f365d.finishBroadcast();
            android.support.v4.media.session.k.n(this.f362a, playbackStateCompat == null ? null : playbackStateCompat.n());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void x0(int i7) {
            if (this.f372k != i7) {
                this.f372k = i7;
                for (int iBeginBroadcast = this.f365d.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f365d.getBroadcastItem(iBeginBroadcast)).W4(i7);
                    } catch (RemoteException unused) {
                    }
                }
                this.f365d.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public Object y() {
            return this.f362a;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.e
        public void z(v vVar) {
            android.support.v4.media.session.k.p(this.f362a, vVar.d());
        }

        h(Object obj) {
            Object objT = android.support.v4.media.session.k.t(obj);
            this.f362a = objT;
            this.f363b = new Token(android.support.v4.media.session.k.c(objT), new a());
        }
    }

    private MediaSessionCompat(Context context, e eVar) {
        this.f339c = new ArrayList<>();
        this.f337a = eVar;
        if (!android.support.v4.media.session.k.d(eVar.y())) {
            p(new c());
        }
        this.f338b = new MediaControllerCompat(context, this);
    }
}
