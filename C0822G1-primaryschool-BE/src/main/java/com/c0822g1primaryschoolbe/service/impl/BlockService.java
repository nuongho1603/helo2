package com.c0822g1primaryschoolbe.service.impl;

import com.c0822g1primaryschoolbe.entity.clazz.Block;
import com.c0822g1primaryschoolbe.repository.IBlockRepository;
import com.c0822g1primaryschoolbe.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService implements IBlockService {

    @Autowired
    private IBlockRepository blockRepository;

    /**
     * Create by TuanNDN
     * @param blockId
     * @return
     */
    @Override
    public Block findByIdBlock(Long blockId) {
        return blockRepository.findByIdBlock(blockId);
    }

    /**
     * Create by TuanNDN
     * @return
     */
    @Override
    public List<Block> showListBlock() {
        return blockRepository.showListBlock();
    }



}
