package com.controller;

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
 * @Time : 2019/2/6 19:00
 * @Author : Zhang, Chen (chansonzhang)
 * @Email : ZhangChen.Shaanxi@gmail.com
 * @FileName: GreetingController.java
 */

import com.mapper.CorporaRecordMapper;
import com.model.CorporaRecord;
import com.model.CorporaRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/corporabox")
public class CorporaBoxController {

    @Autowired
    private CorporaRecordMapper corporaRecordMapper;

    @RequestMapping("/get")
    public List<CorporaRecord> getAllCorporaRecords() {
        List<CorporaRecord> corporaRecords=corporaRecordMapper.selectByExample(new CorporaRecordExample());
        return corporaRecords;
    }

    @RequestMapping("/getById")
    public CorporaRecord getAllCorporaRecords(@RequestParam(value = "id") String id) {
        CorporaRecordExample corporaRecordExample=new CorporaRecordExample();
        CorporaRecordExample.Criteria criteria=corporaRecordExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<CorporaRecord> corporaRecords=corporaRecordMapper.selectByExample(new CorporaRecordExample());
        return corporaRecords.get(0);
    }

    @RequestMapping("/insert")
    public int insertCorporaRecord(@RequestParam(value = "name") String name) {
        CorporaRecord corporaRecord=new CorporaRecord();
        corporaRecord.setId(UUID.randomUUID());
        corporaRecord.setName(name);
        int corporaRecords=corporaRecordMapper.insert(corporaRecord);
        return corporaRecords;
    }

}