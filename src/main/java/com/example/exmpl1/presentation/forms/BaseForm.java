package com.example.exmpl1.presentation.forms;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseForm {

    /*
    * The field layout grid to be used in JSP form page.
    * Default layout is 3 fields per row
    */
    public String[][] fieldLayout(){
        int rowCount = allFields().size() / 3;
        if (allFields.size() % 3 != 0) rowCount = rowCount + 1;
        String[][] allFields = new String[rowCount][3];

        ListIterator<String> iterator = allFields().listIterator();
        int curRow = 0;
        int curCol = 0;
        String[] rowStr = new String[3];
        boolean hasData = false;
        while (iterator.hasNext()){
            if (curCol == 3){
                allFields[curRow] = rowStr;
                curCol = 0;
                curRow = curRow + 1;
                rowStr = new String[3];
                hasData = false;
            }
            hasData = true;
            rowStr[curCol] = iterator.next();
            curCol++;
        }
        if (hasData) allFields[curRow] = rowStr;
        return allFields;
    }


    /*
    * The field detail
     */
    public static class FieldDetail {
        private FieldType fieldType;

        public FieldDetail(String fieldName) {
            this.fieldName = fieldName;
            this.fieldType = FieldType.TEXT;
        }

        public boolean isRequired() {
            return isRequired;
        }

        public void setRequired(boolean required) {
            isRequired = required;
        }

        public String getFieldName() {
            return fieldName;
        }

        public FieldType getFieldType() {
            return fieldType;
        }

        public void setFieldType(FieldType fieldType) {
            this.fieldType = fieldType;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getLabelCode() {
            return labelCode;
        }

        public void setLabelCode(String labelCode) {
            this.labelCode = labelCode;
        }

        public FieldDetail(boolean isRequired, String fieldName, String labelCode) {
            this(fieldName);
            this.isRequired = isRequired;
            this.labelCode = labelCode;
        }

        public FieldDetail(boolean isRequired, String fieldName, String labelCode, FieldType fieldType) {
            this(isRequired,fieldName,labelCode);
            this.fieldType = fieldType;
        }

        private boolean isRequired;
        private String fieldName;
        private String labelCode;

    }

    public abstract FieldDetail getFieldDetail(String field);
    public abstract List<String> requiredFields();
    public abstract List<String> optionalFields();

    public  String getLabelCode(String fieldName){
        return getFieldDetail(fieldName).getLabelCode();
    }

    private List<String> allFields;

    private Map<String, Method> fieldMap = new HashMap<>();

    public BaseForm(){
        for (String field : allFields()){
            if (field == null) throw new IllegalArgumentException(String.format("Field null is not accessible"));
            try {
                fieldMap.put(field, new PropertyDescriptor(field, this.getClass()).getReadMethod());
            }
            catch (Exception e){
                e.printStackTrace();
                throw new IllegalArgumentException(String.format("Field %s is not accessible",field));
            }
        }


    }


    public Object getField(String fieldName){
        ensureFieldExists(fieldName);
        try {
            return fieldMap.get(fieldName).invoke(this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<String> allFields(){
        if (this.allFields == null) {
            List<String> allFields = new ArrayList<>();
            if (requiredFields() != null) allFields.addAll(requiredFields());
            if (optionalFields() != null) allFields.addAll(optionalFields());
            this.allFields = allFields;
        }
        return this.allFields;
    }

    private void ensureFieldExists(String fieldName){
        if (!fieldMap.containsKey(fieldName)) throw new IllegalArgumentException(String.format("Field %s does not exist",fieldName));
    }

    public boolean isRequired(String fieldName){
        ensureFieldExists(fieldName);
        return getFieldDetail(fieldName).isRequired;
    }




    private boolean isEmpty(Object obj){
        return obj == null || obj.equals("");
    }


}
