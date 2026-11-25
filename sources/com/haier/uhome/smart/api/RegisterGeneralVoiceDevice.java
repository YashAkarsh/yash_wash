package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterGeneralVoiceDevice extends AbsRegisterDevice {

    public static class Builder extends AbsRegisterDevice.Builder<Builder> {
        public RegisterGeneralVoiceDevice build() {
            return new RegisterGeneralVoiceDevice(this);
        }
    }

    public RegisterGeneralVoiceDevice(Builder builder) {
        super(builder);
    }
}
