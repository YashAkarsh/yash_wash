package com.alibaba.android.arouter.facade.enums;

import com.alibaba.android.arouter.compiler.utils.a;

/* JADX INFO: loaded from: classes.dex */
public enum RouteType {
    ACTIVITY(0, a.f12420n),
    SERVICE(1, a.f12423q),
    PROVIDER(2, a.G),
    CONTENT_PROVIDER(-1, "android.app.ContentProvider"),
    BOARDCAST(-1, ""),
    METHOD(-1, ""),
    FRAGMENT(-1, a.f12421o),
    UNKNOWN(-1, "Unknown route type");

    String className;
    int id;

    RouteType(int i7, String str) {
        this.id = i7;
        this.className = str;
    }

    public static RouteType parse(String str) {
        for (RouteType routeType : values()) {
            if (routeType.getClassName().equals(str)) {
                return routeType;
            }
        }
        return UNKNOWN;
    }

    public String getClassName() {
        return this.className;
    }

    public int getId() {
        return this.id;
    }

    public RouteType setClassName(String str) {
        this.className = str;
        return this;
    }

    public RouteType setId(int i7) {
        this.id = i7;
        return this;
    }
}
