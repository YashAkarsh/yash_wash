package com.haier.uhome.search.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleEventNotify extends BasicNotify {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "buf")
    private String buf;

    @b(name = "bufSize")
    private int bufSize;

    @b(name = "devId")
    private String devId;

    @b(name = "flags")
    private String flags;

    @b(name = "name")
    private String name;

    @b(name = "protVers")
    private String protVers;

    @b(name = "protocol")
    private String protocol;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    @b(name = "stateCode")
    private int stateCode;

    @b(name = "type")
    private int type;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getBuf() {
        return this.buf;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getFlags() {
        return this.flags;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.search.b.b();
    }

    public String getProtVers() {
        return this.protVers;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public int getState() {
        return this.state;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public int getType() {
        return this.type;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setBuf(String str) {
        this.buf = str;
    }

    public void setBufSize(int i7) {
        this.bufSize = i7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFlags(String str) {
        this.flags = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProtVers(String str) {
        this.protVers = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    public void setType(int i7) {
        this.type = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBleEventNotify{name='" + this.name + "', type=" + this.type + ", devId='" + this.devId + "', bleDevId='" + this.bleDevId + "', flags='" + this.flags + "', protocol='" + this.protocol + "', protVers='" + this.protVers + "', state=" + this.state + ", stateCode=" + this.stateCode + ", buf='" + this.buf + "', bufSize=" + this.bufSize + '}';
    }
}
