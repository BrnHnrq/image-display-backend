package com.brn.imagetest.service;

import com.brn.imagetest.entity.Image;
import com.brn.imagetest.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image getImage(int id) {
        Optional<Image> op = imageRepository.findById(id);
        return op.orElseGet(op::orElseThrow);
    }

    @Override
    public List<Image> getImages(){
        return imageRepository.findAll();
    }

    @Override
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(int id) {
        Optional<Image> op = imageRepository.findById(id);
        imageRepository.delete(op.orElseGet(op::orElseThrow));
    }


}
