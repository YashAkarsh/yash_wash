package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.control.base.handler.c;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleAdvEppNotify extends BasicNotify {

    @b(name = "bleDevId")
    private String mBleDevId;

    @b(name = "companyId")
    private String mCompanyId;

    @b(name = "devId")
    private String mDevId;

    @b(name = "isDupAdv")
    private int mDupAdv;

    @b(name = "eppType")
    private int mEppType;

    @b(name = "eppValue")
    private List<KeyValueItem> mEppValue;

    @b(name = "longProductCode")
    private String mLongProductCode;

    @b(name = "module")
    private String mModule;

    @b(name = "name")
    private String mName;

    @b(name = "protVers")
    private int mProtVers;

    @b(name = "protocol")
    private String mProtocol;

    @b(name = "uniqueId")
    private long mUniqueId;

    @b(name = "uplusId")
    private String mUplusId;

    public String getBleDevId() {
        return this.mBleDevId;
    }

    public String getCompanyId() {
        return this.mCompanyId;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public int getDupAdv() {
        return this.mDupAdv;
    }

    public int getEppType() {
        return this.mEppType;
    }

    public List<KeyValueItem> getEppValue() {
        return this.mEppValue;
    }

    public String getLongProductCode() {
        return this.mLongProductCode;
    }

    public String getModule() {
        return this.mModule;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new c();
    }

    public int getProtVers() {
        return this.mProtVers;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public long getUniqueId() {
        return this.mUniqueId;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public void setBleDevId(String str) {
        this.mBleDevId = str;
    }

    public void setCompanyId(String str) {
        this.mCompanyId = str;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setDupAdv(int i7) {
        this.mDupAdv = i7;
    }

    public void setEppType(int i7) {
        this.mEppType = i7;
    }

    public void setEppValue(List<KeyValueItem> list) {
        this.mEppValue = list;
    }

    public void setLongProductCode(String str) {
        this.mLongProductCode = str;
    }

    public void setModule(String str) {
        this.mModule = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setProtVers(int i7) {
        this.mProtVers = i7;
    }

    public void setProtocol(String str) {
        this.mProtocol = str;
    }

    public void setUniqueId(long j7) {
        this.mUniqueId = j7;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBleAdvEppNotify{mModule=" + this.mModule + ", mName=" + this.mName + ", mDevId=" + this.mDevId + ", mLongProductCode=" + this.mLongProductCode + ", mEppType=" + this.mEppType + ", mEppValue=" + this.mEppValue + "} ";
    }
}
