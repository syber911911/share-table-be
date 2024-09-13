package com.loadToFerrai.share_table_api.Repository;

import com.loadToFerrai.share_table_api.Entity.User;
import com.loadToFerrai.share_table_api.Repository.Interface.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.loadToFerrai.share_table_api.Entity.QUser.*;

@Repository
@RequiredArgsConstructor
public class UserRepositoryQueryDSL implements UserRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public Optional<User> findByIdOptional(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return jpaQueryFactory.selectFrom(user)
                .fetch();
    }

    @Override
    public User findUserByUserAgentId(String userAgentId) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.userAgentInfo.userAgentId.eq(userAgentId))
                .fetchOne();
    }


    @Override
    public Optional<User> findOptionalByUserAgentId(String userAgentId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(user)
                        .where(user.userAgentInfo.userAgentId.eq(userAgentId))
                        .fetchOne()
        );
    }
}
