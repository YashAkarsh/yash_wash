package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterGeneralDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterGeneralDevice build() {
            return new RegisterGeneralDevice(this);
        }
    }

    public RegisterGeneralDevice(Builder builder) {
        super(builder);
    }
}
