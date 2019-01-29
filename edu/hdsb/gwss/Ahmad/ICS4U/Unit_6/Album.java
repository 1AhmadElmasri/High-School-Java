/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_6;

import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author ahmad
 */
public class Album {
    private String albumTitle; // 15 Characters
    private String artistName; // 15 Characters 
    private int recordSales; 
    private int trackNumber;
    private int albumID;
    private int albumNumber;
    private double score; //An Out of 5 Rating
    private char albumGenre;
    private boolean platinum;
    
    protected static final int STRING_LENGTH = 15;
    protected static final int RECORD_SIZE = 83;//Unknown if it would be 82 or 83, since a boolean only takes one bit


    
    public Album(String albumTitle, String artistName, int recordSales, int trackNumber, int albumNumber, double score, char albumGenre, boolean platinum) {
        this.setAlbumTitle(albumTitle);
        this.setArtistName(artistName);
        this.recordSales = recordSales;
        this.trackNumber = trackNumber;
        this.albumNumber = albumNumber;
        this.score = score;
        this.albumGenre = albumGenre;
        this.platinum = platinum;
    }

    public Album() {
        this.setAlbumTitle(null);
        this.setArtistName(null);
        this.recordSales = -1;
        this.trackNumber = -1;
        this.albumNumber = -1;
        this.score = -1;
        this.albumGenre = '0';
        this.platinum = false;
    }
    
    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        StringBuilder temp = new StringBuilder();
        if (albumTitle != null) {
            temp.append(albumTitle.trim().toUpperCase());
        }else{
            temp.append("TBD");//
        }
        
        temp.setLength(STRING_LENGTH);
        this.albumTitle = temp.toString();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        StringBuilder temp = new StringBuilder();
        if (artistName != null) {
            temp.append(artistName.trim().toUpperCase());
        }else{
            temp.append("TBD");
        }
        
        temp.setLength(STRING_LENGTH);
        this.artistName = temp.toString();
    }

    public int getRecordSales() {
        return recordSales;
    }

    public void setRecordSales(int recordSales) {
        if (recordSales >= 0) {
            this.recordSales = recordSales;
        }else{
            System.out.println("Invalid Record Sales, Try Again");
        }
        
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        if (trackNumber > 0) {
            this.trackNumber = trackNumber;
        }else{
            System.out.println("Invalid Track Amount, Try Again");
        }
    }

    public int getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(int albumNumber) {
        if (albumNumber > 0) {
            this.albumNumber = albumNumber;
        }else{
            System.out.println("Invalid Album Number, Try Again");
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0) {
            this.score = score;
        }else{
            System.out.println("Invalid Score, Try Again");
        }
    }

    public char getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(char albumGenre) {
        this.albumGenre = albumGenre;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }
    
    protected int getAlbumID() {
        return albumID;
    }

    protected void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    @Override
    public String toString() {
            return "Album{" + "albumTitle=" + albumTitle + ", artistName=" + this.artistName + ", recordSales=" + recordSales + ", trackNumber=" + trackNumber + ", albumNumber=" + albumNumber + ", score=" + score + ", albumGenre=" + albumGenre + ", platinum=" + platinum + '}';
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.recordSales != other.recordSales) {
            return false;
        }
        if (this.trackNumber != other.trackNumber) {
            return false;
        }
        if (this.albumNumber != other.albumNumber) {
            return false;
        }
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (this.albumGenre != other.albumGenre) {
            return false;
        }
        if (this.platinum != other.platinum) {
            return false;
        }
        if (!Objects.equals(this.albumTitle, other.albumTitle)) {
            return false;
        }
        if (!Objects.equals(this.artistName, other.artistName)) {
            return false;
        }
        return true;
    }
    
    public boolean isValid(){
        if (this.albumTitle.equals("TBD")) {
            return false;
        }
        
        if (this.artistName.equals("TBD")) {
            return false;
        }
        
        if (this.albumNumber < 0 || this.recordSales <= 0 || this.trackNumber < 0
                || this.score <= 0) {
            return false;
        }
        int charValue = Character.getNumericValue(this.albumGenre);
        
        if (!(charValue > 101 & charValue < 132) || !(charValue > 141 & charValue < 172)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
    
}
