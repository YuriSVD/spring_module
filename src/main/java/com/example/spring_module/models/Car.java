package com.example.spring_module.models;

import com.example.spring_module.models.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Car {
    @Id
    private String id;
    @NotBlank(message = "name is required")
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String model;
    @NotBlank(message = "producer is required")
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String producer;
    @NotNull(message = "power is required")
    @Min(value = 100, message = "min value of power - 100")
    @Max(value = 1000, message = "max value of power - 1000")
    @JsonView({Views.Level1.class, Views.Level2.class})
    private int power;

    private String picture;

    public Car(String model, String producer, int power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }

    public Car(String model, String producer, int power, String picture) {
        this.model = model;
        this.producer = producer;
        this.power = power;
        this.picture = picture;
    }
}