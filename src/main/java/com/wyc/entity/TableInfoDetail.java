package com.wyc.entity;

/**
 * @author haima
 */
public class TableInfoDetail {

    private String column_comment;

    private String column_name;

    private String data_type;

    private Integer character_maximum_length;

    private String column_key;

    public String getColumn_comment() {
        return column_comment;
    }

    public void setColumn_comment(String column_comment) {
        this.column_comment = column_comment;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public Integer getCharacter_maximum_length() {
        return character_maximum_length;
    }

    public void setCharacter_maximum_length(Integer character_maximum_length) {
        this.character_maximum_length = character_maximum_length;
    }

    public String getColumn_key() {
        return column_key;
    }

    public void setColumn_key(String column_key) {
        this.column_key = column_key;
    }
}
