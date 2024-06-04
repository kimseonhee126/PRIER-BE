package cocodas.prier.user.kakao.jwt.token;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "refreshToken", timeToLive = 14 * 24 * 60 * 60 * 1000L)
@AllArgsConstructor
@Getter
@Builder
public class Token {

    @Id
    private Long userId;

    private String refreshToken;

    public static Token of(Long id, String refreshToken) {
        return Token.builder()
                .userId(id)
                .refreshToken(refreshToken)
                .build();
    }
}
