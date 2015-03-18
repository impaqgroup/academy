package com.impaqgroup.academy;

import com.impaqgroup.academy.greet.GreetingController;
import com.impaqgroup.academy.greet.GreetingRepository;
import com.impaqgroup.academy.greet.GreetingService;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by impaq on 18.03.15.
 */
public class GreetingControllerTest {

    GreetingRepository repository = mock(GreetingRepository.class);

    GreetingService service = new GreetingService(repository);

    GreetingController controller = new GreetingController(service);

    MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void greetsMe() throws Exception{
        mvc.perform(get("/?name=Academy"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("message").value("Hello Academy!"));
    }

}
