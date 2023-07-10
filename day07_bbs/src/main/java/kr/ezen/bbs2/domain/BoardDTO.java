package kr.ezen.bbs2.domain;

import java.sql.Date;

import lombok.Data;

//@Setter @Getter @ToString
@Data   //한꺼번에 자동으로 setter()/getter()/toString() 메서드 만들어 줌
public class BoardDTO {
	
	private int bid;
    private String subject;
    private String contents;
    private int hit;
    private String writer;
    private Date reg_date;
    
}
