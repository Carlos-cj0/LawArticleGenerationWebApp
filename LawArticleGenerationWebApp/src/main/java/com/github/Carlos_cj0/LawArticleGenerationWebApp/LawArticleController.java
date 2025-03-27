package com.github.Carlos_cj0.LawArticleGenerationWebApp;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller // Use @Controller to serve non-REST content (like file downloads)
@RequestMapping("/api/law")
public class LawArticleController {

    @Value("${law.article.path}")
    private Resource lawArticleResource;

    @GetMapping("/article")
    public ResponseEntity<Resource> getLawArticle() throws IOException {
        if (!lawArticleResource.exists() || !lawArticleResource.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF); // Adjust based on your file type
        headers.setContentDisposition(
        	    ContentDisposition.inline()
        	        .filename(lawArticleResource.getFilename())
        	        .build()
        	);

        return ResponseEntity.ok()
                .headers(headers)
                .body(lawArticleResource);
    }
}
