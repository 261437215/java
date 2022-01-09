package com.msb.dao;

import com.msb.entity.Emp;

import java.sql.SQLException;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-09 12:15:00
 */
public interface EmpDao {

    /**
     * 添加数据
     * @param emp
     * @return
     * @throws SQLException
     */
    int addEmp(Emp emp) throws SQLException;

    /**
     * 删除数据
     * @param entity
     * @return
     * @throws SQLException
     */
    int delEmp(Integer entity) throws SQLException;
}

