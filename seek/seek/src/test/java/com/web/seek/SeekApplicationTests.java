package com.web.seek;

import com.web.seek.domain.Board;
import com.web.seek.domain.User;
import com.web.seek.domain.enums.BoardType;
import com.web.seek.repository.BoardRepository;
import com.web.seek.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SeekApplicationTests {
	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected BoardRepository boardRepository;

	private final String title = "제목";
	private final String email = "test@naver.com";

	@BeforeEach
	public void init(){
		User user = userRepository.save(User.builder()
				.name("seek")
				.password("1234")
				.email(email)
				.build()
		);

		boardRepository.save(Board.builder()
				.title(title)
				.subTitle("부제목")
				.content("내용")
				.boardType(BoardType.free)
				.user(user)
				.build()
		);
	}

	@Test
	void contextLoads() {
		User user = userRepository.findByEmail(email);
		assertThat(user.getName(), is("seek"));
		assertThat(user.getPassword(), is("1234"));
		assertThat(user.getEmail(), is(email));

		Board board = boardRepository.findByUser(user);
		assertThat(board.getTitle(), is(title));
		assertThat(board.getSubTitle(), is("부제목"));
		assertThat(board.getContent(), is("내용내용내용"));
		assertThat(board.getBoardType(), is(BoardType.free));
	}

}
