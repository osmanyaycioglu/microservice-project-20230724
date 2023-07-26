package com.training.micro.service.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String desc;
    private Integer errorCode;

    public ErrorObj() {
    }
}
