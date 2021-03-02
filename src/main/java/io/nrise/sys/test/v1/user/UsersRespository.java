package io.nrise.sys.test.v1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.nrise.sys.test.entity.*;

@RepositoryRestResource
public interface UsersRespository extends JpaRepository<Users, String> {

}
