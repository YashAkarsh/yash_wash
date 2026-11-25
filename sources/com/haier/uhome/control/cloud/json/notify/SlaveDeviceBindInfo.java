package com.haier.uhome.control.cloud.json.notify;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SlaveDeviceBindInfo {

    @b(name = "bindingReport")
    private BindingReport bindingReport;

    public BindingReport getBindingReport() {
        return this.bindingReport;
    }

    public void setBindingReport(BindingReport bindingReport) {
        this.bindingReport = bindingReport;
    }

    public String toString() {
        return "SlaveDeviceBindInfo{bindingReport=" + this.bindingReport + '}';
    }
}
