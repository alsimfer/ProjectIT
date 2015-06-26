package objects;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.UtilFunctions.*;
import daoimpl.NavigationDB;
import db.*;

public class Page implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Page.class.getName());
	
	private int id;
	private String slug, title, link, content, title_en, link_en, content_en, title_de, link_de, content_de, title_ru, link_ru, content_ru;
	
	private NavigationDB navigationDB;
	
	// Initialize page from DB using id.
	public Page()
	{	
		
	}	
	
	public Page(int id)
	{		
		this.id = id;
		this.navigationDB = new NavigationDB();
		this.slug = navigationDB.getSlugById(id);
	}			
	
	public Page(int id, String slug, String title_en, String link_en, String content_en,
			String title_de, String link_de, String content_de,
			String title_ru, String link_ru, String content_ru) {
		super();
		this.id = id;
		this.slug = slug;
		this.title_en = title_en;
		this.link_en = link_en;
		this.content_en = content_en;
		this.title_de = title_de;
		this.link_de = link_de;
		this.content_de = content_de;
		this.title_ru = title_ru;
		this.link_ru = link_ru;
		this.content_ru = content_ru;
		// Per default set locale en. Depending on locale the object returns correct words.
		this.title = title_en;
		this.link = link_en;
		this.content = content_en;
	}

	// With this function we get correct page language.
	public void setLanguage(String language) {
		log.log(Level.FINE, "language was set to " + language);
		if (language.equals("german") == true) {
			this.title = title_de;
			this.link = link_de;
			this.content = content_de;
		} else if (language.equals("russian") == true) {
			this.title = title_ru;
			this.link = link_ru;
			this.content = content_ru;
		} else {
			this.title = title_en;
			this.link = link_en;
			this.content = content_en;
		}
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", slug=" + slug + ", title=" + title
				+ ", link=" + link + ", content=" + content + ", title_en="
				+ title_en + ", link_en=" + link_en + ", content_en="
				+ content_en + ", title_de=" + title_de + ", link_de="
				+ link_de + ", content_de=" + content_de + ", title_ru="
				+ title_ru + ", link_ru=" + link_ru + ", content_ru="
				+ content_ru + "]";
	}

}
