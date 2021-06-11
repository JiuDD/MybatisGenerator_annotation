package cn.ce.yw.mapper;

import cn.ce.yw.model.BusinessUnit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BusinessUnitMapper {
    @Delete({
        "delete from t_business_unit",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_business_unit (id, unit_code, ",
        "unit_name, unit_def, ",
        "create_by)",
        "values (#{id,jdbcType=INTEGER}, #{unitCode,jdbcType=VARCHAR}, ",
        "#{unitName,jdbcType=VARCHAR}, #{unitDef,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=VARCHAR})"
    })
    int insert(BusinessUnit record);

    @InsertProvider(type=BusinessUnitSqlProvider.class, method="insertSelective")
    int insertSelective(BusinessUnit record);

    @Select({
        "select",
        "id, unit_code, unit_name, unit_def, create_by",
        "from t_business_unit",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="unit_code", property="unitCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_name", property="unitName", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit_def", property="unitDef", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    BusinessUnit selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BusinessUnitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BusinessUnit record);

    @Update({
        "update t_business_unit",
        "set unit_code = #{unitCode,jdbcType=VARCHAR},",
          "unit_name = #{unitName,jdbcType=VARCHAR},",
          "unit_def = #{unitDef,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BusinessUnit record);
}