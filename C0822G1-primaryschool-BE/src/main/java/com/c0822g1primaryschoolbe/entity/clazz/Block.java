package com.c0822g1primaryschoolbe.entity.clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Long blockId;
    @Column(columnDefinition = "varchar(45)")
    private Integer blockName;

    public Block() {
    }

    public Block(Long blockId) {
        this.blockId = blockId;
    }

    public Block(Long blockId, Integer blockName) {
        this.blockId = blockId;
        this.blockName = blockName;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockName() {
        return blockName;
    }

    public void setBlockName(Integer blockName) {
        this.blockName = blockName;
    }
}
