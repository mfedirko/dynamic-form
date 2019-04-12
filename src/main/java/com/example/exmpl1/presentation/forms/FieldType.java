package com.example.exmpl1.presentation.forms;

public enum FieldType {
    TEXT("Text"),
    DATE ("Date"),
    CHECKBOX ("Checkbox"),
    TEXT_AREA ("Text Area"),
    NUMBER ("Number"),
    SELECT_OPTIONS ("Options"),
    PASSWORD ("Password");

    private String labelName;
    FieldType(String labelName){
        this.labelName = labelName;
    }

    public String getLabelName() {
        return labelName;
    }
}
