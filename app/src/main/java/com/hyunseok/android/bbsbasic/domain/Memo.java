package com.hyunseok.android.bbsbasic.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Administrator on 2017-02-14.
 */

@DatabaseTable(tableName = "memo")
public class Memo {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String memo;
    @DatabaseField
    Date date;


    public int getId() {
        return id;
    }

    public String getMemo() {
        return memo;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Memo() {

    }

    // create시에 사용할 생성자
    public Memo(String memo, Date date) {
        this.memo = memo;
        this.date = date;
    }

}
