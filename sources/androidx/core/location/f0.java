package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface f0 extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i7);

    @Override // android.location.LocationListener
    void onLocationChanged(@c.m0 List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(@c.m0 String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@c.m0 String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@c.m0 String str, int i7, @c.o0 Bundle bundle);
}
