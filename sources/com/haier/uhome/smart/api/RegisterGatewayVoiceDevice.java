package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterGatewayVoiceDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterGatewayVoiceDevice build() {
            return new RegisterGatewayVoiceDevice(this);
        }
    }

    public RegisterGatewayVoiceDevice(Builder builder) {
        super(builder);
    }
}
