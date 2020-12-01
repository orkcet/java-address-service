package com.orcket.address;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

  private final MockMvc mockMvc;

  @Autowired
  public ApplicationTests(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  public void importTest() throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream input = classLoader.getResourceAsStream("MOCK_DATA.csv");
    MockMultipartFile file = new MockMultipartFile("file", input);

    mockMvc.perform(multipart("/import").file(file))
        .andExpect(status().isAccepted());
  }

}
