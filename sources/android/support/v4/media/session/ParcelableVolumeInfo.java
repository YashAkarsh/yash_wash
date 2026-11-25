package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f435e;

    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i7) {
            return new ParcelableVolumeInfo[i7];
        }
    }

    public ParcelableVolumeInfo(int i7, int i8, int i9, int i10, int i11) {
        this.f431a = i7;
        this.f432b = i8;
        this.f433c = i9;
        this.f434d = i10;
        this.f435e = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f431a);
        parcel.writeInt(this.f433c);
        parcel.writeInt(this.f434d);
        parcel.writeInt(this.f435e);
        parcel.writeInt(this.f432b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f431a = parcel.readInt();
        this.f433c = parcel.readInt();
        this.f434d = parcel.readInt();
        this.f435e = parcel.readInt();
        this.f432b = parcel.readInt();
    }
}
