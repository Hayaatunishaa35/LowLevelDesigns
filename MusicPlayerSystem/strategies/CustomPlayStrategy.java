package strategies;

import models.Playlist;
import models.Song;

public class CustomPlayStrategy implements PlayStrategy {
    
    Node currentSong;

    @Override
    public void setPlaylist(Playlist playlist) {
        if(playlist.getSongs().size()==0){
            throw new RuntimeException("Playlist is empty.");
        }

        Node head = new Node(playlist.getSongs().get(0));
        Node curr = head;

        for(int i = 1;i<playlist.getSongs().size();i++){
            Node temp = new Node(playlist.getSongs().get(i));
            curr.next = temp;
            temp.prev = curr;
            curr = curr.next;

            // circular playlist
            if(i==playlist.getSongs().size()-1){
                curr.next = head;
                head.prev = curr;
            }
        }

        currentSong = head;

    }

    @Override
    public Song playNext() {
        if(currentSong==null){
            throw new RuntimeException("Choose a playlist");
        }
        currentSong = currentSong.next;
        return currentSong.song;
    }

    @Override
    public Song playPrevious() {
        if(currentSong==null){
            throw new RuntimeException("Choose a playlist");
        }
        currentSong = currentSong.prev;
        return currentSong.song;
    }

    @Override
    public void addToQueue(Song song){
        if(currentSong==null){
            throw new RuntimeException("Choose a playlist");
        }
        Node temp = new Node(song);
        temp.next = currentSong.next;
        currentSong.next.prev = temp;
        currentSong.next = temp;
        temp.prev = currentSong;
    }
}

class Node{
    Song song;
    Node next;
    Node prev;

    public Node(Song song){
        this.song = song;
        this.next = null;
        this.prev = null;
    }
}
