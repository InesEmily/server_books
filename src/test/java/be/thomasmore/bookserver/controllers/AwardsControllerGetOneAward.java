package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("SpringTestingSqlInspection")
@Sql("/sql/awards/create_2_awards.sql")
@Sql(scripts = "/sql/awards/clean_awards.sql", executionPhase = AFTER_TEST_METHOD)
public class AwardsControllerGetOneAward extends AbstractIntegrationTest {

    @Test
    public void getOneAward() throws Exception {
        mockMvc.perform(getMockRequestGetAwards("/api/awards/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Pullitzer Prize"));

    }

    @Test
    public void getOneAwardNotFound() throws Exception {
        final MvcResult mvcResult =
                mockMvc.perform(getMockRequestGetAwards("/api/awards/9999"))
                        .andExpect(status().isInternalServerError()) // strange!!! I expected isNotFound().....??????
                        .andReturn();
        assertThat(mvcResult.getResponse().getErrorMessage()).isEqualTo("Award with id 9999 does not exist.");

    }

}
