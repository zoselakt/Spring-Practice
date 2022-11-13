package com.web.seek;

import com.web.seek.domain.Board;
import com.web.seek.domain.User;
import com.web.seek.domain.enums.BoardType;
import com.web.seek.repository.BoardRepository;
import com.web.seek.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.IntStream;

@EnableJpaAuditing
@SpringBootApplication
public class SeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeekApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception{
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("seek")
					.password("1234")
					.email("seek@naver.com")
					.build()
			);
			IntStream.rangeClosed(1, 200).forEach(index ->
					boardRepository.save(Board.builder()
							.title(String.format("제목 %s", index))
							.subTitle(String.format("부제목 %s", index))
							.content(String.format("내용 %s", index))
							.boardType(BoardType.free)
							.user(user)
							.build())
			);
		};
	}
}
