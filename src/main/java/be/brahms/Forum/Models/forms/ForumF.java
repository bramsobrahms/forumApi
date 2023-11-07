package be.brahms.Forum.Models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ForumF(
        @NotNull
        String message,
        @NotBlank
        LocalDate createAt
        ) {

}
