package com.foods.wholefood;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@JsonDeserialize(builder = AppInfo.AppInfoBuilder.class)
@Builder(builderClassName = "AppInfoBuilder", toBuilder = true)
public class AppInfo {

    private LocalDateTime startTime;
    @Singular
    private Map<String, String> parameters;

        @JsonPOJOBuilder(withPrefix = "")
        public static class AppInfoBuilder {
        }

}
