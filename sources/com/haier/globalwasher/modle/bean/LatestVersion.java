package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LatestVersion implements Serializable {
    String downloadURL;
    String isMandatory;
    String versionNumber;

    @Deprecated
    public String getDownloadURL() {
        return this.downloadURL;
    }

    public String getIsMandatory() {
        return this.isMandatory;
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }

    public void setIsMandatory(String str) {
        this.isMandatory = str;
    }

    public void setVersionNumber(String str) {
        this.versionNumber = str;
    }
}
