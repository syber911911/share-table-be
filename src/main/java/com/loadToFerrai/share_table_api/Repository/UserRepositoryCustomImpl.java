package com.loadToFerrai.share_table_api.Repository;

import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Repository.Interface.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final EntityManager em;

    @Override
    public User findUserByUserAgentId(String userAgentId) {
        return em.createQuery("select u from User u where u.userAgentInfo.userAgentId =: userAgentId", User.class)
                .setParameter("userAgentId", userAgentId)
                .getSingleResult();
    }

    @Override
    public Optional<User> findOptionalByUserAgentId(String userAgentId) {
        return Optional.ofNullable(
                em.createQuery("select u from User u where u.userAgentInfo.userAgentId =: userAgentId", User.class)
                        .setParameter("userAgentId", userAgentId)
                        .getSingleResult()
        );
    }
}
