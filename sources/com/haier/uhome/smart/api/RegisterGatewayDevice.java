package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterGatewayDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterGatewayDevice build() {
            return new RegisterGatewayDevice(this);
        }
    }

    public RegisterGatewayDevice(Builder builder) {
        super(builder);
    }
}
