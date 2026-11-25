package com.haier.uhome.config.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ConfigRouterInfo implements Parcelable {
    public static final Parcelable.Creator<ConfigRouterInfo> CREATOR = new Parcelable.Creator<ConfigRouterInfo>() { // from class: com.haier.uhome.config.entity.ConfigRouterInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConfigRouterInfo createFromParcel(Parcel parcel) {
            return new ConfigRouterInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConfigRouterInfo[] newArray(int i7) {
            return new ConfigRouterInfo[i7];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28472d;

    public ConfigRouterInfo() {
    }

    public boolean a() {
        return this.f28472d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Keep
    public String getBssid() {
        return this.f28470b;
    }

    @Keep
    public String getPassword() {
        return this.f28471c;
    }

    @Keep
    public String getSsid() {
        return this.f28469a;
    }

    public String toString() {
        return "ConfigRouterInfo{ssid='" + this.f28469a + "', bssid='" + this.f28470b + "', password='" + this.f28471c + "', isNeedSwitchNetwork=" + this.f28472d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f28469a);
        parcel.writeString(this.f28470b);
        parcel.writeString(this.f28471c);
        parcel.writeByte(this.f28472d ? (byte) 1 : (byte) 0);
    }

    public ConfigRouterInfo(String str, String str2, String str3, boolean z7) {
        this.f28469a = str;
        this.f28470b = str2;
        this.f28471c = str3;
        this.f28472d = z7;
    }

    protected ConfigRouterInfo(Parcel parcel) {
        this.f28469a = parcel.readString();
        this.f28470b = parcel.readString();
        this.f28471c = parcel.readString();
        this.f28472d = parcel.readByte() != 0;
    }
}
