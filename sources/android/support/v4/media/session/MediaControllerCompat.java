package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.ComponentActivity;
import androidx.core.app.r;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import c.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String f264d = "MediaControllerCompat";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f265e = "android.support.v4.media.session.command.GET_EXTRA_BINDER";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f266f = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f267g = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f268h = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f269i = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f270j = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f271k = "android.support.v4.media.session.command.ARGUMENT_INDEX";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet<a> f274c = new HashSet<>();

    @t0(21)
    static class MediaControllerImplApi21 implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Object f275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f276b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @z("mLock")
        private final List<a> f277c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private HashMap<a, a> f278d = new HashMap<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f279e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f280a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f280a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i7, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f280a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f276b) {
                    mediaControllerImplApi21.f279e.h(android.support.v4.media.session.b.a.i0(r.a(bundle, MediaSessionCompat.I)));
                    mediaControllerImplApi21.f279e.i(bundle.getBundle(MediaSessionCompat.f313J));
                    mediaControllerImplApi21.m();
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void T(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void W(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void c0(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void e0() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void h4(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void r6(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f279e = token;
            Object objD = android.support.v4.media.session.c.d(context, token.g());
            this.f275a = objD;
            if (objD == null) {
                throw new RemoteException();
            }
            if (token.e() == null) {
                n();
            }
        }

        private void n() {
            g(MediaControllerCompat.f265e, null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public PlaybackStateCompat G() {
            if (this.f279e.e() != null) {
                try {
                    return this.f279e.e().G();
                } catch (RemoteException e8) {
                    Log.e(MediaControllerCompat.f264d, "Dead object in getPlaybackState.", e8);
                }
            }
            Object objK = android.support.v4.media.session.c.k(this.f275a);
            if (objK != null) {
                return PlaybackStateCompat.a(objK);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public String J() {
            return android.support.v4.media.session.c.i(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void N(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((w() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f270j, mediaDescriptionCompat);
            g(MediaControllerCompat.f268h, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void O(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((w() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f270j, mediaDescriptionCompat);
            g(MediaControllerCompat.f266f, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int P() {
            return android.support.v4.media.session.c.n(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public CharSequence X() {
            return android.support.v4.media.session.c.m(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public g a() {
            Object objJ = android.support.v4.media.session.c.j(this.f275a);
            if (objJ != null) {
                return new g(android.support.v4.media.session.c.C0015c.e(objJ), android.support.v4.media.session.c.C0015c.c(objJ), android.support.v4.media.session.c.C0015c.f(objJ), android.support.v4.media.session.c.C0015c.d(objJ), android.support.v4.media.session.c.C0015c.b(objJ));
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void b(int i7, int i8) {
            android.support.v4.media.session.c.a(this.f275a, i7, i8);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public final void c(a aVar) {
            android.support.v4.media.session.c.v(this.f275a, aVar.f281a);
            synchronized (this.f276b) {
                if (this.f279e.e() != null) {
                    try {
                        a aVarRemove = this.f278d.remove(aVar);
                        if (aVarRemove != null) {
                            aVar.f283c = null;
                            this.f279e.e().E2(aVarRemove);
                        }
                    } catch (RemoteException e8) {
                        Log.e(MediaControllerCompat.f264d, "Dead object in unregisterCallback.", e8);
                    }
                } else {
                    this.f277c.remove(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean d(KeyEvent keyEvent) {
            return android.support.v4.media.session.c.c(this.f275a, keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void e(int i7, int i8) {
            android.support.v4.media.session.c.u(this.f275a, i7, i8);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void f(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
            if ((w() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f270j, mediaDescriptionCompat);
            bundle.putInt(MediaControllerCompat.f271k, i7);
            g(MediaControllerCompat.f267g, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            android.support.v4.media.session.c.s(this.f275a, str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public Bundle getExtras() {
            return android.support.v4.media.session.c.e(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean h() {
            return this.f279e.e() != null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public PendingIntent i() {
            return android.support.v4.media.session.c.o(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public h j() {
            Object objQ = android.support.v4.media.session.c.q(this.f275a);
            if (objQ != null) {
                return new i(objQ);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public Object k() {
            return this.f275a;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public final void l(a aVar, Handler handler) {
            android.support.v4.media.session.c.r(this.f275a, aVar.f281a, handler);
            synchronized (this.f276b) {
                if (this.f279e.e() != null) {
                    a aVar2 = new a(aVar);
                    this.f278d.put(aVar, aVar2);
                    aVar.f283c = aVar2;
                    try {
                        this.f279e.e().H0(aVar2);
                        aVar.n(13, null, null);
                    } catch (RemoteException e8) {
                        Log.e(MediaControllerCompat.f264d, "Dead object in registerCallback.", e8);
                    }
                } else {
                    aVar.f283c = null;
                    this.f277c.add(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int l0() {
            if (this.f279e.e() == null) {
                return -1;
            }
            try {
                return this.f279e.e().l0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getShuffleMode.", e8);
                return -1;
            }
        }

        @z("mLock")
        void m() {
            if (this.f279e.e() == null) {
                return;
            }
            for (a aVar : this.f277c) {
                a aVar2 = new a(aVar);
                this.f278d.put(aVar, aVar2);
                aVar.f283c = aVar2;
                try {
                    this.f279e.e().H0(aVar2);
                    aVar.n(13, null, null);
                } catch (RemoteException e8) {
                    Log.e(MediaControllerCompat.f264d, "Dead object in registerCallback.", e8);
                }
            }
            this.f277c.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean m0() {
            if (this.f279e.e() == null) {
                return false;
            }
            try {
                return this.f279e.e().m0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in isCaptioningEnabled.", e8);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public List<MediaSessionCompat.QueueItem> o0() {
            List<Object> listL = android.support.v4.media.session.c.l(this.f275a);
            if (listL != null) {
                return MediaSessionCompat.QueueItem.b(listL);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int v0() {
            if (this.f279e.e() == null) {
                return -1;
            }
            try {
                return this.f279e.e().v0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getRepeatMode.", e8);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public long w() {
            return android.support.v4.media.session.c.f(this.f275a);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public MediaMetadataCompat y() {
            Object objH = android.support.v4.media.session.c.h(this.f275a);
            if (objH != null) {
                return MediaMetadataCompat.b(objH);
            }
            return null;
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f281a = android.support.v4.media.session.c.b(new b(this));

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        HandlerC0010a f282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        android.support.v4.media.session.a f283c;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private class HandlerC0010a extends Handler {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final int f284c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final int f285d = 2;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final int f286e = 3;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final int f287f = 4;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final int f288g = 5;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final int f289h = 6;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static final int f290i = 7;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static final int f291j = 8;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final int f292k = 9;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private static final int f293l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private static final int f294m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private static final int f295n = 13;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f296a;

            HandlerC0010a(Looper looper) {
                super(looper);
                this.f296a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f296a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.b(data);
                            a.this.k((String) message.obj, data);
                            break;
                        case 2:
                            a.this.f((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            a.this.e((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            a.this.b((g) message.obj);
                            break;
                        case 5:
                            a.this.g((List) message.obj);
                            break;
                        case 6:
                            a.this.h((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.b(bundle);
                            a.this.d(bundle);
                            break;
                        case 8:
                            a.this.j();
                            break;
                        case 9:
                            a.this.i(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            a.this.c(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            a.this.m(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            a.this.l();
                            break;
                    }
                }
            }
        }

        private static class b implements android.support.v4.media.session.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f298a;

            b(a aVar) {
                this.f298a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.c.a
            public void T(Bundle bundle) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.d(bundle);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void W(List<?> list) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.g(MediaSessionCompat.QueueItem.b(list));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object obj) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.e(MediaMetadataCompat.b(obj));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void b(int i7, int i8, int i9, int i10, int i11) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.b(new g(i7, i8, i9, i10, i11));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void c(Object obj) {
                a aVar = this.f298a.get();
                if (aVar == null || aVar.f283c != null) {
                    return;
                }
                aVar.f(PlaybackStateCompat.a(obj));
            }

            @Override // android.support.v4.media.session.c.a
            public void c0(CharSequence charSequence) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.h(charSequence);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void d(String str, Bundle bundle) {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    android.support.v4.media.session.a aVar2 = aVar.f283c;
                    aVar.k(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void e0() {
                a aVar = this.f298a.get();
                if (aVar != null) {
                    aVar.j();
                }
            }
        }

        private static class c extends android.support.v4.media.session.a.AbstractBinderC0012a {

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private final WeakReference<a> f299q;

            c(a aVar) {
                this.f299q = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void A4(int i7) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(9, Integer.valueOf(i7), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void P1() throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void Q3(boolean z7) throws RemoteException {
            }

            public void T(Bundle bundle) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(7, bundle, null);
                }
            }

            public void W(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void W4(int i7) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(12, Integer.valueOf(i7), null);
                }
            }

            public void c0(CharSequence charSequence) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(6, charSequence, null);
                }
            }

            public void e0() throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void g6(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(2, playbackStateCompat, null);
                }
            }

            public void h4(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void h6(String str, Bundle bundle) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.a
            public void l3(boolean z7) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(11, Boolean.valueOf(z7), null);
                }
            }

            public void r6(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = this.f299q.get();
                if (aVar != null) {
                    aVar.n(4, parcelableVolumeInfo != null ? new g(parcelableVolumeInfo.f431a, parcelableVolumeInfo.f432b, parcelableVolumeInfo.f433c, parcelableVolumeInfo.f434d, parcelableVolumeInfo.f435e) : null, null);
                }
            }
        }

        @x0({x0.a.LIBRARY})
        public android.support.v4.media.session.a a() {
            return this.f283c;
        }

        public void b(g gVar) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            n(8, null, null);
        }

        public void c(boolean z7) {
        }

        public void d(Bundle bundle) {
        }

        public void e(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void f(PlaybackStateCompat playbackStateCompat) {
        }

        public void g(List<MediaSessionCompat.QueueItem> list) {
        }

        public void h(CharSequence charSequence) {
        }

        public void i(int i7) {
        }

        public void j() {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l() {
        }

        public void m(int i7) {
        }

        void n(int i7, Object obj, Bundle bundle) {
            HandlerC0010a handlerC0010a = this.f282b;
            if (handlerC0010a != null) {
                Message messageObtainMessage = handlerC0010a.obtainMessage(i7, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        void o(Handler handler) {
            if (handler != null) {
                HandlerC0010a handlerC0010a = new HandlerC0010a(handler.getLooper());
                this.f282b = handlerC0010a;
                handlerC0010a.f296a = true;
            } else {
                HandlerC0010a handlerC0010a2 = this.f282b;
                if (handlerC0010a2 != null) {
                    handlerC0010a2.f296a = false;
                    handlerC0010a2.removeCallbacksAndMessages(null);
                    this.f282b = null;
                }
            }
        }
    }

    private static class b extends ComponentActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaControllerCompat f300a;

        b(MediaControllerCompat mediaControllerCompat) {
            this.f300a = mediaControllerCompat;
        }

        MediaControllerCompat a() {
            return this.f300a;
        }
    }

    interface c {
        PlaybackStateCompat G();

        String J();

        void N(MediaDescriptionCompat mediaDescriptionCompat);

        void O(MediaDescriptionCompat mediaDescriptionCompat);

        int P();

        CharSequence X();

        g a();

        void b(int i7, int i8);

        void c(a aVar);

        boolean d(KeyEvent keyEvent);

        void e(int i7, int i8);

        void f(MediaDescriptionCompat mediaDescriptionCompat, int i7);

        void g(String str, Bundle bundle, ResultReceiver resultReceiver);

        Bundle getExtras();

        boolean h();

        PendingIntent i();

        h j();

        Object k();

        void l(a aVar, Handler handler);

        int l0();

        boolean m0();

        List<MediaSessionCompat.QueueItem> o0();

        int v0();

        long w();

        MediaMetadataCompat y();
    }

    @t0(23)
    static class d extends MediaControllerImplApi21 {
        public d(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.c
        public h j() {
            Object objQ = android.support.v4.media.session.c.q(this.f275a);
            if (objQ != null) {
                return new j(objQ);
            }
            return null;
        }
    }

    @t0(24)
    static class e extends d {
        public e(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.d, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.c
        public h j() {
            Object objQ = android.support.v4.media.session.c.q(this.f275a);
            if (objQ != null) {
                return new k(objQ);
            }
            return null;
        }
    }

    static class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.support.v4.media.session.b f301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private h f302b;

        public f(MediaSessionCompat.Token token) {
            this.f301a = android.support.v4.media.session.b.a.i0((IBinder) token.g());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public PlaybackStateCompat G() {
            try {
                return this.f301a.G();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getPlaybackState.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public String J() {
            try {
                return this.f301a.J();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getPackageName.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void N(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f301a.w() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f301a.N(mediaDescriptionCompat);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in removeQueueItem.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void O(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f301a.w() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f301a.O(mediaDescriptionCompat);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in addQueueItem.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int P() {
            try {
                return this.f301a.P();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getRatingType.", e8);
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public CharSequence X() {
            try {
                return this.f301a.X();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getQueueTitle.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public g a() {
            try {
                ParcelableVolumeInfo parcelableVolumeInfoG5 = this.f301a.G5();
                return new g(parcelableVolumeInfoG5.f431a, parcelableVolumeInfoG5.f432b, parcelableVolumeInfoG5.f433c, parcelableVolumeInfoG5.f434d, parcelableVolumeInfoG5.f435e);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getPlaybackInfo.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void b(int i7, int i8) {
            try {
                this.f301a.Y3(i7, i8, null);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in adjustVolume.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void c(a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f301a.E2((android.support.v4.media.session.a) aVar.f281a);
                this.f301a.asBinder().unlinkToDeath(aVar, 0);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in unregisterCallback.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean d(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f301a.N3(keyEvent);
                return false;
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in dispatchMediaButtonEvent.", e8);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void e(int i7, int i8) {
            try {
                this.f301a.X0(i7, i8, null);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setVolumeTo.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void f(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
            try {
                if ((this.f301a.w() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f301a.g4(mediaDescriptionCompat, i7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in addQueueItemAt.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f301a.h5(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in sendCommand.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public Bundle getExtras() {
            try {
                return this.f301a.getExtras();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getExtras.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean h() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public PendingIntent i() {
            try {
                return this.f301a.A1();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getSessionActivity.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public h j() {
            if (this.f302b == null) {
                this.f302b = new l(this.f301a);
            }
            return this.f302b;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public Object k() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public void l(a aVar, Handler handler) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f301a.asBinder().linkToDeath(aVar, 0);
                this.f301a.H0((android.support.v4.media.session.a) aVar.f281a);
                aVar.n(13, null, null);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in registerCallback.", e8);
                aVar.n(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int l0() {
            try {
                return this.f301a.l0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getShuffleMode.", e8);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public boolean m0() {
            try {
                return this.f301a.m0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in isCaptioningEnabled.", e8);
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public List<MediaSessionCompat.QueueItem> o0() {
            try {
                return this.f301a.o0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getQueue.", e8);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public int v0() {
            try {
                return this.f301a.v0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getRepeatMode.", e8);
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public long w() {
            try {
                return this.f301a.w();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getFlags.", e8);
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c
        public MediaMetadataCompat y() {
            try {
                return this.f301a.y();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in getMetadata.", e8);
                return null;
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f303f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f304g = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f309e;

        g(int i7, int i8, int i9, int i10, int i11) {
            this.f305a = i7;
            this.f306b = i8;
            this.f307c = i9;
            this.f308d = i10;
            this.f309e = i11;
        }

        public int a() {
            return this.f306b;
        }

        public int b() {
            return this.f309e;
        }

        public int c() {
            return this.f308d;
        }

        public int d() {
            return this.f305a;
        }

        public int e() {
            return this.f307c;
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f310a = "android.media.session.extra.LEGACY_STREAM_TYPE";

        h() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(String str, Bundle bundle);

        public abstract void e(String str, Bundle bundle);

        public abstract void f(Uri uri, Bundle bundle);

        public abstract void g();

        public abstract void h(String str, Bundle bundle);

        public abstract void i(String str, Bundle bundle);

        public abstract void j(Uri uri, Bundle bundle);

        public abstract void k();

        public abstract void l(long j7);

        public abstract void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void n(String str, Bundle bundle);

        public abstract void o(boolean z7);

        public abstract void p(RatingCompat ratingCompat);

        public abstract void q(RatingCompat ratingCompat, Bundle bundle);

        public abstract void r(int i7);

        public abstract void s(int i7);

        public abstract void t();

        public abstract void u();

        public abstract void v(long j7);

        public abstract void w();
    }

    static class i extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f311b;

        public i(Object obj) {
            this.f311b = obj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void a() {
            android.support.v4.media.session.c.d.a(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void b() {
            android.support.v4.media.session.c.d.b(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void c() {
            android.support.v4.media.session.c.d.c(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void d(String str, Bundle bundle) {
            android.support.v4.media.session.c.d.d(this.f311b, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void e(String str, Bundle bundle) {
            android.support.v4.media.session.c.d.e(this.f311b, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void f(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.B, uri);
            bundle2.putBundle(MediaSessionCompat.D, bundle);
            n(MediaSessionCompat.f327q, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void g() {
            n(MediaSessionCompat.f328r, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void h(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.f336z, str);
            bundle2.putBundle(MediaSessionCompat.D, bundle);
            n(MediaSessionCompat.f329s, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void i(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.A, str);
            bundle2.putBundle(MediaSessionCompat.D, bundle);
            n(MediaSessionCompat.f330t, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void j(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.B, uri);
            bundle2.putBundle(MediaSessionCompat.D, bundle);
            n(MediaSessionCompat.f331u, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void k() {
            android.support.v4.media.session.c.d.f(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void l(long j7) {
            android.support.v4.media.session.c.d.g(this.f311b, j7);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.F(customAction.b(), bundle);
            android.support.v4.media.session.c.d.h(this.f311b, customAction.b(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void n(String str, Bundle bundle) {
            MediaControllerCompat.F(str, bundle);
            android.support.v4.media.session.c.d.h(this.f311b, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void o(boolean z7) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.E, z7);
            n(MediaSessionCompat.f332v, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void p(RatingCompat ratingCompat) {
            android.support.v4.media.session.c.d.i(this.f311b, ratingCompat != null ? ratingCompat.d() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void q(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.C, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.D, bundle);
            n(MediaSessionCompat.f335y, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void r(int i7) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.F, i7);
            n(MediaSessionCompat.f333w, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void s(int i7) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.G, i7);
            n(MediaSessionCompat.f334x, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void t() {
            android.support.v4.media.session.c.d.j(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void u() {
            android.support.v4.media.session.c.d.k(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void v(long j7) {
            android.support.v4.media.session.c.d.l(this.f311b, j7);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void w() {
            android.support.v4.media.session.c.d.m(this.f311b);
        }
    }

    @t0(23)
    static class j extends i {
        public j(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.i, android.support.v4.media.session.MediaControllerCompat.h
        public void f(Uri uri, Bundle bundle) {
            android.support.v4.media.session.d.a.a(this.f311b, uri, bundle);
        }
    }

    @t0(24)
    static class k extends j {
        public k(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.i, android.support.v4.media.session.MediaControllerCompat.h
        public void g() {
            android.support.v4.media.session.i.a.a(this.f311b);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.i, android.support.v4.media.session.MediaControllerCompat.h
        public void h(String str, Bundle bundle) {
            android.support.v4.media.session.i.a.b(this.f311b, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.i, android.support.v4.media.session.MediaControllerCompat.h
        public void i(String str, Bundle bundle) {
            android.support.v4.media.session.i.a.c(this.f311b, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.i, android.support.v4.media.session.MediaControllerCompat.h
        public void j(Uri uri, Bundle bundle) {
            android.support.v4.media.session.i.a.d(this.f311b, uri, bundle);
        }
    }

    static class l extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private android.support.v4.media.session.b f312b;

        public l(android.support.v4.media.session.b bVar) {
            this.f312b = bVar;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void a() {
            try {
                this.f312b.Y2();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in fastForward.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void b() {
            try {
                this.f312b.pause();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in pause.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void c() {
            try {
                this.f312b.c5();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in play.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void d(String str, Bundle bundle) {
            try {
                this.f312b.L2(str, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in playFromMediaId.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void e(String str, Bundle bundle) {
            try {
                this.f312b.R2(str, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in playFromSearch.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void f(Uri uri, Bundle bundle) {
            try {
                this.f312b.f3(uri, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in playFromUri.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void g() {
            try {
                this.f312b.N1();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in prepare.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void h(String str, Bundle bundle) {
            try {
                this.f312b.z2(str, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in prepareFromMediaId.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void i(String str, Bundle bundle) {
            try {
                this.f312b.G1(str, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in prepareFromSearch.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void j(Uri uri, Bundle bundle) {
            try {
                this.f312b.Y0(uri, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in prepareFromUri.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void k() {
            try {
                this.f312b.s0();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in rewind.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void l(long j7) {
            try {
                this.f312b.k3(j7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in seekTo.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            n(customAction.b(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void n(String str, Bundle bundle) {
            MediaControllerCompat.F(str, bundle);
            try {
                this.f312b.D0(str, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in sendCustomAction.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void o(boolean z7) {
            try {
                this.f312b.f0(z7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setCaptioningEnabled.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void p(RatingCompat ratingCompat) {
            try {
                this.f312b.S0(ratingCompat);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setRating.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void q(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.f312b.c4(ratingCompat, bundle);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setRating.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void r(int i7) {
            try {
                this.f312b.q0(i7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setRepeatMode.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void s(int i7) {
            try {
                this.f312b.x0(i7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in setShuffleMode.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void t() {
            try {
                this.f312b.next();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in skipToNext.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void u() {
            try {
                this.f312b.previous();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in skipToPrevious.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void v(long j7) {
            try {
                this.f312b.B5(j7);
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in skipToQueueItem.", e8);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.h
        public void w() {
            try {
                this.f312b.stop();
            } catch (RemoteException e8) {
                Log.e(MediaControllerCompat.f264d, "Dead object in stop.", e8);
            }
        }
    }

    public MediaControllerCompat(Context context, @m0 MediaSessionCompat mediaSessionCompat) {
        c eVar;
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token tokenI = mediaSessionCompat.i();
        this.f273b = tokenI;
        try {
            eVar = Build.VERSION.SDK_INT >= 24 ? new e(context, tokenI) : new d(context, tokenI);
        } catch (RemoteException e8) {
            Log.w(f264d, "Failed to create MediaControllerImpl.", e8);
            eVar = null;
        }
        this.f272a = eVar;
    }

    public static void C(@m0 Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof ComponentActivity) {
            ((ComponentActivity) activity).putExtraData(new b(mediaControllerCompat));
        }
        android.support.v4.media.session.c.t(activity, mediaControllerCompat != null ? android.support.v4.media.session.c.d(activity, mediaControllerCompat.r().g()) : null);
    }

    static void F(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals(MediaSessionCompat.f320j) || str.equals(MediaSessionCompat.f321k)) {
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.f322l)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + com.alibaba.android.arouter.utils.b.f12515h);
            }
        }
    }

    public static MediaControllerCompat g(@m0 Activity activity) {
        if (activity instanceof ComponentActivity) {
            b bVar = (b) ((ComponentActivity) activity).getExtraData(b.class);
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }
        Object objG = android.support.v4.media.session.c.g(activity);
        if (objG == null) {
            return null;
        }
        try {
            return new MediaControllerCompat(activity, MediaSessionCompat.Token.b(android.support.v4.media.session.c.p(objG)));
        } catch (RemoteException e8) {
            Log.e(f264d, "Dead object in getMediaController.", e8);
            return null;
        }
    }

    @Deprecated
    public void A(int i7) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> listM = m();
        if (listM == null || i7 < 0 || i7 >= listM.size() || (queueItem = listM.get(i7)) == null) {
            return;
        }
        z(queueItem.d());
    }

    public void B(@m0 String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.f272a.g(str, bundle, resultReceiver);
    }

    public void D(int i7, int i8) {
        this.f272a.e(i7, i8);
    }

    public void E(@m0 a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        try {
            this.f274c.remove(aVar);
            this.f272a.c(aVar);
        } finally {
            aVar.o(null);
        }
    }

    public void a(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f272a.O(mediaDescriptionCompat);
    }

    public void b(MediaDescriptionCompat mediaDescriptionCompat, int i7) {
        this.f272a.f(mediaDescriptionCompat, i7);
    }

    public void c(int i7, int i8) {
        this.f272a.b(i7, i8);
    }

    public boolean d(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f272a.d(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle e() {
        return this.f272a.getExtras();
    }

    public long f() {
        return this.f272a.w();
    }

    public Object h() {
        return this.f272a.k();
    }

    public MediaMetadataCompat i() {
        return this.f272a.y();
    }

    public String j() {
        return this.f272a.J();
    }

    public g k() {
        return this.f272a.a();
    }

    public PlaybackStateCompat l() {
        return this.f272a.G();
    }

    public List<MediaSessionCompat.QueueItem> m() {
        return this.f272a.o0();
    }

    public CharSequence n() {
        return this.f272a.X();
    }

    public int o() {
        return this.f272a.P();
    }

    public int p() {
        return this.f272a.v0();
    }

    public PendingIntent q() {
        return this.f272a.i();
    }

    public MediaSessionCompat.Token r() {
        return this.f273b;
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP})
    public Bundle s() {
        return this.f273b.f();
    }

    public int t() {
        return this.f272a.l0();
    }

    public h u() {
        return this.f272a.j();
    }

    public boolean v() {
        return this.f272a.m0();
    }

    public boolean w() {
        return this.f272a.h();
    }

    public void x(@m0 a aVar) {
        y(aVar, null);
    }

    public void y(@m0 a aVar, Handler handler) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        aVar.o(handler);
        this.f272a.l(aVar, handler);
        this.f274c.add(aVar);
    }

    public void z(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f272a.N(mediaDescriptionCompat);
    }

    public MediaControllerCompat(Context context, @m0 MediaSessionCompat.Token token) throws RemoteException {
        if (token != null) {
            this.f273b = token;
            if (Build.VERSION.SDK_INT >= 24) {
                this.f272a = new e(context, token);
                return;
            } else {
                this.f272a = new d(context, token);
                return;
            }
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
