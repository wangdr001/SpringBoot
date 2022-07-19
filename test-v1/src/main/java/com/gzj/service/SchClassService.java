package com.gzj.service;

import com.gzj.model.SchClass;

public interface SchClassService {

    int saveAddSchClass(SchClass schClass);

    int saveEditSchClass(SchClass schClass);

    int deleteClassByNumber(String name);
}