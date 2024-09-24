package com.loadToFerrai.share_table_api.repository.user;

import com.loadToFerrai.share_table_api.dto.authorizationDto.RegisterUserDetail;
import com.loadToFerrai.share_table_api.entity.User;
import com.loadToFerrai.share_table_api.entity.embedded.UserAgentInfo;
import com.loadToFerrai.share_table_api.entity.enums.Gender;
import com.loadToFerrai.share_table_api.entity.enums.UserAgentType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.loadToFerrai.share_table_api.entity.QUser.*;

@Repository
@RequiredArgsConstructor
public class UserRepositoryQueryDSL implements UserRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
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
    public User findUserByUserAgentId(UserAgentInfo userAgentInfo) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.userAgentInfo.userAgentId.eq(userAgentInfo.getUserAgentId())
                        .and(user.userAgentInfo.userAgentType.eq(userAgentInfo.getUserAgentType())))
                .fetchOne();
    }


    @Override
    public Optional<User> findOptionalByUserAgentId(UserAgentInfo userAgentInfo) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(user)
                        .where(user.userAgentInfo.userAgentId.eq(userAgentInfo.getUserAgentId())
                                .and(user.userAgentInfo.userAgentType.eq(userAgentInfo.getUserAgentType())))
                        .fetchOne()
        );
    }

    @Override
    public Long updateUserDetail(RegisterUserDetail userDetail) {
        return jpaQueryFactory
                .update(user)
                .set(user.userName, userDetail.getUserName())
                .set(user.userEmailAddress, userDetail.getUserEmailAddress())
                .set(user.userAgeRange, userDetail.getUserAgeRange())
                .set(user.userProfileNickname, userDetail.getUserProfileNickname())
                .set(user.userProfileIMG, userDetail.getUserProfileIMG())
                .set(user.userGender, userDetail.getUserGender())
                .where(user.userAgentInfo.userAgentId.eq(userDetail.getUserAgentInfo().getUserAgentId())
                        .and(user.userAgentInfo.userAgentId.eq(userDetail.getUserAgentInfo().getUserAgentType().getValue())))
                .execute();

    }

    @Override
    public User findUserByUserProfileNickName(String userProfileNickName) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.userProfileNickname.eq(userProfileNickName))
                .fetchOne();
    }

    @Override
    public Optional<User> findOptionalByUserProfileNickName(String userProfileNickName) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(user)
                        .where(user.userProfileNickname.eq(userProfileNickName))
                        .fetchOne()
        );
    }
}
