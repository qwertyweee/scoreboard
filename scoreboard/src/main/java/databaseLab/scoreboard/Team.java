package databaseLab.scoreboard;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Team {
 
	@Id
	
	
	private Integer teamId;
	
	@ManyToOne
	@JoinColumn(name = "judgeId")
	private Judge judge;
	
    private String teamName;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String comment;
    private String question;

	public String getTeamName() {
		return teamName;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public String getQ5() {
		return q5;
	}

	public void setQ5(String q5) {
		this.q5 = q5;
	}

	public String getQ6() {
		return q6;
	}

	public void setQ6(String q6) {
		this.q6 = q6;
	}
	
	public void updateResult(String messege, String questionNo) {
		if(question.equals("1") ) {
			setQ1(messege);
		}
		
		else if(question.equals("2") )
			setQ2(messege);
		
		else if(question.equals("3") )
			setQ3(messege);
		
		else if(question.equals("4") )
			setQ4(messege);
		
		else if(question.equals("5") )
			setQ5(messege);
		
		else if(question.equals("6") )
			setQ6(messege);
		
		
	}
}