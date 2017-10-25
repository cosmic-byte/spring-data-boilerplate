package com.springdata.elasticrepo;

import com.springdata.dto.UserDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepositoryES extends ElasticsearchRepository<UserDto, Long> {
}
