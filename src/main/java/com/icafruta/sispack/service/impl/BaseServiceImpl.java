package com.icafruta.sispack.service.impl;

import com.icafruta.sispack.dto.PaginationDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by alxnderq on 12/12/2016.
 */
public class BaseServiceImpl{

    Pageable pageable(PaginationDTO pagination) {
        return new PageRequest(pagination.getPage(), pagination.getSize(), Sort.Direction.ASC, pagination.getProperties());
    }
}
