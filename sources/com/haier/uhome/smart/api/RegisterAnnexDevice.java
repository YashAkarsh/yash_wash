package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterAnnexDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterAnnexDevice build() {
            return new RegisterAnnexDevice(this);
        }
    }

    public RegisterAnnexDevice(Builder builder) {
        super(builder);
    }
}
