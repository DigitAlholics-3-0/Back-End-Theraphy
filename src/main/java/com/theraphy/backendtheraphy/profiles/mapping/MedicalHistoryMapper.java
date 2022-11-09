package com.theraphy.backendtheraphy.profiles.mapping;

import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MedicalHistoryMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

}
