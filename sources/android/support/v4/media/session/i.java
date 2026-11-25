package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(24)
class i {

    public static class a {
        private a() {
        }

        public static void a(Object obj) {
            ((MediaController.TransportControls) obj).prepare();
        }

        public static void b(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromMediaId(str, bundle);
        }

        public static void c(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromSearch(str, bundle);
        }

        public static void d(Object obj, Uri uri, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromUri(uri, bundle);
        }
    }

    private i() {
    }
}
