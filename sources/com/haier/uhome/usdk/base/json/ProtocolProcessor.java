package com.haier.uhome.usdk.base.json;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.json.notify.BluetoothStateChangedNotify;
import com.haier.uhome.usdk.base.json.req.DeviceGetProtocolTypeReq;
import com.haier.uhome.usdk.base.json.req.ModuleStartReq;
import com.haier.uhome.usdk.base.json.req.SetLogLevelReq;
import com.haier.uhome.usdk.base.json.resp.DeviceGetProtocolTypeResp;
import com.haier.uhome.usdk.base.json.resp.ModuleStartResp;
import com.haier.uhome.usdk.base.json.resp.SetLogLevelResp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProtocolProcessor {
    private static final Map<Class, Class> REQUEST_RESPONSE_MAPPING;
    private static final Object locker = new Object();
    private static final Map<String, Set<Class<? extends InComing>>> PROTOCOL_MAPPING = new ConcurrentHashMap();

    static {
        registerProtocol(ProtocolConst.RESP_MODULE_START, ModuleStartResp.class);
        registerProtocol(ProtocolConst.RESP_SET_LOG_LEVEL, SetLogLevelResp.class);
        registerProtocol(ProtocolConst.RESP_DEVICE_GET_PROTOCOL_TYPE, DeviceGetProtocolTypeResp.class);
        registerProtocol(ProtocolConst.NOTIFY_BLUETOOTH_STATE, BluetoothStateChangedNotify.class);
        REQUEST_RESPONSE_MAPPING = new ConcurrentHashMap();
        registerProtocolChecker(ModuleStartReq.class, ModuleStartResp.class);
        registerProtocolChecker(SetLogLevelReq.class, SetLogLevelResp.class);
        registerProtocolChecker(DeviceGetProtocolTypeReq.class, DeviceGetProtocolTypeResp.class);
    }

    public static BasicResp createResponseByErrorConst(Class<BasicResp> cls, ErrorConst errorConst) throws IllegalAccessException, InstantiationException {
        BasicResp basicResp = cls == null ? new BasicResp() : cls.newInstance();
        if (errorConst == null) {
            errorConst = ErrorConst.ERR_INTERNAL;
        }
        basicResp.setErrNo(errorConst.getErrorId());
        return basicResp;
    }

    public static String getProtocol(Class<? extends InComing> cls) {
        for (String str : PROTOCOL_MAPPING.keySet()) {
            Set<Class<? extends InComing>> set = PROTOCOL_MAPPING.get(str);
            if (set != null) {
                Iterator<Class<? extends InComing>> it = set.iterator();
                while (it.hasNext()) {
                    if (it.next() == cls) {
                        return str;
                    }
                }
            }
        }
        return null;
    }

    private static Set<Class<? extends InComing>> getProtocolSet(String str) {
        HashSet hashSet;
        Set<Class<? extends InComing>> set = PROTOCOL_MAPPING.get(str);
        if (set == null) {
            return null;
        }
        synchronized (locker) {
            hashSet = new HashSet(set);
        }
        return hashSet;
    }

    public static Class<BasicResp> getResponseClass(Class cls) {
        Class<BasicResp> cls2 = REQUEST_RESPONSE_MAPPING.get(cls);
        return cls2 == null ? BasicResp.class : cls2;
    }

    public static void handleInComing(InComing inComing) {
        if (inComing == null) {
            e3.a.h("parse inComing json failed,inComing is null", new Object[0]);
        } else {
            inComing.handle();
        }
    }

    public static List<InComing> parser(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        if (!itKeys.hasNext()) {
            return null;
        }
        String next = itKeys.next();
        String string = jSONObject.getString(next);
        Set<Class<? extends InComing>> protocolSet = getProtocolSet(next);
        ArrayList arrayList = new ArrayList();
        if (protocolSet != null) {
            Iterator<Class<? extends InComing>> it = protocolSet.iterator();
            while (it.hasNext()) {
                arrayList.add(com.haier.library.json.a.z(string, it.next()));
            }
        }
        return arrayList;
    }

    public static void registerProtocol(String str, Class<? extends InComing> cls) {
        Map<String, Set<Class<? extends InComing>>> map = PROTOCOL_MAPPING;
        Set<Class<? extends InComing>> hashSet = map.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(str, hashSet);
        }
        synchronized (locker) {
            hashSet.add(cls);
        }
    }

    public static void registerProtocolChecker(Class cls, Class cls2) {
        REQUEST_RESPONSE_MAPPING.put(cls, cls2);
    }
}
