package com.teja.blog.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PageUtil {
    public static <T, ID> void validPage(Integer pageSize, Integer page, JpaRepository<T, ID> repository) {
        long count = repository.count();
        if (count == 0) {
            return;
        }
        long totalPage = count / pageSize;
        totalPage = count % pageSize == 0 ? totalPage : totalPage + 1;
        if (page < 0 || page >= totalPage) {
//            throw new PageOutOfBoundException();
        }
    }
}
