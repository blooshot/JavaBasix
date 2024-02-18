package org.basix.mytube;

public class VideoProcessor {

    private VideoEncoder encoder;
    private VideoDatabase database;
    public VideoProcessor(VideoEncoder encoder, VideoDatabase database) {
        this.encoder = encoder;
        this.database = database;
    }
    public void process(Video video){
        encoder.encode(video);
        database.store(video);

        var emailService = new NotificationService();
        emailService.notify(video.getUser());
    }
}
