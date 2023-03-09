package com.c0822g1primaryschoolbe.repository;

import com.c0822g1primaryschoolbe.entity.clazz.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlockRepository extends JpaRepository<Block, Long> {
    /**
     * Create by TuanNDN
     * @param blockId
     * @return
     */
    @Query(value ="SELECT * from block where block_id = :blockId",
            countQuery = "SELECT * from block where block_id = :blockId",
            nativeQuery = true)
    Block findByIdBlock(@Param("blockId") Long blockId);

    /**
     * Create by TuanNDN
     * @return
     */
    @Query(value = "SELECT * FROM `primary-school-management`.block"
            ,countQuery = "SELECT * FROM `primary-school-management`.block"
            ,nativeQuery = true)
    List<Block> showListBlock();
}
