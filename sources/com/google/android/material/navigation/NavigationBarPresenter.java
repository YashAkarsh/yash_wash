package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.s;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class NavigationBarPresenter implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f17951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavigationBarMenuView f17952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17953c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17954d;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        ParcelableSparseArray f17956b;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            parcel.writeInt(this.f17955a);
            parcel.writeParcelable(this.f17956b, 0);
        }

        SavedState(@m0 Parcel parcel) {
            this.f17955a = parcel.readInt();
            this.f17956b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public int a() {
        return this.f17954d;
    }

    public void b(int i7) {
        this.f17954d = i7;
    }

    public void c(@m0 NavigationBarMenuView navigationBarMenuView) {
        this.f17952b = navigationBarMenuView;
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(@o0 g gVar, boolean z7) {
    }

    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        if (this.f17953c) {
            return;
        }
        if (z7) {
            this.f17952b.c();
        } else {
            this.f17952b.o();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean g(@o0 g gVar, @o0 j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean h(@o0 g gVar, @o0 j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(@o0 n.a aVar) {
    }

    @Override // androidx.appcompat.view.menu.n
    public void j(@m0 Context context, @m0 g gVar) {
        this.f17951a = gVar;
        this.f17952b.e(gVar);
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(@m0 Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f17952b.n(savedState.f17955a);
            this.f17952b.setBadgeDrawables(com.google.android.material.badge.a.e(this.f17952b.getContext(), savedState.f17956b));
        }
    }

    public void l(boolean z7) {
        this.f17953c = z7;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean m(@o0 s sVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    @o0
    public o n(@o0 ViewGroup viewGroup) {
        return this.f17952b;
    }

    @Override // androidx.appcompat.view.menu.n
    @m0
    public Parcelable o() {
        SavedState savedState = new SavedState();
        savedState.f17955a = this.f17952b.getSelectedItemId();
        savedState.f17956b = com.google.android.material.badge.a.f(this.f17952b.getBadgeDrawables());
        return savedState;
    }
}
