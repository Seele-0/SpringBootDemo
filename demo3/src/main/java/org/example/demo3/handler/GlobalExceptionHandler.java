package org.example.demo3.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.demo3.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param ex 异常信息
     * @return 统一错误结果
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<String> exceptionHandler(RuntimeException ex) {
        log.error("业务异常：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL异常
     *
     * @param ex 异常信息
     * @return 统一错误结果
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error("SQL异常：{}", ex.getMessage());
        String message = ex.getMessage();
        if (message != null && message.contains("Duplicate entry")) {
            return Result.error("数据已存在");
        }
        return Result.error("数据库操作失败");
    }

    /**
     * 处理未知异常
     *
     * @param ex 异常信息
     * @return 统一错误结果
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception ex) {
        log.error("未知异常", ex);
        return Result.error("系统异常，请稍后再试");
    }
}
