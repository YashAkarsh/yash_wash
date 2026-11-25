package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterSlaveDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterSlaveDevice build() {
            return new RegisterSlaveDevice(this);
        }
    }

    public RegisterSlaveDevice(Builder builder) {
        super(builder);
    }
}
