package org.basix.mytube;

public class VideoDatabaseImpl implements VideoDatabase {
    @Override
    public void store(Video video){
        System.out.println("Storing video in database...");
        System.out.println("Done");
    }
}
