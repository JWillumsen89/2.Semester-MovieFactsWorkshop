package dk.kea.moviefactsworkshopdat22v2.model;


public class Movie {

  //Movie POJO (PLAIN OLD JAVA OBJECT)
  //Year;Length;Title;Subject;Popularity;Awards

  private int year;
  private int length;
  private String title;
  private String subject;
  private int popularity;
  private boolean award;

  public Movie(int year, int length, String title, String subject, int popularity, boolean award) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.award = award;
  }

  public Movie() {

  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public boolean isAward() {
    return award;
  }

  public void setAward(boolean award) {
    this.award = award;
  }


  @Override
  public String toString() {
    return
        "Year: " + year + ". Length: " + length +
        ". Title: " + title + ". Subject: " + subject +
        ". Popularity: " + popularity +
        ". Award: " + award;
  }
}
