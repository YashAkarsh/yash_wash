package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ResolveAccountRequestCreator")
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new a1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAccount", id = 2)
    private final Account f15828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getSessionId", id = 3)
    private final int f15829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getSignInAccountHint", id = 4)
    private final GoogleSignInAccount f15830d;

    @SafeParcelable.b
    zat(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) Account account, @SafeParcelable.e(id = 3) int i8, @c.o0 @SafeParcelable.e(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f15827a = i7;
        this.f15828b = account;
        this.f15829c = i8;
        this.f15830d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15827a);
        e1.b.S(parcel, 2, this.f15828b, i7, false);
        e1.b.F(parcel, 3, this.f15829c);
        e1.b.S(parcel, 4, this.f15830d, i7, false);
        e1.b.b(parcel, iA);
    }

    public zat(Account account, int i7, @c.o0 GoogleSignInAccount googleSignInAccount) {
        this(2, account, i7, googleSignInAccount);
    }
}
