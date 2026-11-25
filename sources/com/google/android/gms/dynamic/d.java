package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public interface d extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.common.m implements d {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @m0
        public static d u0(@m0 IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof d ? (d) iInterfaceQueryLocalInterface : new s(iBinder);
        }
    }
}
