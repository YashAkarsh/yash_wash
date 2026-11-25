package com.haier.uhome.smart;

/* JADX INFO: loaded from: classes2.dex */
public class ConstSmartDevice {
    public static final int DEVICE_VERSION_MAXLENGTH = 16;
    public static final String REGEX_FULL_DEV_ID = "[A-Z0-9]{1,32}";
    public static final String REGEX_MAC = "[A-F0-9]{12}";
    public static final String REGEX_SUB_AUTH_DEV_ID = "[A-Z0-9]{12}";
    public static final String REGEX_SUB_DEV_ID = "[A-Z0-9]{1,12}";
    public static final String REGEX_UPLUSID = "^([0]\\S{31})|([1-2]\\S{63})$";
    public static final int TIMEOUT_DEFAULT_BINDING = 60;
    public static final int TIMEOUT_DEFAULT_QRCODE = 30;
    public static final int TIMEOUT_MAX_BINDING = 120;
    public static final int TIMEOUT_MAX_QRCODE = 120;
    public static final int TIMEOUT_MIN_BINDING = 20;
    public static final int TIMEOUT_MIN_QRCODE = 10;
}
