package com.haier.uhome.smart.api;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceFile {

    @b(name = "alg")
    private String alg;

    @b(name = "expiryTime")
    private long expiryTime;

    @b(name = "fileHash")
    private String fileHash;

    @b(name = "fileSize")
    private long fileSize;

    @b(name = "httpUrl")
    private String httpUrl;

    @b(name = "httpsUrl")
    private String httpsUrl;

    @b(name = "secretKey")
    private String secretKey;

    public String getAlg() {
        return this.alg;
    }

    public long getExpiryTime() {
        return this.expiryTime;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getHttpUrl() {
        return this.httpUrl;
    }

    public String getHttpsUrl() {
        return this.httpsUrl;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public void setAlg(String str) {
        this.alg = str;
    }

    public void setExpiryTime(long j7) {
        this.expiryTime = j7;
    }

    public void setFileHash(String str) {
        this.fileHash = str;
    }

    public void setFileSize(long j7) {
        this.fileSize = j7;
    }

    public void setHttpUrl(String str) {
        this.httpUrl = str;
    }

    public void setHttpsUrl(String str) {
        this.httpsUrl = str;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public String toString() {
        return "ResourceFile{alg='" + this.alg + "', expiryTime=" + this.expiryTime + ", fileHash='" + this.fileHash + "', fileSize=" + this.fileSize + ", httpUrl='" + this.httpUrl + "', httpsUrl='" + this.httpsUrl + "', secretKey='" + this.secretKey + "'}";
    }
}
