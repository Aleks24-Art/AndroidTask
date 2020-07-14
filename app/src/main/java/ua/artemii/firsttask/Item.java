package ua.artemii.firsttask;

import android.widget.ImageView;
import android.widget.TextView;

public class Item {

    ImageView imageView;
    String title;
    String description;

    public Item(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
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
}
