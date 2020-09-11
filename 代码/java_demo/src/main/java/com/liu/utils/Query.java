package com.liu.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * ClassName: Query
 * Description: 封装持久层框架，基于JdbcTemplate
 * date: 2020/8/7 15:12
 * @author liucong<br />
 * @since JDK 1.8
 */
public class Query {
    private String tableName;   // 表名
    private String field;       // 字段名
    private String where;       // 条件
    private String sql;         // sql语句

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    /**
     * @Description: 拼接条件
     * @auther: liucong
     * @date: 2020/8/7 15:23
     * @return:
     */
    public void addWhere(String where) {
        this.where += " " + where;
    }

    private void setSql() {
        this.sql = String.format("select %s from %s ", this.field, this.tableName);
        if (!StringUtils.isEmpty(this.where)) {
            this.sql += String.format(" where %s ", this.where);
        }
    }

    public List query4List() {
        this.setSql();
        org.springframework.jdbc.core.JdbcTemplate jt = JdbcTemplate.getJdbcTemplate();
        List list = (List) jt.queryForList(this.sql);
        return (List)list;
    }
}
