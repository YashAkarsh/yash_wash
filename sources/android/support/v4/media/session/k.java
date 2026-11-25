package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import c.t0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f528a = "MediaSessionCompatApi21";

    interface a {
        void g();

        void j();

        void k();

        void l();

        void m(String str, Bundle bundle, ResultReceiver resultReceiver);

        void n(long j7);

        void o(Object obj);

        void p();

        void q();

        boolean r(Intent intent);

        void s(Object obj, Bundle bundle);

        void t(String str, Bundle bundle);

        void u(String str, Bundle bundle);

        void v();

        void w(long j7);

        void x(String str, Bundle bundle);
    }

    static class b<T extends a> extends MediaSession.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f529a;

        public b(T t7) {
            this.f529a = t7;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.b(bundle);
            this.f529a.m(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            this.f529a.x(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.f529a.v();
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.f529a.r(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.f529a.j();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.f529a.p();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            this.f529a.u(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            this.f529a.t(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.f529a.l();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j7) {
            this.f529a.w(j7);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.f529a.o(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.f529a.k();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.f529a.q();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j7) {
            this.f529a.n(j7);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.f529a.g();
        }
    }

    static class c {
        private c() {
        }

        public static Object a(Object obj, long j7) {
            return new MediaSession.QueueItem((MediaDescription) obj, j7);
        }

        public static Object b(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long c(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }

    private k() {
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    public static Object b(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Parcelable c(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static boolean d(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj) != null;
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.w(f528a, "Failed to get mCallback object.");
        }
        return false;
    }

    public static boolean e(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void f(Object obj) {
        ((MediaSession) obj).release();
    }

    public static void g(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void h(Object obj, boolean z7) {
        ((MediaSession) obj).setActive(z7);
    }

    public static void i(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    public static void j(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    public static void k(Object obj, int i7) {
        ((MediaSession) obj).setFlags(i7);
    }

    public static void l(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void m(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void n(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void o(Object obj, int i7) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i7);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void p(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void q(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    public static void r(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void s(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static Object t(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object u(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
