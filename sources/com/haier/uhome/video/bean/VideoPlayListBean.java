package com.haier.uhome.video.bean;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayListBean {
    private int code;
    private List<DataBean> data;
    private String msg;
    private String requestId;

    public static class DataBean {
        private long end;
        private long start;

        public long getEnd() {
            return this.end;
        }

        public long getStart() {
            return this.start;
        }

        public void setEnd(long j7) {
            this.end = j7;
        }

        public void setStart(long j7) {
            this.start = j7;
        }

        public String toString() {
            return "DataBean{start=" + this.start + ", end=" + this.end + '}';
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String toString() {
        return "VideoPlayListBean{msg='" + this.msg + "', code=" + this.code + ", requestId='" + this.requestId + "', data=" + this.data + '}';
    }
}
