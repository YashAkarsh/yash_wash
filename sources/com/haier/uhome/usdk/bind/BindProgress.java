package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public enum BindProgress {
    CONNECT_DEVICE("连接设备"),
    SEND_CONFIG_INFO("发送配置信息"),
    VERIFICATION("开始校验"),
    BIND_DEVICE("绑定设备"),
    START_NETWORKING_MODE("开始进入组网模式"),
    START_NETWORKING("开始组网"),
    START_BIND_SLAVE_DEVICE("开始绑定子机");

    private String mStateDescription;

    BindProgress(String str) {
        this.mStateDescription = str;
    }

    public String getStateDescription() {
        return this.mStateDescription;
    }
}
