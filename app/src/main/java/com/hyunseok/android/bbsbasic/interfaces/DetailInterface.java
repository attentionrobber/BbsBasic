package com.hyunseok.android.bbsbasic.interfaces;

import com.hyunseok.android.bbsbasic.domain.Memo;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017-02-14.
 */

public interface DetailInterface {
    public void backToList();
    public void saveToList(Memo memo) throws SQLException;

}
