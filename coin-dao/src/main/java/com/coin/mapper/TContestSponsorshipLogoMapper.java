package com.coin.mapper;

import com.coin.entity.TContestSponsorshipLogo;
import com.coin.entity.TContestSponsorshipLogoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContestSponsorshipLogoMapper {
    long countByExample(TContestSponsorshipLogoExample example);

    int deleteByExample(TContestSponsorshipLogoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContestSponsorshipLogo row);

    int insertSelective(TContestSponsorshipLogo row);

    List<TContestSponsorshipLogo> selectByExample(TContestSponsorshipLogoExample example);

    TContestSponsorshipLogo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TContestSponsorshipLogo row, @Param("example") TContestSponsorshipLogoExample example);

    int updateByExample(@Param("row") TContestSponsorshipLogo row, @Param("example") TContestSponsorshipLogoExample example);

    int updateByPrimaryKeySelective(TContestSponsorshipLogo row);

    int updateByPrimaryKey(TContestSponsorshipLogo row);
}