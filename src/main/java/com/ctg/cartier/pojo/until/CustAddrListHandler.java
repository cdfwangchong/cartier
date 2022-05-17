package com.ctg.cartier.pojo.until;

import com.alibaba.druid.support.spring.DruidNativeJdbcExtractor;
import com.ctg.cartier.pojo.dto.SaleReportDetailDto;
import oracle.jdbc.driver.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
@MappedTypes(List.class)
@MappedJdbcTypes({JdbcType.ARRAY})
public class CustAddrListHandler implements TypeHandler<Object> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        DruidNativeJdbcExtractor extractor = new DruidNativeJdbcExtractor();
        OracleConnection oracleConn = (OracleConnection) extractor.getNativeConnection(ps.getConnection());
        if (oracleConn.isClosed()) {
            System.out.println("***********关闭");
        }
        if (parameter.toString().contains("SaleReportDetailDto")) {
            List dto = (ArrayList) parameter;
            StructDescriptor sd = new StructDescriptor("SALEREPORTDETAIL_ROW_TYPE", oracleConn);
            STRUCT result[] = new STRUCT[dto.size()];

            for (int index = 0; index < dto.size(); index++) {
                SaleReportDetailDto d = (SaleReportDetailDto) dto.get(index);
                Object o[] = new Object[4];//数组大小不能多也不能少
                o[0] = d.getGoods_cshh();
                o[1] = d.getGoods_count();
                o[2] = d.getIndependent_code();
                o[3] = d.getGoods_id();
                try {
                    result[index] = new STRUCT(sd, oracleConn, o);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ArrayDescriptor des_Employee_TABLE = ArrayDescriptor.createDescriptor("SALEREPORTDETAIL_TAB_TYPE", oracleConn);
            ARRAY oracle_array = new ARRAY(des_Employee_TABLE, oracleConn, result);
            ps.setArray(i, oracle_array);
            ps.getResultSet();
        }
    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}