package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class uSDKStartOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f30964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f30965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f30966e;

    @Keep
    public static class Builder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f30970d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f30968b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30967a = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f30971e = true;

        @Keep
        public uSDKStartOptions build() {
            uSDKStartOptions usdkstartoptions = new uSDKStartOptions();
            usdkstartoptions.f30962a = this.f30967a;
            usdkstartoptions.f30963b = this.f30968b;
            usdkstartoptions.f30964c = this.f30969c;
            usdkstartoptions.f30965d = this.f30970d;
            usdkstartoptions.f30966e = this.f30971e;
            return usdkstartoptions;
        }

        @Keep
        public Builder isBleSearchControllableDevice(boolean z7) {
            this.f30971e = z7;
            return this;
        }

        @Keep
        public Builder setAppID(String str) {
            this.f30969c = str;
            return this;
        }

        @Keep
        public Builder setAppKey(String str) {
            this.f30970d = str;
            return this;
        }

        @Keep
        public Builder setArea(int i7) {
            this.f30967a = i7;
            return this;
        }

        @Keep
        public Builder setFeatures(int i7) {
            this.f30968b = i7;
            return this;
        }
    }

    public String c() {
        return this.f30964c;
    }

    public String d() {
        return this.f30965d;
    }

    public boolean e() {
        return this.f30966e;
    }

    public String toString() {
        return "uSDKStartOptions{area=" + this.f30962a + ", features=" + this.f30963b + ", appID='" + this.f30964c + "', appKey='" + this.f30965d + "', isBleSearchControllableDevice=" + this.f30966e + '}';
    }

    public int b() {
        return this.f30963b;
    }

    public int a() {
        return this.f30962a;
    }
}
