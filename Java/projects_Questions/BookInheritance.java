class Book {
	private String title;
	private String author;
	
	public Book (String title, String author) {
		this.title = title;
		this.author = author;
	}

	
	public void setTitle (String title) {
		this.title = title;
	}
	public void setAuthor (String author) {
		this.author = author;		
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String toString() {
		return String.format("The title of the book is %s%nThe author of the book is %s", getTitle(), getAuthor());
	}
}
class PrintBook extends Book{
	private String publisher;
	private String isbn;
	
	public PrintBook (String title, String author, String publisher, String isbn) {
		super(title, author);
		this.publisher = publisher;
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return String.format("%nPrinted version%n%s%nThe publisher of the book is %s%nThe ISBN is %s", super.toString(), getPublisher(), getIsbn());
	}
}
class AudioBook extends Book {
	private String artistName;
	private String audioLength;
	private int bookSize;
	
	public AudioBook (String title, String author, String artistName, String audioLength, int bookSize) {
		super(title, author);
		this.artistName = artistName;
		this.audioLength = audioLength;
		this.bookSize = bookSize;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAudioLength() {
		return audioLength;
	}

	public void setAudioLength(String audioLength) {
		this.audioLength = audioLength;
	}

	public int getBookSize() {
		return bookSize;
	}

	public void setBookSize(int bookSize) {
		this.bookSize = bookSize;
	}
	
	@Override
	public String toString() {
		return String.format("%nAudio version%n%s%nThe artist name is %s%nThe length is %s%n the book size is %s MB", 
				super.toString(), getArtistName(), getAudioLength(), getBookSize());
	}
}


public class Test{
	public static void main(String[] args) {
		AudioBook myAudio = new AudioBook("Saleh's book","Saleh", "Ana", "1 hour", 11);
		PrintBook myPrinted = new PrintBook("Saleh's book","Saleh", "3obakan", "9-343-234-2553");
		
		System.out.println(myAudio);
		System.out.println(myPrinted);
		
	}
}