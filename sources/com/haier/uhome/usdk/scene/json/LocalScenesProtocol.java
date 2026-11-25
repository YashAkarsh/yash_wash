package com.haier.uhome.usdk.scene.json;

import com.haier.library.json.a;
import com.haier.uhome.usdk.scene.json.up.BaseUp;
import com.haier.uhome.usdk.scene.json.up.DeviceAttrReq;
import com.haier.uhome.usdk.scene.json.up.SceneExecuteReq;
import com.haier.uhome.usdk.scene.json.up.SceneSubscribeReq;
import com.haier.uhome.usdk.scene.json.up.SceneUnsubscribeReq;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LocalScenesProtocol {
    private static final Map<String, Class<? extends BaseUp>> PROTOCOL_MAPPING;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        PROTOCOL_MAPPING = concurrentHashMap;
        concurrentHashMap.put(ProtocolConst.UP_DEVICE_ATTR, DeviceAttrReq.class);
        concurrentHashMap.put(ProtocolConst.UP_SCENE_EXECUTE, SceneExecuteReq.class);
        concurrentHashMap.put(ProtocolConst.UP_SCENE_SUBSCRIBE_REQ, SceneSubscribeReq.class);
        concurrentHashMap.put(ProtocolConst.UP_SCENE_UNSUBSCRIBE_REQ, SceneUnsubscribeReq.class);
    }

    public static BaseUp getBaseUp(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        if (itKeys.hasNext()) {
            String next = itKeys.next();
            String string = jSONObject.getString(next);
            Class<? extends BaseUp> cls = PROTOCOL_MAPPING.get(next);
            if (cls != null) {
                return (BaseUp) a.z(string, cls);
            }
        }
        return null;
    }
}
