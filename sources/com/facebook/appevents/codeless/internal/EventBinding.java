package com.facebook.appevents.codeless.internal;

import bolts.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventBinding {
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        String string = jSONObject.getString(o.f11382e);
        String string2 = jSONObject.getString("method");
        Locale locale = Locale.ENGLISH;
        MappingMethod mappingMethodValueOf = MappingMethod.valueOf(string2.toUpperCase(locale));
        ActionType actionTypeValueOf = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase(locale));
        String string3 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i7)));
        }
        String strOptString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                arrayList2.add(new ParameterComponent(jSONArrayOptJSONArray.getJSONObject(i8)));
            }
        }
        return new EventBinding(string, mappingMethodValueOf, actionTypeValueOf, string3, arrayList, arrayList2, jSONObject.optString("component_id"), strOptString, jSONObject.optString("activity_name"));
    }

    public static List<EventBinding> parseArray(JSONArray jSONArray) {
        int length;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (IllegalArgumentException | JSONException unused) {
            }
        } else {
            length = 0;
        }
        for (int i7 = 0; i7 < length; i7++) {
            arrayList.add(getInstanceFromJson(jSONArray.getJSONObject(i7)));
        }
        return arrayList;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getComponentId() {
        return this.componentId;
    }

    public String getEventName() {
        return this.eventName;
    }

    public MappingMethod getMethod() {
        return this.method;
    }

    public String getPathType() {
        return this.pathType;
    }

    public ActionType getType() {
        return this.type;
    }

    public List<ParameterComponent> getViewParameters() {
        return Collections.unmodifiableList(this.parameters);
    }

    public List<PathComponent> getViewPath() {
        return Collections.unmodifiableList(this.path);
    }
}
