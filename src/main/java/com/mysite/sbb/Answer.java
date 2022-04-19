package com.mysite.sbb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
	private Integer id;

	@Column(columnDefinition = "TEXT") // 글자 수 제한 할 수 없을 때
	private String content;

	private LocalDateTime createDate;

	@ManyToOne // 하나의 질문에 여러개의 답변이 달릴 수 있는 구조
	private Question question;
}
