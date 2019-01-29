/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_4;

/**
 *
 * @author 1elmasriahm
 */
public class Book {
    
    //CLASS CONSTANTS
    final static String[] GENRE = {"Fiction", "Non-Fiction","Action","Adventure",
        "Romance","Teen","Mystery","Self-Help"};
    final static String PUBLISHER = "GWPC";
    
    //OBJECT VARIABLES
    private int pageCount;
    private String author;
    private String title;//OR
    private String[] authors;
    private int edition;
    private boolean read;
    private long id;
    private int genreID;

    public Book(String title, String[] authors, int edition) {
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

   

    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", title=" + title + ", edition=" + edition + ", id=" + id + '}';
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        if (genreID < 0 || genreID > GENRE.length) {
            this.genreID = 0;
        }else{
            this.genreID = genreID;
        }
        
    }
    
    public String getGenre(){
        return GENRE[genreID];
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
    
    
        
        
    

    

    
    
    
}
