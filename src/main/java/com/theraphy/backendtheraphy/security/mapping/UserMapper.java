package com.theraphy.backendtheraphy.security.mapping;

import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import com.theraphy.backendtheraphy.security.resource.CreateUserResource;
import com.theraphy.backendtheraphy.security.resource.UpdateUserResource;
import com.theraphy.backendtheraphy.security.resource.UserResource;
import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource) {return mapper.map(resource, User.class);}
    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

}
