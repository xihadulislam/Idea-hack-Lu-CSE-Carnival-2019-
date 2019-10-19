package teamx.ideahacks.Models;

public class PostModel {


    String title,description,imgaeurl,userID,id,status;
    long create_at;
    String upvote,downvote;

    public PostModel() {
    }

    public PostModel(String title, String description, String imgaeurl, String userID, String id, String status, long create_at, String upvote, String downvote) {
        this.title = title;
        this.description = description;
        this.imgaeurl = imgaeurl;
        this.userID = userID;
        this.id = id;
        this.status = status;
        this.create_at = create_at;
        this.upvote = upvote;
        this.downvote = downvote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgaeurl() {
        return imgaeurl;
    }

    public void setImgaeurl(String imgaeurl) {
        this.imgaeurl = imgaeurl;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public String getUpvote() {
        return upvote;
    }

    public void setUpvote(String upvote) {
        this.upvote = upvote;
    }

    public String getDownvote() {
        return downvote;
    }

    public void setDownvote(String downvote) {
        this.downvote = downvote;
    }
}
