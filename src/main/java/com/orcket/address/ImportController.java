package com.orcket.address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import")
public class ImportController {

  private final UserRepository repository;

  public ImportController(UserRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void importUsers(@RequestParam MultipartFile file) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
      br.lines()
          .skip(1)
          .map(rawString -> rawString.split(","))
          .filter(cols -> cols.length == 8)
          .map(User::new)
          .forEach(repository::save);
    }
  }
}
