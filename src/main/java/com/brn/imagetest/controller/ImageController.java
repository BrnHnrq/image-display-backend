package com.brn.imagetest.controller;

import com.brn.imagetest.entity.Image;
import com.brn.imagetest.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping("/{id}")
    public Image getImage(@PathVariable int id){
        return imageService.getImage(id);
    }

    @GetMapping
    public List<Image> getImages(){
        return imageService.getImages();
    }


    @PostMapping
    public void postImage(@RequestParam("file") MultipartFile file) throws IOException {
        Image image =  new Image();
        Random rnd = new Random();

        //Add a random number in front of the file name to make it unique for the frontend
        String imageName = rnd.nextInt(50000) + file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        Path path = Paths.get("C:\\Users\\podon\\Documents\\Projetos\\React\\image-test\\image-test\\public\\image\\" + imageName);
        Files.write(path, bytes);

        image.setFileName(imageName);

        imageService.saveImage(image);
    }
}
