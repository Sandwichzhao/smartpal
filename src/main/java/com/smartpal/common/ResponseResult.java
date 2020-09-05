package com.smartpal.common;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResponseResult<T> {
    private int statusCode = HttpStatus.OK.value();
    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        if (!CollectionUtils.isEmpty(result)) {
            this.result = result;
        }
    }

    public void setResult(T result) {
        if (!Objects.nonNull(result)) {
            this.result = Stream.of(result).collect(Collectors.toList());
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
