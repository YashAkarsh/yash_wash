package com.haier.uhome.usdk.base.api;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    ALL_TYPE(-1, "所有", "ALL"),
    FRIDGE(1, "冰箱", "RFR"),
    SPLIT_AIRCONDITION(2, "分体空调", "AC"),
    PACKAGE_AIRCONDITION(3, "柜机空调", "AC"),
    PULSATOR_WASHING_MACHINE(4, "波轮洗衣机", "WM"),
    DRUM_WASHING_MACHINE(5, "滚筒洗衣机", "WM"),
    WATER_HEATER(6, "电热水器", "EWH"),
    MICRO_WAVE_OVEN(7, "微波炉", "MWO"),
    WINE_CABINET(8, "酒柜", "CELL"),
    RANGE_HOOD(9, "烟机", "RH"),
    DISH_WASHING_MACHINE(10, "洗碗机", "DW"),
    DISINFECTION_CABINET(11, "消毒柜", "DTC"),
    RESERVE(12, "保留", "RESERVE"),
    COMMERCIAL_AIRCONDITION(13, "商用空调", "BAC"),
    TV(14, "电视", "TV"),
    HOME_ENTERTAINMENT_EQUIPMENT(15, "影音娱乐", "ETM"),
    LIGHTING(16, "灯光照明", "LIGHT"),
    SECURITY_EQUIPMENT(17, "安防报警", "SECU"),
    VIDEO_SURVEILLANCE(18, "视频监控", "VM"),
    SENSOR(19, "传感器", "SEN"),
    SMART_HOME(20, "智能家居", "SH"),
    MEDICAL_CARE(21, "医疗健康", "HC"),
    REFRIDGERATOR(22, "冷柜", "IC"),
    MEDICAL_CABINET(23, "医用柜", "MED"),
    GAS_WATER_HEATER(24, "燃气热水器", "GWH"),
    HEATING_FURNACE(25, "采暖炉", "BWH"),
    STEAM_BOX(26, "蒸箱", "SO"),
    COFFEE_MAKER(27, "咖啡机", "CM"),
    WATER_MACHINE(28, "饮水机", "WD"),
    COOKING(29, "灶具", "CU"),
    OVEN(30, "烤箱", "OV"),
    SOLAR_WATER_HEATER(31, "太阳能", "SWH"),
    HEAT_PUMP(32, "热泵", "HWH"),
    AIR_CONDITIONING_DEVICE(33, "空气调节设备", "ACD"),
    AIR_PURIFIER(33, "空气净化设备", "AIC"),
    WATER_TREATMENT_DEVICE(34, "水处理设备", "WTD"),
    WATER_PURIFIER(34, "净水机", "WP"),
    KETTLE(35, "水壶", "KT"),
    NEW_WIND_DEVICE(36, "新风设备", "FAS"),
    FLOOR_HEATING_DEVICE(37, "采暖配套设备", "UHS"),
    PUBLIC_SERVICE(38, "公共服务类", "PUB"),
    DUST_PROOF(39, "吸尘器", "VCL"),
    KITCHEN_APPLIANCE(40, "小家电", "SHA"),
    ENV_MONITOR(41, "环境监测设备", "HEM"),
    CABINET(42, "衣柜鞋柜", "CAB"),
    SHOE_WASHER(43, "洗鞋机", "WM"),
    GATEWAY(48, "网关", "GTW"),
    DRYER_DEVICE(49, "干衣机", "WM"),
    DRYER(49, "干衣机", "DRY"),
    WEARABLE_DEVICE(50, "可穿戴设备", "WEAR"),
    AIR_CUBE(51, "空气魔方", "ACB"),
    AIR_HEATER(52, "浴室环境调节设备", "EHD"),
    OTHER_DEVICE(53, "其他", "OTHER"),
    PERSONAL_CLEANER(54, "个人护理类", "PC"),
    ELECTRIC_FAN(55, "电风扇", "FAN"),
    FITNESS_EQUIPMENT(56, "健身器材", "FIT"),
    WINDOW_AIR_CONDITIONER(57, "窗机空调", "WAC"),
    ICE_BAR(58, "冰吧", "IBAR"),
    SMART_SPEAKER(59, "智能音箱", "SPK"),
    KITCHEN_WATER_HEATER(60, "厨宝", "KWH"),
    SHOWER(61, "花洒", "SHWR"),
    INTEGRATED_OVEN_STEAM_BOX(62, "蒸烤一体设备", "OVSO"),
    INTEGRATED_OVEN_AND_STEAM_BOX(62, "蒸烤一体设备", "OV"),
    INTEGRATED_STOVE_DEVICE(63, "集成灶", "INCU"),
    INTEGRATED_STOVE(63, "集成灶", "CU"),
    ELECTRIC_HEATING(65, "电暖气", "HEAT"),
    ROBOT(161, "机器人", "RBT"),
    ROUTING_MODULE(225, "路由模块", "RU"),
    SMART_ROUTER(226, "路由器", com.haier.uhome.control.base.b.a.f28848b),
    CONTROL_TERMINAL(241, "控制终端", "CT"),
    UNKNOWN(0, "未知", "XX");

    private static HashMap<Integer, h> aw = new HashMap<>();
    private final int at;
    private final String au;
    private final String av;

    static {
        for (h hVar : values()) {
            aw.put(Integer.valueOf(hVar.at), hVar);
        }
    }

    h(int i7, String str, String str2) {
        this.at = i7;
        this.au = str;
        this.av = str2;
    }

    public String a() {
        return this.au;
    }

    public int b() {
        return this.at;
    }

    public String c() {
        return this.av;
    }

    public static h a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    public static h b(String str) {
        h hVar = UNKNOWN;
        if (TextUtils.isEmpty(str)) {
            return hVar;
        }
        String upperCase = str.toUpperCase();
        for (h hVar2 : values()) {
            if (hVar2.av.equals(upperCase)) {
                return hVar2;
            }
        }
        return hVar;
    }

    public static h a(int i7) {
        h hVar = aw.get(Integer.valueOf(i7));
        return hVar == null ? UNKNOWN : hVar;
    }
}
