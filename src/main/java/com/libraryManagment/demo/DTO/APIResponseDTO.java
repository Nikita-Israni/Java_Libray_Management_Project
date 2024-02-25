package com.libraryManagment.demo.DTO;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class APIResponseDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String message;
    private Object body;

    public APIResponseDTO() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    /**
     * this.setMessage(CommonConstants.ResponseMsg.SUCCESS.toString());
     * this.setStatus(CommonConstants.RESPONSE_CODE_SUCCESS);
     */
    public void setSuccess() {
        this.setMessage("Success");
        this.setStatus(200);
    }

    /**
     * this.setMessage(CommonConstants.ResponseMsg.FAILED.toString());
     * this.setStatus(CommonConstants.RESPONSE_CODE_FAILED);
     */
}
