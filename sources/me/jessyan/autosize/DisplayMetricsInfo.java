package me.jessyan.autosize;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayMetricsInfo implements Parcelable {
    public static final Parcelable.Creator<DisplayMetricsInfo> CREATOR = new Parcelable.Creator<DisplayMetricsInfo>() { // from class: me.jessyan.autosize.DisplayMetricsInfo.1
        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo createFromParcel(Parcel parcel) {
            return new DisplayMetricsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo[] newArray(int i7) {
            return new DisplayMetricsInfo[i7];
        }
    };
    private float density;
    private int densityDpi;
    private float scaledDensity;
    private int screenHeightDp;
    private int screenWidthDp;
    private float xdpi;

    public DisplayMetricsInfo(float f8, int i7, float f9, float f10) {
        this.density = f8;
        this.densityDpi = i7;
        this.scaledDensity = f9;
        this.xdpi = f10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDensity() {
        return this.density;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public int getScreenHeightDp() {
        return this.screenHeightDp;
    }

    public int getScreenWidthDp() {
        return this.screenWidthDp;
    }

    public float getXdpi() {
        return this.xdpi;
    }

    public void setDensity(float f8) {
        this.density = f8;
    }

    public void setDensityDpi(int i7) {
        this.densityDpi = i7;
    }

    public void setScaledDensity(float f8) {
        this.scaledDensity = f8;
    }

    public void setScreenHeightDp(int i7) {
        this.screenHeightDp = i7;
    }

    public void setScreenWidthDp(int i7) {
        this.screenWidthDp = i7;
    }

    public void setXdpi(float f8) {
        this.xdpi = f8;
    }

    public String toString() {
        return "DisplayMetricsInfo{density=" + this.density + ", densityDpi=" + this.densityDpi + ", scaledDensity=" + this.scaledDensity + ", xdpi=" + this.xdpi + ", screenWidthDp=" + this.screenWidthDp + ", screenHeightDp=" + this.screenHeightDp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeFloat(this.density);
        parcel.writeInt(this.densityDpi);
        parcel.writeFloat(this.scaledDensity);
        parcel.writeFloat(this.xdpi);
        parcel.writeInt(this.screenWidthDp);
        parcel.writeInt(this.screenHeightDp);
    }

    public DisplayMetricsInfo(float f8, int i7, float f9, float f10, int i8, int i9) {
        this.density = f8;
        this.densityDpi = i7;
        this.scaledDensity = f9;
        this.xdpi = f10;
        this.screenWidthDp = i8;
        this.screenHeightDp = i9;
    }

    protected DisplayMetricsInfo(Parcel parcel) {
        this.density = parcel.readFloat();
        this.densityDpi = parcel.readInt();
        this.scaledDensity = parcel.readFloat();
        this.xdpi = parcel.readFloat();
        this.screenWidthDp = parcel.readInt();
        this.screenHeightDp = parcel.readInt();
    }
}
