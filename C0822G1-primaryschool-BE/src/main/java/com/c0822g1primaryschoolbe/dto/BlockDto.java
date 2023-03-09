package com.c0822g1primaryschoolbe.dto;

import com.c0822g1primaryschoolbe.entity.clazz.Block;
import com.c0822g1primaryschoolbe.entity.teacher.Teacher;
import com.c0822g1primaryschoolbe.entity.time_table_subject.TimeTable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BlockDto  {
    /**
     * Create by TuanNDN
     */
    private Long blockId;
    private String blockName;

    public BlockDto() {
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }


}
