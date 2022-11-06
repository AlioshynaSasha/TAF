package models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Milestone {
    private int id;
    private String name;
    private String references;
    private String descriptions;
    private boolean completed;
}
