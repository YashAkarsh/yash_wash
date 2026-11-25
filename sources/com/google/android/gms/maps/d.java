package com.google.android.gms.maps;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public interface a {
        void onLocationChanged(@c.m0 Location location);
    }

    void a(@c.m0 a aVar);

    void deactivate();
}
