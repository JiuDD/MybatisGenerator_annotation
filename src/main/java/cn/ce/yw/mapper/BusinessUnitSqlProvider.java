package cn.ce.yw.mapper;

import cn.ce.yw.model.BusinessUnit;
import org.apache.ibatis.jdbc.SQL;

public class BusinessUnitSqlProvider {

    public String insertSelective(BusinessUnit record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_business_unit");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUnitCode() != null) {
            sql.VALUES("unit_code", "#{unitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitName() != null) {
            sql.VALUES("unit_name", "#{unitName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitDef() != null) {
            sql.VALUES("unit_def", "#{unitDef,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BusinessUnit record) {
        SQL sql = new SQL();
        sql.UPDATE("t_business_unit");
        
        if (record.getUnitCode() != null) {
            sql.SET("unit_code = #{unitCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitName() != null) {
            sql.SET("unit_name = #{unitName,jdbcType=VARCHAR}");
        }
        
        if (record.getUnitDef() != null) {
            sql.SET("unit_def = #{unitDef,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}