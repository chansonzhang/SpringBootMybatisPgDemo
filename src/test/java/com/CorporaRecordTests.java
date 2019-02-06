package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.CorporaRecordMapper;
import com.model.CorporaRecord;
import com.model.CorporaRecordExample;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/**
 * Copyright 2018 Zhang, Chen. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==============================================================================
 *
 * @Time : 2019/2/6 21:32
 * @Author : Zhang, Chen (chansonzhang)
 * @Email : ZhangChen.Shaanxi@gmail.com
 * @FileName: com.CorporaRecordTests.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.JVM)
public class CorporaRecordTests {
    @Autowired
    private CorporaRecordMapper corporaRecordMapper;

    @Test
    public void testInsert(){
        String name="TestRecord";
        CorporaRecord corporaRecord=new CorporaRecord();
        corporaRecord.setId(UUID.randomUUID());
        corporaRecord.setName(name);
        int num=corporaRecordMapper.insert(corporaRecord);
        assert 1==num;
    }

    @Test
    public void testGetAll(){
            List<CorporaRecord> corporaRecords=corporaRecordMapper.selectByExample(new CorporaRecordExample());
        try {
            System.out.println(new ObjectMapper().writeValueAsString(corporaRecords));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
