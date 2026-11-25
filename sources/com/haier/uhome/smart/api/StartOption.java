package com.haier.uhome.smart.api;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class StartOption {
    private String mAuthPath;
    private Context mContext;
    private String mDomain;
    private String mNetCardName;
    private int mPort;
    private int mRootCA;

    public static class Builder {
        String mDomain = "gw.haier.net";
        int mPort = 56810;
        int mRootCA = 0;
        String mAuthPath = "";
        String mNetCardName = "";
        Context mContext = null;

        public Builder authPath(String str) {
            this.mAuthPath = str;
            return this;
        }

        public StartOption build() {
            StartOption startOption = new StartOption();
            startOption.mDomain = this.mDomain;
            startOption.mPort = this.mPort;
            startOption.mRootCA = this.mRootCA;
            startOption.mAuthPath = this.mAuthPath;
            startOption.mNetCardName = this.mNetCardName;
            startOption.mContext = this.mContext;
            return startOption;
        }

        public Builder context(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder domain(String str) {
            this.mDomain = str;
            return this;
        }

        public Builder netCardName(String str) {
            this.mNetCardName = str;
            return this;
        }

        public Builder port(int i7) {
            this.mPort = i7;
            return this;
        }

        public Builder rootCA(int i7) {
            this.mRootCA = i7;
            return this;
        }
    }

    public String getAuthPath() {
        return this.mAuthPath;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDomain() {
        return this.mDomain;
    }

    public String getNetCardName() {
        return this.mNetCardName;
    }

    public int getPort() {
        return this.mPort;
    }

    public int getRootCA() {
        return this.mRootCA;
    }

    public String toString() {
        return "StartOption{mDomain='" + this.mDomain + "', mPort=" + this.mPort + ", mRootCA=" + this.mRootCA + ", mAuthPath='" + this.mAuthPath + "', mNetCardName='" + this.mNetCardName + "', mContext='" + this.mContext + "'}";
    }
}
