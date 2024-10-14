package com.oyl.cics.impl.shared;

import com.oyl.cics.model.shared.UploadStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UploadStatusTypeHandler implements TypeHandler<UploadStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, UploadStatus uploadStatus, JdbcType jdbcType) throws SQLException {
        if (null != uploadStatus) {
            preparedStatement.setInt(i, uploadStatus.getCode());
        }
    }

    @Override
    public UploadStatus getResult(ResultSet resultSet, String s) throws SQLException {
        return UploadStatus.init(resultSet.getInt(s));
    }

    @Override
    public UploadStatus getResult(ResultSet resultSet, int i) throws SQLException {
        return UploadStatus.init(resultSet.getInt(i));
    }

    @Override
    public UploadStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        return UploadStatus.init(callableStatement.getInt(i));
    }
}
