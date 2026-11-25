package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import c.t0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(22)
class p {
    private p() {
    }

    public static Bundle a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }

    public static Object b(int i7, long j7, long j8, float f8, long j9, CharSequence charSequence, long j10, List<Object> list, long j11, Bundle bundle) {
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
        builder.setExtras(bundle);
        return builder.build();
    }
}
