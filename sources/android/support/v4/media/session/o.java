package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import c.t0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class o {

    static final class a {
        private a() {
        }

        public static String a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        public static Bundle b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        public static int c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static CharSequence d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static Object e(String str, CharSequence charSequence, int i7, Bundle bundle) {
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i7);
            builder.setExtras(bundle);
            return builder.build();
        }
    }

    private o() {
    }

    public static long a(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static List<Object> d(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static CharSequence e(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long f(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float g(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long h(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static int i(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object j(int i7, long j7, long j8, float f8, long j9, CharSequence charSequence, long j10, List<Object> list, long j11) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i7, j7, f8, j10);
        builder.setBufferedPosition(j8);
        builder.setActions(j9);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j11);
        return builder.build();
    }
}
