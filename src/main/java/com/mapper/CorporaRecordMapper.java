package com.mapper;

import java.util.List;
import com.model.CorporaRecord;
import com.model.CorporaRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CorporaRecordMapper {
    int countByExample(CorporaRecordExample example);

    int deleteByExample(CorporaRecordExample example);

    int insert(CorporaRecord record);

    int insertSelective(CorporaRecord record);

    List<CorporaRecord> selectByExample(CorporaRecordExample example);

    int updateByExampleSelective(@Param("record") CorporaRecord record, @Param("example") CorporaRecordExample example);

    int updateByExample(@Param("record") CorporaRecord record, @Param("example") CorporaRecordExample example);
}