package com.haier.uhome.config.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigResult {

    @g3.b(name = "configMode")
    private int configMode;

    @g3.b(name = "lastErr")
    private int lastErr;

    @g3.b(name = "lastMatch")
    private int lastMatch;

    public ConfigResult() {
        this(0, 0, 0);
    }

    public static ConfigResult createDefault() {
        return new ConfigResult(0, 0, 0);
    }

    public int getConfigMode() {
        return this.configMode;
    }

    public int getLastErr() {
        return this.lastErr;
    }

    public int getLastMatch() {
        return this.lastMatch;
    }

    public void setConfigMode(int i7) {
        this.configMode = i7;
    }

    public void setLastErr(int i7) {
        this.lastErr = i7;
    }

    public void setLastMatch(int i7) {
        this.lastMatch = i7;
    }

    public ConfigResult(int i7, int i8, int i9) {
        this.configMode = i7;
        this.lastMatch = i8;
        this.lastErr = i9;
    }
}
