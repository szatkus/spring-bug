package asd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Base64;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(C.class)
public class CTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void a() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/").contentType("application/x-www-form-urlencoded").content("fff=aaa%2Abbb"))
                .andReturn();
        String content = new String(Base64.getDecoder().decode(result.getResponse().getContentAsString()));
        assertEquals("fff=aaa%2Abbb", content);
    }
}