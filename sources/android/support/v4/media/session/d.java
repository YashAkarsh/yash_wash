package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(23)
class d {

    public static class a {
        private a() {
        }

        public static void a(Object obj, Uri uri, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromUri(uri, bundle);
        }
    }

    private d() {
    }
}
