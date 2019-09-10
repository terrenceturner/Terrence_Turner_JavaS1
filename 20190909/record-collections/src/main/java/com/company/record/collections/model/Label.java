package com.company.record.collections.model;

import java.util.Objects;

public class Label {

    private int label_id;
    private String name;
    private String website;

    public int getLabel_id() {
        return label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return label_id == label.label_id &&
                name.equals(label.name) &&
                website.equals(label.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label_id, name, website);
    }
}
