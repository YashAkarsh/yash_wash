package com.haier.uhome.account.model.geamodel;

import g3.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GEAModule {

    @b(name = "moduleId")
    private String moduleId;

    @b(name = "moduleInfos")
    private Map<String, String> moduleInfos;

    @b(name = "moduleType")
    private String moduleType;

    public String getModuleId() {
        return this.moduleId;
    }

    public Map<String, String> getModuleInfos() {
        return this.moduleInfos;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    public void setModuleId(String str) {
        this.moduleId = str;
    }

    public void setModuleInfos(Map<String, String> map) {
        this.moduleInfos = map;
    }

    public void setModuleType(String str) {
        this.moduleType = str;
    }
}
