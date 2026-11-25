package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(23)
class g {

    static class a {
        private a() {
        }

        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    private g() {
    }

    public static Uri a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
