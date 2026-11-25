package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum f {
    COMMAND_0000(0, 0, "无效命令"),
    COMMAND_0001(0, 1, "程序未选定，不能启动"),
    COMMAND_0002(0, 2, "程序运行后不能设置"),
    COMMAND_0003(0, 3, "未开机不能进行设置"),
    COMMAND_0004(0, 4, "启动状态下不能设置"),
    COMMAND_0005(0, 5, "所设参数超出程序允许范围"),
    COMMAND_0006(0, 6, "该程序下此功能不可选"),
    COMMAND_0007(0, 7, "该程序下此参数不可调"),
    COMMAND_0008(0, 8, "该模式下此程序不可选 童锁状态，请先解锁"),
    COMMAND_0009(0, 9, "童锁状态，请先解锁"),
    COMMAND_000a(0, 10, "最后一次漂洗进行中，不能再设定漂洗次数"),
    COMMAND_000b(0, 11, "此过程已结束，不能设置"),
    COMMAND_000c(0, 12, "此程序下不能设置衣物重量"),
    COMMAND_000d(0, 13, "程序未结束不能设置或已设置过"),
    COMMAND_000e(0, 14, "设定参数错误"),
    COMMAND_000f(0, 15, "远程控制功能未激活，无法控制"),
    COMMAND_0010(0, 16, "门被打开，远程控制功能失效，请等待激活后再进行控制"),
    COMMAND_0011(0, 17, "筒内温度过高, 不能启动");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32348b;

    f(int i7, int i8, String str) {
        this.f32347a = i8;
        this.f32348b = str;
    }

    public static String b(int i7) {
        for (f fVar : values()) {
            if (fVar.f32347a == i7) {
                return fVar.f32348b;
            }
        }
        return "蓝牙返回未知信息";
    }
}
