package day1217;

public class ScoreVO {

	private String name;
	private int javaScore, oraclScore;
	
	public ScoreVO(String name, int javaScore, int oraclScore) {//인자있는생성자
		super();
		this.name = name;
		this.javaScore = javaScore;
		this.oraclScore = oraclScore;
	}
	public String getName() {
		return name;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public int getOraclScore() {
		return oraclScore;
	}
//	private String name;
//	private int javaScore, oracleScore;
//	
//	public ScoreVO(String name, int javaScore, int oracleScore) {
//		super();
//		this.name = name;
//		this.javaScore = javaScore;
//		this.oracleScore = oracleScore;
//		
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public int getJavaScore() {
//		return javaScore;
//	}
//
//	public int getOracleScore() {
//		return oracleScore;
//	}
	
	
	

	
	
}
