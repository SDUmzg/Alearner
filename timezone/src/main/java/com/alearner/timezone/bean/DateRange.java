package com.alearner.timezone.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: mazongguang
 * @version: v1.0
 * @description: com.alearner.timezone.bean
 * @date:2019/9/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRange {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;
}
