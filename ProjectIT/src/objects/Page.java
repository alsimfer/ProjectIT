package objects;

import java.io.Serializable;

import db.*;

public class Page implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	String slug, title, link, content, title_de, link_de, content_de, title_ru, link_ru, content_ru = "";
	
	private DBQuery query;
	
	// Initialize page from DB using id.
	public Page(int id)
	{		
		this.id = id;
		this.query = new DBQuery();
		this.slug = query.getSlugByID(id);
		this.query.closeConnection();
	}		
	
	
	public Page(int id, String slug, String title, String link, String content,
			String title_de, String link_de, String content_de,
			String title_ru, String link_ru, String content_ru) {
		super();
		this.id = id;
		this.slug = slug;
		this.title = title;
		this.link = link;
		this.content = content;
		this.title_de = title_de;
		this.link_de = link_de;
		this.content_de = content_de;
		this.title_ru = title_ru;
		this.link_ru = link_ru;
		this.content_ru = content_ru;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

}
