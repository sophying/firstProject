package net.movie.db;

public class MovieBean {
	private int MOVIE_NUM;
	private String MOVIE_POSTER;
	private String MOVIE_SUBJECT;
	private String MOVIE_START;
	private String MOVIE_END;
//	private String subStringStartDate;
//	private String subStringEndDate;
	
	
	public String getMOVIE_END() {
		return MOVIE_END;
	}

	public void setMOVIE_END(String mOVIE_END) {
		
		String subStringEnd = mOVIE_END;
		
		
		String year = subStringEnd.substring(0, 4);
		String month = subStringEnd.substring(4, 6);
		String day = subStringEnd.substring(6, 8);

		String EndDate = year+"-"+ month+"-"+day;
		System.out.println("EndDATE: " + EndDate);

		MOVIE_END = EndDate;
	}

	
	public String getMOVIE_START() {
		return MOVIE_START;
	}
	
	public void setMOVIE_START(String mOVIE_START) {
		
		
		String subStringStart = mOVIE_START;
		

		String year = subStringStart.substring(0, 4);
		String month = subStringStart.substring(4, 6);
		String day = subStringStart.substring(6, 8);

		String StartDate = year+"-"+month+"-"+day;
		System.out.println("StartDATE : "+StartDate);

		MOVIE_START = StartDate;
	}
	public String STARTDATE(String MOVIE_START) {
		
		return MOVIE_START;
	}
	public String ENDDATE(String MOVIE_END) {
		
		return MOVIE_END;
	}

	
	public int getMOVIE_NUM() {
		return MOVIE_NUM;
	}

	public void setMOVIE_NUM(int mOVIE_NUM) {
		MOVIE_NUM = mOVIE_NUM;
	}

	public String getMOVIE_POSTER() {
		return MOVIE_POSTER;
	}

	public void setMOVIE_POSTER(String mOVIE_POSTER) {
		MOVIE_POSTER = mOVIE_POSTER;
	}

	public String getMOVIE_SUBJECT() {
		return MOVIE_SUBJECT;
	}

	public void setMOVIE_SUBJECT(String mOVIE_SUBJECT) {
		MOVIE_SUBJECT = mOVIE_SUBJECT;
	}



	
	
}
