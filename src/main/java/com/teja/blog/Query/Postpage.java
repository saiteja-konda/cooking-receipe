package com.teja.blog.Query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postpage {
    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction direction = Sort.Direction.DESC;
    private String sortBy = "views";
}
