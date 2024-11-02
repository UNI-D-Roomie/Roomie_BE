package com.roomie.server.domain.member.domain;

import com.roomie.server.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "point", nullable = true)
    private int points;

    public static Member of(
            String loginId,
            String encodedPassword,
            String name,
            int points
    ) {
        return Member.builder()
                .loginId(loginId)
                .password(encodedPassword)
                .name(name)
                .points(points)
                .build();
    }

}
