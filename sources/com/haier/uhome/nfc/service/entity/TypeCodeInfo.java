package com.haier.uhome.nfc.service.entity;

import com.haier.uhome.usdk.base.annotation.Keep;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class TypeCodeInfo {

    @b(name = "productCode")
    private String code;

    @b(name = "img")
    private String imageUrl;

    @b(name = "modelCode")
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "\n{productCode='" + this.code + "'\n modelCode='" + this.name + "'}";
    }
}
