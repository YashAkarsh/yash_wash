package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
    }

    @m0
    public static Context a(@m0 ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
