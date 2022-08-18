package com.coin.mapper;

import com.coin.entity.TCustomer;
import com.coin.entity.TCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCustomerMapper {
    long countByExample(TCustomerExample example);

    int deleteByExample(TCustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCustomer row);

    int insertSelective(TCustomer row);

    List<TCustomer> selectByExample(TCustomerExample example);

    TCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TCustomer row, @Param("example") TCustomerExample example);

    int updateByExample(@Param("row") TCustomer row, @Param("example") TCustomerExample example);

    int updateByPrimaryKeySelective(TCustomer row);

    int updateByPrimaryKey(TCustomer row);
}