package android.support.v4.media;

import android.media.browse.MediaBrowser;
import c.t0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Constructor f263a;

    static {
        try {
            f263a = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            e8.printStackTrace();
        }
    }

    private i() {
    }

    static Object a(List<MediaBrowser.MediaItem> list) {
        try {
            return f263a.newInstance(list);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e8) {
            e8.printStackTrace();
            return null;
        }
    }
}
