package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
	private Integer id;

	@Column(length = 200) // 글자 수 제한
	private String subject;

	@Column(columnDefinition = "TEXT") // 글자 수 제한 할 수 없을 때
	private String content;

	private LocalDateTime createDate;

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 질문을 삭제하면 그에 달린 답변들도 함께 삭제
	private List<Answer> answerList;
}
