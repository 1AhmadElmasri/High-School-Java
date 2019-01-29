/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author 1elmasriahm
 */
public class Database {

    private RandomAccessFile recordFile;
    private boolean open;
    private String fileName;

    public Database() {
        this.open = false;
    }

    public Database(String fileName) throws FileNotFoundException {
        this();
        this.openFile(fileName);
    }

    public void writeRecord(Album record) throws IOException {
        this.recordFile.seek(this.recordFile.length());
        this.recordFile.writeChars(record.getAlbumTitle());
        this.recordFile.writeChars(record.getArtistName());
        this.recordFile.writeInt(record.getRecordSales());
        this.recordFile.writeInt(record.getTrackNumber());
        this.recordFile.writeInt(record.getAlbumNumber());
        this.recordFile.writeDouble(record.getScore());
        this.recordFile.writeChar(record.getAlbumGenre());
        this.recordFile.writeBoolean(record.isPlatinum());
    }

    public String getFileName() {
        if (this.open) {
            return fileName;
        }else{
            System.out.println("File Not Opened Yet");
            return "NO NAME";
        }
        
    }

    public void updateRecord(Album record, long databaseID) throws IOException {

        long position = (databaseID - 1) * Album.RECORD_SIZE;
        if (position % Album.RECORD_SIZE == 0 && position < this.recordFile.length() && position > 0) {
            this.recordFile.seek(position);
            this.recordFile.writeChars(record.getAlbumTitle());
            this.recordFile.writeChars(record.getArtistName());
            this.recordFile.writeInt(record.getRecordSales());
            this.recordFile.writeInt(record.getTrackNumber());
            this.recordFile.writeInt(record.getAlbumNumber());
            this.recordFile.writeDouble(record.getScore());
            this.recordFile.writeChar(record.getAlbumGenre());
            this.recordFile.writeBoolean(record.isPlatinum());
        }else{
            System.out.println("Invalid database Id");
        }

    }

    public Album getRecord(long databaseID) throws IOException {
        Album temp = new Album();
        long position = (databaseID - 1) * Album.RECORD_SIZE;
        if (position % Album.RECORD_SIZE == 0 && position < this.recordFile.length() && position > 0) {
            temp = new Album();

            this.recordFile.seek(position);

            char[] albumName = new char[Album.STRING_LENGTH];
            for (int i = 0; i < Album.STRING_LENGTH; i++) {
                albumName[i] = this.recordFile.readChar();
            }
            temp.setAlbumTitle(new String(albumName));

            char[] artistName = new char[Album.STRING_LENGTH];
            for (int i = 0; i < Album.STRING_LENGTH; i++) {
                artistName[i] = this.recordFile.readChar();
            }
            temp.setArtistName(new String(artistName));

            temp.setRecordSales(this.recordFile.readInt());

            temp.setTrackNumber(this.recordFile.readInt());

            temp.setAlbumNumber(this.recordFile.readInt());

            temp.setScore(this.recordFile.readDouble());

            temp.setAlbumGenre(this.recordFile.readChar());

            temp.setPlatinum(this.recordFile.readBoolean());

        } else {
            System.out.println("Invalid Position");
        }

        return temp;
    }

    public RandomAccessFile openFile(String fileName) throws FileNotFoundException {
        if (fileName == null) {
            System.out.println("Invalid input, try again");
            return null;
        } else {
            File fileChecker = new File(fileName);
            if (fileChecker.exists()) {
                System.out.println("\nOpening File : ");
                this.recordFile = new RandomAccessFile(fileName, "rw");
            } else {
                System.out.println("\nCreating File : ");
                this.recordFile = new RandomAccessFile(fileName, "rw");
            }
            this.fileName = fileName;
            this.open = true;
        }

        return this.recordFile;
    }
    
    public void clear() throws FileNotFoundException, IOException {
        if (this.open) {
            File clearF = new File(this.fileName);
            
            String path = clearF.getAbsolutePath();
            
            this.closeFile();
            
            Files.delete(Paths.get(path));
            
            this.recordFile = new RandomAccessFile(fileName, "rw");
        } else {
            System.out.println("Cannot Clear, No File Selected");
        }
    }

    public void closeFile() throws IOException {
        if (this.open) {
            this.recordFile.close();
        } else {
            System.out.println("Cannot Close, File Already Closed");
        }

    }
    
    
}
