package io.sys1.test.v1.user;

import io.sys1.test.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsersRespository extends JpaRepository<Users, Long> {

}
