package com.google.android.gms.maps.model;

import android.os.RemoteException;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
final class h0 implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.k f16692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TileOverlayOptions f16693c;

    h0(TileOverlayOptions tileOverlayOptions) {
        this.f16693c = tileOverlayOptions;
        this.f16692b = tileOverlayOptions.f16660a;
    }

    @Override // com.google.android.gms.maps.model.m
    @o0
    public final Tile a(int i7, int i8, int i9) {
        try {
            return this.f16692b.G4(i7, i8, i9);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
