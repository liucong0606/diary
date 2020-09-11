package com.liu.month8.d0807;

import com.liu.utils.Query;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * ClassName: JdbcDemo <br/>
 * Description: <br/>
 * date: 2020/8/7 15:51<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class JdbcDemo {
    @Test
    public void test01() {
        Query query = new Query();
        query.setTableName("tab_stu");
        query.setField("id, name, gender, age");
        query.query4List().forEach(System.out::println);
        JdbcTemplate jt = new JdbcTemplate();
    }
}
