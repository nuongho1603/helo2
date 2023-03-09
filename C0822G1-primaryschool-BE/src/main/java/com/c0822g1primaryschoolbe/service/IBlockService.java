package com.c0822g1primaryschoolbe.service;

import com.c0822g1primaryschoolbe.entity.clazz.Block;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlockService{

    /**
     * Create by TuanNDN
     * @param blockId
     * @return
     */
    Block findByIdBlock(@Param("blockId") Long blockId);

    /**
     * Create by TuanNDN
     * @return
     */
    List<Block> showListBlock();
}
