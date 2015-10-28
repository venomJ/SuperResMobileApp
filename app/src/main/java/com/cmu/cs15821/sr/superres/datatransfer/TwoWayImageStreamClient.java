package com.cmu.cs15821.sr.superres.datatransfer;

/**
 * Created by cem on 10/27/2015.
 */
public interface TwoWayImageStreamClient {

    public void setup(String IP, int port);
    public void sendImage(byte[] imageBytes);
    public byte[] receiveImage();

}
