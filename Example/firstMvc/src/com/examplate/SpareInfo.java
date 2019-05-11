package com.examplate;

public class SpareInfo {
    private String isOriginal;
    private Integer templateId;
    private String bigClass;
    private String smallClass;
    private String sortNo;
    private String originalItem;//原物项
    private String primitiveItems;//原始物项
    private String substituteItem;//原始物项

    public String getOriginalItem() {
        return originalItem;
    }

    public void setOriginalItem(String originalItem) {
        this.originalItem = originalItem;
    }

    public String getPrimitiveItems() {
        return primitiveItems;
    }

    public void setPrimitiveItems(String primitiveItems) {
        this.primitiveItems = primitiveItems;
    }

    public String getSubstituteItem() {
        return substituteItem;
    }

    public void setSubstituteItem(String substituteItem) {
        this.substituteItem = substituteItem;
    }


    public String getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(String isOriginal) {
        this.isOriginal = isOriginal;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getBigClass() {
        return bigClass;
    }

    public void setBigClass(String bigClass) {
        this.bigClass = bigClass;
    }

    public String getSmallClass() {
        return smallClass;
    }

    public void setSmallClass(String smallClass) {
        this.smallClass = smallClass;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }
}
