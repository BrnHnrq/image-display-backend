package com.brn.imagetest.service;

import com.brn.imagetest.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageService{
    Image getImage(int id);
    List<Image> getImages();
    void saveImage(Image image);
    void deleteImage(int id);
}
