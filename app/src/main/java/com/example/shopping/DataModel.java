package com.example.shopping;

public class DataModel {

    String name;
    String type;
    String version_number;
    String feature;

    public DataModel(){

    }

    public DataModel(String name, String version_number, String feature ) {
        this.name=name;

        this.version_number=version_number;
        this.feature=feature;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion_number(String version_number) {
        this.version_number = version_number;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getVersion_number() {
        return version_number;
    }

    public String getFeature() {
        return feature;
    }

}
