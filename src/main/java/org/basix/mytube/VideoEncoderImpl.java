package org.basix.mytube;

public class VideoEncoderImpl implements VideoEncoder {
    @Override
    public void encode(Video video){
        System.out.println("Encoding Video...");
        System.out.println("Done");
    }
}
