package manage.book.request;

public class GetBookRequest {

		private String title;
		private String author;
		private String publishedDate;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPublishedDate() {
			return publishedDate;
		}
		public void setPublishedDate(String publishedDate) {
			this.publishedDate = publishedDate;
		}
}
