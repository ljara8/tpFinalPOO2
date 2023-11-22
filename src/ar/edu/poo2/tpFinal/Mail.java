package ar.edu.poo2.tpFinal;

public class Mail {
	private String title;
	private String to;
	private String content;

	public Mail(String title, String to, String content) {
		this.title = title;
		this.to = to;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(to)
				.append("\n")
				.append(title)
				.append("\n")
				.append(content)
				.toString();
	}
}