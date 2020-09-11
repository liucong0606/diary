package com.liu.month8.d0825.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author liucong
 * @ClassName: Good
 * @Description:
 * @date: 2020/8/25 9:20
 */
@Data
@ToString
public class Good {
    private Integer id;
    private String name;
    private Integer typeId;
    private String remark;

    public Good() {
    }

    public Good(Integer id, String name, Integer typeId, String remark) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.remark = remark;
    }
}
