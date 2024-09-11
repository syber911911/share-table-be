package com.loadToFerrai.share_table_api.Repository.Interface;

import com.loadToFerrai.share_table_api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
