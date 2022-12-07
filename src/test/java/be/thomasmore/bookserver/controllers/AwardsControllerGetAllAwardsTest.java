package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("/sql/awards/create_2_awards.sql")
@Sql(scripts = "/sql/awards/clean_awards.sql", executionPhase = AFTER_TEST_METHOD)
public class AwardsControllerGetAllAwardsTest extends AbstractIntegrationTest {

    @Test
    public void getAllAwards() throws Exception {
        mockMvc.perform(getMockRequestGetAwards("/api/awards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Pullitzer Prize"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Booker Prize"));

    }



}
