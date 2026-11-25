package com.haier.uhome.control.local.c;

import android.text.TextUtils;
import com.haier.uhome.control.local.b.e;
import com.haier.uhome.control.local.b.f;
import com.haier.uhome.usdk.base.api.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29368a = "UDISCOVERY_UWT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29369b = "e_";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29370c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29371d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f29372e = "eSDK_WIFI_AC";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f29373f = "e_2.7.01";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f29374g = "e_2.7.02";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f29375h = "e_2.6.30";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f29376i = "e_2.6.90";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f29377j = "uplug8710BNAC4.4.10_R_4.0.00_ota_e_2.6.90.bin";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f29378k = "uPlug8710BNGP4.5.0_R_4.0.00_ota_all_e_2.7.01.bin";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f29379l = "uPlug8710BNGP4.5.0_R_4.0.00_ota_all_e_2.7.02.bin";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f29380m = "uPlug8711AF_AC3.5.0_R_1.0.00_ota_e_2.6.30.bin";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f29381n = "uPlug8711AF_GP3.5.0_R_1.0.00_ota_e_2.6.30.bin";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List<String> f29382o = new ArrayList(20);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Map<String, e> f29383p = new HashMap(8);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Map<String, e> f29384q = new HashMap(2);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Map<String, e> f29385r = new HashMap(10);

    static {
        a();
        b();
        c();
        d();
    }

    private static void a() {
        List<String> list = f29382o;
        list.add("111c120024000810040100318001350000000000000000000000000000000000");
        list.add("111c120024000810040100318001350000000001000000000000000000000000");
        list.add("111c120024000810040100318001180000000000000000000000000000000000");
        list.add("111c120024000810040100318001180000000001000000000000000000000000");
        list.add("111c120024000810040100318001450000000000000000000000000000000000");
        list.add("111c120024000810040100318000990000000001000000000000000000000000");
        list.add("111c120024000810040100318000990000000000000000000000000000000000");
        list.add("111c120024000810040100318000994500000000000000000000000000000000");
        list.add("111c120024000810040100318000994500000001000000000000000000000000");
        list.add("111c120024000810040100318001380000000000000000000000000000000000");
        list.add("111c120024000810050101818000284100000000000000000000000000000000");
        list.add("201c80c70c50031c1102e4b10d06924de1158d66e6e5b852931d670f6c0b1740");
        list.add("2054a00039044b142105b777deda920000003547291855cb3b68db04e6cb6740");
        list.add("2054a0d610c6d21034012579020e18000000536ac509026f6264c86537688840");
        list.add("111c1200240008100d8101504018000000000000000000000000000000000000");
        list.add("111c1200240008100d8101504018004300000000000000000000000000000000");
        list.add("111c1200240008100d8101504018004400000000000000000000000000000000");
        list.add("111c1200240008100d8101504018004500000000000000000000000000000000");
        list.add("201c1200240008100d12f71c4094f300000080e384181627a2904f4940b24240");
        list.add("01c12002400081034080000000100000");
    }

    private static void b() {
        e eVar = new e(f29376i, f29377j);
        e eVar2 = new e(f29375h, f29380m);
        Map<String, e> map = f29383p;
        map.put("R_4.0.00e_2.5.11", eVar);
        map.put("R_4.0.00e_2.6.01", eVar);
        map.put("R_4.0.00e_2.6.10", eVar);
        map.put("R_4.0.00e_2.6.21", eVar);
        map.put("R_1.0.00e_2.3.21", eVar2);
        map.put("R_1.0.00e_2.5.01", eVar2);
        map.put("R_1.0.00e_2.5.11", eVar2);
        map.put("R_1.0.00e_2.5.13", eVar2);
    }

    private static void c() {
        e eVar = new e(f29374g, f29379l);
        Map<String, e> map = f29384q;
        map.put("R_4.0.00e_2.6.00", eVar);
        map.put("R_4.0.00e_2.6.12", eVar);
    }

    private static void d() {
        e eVar = new e(f29373f, f29378k);
        e eVar2 = new e(f29375h, f29381n);
        Map<String, e> map = f29385r;
        map.put("R_4.0.00e_2.5.12", eVar);
        map.put("R_4.0.00e_2.6.00", eVar);
        map.put("R_4.0.00e_2.6.12", eVar);
        map.put("R_4.0.00e_2.7.00", eVar);
        map.put("R_1.0.00e_2.3.12", eVar2);
        map.put("R_1.0.00e_2.3.31", eVar2);
        map.put("R_1.0.00e_2.3.32", eVar2);
        map.put("R_1.0.00e_2.3.40", eVar2);
        map.put("R_1.0.00e_2.6.00", eVar2);
        map.put("R_1.0.00e_2.6.01", eVar2);
    }

    public static f a(String str, h hVar, String str2, String str3, String str4) {
        e eVar;
        e3.a.e("[ota] checkUpgradeState : verHard = " + str2 + ", verSoft = " + str3 + ", type = " + hVar + ", softwareType = " + str4, new Object[0]);
        if (!TextUtils.isEmpty(str2) && str2.length() >= 3) {
            if (str3 != null && str3.length() >= 6) {
                if (!str3.startsWith(f29369b)) {
                    str3 = f29369b.concat(str3);
                }
                if (!f29368a.equals(str4) && !f29372e.equals(str4)) {
                    e3.a.h("softwareType:" + str4, new Object[0]);
                    return new f();
                }
                if (f29382o.contains(str)) {
                    e3.a.e("uplusID in EXCLUDE_LIST excluded uplusID = %s", str);
                    return new f();
                }
                if (hVar != h.DRYER && hVar != h.DRYER_DEVICE && hVar != h.DISH_WASHING_MACHINE) {
                    if (hVar != h.SPLIT_AIRCONDITION && hVar != h.PACKAGE_AIRCONDITION && hVar != h.COMMERCIAL_AIRCONDITION && hVar != h.WINDOW_AIR_CONDITIONER) {
                        if (hVar != h.PULSATOR_WASHING_MACHINE && hVar != h.DRUM_WASHING_MACHINE && hVar != h.SHOE_WASHER) {
                            eVar = f29385r.get(str2.concat(str3));
                        } else {
                            eVar = f29384q.get(str2.concat(str3));
                        }
                    } else {
                        eVar = f29383p.get(str2.concat(str3));
                    }
                    if (eVar != null) {
                        return new f(eVar);
                    }
                    return new f();
                }
                e3.a.e("ota check: dryer or dish_washing_machine not match!", new Object[0]);
                return new f();
            }
            e3.a.h("verSoft:" + str3, new Object[0]);
            return new f();
        }
        e3.a.h("verHardware:" + str2, new Object[0]);
        return new f();
    }
}
