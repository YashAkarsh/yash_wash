package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.common.m implements c {
        public a() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @m0
        public static c u0(@m0 IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new r(iBinder);
        }

        @Override // com.google.android.gms.internal.common.m
        protected final boolean i0(int i7, @m0 Parcel parcel, @m0 Parcel parcel2, int i8) throws RemoteException {
            switch (i7) {
                case 2:
                    d dVarB = b();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.e(parcel2, dVarB);
                    return true;
                case 3:
                    Bundle bundleA = a();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.d(parcel2, bundleA);
                    return true;
                case 4:
                    int iE = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(iE);
                    return true;
                case 5:
                    c cVarC = c();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.e(parcel2, cVarC);
                    return true;
                case 6:
                    d dVarH = h();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.e(parcel2, dVarH);
                    return true;
                case 7:
                    boolean zD5 = D5();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zD5);
                    return true;
                case 8:
                    String strL = l();
                    parcel2.writeNoException();
                    parcel2.writeString(strL);
                    return true;
                case 9:
                    c cVarD = d();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.e(parcel2, cVarD);
                    return true;
                case 10:
                    int iT = t();
                    parcel2.writeNoException();
                    parcel2.writeInt(iT);
                    return true;
                case 11:
                    boolean zS6 = s6();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zS6);
                    return true;
                case 12:
                    d dVarF = f();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.e(parcel2, dVarF);
                    return true;
                case 13:
                    boolean zB4 = B4();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zB4);
                    return true;
                case 14:
                    boolean zV4 = V4();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zV4);
                    return true;
                case 15:
                    boolean zH2 = H2();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zH2);
                    return true;
                case 16:
                    boolean zB3 = B3();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zB3);
                    return true;
                case 17:
                    boolean zT0 = T0();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zT0);
                    return true;
                case 18:
                    boolean zQ = Q();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zQ);
                    return true;
                case 19:
                    boolean zK = K();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.n.b(parcel2, zK);
                    return true;
                case 20:
                    q4(d.a.u0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    L(com.google.android.gms.internal.common.n.f(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    g1(com.google.android.gms.internal.common.n.f(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    W1(com.google.android.gms.internal.common.n.f(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    J5(com.google.android.gms.internal.common.n.f(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    x2((Intent) com.google.android.gms.internal.common.n.a(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    I2((Intent) com.google.android.gms.internal.common.n.a(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    L4(d.a.u0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean B3() throws RemoteException;

    boolean B4() throws RemoteException;

    boolean D5() throws RemoteException;

    boolean H2() throws RemoteException;

    void I2(@m0 Intent intent, int i7) throws RemoteException;

    void J5(boolean z7) throws RemoteException;

    boolean K() throws RemoteException;

    void L(boolean z7) throws RemoteException;

    void L4(@m0 d dVar) throws RemoteException;

    boolean Q() throws RemoteException;

    boolean T0() throws RemoteException;

    boolean V4() throws RemoteException;

    void W1(boolean z7) throws RemoteException;

    @o0
    Bundle a() throws RemoteException;

    @m0
    d b() throws RemoteException;

    @o0
    c c() throws RemoteException;

    @o0
    c d() throws RemoteException;

    int e() throws RemoteException;

    @m0
    d f() throws RemoteException;

    void g1(boolean z7) throws RemoteException;

    @m0
    d h() throws RemoteException;

    @o0
    String l() throws RemoteException;

    void q4(@m0 d dVar) throws RemoteException;

    boolean s6() throws RemoteException;

    int t() throws RemoteException;

    void x2(@m0 Intent intent) throws RemoteException;
}
